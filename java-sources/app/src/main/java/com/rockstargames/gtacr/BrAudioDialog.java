package com.rockstargames.gtacr;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;
import blackrussia.online.R;
import com.google.android.material.tabs.TabLayout;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrAudioDialog extends DialogFragment implements ISAMPGUI {
    NvEventQueueActivity mContext = null;
    private GUIManager mGUIManager = null;
    TabLayout tabLayout;
    public ViewPager viewPager;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 9;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public static ISAMPGUI newInstance() {
        return new BrAudioDialog();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        onAudioGuiClosed();
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.br_audio, (ViewGroup) null, false);
        this.tabLayout = (TabLayout) inflate.findViewById(R.id.br_audio_tabLayout);
        this.viewPager = (ViewPager) inflate.findViewById(R.id.br_audio_masterViewPager);
        BrDialogVoiceAdapter brDialogVoiceAdapter = new BrDialogVoiceAdapter(getChildFragmentManager(), 0);
        brDialogVoiceAdapter.addFragment("Радиостанция        ", BrAudioFragment.createInstance(1, this));
        brDialogVoiceAdapter.addFragment("Библиотека        ", BrAudioFragment.createInstance(2, this));
        this.viewPager.setAdapter(brDialogVoiceAdapter);
        this.tabLayout.setupWithViewPager(this.viewPager);
        this.mContext = (NvEventQueueActivity) getActivity();
        this.viewPager.setCurrentItem(0);
        View childAt = ((ViewGroup) this.tabLayout.getChildAt(0)).getChildAt(0);
        View childAt2 = ((ViewGroup) this.tabLayout.getChildAt(0)).getChildAt(1);
        childAt.setBackgroundResource(R.drawable.br_ltab_background_selected);
        childAt2.setBackgroundResource(R.drawable.br_rtab_background_unselected);
        this.tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.rockstargames.gtacr.BrAudioDialog.1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                View childAt3 = ((ViewGroup) BrAudioDialog.this.tabLayout.getChildAt(0)).getChildAt(0);
                View childAt4 = ((ViewGroup) BrAudioDialog.this.tabLayout.getChildAt(0)).getChildAt(1);
                if (position == 0) {
                    childAt3.setBackgroundResource(R.drawable.br_ltab_background_selected);
                    childAt4.setBackgroundResource(R.drawable.br_rtab_background_unselected);
                } else if (position == 1) {
                    childAt3.setBackgroundResource(R.drawable.br_ltab_background_unselected);
                    childAt4.setBackgroundResource(R.drawable.br_rtab_background_selected);
                }
                BrAudioDialog.this.onAudioGuiTabChanged(position);
            }
        });
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setDimAmount(0.4f);
        ((Button) inflate.findViewById(R.id.br_audio_close)).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrAudioDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BrAudioDialog.this.dismissAllowingStateLoss();
            }
        });
        return inflate;
    }

    /* JADX WARN: Type inference failed for: r15v0, types: [com.rockstargames.gtacr.BrAudioDialog$3] */
    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
        int i;
        try {
            i = json.getInt("t");
        } catch (Exception unused) {
            i = -1;
        }
        try {
            if (i == 0) {
                final int i2 = json.getInt("nu");
                final int i3 = json.getInt(TuningConstants.KEY_GET_ID_DETAIL);
                final byte b = (byte) json.getInt("b");
                final byte b2 = (byte) json.getInt("a");
                boolean z = json.getInt("e") != 0;
                final String string = json.getString("n");
                final String[] strArr = new String[i2];
                for (int i4 = 0; i4 < i2; i4++) {
                    strArr[i4] = json.getString(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL + i4);
                }
                final boolean z2 = z;
                new CountDownTimer(5000L, 250L) { // from class: com.rockstargames.gtacr.BrAudioDialog.3
                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                    }

                    @Override // android.os.CountDownTimer
                    public void onTick(long l) {
                        if (BrAudioDialog.this.viewPager != null) {
                            BrAudioFragment brAudioFragment = (BrAudioFragment) ((BrDialogVoiceAdapter) BrAudioDialog.this.viewPager.getAdapter()).getItem(0);
                            BrAudioFragment brAudioFragment2 = (BrAudioFragment) ((BrDialogVoiceAdapter) BrAudioDialog.this.viewPager.getAdapter()).getItem(1);
                            if (brAudioFragment == null || brAudioFragment2 == null || !brAudioFragment.mIsInited || !brAudioFragment2.mIsInited) {
                                return;
                            }
                            BrAudioFragment.mIsActivePlaying = b2;
                            brAudioFragment.setParametrs(i3, false, i2, b, string, z2, strArr, null);
                            brAudioFragment2.updatePlayAct();
                            cancel();
                        }
                    }
                }.start();
            }
            if (i == 1) {
                int i5 = json.getInt("nu");
                int i6 = json.getInt(TuningConstants.KEY_GET_ID_DETAIL);
                byte b3 = (byte) json.getInt("b");
                boolean z3 = json.getInt("s") != 0;
                byte b4 = (byte) json.getInt("a");
                boolean z4 = json.getInt("e") != 0;
                String string2 = json.getString("n");
                String[] strArr2 = new String[i5];
                int[] iArr = new int[i5];
                for (int i7 = 0; i7 < i5; i7++) {
                    strArr2[i7] = json.getString("m" + i7);
                }
                for (int i8 = 0; i8 < i5; i8++) {
                    iArr[i8] = json.getInt(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL + i8);
                }
                BrAudioFragment brAudioFragment = (BrAudioFragment) ((BrDialogVoiceAdapter) this.viewPager.getAdapter()).getItem(0);
                BrAudioFragment brAudioFragment2 = (BrAudioFragment) ((BrDialogVoiceAdapter) this.viewPager.getAdapter()).getItem(1);
                BrAudioFragment.mIsActivePlaying = b4;
                brAudioFragment2.setParametrs(i6, z3, i5, b3, string2, z4, strArr2, iArr);
                brAudioFragment.updatePlayAct();
            }
        } catch (Exception unused2) {
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mGUIManager = manager;
        show(activity.getSupportFragmentManager(), "dialog");
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
        dismissAllowingStateLoss();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        if (getDialog() != null) {
            return getDialog().isShowing();
        }
        return false;
    }

    public void onAudioGuiClosed() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 0);
            this.mGUIManager.sendJsonData(9, jSONObject);
        } catch (Exception unused) {
        }
    }

    public void onAudioGuiTabChanged(int tab) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 1);
            jSONObject.put("b", tab);
            this.mGUIManager.sendJsonData(9, jSONObject);
        } catch (Exception unused) {
        }
    }

    public void onAudioGuiButClicked(int tab, int but, String search) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", 2);
            jSONObject.put("a", tab);
            jSONObject.put("b", but);
            if (but == 8) {
                jSONObject.put("s", search);
            }
            this.mGUIManager.sendJsonData(9, jSONObject);
        } catch (Exception unused) {
        }
    }
}
