package com.rockstargames.gtacr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;

/* loaded from: classes2.dex */
public class BrDialogVoiceCommon extends Fragment {
    private NvEventQueueActivity mContext = null;
    private View mRootView = null;
    private TextView mTextDuration = null;

    public static BrDialogVoiceCommon createInstance(String txt) {
        return new BrDialogVoiceCommon();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mContext = (NvEventQueueActivity) getActivity();
        this.mRootView = inflater.inflate(R.layout.br_voicesettings_common, container, false);
        final NvEventQueueActivity nvEventQueueActivity = (NvEventQueueActivity) getActivity();
        SeekBar seekBar = (SeekBar) this.mRootView.findViewById(R.id.br_voice_volume);
        seekBar.setProgress(nvEventQueueActivity.getCurrentVolume());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rockstargames.gtacr.BrDialogVoiceCommon.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int i, boolean b) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar2) {
                nvEventQueueActivity.setCurrentVolume(seekBar2.getProgress());
            }
        });
        this.mTextDuration = (TextView) this.mRootView.findViewById(R.id.br_voice_duration_text);
        SeekBar seekBar2 = (SeekBar) this.mRootView.findViewById(R.id.br_voice_duration);
        seekBar2.setProgress(nvEventQueueActivity.getVoiceDuration());
        this.mTextDuration.setText("Отключение микрофона через: " + ((seekBar2.getProgress() + 1) * 10) + " секунд");
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rockstargames.gtacr.BrDialogVoiceCommon.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar3, int i, boolean b) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar3) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar3) {
                BrDialogVoiceCommon.this.mTextDuration.setText("Отключение микрофона через: " + ((seekBar3.getProgress() + 1) * 10) + " секунд");
                nvEventQueueActivity.setVoiceDuration(seekBar3.getProgress());
            }
        });
        SwitchCompat switchCompat = (SwitchCompat) this.mRootView.findViewById(R.id.br_voice_switch_list);
        switchCompat.setChecked(nvEventQueueActivity.isShowingVoiceList());
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rockstargames.gtacr.BrDialogVoiceCommon.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                nvEventQueueActivity.setShowingVoiceList(b);
            }
        });
        SwitchCompat switchCompat2 = (SwitchCompat) this.mRootView.findViewById(R.id.br_voice_switch_onoff);
        switchCompat2.setChecked(nvEventQueueActivity.isWorkingVoice());
        switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rockstargames.gtacr.BrDialogVoiceCommon.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                nvEventQueueActivity.setWorkingVoice(b);
            }
        });
        return this.mRootView;
    }
}
