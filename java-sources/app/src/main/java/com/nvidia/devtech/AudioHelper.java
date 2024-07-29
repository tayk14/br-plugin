package com.nvidia.devtech;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.Log;
import java.io.IOException;

/* loaded from: classes2.dex */
public class AudioHelper {
    private static final int MAX_SOUND_STREAMS = 10;
    private static String ResourceLocation = "com.nvidia.devtech.audio:raw/";
    private static final String TAG = "AudioHelper";
    private static AudioHelper instance;
    private Context context = null;
    private SoundPool Sounds = null;
    private MediaPlayer MusicPlayer = null;

    private AudioHelper() {
    }

    void Initialise() {
        SoundPool soundPool = new SoundPool(10, 3, 0);
        this.Sounds = soundPool;
        if (soundPool == null) {
            Log.e(TAG, "failed to create soundpool instance");
        }
        Log.i(TAG, "created sound pool");
    }

    public void finalize() {
        SoundPool soundPool = this.Sounds;
        if (soundPool != null) {
            soundPool.release();
            this.Sounds = null;
        }
        MediaPlayer mediaPlayer = this.MusicPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.MusicPlayer = null;
        }
    }

    public void SetResouceLocation(String s) {
        ResourceLocation = s;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static AudioHelper getInstance() {
        if (instance == null) {
            AudioHelper audioHelper = new AudioHelper();
            instance = audioHelper;
            audioHelper.Initialise();
        }
        return instance;
    }

    public int LoadSound(String filename, int Priority) {
        Log.i(TAG, "Load sound " + filename);
        int identifier = this.context.getResources().getIdentifier(ResourceLocation + filename, null, null);
        if (identifier == 0) {
            Log.i(TAG, "unidentified resource id for " + filename);
            return 0;
        }
        return this.Sounds.load(this.context, identifier, Priority);
    }

    public int LoadSoundAsset(String filename, int Priority) {
        AssetFileDescriptor assetFileDescriptor;
        try {
            assetFileDescriptor = this.context.getAssets().openFd(filename);
        } catch (IOException e) {
            e.printStackTrace();
            assetFileDescriptor = null;
        }
        return this.Sounds.load(assetFileDescriptor, Priority);
    }

    public void PauseSound(int SoundID) {
        this.Sounds.pause(SoundID);
    }

    public void ResumeSound(int SoundID) {
        this.Sounds.resume(SoundID);
    }

    public void StopSound(int SoundID) {
        this.Sounds.stop(SoundID);
    }

    public int PlaySound(int SoundID, float lv, float rv, int priority, int loop, float rate) {
        return this.Sounds.play(SoundID, lv, rv, priority, loop, rate);
    }

    public void SetVolume(int SoundID, float vl, float vr) {
        this.Sounds.setVolume(SoundID, vl, vr);
    }

    public boolean UnloadSample(int SoundID) {
        return this.Sounds.unload(SoundID);
    }

    public void MusicSetDataSource(String filename) {
        try {
            int identifier = this.context.getResources().getIdentifier(ResourceLocation + filename, null, null);
            if (identifier == 0) {
                Log.i(TAG, "unidentified resource id for " + filename);
                return;
            }
            MediaPlayer create = MediaPlayer.create(this.context, identifier);
            this.MusicPlayer = create;
            if (create == null) {
                Log.i(TAG, "failed to create music player" + filename);
                return;
            }
            create.start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    public void MusicStart() {
        this.MusicPlayer.start();
    }

    public void MusicVolume(float VolumeL, float VolumeR) {
        this.MusicPlayer.setVolume(VolumeL, VolumeR);
    }

    void SetMaxVolume() {
        AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
        audioManager.setStreamVolume(3, audioManager.getStreamMaxVolume(3), 0);
    }

    public void MusicStop() {
        MediaPlayer mediaPlayer = this.MusicPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.MusicPlayer.stop();
        this.MusicPlayer.reset();
    }
}
