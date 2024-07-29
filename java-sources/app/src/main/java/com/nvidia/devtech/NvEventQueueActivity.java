package com.nvidia.devtech;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.exifinterface.media.ExifInterface;
import blackrussia.online.App;
import blackrussia.online.Logger;
import blackrussia.online.R;
import blackrussia.online.Settings;

import com.appsflyer.AppsFlyerLib;
//import com.crashtool.CrashTool;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.messaging.Constants;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.GameRender;
import com.rockstargames.gtacr.NotificationDialogFragment;
import com.rockstargames.gtacr.SoundAPI;
import com.rockstargames.gtacr.gui.familySystem.UIMenuMainKt;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL11;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class NvEventQueueActivity extends AppCompatActivity implements SensorEventListener {

    private static NvEventQueueActivity instance = null;
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private static final int EGL_OPENGL_ES3_BIT = 64;
    private static final int EGL_RENDERABLE_TYPE = 12352;
    private GameRender mGameRender;
    private Handler mNetworkHandler;
    private HandlerThread mNetworkHandlerThread;
    protected Handler handler = null;
    private int SwapBufferSkip = 0;
    protected boolean paused = false;
    protected boolean wantsMultitouch = false;
    protected boolean supportPauseResume = true;
    protected boolean ResumeEventDone = false;
    protected boolean wantsAccelerometer = false;
    protected SensorManager mSensorManager = null;
    protected ClipboardManager mClipboardManager = null;
    protected int mSensorDelay = 1;
    protected Display display = null;
    EGL10 egl = null;
    GL11 gl = null;
    private boolean ranInit = false;
    protected EGLSurface eglSurface = null;
    protected EGLDisplay eglDisplay = null;
    protected EGLContext eglContext = null;
    protected EGLConfig eglConfig = null;
    protected SurfaceHolder cachedSurfaceHolder = null;
    private int surfaceWidth = 0;
    private int surfaceHeight = 0;
    public GUIManager mGuiManager = null;
    private SoundAPI mSoundAPI = null;
    private int fixedWidth = 0;
    private int fixedHeight = 0;
    private boolean HasGLExtensions = false;
    private String glVendor = null;
    private String glExtensions = null;
    private String glRenderer = null;
    private String glVersion = null;
    private boolean GameIsFocused = false;
    private boolean viewIsActive = false;
    private FrameLayout mRootFrame = null;
    private SurfaceView mSurfaceView = null;
    private boolean savedInstanceStateDone = true;
    private int mUseFullscreen = 0;
    protected int redSize = 8;
    protected int greenSize = 8;
    protected int blueSize = 8;
    protected int alphaSize = 0;
    protected int stencilSize = 8;
    protected int depthSize = 24;
    protected int[] configAttrs = null;
    protected int[] contextAttrs = null;
    public boolean isSupportFingerPrint = false;
    private int currServer = -1;

    private native void onNativeHeightChanged(int orientation, int height);

    public native boolean accelerometerEvent(float values0, float values1, float values2);

    public native void changeConnection(boolean z);

    public native void cleanup();

    public native boolean customMultiTouchEvent(int action, int count, int x1, int y1, int x2, int y2, int x3, int y3);

    public native int getCurrentVolume();

    public native int getLastServer();

    public native byte[] getMutedPlayersNative();

    public native int getPlayerId();

    public native int getPlayerVehicleType();

    public native int getPlayerVolume(int id);

    public native int getVoiceDuration();

    public native void imeClosed();

    public native boolean init(boolean z);

    public native void initSAMP(long mem, int sdkInt);
    public native void initPluginBr();

    public native boolean isShowingVoiceList();

    public native boolean isWorkingVoice();

    public native boolean keyEvent(int action, int keycode, int unicodeChar, int metaState, KeyEvent event);

    public native void lowMemoryEvent();

    public native boolean multiTouchEvent(int i, int i2, int i3, int i4, int i5, int i6, MotionEvent motionEvent);
    public native boolean multiTouchEvent4(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, MotionEvent motionEvent);

    public native void mutePlayer(int id);

    public native void notifyChange(String str, int i);

    public native void nvAcquireTimeExtension();

    public native long nvGetSystemTime();

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public native void onEventBackPressed();

    public native void pauseEvent();

    public native void postCleanup();

    public native boolean processTouchpadAsPointer(ViewParent viewParent, boolean z);

    public native void quitAndWait();

    public native void resumeEvent();
    public native void sendDialogResponse(int i, int i2, int i3, byte[] str);
    public native void sendHudResponse(int i);

    public native void sendGraphicSettingsResponse(int wLvl, int crLvl, int ddLvl);
    public native void sendJsonData(int guiid, byte[] data);
    public native void sendJsonData1(int guiid, int a1, int a2, int a3, byte[] a4);

    public native void sendRegerdsJsonData(int gID, byte[] b);

    public native int setCurrentVolume(int volume);

    public native void setPlayerVolume(int id, int value);

    public native void setShowingClipboardHint(int show);

    public native void setShowingVoiceList(boolean b);

    public native void setVoiceDuration(int value);

    public native void setWindowSize(int w, int h);

    public native void setWorkingVoice(boolean b);

    public native void toggleDrawing2dStuff(boolean toggle);
    public native void setDraw2dStuff();

    public native boolean touchEvent(int action, int x, int y, MotionEvent event);

    public native void unMutePlayerByInternalid(int id);

    public FrameLayout getParentLayout() {
        return this.mRootFrame;
    }

    public void setFixedSize(int fw, int fh) {
        this.fixedWidth = fw;
        this.fixedHeight = fh;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.savedInstanceStateDone = true;
    }

    public boolean isSavedInstanceStateDone() {
        return this.savedInstanceStateDone;
    }

    @Override
    public void onBackPressed() {
        GUIManager gUIManager = this.mGuiManager;
        if (gUIManager == null || !gUIManager.isShowingGui()) {
            super.onBackPressed();
            onEventBackPressed();
        }
    }

    public void setUseFullscreen(int b) {
        this.mUseFullscreen = b;
    }

    public void hideSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(7942);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean onTouchEvent = super.onTouchEvent(event);
        if (onTouchEvent) {
            return onTouchEvent;
        }
        if (this.wantsMultitouch) {
            int pointerCount = event.getPointerCount();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < pointerCount; i7++) {
                int pointerId = event.getPointerId(i7);
                if (pointerId == 0) {
                    i = (int) event.getX(i7);
                    i2 = (int) event.getY(i7);
                } else if (pointerId == 1) {
                    i3 = (int) event.getX(i7);
                    i4 = (int) event.getY(i7);
                } else if (pointerId == 2) {
                    i5 = (int) event.getX(i7);
                    i6 = (int) event.getY(i7);
                }
            }
            customMultiTouchEvent(event.getActionMasked(), event.getPointerId(event.getActionIndex()), i, i2, i3, i4, i5, i6);
            return onTouchEvent;
        }
        return touchEvent(event.getAction(), (int) event.getX(), (int) event.getY(), event);
    }



    public class RawData {
        public byte[] data;
        public int length;

        public RawData() {
            //NvEventQueueActivity.this = this$0;
        }
    }

    public class RawTexture extends RawData {
        public int height;
        public int width;

        public RawTexture() {
            super();
            //NvEventQueueActivity.this = this$0;
        }
    }

    public RawData loadFile(String filename)
    {
        InputStream is = null;
        RawData ret = new RawData();
        try {
            try
            {
                is = new FileInputStream("/data/" + filename);
            }
            catch (Exception e)
            {
                try
                {
                    is = getAssets().open(filename);
                }
                catch (Exception e2)
                {
                }
            }
            int size = is.available();
            ret.length = size;
            ret.data = new byte[size];
            is.read(ret.data);
        }
        catch (IOException ioe)
        {
        }
        finally
        {
            if (is != null)
            {
                try { is.close(); } catch (Exception e) {}
            }
        }
        return ret;
    }

    public RawTexture loadTexture(String filename) {
        InputStream inputStream;
        RawTexture rawTexture = new RawTexture();
        try {
            try {
                inputStream = new FileInputStream("/data/" + filename);
            } catch (Exception unused) {
                inputStream = null;
            }
        } catch (Exception unused2) {
            try {
                inputStream = getAssets().open(filename);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            rawTexture.width = decodeStream.getWidth();
            rawTexture.height = decodeStream.getHeight();
            int width = decodeStream.getWidth() * decodeStream.getHeight();
            int[] iArr = new int[width];
            decodeStream.getPixels(iArr, 0, decodeStream.getWidth(), 0, 0, decodeStream.getWidth(), decodeStream.getHeight());
            int[] iArr2 = new int[decodeStream.getWidth()];
            int width2 = decodeStream.getWidth();
            int height = decodeStream.getHeight();
            for (int i = 0; i < (height >> 1); i++) {
                int i2 = i * width2;
                System.arraycopy(iArr, i2, iArr2, 0, width2);
                int i3 = ((height - 1) - i) * width2;
                System.arraycopy(iArr, i3, iArr, i2, width2);
                System.arraycopy(iArr2, 0, iArr, i3, width2);
            }
            rawTexture.length = width * 4;
            rawTexture.data = new byte[rawTexture.length];
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < height; i6++) {
                int i7 = 0;
                while (i7 < width2) {
                    int i8 = iArr[i4];
                    int i9 = i5 + 1;
                    rawTexture.data[i5] = (byte) ((i8 >> 16) & 255);
                    int i10 = i9 + 1;
                    rawTexture.data[i9] = (byte) ((i8 >> 8) & 255);
                    int i11 = i10 + 1;
                    rawTexture.data[i10] = (byte) ((i8 >> 0) & 255);
                    int i12 = i11 + 1;
                    rawTexture.data[i11] = (byte) ((i8 >> 24) & 255);
                    i7++;
                    i4++;
                    i5 = i12;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rawTexture;
    }

    public GameRender getGameRender() {
        return this.mGameRender;
    }

    public SoundAPI getSoundApi() {
        return this.mSoundAPI;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        NvUtil.getInstance().setActivity(this);
        Logger.i("**** onCreate");
        super.onCreate(savedInstanceState);
        instance = this;
        AppCompatDelegate.setDefaultNightMode(1);
        //CrashTool.launchMemoryMonitor();
        HandlerThread handlerThread = new HandlerThread("NetworkHandler");
        this.mNetworkHandlerThread = handlerThread;
        handlerThread.start();
        this.mNetworkHandler = new Handler(this.mNetworkHandlerThread.getLooper());
        File file = new File(NvUtil.getInstance().getAppLocalValue("STORAGE_ROOT") + "SAMP/donstsend.c");
        if (file.exists()) {
            try {
                Scanner scanner = new Scanner(file);
                if (scanner.hasNextLine()) {
                    showCrashDialog(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            file.delete();
            return;
        }
        AppsFlyerLib.getInstance().init("dBuYqCcyG2QQZrfGbZHLuN", null, this);
        AppsFlyerLib.getInstance().start(this);
        this.mGuiManager = new GUIManager(this);
        SoundAPI soundAPI = new SoundAPI(this);
        this.mSoundAPI = soundAPI;
        try {
            soundAPI.addSound("donate_click_close_sfx", R.raw.donate_click_close_sfx);
            this.mSoundAPI.addSound("donate_click_back_sfx", R.raw.donate_click_back_sfx);
            this.mSoundAPI.addSound("donate_click_in_or_next_sfx", R.raw.donate_click_in_or_next_sfx);
            this.mSoundAPI.addSound("donate_error_sfx", R.raw.donate_error_sfx);
            this.mSoundAPI.addSound("donate_pop_up_sfx", R.raw.donate_pop_up_sfx);
            this.mSoundAPI.addSound("donate_success_sfx", R.raw.donate_success_sfx);
            this.mSoundAPI.addSound("donate_success_scr_sfx", R.raw.donate_success_scr_sfx);
        } catch (Exception unused) {
        }
        if (this.supportPauseResume) {
            Logger.i("Calling init(false)");
            init(false);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) getSystemService("activity")).getMemoryInfo(memoryInfo);
            initSAMP(memoryInfo.totalMem, Build.VERSION.SDK_INT);
            initPluginBr();
            Logger.i("Called");
        }
        this.mGameRender = new GameRender(this);
        try {
            ((ConnectivityManager) getSystemService("connectivity")).setNetworkPreference(1);
        } catch (Exception unused2) {
        }
        this.handler = new Handler();
        if (this.wantsAccelerometer && this.mSensorManager == null) {
            this.mSensorManager = (SensorManager) getSystemService("sensor");
        }
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        this.mClipboardManager = clipboardManager;
        clipboardManager.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
            @Override
            public void onPrimaryClipChanged() {
                ClipData.Item itemAt;
                if (NvEventQueueActivity.this.mClipboardManager.getPrimaryClip() != null && (itemAt = NvEventQueueActivity.this.mClipboardManager.getPrimaryClip().getItemAt(0)) != null && itemAt.getText() != null) {
                    NvEventQueueActivity.this.setShowingClipboardHint(1);
                } else {
                    NvEventQueueActivity.this.setShowingClipboardHint(0);
                }
            }
        });
        NvAPKFileHelper.getInstance().setContext(this);
        this.display = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        getWindow().addFlags(1024);
        setRequestedOrientation(6);
        systemInit();
        hideSystemUI();
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if ((i & 4) == 0) {
                    NvEventQueueActivity.this.hideSystemUI();
                }
            }
        });
        Logger.i("Manufacturer " + Build.MANUFACTURER);
        Logger.i("Model " + Build.MODEL);
        Logger.i("Device " + Build.PRODUCT);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("o", 1);
            this.mGuiManager.onPacketIncoming(11, jSONObject);
        } catch (Exception unused3) {
        }
        isFingerprintSupported();
    }

    public static void fixEditTextForAndroid10Xiaomi(EditText editText) {
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") && Build.VERSION.SDK_INT == 29) {
            editText.setCursorVisible(false);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (getSupportFragmentManager().findFragmentByTag("dialog") != null) {
            super.onWindowFocusChanged(hasFocus);
            return;
        }
        /*if(mInputManager != null)
        {
            if(!mInputManager.IsShowing())
            {
                pauseEvent();
            }
        }
        else
        {
            pauseEvent();
        }*/
        GUIManager gUIManager = this.mGuiManager;
        if (gUIManager != null && gUIManager.isShowingGui()) {
            super.onWindowFocusChanged(hasFocus);
            return;
        }
        if (this.ResumeEventDone && this.viewIsActive && !this.paused) {
            boolean z = this.GameIsFocused;
            if (z && !hasFocus) {
                Logger.i("*** onWindowFocusChanged pauseEvent entering");
                pauseEvent();
                Logger.i("*** onWindowFocusChanged pauseEvent executed");
            } else if (!z && hasFocus) {
                Logger.i("*** onWindowFocusChanged resumeEvent entering");
                resumeEvent();
                Logger.i("*** onWindowFocusChanged resumeEvent executed");
            }
            this.GameIsFocused = hasFocus;
        }
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    @Override
    public void onResume() {
        Logger.i("**** onResume");
        super.onResume();
        hideSystemUI();
        this.savedInstanceStateDone = false;
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.registerListener(this, sensorManager.getDefaultSensor(1), this.mSensorDelay);
        }
        this.paused = false;
        if (this.viewIsActive && this.ResumeEventDone) {
            Logger.i("*** onResume resumeEvent entering");
            resumeEvent();
            Logger.i("*** onResume resumeEvent executed");
            SurfaceHolder surfaceHolder = this.cachedSurfaceHolder;
            if (surfaceHolder != null) {
                surfaceHolder.setKeepScreenOn(true);
            }
        }
    }

    @Override
    public void onRestart() {
        Logger.i("**** onRestart");
        super.onRestart();
    }

    @Override
    public void onPause() {
        Logger.i("**** onPause");
        super.onPause();
        this.paused = true;
        if (this.ResumeEventDone) {
            Logger.i("java is invoking pauseEvent(), this will block until\nthe client calls NVEventPauseProcessed");
            pauseEvent();
            Logger.i("pauseEvent() returned");
        }
    }

    @Override
    public void onStop() {
        Logger.i("**** onStop");
        SensorManager sensorManager = this.mSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Logger.i("**** onDestroy");
        if (this.supportPauseResume) {
            quitAndWait();
            finish();
        }
        super.onDestroy();
        systemCleanup();
    }

    public void mSleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException unused) {
        }
    }

    public void DoResumeEvent() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (NvEventQueueActivity.this.cachedSurfaceHolder == null) {
                    NvEventQueueActivity.this.mSleep(1000L);
                }
                Logger.i("Call from DoResumeEvent");
                NvEventQueueActivity.this.resumeEvent();
                Logger.i("DoResumeEvent done");
                NvEventQueueActivity.this.ResumeEventDone = true;
            }
        }).start();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float f;
        if (event.sensor.getType() == 1) {
            int rotation = this.display.getRotation();
            float f2 = 0.0f;
            if (rotation == 0) {
                f2 = -event.values[0];
                f = event.values[1];
            } else if (rotation == 1) {
                f2 = event.values[1];
                f = event.values[0];
            } else if (rotation == 2) {
                f2 = event.values[0];
                f = event.values[1];
            } else if (rotation != 3) {
                f = 0.0f;
            } else {
                f2 = -event.values[1];
                f = event.values[0];
            }
            accelerometerEvent(f2, f, event.values[2]);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 24 || keyCode == 25) {
            return super.onKeyDown(keyCode, event);
        }
        if (keyCode == 89 || keyCode == 85 || keyCode == 90) {
            return false;
        }
        boolean onKeyDown = (keyCode == 82 || keyCode == 4) ? false : super.onKeyDown(keyCode, event);
        if (onKeyDown) {
            return onKeyDown;
        }
        GUIManager gUIManager = this.mGuiManager;
        if (gUIManager == null || !gUIManager.isShowingGui()) {
            return keyEvent(event.getAction(), keyCode, event.getUnicodeChar(), event.getMetaState(), event);
        }
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == 115 && Build.VERSION.SDK_INT >= 11) {
            keyEvent(event.isCapsLockOn() ? 3 : 4, 115, 0, 0, event);
        }
        if (keyCode == 89 || keyCode == 85 || keyCode == 90) {
            return false;
        }
        boolean onKeyUp = super.onKeyUp(keyCode, event);
        if (onKeyUp) {
            return onKeyUp;
        }
        GUIManager gUIManager = this.mGuiManager;
        if (gUIManager == null || !gUIManager.isShowingGui()) {
            return keyEvent(event.getAction(), keyCode, event.getUnicodeChar(), event.getMetaState(), event);
        }
        return false;
    }

    public boolean InitEGLAndGLES2(int i) {
        try {
            Logger.i("lnitEGLAndGLES2");
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            Logger.e(stringWriter.toString());
            e.printStackTrace();
        }
        if (this.cachedSurfaceHolder == null) {
            Logger.e("InitEGLAndGLES2 failed, cachedSurfaceHoIder is null");
            return false;
        }
        if (this.eglContext == null ? initEGL() : true) {
            Logger.i("Should we create a surface?");
            if (!this.viewIsActive) {
                Logger.i("Yes! Calling create surface");
                createEGLSurface(this.cachedSurfaceHolder);
                Logger.i("Done creating surface");
            }
            this.viewIsActive = true;
            this.SwapBufferSkip = 1;
            return true;
        }
        Logger.e("initEGlAndGLES2 failed, core EGL init failure");
        return false;
    }

    protected boolean systemInit() {
        Logger.i("ln systemInit");
        setContentView(R.layout.main_render_screen);
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.main_surface);
        this.mSurfaceView = surfaceView;
        this.mRootFrame = (FrameLayout) findViewById(R.id.main_root);
        SurfaceHolder holder = surfaceView.getHolder();
        holder.setType(2);
        holder.setKeepScreenOn(true);
        surfaceView.setFocusable(true);
        surfaceView.setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 24) {
            getWindow().setSustainedPerformanceMode(true);
        }
        DoResumeEvent();
        holder.addCallback(new AnonymousClass4(this));
        return true;
    }



    public class AnonymousClass4 implements SurfaceHolder.Callback {
        final NvEventQueueActivity val$act;

        AnonymousClass4(final NvEventQueueActivity val$act) {
            //NvEventQueueActivity.this = this$0;
            this.val$act = val$act;
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            Logger.i("systemInit.surfaceCreated");
            boolean z = NvEventQueueActivity.this.cachedSurfaceHolder == null;
            NvEventQueueActivity.this.cachedSurfaceHolder = holder;
            if (NvEventQueueActivity.this.fixedWidth != 0 && NvEventQueueActivity.this.fixedHeight != 0) {
                Logger.i("Setting fixed window size");
                holder.setFixedSize(NvEventQueueActivity.this.fixedWidth, NvEventQueueActivity.this.fixedHeight);
            }
            NvEventQueueActivity.this.ranInit = true;
            if (!NvEventQueueActivity.this.supportPauseResume && !NvEventQueueActivity.this.init(true)) {
                NvEventQueueActivity.this.handler.post(new Runnable() {
                    @Override
                    public void run() {
                        new AlertDialog.Builder(AnonymousClass4.this.val$act).setMessage("Application initialization failed. The application will exit.").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface i, int a) {
                                NvEventQueueActivity.this.finish();
                            }
                        }).setCancelable(false).show();
                    }
                });
            }
            if (!z && NvEventQueueActivity.this.ResumeEventDone) {
                Logger.i("entering resumeEvent");
                NvEventQueueActivity.this.resumeEvent();
                Logger.i("returned from resumeEvent");
            }
            NvEventQueueActivity nvEventQueueActivity = NvEventQueueActivity.this;
            nvEventQueueActivity.setWindowSize(nvEventQueueActivity.surfaceWidth, NvEventQueueActivity.this.surfaceHeight);
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            Logger.i("Surface changed: " + width + ", " + height);
            NvEventQueueActivity.this.surfaceWidth = width;
            NvEventQueueActivity.this.surfaceHeight = height;
            NvEventQueueActivity nvEventQueueActivity = NvEventQueueActivity.this;
            nvEventQueueActivity.setWindowSize(nvEventQueueActivity.surfaceWidth, NvEventQueueActivity.this.surfaceHeight);
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            Logger.i("systemInit.surfaceDestroyed");
            NvEventQueueActivity.this.viewIsActive = false;
            NvEventQueueActivity.this.pauseEvent();
            Logger.i("systemInit.surfaceDestroyed paused");
            NvEventQueueActivity.this.destroyEGLSurface();
            Logger.i("systemInit.surfaceDestroyed executed");
        }
    }

    protected boolean initEGL() {
        int eglGetError;
        boolean z;
        int[] iArr;
        int i = 1;
        if (this.configAttrs == null) {
            this.configAttrs = new int[]{12344};
        }
        int[] iArr2 = this.configAttrs;
        this.configAttrs = new int[(iArr2.length + 3) - 1];
        int i2 = 0;
        while (i2 < iArr2.length - 1) {
            this.configAttrs[i2] = iArr2[i2];
            i2++;
        }
        int[] iArr3 = this.configAttrs;
        int i3 = i2 + 1;
        iArr3[i2] = EGL_RENDERABLE_TYPE;
        iArr3[i3] = 4;
        iArr3[i3 + 1] = 12344;
        this.contextAttrs = new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
        if (iArr3 == null) {
            this.configAttrs = new int[]{12344};
        }
        int[] iArr4 = this.configAttrs;
        this.configAttrs = new int[(iArr4.length + 13) - 1];
        int i4 = 0;
        while (i4 < iArr4.length - 1) {
            this.configAttrs[i4] = iArr4[i4];
            i4++;
        }
        int[] iArr5 = this.configAttrs;
        int i5 = i4 + 1;
        int i6 = 12324;
        iArr5[i4] = 12324;
        int i7 = i5 + 1;
        iArr5[i5] = this.redSize;
        int i8 = i7 + 1;
        int i9 = 12323;
        iArr5[i7] = 12323;
        int i10 = i8 + 1;
        iArr5[i8] = this.greenSize;
        int i11 = i10 + 1;
        iArr5[i10] = 12322;
        int i12 = i11 + 1;
        iArr5[i11] = this.blueSize;
        int i13 = i12 + 1;
        iArr5[i12] = 12321;
        int i14 = i13 + 1;
        iArr5[i13] = this.alphaSize;
        int i15 = i14 + 1;
        iArr5[i14] = 12326;
        int i16 = i15 + 1;
        iArr5[i15] = this.stencilSize;
        int i17 = i16 + 1;
        iArr5[i16] = 12325;
        iArr5[i17] = this.depthSize;
        iArr5[i17 + 1] = 12344;
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.egl = egl10;
        egl10.eglGetError();
        this.eglDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        Logger.i("eglDisplay: " + this.eglDisplay + ", errr: " + this.egl.eglGetError());
        boolean eglInitialize = this.egl.eglInitialize(this.eglDisplay, new int[2]);
        StringBuilder sb = new StringBuilder();
        sb.append("EGLInitialize returned: ");
        sb.append(eglInitialize);
        Logger.i(sb.toString());
        if (eglInitialize && (eglGetError = this.egl.eglGetError()) == 12288) {
            Logger.i("eglInitialize err: " + eglGetError);
            EGLConfig[] eGLConfigArr = new EGLConfig[30];
            int[] iArr6 = new int[1];
            this.egl.eglChooseConfig(this.eglDisplay, this.configAttrs, eGLConfigArr, 30, iArr6);
            Logger.i("eglChooseConfig err: " + this.egl.eglGetError());
            int i18 = 16777216;
            int[] iArr7 = new int[1];
            int i19 = 0;
            while (i19 < iArr6[0]) {
                int i20 = 0;
                while (true) {
                    if (i20 >= ((iArr2.length - i) >> i)) {
                        z = true;
                        break;
                    }
                    int i21 = i20 * 2;
                    this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i19], this.configAttrs[i21], iArr7);
                    int i22 = iArr7[0];
                    int[] iArr8 = this.configAttrs;
                    int i23 = i21 + 1;
                    if ((i22 & iArr8[i23]) != iArr8[i23]) {
                        z = false;
                        break;
                    }
                    i20++;
                }
                if (z) {
                    this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i19], i6, iArr7);
                    int i24 = iArr7[0];
                    this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i19], i9, iArr7);
                    int i25 = iArr7[0];
                    this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i19], 12322, iArr7);
                    int i26 = iArr7[0];
                    this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i19], 12321, iArr7);
                    int i27 = iArr7[0];
                    this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i19], 12325, iArr7);
                    int i28 = iArr7[0];
                    iArr = iArr2;
                    this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i19], 12326, iArr7);
                    int i29 = iArr7[0];
                    Logger.i(">>> EGL Config [" + i19 + "] R" + i24 + "G" + i25 + "B" + i26 + ExifInterface.GPS_MEASUREMENT_IN_PROGRESS + i27 + " D" + i28 + ExifInterface.LATITUDE_SOUTH + i29);
                    int abs = ((((Math.abs(i24 - this.redSize) + Math.abs(i25 - this.greenSize)) + Math.abs(i26 - this.blueSize)) + Math.abs(i27 - this.alphaSize)) << 16) + (Math.abs(i28 - this.depthSize) << 8) + Math.abs(i29 - this.stencilSize);
                    if (abs < i18) {
                        Logger.i("--------------------------");
                        Logger.i("New config chosen: " + i19);
                        int i30 = 0;
                        while (true) {
                            int[] iArr9 = this.configAttrs;
                            if (i30 >= ((iArr9.length - 1) >> 1)) {
                                break;
                            }
                            int i31 = i30 * 2;
                            this.egl.eglGetConfigAttrib(this.eglDisplay, eGLConfigArr[i19], iArr9[i31], iArr7);
                            if (iArr7[0] >= this.configAttrs[i31 + 1]) {
                                Logger.i("setting " + i30 + ", matches: " + iArr7[0]);
                            }
                            i30++;
                        }
                        this.eglConfig = eGLConfigArr[i19];
                        i18 = abs;
                    }
                } else {
                    iArr = iArr2;
                }
                i19++;
                iArr2 = iArr;
                i = 1;
                i6 = 12324;
                i9 = 12323;
            }
            this.eglContext = this.egl.eglCreateContext(this.eglDisplay, this.eglConfig, EGL10.EGL_NO_CONTEXT, this.contextAttrs);
            Logger.i("eglCreateContext: " + this.egl.eglGetError());
            this.gl = (GL11) this.eglContext.getGL();
            return true;
        }
        return false;
    }

    protected boolean createEGLSurface(SurfaceHolder surface) {
        this.eglSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, surface, null);
        Logger.i("eglCreateWindowSurface err: " + this.egl.eglGetError());
        int[] iArr = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, iArr);
        this.surfaceWidth = iArr[0];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, iArr);
        this.surfaceHeight = iArr[0];
        Logger.i("checking glVendor == null?");
        if (this.glVendor == null) {
            Logger.w("Making current and back");
            makeCurrent();
            unMakeCurrent();
        }
        Logger.i("Done create EGL surface");
        return true;
    }

    protected void destroyEGLSurface() {
        Logger.i("*** destroyEGLSurface");
        if (this.eglDisplay != null && this.eglSurface != null) {
            unMakeCurrent();
        }
        Logger.i("*** destroyEGLSurface unmade current");
        EGLSurface eGLSurface = this.eglSurface;
        if (eGLSurface != null) {
            this.egl.eglDestroySurface(this.eglDisplay, eGLSurface);
        }
        Logger.i("*** destroyEGLSurface destroyed surface");
        this.eglSurface = null;
    }

    protected void cleanupEGL() {
        Logger.i("cleanupEGL");
        destroyEGLSurface();
        if (this.eglDisplay != null) {
            unMakeCurrent();
        }
        Logger.i("* making current surface");
        EGLContext eGLContext = this.eglContext;
        if (eGLContext != null) {
            this.egl.eglDestroyContext(this.eglDisplay, eGLContext);
        }
        Logger.i("* destroying surface");
        EGLDisplay eGLDisplay = this.eglDisplay;
        if (eGLDisplay != null) {
            this.egl.eglTerminate(eGLDisplay);
        }
        Logger.i("* terminate egl");
        this.eglDisplay = null;
        this.eglContext = null;
        this.eglSurface = null;
        this.ranInit = false;
        this.eglConfig = null;
        this.cachedSurfaceHolder = null;
        this.surfaceWidth = 0;
        this.surfaceHeight = 0;
    }

    public boolean swapBuffers() {
        int i = this.SwapBufferSkip;
        if (i > 0) {
            this.SwapBufferSkip = i - 1;
            Logger.w("swapBuffer wait");
            return true;
        }
        EGLSurface eGLSurface = this.eglSurface;
        if (eGLSurface == null) {
            Logger.e("eglSurface is NULL");
            return false;
        } else if (this.egl.eglSwapBuffers(this.eglDisplay, eGLSurface)) {
            return true;
        } else {
            Logger.e("eglSwapBufferrr: " + this.egl.eglGetError());
            return false;
        }
    }

    public boolean getSupportPauseResume() {
        return this.supportPauseResume;
    }

    public int getSurfaceWidth() {
        return this.surfaceWidth;
    }

    public int getSurfaceHeight() {
        return this.surfaceHeight;
    }

    public void GetGLExtensions() {
        GL11 gl11;
        if (this.HasGLExtensions || (gl11 = this.gl) == null || this.cachedSurfaceHolder == null) {
            return;
        }
        this.glVendor = gl11.glGetString(7936);
        this.glExtensions = this.gl.glGetString(7939);
        this.glRenderer = this.gl.glGetString(7937);
        this.glVersion = this.gl.glGetString(7938);
        Logger.i("Vendor: " + this.glVendor);
        Logger.i("Extensions " + this.glExtensions);
        Logger.i("Renderer: " + this.glRenderer);
        Logger.i("GLVersion: " + this.glVersion);
        FirebaseCrashlytics.getInstance().setCustomKey("Vendor", this.glVendor);
        FirebaseCrashlytics.getInstance().setCustomKey("Renderer", this.glRenderer);
        if (this.glVendor != null) {
            this.HasGLExtensions = true;
        }
    }

    public boolean makeCurrent() {
        EGLContext eGLContext = this.eglContext;
        if (eGLContext == null) {
            Logger.e("eglContext is NULL");
            return false;
        }
        EGLSurface eGLSurface = this.eglSurface;
        if (eGLSurface == null) {
            Logger.e("eglSurface is NULL");
            return false;
        }
        if (!this.egl.eglMakeCurrent(this.eglDisplay, eGLSurface, eGLSurface, eGLContext)) {
            EGL10 egl10 = this.egl;
            EGLDisplay eGLDisplay = this.eglDisplay;
            EGLSurface eGLSurface2 = this.eglSurface;
            if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.eglContext)) {
                Logger.e("eglMakeCurrent err: " + this.egl.eglGetError());
                return false;
            }
        }
        GetGLExtensions();
        return true;
    }

    public int getOrientation() {
        return this.display.getOrientation();
    }

    public boolean unMakeCurrent() {
        if (this.egl.eglMakeCurrent(this.eglDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT)) {
            return true;
        }
        Logger.e("egl(Un)MakeCurrent err: " + this.egl.eglGetError());
        return false;
    }

    protected void systemCleanup() {
        if (this.ranInit) {
            cleanup();
        }
        cleanupEGL();
        System.exit(0);
    }

    public String[] getMutedPlayers() {
        byte[] mutedPlayersNative = getMutedPlayersNative();
        if (mutedPlayersNative == null) {
            return null;
        }
        try {
            return new String(mutedPlayersNative, "windows-1251").split(Pattern.quote("|"));
        } catch (Exception unused) {
            return null;
        }
    }

    public void sendGetRequest(byte[] url) {
        String str;
        try {
            str = new String(url, "windows-1251");
        } catch (UnsupportedEncodingException unused) {
            str = null;
        }
        if (str != null) {
            final String str2 = "http://" + str + "/";
            this.mNetworkHandler.post(new Runnable() {
                @Override
                public void run() {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                        httpURLConnection.addRequestProperty("User-Agent", "MOl9ISIvsVFgqqVgDIBp");
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(UIMenuMainKt.MENU_MAIN_MIN_TIMER);
                        httpURLConnection.connect();
                        httpURLConnection.getResponseCode();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void showCrashDialog(final String info) {
        if (isSavedInstanceStateDone()) {
            return;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new NotificationDialogFragment(info).show(NvEventQueueActivity.this.getSupportFragmentManager(), "alert");
            }
        });
    }

    public static int dpToPx(float dp, Context context) {
        return (int) TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
    }

    public void showInputLayout()
    {

    }

    public void hideInputLayout()
    {

    }

    public byte[] getClipboardString() {
        ClipData.Item itemAt;
        CharSequence text;
        try {
            return ((this.mClipboardManager.getPrimaryClip() == null || (itemAt = this.mClipboardManager.getPrimaryClip().getItemAt(0)) == null || (text = itemAt.getText()) == null) ? "nullstr" : text.toString()).getBytes("windows-1251");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public void onJsonDataIncoming(final int guiid, byte[] data) {
        String str;
        try {
            str = new String(data, "windows-1251");
        } catch (UnsupportedEncodingException unused) {
            str = null;
        }
        if (str != null) {
            try {
                final JSONObject jSONObject = new JSONObject(str);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        NvEventQueueActivity.this.mGuiManager.onPacketIncoming(guiid, jSONObject);
                    }
                });
            } catch (JSONException e) {
                Log.d("AXL", e.getMessage());
            }
        }
    }

    public void closeAllWindows() {
        this.mGuiManager.closeAllWindows();
    }

    public void closeAllWindowsExSAMP() {
        this.mGuiManager.closeAllWindowsExSAMP();
    }

    public void onTabEvent(int[] ids, byte[] nicks, int[] level, int[] ping, int event) {
        try {
            String[] split = new String(nicks, "windows-1251").split(Pattern.quote("|"));
            final JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (event == 0) {
                jSONObject.put("o", 1);
            }
            jSONObject.put("t", event);
            for (int i = 0; i < ids.length; i++) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(GetKeys.GET_PLAYERS_ID, ids[i]);
                jSONObject2.put("nick", split[i]);
                jSONObject2.put("level", level[i]);
                jSONObject2.put("ping", ping[i]);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, jSONArray);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    NvEventQueueActivity.this.mGuiManager.onPacketIncoming(25, jSONObject);
                }
            });
        } catch (Exception unused) {
        }
    }

    public boolean isShowingGUI() {
        return this.mGuiManager.isShowingGui();
    }

    private boolean isFingerprintSupported() {
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100500 && grantResults.length > 0 && grantResults[0] == 0) {
            isFingerprintSupported();
        }
    }

    public int getCurrServer() {
        return this.currServer;
    }

    public void setCurrServer(int id) {
        this.currServer = id;
    }

    public boolean isAllowedFastConnect(byte[] r7arg) {
        return true;
    }

    public String getNick() {
        String str = "";
        if (!App.isExternalStorageAvailable(this)) {
            return "";
        }
        String absolutePath = getExternalFilesDir(null).getAbsolutePath();
        try {
            Matcher matcher = Pattern.compile("name = .*", 2).matcher(readUsingBufferedReader(absolutePath.replace("blackrussia.online/files", "") + Settings.CLIENT_PACKAGE + "/files/SAMP/settings.ini"));
            String str2 = "";
            for (int i = 0; matcher.find(i); i = matcher.end()) {
                try {
                    String group = matcher.group(0);
                    try {
                        str2 = group.replaceAll("name = ", "");
                    } catch (Exception e) {
                        e = e;
                        str = group;
                        e.printStackTrace();
                        return str;
                    }
                } catch (Exception e2) {
                    //e = e2;
                    str = str2;
                }
            }
            return str2;
        } catch (Exception e3) {
            //e = e3;
        }
        return "";
    }

    String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String property = System.getProperty("line.separator");
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
                sb.append(property);
            } else {
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
        }
    }

    public boolean isPortraitOrientation() {
        return getResources().getConfiguration().orientation == 1;
    }

    public void onSpawn() {
        this.mGuiManager.onSpawn();
    }

    public byte[] getBuildTime() {
        return (" ").getBytes(StandardCharsets.UTF_8);
    }

    public byte[] getClipboardText()
    {
        String retn = " ";

        if(mClipboardManager.getPrimaryClip() != null)
        {
            ClipData.Item item = mClipboardManager.getPrimaryClip().getItemAt(0);
            if(item != null)
            {
                CharSequence sequence = item.getText();
                if(sequence != null)
                {
                    retn = sequence.toString();
                }
            }
        }

        byte[] toReturn = null;
        try
        {
            toReturn = retn.getBytes("windows-1251");
        }
        catch(UnsupportedEncodingException e)
        {

        }
        return toReturn;
    }

    public void setPauseState(boolean z2) {
        if(mSurfaceView == null){ return; }
        if(!mGuiManager.mIsPlayerSpawned){ return; }
    }

    public void crashLog(String s){
        NvUtil.appendLog(s);
    }

    public static NvEventQueueActivity getInstance(){
        return instance;
    }

}
