package blackrussia.online.activities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.Html;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.Downloader;
import blackrussia.online.Logger;
import blackrussia.online.Preferences;
import blackrussia.online.R;
import blackrussia.online.Settings;
import blackrussia.online.Utils;
import blackrussia.online.adapters.ChooseServerAdapter;
import blackrussia.online.fragments.DonateFragment;
import blackrussia.online.fragments.MonitoringFragment;
import blackrussia.online.fragments.RouletteFragment;
import blackrussia.online.fragments.SettingsFragment;
import blackrussia.online.network.ApiService;
import blackrussia.online.network.DataService;
import blackrussia.online.network.MyFile;
import blackrussia.online.network.Server;
import com.crashtool.CrashTool;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.rockstargames.gtacr.GTASA;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes.dex */
public class MainActivity extends AppCompatActivity implements GLSurfaceView.Renderer {
    private ChooseServerAdapter chooseServerAdapter;
    private int connectCount = 0;
    private LinearLayout donateButton;
    private DonateFragment donateFragment;
    private ImageView donateImage;
    private TextView donateTV;
    private GLSurfaceView glSurfaceView;
    private Handler handler;
    private LinearLayout monitoringButton;
    private MonitoringFragment monitoringFragment;
    private ImageView monitoringImage;
    private TextView monitoringTV;
    public LinearLayout playButton;
    private ImageView playImage;
    private ProgressDialog progressDialog;
    private String renderer;
    private FrameLayout root;
    private LinearLayout rouletteButton;
    private RouletteFragment rouletteFragment;
    private ImageView rouletteImage;
    private TextView rouletteTV;
    private LinearLayout serverLL;
    private LinearLayout settingsButton;
    private SettingsFragment settingsFragment;
    private ImageView settingsImage;
    private TextView settingsTV;

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl, int w, int h) {
    }

    static /* synthetic */ int access$108(MainActivity mainActivity) {
        int i = mainActivity.connectCount;
        mainActivity.connectCount = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.progressDialog.dismiss();
            this.progressDialog = null;
        }
        if (this.progressDialog != null) {
            this.progressDialog = null;
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.progressDialog == null) {
            ProgressDialog progressDialog = new ProgressDialog(this, R.style.MyTheme);
            this.progressDialog = progressDialog;
            progressDialog.setIndeterminateDrawable(ContextCompat.getDrawable(this, R.drawable.progressbar_custom));
            this.progressDialog.setCancelable(false);
            this.progressDialog.setProgressStyle(android.R.attr.progressBarStyleSmall);
        }
    }

    public String getDataPath() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        return getExternalFilesDir(null).getAbsolutePath() + "/";
    }

    private void initLogger() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                Logger.init(getDataPath() + "SAMP/");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        initLogger();
