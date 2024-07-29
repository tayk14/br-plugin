package blackrussia.online.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import blackrussia.online.R;
import blackrussia.online.Utils;

/* loaded from: classes.dex */
public class PrizeActivity extends AppCompatActivity {
    private Handler handler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize);
        this.handler = new Handler();
        Utils.setBackground(this, R.drawable.back, (LinearLayout) findViewById(R.id.root));
        ((FrameLayout) findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$PrizeActivity$ppCoiCHLC4vTRggQ-uCXUMfsThQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrizeActivity.this.lambda$onCreate$0$PrizeActivity(view);
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.winBack);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1500L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(2);
        imageView.startAnimation(rotateAnimation);
        ImageView imageView2 = (ImageView) findViewById(R.id.winImage);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(3000L);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        imageView2.startAnimation(scaleAnimation);
        TextView textView = (TextView) findViewById(R.id.winText);
        String stringExtra = getIntent().getStringExtra("title");
        int intExtra = getIntent().getIntExtra("count", 0);
        int intExtra2 = getIntent().getIntExtra("object", 0);
        if (intExtra2 == 4 || intExtra2 == 5) {
            textView.setText(stringExtra + " - " + intExtra);
        } else {
            textView.setText(stringExtra);
        }
        if (intExtra2 == 0) {
            imageView2.setImageResource(R.drawable.roulette_backpack);
            return;
        }
        if (intExtra2 == 1) {
            imageView2.setImageResource(R.drawable.roulette_bag);
            return;
        }
        if (intExtra2 == 2) {
            imageView2.setImageResource(R.drawable.roulette_cap);
            return;
        }
        if (intExtra2 == 3) {
            imageView2.setImageResource(R.drawable.roulette_watch);
            return;
        }
        if (intExtra2 == 4) {
            imageView2.setImageResource(R.drawable.roulette_currency);
            return;
        }
        if (intExtra2 == 5) {
            imageView2.setImageResource(R.drawable.roulette_donate);
            return;
        }
        if (intExtra2 == 6) {
            imageView2.setImageResource(R.drawable.roulette_experience);
            return;
        }
        if (intExtra2 == 7) {
            imageView2.setImageResource(R.drawable.roulette_slot_auto);
            return;
        }
        if (intExtra2 == 8) {
            imageView2.setImageResource(R.drawable.roulette_glass);
            return;
        }
        if (intExtra2 == 9) {
            imageView2.setImageResource(R.drawable.roulette_guitar);
            return;
        }
        if (intExtra2 == 10) {
            imageView2.setImageResource(R.drawable.roulette_gun);
            return;
        }
        if (intExtra2 == 11) {
            imageView2.setImageResource(R.drawable.roulette_crown_silver);
            return;
        }
        if (intExtra2 == 12) {
            imageView2.setImageResource(R.drawable.roulette_crown_gold);
            return;
        }
        if (intExtra2 == 13) {
            imageView2.setImageResource(R.drawable.roulette_crown_platinum);
            return;
        }
        if (intExtra2 == 16) {
            imageView2.setImageResource(R.drawable.roulette_military_ticket);
            return;
        }
        if (intExtra2 == 19) {
            imageView2.setImageResource(R.drawable.roulette_car);
            return;
        }
        if (intExtra2 == 20) {
            imageView2.setImageResource(R.drawable.roulette_car);
            return;
        }
        if (intExtra2 == 21) {
            imageView2.setImageResource(R.drawable.roulette_all_license);
        } else if (intExtra2 == 22) {
            imageView2.setImageResource(R.drawable.roulette_number_car);
        } else if (intExtra2 == 23) {
            imageView2.setImageResource(R.drawable.roulette_skin);
        }
    }

    public /* synthetic */ void lambda$onCreate$0$PrizeActivity(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$qlgb1BhwMSMwRx-jQAndCS4aei0
            @Override // java.lang.Runnable
            public final void run() {
                PrizeActivity.this.finish();
            }
        }, 200L);
    }
}
