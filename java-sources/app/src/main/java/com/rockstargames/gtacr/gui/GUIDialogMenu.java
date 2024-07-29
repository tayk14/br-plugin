package com.rockstargames.gtacr.gui;

import android.graphics.Typeface;
import android.os.Handler;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.adapters.DialogMenuAdapter;
import com.rockstargames.gtacr.data.DataDialogMenu;
import java.util.ArrayList;
import org.json.JSONObject;

public class GUIDialogMenu implements ISAMPGUI {
    private boolean closed;
    private GUIManager mGUIManager;
    private View mRootView;
    private TextView menuTitle;
    Typeface typeface;
    private final ArrayList<DataDialogMenu> dataDialogMenuArrayList = new ArrayList<>();
    private int index = -1;
    private PopupWindow mWindow = null;
    private NvEventQueueActivity mContext = null;
    private Animation anim = null;

    @Override
    public int getGuiId() {
        return 14;
    }

    @Override
    public void onPacketIncoming(JSONObject json) {
    }

    public static ISAMPGUI newInstance() {
        return new GUIDialogMenu();
    }

    private void setMenu() {
        this.dataDialogMenuArrayList.clear();
        this.dataDialogMenuArrayList.add(new DataDialogMenu(0, R.drawable.br_menu_compass, "Навигатор"));
        this.dataDialogMenuArrayList.add(new DataDialogMenu(1, R.drawable.br_menu_taxi, "Вызов такси"));
        this.dataDialogMenuArrayList.add(new DataDialogMenu(2, R.drawable.br_menu_menu, "Меню"));
        this.dataDialogMenuArrayList.add(new DataDialogMenu(3, R.drawable.br_menu_chat, "Общение"));
        this.dataDialogMenuArrayList.add(new DataDialogMenu(4, R.drawable.br_menu_bag, "Инвентарь"));
        this.dataDialogMenuArrayList.add(new DataDialogMenu(5, R.drawable.br_menu_anim, "Анимации"));
        this.dataDialogMenuArrayList.add(new DataDialogMenu(6, R.drawable.br_menu_ruble, "Донат"));
        this.dataDialogMenuArrayList.add(new DataDialogMenu(7, R.drawable.br_menu_car, "Автомобили"));
    }

    private void setDialogMenu() {
        this.dataDialogMenuArrayList.clear();
        this.dataDialogMenuArrayList.add(new DataDialogMenu(8, R.drawable.menu_passport, "Передать паспорт"));
        this.dataDialogMenuArrayList.add(new DataDialogMenu(9, R.drawable.menu_med, "Передать мед.карту"));
        this.dataDialogMenuArrayList.add(new DataDialogMenu(10, R.drawable.menu_paper, "Передать лицензии"));
        this.dataDialogMenuArrayList.add(new DataDialogMenu(11, R.drawable.menu_lic, "Передать ПТС"));
        this.dataDialogMenuArrayList.add(new DataDialogMenu(12, R.drawable.menu_exchange, "Совершить обмен"));
        this.dataDialogMenuArrayList.add(new DataDialogMenu(13, R.drawable.menu_back, "Назад"));
    }

    public void putJSONObject(int getIndex) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", getIndex);
            this.mGUIManager.sendJsonData(14, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.closed = false;
        close(null);
    }

    private void setDataInRecyclerView(DialogMenuAdapter.OnUserClickListener getOnUserClickListener, ArrayList<DataDialogMenu> dataDialogMenuArrayList, RecyclerView recyclerView, final View getView, int columnValue) {
        DialogMenuAdapter dialogMenuAdapter = new DialogMenuAdapter(dataDialogMenuArrayList, getOnUserClickListener);
        recyclerView.setLayoutManager(new GridLayoutManager(getView.getContext(), columnValue) {
            @Override
            public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                float f = 30.0f / getView.getResources().getDisplayMetrics().density;
                int i = (int) f;
                lp.setMarginStart(i);
                lp.setMarginEnd(i);
                lp.setMargins(0, i, 0, 0);
                lp.width = (int) ((getWidth() / getSpanCount()) - f);
                return true;
            }
        });
        recyclerView.setAdapter(dialogMenuAdapter);
    }

    public void Update(boolean IsChat) {
        RecyclerView recyclerView = (RecyclerView) this.mRootView.findViewById(R.id.br_rec_view_menu);
        if (this.index == -1) {
            TransitionManager.beginDelayedTransition(recyclerView);
        }
        this.index = -1;
        this.menuTitle = (TextView) this.mRootView.findViewById(R.id.br_menu_title);
        if (!IsChat) {
            setMenu();
            this.menuTitle.setText(R.string.menu_action_title_actions);
            setDataInRecyclerView(new DialogMenuAdapter.OnUserClickListener() {
                @Override
                public void click(DataDialogMenu dataDialogMenu, View view) {
                    GUIDialogMenu.this.index = dataDialogMenu.getId();
                    view.startAnimation(GUIDialogMenu.this.anim);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (GUIDialogMenu.this.index == 3) {
                                GUIDialogMenu.this.Update(true);
                            } else {
                                GUIDialogMenu.this.putJSONObject(GUIDialogMenu.this.index);
                            }
                        }
                    }, 300L);
                }
            }, this.dataDialogMenuArrayList, recyclerView, this.mRootView, 4);
            return;
        }
        setDialogMenu();
        this.menuTitle.setText(R.string.menu_action_title_communication);
        setDataInRecyclerView(new DialogMenuAdapter.OnUserClickListener() {
            @Override
            public void click(DataDialogMenu dataDialogMenu, View view) {
                GUIDialogMenu.this.index = dataDialogMenu.getId();
                view.startAnimation(GUIDialogMenu.this.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (GUIDialogMenu.this.index == 13) {
                            GUIDialogMenu.this.Update(false);
                        } else {
                            GUIDialogMenu.this.putJSONObject(GUIDialogMenu.this.index);
                        }
                    }
                }, 300L);
            }
        }, this.dataDialogMenuArrayList, recyclerView, this.mRootView, 3);
    }

    @Override
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mContext = activity;
        this.mGUIManager = manager;
        if (this.mWindow == null) {
            this.mRootView = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.menu_action_dialog, (ViewGroup) null, false);
            PopupWindow popupWindow = new PopupWindow(this.mRootView, -1, -1, true);
            this.mWindow = popupWindow;
            popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mWindow.setSoftInputMode(16);
            this.mGUIManager.setCustomTouchInterceptor(this.mWindow);
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    if (GUIDialogMenu.this.closed) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("t", -1);
                            jSONObject.put("i", 1);
                            GUIDialogMenu.this.mGUIManager.sendJsonData(14, jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    //GUIDialogMenu.this.mContext.setDraw2dStuff();
                    GUIDialogMenu.this.mGUIManager.closeGUI(null, 14);
                }
            });
            this.mContext = activity;
            this.mRootView.findViewById(R.id.br_menu_close_new).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GUIDialogMenu.this.close(null);
                }
            });
            this.mRootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    GUIDialogMenu.this.mWindow.dismiss();
                }
            });
            this.anim = AnimationUtils.loadAnimation(this.mContext, R.anim.button_click);
            this.typeface = Typeface.createFromAsset(this.mContext.getAssets(), "Fonts/muller_bold.ttf");
        }
        Update(false);
        this.closed = true;
        this.mWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
        GUIManager.hideSystemUI(this.mWindow.getContentView());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", -1);
            jSONObject.put("i", 0);
            this.mGUIManager.sendJsonData(14, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close(JSONObject json) {
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }
}
