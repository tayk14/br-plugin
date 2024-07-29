package blackrussia.online.network;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import kotlin.Metadata;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003Jm\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006*"}, d2 = {"Lblackrussia/online/network/FamilySystemUpgradeObj;", "", GetKeys.GET_PLAYERS_ID, "", "level", "money", "materials", "masks", "gasoline", "armour", "people", "ammo", FirebaseAnalytics.Param.PRICE, "(IIIIIIIIII)V", "getAmmo", "()I", "getArmour", "getGasoline", "getId", "getLevel", "getMasks", "getMaterials", "getMoney", "getPeople", "getPrice", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilySystemUpgradeObj {
    @SerializedName("ammo")
    private final int ammo;
    @SerializedName("armour")
    private final int armour;
    @SerializedName("gasoline")
    private final int gasoline;
    @SerializedName(GetKeys.GET_PLAYERS_ID)
    private final int id;
    @SerializedName("level")
    private final int level;
    @SerializedName("masks")
    private final int masks;
    @SerializedName("materials")
    private final int materials;
    @SerializedName("money")
    private final int money;
    @SerializedName("people")
    private final int people;
    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private final int price;

    public final int component1() {
        return this.id;
    }

    public final int component10() {
        return this.price;
    }

    public final int component2() {
        return this.level;
    }

    public final int component3() {
        return this.money;
    }

    public final int component4() {
        return this.materials;
    }

    public final int component5() {
        return this.masks;
    }

    public final int component6() {
        return this.gasoline;
    }

    public final int component7() {
        return this.armour;
    }

    public final int component8() {
        return this.people;
    }

    public final int component9() {
        return this.ammo;
    }

    public final FamilySystemUpgradeObj copy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        return new FamilySystemUpgradeObj(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FamilySystemUpgradeObj) {
            FamilySystemUpgradeObj familySystemUpgradeObj = (FamilySystemUpgradeObj) obj;
            return this.id == familySystemUpgradeObj.id && this.level == familySystemUpgradeObj.level && this.money == familySystemUpgradeObj.money && this.materials == familySystemUpgradeObj.materials && this.masks == familySystemUpgradeObj.masks && this.gasoline == familySystemUpgradeObj.gasoline && this.armour == familySystemUpgradeObj.armour && this.people == familySystemUpgradeObj.people && this.ammo == familySystemUpgradeObj.ammo && this.price == familySystemUpgradeObj.price;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.id * 31) + this.level) * 31) + this.money) * 31) + this.materials) * 31) + this.masks) * 31) + this.gasoline) * 31) + this.armour) * 31) + this.people) * 31) + this.ammo) * 31) + this.price;
    }

    public String toString() {
        return "FamilySystemUpgradeObj(id=" + this.id + ", level=" + this.level + ", money=" + this.money + ", materials=" + this.materials + ", masks=" + this.masks + ", gasoline=" + this.gasoline + ", armour=" + this.armour + ", people=" + this.people + ", ammo=" + this.ammo + ", price=" + this.price + ')';
    }

    public FamilySystemUpgradeObj(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.id = i;
        this.level = i2;
        this.money = i3;
        this.materials = i4;
        this.masks = i5;
        this.gasoline = i6;
        this.armour = i7;
        this.people = i8;
        this.ammo = i9;
        this.price = i10;
    }

    public final int getId() {
        return this.id;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getMoney() {
        return this.money;
    }

    public final int getMaterials() {
        return this.materials;
    }

    public final int getMasks() {
        return this.masks;
    }

    public final int getGasoline() {
        return this.gasoline;
    }

    public final int getArmour() {
        return this.armour;
    }

    public final int getPeople() {
        return this.people;
    }

    public final int getAmmo() {
        return this.ammo;
    }

    public final int getPrice() {
        return this.price;
    }
}
