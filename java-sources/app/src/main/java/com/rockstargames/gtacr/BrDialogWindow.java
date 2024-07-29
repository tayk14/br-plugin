package com.rockstargames.gtacr;

import android.graphics.drawable.ColorDrawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import blackrussia.online.R;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.common.CustomEditTextWithBackPressEvent;
import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogWindow implements ISAMPGUI {
    private GUIManager mManager = null;
    private PopupWindow mWindow = null;
    private NvEventQueueActivity mActivity = null;
    private View mView = null;
    private View mSelectedButton = null;
    private TextView mOrigButton = null;
    private int mClickedButton = -1;
    private CustomEditTextWithBackPressEvent mEditText = null;
    private String mListitemToSend = null;
    private boolean mIsTab = false;
    private boolean ifOtherMethodClosed = false;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 10;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogWindow();
    }

    private String[] getSplittedStrings(String content) {
        return content.split(Pattern.quote("\n"));
    }

    private String[] getSplittedTabs(String content) {
        return content.split(Pattern.quote("\t"));
    }

    public float[] calcuteStringsLength(TextView textView, String[] strings) {
        float[] fArr = new float[strings.length];
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(textView.getTextSize());
        textPaint.setTypeface(textView.getTypeface());
        for (int i = 0; i < strings.length; i++) {
            fArr[i] = new StaticLayout(GUIManager.transfromColors(strings[i]), textPaint, 10000, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineWidth(0) + 5.0f;
        }
        return fArr;
    }

    private TextView createButtonFromOrig(TextView btn_orig, boolean margin, boolean tabbed) {
        TextView textView = new TextView(this.mActivity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (margin) {
            layoutParams.topMargin = NvEventQueueActivity.dpToPx(6.0f, this.mActivity);
        }
        textView.setLayoutParams(layoutParams);
        textView.setBackground(btn_orig.getBackground());
        textView.setTypeface(btn_orig.getTypeface());
        textView.setGravity(btn_orig.getGravity());
        if (!tabbed) {
            textView.setPadding(btn_orig.getPaddingLeft(), btn_orig.getPaddingTop(), btn_orig.getPaddingRight(), btn_orig.getPaddingBottom());
        }
        textView.setAllCaps(false);
        textView.setTextColor(btn_orig.getTextColors().getDefaultColor());
        textView.setTextSize(0, btn_orig.getTextSize());
        return textView;
    }

    private float[][] getColumnsWidth(TextView textView, String[] strings) {
        float[][] fArr = new float[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            String[] splittedTabs = getSplittedTabs(strings[i]);
            fArr[i] = new float[splittedTabs.length];
            for (int i2 = 0; i2 < splittedTabs.length; i2++) {
                textView.setText(GUIManager.transfromColors(splittedTabs[i2]));
                fArr[i][i2] = GUIManager.getTextLength(textView) + NvEventQueueActivity.dpToPx(54.0f, this.mActivity);
            }
        }
        return fArr;
    }

    private float[] getMaxWidths(float[][] floats) {
        float[] fArr = new float[5];
        for (int i = 0; i < 5; i++) {
            fArr[i] = -1.0f;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            for (int i3 = 0; i3 < floats.length; i3++) {
                if (i2 < floats[i3].length && floats[i3][i2] >= fArr[i2]) {
                    fArr[i2] = floats[i3][i2];
                }
            }
        }
        return fArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: android.widget.LinearLayout */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:128:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0116  */
    @Override // com.rockstargames.gtacr.ISAMPGUI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void show(JSONObject jSONObject, GUIManager gUIManager, NvEventQueueActivity nvEventQueueActivity) {
        String str;
        String str2;
        String str3 = null;
        int i;
        String str4 = null;
        Button button;
        boolean z;
        boolean z2;
        boolean z3;
        final String[] strArr;
        String str5;
        String[] strArr2;
        boolean z4;
        TextView textView;
        TextView createButtonFromOrig = null;
        this.mManager = gUIManager;
        this.mActivity = nvEventQueueActivity;
        if (this.mWindow == null) {
            this.mView = ((LayoutInflater) nvEventQueueActivity.getSystemService("layout_inflater")).inflate(R.layout.window_dialog, (ViewGroup) null, false);
            PopupWindow popupWindow = new PopupWindow(this.mView, -2, -2, true);
            this.mWindow = popupWindow;
            popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mWindow.setSoftInputMode(16);
            this.mWindow.setFocusable(true);
            this.mWindow.setTouchInterceptor(new View.OnTouchListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        if (motionEvent.getX() < 0.0f || motionEvent.getX() > view.getWidth()) {
                            ((InputMethodManager) BrDialogWindow.this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(BrDialogWindow.this.mEditText.getWindowToken(), 0);
                            BrDialogWindow.this.mEditText.setFocusable(false);
                            BrDialogWindow.this.mEditText.setFocusableInTouchMode(true);
                            return true;
                        }
                        if (motionEvent.getY() < 0.0f || motionEvent.getY() > view.getHeight()) {
                            ((InputMethodManager) BrDialogWindow.this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(BrDialogWindow.this.mEditText.getWindowToken(), 0);
                            BrDialogWindow.this.mEditText.setFocusable(false);
                            BrDialogWindow.this.mEditText.setFocusableInTouchMode(true);
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.2
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    boolean unused = BrDialogWindow.this.ifOtherMethodClosed;
                    BrDialogWindow.this.ifOtherMethodClosed = false;
                    BrDialogWindow.this.mWindow.setFocusable(false);
                }
            });
        }
        this.mClickedButton = -1;
        this.mListitemToSend = null;
        GUIManager.makeAllViewsVisible((ViewGroup) this.mView.findViewById(R.id.dw_root));
        try {
            i = jSONObject.getInt("i");
            try {
                str = jSONObject.getString(Const.FRACTION_CLOSE_KEY);
                try {
                    str2 = jSONObject.getString("s");
                    try {
                        str3 = jSONObject.getString("l");
                        try {
                            str4 = jSONObject.getString(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL);
                        } catch (Exception unused) {
                            str4 = null;
                            Button button2 = (Button) this.mView.findViewById(R.id.dw_button_ok);
                            button = (Button) this.mView.findViewById(R.id.dw_button_cancel);
                            TextView textView2 = (TextView) this.mView.findViewById(R.id.dw_caption);
                            CustomEditTextWithBackPressEvent customEditTextWithBackPressEvent = (CustomEditTextWithBackPressEvent) this.mView.findViewById(R.id.dw_edittext);
                            this.mEditText = customEditTextWithBackPressEvent;
                            NvEventQueueActivity.fixEditTextForAndroid10Xiaomi(customEditTextWithBackPressEvent);
                            button2.setText(GUIManager.transfromColors(str3));
                            button.setText(GUIManager.transfromColors(str4));
                            textView2.setText(GUIManager.transfromColors(str));
                            if (str4 != null) {
                            }
                            if (i == 3) {
                            }
                            if (i == 4) {
                            }
                            if (i == 5) {
                            }
                            button2.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    BrDialogWindow.this.ifOtherMethodClosed = true;
                                    BrDialogWindow.this.sendResponse(1);
                                }
                            });
                            button.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.4
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    BrDialogWindow.this.ifOtherMethodClosed = true;
                                    BrDialogWindow.this.sendResponse(0);
                                }
                            });
                            GUIManager.changeTextViewWidth(textView2);
                            if (i == 0) {
                            }
                            this.mEditText.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.7
                                @Override // com.rockstargames.gtacr.common.CustomEditTextWithBackPressEvent.MyEditTextListener
                                public void callback() {
                                    NvEventQueueActivity nvEventQueueActivity2 = BrDialogWindow.this.mActivity;
                                    NvEventQueueActivity unused2 = BrDialogWindow.this.mActivity;
                                    ((InputMethodManager) nvEventQueueActivity2.getSystemService("input_method")).hideSoftInputFromWindow(BrDialogWindow.this.mEditText.getWindowToken(), 0);
                                    BrDialogWindow.this.mEditText.setFocusable(false);
                                    BrDialogWindow.this.mEditText.setFocusableInTouchMode(true);
                                }
                            });
                            this.mEditText.setOnKeyListener(new View.OnKeyListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.8
                                @Override // android.view.View.OnKeyListener
                                public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                                    if (i2 != 66) {
                                        return false;
                                    }
                                    NvEventQueueActivity nvEventQueueActivity2 = BrDialogWindow.this.mActivity;
                                    NvEventQueueActivity unused2 = BrDialogWindow.this.mActivity;
                                    ((InputMethodManager) nvEventQueueActivity2.getSystemService("input_method")).hideSoftInputFromWindow(BrDialogWindow.this.mEditText.getWindowToken(), 0);
                                    BrDialogWindow.this.mEditText.setFocusable(false);
                                    BrDialogWindow.this.mEditText.setFocusableInTouchMode(true);
                                    return true;
                                }
                            });
                            this.mWindow.showAtLocation(nvEventQueueActivity.getParentLayout(), 17, 0, 0);
                        }
                    } catch (Exception unused2) {
                        str3 = null;
                    }
                } catch (Exception unused3) {
                    str2 = null;
                    str3 = str2;
                    str4 = null;
                    Button button22 = (Button) this.mView.findViewById(R.id.dw_button_ok);
                    button = (Button) this.mView.findViewById(R.id.dw_button_cancel);
                    TextView textView22 = (TextView) this.mView.findViewById(R.id.dw_caption);
                    CustomEditTextWithBackPressEvent customEditTextWithBackPressEvent2 = (CustomEditTextWithBackPressEvent) this.mView.findViewById(R.id.dw_edittext);
                    this.mEditText = customEditTextWithBackPressEvent2;
                    NvEventQueueActivity.fixEditTextForAndroid10Xiaomi(customEditTextWithBackPressEvent2);
                    button22.setText(GUIManager.transfromColors(str3));
                    button.setText(GUIManager.transfromColors(str4));
                    textView22.setText(GUIManager.transfromColors(str));
                    if (str4 != null) {
                        button.setVisibility(8);
                    }
                    if (i == 3) {
                    }
                    if (i == 4) {
                    }
                    if (i == 5) {
                    }
                    button22.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BrDialogWindow.this.ifOtherMethodClosed = true;
                            BrDialogWindow.this.sendResponse(1);
                        }
                    });
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            BrDialogWindow.this.ifOtherMethodClosed = true;
                            BrDialogWindow.this.sendResponse(0);
                        }
                    });
                    GUIManager.changeTextViewWidth(textView22);
                    if (i == 0) {
                    }
                    this.mEditText.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.7
                        @Override // com.rockstargames.gtacr.common.CustomEditTextWithBackPressEvent.MyEditTextListener
                        public void callback() {
                            NvEventQueueActivity nvEventQueueActivity2 = BrDialogWindow.this.mActivity;
                            NvEventQueueActivity unused22 = BrDialogWindow.this.mActivity;
                            ((InputMethodManager) nvEventQueueActivity2.getSystemService("input_method")).hideSoftInputFromWindow(BrDialogWindow.this.mEditText.getWindowToken(), 0);
                            BrDialogWindow.this.mEditText.setFocusable(false);
                            BrDialogWindow.this.mEditText.setFocusableInTouchMode(true);
                        }
                    });
                    this.mEditText.setOnKeyListener(new View.OnKeyListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.8
                        @Override // android.view.View.OnKeyListener
                        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                            if (i2 != 66) {
                                return false;
                            }
                            NvEventQueueActivity nvEventQueueActivity2 = BrDialogWindow.this.mActivity;
                            NvEventQueueActivity unused22 = BrDialogWindow.this.mActivity;
                            ((InputMethodManager) nvEventQueueActivity2.getSystemService("input_method")).hideSoftInputFromWindow(BrDialogWindow.this.mEditText.getWindowToken(), 0);
                            BrDialogWindow.this.mEditText.setFocusable(false);
                            BrDialogWindow.this.mEditText.setFocusableInTouchMode(true);
                            return true;
                        }
                    });
                    this.mWindow.showAtLocation(nvEventQueueActivity.getParentLayout(), 17, 0, 0);
                }
            } catch (Exception unused4) {
                str = null;
                str2 = null;
            }
        } catch (Exception unused5) {
            str = null;
            str2 = null;
            str3 = null;
            i = -1;
        }
        Button button222 = (Button) this.mView.findViewById(R.id.dw_button_ok);
        button = (Button) this.mView.findViewById(R.id.dw_button_cancel);
        TextView textView222 = (TextView) this.mView.findViewById(R.id.dw_caption);
        CustomEditTextWithBackPressEvent customEditTextWithBackPressEvent22 = (CustomEditTextWithBackPressEvent) this.mView.findViewById(R.id.dw_edittext);
        this.mEditText = customEditTextWithBackPressEvent22;
        NvEventQueueActivity.fixEditTextForAndroid10Xiaomi(customEditTextWithBackPressEvent22);
        button222.setText(GUIManager.transfromColors(str3));
        button.setText(GUIManager.transfromColors(str4));
        textView222.setText(GUIManager.transfromColors(str));
        if (str4 != null && str4.length() == 0) {
            button.setVisibility(8);
        }
        if (i == 3) {
            i = 1;
        }
        if (i == 4) {
            z = true;
            i = 2;
        } else {
            z = false;
        }
        if (i == 5) {
            z3 = true;
            i = 2;
            z2 = true;
        } else {
            z2 = z;
            z3 = false;
        }
        button222.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BrDialogWindow.this.ifOtherMethodClosed = true;
                BrDialogWindow.this.sendResponse(1);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BrDialogWindow.this.ifOtherMethodClosed = true;
                BrDialogWindow.this.sendResponse(0);
            }
        });
        GUIManager.changeTextViewWidth(textView222);
        if (i == 0) {
            this.mEditText.setVisibility(8);
            this.mView.findViewById(R.id.dw_scroll_root).setVisibility(8);
            TextView textView3 = (TextView) this.mView.findViewById(R.id.dw_info);
            textView3.setText(GUIManager.transfromColors(str2));
            GUIManager.changeTextViewWidth(textView3);
        } else if (i == 1) {
            this.mWindow.setFocusable(true);
            this.mView.findViewById(R.id.dw_scroll_root).setVisibility(8);
            TextView textView4 = (TextView) this.mView.findViewById(R.id.dw_info);
            textView4.setText(GUIManager.transfromColors(str2));
            GUIManager.changeTextViewWidth(textView4);
            this.mEditText.getEditableText().clear();
        } else if (i == 2) {
            this.mWindow.setFocusable(true);
            final LinearLayout linearLayout = (LinearLayout) this.mView.findViewById(R.id.dw_header);
            this.mView.findViewById(R.id.dw_scroll_info).setVisibility(8);
            this.mEditText.setVisibility(8);
            if (!z3) {
                this.mView.findViewById(R.id.dw_divider).setVisibility(8);
                linearLayout.setVisibility(8);
            }
            if (this.mOrigButton == null) {
                this.mOrigButton = (TextView) this.mView.findViewById(R.id.dw_list_button);
            }
            TextView textView5 = this.mOrigButton;
            String[] splittedStrings = getSplittedStrings(str2);
            float[] maxWidths = z2 ? getMaxWidths(getColumnsWidth(textView5, splittedStrings)) : null;
            if (z3) {
                str5 = splittedStrings[0];
                String[] strArr3 = new String[splittedStrings.length - 1];
                for (int i2 = 1; i2 < splittedStrings.length; i2++) {
                    strArr3[i2 - 1] = splittedStrings[i2];
                }
                String[] splittedTabs = getSplittedTabs(str5);
                for (int i3 = 0; i3 < linearLayout.getChildCount(); i3++) {
                    linearLayout.getChildAt(i3).setVisibility(8);
                }
                for (int i4 = 0; i4 < splittedTabs.length; i4++) {
                    TextView textView6 = (TextView) linearLayout.getChildAt(i4);
                    textView6.setText(GUIManager.transfromColors(splittedTabs[i4]));
                    textView6.setVisibility(0);
                }
                strArr2 = splittedTabs;
                strArr = strArr3;
            } else {
                strArr = splittedStrings;
                str5 = null;
                strArr2 = null;
            }
            float[] calcuteStringsLength = calcuteStringsLength(textView5, strArr);
            if (calcuteStringsLength == null || calcuteStringsLength.length == 0) {
                if (str5 != null) {
                    FirebaseCrashlytics.getInstance().recordException(new RuntimeException("HEADER " + str5 + "widths length 0 dialog text " + strArr.length + " button" + str3));
                    return;
                }
                FirebaseCrashlytics.getInstance().recordException(new RuntimeException("NO HEADER widths length 0 dialog text " + strArr.length + " button" + str3));
                return;
            }
            float f = calcuteStringsLength[0];
            for (int i5 = 0; i5 < calcuteStringsLength.length; i5++) {
                if (calcuteStringsLength[i5] > f) {
                    f = calcuteStringsLength[i5];
                }
            }
            final View findViewById = this.mView.findViewById(R.id.dw_scroll_root);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.width = ((int) f) + NvEventQueueActivity.dpToPx(54.0f, this.mActivity);
            if (z2) {
                layoutParams.width = 0;
                for (float f2 : maxWidths) {
                    layoutParams.width = (int) (layoutParams.width + f2);
                }
            }
            int textLength = GUIManager.getTextLength(textView222);
            if (layoutParams.width < textLength) {
                layoutParams.width = textLength;
                z4 = true;
            } else {
                z4 = false;
            }
            findViewById.setLayoutParams(layoutParams);
            final ViewGroup viewGroup = (ViewGroup) this.mView.findViewById(R.id.dw_root);
            final LinearLayout linearLayout2 = (LinearLayout) this.mView.findViewById(R.id.dw_scroll_layout);
            final float[] fArr = maxWidths;
            final boolean z5 = z4;
            TextView textView7 = textView5;
            final String[] strArr4 = strArr2;
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.5
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    if (viewGroup.getWidth() > findViewById.getWidth() && z5) {
                        ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                        layoutParams2.width = -1;
                        findViewById.setLayoutParams(layoutParams2);
                    }
                    if (viewGroup.findViewById(R.id.dw_root_buttons).getWidth() > findViewById.getWidth()) {
                        ViewGroup.LayoutParams layoutParams3 = findViewById.getLayoutParams();
                        layoutParams3.width = -1;
                        findViewById.setLayoutParams(layoutParams3);
                    }
                    float[] fArr2 = fArr;
                    if (fArr2 != null) {
                        int length = fArr2.length;
                        float[] fArr3 = new float[length];
                        for (int i6 = 0; i6 < length; i6++) {
                            fArr3[i6] = fArr[i6] / findViewById.getWidth();
                        }
                        if (strArr4 != null) {
                            for (int i7 = 0; i7 < strArr4.length; i7++) {
                                TextView textView8 = (TextView) linearLayout.getChildAt(i7);
                                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) textView8.getLayoutParams();
                                layoutParams4.weight = 1.0f - fArr3[i7];
                                textView8.setLayoutParams(layoutParams4);
                            }
                        }
                        for (int i8 = 0; i8 < linearLayout2.getChildCount(); i8++) {
                            if (linearLayout2.getChildAt(i8) instanceof LinearLayout) {
                                LinearLayout linearLayout3 = (LinearLayout) linearLayout2.getChildAt(i8);
                                for (int i9 = 0; i9 < linearLayout3.getChildCount(); i9++) {
                                    LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) linearLayout3.getChildAt(i9).getLayoutParams();
                                    layoutParams5.weight = 1.0f - fArr3[i9];
                                    linearLayout3.getChildAt(i9).setLayoutParams(layoutParams5);
                                }
                            }
                        }
                    }
                }
            });
            linearLayout2.removeAllViews();
            int i6 = 0;
            while (i6 < strArr.length) {
                if (z2) {
                    LinearLayout linearLayout3 = new LinearLayout(this.mActivity);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    if (i6 >= 1) {
                        layoutParams2.topMargin = NvEventQueueActivity.dpToPx(6.0f, this.mActivity);
                    }
                    linearLayout3.setLayoutParams(layoutParams2);
                    linearLayout3.setOrientation(0);
                    linearLayout3.setPadding(textView7.getPaddingLeft(), textView7.getPaddingTop(), textView7.getPaddingRight(), textView7.getPaddingBottom());
                    linearLayout3.setBackground(ResourcesCompat.getDrawable(this.mActivity.getResources(), R.drawable.br_list_inactive, null));
                    for (String str6 : getSplittedTabs(strArr[i6])) {
                        TextView createButtonFromOrig2 = createButtonFromOrig(textView7, false, true);
                        createButtonFromOrig2.setText(GUIManager.transfromColors(str6));
                        createButtonFromOrig2.setBackground(new ColorDrawable());
                        linearLayout3.addView(createButtonFromOrig2);
                    }
                    textView = textView7;
//                    createButtonFromOrig = linearLayout3;
                } else {
                    textView = textView7;
                    if (i6 >= 1) {
                        createButtonFromOrig = createButtonFromOrig(textView, true, false);
                    } else {
                        createButtonFromOrig = createButtonFromOrig(textView, false, false);
                    }
                }
                if (i6 == 0) {
                    this.mSelectedButton = createButtonFromOrig;
                    this.mClickedButton = i6;
                    this.mListitemToSend = strArr[i6];
                    createButtonFromOrig.setBackground(ResourcesCompat.getDrawable(this.mActivity.getResources(), R.drawable.br_list_active, null));
                }
                int finalI = i6;
                createButtonFromOrig.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (BrDialogWindow.this.mSelectedButton != view) {
                            if (BrDialogWindow.this.mSelectedButton != null) {
                                BrDialogWindow.this.mSelectedButton.setBackground(ResourcesCompat.getDrawable(BrDialogWindow.this.mActivity.getResources(), R.drawable.br_list_inactive, null));
                            }
                            BrDialogWindow.this.mSelectedButton = view;
                            BrDialogWindow.this.mClickedButton = finalI;
                            BrDialogWindow.this.mListitemToSend = strArr[finalI];
                            BrDialogWindow.this.mSelectedButton.setBackground(ResourcesCompat.getDrawable(BrDialogWindow.this.mActivity.getResources(), R.drawable.br_list_active, null));
                            BrDialogWindow.this.mSelectedButton.startAnimation(AnimationUtils.loadAnimation(BrDialogWindow.this.mActivity, R.anim.button_click));
                            return;
                        }
                        BrDialogWindow.this.mClickedButton = finalI;
                        BrDialogWindow.this.ifOtherMethodClosed = true;
                        BrDialogWindow.this.sendResponse(1);
                        BrDialogWindow.this.mSelectedButton = null;
                    }
                });
                if (!z2) {
                    createButtonFromOrig.setText(GUIManager.transfromColors(strArr[i6]));
                }
                linearLayout2.addView(createButtonFromOrig);
                i6++;
                textView7 = textView;
            }
            textView7.setVisibility(8);
        }
        this.mEditText.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.7
            @Override // com.rockstargames.gtacr.common.CustomEditTextWithBackPressEvent.MyEditTextListener
            public void callback() {
                NvEventQueueActivity nvEventQueueActivity2 = BrDialogWindow.this.mActivity;
                NvEventQueueActivity unused22 = BrDialogWindow.this.mActivity;
                ((InputMethodManager) nvEventQueueActivity2.getSystemService("input_method")).hideSoftInputFromWindow(BrDialogWindow.this.mEditText.getWindowToken(), 0);
                BrDialogWindow.this.mEditText.setFocusable(false);
                BrDialogWindow.this.mEditText.setFocusableInTouchMode(true);
            }
        });
        this.mEditText.setOnKeyListener(new View.OnKeyListener() { // from class: com.rockstargames.gtacr.BrDialogWindow.8
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i22, KeyEvent keyEvent) {
                if (i22 != 66) {
                    return false;
                }
                NvEventQueueActivity nvEventQueueActivity2 = BrDialogWindow.this.mActivity;
                NvEventQueueActivity unused22 = BrDialogWindow.this.mActivity;
                ((InputMethodManager) nvEventQueueActivity2.getSystemService("input_method")).hideSoftInputFromWindow(BrDialogWindow.this.mEditText.getWindowToken(), 0);
                BrDialogWindow.this.mEditText.setFocusable(false);
                BrDialogWindow.this.mEditText.setFocusableInTouchMode(true);
                return true;
            }
        });
        this.mWindow.showAtLocation(nvEventQueueActivity.getParentLayout(), 17, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResponse(int button) {
        int i;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("b", button);
            String str = this.mListitemToSend;
            if (str != null) {
                String str2 = getSplittedTabs(str)[0];
                for (int i2 = 0; i2 < str2.length(); i2++) {
                    if (str2.charAt(i2) == '{' && (i = i2 + 7) < str2.length() && str2.charAt(i) == '}') {
                        str2 = str2.replaceAll(Pattern.quote(str2.substring(i2, i2 + 8)), "");
                    }
                }
                jSONObject.put("i", str2);
                this.mListitemToSend = null;
            } else {
                jSONObject.put("i", this.mEditText.getText().toString());
            }
            jSONObject.put("l", this.mClickedButton);
        } catch (Exception unused) {
        }
        this.mManager.sendJsonData(10, jSONObject);
        this.mManager.closeGUI(null, 10);
        this.mClickedButton = -1;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
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
