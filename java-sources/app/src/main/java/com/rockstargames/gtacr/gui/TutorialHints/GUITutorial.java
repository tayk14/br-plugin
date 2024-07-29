package com.rockstargames.gtacr.gui.TutorialHints;

import android.os.Handler;
import android.os.SystemClock;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.adapters.TutorialAdapter;
import com.rockstargames.gtacr.common.GUIPopupWindow;
import com.rockstargames.gtacr.data.HintQuestData;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class GUITutorial implements ISAMPGUI {
    static final int HINT_TYPE_BOTTOM = 2;
    static final int HINT_TYPE_CALL = 3;
    static final int HINT_TYPE_DRIVING = 0;
    static final int HINT_TYPE_MES = 4;
    static final int HINT_TYPE_QUESTS_WITHOUT_ICON = 5;
    static final int HINT_TYPE_UNCLE = 1;
    private View blockView;
    private RecyclerView hintAdditionalQuests;
    private ImageView hintInstructor;
    private RecyclerView hintMainQuests;
    private TextView hintTextAdditionalTitle;
    private TextView hintTextIfWithoutAdditionalQuests;
    private TextView hintTextMainTitle;
    int hintType;
    private View hintUnderline;
    TextView textHint;
    private NvEventQueueActivity mActivity = null;
    private GUIManager mGUIManager = null;
    private GUIPopupWindow mWindow = null;
    private View mViewRoot = null;
    private TutorialAdapter mainQuestAdapter = null;
    private TutorialAdapter additionalQuestAdapter = null;
    private ArrayList<HintQuestData> mainQuest = new ArrayList<>();
    private ArrayList<HintQuestData> additionalQuests = new ArrayList<>();
    private Handler handler_ = null;
    private Runnable runnable_ = null;
    private boolean ifOpenWindow = false;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 39;
    }

    public static ISAMPGUI newInstance() {
        return new GUITutorial();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mGUIManager = manager;
        this.mActivity = activity;
        if (this.mWindow == null) {
            this.hintType = json.optInt("m", 0);
            LayoutInflater layoutInflater = (LayoutInflater) this.mActivity.getSystemService("layout_inflater");
            int i = R.layout.hint_driving_school;
            int i2 = this.hintType;
            if (i2 == 2) {
                i = R.layout.hint_bottom;
            }
            if (i2 == 3) {
                i = R.layout.uncle_call;
            }
            this.mViewRoot = layoutInflater.inflate(i, (ViewGroup) null, false);
            GUIPopupWindow gUIPopupWindow = new GUIPopupWindow(this.mViewRoot, -1, -1, true);
            this.mWindow = gUIPopupWindow;
            gUIPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.gui.TutorialHints.GUITutorial.1
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    GUITutorial.this.mGUIManager.notifyGUIClosed(GUITutorial.this.getGuiId(), null);
                    GUITutorial.this.mGUIManager.closeGUI(null, 39);
                }
            });
            this.mWindow.setAnimationStyle(R.style.PopupWindowAnimation);
        }
        GUIManager.hideSystemUI(this.mViewRoot);
        int i3 = this.hintType;
        if (i3 == 0 || i3 == 1 || i3 == 4 || i3 == 5) {
            this.textHint = (TextView) this.mViewRoot.findViewById(R.id.hint_text_instructor);
            this.hintTextMainTitle = (TextView) this.mViewRoot.findViewById(R.id.hint_text_main_title);
            this.hintMainQuests = (RecyclerView) this.mViewRoot.findViewById(R.id.hint_main_quests);
            this.hintUnderline = this.mViewRoot.findViewById(R.id.hint_underline);
            this.hintTextAdditionalTitle = (TextView) this.mViewRoot.findViewById(R.id.hint_text_additional_title);
            this.hintAdditionalQuests = (RecyclerView) this.mViewRoot.findViewById(R.id.hint_additional_quests);
            this.blockView = this.mViewRoot.findViewById(R.id.hint_additional_quests_block_view);
            this.hintTextIfWithoutAdditionalQuests = (TextView) this.mViewRoot.findViewById(R.id.hint_text_if_without_additional_quests);
            this.hintInstructor = (ImageView) this.mViewRoot.findViewById(R.id.hint_instructor);
            int i4 = this.hintType;
            if (i4 == 1) {
                setVisibleBlock(false, 0);
                TextView textView = this.textHint;
                textView.setText(Html.fromHtml("<font color=#FFC634>Дядя Миша</font><br>" + json.optString("s")));
                this.hintInstructor.setVisibility(0);
                this.hintInstructor.setImageResource(R.drawable.uncle_misha);
            } else if (i4 == 4) {
                getStartData(json);
                setDataInView();
                this.hintInstructor.setVisibility(0);
                this.hintInstructor.setImageResource(R.drawable.mes_icon);
            } else if (i4 == 5) {
                getStartData(json);
                setDataInView();
                this.hintInstructor.setVisibility(4);
            } else {
                setVisibleBlock(false, 0);
                this.textHint.setText(Html.fromHtml(json.optString("s")));
            }
        } else if (i3 == 2) {
            this.textHint = (TextView) this.mViewRoot.findViewById(R.id.text_hint);
            ((TextView) this.mViewRoot.findViewById(R.id.header_hint)).setText(json.optString("h"));
            this.textHint.setText(Html.fromHtml(json.optString("s")));
        } else if (i3 == 3) {
            this.mViewRoot.findViewById(R.id.hint_call).startAnimation(AnimationUtils.loadAnimation(activity, R.anim.anim_call));
            this.mViewRoot.findViewById(R.id.hint_call).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.gui.TutorialHints.GUITutorial.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("t", 0);
                        GUITutorial.this.mGUIManager.sendJsonData(39, jSONObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    GUITutorial.this.mWindow.dismiss();
                }
            });
        }
        this.mViewRoot.setOnTouchListener(new View.OnTouchListener() { // from class: com.rockstargames.gtacr.gui.TutorialHints.GUITutorial.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                int pointerCount = event.getPointerCount();
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                for (int i11 = 0; i11 < pointerCount; i11++) {
                    int pointerId = event.getPointerId(i11);
                    if (pointerId == 0) {
                        i5 = (int) event.getX(i11);
                        i6 = (int) event.getY(i11);
                    } else if (pointerId == 1) {
                        i7 = (int) event.getX(i11);
                        i8 = (int) event.getY(i11);
                    } else if (pointerId == 2) {
                        i9 = (int) event.getX(i11);
                        i10 = (int) event.getY(i11);
                    }
                }
                int pointerId2 = event.getPointerId(event.getActionIndex());
                GUITutorial.this.mActivity.customMultiTouchEvent(event.getActionMasked(), pointerId2, i5, i6, i7, i8, i9, i10);
                return true;
            }
        });
        this.handler_ = new Handler();
        this.runnable_ = new Runnable() { // from class: com.rockstargames.gtacr.gui.TutorialHints.-$$Lambda$GUITutorial$GKN8E4U_JSiIiKatryI4EzJmk-c
            @Override // java.lang.Runnable
            public final void run() {
                GUITutorial.this.lambda$show$1$GUITutorial();
            }
        };
        new Thread(this.runnable_).start();
    }

    public /* synthetic */ void lambda$show$1$GUITutorial() {
        while (!this.ifOpenWindow) {
            SystemClock.sleep(200L);
            this.handler_.post(new Runnable() { // from class: com.rockstargames.gtacr.gui.TutorialHints.-$$Lambda$GUITutorial$8vnqwMA0yc9-IXFg6lmPo1Z75Cg
                @Override // java.lang.Runnable
                public final void run() {
                    GUITutorial.this.lambda$null$0$GUITutorial();
                }
            });
        }
    }

    public /* synthetic */ void lambda$null$0$GUITutorial() {
        if (this.mGUIManager.isShowingGui()) {
            return;
        }
        showWindow(this.ifOpenWindow);
    }

    private void showWindow(boolean ifOpenWindow) {
        if (ifOpenWindow) {
            return;
        }
        this.ifOpenWindow = true;
        this.mWindow.showAtLocation(this.mActivity.getParentLayout(), 17, 0, 0);
    }

    private RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this.mViewRoot.getContext(), 1, false);
    }

    private void setDataInView() {
        this.mainQuestAdapter = new TutorialAdapter(this.mActivity, this.mainQuest);
        this.hintMainQuests.setLayoutManager(getLayoutManager());
        this.hintMainQuests.setAdapter(this.mainQuestAdapter);
        this.additionalQuestAdapter = new TutorialAdapter(this.mActivity, this.additionalQuests);
        this.hintAdditionalQuests.setLayoutManager(getLayoutManager());
        this.hintAdditionalQuests.setAdapter(this.additionalQuestAdapter);
    }

    private void setVisibleBlock(Boolean ifQuests, Integer additionalQuestsSize) {
        if (ifQuests.booleanValue()) {
            this.textHint.setVisibility(4);
            this.hintTextMainTitle.setVisibility(0);
            this.hintMainQuests.setVisibility(0);
            this.hintTextAdditionalTitle.setVisibility(0);
            if (additionalQuestsSize.intValue() == 0) {
                this.hintAdditionalQuests.setVisibility(4);
                this.blockView.setVisibility(4);
                this.hintTextIfWithoutAdditionalQuests.setVisibility(0);
                this.hintMainQuests.setBackground(ContextCompat.getDrawable(this.mViewRoot.getContext(), R.drawable.hint_back_bottom));
                this.hintUnderline.setVisibility(4);
                return;
            }
            this.hintAdditionalQuests.setVisibility(0);
            this.blockView.setVisibility(0);
            this.hintTextIfWithoutAdditionalQuests.setVisibility(4);
            this.hintMainQuests.setBackgroundColor(ResourcesCompat.getColor(this.mViewRoot.getResources(), R.color.color_75_212333, null));
            this.hintUnderline.setVisibility(0);
            return;
        }
        this.textHint.setVisibility(0);
        this.hintTextMainTitle.setVisibility(4);
        this.hintMainQuests.setVisibility(4);
        this.hintUnderline.setVisibility(4);
        this.hintTextAdditionalTitle.setVisibility(4);
        this.hintAdditionalQuests.setVisibility(4);
        this.blockView.setVisibility(4);
        this.hintTextIfWithoutAdditionalQuests.setVisibility(4);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00b6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getStartData(JSONObject r12) {
        /*
            r11 = this;
            if (r12 == 0) goto Leb
            java.lang.String r0 = "t"
            int r0 = r12.optInt(r0)
            r1 = 3
            r2 = 0
            if (r0 == r1) goto Lcb
            r1 = 4
            if (r0 == r1) goto L11
            goto Leb
        L11:
            java.util.ArrayList<com.rockstargames.gtacr.data.HintQuestData> r0 = r11.mainQuest
            r0.clear()
            java.util.ArrayList<com.rockstargames.gtacr.data.HintQuestData> r0 = r11.mainQuest
            com.rockstargames.gtacr.data.HintQuestData r1 = new com.rockstargames.gtacr.data.HintQuestData
            java.lang.String r3 = "mq"
            java.lang.String r3 = r12.optString(r3)
            android.text.Spanned r3 = android.text.Html.fromHtml(r3)
            java.lang.String r4 = "mt"
            int r4 = r12.optInt(r4)
            java.lang.String r5 = "ma"
            int r5 = r12.optInt(r5)
            r6 = 1
            r1.<init>(r3, r4, r5, r6)
            r0.add(r1)
            java.util.ArrayList<com.rockstargames.gtacr.data.HintQuestData> r0 = r11.additionalQuests
            r0.clear()
            java.lang.String r0 = "aq"
            org.json.JSONArray r0 = r12.optJSONArray(r0)
            java.lang.String r1 = "at"
            org.json.JSONArray r1 = r12.optJSONArray(r1)
            java.lang.String r3 = "aa"
            org.json.JSONArray r12 = r12.optJSONArray(r3)
            if (r0 == 0) goto Lb9
            if (r1 == 0) goto Lb9
            if (r12 == 0) goto Lb9
            int r3 = r0.length()
            int r4 = r1.length()
            if (r3 != r4) goto Lb9
            int r3 = r0.length()
            int r4 = r12.length()
            if (r3 != r4) goto Lb9
            r3 = 0
        L69:
            int r4 = r0.length()
            if (r3 >= r4) goto Lb9
            java.lang.String r4 = ""
            android.text.Spanned r4 = android.text.Html.fromHtml(r4)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            java.lang.Object r8 = r0.get(r3)     // Catch: org.json.JSONException -> L97
            java.lang.String r8 = (java.lang.String) r8     // Catch: org.json.JSONException -> L97
            android.text.Spanned r4 = android.text.Html.fromHtml(r8)     // Catch: org.json.JSONException -> L97
            java.lang.Object r8 = r1.get(r3)     // Catch: org.json.JSONException -> L97
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch: org.json.JSONException -> L97
            java.lang.Object r5 = r12.get(r3)     // Catch: org.json.JSONException -> L95
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: org.json.JSONException -> L95
            r7 = r5
            goto L9e
        L95:
            r5 = move-exception
            goto L9b
        L97:
            r8 = move-exception
            r10 = r8
            r8 = r5
            r5 = r10
        L9b:
            r5.printStackTrace()
        L9e:
            int r5 = r7.intValue()
            if (r5 == 0) goto Lb6
            java.util.ArrayList<com.rockstargames.gtacr.data.HintQuestData> r5 = r11.additionalQuests
            com.rockstargames.gtacr.data.HintQuestData r9 = new com.rockstargames.gtacr.data.HintQuestData
            int r8 = r8.intValue()
            int r7 = r7.intValue()
            r9.<init>(r4, r8, r7, r2)
            r5.add(r9)
        Lb6:
            int r3 = r3 + 1
            goto L69
        Lb9:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r6)
            java.util.ArrayList<com.rockstargames.gtacr.data.HintQuestData> r0 = r11.additionalQuests
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r11.setVisibleBlock(r12, r0)
            goto Leb
        Lcb:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            java.util.ArrayList<com.rockstargames.gtacr.data.HintQuestData> r1 = r11.additionalQuests
            int r1 = r1.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11.setVisibleBlock(r0, r1)
            android.widget.TextView r0 = r11.textHint
            java.lang.String r1 = "s"
            java.lang.String r12 = r12.optString(r1)
            android.text.Spanned r12 = android.text.Html.fromHtml(r12)
            r0.setText(r12)
        Leb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rockstargames.gtacr.gui.TutorialHints.GUITutorial.getStartData(org.json.JSONObject):void");
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
        int i;
        GUIPopupWindow gUIPopupWindow;
        int optInt = json.optInt("t");
        if (optInt == 0) {
            setVisibleBlock(false, 0);
            this.textHint.setText(Html.fromHtml(json.optString("s")));
        } else if (optInt == 1) {
            JSONArray optJSONArray = json.optJSONArray("at");
            if (optJSONArray == null || optJSONArray.length() != this.additionalQuests.size()) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    i = ((Integer) optJSONArray.get(i2)).intValue();
                } catch (JSONException e) {
                    e.printStackTrace();
                    i = 0;
                }
                this.additionalQuests.get(i2).setThisQuestsStatus(i);
            }
            this.additionalQuestAdapter.notifyDataSetChanged();
        } else if (optInt != 2) {
            if (optInt == 3) {
                setVisibleBlock(true, Integer.valueOf(this.additionalQuests.size()));
            } else if (optInt == 4 && (gUIPopupWindow = this.mWindow) != null) {
                gUIPopupWindow.dismiss();
            }
        } else if (this.mainQuest.size() != 0) {
            int optInt2 = json.optInt(TuningConstants.KEY_SEND_DETAILS_TYPE);
            if (optInt2 != 0) {
                this.mainQuest.get(0).setThisQuestsStatus(optInt2);
            }
            int optInt3 = json.optInt("ma");
            if (optInt3 != 0) {
                this.mainQuest.get(0).setMaxQuestsStatus(optInt3);
            }
            this.mainQuestAdapter.notifyItemChanged(0);
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
        GUIPopupWindow gUIPopupWindow = this.mWindow;
        if (gUIPopupWindow != null) {
            gUIPopupWindow.dismiss();
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        GUIPopupWindow gUIPopupWindow = this.mWindow;
        if (gUIPopupWindow != null) {
            return gUIPopupWindow.isShowing();
        }
        return false;
    }
}