package blackrussia.online.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.Logger;
import blackrussia.online.R;
import blackrussia.online.Utils;
import blackrussia.online.adapters.ChooseServerAdapter;
import blackrussia.online.network.Auth;
import blackrussia.online.network.DataService;
import blackrussia.online.network.Server;
import com.rockstargames.gtacr.BrCaptcha;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes.dex */
public class AuthorizationActivity extends AppCompatActivity {
    public CheckBox checkBox;
    private FrameLayout chooseServer;
    private ChooseServerAdapter chooseServerAdapter;
    private TextView enter;
    private Handler handler;
    private long lastTimeRequest;
    private EditText nik;
    private EditText password;
    private LinearLayout root;
    private Server server;
    private LinearLayout serverLL;
    private TextView serverName;
    private TextView warning;
    private BrCaptcha captcha = null;
    public String responseToken = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        this.handler = new Handler();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root);
        this.root = linearLayout;
        Utils.setBackground(this, R.drawable.back, linearLayout);
        this.nik = (EditText) findViewById(R.id.nik);
        this.password = (EditText) findViewById(R.id.password);
        this.warning = (TextView) findViewById(R.id.warning);
        TextView textView = (TextView) findViewById(R.id.enter);
        this.enter = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$AuthorizationActivity$mnscWCMyPHnn9FLvIuhTz5Ck9Bs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorizationActivity.this.lambda$onCreate$0$AuthorizationActivity(view);
            }
        });
        ((FrameLayout) findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$AuthorizationActivity$E3QLnAdodzIZaE1mayvzWjd3rnI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorizationActivity.this.lambda$onCreate$1$AuthorizationActivity(view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.chooseServersRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ChooseServerAdapter chooseServerAdapter = new ChooseServerAdapter(this, App.getInstance().getServerList());
        this.chooseServerAdapter = chooseServerAdapter;
        recyclerView.setAdapter(chooseServerAdapter);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.serverLL);
        this.serverLL = linearLayout2;
        Utils.setBackground(this, R.drawable.back, linearLayout2);
        ((FrameLayout) findViewById(R.id.chooseServerCancelButton)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$AuthorizationActivity$4GRHxSBqxXEWb2Iee6NwZiCDrb4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorizationActivity.this.lambda$onCreate$3$AuthorizationActivity(view);
            }
        });
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.chooseServer);
        this.chooseServer = frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$AuthorizationActivity$jeJ5BkhQP7KMrEGqdKyemfhkHBY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorizationActivity.this.lambda$onCreate$4$AuthorizationActivity(view);
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.serverName);
        this.serverName = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$AuthorizationActivity$pbS8f4iqgDipnjPxWbr37hdDaD0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorizationActivity.this.lambda$onCreate$5$AuthorizationActivity(view);
            }
        });
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox_auth);
        this.checkBox = checkBox;
        checkBox.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.AuthorizationActivity.1
            void AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (AuthorizationActivity.this.checkBox.isChecked()) {
                    AuthorizationActivity.this.checkBox.setChecked(false);
                    if (AuthorizationActivity.this.captcha == null) {
                        AuthorizationActivity.this.captcha = new BrCaptcha();
                    }
                    if (AuthorizationActivity.this.captcha.isShowingGui()) {
                        return;
                    }
                    new BrCaptcha().rouletteShow(AuthorizationActivity.this);
                }
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$AuthorizationActivity(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$AuthorizationActivity$K0MqBYx1MbaU38ycKRQAPpu064g
            @Override // java.lang.Runnable
            public final void run() {
                AuthorizationActivity.this.onClickEnter();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$onCreate$1$AuthorizationActivity(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$xgLuS7tTv-rLtm9DwiyAw1GDuQ0
            @Override // java.lang.Runnable
            public final void run() {
                AuthorizationActivity.this.finish();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$onCreate$3$AuthorizationActivity(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$AuthorizationActivity$o9s3dfEn9QzATxCnT3AaCjoizA8
            @Override // java.lang.Runnable
            public final void run() {
                AuthorizationActivity.this.lambda$null$2$AuthorizationActivity();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$2$AuthorizationActivity() {
        this.serverLL.setVisibility(8);
    }

    public /* synthetic */ void lambda$onCreate$4$AuthorizationActivity(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        this.handler.postDelayed(new $$Lambda$AuthorizationActivity$6HQWqjnGfdmFvvbDbW1_WcxZRrU(this), 200L);
    }

    public /* synthetic */ void lambda$onCreate$5$AuthorizationActivity(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        this.handler.postDelayed(new $$Lambda$AuthorizationActivity$6HQWqjnGfdmFvvbDbW1_WcxZRrU(this), 200L);
    }

    /* renamed from: blackrussia.online.activities.AuthorizationActivity$1 */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (AuthorizationActivity.this.checkBox.isChecked()) {
                AuthorizationActivity.this.checkBox.setChecked(false);
                if (AuthorizationActivity.this.captcha == null) {
                    AuthorizationActivity.this.captcha = new BrCaptcha();
                }
                if (AuthorizationActivity.this.captcha.isShowingGui()) {
                    return;
                }
                new BrCaptcha().rouletteShow(AuthorizationActivity.this);
            }
        }
    }

    public View getParentLayout() {
        return this.root;
    }

    public void onClickEnter() {
        if (this.nik.getText().toString().isEmpty()) {
            Toast.makeText(this, getResources().getString(R.string.enterNikForDonate), 1).show();
            return;
        }
        if (!this.nik.getText().toString().contains("_")) {
            Toast.makeText(this, getResources().getString(R.string.mustContains_), 1).show();
            return;
        }
        if (this.nik.getText().toString().length() < 4) {
            Toast.makeText(this, getResources().getString(R.string.minLengthNik), 1).show();
            return;
        }
        if (this.password.getText().toString().isEmpty()) {
            Toast.makeText(this, getResources().getString(R.string.enter_your_pass), 1).show();
            return;
        }
        if (this.server == null) {
            Toast.makeText(this, getResources().getString(R.string.chooseServer), 1).show();
            return;
        }
        if (!this.checkBox.isChecked() || this.responseToken == null) {
            Toast.makeText(this, "Докажите, что Вы не робот :)", 1).show();
            return;
        }
        this.warning.setVisibility(8);
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.lastTimeRequest;
        if (j < 15000) {
            Toast.makeText(this, String.format(getString(R.string.warning_request), Long.valueOf(15 - (j / 1000))), 1).show();
        } else {
            this.lastTimeRequest = currentTimeMillis;
            DataService.getInstance().getApiService().getAuth(this.server.getFirstName().toLowerCase(), this.server.getColor(), this.nik.getText().toString(), md5(this.password.getText().toString()), this.responseToken).enqueue(new Callback<Auth>() { // from class: blackrussia.online.activities.AuthorizationActivity.2
                void AnonymousClass2() {
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<Auth> call, Response<Auth> response) {
                    if (response.body() != null) {
                        Auth body = response.body();
                        if (!body.getAuth()) {
                            AuthorizationActivity.this.warning.setVisibility(0);
                            AuthorizationActivity.this.runOnUiThread(new Runnable() { // from class: blackrussia.online.activities.AuthorizationActivity.2.1
                                void AnonymousClass1() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    AuthorizationActivity.this.checkBox.setChecked(false);
                                    AuthorizationActivity.this.responseToken = null;
                                }
                            });
                            return;
                        }
                        if (!body.getMessage().isEmpty()) {
                            Toast.makeText(AuthorizationActivity.this, body.getMessage(), 1).show();
                        }
                        AuthorizationActivity.this.captcha = null;
                        Intent intent = new Intent();
                        intent.putExtra("userName", body.getName());
                        intent.putExtra("userPassword", body.getPass());
                        intent.putExtra("userServer", body.getServer().toUpperCase());
                        intent.putExtra("userColor", body.getColor());
                        intent.putExtra("userBalance", body.getBalance());
                        AuthorizationActivity.this.setResult(-1, intent);
                        AuthorizationActivity.this.finish();
                        return;
                    }
                    AuthorizationActivity authorizationActivity = AuthorizationActivity.this;
                    Toast.makeText(authorizationActivity, authorizationActivity.getString(R.string.roulette_error_connection), 1).show();
                }

                /* renamed from: blackrussia.online.activities.AuthorizationActivity$2$1 */
                /* loaded from: classes.dex */
                class AnonymousClass1 implements Runnable {
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        AuthorizationActivity.this.checkBox.setChecked(false);
                        AuthorizationActivity.this.responseToken = null;
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<Auth> call, Throwable t) {
                    AuthorizationActivity authorizationActivity = AuthorizationActivity.this;
                    Toast.makeText(authorizationActivity, authorizationActivity.getString(R.string.roulette_error_connection), 1).show();
                }
            });
        }
    }

    /* renamed from: blackrussia.online.activities.AuthorizationActivity$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements Callback<Auth> {
        AnonymousClass2() {
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<Auth> call, Response<Auth> response) {
            if (response.body() != null) {
                Auth body = response.body();
                if (!body.getAuth()) {
                    AuthorizationActivity.this.warning.setVisibility(0);
                    AuthorizationActivity.this.runOnUiThread(new Runnable() { // from class: blackrussia.online.activities.AuthorizationActivity.2.1
                        void AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AuthorizationActivity.this.checkBox.setChecked(false);
                            AuthorizationActivity.this.responseToken = null;
                        }
                    });
                    return;
                }
                if (!body.getMessage().isEmpty()) {
                    Toast.makeText(AuthorizationActivity.this, body.getMessage(), 1).show();
                }
                AuthorizationActivity.this.captcha = null;
                Intent intent = new Intent();
                intent.putExtra("userName", body.getName());
                intent.putExtra("userPassword", body.getPass());
                intent.putExtra("userServer", body.getServer().toUpperCase());
                intent.putExtra("userColor", body.getColor());
                intent.putExtra("userBalance", body.getBalance());
                AuthorizationActivity.this.setResult(-1, intent);
                AuthorizationActivity.this.finish();
                return;
            }
            AuthorizationActivity authorizationActivity = AuthorizationActivity.this;
            Toast.makeText(authorizationActivity, authorizationActivity.getString(R.string.roulette_error_connection), 1).show();
        }

        /* renamed from: blackrussia.online.activities.AuthorizationActivity$2$1 */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AuthorizationActivity.this.checkBox.setChecked(false);
                AuthorizationActivity.this.responseToken = null;
            }
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<Auth> call, Throwable t) {
            AuthorizationActivity authorizationActivity = AuthorizationActivity.this;
            Toast.makeText(authorizationActivity, authorizationActivity.getString(R.string.roulette_error_connection), 1).show();
        }
    }

    private String md5(String input) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            Logger.i("Exception while encrypting to md5");
            e.printStackTrace();
            messageDigest = null;
        }
        messageDigest.update(input.getBytes(), 0, input.length());
        String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
        while (bigInteger.length() < 32) {
            bigInteger = "0" + bigInteger;
        }
        return bigInteger;
    }

    public void showChooseServer() {
        View currentFocus;
        this.serverLL.setVisibility(0);
        this.chooseServerAdapter.notifyDataSetChanged();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null || !inputMethodManager.isActive() || (currentFocus = getCurrentFocus()) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
    }

    public void setServer(Server server) {
        this.server = server;
        this.serverLL.setVisibility(8);
        this.serverName.setVisibility(0);
        this.serverName.setText(server.getFirstName());
        this.serverName.setTextColor(Color.parseColor("#" + server.getColor()));
        this.chooseServer.setVisibility(8);
    }
}
