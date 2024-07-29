package blackrussia.online.network;

import blackrussia.online.network.fraction.data.FractionQuestsObj;
import blackrussia.online.network.fraction.data.FractionsDocumentsObjList;
import com.rockstargames.gtacr.data.FractionsShopList;
import com.rockstargames.gtacr.gui.spawnLocation.data.SpawnLocationList;
import io.reactivex.rxjava3.core.Single;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("/app/auth.php")
    Call<Auth> getAuth(@Query("server") String server, @Query("color") String color, @Query("name") String name, @Query("pass") String pass, @Query("token") String token);

    @GET("black-pass.json")
    Call<BlackPassItemsNew> getBlackPassItems();

    @GET("black-pass-test.json")
    Call<BlackPassItemsNew> getBlackPassTestItems();

    @GET("car-colors.json")
    Call<ArrayList<CarColorItem>> getCarColors();

    @GET("donate-items.json")
    Call<DonateItemList> getDonateItems();

    @GET("donate-items-test.json")
    Call<DonateItemList> getDonateItemsTest();

    @GET("/client/family_system.json")
    Call<FamilySystemList> getFamilySystemList();

    @GET("admins-list.json")
    Call<ArrayList<AdminsList>> getFastConnectNicks();

    @GET("api.json")
    Call<ArrayList<MyFile>> getFiles();

    @GET("/client/fractionMenuDocuments.json")
    Single<FractionsDocumentsObjList> getFractionDocumentsList();

    @GET("/client/fractionTask.json")
    Single<FractionQuestsObj> getFractionQuestsObj();

    @GET("/client/fractionMenuStore.json")
    Single<FractionsShopList> getFractionShopList();

    @GET("/client/inventory.json")
    Call<ItemsList> getItems();

    @GET("/app/roulette.php")
    Call<Prize> getRoulette(@Query("server") String server, @Query("color") String color, @Query("name") String name, @Query("pass") String pass);

    @GET("servers.json")
    Call<ArrayList<Server>> getServers();

    @GET("cars-and-accessories.json")
    Call<SmiList> getSmiList();

    @GET("/client/social-interaction.json")
    Call<SocialInteractionList> getSocialList();

    @GET("/client/spawnLocation.json")
    Single<SpawnLocationList> getSpawnLocationList();

    @GET("stories.json")
    Call<ArrayList<Story>> getStories();

    @GET("/client/inventory_test.json")
    Call<ItemsList> getTestItems();

    @GET("text1.json")
    Call<ArrayList<TextLoader>> getTextLoader();

    @GET("tune-items.json")
    Call<TuneList> getTuneItems();

    @GET("tune-items-test.json")
    Call<TuneList> getTuneItemsTest();

    @GET("tune-screens.json")
    Call<ArrayList<TuneGuiScreen>> getTuneScreens();

    @GET("tune-vinyls.json")
    Call<ArrayList<TuneVinyls>> getTuneVinyls();

    @GET("tune-vinyls-test.json")
    Call<ArrayList<TuneVinyls>> getTuneVinylsTest();
}
