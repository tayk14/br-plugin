package blackrussia.online.network;

import android.widget.Toast;
import blackrussia.online.App;
import blackrussia.online.Settings;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataService {
    private static DataService instance;
    private boolean wasChangedAPI = false;
    private Retrofit retrofit = new Retrofit.Builder().client(new OkHttpClient.Builder().addInterceptor(new UserAgentInterceptor("")).build()).baseUrl(Settings.API3).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();

    private DataService() {
    }

    public static DataService getInstance() {
        if (instance == null) {
            instance = new DataService();
        }
        return instance;
    }

    public Api getApiService() {
        return (Api) this.retrofit.create(Api.class);
    }

    public void changeAPI() {
        if (this.wasChangedAPI) {
            return;
        }
        this.retrofit = new Retrofit.Builder().client(new OkHttpClient.Builder().addInterceptor(new UserAgentInterceptor("")).build()).baseUrl(Settings.API3).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build();
        this.wasChangedAPI = true;
        Toast.makeText(App.getInstance(), "Переадресовано на резервное api", 1).show();
    }
}
