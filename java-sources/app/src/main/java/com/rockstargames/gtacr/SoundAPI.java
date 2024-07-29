package com.rockstargames.gtacr;

import android.content.Context;
import android.media.MediaPlayer;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class SoundAPI {
    private Context mContext;
    private HashMap<String, MediaPlayer> mPlayers = new HashMap<>();

    public void addSound(String name, int id) throws IOException {
    }

    public void playSound(String name) {
    }

    public SoundAPI(Context context) {
        this.mContext = null;
        this.mContext = context;
    }
}
