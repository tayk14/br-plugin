package com.rockstargames.gtacr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import blackrussia.online.R;
import java.util.ArrayList;

/* loaded from: classes2.dex */
class BrDialogVoiceListAdapter extends ArrayAdapter<String> {
    private LayoutInflater mInflater;

    public BrDialogVoiceListAdapter(Context context, int resource, int textViewResourceId, ArrayList<String> objects) {
        super(context, resource, textViewResourceId, objects);
        this.mInflater = null;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        BrVoiceMutedPlayer brVoiceMutedPlayer;
        if (convertView == null) {
            convertView = this.mInflater.inflate(R.layout.br_list_voice_muted, (ViewGroup) null);
            brVoiceMutedPlayer = new BrVoiceMutedPlayer();
            brVoiceMutedPlayer.textView = (TextView) convertView.findViewById(R.id.br_voice_list_name);
            brVoiceMutedPlayer.button = (TextView) convertView.findViewById(R.id.br_voice_list_btn);
            convertView.setTag(brVoiceMutedPlayer);
        } else {
            brVoiceMutedPlayer = (BrVoiceMutedPlayer) convertView.getTag();
        }
        brVoiceMutedPlayer.textView.setText(getItem(position));
        return convertView;
    }
}
