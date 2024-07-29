package blackrussia.online.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import blackrussia.online.R;

/* loaded from: classes.dex */
public class SplashActivity extends AppCompatActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$SplashActivity$JX03J8Ty4NjIsQK-PeqBmrRISeI
            @Override // java.lang.Runnable
            public final void run() {
                SplashActivity.this.lambda$onCreate$0$SplashActivity();
            }
        }, 1000L);
    }

    public /* synthetic */ void lambda$onCreate$0$SplashActivity() {
        startActivity(new Intent(this, (Class<?>) MainActivity.class));
        finish();
    }
}
