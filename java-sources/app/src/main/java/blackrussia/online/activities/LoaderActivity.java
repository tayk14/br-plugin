package blackrussia.online.activities;

import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager2.widget.ViewPager2;
import blackrussia.online.App;
import blackrussia.online.Downloader;
import blackrussia.online.R;
import blackrussia.online.Utils;
import blackrussia.online.adapters.SliderTextAdapter;
import blackrussia.online.network.DataService;
import blackrussia.online.network.TextLoader;
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes.dex */
public class LoaderActivity extends AppCompatActivity implements GLSurfaceView.Renderer {
    private Downloader downloader;
    private TextView fileName;
    private GLSurfaceView glSurfaceView;
    private Handler handler;
    private TextView loadingPercent;
    private TextView loadingText;
    private RoundCornerProgressBar progressBar;
    private TextView repeatButton;
    private LinearLayout root;
    private String renderer = "";
    public boolean mInstallLauncher = false;

    public boolean isInstallPermissionGranted() {
        return true;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl, int w, int h) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        getWindow().addFlags(128);
        this.handler = new Handler();
        this.progressBar = (RoundCornerProgressBar) findViewById(R.id.progressBar);
        TextView textView = (TextView) findViewById(R.id.loadingText);
        this.loadingText = textView;
        textView.setText(getString(R.string.check_updates));
        TextView textView2 = (TextView) findViewById(R.id.loadingPercent);
        this.loadingPercent = textView2;
        textView2.setText("");
        this.fileName = (TextView) findViewById(R.id.fileName);
        TextView textView3 = (TextView) findViewById(R.id.repeatButton);
        this.repeatButton = textView3;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$LoaderActivity$aocKYKP0IiSMqu13CUTx6lFjus8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoaderActivity.this.onClickRepeatButton(view);
            }
        });
        this.downloader = new Downloader(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root);
        this.root = linearLayout;
        Utils.setBackground(this, R.drawable.back, linearLayout);
        GLSurfaceView gLSurfaceView = new GLSurfaceView(this);
        this.glSurfaceView = gLSurfaceView;
        gLSurfaceView.setRenderer(this);
        this.glSurfaceView.setLayoutParams(new LinearLayout.LayoutParams(1, 1));
        this.root.addView(this.glSurfaceView);
        Handler handler = new Handler();
        final ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.viewPager);
        final SliderTextAdapter sliderTextAdapter = new SliderTextAdapter(this);
        viewPager2.setAdapter(sliderTextAdapter);
        viewPager2.registerOnPageChangeCallback(new AnonymousClass1(handler, viewPager2));
        DataService.getInstance().getApiService().getTextLoader().enqueue(new Callback<ArrayList<TextLoader>>() { // from class: blackrussia.online.activities.LoaderActivity.2
            @Override // retrofit2.Callback
            public void onFailure(Call<ArrayList<TextLoader>> call, Throwable t) {
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<ArrayList<TextLoader>> call, Response<ArrayList<TextLoader>> response) {
                if (response.body() != null) {
                    ArrayList<TextLoader> body = response.body();
                    sliderTextAdapter.addItems(body);
                    viewPager2.setCurrentItem(body.size() * 10, false);
                }
            }
        });
        ((ImageView) findViewById(R.id.leftButton)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$LoaderActivity$7DGV6enuScuqzdKqIpIYCBbdXxI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoaderActivity.this.lambda$onCreate$0$LoaderActivity(viewPager2, view);
            }
        });
        ((ImageView) findViewById(R.id.rightButton)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$LoaderActivity$aAALkHlQKuj-T5SVMJqHp3TbH94
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoaderActivity.this.lambda$onCreate$1$LoaderActivity(viewPager2, view);
            }
        });
    }

    /* renamed from: blackrussia.online.activities.LoaderActivity$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends ViewPager2.OnPageChangeCallback {
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ ViewPager2 val$viewPager;

        AnonymousClass1(final Handler val$viewPager, final ViewPager2 val$handler) {
            this.val$handler = val$viewPager;
            this.val$viewPager = val$handler;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            this.val$handler.removeCallbacksAndMessages(null);
            Handler handler = this.val$handler;
            final ViewPager2 viewPager2 = this.val$viewPager;
            handler.postDelayed(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$LoaderActivity$1$hPUWktw-oyFXgZYgigimSF_zOIE
                @Override // java.lang.Runnable
                public final void run() {
//                    r0.setCurrentItem(ViewPager2.this.getCurrentItem() + 1);
                }
            }, 5000L);
        }
    }

    public /* synthetic */ void lambda$onCreate$0$LoaderActivity(final ViewPager2 viewPager, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }

    public /* synthetic */ void lambda$onCreate$1$LoaderActivity(final ViewPager2 viewPager, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }

    public void startMainActivity() {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mInstallLauncher) {
            this.downloader.installLauncher();
            this.mInstallLauncher = false;
        }
    }

    public void startUpdate() {
        if (this.renderer.contains("adreno") || this.renderer.contains("tegra")) {
            App.getInstance().setCurrentFolder(Downloader.ADRENO_TEGRA);
            this.downloader.checkFiles(Downloader.ADRENO_TEGRA);
        } else if (this.renderer.contains(Downloader.POWER_VR)) {
            App.getInstance().setCurrentFolder(Downloader.POWER_VR);
            this.downloader.checkFiles(Downloader.POWER_VR);
        } else if (this.renderer.contains(Downloader.MALI)) {
            App.getInstance().setCurrentFolder(Downloader.MALI);
            this.downloader.checkFiles(Downloader.MALI);
        } else {
            App.getInstance().setCurrentFolder(Downloader.ETC);
            this.downloader.checkFiles(Downloader.ETC);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
        gl10.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        this.renderer = gl10.glGetString(7937).toLowerCase().replaceAll("\\s+", "");
        runOnUiThread(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$LoaderActivity$gfnnXBlD5IsqgPn0jaKrqwe19Yc
            @Override // java.lang.Runnable
            public final void run() {
                LoaderActivity.this.lambda$onSurfaceCreated$2$LoaderActivity();
            }
        });
    }

    public /* synthetic */ void lambda$onSurfaceCreated$2$LoaderActivity() {
        this.root.removeView(this.glSurfaceView);
        if (isStoragePermissionGranted() && isInstallPermissionGranted()) {
            startUpdate();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl) {
        gl.glClear(16384);
    }

    public boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults[0] == 0 && isInstallPermissionGranted()) {
            startUpdate();
        }
    }

    public void setProgressFilesLoad(int percent) {
        this.loadingText.setText(getString(R.string.loading_percent));
        this.loadingPercent.setText(getString(R.string.percent, new Object[]{Integer.valueOf(percent)}));
        this.progressBar.setProgress(percent);
    }

    public void setFileName(String name) {
        this.fileName.setText(name);
    }

    public void setLoaded(double loaded, double total) {
        this.fileName.setText(getString(R.string.loaded, new Object[]{Double.valueOf(loaded), Double.valueOf(total)}));
    }

    public void setProgressTexturesLoad(int percent) {
        this.loadingText.setText(getString(R.string.loading_textures));
        this.loadingPercent.setText(getString(R.string.percent, new Object[]{Integer.valueOf(percent)}));
        this.progressBar.setProgress(percent);
    }

    public void setProgressUnzip(int current, int total) {
        this.loadingText.setText(getString(R.string.loading_unzip));
        this.loadingPercent.setText(getString(R.string.unzip, new Object[]{Integer.valueOf(current), Integer.valueOf(total)}));
    }

    public void setErrorConnection() {
        this.loadingText.setText(getString(R.string.loading_error));
        this.loadingPercent.setText("");
    }

    public void setRepeatButtonVisibility(int visibility) {
        this.repeatButton.setVisibility(visibility);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickRepeatButton(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$LoaderActivity$bJ7ufLTxJ7NKpAXjX58MqRLysGM
            @Override // java.lang.Runnable
            public final void run() {
                LoaderActivity.this.lambda$onClickRepeatButton$3$LoaderActivity();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$onClickRepeatButton$3$LoaderActivity() {
        this.repeatButton.setVisibility(8);
        startUpdate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            startUpdate();
        }
    }

    public int getProgress() {
        return (int) this.progressBar.getProgress();
    }
}
