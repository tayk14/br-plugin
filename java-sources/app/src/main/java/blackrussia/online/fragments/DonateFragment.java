package blackrussia.online.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import blackrussia.online.App;
import blackrussia.online.Preferences;
import blackrussia.online.R;
import blackrussia.online.Settings;
import blackrussia.online.activities.MainActivity;
import blackrussia.online.network.Server;
import com.bumptech.glide.load.Key;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class DonateFragment extends Fragment {
    private FrameLayout chooseServer;
    private int currentServer;
    private EditText email;
    private EditText nik;
    private TextView serverName;
    private EditText sum;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_donate, container, false);
        this.nik = (EditText) inflate.findViewById(R.id.nik);
        this.email = (EditText) inflate.findViewById(R.id.email);
        this.sum = (EditText) inflate.findViewById(R.id.sum);
        this.chooseServer = (FrameLayout) inflate.findViewById(R.id.chooseServer);
        this.serverName = (TextView) inflate.findViewById(R.id.serverName);
        TextView textView = (TextView) inflate.findViewById(R.id.deposit);
        String string = Preferences.getString(App.getInstance(), Preferences.NIK);
        if (!string.isEmpty()) {
            this.nik.setText(string);
        }
        String string2 = Preferences.getString(App.getInstance(), Preferences.EMAIL);
        if (!string2.isEmpty()) {
            this.email.setText(string2);
        }
        this.chooseServer.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$DonateFragment$wdbxTbJT99Y139s4htQhSyCvlxM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateFragment.this.lambda$onCreateView$0$DonateFragment(view);
            }
        });
        this.serverName.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$DonateFragment$0UGO7HTTJgukzXNR5VWj9ocg7OI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateFragment.this.lambda$onCreateView$1$DonateFragment(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$DonateFragment$KwgmSKSHr7KYH7Zad869DSA0lKE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateFragment.this.lambda$onCreateView$2$DonateFragment(view);
            }
        });
        this.sum.addTextChangedListener(new TextWatcher() { // from class: blackrussia.online.fragments.DonateFragment.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            void AnonymousClass1() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                if (obj.length() <= 0 || obj.charAt(0) != '0') {
                    return;
                }
                DonateFragment.this.sum.setText(obj.substring(1));
            }
        });
        this.currentServer = -1;
        this.serverName.setVisibility(8);
        this.chooseServer.setVisibility(0);
        return inflate;
    }

    public /* synthetic */ void lambda$onCreateView$0$DonateFragment(View view1) {
        view1.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        new Handler().postDelayed(new $$Lambda$DonateFragment$sDnQDZdqhNbDqT7bGXX7jbO0BFs(this), 200L);
    }

    public /* synthetic */ void lambda$onCreateView$1$DonateFragment(View view1) {
        view1.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        new Handler().postDelayed(new $$Lambda$DonateFragment$sDnQDZdqhNbDqT7bGXX7jbO0BFs(this), 200L);
    }

    public /* synthetic */ void lambda$onCreateView$2$DonateFragment(View view1) {
        view1.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        new Handler().postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$DonateFragment$f8bHOuCXCshaVOPdoGy9vh9k53E
            @Override // java.lang.Runnable
            public final void run() {
                DonateFragment.this.onClickDeposit();
            }
        }, 200L);
    }

    /* renamed from: blackrussia.online.fragments.DonateFragment$1 */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements TextWatcher {
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        AnonymousClass1() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (obj.length() <= 0 || obj.charAt(0) != '0') {
                return;
            }
            DonateFragment.this.sum.setText(obj.substring(1));
        }
    }

    public void onClickChooseServer() {
        ((MainActivity) getActivity()).showChooseServer();
    }

    public void setServer(int position, Server server) {
        this.currentServer = position;
        this.serverName.setVisibility(0);
        this.serverName.setText(server.getFirstName());
        this.serverName.setTextColor(Color.parseColor("#" + server.getColor()));
        this.chooseServer.setVisibility(8);
    }

    public void onClickDeposit() {
        if (this.nik.getText().toString().isEmpty()) {
            Toast.makeText(App.getInstance(), App.getInstance().getResources().getString(R.string.enterNikForDonate), 1).show();
            return;
        }
        if (!this.nik.getText().toString().contains("_")) {
            Toast.makeText(App.getInstance(), App.getInstance().getResources().getString(R.string.mustContains_), 1).show();
            return;
        }
        if (this.nik.getText().toString().length() < 4) {
            Toast.makeText(App.getInstance(), App.getInstance().getResources().getString(R.string.minLengthNik), 1).show();
            return;
        }
        if (this.email.getText().toString().isEmpty()) {
            Toast.makeText(App.getInstance(), App.getInstance().getResources().getString(R.string.enterYourEmail), 1).show();
            return;
        }
        if (this.sum.getText().toString().isEmpty()) {
            Toast.makeText(App.getInstance(), App.getInstance().getResources().getString(R.string.enterSumForDonate), 1).show();
            return;
        }
        if (this.currentServer == -1) {
            Toast.makeText(App.getInstance(), App.getInstance().getResources().getString(R.string.chooseServer), 1).show();
            return;
        }
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.fragment_webview);
        dialog.setCancelable(true);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(-1, -1);
            dialog.getWindow().setBackgroundDrawableResource(R.drawable.background_dialog_full);
            dialog.getWindow().getAttributes().dimAmount = 0.0f;
        }
        ((ImageView) dialog.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$DonateFragment$1vZiGaQ3Ovmiqphqo4cUbRv-iB8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonateFragment.lambda$onClickDeposit$3(dialog, view);
            }
        });
        clearCookies();
        WebView webView = (WebView) dialog.findViewById(R.id.webView);
        webView.setSoundEffectsEnabled(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(false);
        webView.getSettings().setUseWideViewPort(false);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setGeolocationEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccessFromFileURLs(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.setLayerType(2, null);
        webView.getSettings().setCacheMode(2);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        CookieSyncManager.createInstance(getActivity());
        CookieManager cookieManager = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= 21) {
            cookieManager.setAcceptThirdPartyCookies(webView, true);
        } else {
            cookieManager.setAcceptCookie(true);
        }
        webView.clearCache(true);
        webView.clearHistory();
        Preferences.putString(App.getInstance(), Preferences.EMAIL, this.email.getText().toString());
        Preferences.putString(App.getInstance(), Preferences.NIK, this.nik.getText().toString());
        String.format(Settings.URL_DONATE, this.sum.getText(), this.nik.getText(), this.email.getText(), Integer.valueOf(this.currentServer + 1), Integer.valueOf(this.currentServer + 1));
        try {
            webView.postUrl(Settings.URL_DONATE, ("&summa=" + URLEncoder.encode(this.sum.getText().toString(), Key.STRING_CHARSET_NAME) + "&account=" + URLEncoder.encode(this.nik.getText().toString(), Key.STRING_CHARSET_NAME) + "&mail=" + URLEncoder.encode(this.email.getText().toString(), Key.STRING_CHARSET_NAME) + "&desc=" + URLEncoder.encode(String.format("Пополнение игрового счёта на сервере №%d", Integer.valueOf(this.currentServer + 1)), Key.STRING_CHARSET_NAME) + "&server=server" + URLEncoder.encode(String.valueOf(this.currentServer + 1), Key.STRING_CHARSET_NAME)).getBytes());
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
        }
        dialog.show();
    }

    public static /* synthetic */ void lambda$onClickDeposit$3(final Dialog dialog, View view1) {
        view1.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        dialog.dismiss();
    }

    private void clearCookies() {
        if (Build.VERSION.SDK_INT >= 22) {
            CookieManager.getInstance().removeAllCookies(null);
            CookieManager.getInstance().flush();
            return;
        }
        CookieSyncManager createInstance = CookieSyncManager.createInstance(App.getInstance());
        createInstance.startSync();
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
        cookieManager.removeSessionCookie();
        createInstance.stopSync();
        createInstance.sync();
    }
}
