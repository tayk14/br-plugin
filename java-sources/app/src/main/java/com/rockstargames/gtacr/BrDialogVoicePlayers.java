package com.rockstargames.gtacr;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class BrDialogVoicePlayers extends Fragment {
    private NvEventQueueActivity mContext = null;
    private View mRootView = null;
    private ListView mListView = null;
    String[] mItems = null;
    private Button mButtonVolume = null;
    private SeekBar mBarVolume = null;
    private EditText mEditTextVolume = null;
    private Button mButtonMute = null;
    private EditText mEditTextMute = null;
    private ArrayAdapter<String> mAdapter = null;

    public static BrDialogVoicePlayers createInstance(String txt) {
        return new BrDialogVoicePlayers();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mContext = (NvEventQueueActivity) getActivity();
        View inflate = inflater.inflate(R.layout.br_voicesettings_players, container, false);
        this.mRootView = inflate;
        this.mListView = (ListView) inflate.findViewById(R.id.voice_mute_list);
        String[] mutedPlayers = this.mContext.getMutedPlayers();
        this.mItems = mutedPlayers;
        if (mutedPlayers != null) {
            this.mAdapter = new BrDialogVoiceListAdapter(this.mContext, R.layout.br_list_voice_muted, R.id.br_voice_list_name, new ArrayList(Arrays.asList(this.mItems)));
        } else {
            this.mAdapter = new BrDialogVoiceListAdapter(this.mContext, R.layout.br_list_voice_muted, R.id.br_voice_list_name, new ArrayList());
        }
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mListView.setItemsCanFocus(false);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.rockstargames.gtacr.BrDialogVoicePlayers.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                BrDialogVoicePlayers.this.mContext.unMutePlayerByInternalid(position);
                TextView textView = (TextView) view.findViewById(R.id.br_voice_list_name);
                if (textView == null || textView.getText() == null) {
                    return;
                }
                BrDialogVoicePlayers.this.mAdapter.remove(textView.getText().toString());
            }
        });
        this.mButtonVolume = (Button) this.mRootView.findViewById(R.id.br_voice_button_1);
        this.mBarVolume = (SeekBar) this.mRootView.findViewById(R.id.br_seekbar_volume_p);
        this.mEditTextVolume = (EditText) this.mRootView.findViewById(R.id.br_voice_et_1);
        this.mButtonMute = (Button) this.mRootView.findViewById(R.id.br_voice_button_2);
        this.mEditTextMute = (EditText) this.mRootView.findViewById(R.id.br_voice_et_2);
        this.mEditTextVolume.addTextChangedListener(new TextWatcher() { // from class: com.rockstargames.gtacr.BrDialogVoicePlayers.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (obj != null) {
                    try {
                        BrDialogVoicePlayers.this.mBarVolume.setProgress(BrDialogVoicePlayers.this.mContext.getPlayerVolume(Integer.parseInt(obj)));
                    } catch (Exception unused) {
                    }
                }
            }
        });
        this.mButtonMute.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogVoicePlayers.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj;
                if (BrDialogVoicePlayers.this.mEditTextMute.getText() == null || (obj = BrDialogVoicePlayers.this.mEditTextMute.getText().toString()) == null) {
                    return;
                }
                try {
                    BrDialogVoicePlayers.this.mContext.mutePlayer(Integer.parseInt(obj));
                    view.postDelayed(new Runnable() { // from class: com.rockstargames.gtacr.BrDialogVoicePlayers.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String[] mutedPlayers2 = BrDialogVoicePlayers.this.mContext.getMutedPlayers();
                            if (mutedPlayers2 != null) {
                                BrDialogVoicePlayers.this.mAdapter.clear();
                                for (String str : mutedPlayers2) {
                                    BrDialogVoicePlayers.this.mAdapter.add(str);
                                }
                            }
                        }
                    }, 100L);
                } catch (Exception unused) {
                }
            }
        });
        this.mButtonVolume.setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogVoicePlayers.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String obj;
                if (BrDialogVoicePlayers.this.mEditTextVolume.getText() == null || (obj = BrDialogVoicePlayers.this.mEditTextVolume.getText().toString()) == null) {
                    return;
                }
                try {
                    BrDialogVoicePlayers.this.mContext.setPlayerVolume(Integer.parseInt(obj), BrDialogVoicePlayers.this.mBarVolume.getProgress());
                } catch (Exception unused) {
                }
            }
        });
        return this.mRootView;
    }
}
