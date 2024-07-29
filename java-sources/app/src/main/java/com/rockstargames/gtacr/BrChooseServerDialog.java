package com.rockstargames.gtacr;

import android.animation.Animator;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import blackrussia.online.R;
import blackrussia.online.network.DataService;
import blackrussia.online.network.Server;
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.common.GUIPopupWindow;
import java.util.ArrayList;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes2.dex */
public class BrChooseServerDialog implements ISAMPGUI {
    private static ArrayList<Server> mServers;
    private GUIManager mGUIManager;
    private NvEventQueueActivity mContext = null;
    private int mType = 0;
    private View mRootViewLoading = null;
    private View mRootViewChoose = null;
    private TextView mProgress = null;
    private Handler mHandler = new Handler();
    private PopupWindow mWindow = null;
    private View mRootView = null;
    private boolean mHasInitializedUI = false;
    private boolean mSwitchAfterInitializtion = false;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 11;
    }

    public static ISAMPGUI newInstance() {
        return new BrChooseServerDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initServers() {
        DataService.getInstance().getApiService().getServers().enqueue(new Callback<ArrayList<Server>>() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.1
            @Override // retrofit2.Callback
            public void onResponse(Call<ArrayList<Server>> call, Response<ArrayList<Server>> response) {
                if (response.body() != null) {
                    if (BrChooseServerDialog.mServers == null) {
                        ArrayList unused = BrChooseServerDialog.mServers = new ArrayList();
                    }
                    BrChooseServerDialog.mServers.clear();
                    BrChooseServerDialog.mServers.addAll(response.body());
                    BrChooseServerDialog.this.mContext.runOnUiThread(new Runnable() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BrChooseServerDialog.this.initUI();
                        }
                    });
                }
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ArrayList<Server>> call, Throwable t) {
                BrChooseServerDialog.this.mHandler.postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        BrChooseServerDialog.this.initServers();
                    }
                }, 500L);
            }
        });
    }

    public static void setServers(ArrayList<Server> servers) {
        if (servers == null) {
            return;
        }
        mServers = servers;
    }

    public static ArrayList<Server> getServers() {
        return mServers;
    }

    private void processMyServer(View view) {
        if (this.mType >= mServers.size()) {
            this.mType = 0;
        }
        if (mServers.get(this.mType).getFirstName().contains("test")) {
            ((TextView) view.findViewById(R.id.br_server_name)).setText(mServers.get(this.mType).getFirstName());
            return;
        }
        ((TextView) view.findViewById(R.id.br_server_name)).setText(mServers.get(this.mType).getFirstName());
        View findViewById = view.findViewById(R.id.server_list_back_color);
        RoundCornerProgressBar roundCornerProgressBar = (RoundCornerProgressBar) view.findViewById(R.id.br_server_progress);
        ImageView imageView = (ImageView) view.findViewById(R.id.br_server_image);
        findViewById.getBackground().setColorFilter(Color.parseColor("#" + mServers.get(this.mType).getColor()), PorterDuff.Mode.SRC_ATOP);
        roundCornerProgressBar.setProgressColor(Color.parseColor("#" + mServers.get(this.mType).getColor()));
        roundCornerProgressBar.setProgress((float) ((int) ((Double.parseDouble(mServers.get(this.mType).getOnline()) / Double.parseDouble(mServers.get(this.mType).getMaxonline())) * 100.0d)));
        imageView.setColorFilter(Color.parseColor("#" + mServers.get(this.mType).getColor()), PorterDuff.Mode.SRC_ATOP);
        view.findViewById(R.id.br_server_x2).setVisibility(mServers.get(this.mType).getX2() ? 0 : 8);
        ((TextView) view.findViewById(R.id.br_server_online)).setText(Html.fromHtml(mServers.get(this.mType).getOnline() + "<font color='#808080'>/" + mServers.get(this.mType).getMaxonline()));
    }

    private void addTestServers() {
        if (mServers == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initUI() {
        View view = this.mRootView;
        this.mType = 2;
        addTestServers();
        this.mRootViewLoading = view.findViewById(R.id.choose_server_root_loading);
        this.mRootViewChoose = view.findViewById(R.id.choose_server_root_choose);
        GUIManager.hideSystemUI(this.mContext.getWindow());
        this.mContext.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.2
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i) {
                if ((i & 4) == 0) {
                    GUIManager.hideSystemUI(BrChooseServerDialog.this.mContext.getWindow());
                }
            }
        });
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.scroll_layout_servers);
        linearLayout.setScrollbarFadingEnabled(false);
        int i = 4;
        int i2 = 1;
        int size = (mServers.size() / 4) + 1;
        this.mProgress = (TextView) view.findViewById(R.id.br_ls_progress);
        final Button button = (Button) view.findViewById(R.id.servers_btn_my_server);
        final Button button2 = (Button) view.findViewById(R.id.all_servers_button);
        Button button3 = (Button) view.findViewById(R.id.br_servers_play);
        view.findViewById(R.id.server_main_frame).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(BrChooseServerDialog.this.mContext, R.anim.button_click));
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(BrChooseServerDialog.this.mContext, R.anim.button_click));
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("b", BrChooseServerDialog.this.mType);
                    BrChooseServerDialog.this.mContext.setCurrServer(BrChooseServerDialog.this.mType);
                    BrChooseServerDialog.this.mGUIManager.sendJsonData(11, jSONObject);
                    BrChooseServerDialog.this.mGUIManager.closeGUI(null, 11);
                } catch (Exception unused) {
                }
            }
        });
        final View findViewById = view.findViewById(R.id.main_servers_choose);
        final View findViewById2 = view.findViewById(R.id.list_servers_choose);
        int i3 = -1;
        if (this.mType != -1) {
            findViewById2.setAlpha(0.0f);
            findViewById2.setVisibility(8);
            findViewById.setVisibility(0);
        } else {
            findViewById.setAlpha(0.0f);
            findViewById.setVisibility(8);
            findViewById2.setVisibility(0);
            button2.setVisibility(8);
            button.setVisibility(8);
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(BrChooseServerDialog.this.mContext, R.anim.button_click));
                v.setBackground(ResourcesCompat.getDrawable(BrChooseServerDialog.this.mContext.getResources(), R.drawable.button_red_rectangle, null));
                button2.setBackground(ResourcesCompat.getDrawable(BrChooseServerDialog.this.mContext.getResources(), R.drawable.button_br_red_unfilled_ss, null));
                if (findViewById.getVisibility() != 0) {
                    findViewById2.animate().alpha(0.0f).setDuration(100L).setListener(new Animator.AnimatorListener() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.5.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animation) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animation) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            findViewById2.setAlpha(0.0f);
                            findViewById2.setVisibility(8);
                            findViewById.setVisibility(0);
                            findViewById.setAlpha(0.0f);
                            findViewById.animate().alpha(1.0f).setDuration(100L).setListener(null).start();
                        }
                    }).start();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(BrChooseServerDialog.this.mContext, R.anim.button_click));
                v.setBackground(ResourcesCompat.getDrawable(BrChooseServerDialog.this.mContext.getResources(), R.drawable.button_red_rectangle, null));
                button.setBackground(ResourcesCompat.getDrawable(BrChooseServerDialog.this.mContext.getResources(), R.drawable.button_br_red_unfilled_ss, null));
                if (findViewById2.getVisibility() != 0) {
                    findViewById.animate().alpha(0.0f).setDuration(100L).setListener(new Animator.AnimatorListener() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.6.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animation) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animation) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            findViewById.setAlpha(0.0f);
                            findViewById.setVisibility(8);
                            findViewById2.setVisibility(0);
                            findViewById2.setAlpha(0.0f);
                            findViewById2.animate().alpha(1.0f).setDuration(100L).setListener(null).start();
                        }
                    }).start();
                }
            }
        });
        if (this.mType != -1) {
            processMyServer(view.findViewById(R.id.main_servers_choose));
        }
        int i4 = 0;
        while (i4 < size) {
            LinearLayout linearLayout2 = new LinearLayout(this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
            layoutParams.weight = i2 / size;
            if (i4 < size - 1) {
                layoutParams.setMargins(0, 0, 0, NvEventQueueActivity.dpToPx(12.0f, this.mContext));
            }
            linearLayout2.setLayoutParams(layoutParams);
            linearLayout2.setOrientation(0);
            int i5 = 0;
            while (i5 < i) {
                int i6 = (i4 * 4) + i5;
                if (i6 >= mServers.size()) {
                    break;
                }
                final int size2 = (mServers.size() - i6) - i2;
                View inflate = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.br_serverselect_server, (ViewGroup) null, false);
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        v.startAnimation(AnimationUtils.loadAnimation(BrChooseServerDialog.this.mContext, R.anim.button_click));
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("b", size2);
                            BrChooseServerDialog.this.mContext.setCurrServer(size2);
                            BrChooseServerDialog.this.mGUIManager.sendJsonData(11, jSONObject);
                            BrChooseServerDialog.this.mGUIManager.closeGUI(null, 11);
                        } catch (Exception unused) {
                        }
                    }
                });
                ((TextView) inflate.findViewById(R.id.br_server_name)).setText(mServers.get(size2).getFirstName());
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(NvEventQueueActivity.dpToPx(160.0f, this.mContext), NvEventQueueActivity.dpToPx(80.0f, this.mContext));
                layoutParams2.weight = 0.25f;
                if (i4 < 5) {
                    layoutParams2.setMargins(0, 0, NvEventQueueActivity.dpToPx(20.0f, this.mContext), 0);
                }
                inflate.setLayoutParams(layoutParams2);
                View findViewById3 = inflate.findViewById(R.id.server_list_back_color);
                RoundCornerProgressBar roundCornerProgressBar = (RoundCornerProgressBar) inflate.findViewById(R.id.br_server_progress);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.br_server_image);
                if (mServers.get(size2).getFirstName().contains("test")) {
                    linearLayout2.addView(inflate);
                } else {
                    findViewById3.getBackground().setColorFilter(Color.parseColor("#" + mServers.get(size2).getColor()), PorterDuff.Mode.SRC_ATOP);
                    roundCornerProgressBar.setProgressColor(Color.parseColor("#" + mServers.get(size2).getColor()));
                    inflate.findViewById(R.id.br_server_x2).setVisibility(mServers.get(size2).getX2() ? 0 : 8);
                    roundCornerProgressBar.setProgress((int) ((Double.parseDouble(mServers.get(size2).getOnline()) / Double.parseDouble(mServers.get(size2).getMaxonline())) * 100.0d));
                    imageView.setColorFilter(Color.parseColor("#" + mServers.get(size2).getColor()), PorterDuff.Mode.SRC_ATOP);
                    ((TextView) inflate.findViewById(R.id.br_server_online)).setText(Html.fromHtml(mServers.get(size2).getOnline() + "<font color='#808080'>/" + mServers.get(size2).getMaxonline()));
                    linearLayout2.addView(inflate);
                }
                i5++;
                i = 4;
                i2 = 1;
            }
            linearLayout.addView(linearLayout2);
            i4++;
            i = 4;
            i2 = 1;
            i3 = -1;
        }
        if (this.mSwitchAfterInitializtion) {
            this.mRootViewChoose.setVisibility(0);
            this.mRootViewChoose.setAlpha(0.0f);
            this.mRootViewLoading.setVisibility(8);
            this.mSwitchAfterInitializtion = false;
        }
        this.mHasInitializedUI = true;
    }

    private void setProgress(int progress) {
        if (progress >= 100) {
            progress = 99;
        }
        this.mProgress.setText(progress + "%");
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
        int i;
        try {
            i = json.getInt("t");
        } catch (Exception unused) {
            i = -1;
        }
        if (i == 0) {
            try {
                setProgress(json.getInt("s"));
            } catch (Exception unused2) {
            }
        } else {
            if (i != 1) {
                return;
            }
            if (!this.mHasInitializedUI) {
                this.mSwitchAfterInitializtion = true;
                return;
            }
            this.mRootViewChoose.setVisibility(0);
            this.mRootViewChoose.setAlpha(0.0f);
            this.mRootViewChoose.animate().setDuration(1500L).alpha(1.0f).setListener(new Animator.AnimatorListener() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.8
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    BrChooseServerDialog.this.mRootViewLoading.setVisibility(8);
                }
            }).start();
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, final NvEventQueueActivity activity) {
        this.mContext = activity;
        this.mGUIManager = manager;
        try {
            int i = json.getInt("s");
            this.mType = i;
            if (i >= mServers.size() || this.mType < 0) {
                this.mType = -1;
            }
        } catch (Exception unused) {
        }
        if (this.mWindow == null) {
            this.mRootView = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.br_serverselect, (ViewGroup) null, false);
            GUIPopupWindow gUIPopupWindow = new GUIPopupWindow(this.mRootView, -1, -1, false);
            this.mWindow = gUIPopupWindow;
            gUIPopupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mWindow.setSoftInputMode(16);
            this.mGUIManager.setCustomTouchInterceptor(this.mWindow);
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.9
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    BrChooseServerDialog.this.mGUIManager.closeGUI(null, 11);
                }
            });
            this.mContext = activity;
        }
        if (mServers == null) {
            initServers();
        } else {
            initUI();
        }
        this.mContext.getParentLayout().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BrChooseServerDialog.this.mWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
                    GUIManager.hideSystemUI(BrChooseServerDialog.this.mWindow.getContentView());
                } catch (Exception unused2) {
                    BrChooseServerDialog.this.mContext.getParentLayout().postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrChooseServerDialog.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BrChooseServerDialog.this.mWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
                            GUIManager.hideSystemUI(BrChooseServerDialog.this.mWindow.getContentView());
                        }
                    }, 1000L);
                }
            }
        }, 300L);
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
        this.mContext.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }
}
