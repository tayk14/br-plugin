package com.rockstargames.gtacr;

import android.graphics.Bitmap;
import com.nvidia.devtech.NvEventQueueActivity;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class GameRender {
    public static final int LISTENER_TYPE_RENDER = 0;
    public static final int LISTENER_TYPE_TEXTURE = 1;
    private static float OffX = 0.0f;
    private static float OffY = 0.0f;
    private static float OffZ = 0.0f;
    public static final int RENDER_TYPE_CAR = 1;
    public static final int RENDER_TYPE_OBJECT = 0;
    public static final int RENDER_TYPE_SKIN = 2;
    private NvEventQueueActivity mActivity;
    private ArrayList<GameRenderInstance> mQueue = new ArrayList<>();

    /* loaded from: classes2.dex */
    public interface GameRenderListener {
        void OnRenderComplete(int id, byte[] buffer, long length);
    }

    /* loaded from: classes2.dex */
    public interface GameTextureListener {
        void OnTextureGet(int id, Bitmap bitmap);
    }

    private native void initJni();

    private native void nativeRequestRender(int type, int id, int modelid, int color1, int color2, float rotX, float rotY, float rotZ, float zoom, float offX, float offY, float offZ, Object listener);

    private native void nativeRequestRenderTexture(byte[] texture, int id);

    private native void nativeRequestRenderTexturePlate(int type, byte[] number, byte[] region, int id, float rotX, float rotY, float rotZ, float zoom);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class GameRenderInstance {
        int id;
        GameRenderListener listener;
        GameTextureListener listenerTexture;
        int type;

        private GameRenderInstance() {
        }
    }

    public void SetOffsets(float X, float Y, float Z) {
        OffX = X;
        OffY = Y;
        OffZ = Z;
    }

    public GameRender(NvEventQueueActivity activity) {
        this.mActivity = null;
        this.mActivity = activity;
        initJni();
    }

    public void onNativeRendered(int id, byte[] buffer, long length) {
        for (int i = 0; i < this.mQueue.size(); i++) {
            GameRenderInstance gameRenderInstance = this.mQueue.get(i);
            if (gameRenderInstance.id == id) {
                gameRenderInstance.listener.OnRenderComplete(id, buffer, length);
                this.mQueue.remove(i);
                return;
            }
        }
    }

    public void onNativeTextureSend(int id, byte[] buffer, long length, int dim, int dimh) {
        for (int i = 0; i < this.mQueue.size(); i++) {
            GameRenderInstance gameRenderInstance = this.mQueue.get(i);
            if (gameRenderInstance.id == id) {
                Bitmap createBitmap = Bitmap.createBitmap(dim, dimh, Bitmap.Config.ARGB_8888);
                createBitmap.setHasAlpha(true);
                IntBuffer asIntBuffer = ByteBuffer.wrap(buffer).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
                int[] iArr = new int[asIntBuffer.remaining()];
                asIntBuffer.get(iArr);
                createBitmap.setPixels(iArr, 0, dim, 0, 0, dim, dimh);
                gameRenderInstance.listenerTexture.OnTextureGet(id, createBitmap);
                this.mQueue.remove(i);
                return;
            }
        }
    }

    public void RequestRender(int type, int id, int modelid, int color1, int color2, float rotX, float rotY, float rotZ, float zoom, GameRenderListener listener) {
        GameRenderInstance gameRenderInstance = new GameRenderInstance();
        gameRenderInstance.id = id;
        gameRenderInstance.listener = listener;
        gameRenderInstance.type = 0;
        this.mQueue.add(gameRenderInstance);
        nativeRequestRender(type, id, modelid, color1, color2, rotX, rotY, rotZ, zoom, OffX, OffY, OffZ, listener);
        OffZ = 0.0f;
        OffY = 0.0f;
        OffX = 0.0f;
    }

    public void RequestTexture(String name, int id, GameTextureListener listener) {
        GameRenderInstance gameRenderInstance = new GameRenderInstance();
        gameRenderInstance.id = id;
        gameRenderInstance.type = 0;
        gameRenderInstance.listenerTexture = listener;
        this.mQueue.add(gameRenderInstance);
        nativeRequestRenderTexture(name.getBytes(), id);
    }

    public void RequestTexturePlate(int type, int id, String number, String region, float rotX, float rotY, float rotZ, float zoom, GameTextureListener listener) {
        GameRenderInstance gameRenderInstance = new GameRenderInstance();
        gameRenderInstance.id = id;
        gameRenderInstance.type = 1;
        gameRenderInstance.listenerTexture = listener;
        this.mQueue.add(gameRenderInstance);
        nativeRequestRenderTexturePlate(type, number.getBytes(), region.getBytes(), id, rotX, rotY, rotZ, zoom);
    }
}
