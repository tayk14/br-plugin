package blackrussia.online.fragments;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import blackrussia.online.App;
import blackrussia.online.Preferences;
import blackrussia.online.R;
import blackrussia.online.activities.AuthorizationActivity;
import blackrussia.online.activities.PrizeActivity;
import blackrussia.online.adapters.RouletteAdapter;
import blackrussia.online.network.Auth;
import blackrussia.online.network.AuthListener;
import blackrussia.online.network.DataService;
import blackrussia.online.network.Prize;
import blackrussia.online.network.RouletteListener;
import java.util.ArrayList;
import java.util.Random;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes.dex */
public class RouletteFragment extends Fragment {
    private LinearLayout account;
    private TextView balance;
    private Handler handler = new Handler();
    private ArrayList<Integer> images;
    private boolean isRouletteBlocked;
    private MediaPlayer mp;
    private TextView nik;
    private TextView serverName;
    private String userBalance;
    private String userColor;
    private String userName;
    private String userPassword;
    private String userServer;
    private ViewPager2 viewPager;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.isRouletteBlocked = false;
        View inflate = inflater.inflate(R.layout.fragment_roulette, container, false);
        this.account = (LinearLayout) inflate.findViewById(R.id.account);
        this.nik = (TextView) inflate.findViewById(R.id.nik);
        this.serverName = (TextView) inflate.findViewById(R.id.serverName);
        this.balance = (TextView) inflate.findViewById(R.id.balance);
        this.userName = Preferences.getString(App.getInstance(), Preferences.USER_NAME);
        this.userPassword = Preferences.getString(App.getInstance(), Preferences.USER_PASSWORD);
        this.userServer = Preferences.getString(App.getInstance(), Preferences.USER_SERVER).toUpperCase();
        this.userColor = Preferences.getString(App.getInstance(), Preferences.USER_COLOR);
        this.userBalance = Preferences.getString(App.getInstance(), Preferences.USER_BALANCE);
        if (!this.userName.isEmpty()) {
            setUserData();
            getData(new AuthListener() { // from class: blackrussia.online.fragments.-$$Lambda$RouletteFragment$uzRFEB8P7-dqKBpc51XuPNgVohA
                @Override // blackrussia.online.network.AuthListener
                public final void onLoad(Auth auth) {
                    RouletteFragment.this.lambda$onCreateView$0$RouletteFragment(auth);
                }
            }, this.userServer, this.userColor, this.userName, this.userPassword);
        }
        ((ImageView) inflate.findViewById(R.id.quit)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$RouletteFragment$ToWzjXbY2gt-ajTwH2FHEA9lQOw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RouletteFragment.this.lambda$onCreateView$1$RouletteFragment(view);
            }
        });
        ((TextView) inflate.findViewById(R.id.twist)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$RouletteFragment$MX7-TxiutiI3jTe_OiekFTIGqkM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RouletteFragment.this.lambda$onCreateView$2$RouletteFragment(view);
            }
        });
        this.mp = MediaPlayer.create(App.getInstance(), R.raw.roulette);
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.images = arrayList;
        arrayList.add(Integer.valueOf(R.drawable.roulette_backpack));
        this.images.add(Integer.valueOf(R.drawable.roulette_bag));
        this.images.add(Integer.valueOf(R.drawable.roulette_cap));
        this.images.add(Integer.valueOf(R.drawable.roulette_watch));
        this.images.add(Integer.valueOf(R.drawable.roulette_currency));
        this.images.add(Integer.valueOf(R.drawable.roulette_donate));
        this.images.add(Integer.valueOf(R.drawable.roulette_experience));
        this.images.add(Integer.valueOf(R.drawable.roulette_slot_auto));
        this.images.add(Integer.valueOf(R.drawable.roulette_glass));
        this.images.add(Integer.valueOf(R.drawable.roulette_guitar));
        this.images.add(Integer.valueOf(R.drawable.roulette_gun));
        this.images.add(Integer.valueOf(R.drawable.roulette_crown_silver));
        this.images.add(Integer.valueOf(R.drawable.roulette_crown_gold));
        this.images.add(Integer.valueOf(R.drawable.roulette_crown_platinum));
        this.images.add(Integer.valueOf(R.drawable.roulette_military_ticket));
        this.images.add(Integer.valueOf(R.drawable.roulette_car));
        this.images.add(Integer.valueOf(R.drawable.roulette_all_license));
        this.images.add(Integer.valueOf(R.drawable.roulette_number_car));
        this.images.add(Integer.valueOf(R.drawable.roulette_skin));
        this.viewPager = (ViewPager2) inflate.findViewById(R.id.viewPager);
        this.viewPager.setAdapter(new RouletteAdapter(App.getInstance(), this.images));
        this.viewPager.setCurrentItem((this.images.size() * 100000) + new Random().nextInt(this.images.size()), false);
        this.viewPager.setOffscreenPageLimit(100);
        this.viewPager.setUserInputEnabled(false);
        this.viewPager.setPageTransformer(new MarginPageTransformer(getResources().getDimensionPixelSize(R.dimen._10sdp)));
        return inflate;
    }

    public /* synthetic */ void lambda$onCreateView$0$RouletteFragment(Auth auth) {
        try {
            if (auth.getAuth()) {
                this.userName = auth.getName();
                this.userPassword = auth.getPass();
                this.userServer = auth.getServer().toUpperCase();
                this.userColor = auth.getColor();
                this.userBalance = auth.getBalance();
                saveUserData();
                setUserData();
                if (!auth.getMessage().isEmpty()) {
                    Toast.makeText(getActivity(), auth.getMessage(), 1).show();
                }
            } else {
                setQuit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$onCreateView$1$RouletteFragment(View view1) {
        view1.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$RouletteFragment$6yVO5U3yY4N2RRBD7NT5RBKaYvg
            @Override // java.lang.Runnable
            public final void run() {
                RouletteFragment.this.onClickQuit();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$onCreateView$2$RouletteFragment(View view1) {
        view1.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$RouletteFragment$rvc4MAXNezf7_rn2b0N7DEMPmuY
            @Override // java.lang.Runnable
            public final void run() {
                RouletteFragment.this.onClickTwist();
            }
        }, 200L);
    }

    private void setCurrentItem(int item, long duration, AccelerateDecelerateInterpolator interpolator, final ViewPager2 viewPager) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, viewPager.getWidth() * (item - viewPager.getCurrentItem()));
        final float[] fArr = {0.0f};
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: blackrussia.online.fragments.-$$Lambda$RouletteFragment$G8hpJxD2SGABsl4iaA503Bjovww
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RouletteFragment.lambda$setCurrentItem$3(fArr, viewPager, valueAnimator);
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: blackrussia.online.fragments.RouletteFragment.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                viewPager.beginFakeDrag();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPager.endFakeDrag();
            }
        });
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(duration);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setCurrentItem$3(final float[] previousValue, final ViewPager2 viewPager, ValueAnimator valueAnimator) {
        float intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        viewPager.fakeDragBy(-(intValue - previousValue[0]));
        previousValue[0] = intValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 111 && resultCode == -1 && data != null) {
            this.userName = data.getStringExtra("userName");
            this.userPassword = data.getStringExtra("userPassword");
            this.userServer = data.getStringExtra("userServer");
            this.userColor = data.getStringExtra("userColor");
            this.userBalance = data.getStringExtra("userBalance");
            saveUserData();
            setUserData();
        }
    }

    public boolean isRouletteBlocked() {
        return this.isRouletteBlocked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickTwist() {
        if (this.userName.isEmpty()) {
            startActivityForResult(new Intent(getActivity(), (Class<?>) AuthorizationActivity.class), 111);
        } else {
            if (this.isRouletteBlocked) {
                return;
            }
            this.isRouletteBlocked = true;
            getRoulette(new RouletteListener() { // from class: blackrussia.online.fragments.-$$Lambda$RouletteFragment$tXA1e-mtHfi8lwORWo0vOhys8NE
                @Override // blackrussia.online.network.RouletteListener
                public final void onLoad(Prize prize) {
                    RouletteFragment.this.lambda$onClickTwist$6$RouletteFragment(prize);
                }
            }, this.userServer, this.userColor, this.userName, this.userPassword);
        }
    }

    public /* synthetic */ void lambda$onClickTwist$6$RouletteFragment(final Prize prize) {
        int i = 0;
        if (prize.getAuth()) {
            if (prize.getError()) {
                Toast.makeText(App.getInstance(), prize.getMessage(), 1).show();
                this.isRouletteBlocked = false;
                return;
            }
            if (!prize.getMessage().isEmpty()) {
                Toast.makeText(getActivity(), prize.getMessage(), 1).show();
            }
            if (this.mp.isPlaying()) {
                this.mp.stop();
                this.mp.release();
                this.mp = MediaPlayer.create(App.getInstance(), R.raw.roulette);
            }
            this.mp.start();
            int objectPrize = prize.getObjectPrize();
            if (objectPrize != 0) {
                if (objectPrize == 1) {
                    i = 1;
                } else if (objectPrize == 2) {
                    i = 2;
                } else if (objectPrize == 3) {
                    i = 3;
                } else if (objectPrize == 4) {
                    i = 4;
                } else if (objectPrize == 5) {
                    i = 5;
                } else if (objectPrize == 6) {
                    i = 6;
                } else if (objectPrize == 7) {
                    i = 7;
                } else if (objectPrize == 8) {
                    i = 8;
                } else if (objectPrize == 9) {
                    i = 9;
                } else if (objectPrize == 10) {
                    i = 10;
                } else if (objectPrize == 11) {
                    i = 11;
                } else if (objectPrize == 12) {
                    i = 12;
                } else if (objectPrize == 13) {
                    i = 13;
                } else if (objectPrize == 16) {
                    i = 14;
                } else if (objectPrize == 19 || objectPrize == 20) {
                    i = 15;
                } else if (objectPrize == 21) {
                    i = 16;
                } else if (objectPrize == 22) {
                    i = 17;
                } else if (objectPrize == 23) {
                    i = 18;
                }
                final int size = this.images.size() * (new Random().nextInt(5) + 3);
                int finalI = i;
                new Handler().postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$RouletteFragment$Xs9W5KetW3pulVBMp7YlOsH9sMA
                    @Override // java.lang.Runnable
                    public final void run() {
                        RouletteFragment.this.lambda$null$4$RouletteFragment(size, finalI);
                    }
                }, 400L);
                final Intent intent = new Intent(App.getInstance(), (Class<?>) PrizeActivity.class);
                intent.putExtra("title", prize.getTitle());
                intent.putExtra("count", prize.getCount());
                intent.putExtra("object", prize.getObjectPrize());
                int finalI1 = i;
                new Handler().postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$RouletteFragment$3SQYs2aSLxsA9oumW2lsG8lvs3g
                    @Override // java.lang.Runnable
                    public final void run() {
                        RouletteFragment.this.lambda$null$5$RouletteFragment(prize, finalI1, intent);
                    }
                }, 6500L);
                return;
            }
            i = 0;
            final int size2 = this.images.size() * (new Random().nextInt(5) + 3);
            int finalI2 = i;
            new Handler().postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$RouletteFragment$Xs9W5KetW3pulVBMp7YlOsH9sMA
                @Override // java.lang.Runnable
                public final void run() {
                    RouletteFragment.this.lambda$null$4$RouletteFragment(size2, finalI2);
                }
            }, 400L);
            final Intent intent2 = new Intent(App.getInstance(), (Class<?>) PrizeActivity.class);
            intent2.putExtra("title", prize.getTitle());
            intent2.putExtra("count", prize.getCount());
            intent2.putExtra("object", prize.getObjectPrize());
            int finalI3 = i;
            new Handler().postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$RouletteFragment$3SQYs2aSLxsA9oumW2lsG8lvs3g
                @Override // java.lang.Runnable
                public final void run() {
                    RouletteFragment.this.lambda$null$5$RouletteFragment(prize, finalI3, intent2);
                }
            }, 6500L);
            return;
        }
        setQuit();
        startActivityForResult(new Intent(getActivity(), (Class<?>) AuthorizationActivity.class), 111);
    }

    public /* synthetic */ void lambda$null$4$RouletteFragment(final int rand, final int finalItem) {
        setCurrentItem((this.images.size() * 100000) + rand + finalItem, 5500L, null, this.viewPager);
    }

    public /* synthetic */ void lambda$null$5$RouletteFragment(final Prize prize, final int finalItem, final Intent intent) {
        this.userBalance = prize.getBalance();
        this.balance.setText(String.format(getString(R.string.balance), this.userBalance));
        Preferences.putString(App.getInstance(), Preferences.USER_BALANCE, this.userBalance);
        this.viewPager.setCurrentItem((this.images.size() * 100000) + finalItem, false);
        this.isRouletteBlocked = false;
        startActivity(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mp.isPlaying()) {
            this.mp.stop();
            this.mp.release();
            this.mp = MediaPlayer.create(App.getInstance(), R.raw.roulette);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickQuit() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.item_dialog_settings);
        dialog.setCancelable(true);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(-1, -2);
        ((TextView) dialog.findViewById(R.id.message)).setText(App.getInstance().getResources().getString(R.string.quitQ));
        ((TextView) dialog.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$RouletteFragment$C4dTETu0nrth-hKzhpOcsYA_txk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RouletteFragment.this.lambda$onClickQuit$7$RouletteFragment(dialog, view);
            }
        });
        ((TextView) dialog.findViewById(R.id.ok)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$RouletteFragment$OAeHYaIlQO1d5j_AdVuARKrWscc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RouletteFragment.this.lambda$onClickQuit$9$RouletteFragment(dialog, view);
            }
        });
        dialog.show();
    }

    public /* synthetic */ void lambda$onClickQuit$7$RouletteFragment(final Dialog dialog, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        Handler handler = this.handler;
        dialog.getClass();
        handler.postDelayed(new $$Lambda$G2sZv_QBDDjB3nPadjUdMmz4hc(dialog), 200L);
    }

    public /* synthetic */ void lambda$onClickQuit$9$RouletteFragment(final Dialog dialog, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$RouletteFragment$Iy6CXk2MkBnEZynkqxTA3kjQmj0
            @Override // java.lang.Runnable
            public final void run() {
                RouletteFragment.this.lambda$null$8$RouletteFragment(dialog);
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$8$RouletteFragment(final Dialog dialog) {
        setQuit();
        dialog.dismiss();
    }

    private void setUserData() {
        this.nik.setText(this.userName);
        this.serverName.setText(this.userServer);
        this.serverName.setTextColor(Color.parseColor("#" + this.userColor));
        this.balance.setText(String.format(getString(R.string.balance), this.userBalance));
        this.account.setVisibility(0);
    }

    private void saveUserData() {
        Preferences.putString(App.getInstance(), Preferences.USER_NAME, this.userName);
        Preferences.putString(App.getInstance(), Preferences.USER_PASSWORD, this.userPassword);
        Preferences.putString(App.getInstance(), Preferences.USER_SERVER, this.userServer);
        Preferences.putString(App.getInstance(), Preferences.USER_COLOR, this.userColor);
        Preferences.putString(App.getInstance(), Preferences.USER_BALANCE, this.userBalance);
    }

    private void setQuit() {
        this.userName = "";
        this.userPassword = "";
        this.userServer = "";
        this.userColor = "";
        this.userBalance = "";
        saveUserData();
        this.account.setVisibility(8);
    }

    private void getData(final AuthListener authListener, String userServer, String userColor, String userName, String userPassword) {
        DataService.getInstance().getApiService().getAuth(userServer.toLowerCase(), userColor, userName, userPassword, "").enqueue(new Callback<Auth>() { // from class: blackrussia.online.fragments.RouletteFragment.2
            @Override // retrofit2.Callback
            public void onFailure(Call<Auth> call, Throwable t) {
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<Auth> call, Response<Auth> response) {
                if (response.body() != null) {
                    Auth body = response.body();
                    AuthListener authListener2 = authListener;
                    if (authListener2 != null) {
                        authListener2.onLoad(body);
                    }
                }
            }
        });
    }

    private void getRoulette(final RouletteListener authListener, String userServer, String userColor, String userName, String userPassword) {
        DataService.getInstance().getApiService().getRoulette(userServer.toLowerCase(), userColor, userName, userPassword).enqueue(new Callback<Prize>() { // from class: blackrussia.online.fragments.RouletteFragment.3
            @Override // retrofit2.Callback
            public void onResponse(Call<Prize> call, Response<Prize> response) {
                if (response.body() != null) {
                    Prize body = response.body();
                    RouletteListener rouletteListener = authListener;
                    if (rouletteListener != null) {
                        rouletteListener.onLoad(body);
                        return;
                    }
                    return;
                }
                Toast.makeText(App.getInstance(), RouletteFragment.this.getString(R.string.roulette_error_connection), 1).show();
                RouletteFragment.this.isRouletteBlocked = false;
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<Prize> call, Throwable t) {
                Toast.makeText(App.getInstance(), RouletteFragment.this.getString(R.string.roulette_error_connection), 1).show();
                RouletteFragment.this.isRouletteBlocked = false;
            }
        });
    }
}
