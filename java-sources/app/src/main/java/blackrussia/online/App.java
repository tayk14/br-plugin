package blackrussia.online;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import androidx.multidex.MultiDexApplication;
import blackrussia.online.network.AdminsList;
import blackrussia.online.network.BlackPassItemsNew;
import blackrussia.online.network.CarColorItem;
import blackrussia.online.network.DataService;
import blackrussia.online.network.DonateItem;
import blackrussia.online.network.DonateItemList;
import blackrussia.online.network.FamilySystemList;
import blackrussia.online.network.InvItems;
import blackrussia.online.network.ItemsList;
import blackrussia.online.network.Server;
import blackrussia.online.network.ServerListener;
import blackrussia.online.network.SmiList;
import blackrussia.online.network.SocialInteraction;
import blackrussia.online.network.SocialInteractionList;
import blackrussia.online.network.Story;
import blackrussia.online.network.Tune;
import blackrussia.online.network.TuneGuiScreen;
import blackrussia.online.network.TuneList;
import blackrussia.online.network.TuneVinyls;
import blackrussia.online.network.UserAgentInterceptor;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes.dex */
public class App extends MultiDexApplication {
    private static App instance;
    private BlackPassItemsNew blackPassItems;
    private ArrayList<CarColorItem> carColorItems;
    private String currentFolder;
    private HashMap<String, String> dataFiles;
    private ArrayList<DonateItem> donateItems;
    private FamilySystemList familySystemList;
    private ArrayList<AdminsList> fastConnectNick;
    private ArrayList<InvItems> invItems;
    private ArrayList<String> linkList;
    private ArrayList<Server> serverList;
    private ServerListener serverListener;
    private SmiList smiList;
    private ArrayList<SocialInteraction> socialInteractions;
    private boolean startGame;
    private ArrayList<Story> stories;
    private String tempNik;
    private ArrayList<TuneGuiScreen> tuneGuiScreens;
    private ArrayList<Tune> tuneItems;
    private ArrayList<TuneVinyls> tuneVinyls;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        instance = this;
        this.serverList = new ArrayList<>();
        this.donateItems = new ArrayList<>();
        this.carColorItems = new ArrayList<>();
        this.fastConnectNick = new ArrayList<>();
        this.tuneItems = new ArrayList<>();
        this.tuneGuiScreens = new ArrayList<>();
        this.tuneVinyls = new ArrayList<>();
        this.invItems = new ArrayList<>();
        this.socialInteractions = new ArrayList<>();
        this.smiList = new SmiList(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        this.blackPassItems = new BlackPassItemsNew(new ArrayList(), new ArrayList(), new ArrayList(), -1, new ArrayList());
        this.stories = new ArrayList<>();
        this.dataFiles = Preferences.restoreFilesData(this, Preferences.FILES);
        this.familySystemList = new FamilySystemList(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        task(true);
        Observable.interval(15L, TimeUnit.SECONDS).doOnNext(new Consumer() { // from class: blackrussia.online.-$$Lambda$App$lZ0WexSgnOrxgIdlCoFEy2hhIKE
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                try {
                    App.this.lambda$onCreate$0$App((Long) obj);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }).subscribe();
        updateDonateItems(true);
        Observable.interval(15L, TimeUnit.SECONDS).doOnNext(new Consumer() { // from class: blackrussia.online.-$$Lambda$App$hLdCgpXjNF9NLIml0s3LGMM31uM
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                App.this.lambda$onCreate$1$App((Long) obj);
            }
        }).subscribe();
        updateBlackPassItems(true);
        Observable.interval(15L, TimeUnit.SECONDS).doOnNext(new Consumer() { // from class: blackrussia.online.-$$Lambda$App$mp5VmWVtZ3XjGVC2GgX0XNNtniY
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                App.this.lambda$onCreate$2$App((Long) obj);
            }
        }).subscribe();
        updateCarColors(true);
        Observable.interval(15L, TimeUnit.SECONDS).doOnNext(new Consumer() { // from class: blackrussia.online.-$$Lambda$App$k3gCuTga-qCvgCeogxEhnQTGouY
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                App.this.lambda$onCreate$3$App((Long) obj);
            }
        }).subscribe();
        updateFastConnectNicks(true);
        Observable.interval(15L, TimeUnit.SECONDS).doOnNext(new Consumer() { // from class: blackrussia.online.-$$Lambda$App$i8XV1_Nx6_JzHhPY1unV4_04cXo
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                App.this.lambda$onCreate$4$App((Long) obj);
            }
        }).subscribe();
        updateSmiCarAndAccessories(true);
        Observable.interval(15L, TimeUnit.SECONDS).doOnNext(new Consumer() { // from class: blackrussia.online.-$$Lambda$App$R6JWL99L7x4jHMw3mhbhaHPvZH8
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                App.this.lambda$onCreate$5$App((Long) obj);
            }
        }).subscribe();
        updateTuneItems(true);
        Observable.interval(15L, TimeUnit.SECONDS).doOnNext(new Consumer() { // from class: blackrussia.online.-$$Lambda$App$Jbrfv8alSfRv_Xqb1Seuv2OMe8g
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                App.this.lambda$onCreate$6$App((Long) obj);
            }
        }).subscribe();
        updateTuneGuiScreens(true);
        Observable.interval(15L, TimeUnit.SECONDS).doOnNext(new Consumer() { // from class: blackrussia.online.-$$Lambda$App$1gezz8RLKA3DOYKCFmsrt-ed1Jw
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                App.this.lambda$onCreate$7$App((Long) obj);
            }
        }).subscribe();
        updateTuneVinyls(true);
        Observable.interval(15L, TimeUnit.SECONDS).doOnNext(new Consumer() { // from class: blackrussia.online.-$$Lambda$App$DMwbfWrCQag_PwwfIjXNsNm8sz4
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                App.this.lambda$onCreate$8$App((Long) obj);
            }
        }).subscribe();
        updateInvItems(true);
        Observable.interval(15L, TimeUnit.SECONDS).doOnNext(new Consumer() { // from class: blackrussia.online.-$$Lambda$App$bdypMj565uOIqRw5_E6zWk6r_A0
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                App.this.lambda$onCreate$9$App((Long) obj);
            }
        }).subscribe();
        updateSocialInteraction(true);
        Observable.interval(15L, TimeUnit.SECONDS).doOnNext(new Consumer() { // from class: blackrussia.online.-$$Lambda$App$_r1Y3UX9SuUGi8QbWUYsm0VbaSY
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                App.this.lambda$onCreate$10$App((Long) obj);
            }
        }).subscribe();
        updateFamilySystemList(true);
        Observable.interval(15L, TimeUnit.SECONDS).doOnNext(new Consumer() { // from class: blackrussia.online.-$$Lambda$App$64ZfD6i6F4LZJTNZQlMpgOKdNhg
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                App.this.lambda$onCreate$11$App((Long) obj);
            }
        }).subscribe();
        this.linkList = new ArrayList<>();
        downloadLinkList(Settings.URL_DOWNLOAD_LIST);
    }

    public /* synthetic */ void lambda$onCreate$0$App(Long n) throws Throwable {
        task(false);
    }

    public /* synthetic */ void lambda$onCreate$1$App(Long n) throws Throwable {
        updateDonateItems(false);
    }

    public /* synthetic */ void lambda$onCreate$2$App(Long n) throws Throwable {
        updateBlackPassItems(false);
    }

    public /* synthetic */ void lambda$onCreate$3$App(Long n) throws Throwable {
        updateCarColors(false);
    }

    public /* synthetic */ void lambda$onCreate$4$App(Long n) throws Throwable {
        updateFastConnectNicks(false);
    }

    public /* synthetic */ void lambda$onCreate$5$App(Long n) throws Throwable {
        updateSmiCarAndAccessories(false);
    }

    public /* synthetic */ void lambda$onCreate$6$App(Long n) throws Throwable {
        updateTuneItems(false);
    }

    public /* synthetic */ void lambda$onCreate$7$App(Long n) throws Throwable {
        updateTuneGuiScreens(false);
    }

    public /* synthetic */ void lambda$onCreate$8$App(Long n) throws Throwable {
        updateTuneVinyls(false);
    }

    public /* synthetic */ void lambda$onCreate$9$App(Long n) throws Throwable {
        updateInvItems(false);
    }

    public /* synthetic */ void lambda$onCreate$10$App(Long n) throws Throwable {
        updateSocialInteraction(false);
    }

    public /* synthetic */ void lambda$onCreate$11$App(Long n) throws Throwable {
        updateFamilySystemList(false);
    }

    private void updateFastConnectNicks(boolean isNeed) {
        if (isNeed || this.fastConnectNick.size() <= 0) {
            DataService.getInstance().getApiService().getFastConnectNicks().enqueue(new Callback<ArrayList<AdminsList>>() { // from class: blackrussia.online.App.1
                @Override // retrofit2.Callback
                public void onFailure(Call<ArrayList<AdminsList>> call, Throwable t) {
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<ArrayList<AdminsList>> call, Response<ArrayList<AdminsList>> response) {
                    if (response.body() != null) {
                        App.this.fastConnectNick.clear();
                        App.this.fastConnectNick.addAll(response.body());
                    }
                }
            });
        }
    }

    private void updateSmiCarAndAccessories(boolean isNeed) {
        if (isNeed || this.smiList.getLowClass().size() <= 0) {
            DataService.getInstance().getApiService().getSmiList().enqueue(new Callback<SmiList>() { // from class: blackrussia.online.App.2
                @Override // retrofit2.Callback
                public void onFailure(Call<SmiList> call, Throwable t) {
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<SmiList> call, Response<SmiList> response) {
                    if (response.body() != null) {
                        App.this.smiList.getLowClass().clear();
                        App.this.smiList.getLowClass().addAll(response.body().getLowClass());
                        App.this.smiList.getCarMiddleClass().clear();
                        App.this.smiList.getCarMiddleClass().addAll(response.body().getCarMiddleClass());
                        App.this.smiList.getCarHighClass().clear();
                        App.this.smiList.getCarHighClass().addAll(response.body().getCarHighClass());
                        App.this.smiList.getCarMotoClass().clear();
                        App.this.smiList.getCarMotoClass().addAll(response.body().getCarMotoClass());
                        App.this.smiList.getCarUniqueClass().clear();
                        App.this.smiList.getCarUniqueClass().addAll(response.body().getCarUniqueClass());
                        App.this.smiList.getAccessoriesList().clear();
                        App.this.smiList.getAccessoriesList().addAll(response.body().getAccessoriesList());
                    }
                }
            });
        }
    }

    private void updateFamilySystemList(boolean isNeed) {
        if (isNeed || this.familySystemList.getUpgradeList().size() <= 0) {
            DataService.getInstance().getApiService().getFamilySystemList().enqueue(new Callback<FamilySystemList>() { // from class: blackrussia.online.App.3
                @Override // retrofit2.Callback
                public void onFailure(Call<FamilySystemList> call, Throwable t) {
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<FamilySystemList> call, Response<FamilySystemList> response) {
                    if (response.body() != null) {
                        App.this.familySystemList.getUpgradeList().clear();
                        App.this.familySystemList.getUpgradeList().addAll(response.body().getUpgradeList());
                        App.this.familySystemList.getRewardTopList().clear();
                        App.this.familySystemList.getRewardTopList().addAll(response.body().getRewardTopList());
                        App.this.familySystemList.getShopList().clear();
                        App.this.familySystemList.getShopList().addAll(response.body().getShopList());
                        App.this.familySystemList.getTasksList().clear();
                        App.this.familySystemList.getTasksList().addAll(response.body().getTasksList());
                        App.this.familySystemList.getColorsList().clear();
                        App.this.familySystemList.getColorsList().addAll(response.body().getColorsList());
                    }
                }
            });
        }
    }

    private void updateTuneGuiScreens(boolean isNeed) {
        if (isNeed || this.tuneGuiScreens.size() <= 0) {
            DataService.getInstance().getApiService().getTuneScreens().enqueue(new Callback<ArrayList<TuneGuiScreen>>() { // from class: blackrussia.online.App.4
                @Override // retrofit2.Callback
                public void onResponse(Call<ArrayList<TuneGuiScreen>> call, Response<ArrayList<TuneGuiScreen>> response) {
                    if (response.body() != null) {
                        App.this.tuneGuiScreens.clear();
                        App.this.tuneGuiScreens.addAll(response.body());
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<ArrayList<TuneGuiScreen>> call, Throwable t) {
                    System.out.println(t.toString());
                }
            });
        }
    }

    private void updateTuneItems(boolean isNeed) {
        if (isNeed || this.tuneItems.size() <= 0) {
            DataService.getInstance().getApiService().getTuneItems().enqueue(new Callback<TuneList>() { // from class: blackrussia.online.App.5
                @Override // retrofit2.Callback
                public void onFailure(Call<TuneList> call, Throwable t) {
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<TuneList> call, Response<TuneList> response) {
                    if (response.body() != null) {
                        App.this.tuneItems.clear();
                        App.this.tuneItems.addAll(response.body().getArray());
                    }
                }
            });
        }
    }

    private void updateDonateItems(boolean isNeed) {
        if (isNeed || this.donateItems.size() <= 0) {
            DataService.getInstance().getApiService().getDonateItems().enqueue(new Callback<DonateItemList>() { // from class: blackrussia.online.App.6
                @Override // retrofit2.Callback
                public void onFailure(Call<DonateItemList> call, Throwable t) {
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<DonateItemList> call, Response<DonateItemList> response) {
                    if (response.body() != null) {
                        App.this.donateItems.clear();
                        App.this.donateItems.addAll(response.body().getArray());
                    }
                }
            });
        }
    }

    private void updateCarColors(boolean isNeed) {
        if (isNeed || this.carColorItems.size() <= 0) {
            DataService.getInstance().getApiService().getCarColors().enqueue(new Callback<ArrayList<CarColorItem>>() { // from class: blackrussia.online.App.7
                @Override // retrofit2.Callback
                public void onFailure(Call<ArrayList<CarColorItem>> call, Throwable t) {
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<ArrayList<CarColorItem>> call, Response<ArrayList<CarColorItem>> response) {
                    if (response.body() != null) {
                        App.this.carColorItems.clear();
                        App.this.carColorItems.addAll(response.body());
                    }
                }
            });
        }
    }

    private void updateTuneVinyls(boolean isNeed) {
        if (isNeed || this.tuneVinyls.size() <= 0) {
            DataService.getInstance().getApiService().getTuneVinyls().enqueue(new Callback<ArrayList<TuneVinyls>>() { // from class: blackrussia.online.App.8
                @Override // retrofit2.Callback
                public void onFailure(Call<ArrayList<TuneVinyls>> call, Throwable t) {
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<ArrayList<TuneVinyls>> call, Response<ArrayList<TuneVinyls>> response) {
                    if (response.body() != null) {
                        App.this.tuneVinyls.clear();
                        App.this.tuneVinyls.addAll(response.body());
                    }
                }
            });
        }
    }

    private void updateInvItems(boolean isNeed) {
        if (isNeed || this.invItems.size() <= 0) {
            DataService.getInstance().getApiService().getItems().enqueue(new Callback<ItemsList>() { // from class: blackrussia.online.App.9
                @Override // retrofit2.Callback
                public void onFailure(Call<ItemsList> call, Throwable t) {
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<ItemsList> call, Response<ItemsList> response) {
                    if (response.body() != null) {
                        App.this.invItems.clear();
                        App.this.invItems.addAll(response.body().getArrayItems());
                    }
                }
            });
        }
    }

    private void updateSocialInteraction(boolean isNeed) {
        if (isNeed || this.socialInteractions.size() <= 0) {
            DataService.getInstance().getApiService().getSocialList().enqueue(new Callback<SocialInteractionList>() { // from class: blackrussia.online.App.10
                @Override // retrofit2.Callback
                public void onFailure(Call<SocialInteractionList> call, Throwable t) {
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<SocialInteractionList> call, Response<SocialInteractionList> response) {
                    if (response.body() != null) {
                        App.this.socialInteractions.clear();
                        App.this.socialInteractions.addAll(response.body().getArraySocialInteraction());
                    }
                }
            });
        }
    }

    private void updateBlackPassItems(boolean isNeed) {
        if (isNeed || this.blackPassItems.getStandartLevel().size() <= 0) {
            DataService.getInstance().getApiService().getBlackPassItems().enqueue(new Callback<BlackPassItemsNew>() { // from class: blackrussia.online.App.11
                @Override // retrofit2.Callback
                public void onFailure(Call<BlackPassItemsNew> call, Throwable t) {
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<BlackPassItemsNew> call, Response<BlackPassItemsNew> response) {
                    if (response.body() != null) {
                        App.this.blackPassItems.getStandartLevel().clear();
                        App.this.blackPassItems.getStandartLevel().addAll(response.body().getStandartLevel());
                        App.this.blackPassItems.getPremiumLevel().clear();
                        App.this.blackPassItems.getPremiumLevel().addAll(response.body().getPremiumLevel());
                        App.this.blackPassItems.getMarathonLevel().clear();
                        App.this.blackPassItems.getMarathonLevel().addAll(response.body().getMarathonLevel());
                        App.this.blackPassItems.setLevelPrices(response.body().getLevelPrices());
                        App.this.blackPassItems.getTasks().clear();
                        App.this.blackPassItems.getTasks().addAll(response.body().getTasks());
                    }
                }
            });
        }
    }

    private void task(boolean isNeed) {
        if (isNeed || this.serverListener != null) {
            DataService.getInstance().getApiService().getServers().enqueue(new Callback<ArrayList<Server>>() { // from class: blackrussia.online.App.12
                @Override // retrofit2.Callback
                public void onFailure(Call<ArrayList<Server>> call, Throwable t) {
                }

                @Override // retrofit2.Callback
                public void onResponse(Call<ArrayList<Server>> call, Response<ArrayList<Server>> response) {
                    if (response.body() != null) {
                        App.this.serverList.clear();
                        App.this.serverList.addAll(response.body());
                        if (App.this.serverListener != null) {
                            App.this.serverListener.onChange();
                        }
                    }
                }
            });
        }
    }

    public static boolean isExternalStorageAvailable(Activity activity) {
        try {
            activity.getExternalFilesDir(null).getAbsolutePath();
            return true;
        } catch (Exception unused) {
            Toast.makeText(activity, activity.getResources().getString(R.string.noExternalStorage), 1).show();
            return false;
        }
    }

    public static App getInstance() {
        return instance;
    }

    public static String isClassPresent(Context context) {
        try {
            Class.forName("com.save");
            return "present";
        } catch (ClassNotFoundException unused) {
            return "clear";
        }
    }

    public static long getFileLength(Context context) {
        try {
            return context.getAssets().openFd("Text/japanese.gxt").getLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String getInput(Context context) {
        return "NULL|3.62|" + getFileLength(context) + "|" + isClassPresent(context);
    }

    public ArrayList<Server> getServerList() {
        return this.serverList;
    }

    public ServerListener getServerListener() {
        return this.serverListener;
    }

    public void setServerListener(ServerListener serverListener) {
        this.serverListener = serverListener;
    }

    public ArrayList<Tune> getTuneItems() {
        return this.tuneItems;
    }

    public ArrayList<TuneGuiScreen> getTuneGuiScreens() {
        return this.tuneGuiScreens;
    }

    public SmiList getSmiListItems() {
        return this.smiList;
    }

    public ArrayList<DonateItem> getDonateItems() {
        return this.donateItems;
    }

    public ArrayList<CarColorItem> getCarColorItems() {
        return this.carColorItems;
    }

    public BlackPassItemsNew getBlackPassItems() {
        return this.blackPassItems;
    }

    public ArrayList<AdminsList> getFastConnectNicks() {
        return this.fastConnectNick;
    }

    public void setCurrentFolder(String currentFolder) {
        this.currentFolder = currentFolder;
    }

    public String getCurrentFolder() {
        return this.currentFolder;
    }

    public HashMap<String, String> getDataFiles() {
        return this.dataFiles;
    }

    public String getTempNik() {
        return this.tempNik;
    }

    public ArrayList<Story> getStories() {
        return this.stories;
    }

    public void setStories(ArrayList<Story> stories) {
        this.stories = stories;
    }

    public void setTempNik(String tempNik) {
        this.tempNik = tempNik;
    }

    public boolean isStartGame() {
        return this.startGame;
    }

    public void setStartGame(boolean startGame) {
        this.startGame = startGame;
    }

    public ArrayList<String> getLinkList() {
        return this.linkList;
    }

    public ArrayList<TuneVinyls> getTuneVinyls() {
        return this.tuneVinyls;
    }

    public ArrayList<InvItems> getInvItems() {
        return this.invItems;
    }

    public ArrayList<SocialInteraction> getSocialInteractions() {
        return this.socialInteractions;
    }

    public FamilySystemList getFamilySystemList() {
        return this.familySystemList;
    }

    public void downloadLinkList(String urlList) {
        final Request build = new Request.Builder().url(urlList).build();
        final OkHttpClient build2 = new OkHttpClient.Builder().addInterceptor(new UserAgentInterceptor("")).build();
        new Thread(new Runnable() { // from class: blackrussia.online.-$$Lambda$App$7ooOeNwcerlhsGf8-2RhrUiqAPw
            @Override // java.lang.Runnable
            public final void run() {
                App.this.lambda$downloadLinkList$12$App(build2, build);
            }
        }).start();
    }

    public /* synthetic */ void lambda$downloadLinkList$12$App(final OkHttpClient client, final Request request) {
        try {
            okhttp3.Response execute = client.newCall(request).execute();
            if (execute.body() != null) {
                String string = execute.body().string();
                this.linkList.clear();
                this.linkList.addAll(Arrays.asList(string.split("\n")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int rnd(int max) {
        double random = Math.random();
        double d = max;
        Double.isNaN(d);
        return (int) (random * d);
    }
}
