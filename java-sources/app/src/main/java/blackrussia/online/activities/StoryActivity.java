package blackrussia.online.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.adapters.SliderStoriesAdapter;
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class StoryActivity extends AppCompatActivity {
    private RoundCornerProgressBar progressStory;
    private SliderStoriesAdapter sliderStoriesAdapter;
    private SliderView sliderView;
    private Disposable timerDisposable;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        setContentView(R.layout.activity_story);
        this.sliderView = (SliderView) findViewById(R.id.sliderView);
        ImageView imageView = (ImageView) findViewById(R.id.closeStory);
        this.progressStory = (RoundCornerProgressBar) findViewById(R.id.progressStory);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.activities.-$$Lambda$StoryActivity$JBdrj35E2JUT29mONpRBS2Hib5M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoryActivity.this.lambda$onCreate$0$StoryActivity(view);
            }
        });
        SliderStoriesAdapter sliderStoriesAdapter = new SliderStoriesAdapter(this);
        this.sliderStoriesAdapter = sliderStoriesAdapter;
        this.sliderView.setSliderAdapter(sliderStoriesAdapter);
        this.sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        this.sliderStoriesAdapter.addItems(App.getInstance().getStories());
        this.sliderView.setCurrentPageListener(new SliderView.OnSliderPageListener() { // from class: blackrussia.online.activities.-$$Lambda$StoryActivity$GSFuiBPlj859CjXaKURjwIFgseY
            @Override // com.smarteist.autoimageslider.SliderView.OnSliderPageListener
            public final void onSliderPageChanged(int i) {
                StoryActivity.this.lambda$onCreate$1$StoryActivity(i);
            }
        });
        int intExtra = getIntent().getIntExtra("position", 0);
        this.sliderView.getSliderPager().setCurrentItem(intExtra, false);
        this.sliderView.getPagerIndicator().setSelection(intExtra);
        this.progressStory.setProgress(0.0f);
        startTimer();
    }

    public /* synthetic */ void lambda$onCreate$0$StoryActivity(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this, R.anim.button_click));
        new Handler().postDelayed(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$StoryActivity$Vq2_buK060WXtSiU8xXagmX_Ot4
            @Override // java.lang.Runnable
            public final void run() {
                StoryActivity.this.closeStory();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$onCreate$1$StoryActivity(int position) {
        startTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeStory() {
        Disposable disposable = this.timerDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        finish();
    }

    private void startTimer() {
        Disposable disposable = this.timerDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        this.timerDisposable = Observable.interval(0L, 50L, TimeUnit.MILLISECONDS).subscribe(new Consumer() { // from class: blackrussia.online.activities.-$$Lambda$StoryActivity$PNJcpFnNdPPf02QxP6B2KTkKds8
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                try {
                    StoryActivity.this.lambda$startTimer$3$StoryActivity((Long) obj);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public /* synthetic */ void lambda$startTimer$3$StoryActivity(final Long aLong) throws Throwable {
        runOnUiThread(new Runnable() { // from class: blackrussia.online.activities.-$$Lambda$StoryActivity$TcDYi1pkh2OcGIjMOlBu6_Z8ODs
            @Override // java.lang.Runnable
            public final void run() {
                StoryActivity.this.lambda$null$2$StoryActivity(aLong);
            }
        });
    }

    public /* synthetic */ void lambda$null$2$StoryActivity(final Long aLong) {
        if (aLong.longValue() >= 300) {
            this.progressStory.setProgress((float) aLong.longValue());
            if (this.sliderView.getCurrentPagePosition() + 1 == this.sliderStoriesAdapter.getCount()) {
                this.timerDisposable.dispose();
                closeStory();
                return;
            } else {
                this.timerDisposable.dispose();
                SliderView sliderView = this.sliderView;
                sliderView.setCurrentPagePosition(sliderView.getCurrentPagePosition() + 1);
                return;
            }
        }
        this.progressStory.setProgress((float) aLong.longValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.timerDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