//        CrashTool.init(this);
        Logger.i("* MainActivity onCreate");
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(128);
        getWindow().addFlags(1024);
        isRecordAudioPermissionGranted();
        this.handler = new Handler();
        ProgressDialog progressDialog = new ProgressDialog(this, R.style.MyTheme);
        this.progressDialog = progressDialog;
        progressDialog.setIndeterminateDrawable(ContextCompat.getDrawable(this, R.drawable.progressbar_custom));
        this.progressDialog.setCancelable(false);
        this.progressDialog.setProgressStyle(android.R.attr.progressBarStyleSmall);
        this.monitoringTV = (TextView) findViewById(R.id.monitoringTV);
        this.settingsTV = (TextView) findViewById(R.id.settingsTV);
        this.rouletteTV = (TextView) findViewById(R.id.rouletteTV);
        this.donateTV = (TextView) findViewById(R.id.donateTV);
        this.monitoringImage = (ImageView) findViewById(R.id.monitoringImage);
        this.settingsImage = (ImageView) findViewById(R.id.settingsImage);
        this.rouletteImage = (ImageView) findViewById(R.id.rouletteImage);
        this.donateImage = (ImageView) findViewById(R.id.donateImage);
        this.playImage = (ImageView) findViewById(R.id.playImage);
        this.monitoringButton = (LinearLayout) findViewById(R.id.monitoringButton);
        this.settingsButton = (LinearLayout) findViewById(R.id.settingsButton);
        this.rouletteButton = (LinearLayout) findViewById(R.id.rouletteButton);
        this.donateButton = (LinearLayout) findViewById(R.id.donateButton);
        this.playButton = (LinearLayout) findViewById(R.id.playButton);
        this.monitoringButton.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$MainActivity$6xyDiWkhpkPjD0rrkxPCwfPKE5c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.lambda$onCreate$0$MainActivity(view);
            }
        });
        this.settingsButton.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$MainActivity$g_NMb7TSfcPTbpfsPNmjYM3fI0A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.lambda$onCreate$1$MainActivity(view);
            }
        });
        this.rouletteButton.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$MainActivity$Xf5Af8lXhInxgNFMUZLfy4pORBY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.lambda$onCreate$2$MainActivity(view);
            }
        });
        this.donateButton.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$MainActivity$5k7H1-6E5O8c-fkn5aveGWWGqs4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.lambda$onCreate$3$MainActivity(view);
            }
        });
        this.playButton.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$MainActivity$sOQlU8OAmhXaWxOOXthyanJijyw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.lambda$onCreate$4$MainActivity(view);
            }
        });
        this.monitoringFragment = new MonitoringFragment();
        this.settingsFragment = new SettingsFragment();
        this.rouletteFragment = new RouletteFragment();
        this.donateFragment = new DonateFragment();
        replaceFragment(this.monitoringFragment);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.root);
        this.root = frameLayout;
        Utils.setBackground(this, R.drawable.back, frameLayout);
        GLSurfaceView gLSurfaceView = new GLSurfaceView(this);
        this.glSurfaceView = gLSurfaceView;
        gLSurfaceView.setRenderer(this);
        this.glSurfaceView.setLayoutParams(new LinearLayout.LayoutParams(1, 1));
        this.root.addView(this.glSurfaceView);
        if (App.getInstance().isStartGame()) {
            try {
                startActivity(new Intent(this, (Class<?>) GTASA.class));
                finish();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        if (!Preferences.getBoolean(this, Preferences.PRIVACY)) {
            privacyPolicy();
        }
        FirebaseMessaging.getInstance().subscribeToTopic("all");
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.serverLL);
        this.serverLL = linearLayout;
        Utils.setBackground(this, R.drawable.back, linearLayout);
        ((FrameLayout) findViewById(R.id.chooseServerCancelButton)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$MainActivity$KOrH6OJ_0XdIK4e4zFqJGXmDNp4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.lambda$onCreate$6$MainActivity(view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.chooseServersRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ChooseServerAdapter chooseServerAdapter = new ChooseServerAdapter(this, App.getInstance().getServerList());
        this.chooseServerAdapter = chooseServerAdapter;
        recyclerView.setAdapter(chooseServerAdapter);
        long freeMemory = getFreeMemory();
        if (freeMemory < 2000) {
            Toast.makeText(this, String.format(getString(R.string.warning_free_memory), Long.valueOf(freeMemory)), 1).show();
        }
        String stringExtra = getIntent().getStringExtra(GetKeys.GET_PLAYERS_ID);
        if (stringExtra != null) {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(getApplicationContext());
            Bundle bundle = new Bundle();
            bundle.putString("open", stringExtra);
            firebaseAnalytics.logEvent("push", bundle);
        }
    }

    public /* synthetic */ void lambda$onCreate$0$MainActivity(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        onClickMonitoring();
    }

    public /* synthetic */ void lambda$onCreate$1$MainActivity(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        onClickSettings();
    }

    public /* synthetic */ void lambda$onCreate$2$MainActivity(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        onClickRoulette();
    }

    public /* synthetic */ void lambda$onCreate$3$MainActivity(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        onClickDonate();
    }

    public /* synthetic */ void lambda$onCreate$4$MainActivity(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$onvbcP1yyL0aIc_qYmj911iHUsk
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.onClickPlay();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$onCreate$6$MainActivity(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$MainActivity$0xn84RxHVWVvsJyTb2Z-EtSKpCE
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.lambda$null$5$MainActivity();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$5$MainActivity() {
        this.serverLL.setVisibility(8);
    }

    public void setServer(int position, Server server) {
        this.donateFragment.setServer(position, server);
        this.serverLL.setVisibility(8);
    }

    public void showChooseServer() {
        this.serverLL.setVisibility(0);
        this.chooseServerAdapter.notifyDataSetChanged();
    }

    private void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            for (File file : fileOrDirectory.listFiles()) {
                deleteRecursive(file);
            }
        }
        fileOrDirectory.delete();
    }

    private void privacyPolicy() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.item_dialog_privacy);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(-1, -2);
        TextView textView = (TextView) dialog.findViewById(R.id.message);
        textView.setText(Html.fromHtml("<u>" + getResources().getString(R.string.privacyPolicy2) + "</u>"));
        textView.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$MainActivity$WzBI_UpkUCEKp0Sxl4PPf-ic7ME
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.lambda$privacyPolicy$7$MainActivity(view);
            }
        });
        ((TextView) dialog.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$MainActivity$e-536gVV6Kc52KE3XGQVOR4LHTg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.lambda$privacyPolicy$9$MainActivity(dialog, view);
            }
        });
        TextView textView2 = (TextView) dialog.findViewById(R.id.ok);
        textView2.setText(getResources().getString(R.string.ok));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$MainActivity$fpUB6xjqmhQwzRPwZAsGri19QDk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.lambda$privacyPolicy$11$MainActivity(dialog, view);
            }
        });
        dialog.show();
    }

    public /* synthetic */ void lambda$privacyPolicy$7$MainActivity(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.link_privacy))));
    }

    public /* synthetic */ void lambda$privacyPolicy$9$MainActivity(final Dialog dialog, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$MainActivity$-zsNepfv9OJDXq0n9rf0JB254ao
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.lambda$null$8$MainActivity(dialog);
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$8$MainActivity(final Dialog dialog) {
        dialog.dismiss();
        finish();
    }

    public /* synthetic */ void lambda$privacyPolicy$11$MainActivity(final Dialog dialog, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$MainActivity$5NVld7x4Sg8s7DBsG1sNBZ-_iLA
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.lambda$null$10$MainActivity(dialog);
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$10$MainActivity(final Dialog dialog) {
        dialog.dismiss();
        Preferences.putBoolean(this, Preferences.PRIVACY, true);
    }

    private void onClickMonitoring() {
        if (this.rouletteFragment.isRouletteBlocked()) {
            return;
        }
        setTextColor(this.monitoringButton, this.monitoringTV, this.monitoringImage);
        replaceFragment(this.monitoringFragment);
    }

    private void deleteCol() {
        try {
            deleteRecursive(new File(getExternalFilesDir(null).getPath().replace("blackrussia.online/files", "") + Settings.CLIENT_PACKAGE + "/files/loader/img/GTA_INT/"));
        } catch (Exception unused) {
        }
    }

    public void onClickPlay() {
        if (isStoragePermissionGranted()) {
            String path = getExternalFilesDir(null).getPath();
            File cache = new File(path.replace("blackrussia.online/files", "") + Settings.CLIENT_PACKAGE + "/files/SAMP/settings.ini");

            if(cache.exists()){
                Logger.i("Cache exists");
                MainActivity.this.startActivity(new Intent(MainActivity.this, GTASA.class));
                MainActivity.this.finish();
            }else{
                Logger.i("Cache not exists");
                //MainActivity.this.startActivity(new Intent(MainActivity.this, LoaderActivity.class));
                //MainActivity.this.finish();
            }
        }
    }

    private void onClickSettings() {
        if (!isStoragePermissionGranted() || this.rouletteFragment.isRouletteBlocked()) {
            return;
        }
        setTextColor(this.settingsButton, this.settingsTV, this.settingsImage);
        replaceFragment(this.settingsFragment);
    }

    private void onClickRoulette() {
        if (this.rouletteFragment.isRouletteBlocked()) {
            return;
        }
        setTextColor(this.rouletteButton, this.rouletteTV, this.rouletteImage);
        replaceFragment(this.rouletteFragment);
    }

    private void onClickDonate() {
        if (this.rouletteFragment.isRouletteBlocked()) {
            return;
        }
        setTextColor(this.donateButton, this.donateTV, this.donateImage);
        replaceFragment(this.donateFragment);
    }

    private void setTextColor(LinearLayout linearLayout, TextView textView, ImageView imageView) {
        this.monitoringButton.setAlpha(0.45f);
        this.settingsButton.setAlpha(0.45f);
        this.rouletteButton.setAlpha(0.45f);
        this.donateButton.setAlpha(0.45f);
        this.monitoringTV.setTextColor(getResources().getColor(R.color.menuTextDisable));
        this.settingsTV.setTextColor(getResources().getColor(R.color.menuTextDisable));
        this.rouletteTV.setTextColor(getResources().getColor(R.color.menuTextDisable));
        this.donateTV.setTextColor(getResources().getColor(R.color.menuTextDisable));
        this.monitoringImage.setColorFilter(getResources().getColor(R.color.menuTextDisable), PorterDuff.Mode.SRC_IN);
        this.settingsImage.setColorFilter(getResources().getColor(R.color.menuTextDisable), PorterDuff.Mode.SRC_IN);
        this.rouletteImage.setColorFilter(getResources().getColor(R.color.menuTextDisable), PorterDuff.Mode.SRC_IN);
        this.donateImage.setColorFilter(getResources().getColor(R.color.menuTextDisable), PorterDuff.Mode.SRC_IN);
        linearLayout.setAlpha(1.0f);
        textView.setTextColor(getResources().getColor(R.color.menuTextEnable));
        imageView.setColorFilter(getResources().getColor(R.color.menuTextEnable), PorterDuff.Mode.SRC_IN);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.container, fragment);
        beginTransaction.commit();
    }

    private String getNick() {
        if (!App.isExternalStorageAvailable(this)) {
            return "";
        }
        try {
            Matcher matcher = Pattern.compile("name = .*", 2).matcher(readUsingBufferedReader(getExternalFilesDir(null).getAbsolutePath().replace("blackrussia.online/files", "") + Settings.CLIENT_PACKAGE + "/files/SAMP/settings.ini"));
            String str = "";
            for (int i = 0; matcher.find(i); i = matcher.end()) {
                str = matcher.group(0);
            }
            if (str != null && str.length() > 0) {
                String substring = str.substring(str.indexOf("name = ") + 7);
                if (substring.length() > 0) {
                    return substring;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String property = System.getProperty("line.separator");
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            sb.append(readLine);
            sb.append(property);
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdate() {
        if (this.connectCount % 10 == 0) {
            try {
                this.progressDialog.show();
            } catch (Exception unused) {
            }
        }
        ApiService.getInstance().getApiService().getFiles().enqueue(new Callback<ArrayList<MyFile>>() { // from class: blackrussia.online.activities.MainActivity.1
            /* JADX WARN: Code restructure failed: missing block: B:138:0x042b, code lost:
            
                if (r0.versionName.equalsIgnoreCase(r2.versionName) == false) goto L119;
             */
            /* JADX WARN: Code restructure failed: missing block: B:144:0x0466, code lost:
            
                if (r2.versionName.equalsIgnoreCase(r4.versionName) == false) goto L127;
             */
            /* JADX WARN: Removed duplicated region for block: B:143:0x045e A[Catch: Exception -> 0x0469, TRY_LEAVE, TryCatch #1 {Exception -> 0x0469, blocks: (B:141:0x0435, B:143:0x045e), top: B:140:0x0435 }] */
            /* JADX WARN: Removed duplicated region for block: B:149:0x0475  */
            /* JADX WARN: Removed duplicated region for block: B:159:0x04aa  */
            /* JADX WARN: Removed duplicated region for block: B:163:0x04b6 A[LOOP:4: B:161:0x04b0->B:163:0x04b6, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:167:0x04ea A[LOOP:5: B:165:0x04e4->B:167:0x04ea, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:171:0x0527  */
            @Override // retrofit2.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResponse(Call<ArrayList<MyFile>> call, Response<ArrayList<MyFile>> response) {
                String str = null;
                ArrayList<MyFile> body = null;
                ArrayList arrayList = null;
                int i = 0;
                boolean z = false;
                int i2 = 0;
                PackageInfo packageArchiveInfo;
                String substring;
                if (response.body() == null || MainActivity.this.progressDialog == null || MainActivity.this.isDestroyed()) {
                    if (MainActivity.this.connectCount == 6) {
                        DataService.getInstance().changeAPI();
                        App.getInstance().downloadLinkList(Settings.URL_DOWNLOAD_LIST2);
                    }
                    MainActivity.access$108(MainActivity.this);
                    if (MainActivity.this.connectCount % 10 == 0) {
                        if (MainActivity.this.progressDialog != null) {
                            MainActivity.this.progressDialog.dismiss();
                        }
                        MainActivity mainActivity = MainActivity.this;
                        Toast.makeText(mainActivity, mainActivity.getString(R.string.no_internet), 1).show();
                        return;
                    }
                    new Handler().postDelayed(new Runnable() { // from class: blackrussia.online.activities.MainActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MainActivity.this.checkUpdate();
                        }
                    }, 500L);
                    return;
                }
                if (App.isExternalStorageAvailable(MainActivity.this)) {
                    str = MainActivity.this.getExternalFilesDir(null).getAbsolutePath().replace("blackrussia.online/files", "") + Settings.CLIENT_PACKAGE + "/files/";
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(Downloader.ADRENO_TEGRA);
                    arrayList2.add(Downloader.MALI);
                    arrayList2.add(Downloader.POWER_VR);
                    arrayList2.add(Downloader.ETC);
                    arrayList2.remove(App.getInstance().getCurrentFolder());
                    body = response.body();
                    arrayList = new ArrayList();
                    int size = body.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        if (body.get(size).getPath().startsWith((String) arrayList2.get(0)) || body.get(size).getPath().startsWith((String) arrayList2.get(1)) || body.get(size).getPath().startsWith((String) arrayList2.get(2))) {
                            body.remove(size);
                        } else {
                            if (body.get(size).getPath().contains("texdb") && !body.get(size).getPath().contains("texdb/player") && !body.get(size).getPath().contains("texdb/playerhi") && !body.get(size).getPath().contains("texdb/menu")) {
                                if (!App.getInstance().getCurrentFolder().equals(Downloader.ETC) && !App.getInstance().getCurrentFolder().equals(Downloader.ADRENO_TEGRA) && body.get(size).getName().contains(".dxt.")) {
                                    body.remove(size);
                                } else if (!App.getInstance().getCurrentFolder().equals(Downloader.ETC) && !App.getInstance().getCurrentFolder().equals(Downloader.MALI) && body.get(size).getName().contains(".etc.")) {
                                    body.remove(size);
                                } else if (!App.getInstance().getCurrentFolder().equals(Downloader.ETC) && !App.getInstance().getCurrentFolder().equals(Downloader.POWER_VR) && body.get(size).getName().contains(".pvr.")) {
                                    body.remove(size);
                                }
                            }
                            if (body.get(size).getPath().startsWith("high") || body.get(size).getPath().startsWith("notrees")) {
                                body.remove(size);
                            } else if (body.get(size).getPath().startsWith(App.getInstance().getCurrentFolder())) {
                                arrayList.add(body.get(size));
                                body.remove(size);
                            } else {
                                String path = body.get(size).getPath();
                                if (path.startsWith("files/")) {
                                    path = path.substring(path.indexOf("files/") + 6);
                                }
                                File file = new File(str + path + body.get(size).getName());
                                if (file.exists() && body.get(size).getName().equalsIgnoreCase("gta_sa.set")) {
                                    body.remove(size);
                                } else if (file.exists() && body.get(size).getName().equalsIgnoreCase("settings.ini")) {
                                    body.remove(size);
                                } else {
                                    String str2 = App.getInstance().getDataFiles().get(body.get(size).getPath() + body.get(size).getName());
                                    if (str2 != null && str2.equals(body.get(size).getDate()) && file.exists() && file.length() == body.get(size).getSize()) {
                                        body.remove(size);
                                    }
                                }
                            }
                        }
                        size--;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                        if (((MyFile) arrayList.get(size2)).getName().endsWith(".saa")) {
                            File file2 = new File(str + ((MyFile) arrayList.get(size2)).getName());
                            String str3 = App.getInstance().getDataFiles().get(((MyFile) arrayList.get(size2)).getPath() + ((MyFile) arrayList.get(size2)).getName());
                            if (str3 != null && str3.equals(((MyFile) arrayList.get(size2)).getDate()) && file2.exists() && file2.length() == ((MyFile) arrayList.get(size2)).getSize()) {
                                arrayList3.add(((MyFile) arrayList.get(size2)).getName().substring(0, ((MyFile) arrayList.get(size2)).getName().indexOf(".saa")));
                            }
                        }
                    }
                    for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                        Iterator it = arrayList3.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                String str4 = (String) it.next();
                                if (((MyFile) arrayList.get(size3)).getName().endsWith(".saa")) {
                                    substring = ((MyFile) arrayList.get(size3)).getName().substring(0, ((MyFile) arrayList.get(size3)).getName().indexOf(".saa"));
                                } else {
                                    substring = ((MyFile) arrayList.get(size3)).getName().substring(0, ((MyFile) arrayList.get(size3)).getName().indexOf(".zip"));
                                }
                                if (substring.equalsIgnoreCase(str4)) {
                                    arrayList.remove(size3);
                                    break;
                                }
                            }
                        }
                    }
                    try {
                        PackageInfo packageInfo = MainActivity.this.getPackageManager().getPackageInfo(Settings.CLIENT_PACKAGE, 0);
                        PackageInfo packageArchiveInfo2 = MainActivity.this.getPackageManager().getPackageArchiveInfo(str + "blackrussia_client.apk", 0);
                        if (packageArchiveInfo2 != null) {
                        }
                        z = false;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        PackageInfo packageInfo2 = MainActivity.this.getPackageManager().getPackageInfo("blackrussia.online", 0);
                        packageArchiveInfo = MainActivity.this.getPackageManager().getPackageArchiveInfo(str + "launcher.apk", 0);
                        if (packageArchiveInfo != null) {
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    Logger.i("Test 0");
                    if (z && body.size() <= 0 && arrayList.size() <= 0) {
                        if (MainActivity.this.progressDialog != null) {
                            MainActivity.this.progressDialog.dismiss();
                        }
                        MainActivity.this.startActivity(new Intent(MainActivity.this, (Class<?>) GTASA.class));
                        MainActivity.this.finish();
                        return;
                    }
                    if (z) {
                        Logger.i("Need to update APK");
                    }
                    for (i2 = 0; i2 < body.size(); i2++) {
                        Logger.i("Updating file " + body.get(i2).getPath() + body.get(i2).getName());
                    }
                    for (i = 0; i < arrayList.size(); i++) {
                        Logger.i("Updating textures " + ((MyFile) arrayList.get(i)).getPath() + ((MyFile) arrayList.get(i)).getName());
                    }
                    App.getInstance().setStartGame(true);
                    if (MainActivity.this.progressDialog != null) {
                        MainActivity.this.progressDialog.dismiss();
                    }
                    MainActivity.this.startActivity(new Intent(MainActivity.this, (Class<?>) LoaderActivity.class));
                    MainActivity.this.finish();
                }
                z = true;
                try {
                    PackageInfo packageInfo22 = MainActivity.this.getPackageManager().getPackageInfo("blackrussia.online", 0);
                } catch (PackageManager.NameNotFoundException e) {
                    throw new RuntimeException(e);
                }
                packageArchiveInfo = MainActivity.this.getPackageManager().getPackageArchiveInfo(str + "launcher.apk", 0);
                if (packageArchiveInfo != null) {
                }
                Logger.i("Test 0");
                if (z) {
                }
                if (z) {
                }
                while (i2 < body.size()) {
                }
                while (i < arrayList.size()) {
                }
                App.getInstance().setStartGame(true);
                if (MainActivity.this.progressDialog != null) {
                }
                MainActivity.this.startActivity(new Intent(MainActivity.this, (Class<?>) LoaderActivity.class));
                MainActivity.this.finish();
                z = true;
                Logger.i("Test 0");
                if (z) {
                }
                if (z) {
                }
                while (i2 < body.size()) {
                }
                while (i < arrayList.size()) {
                }
                App.getInstance().setStartGame(true);
                if (MainActivity.this.progressDialog != null) {
                }
                MainActivity.this.startActivity(new Intent(MainActivity.this, (Class<?>) LoaderActivity.class));
                MainActivity.this.finish();
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<ArrayList<MyFile>> call, Throwable t) {
                if (MainActivity.this.connectCount == 6) {
                    DataService.getInstance().changeAPI();
                    App.getInstance().downloadLinkList(Settings.URL_DOWNLOAD_LIST2);
                }
                MainActivity.access$108(MainActivity.this);
                if (MainActivity.this.connectCount % 10 == 0) {
                    if (MainActivity.this.progressDialog != null) {
                        MainActivity.this.progressDialog.dismiss();
                    }
                    MainActivity mainActivity = MainActivity.this;
                    Toast.makeText(mainActivity, mainActivity.getString(R.string.no_internet), 1).show();
                    return;
                }
                new Handler().postDelayed(new Runnable() { // from class: blackrussia.online.activities.MainActivity.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        MainActivity.this.checkUpdate();
                    }
                }, 500L);
            }
        });
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        gl10.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        this.renderer = gl10.glGetString(7937).toLowerCase().replaceAll("\\s+", "");
        runOnUiThread(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$MainActivity$weZjtX8TSChJn_tDNUAPrQhONNs
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.lambda$onSurfaceCreated$12$MainActivity();
            }
        });
    }

    public /* synthetic */ void lambda$onSurfaceCreated$12$MainActivity() {
        this.root.removeView(this.glSurfaceView);
        if (this.renderer.contains("adreno") || this.renderer.contains("tegra")) {
            App.getInstance().setCurrentFolder(Downloader.ADRENO_TEGRA);
            return;
        }
        if (this.renderer.contains(Downloader.POWER_VR)) {
            App.getInstance().setCurrentFolder(Downloader.POWER_VR);
        } else if (this.renderer.contains(Downloader.MALI)) {
            App.getInstance().setCurrentFolder(Downloader.MALI);
        } else {
            App.getInstance().setCurrentFolder(Downloader.ETC);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl) {
        gl.glClear(16384);
    }

    public boolean isRecordAudioPermissionGranted() {
        if (Build.VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.RECORD_AUDIO"}, 2);
        return false;
    }

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        return false;
    }

    public long getFreeMemory() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            return (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        } catch (Exception unused) {
            return 268435455L;
        }
    }
}
