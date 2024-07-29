package com.rockstargames.gtacr;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;
import blackrussia.online.R;
import com.google.android.material.tabs.TabLayout;
import com.nvidia.devtech.NvEventQueueActivity;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogVoice extends DialogFragment implements ISAMPGUI {
    private NvEventQueueActivity mContext = null;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 0;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.br_voicesettings, (ViewGroup) null, false);
        this.tabLayout = (TabLayout) inflate.findViewById(R.id.tabLayout);
        this.viewPager = (ViewPager) inflate.findViewById(R.id.masterViewPager);
        BrDialogVoiceAdapter brDialogVoiceAdapter = new BrDialogVoiceAdapter(getChildFragmentManager(), 0);
        brDialogVoiceAdapter.addFragment("Общие", BrDialogVoiceCommon.createInstance("common"));
        brDialogVoiceAdapter.addFragment("Действия с игроками", BrDialogVoicePlayers.createInstance("colors"));
        this.viewPager.setAdapter(brDialogVoiceAdapter);
        this.tabLayout.setupWithViewPager(this.viewPager);
        this.mContext = (NvEventQueueActivity) getActivity();
        this.viewPager.setCurrentItem(0);
        View childAt = ((ViewGroup) this.tabLayout.getChildAt(0)).getChildAt(0);
        View childAt2 = ((ViewGroup) this.tabLayout.getChildAt(0)).getChildAt(1);
        childAt.setBackgroundResource(R.drawable.br_ltab_background_selected);
        childAt2.setBackgroundResource(R.drawable.br_rtab_background_unselected);
        this.tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: com.rockstargames.gtacr.BrDialogVoice.1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                View childAt3 = ((ViewGroup) BrDialogVoice.this.tabLayout.getChildAt(0)).getChildAt(0);
                View childAt4 = ((ViewGroup) BrDialogVoice.this.tabLayout.getChildAt(0)).getChildAt(1);
                if (position == 0) {
                    childAt3.setBackgroundResource(R.drawable.br_ltab_background_selected);
                    childAt4.setBackgroundResource(R.drawable.br_rtab_background_unselected);
                } else if (position == 1) {
                    childAt3.setBackgroundResource(R.drawable.br_ltab_background_unselected);
                    childAt4.setBackgroundResource(R.drawable.br_rtab_background_selected);
                }
            }
        });
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().getWindow().setDimAmount(0.4f);
        return inflate;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        show(activity.getSupportFragmentManager(), "dialog");
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
        dismissAllowingStateLoss();
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        if (getDialog() == null) {
            return false;
        }
        return getDialog().isShowing();
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogVoice();
    }
}
