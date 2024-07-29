package blackrussia.online.network;

import com.google.gson.annotations.SerializedName;
import com.rockstargames.gtacr.gui.fractions.Const;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bg\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÝ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\u001c\b\u0002\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003¢\u0006\u0002\u0010\"J\u0010\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010HJ\u0011\u0010g\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u0011\u0010h\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u0011\u0010i\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010k\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001d\u0010m\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0019HÆ\u0003J\u0010\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\t\u0010r\u001a\u00020\u0003HÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\t\u0010t\u001a\u00020\u0003HÆ\u0003J\t\u0010u\u001a\u00020\u0003HÆ\u0003J\t\u0010v\u001a\u00020\u0003HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u0011\u0010}\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003Jæ\u0002\u0010~\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u001c\b\u0002\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u007fJ\u0016\u0010\u0080\u0001\u001a\u00030\u0081\u00012\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0084\u0001\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u001f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010!\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010$\"\u0004\b-\u0010&R\"\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b.\u0010(\"\u0004\b/\u0010*R&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\"\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b6\u0010(\"\u0004\b7\u0010*R \u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b<\u0010(\"\u0004\b=\u0010*R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00109\"\u0004\b?\u0010;R \u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00109\"\u0004\bA\u0010;R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\bB\u0010(\"\u0004\bC\u0010*R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b\u001a\u0010(\"\u0004\bD\u0010*R\"\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\bE\u0010(\"\u0004\bF\u0010*R\"\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\bL\u0010(\"\u0004\bM\u0010*R\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\bN\u0010(\"\u0004\bO\u0010*R&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00101\"\u0004\bQ\u00103R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\bR\u0010(\"\u0004\bS\u0010*R\u001a\u0010\u001d\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010$\"\u0004\bU\u0010&R\u001a\u0010\u001e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010$\"\u0004\bW\u0010&R2\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00109\"\u0004\b]\u0010;R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b^\u0010(\"\u0004\b_\u0010*R\u001a\u0010 \u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010$\"\u0004\ba\u0010&R&\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00101\"\u0004\bc\u00103¨\u0006\u0085\u0001"}, d2 = {"Lblackrussia/online/network/DonateItem;", "", "internalId", "", "gameId", "header", "", "subheader", "basePrice", "renderId", "count", Const.FRACTION_TYPE_KEY, "rot", "", "", "modelId", "modelZoom", "colors", "contains", "values", "money", "imageId", "desc", "specs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isNew", "rubles", "closed", "salePercent", "saleTime", "assignedId", "upTag", "category", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IIIII)V", "getAssignedId", "()I", "setAssignedId", "(I)V", "getBasePrice", "()Ljava/lang/Integer;", "setBasePrice", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCategory", "setCategory", "getClosed", "setClosed", "getColors", "()Ljava/util/List;", "setColors", "(Ljava/util/List;)V", "getContains", "setContains", "getCount", "setCount", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getGameId", "setGameId", "getHeader", "setHeader", "getImageId", "setImageId", "getInternalId", "setInternalId", "setNew", "getModelId", "setModelId", "getModelZoom", "()Ljava/lang/Double;", "setModelZoom", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getMoney", "setMoney", "getRenderId", "setRenderId", "getRot", "setRot", "getRubles", "setRubles", "getSalePercent", "setSalePercent", "getSaleTime", "setSaleTime", "getSpecs", "()Ljava/util/ArrayList;", "setSpecs", "(Ljava/util/ArrayList;)V", "getSubheader", "setSubheader", "getType", "setType", "getUpTag", "setUpTag", "getValues", "setValues", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IIIII)Lblackrussia/online/network/DonateItem;", "equals", "", "other", "hashCode", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DonateItem {
    private int assignedId;
    @SerializedName("basePrice")
    private Integer basePrice;
    private int category;
    @SerializedName("closed")
    private Integer closed;
    @SerializedName("colors")
    private List<Integer> colors;
    @SerializedName("contains")
    private List<Integer> contains;
    @SerializedName("count")
    private Integer count;
    @SerializedName("desc")
    private String desc;
    @SerializedName("gameId")
    private Integer gameId;
    @SerializedName("header")
    private String header;
    @SerializedName("imageId")
    private String imageId;
    @SerializedName("internalId")
    private Integer internalId;
    @SerializedName("isNew")
    private Integer isNew;
    @SerializedName("modelId")
    private Integer modelId;
    @SerializedName("modelZoom")
    private Double modelZoom;
    @SerializedName("money")
    private Integer money;
    @SerializedName("renderId")
    private Integer renderId;
    @SerializedName("rot")
    private List<Double> rot;
    @SerializedName("rubles")
    private Integer rubles;
    private int salePercent;
    private int saleTime;
    @SerializedName("specs")
    private ArrayList<Integer> specs;
    @SerializedName("subheader")
    private String subheader;
    @SerializedName(Const.FRACTION_TYPE_KEY)
    private Integer type;
    private int upTag;
    @SerializedName("values")
    private List<Integer> values;

    public DonateItem() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 67108863, null);
    }

    public final Integer component1() {
        return this.internalId;
    }

    public final Integer component10() {
        return this.modelId;
    }

    public final Double component11() {
        return this.modelZoom;
    }

    public final List<Integer> component12() {
        return this.colors;
    }

    public final List<Integer> component13() {
        return this.contains;
    }

    public final List<Integer> component14() {
        return this.values;
    }

    public final Integer component15() {
        return this.money;
    }

    public final String component16() {
        return this.imageId;
    }

    public final String component17() {
        return this.desc;
    }

    public final ArrayList<Integer> component18() {
        return this.specs;
    }

    public final Integer component19() {
        return this.isNew;
    }

    public final Integer component2() {
        return this.gameId;
    }

    public final Integer component20() {
        return this.rubles;
    }

    public final Integer component21() {
        return this.closed;
    }

    public final int component22() {
        return this.salePercent;
    }

    public final int component23() {
        return this.saleTime;
    }

    public final int component24() {
        return this.assignedId;
    }

    public final int component25() {
        return this.upTag;
    }

    public final int component26() {
        return this.category;
    }

    public final String component3() {
        return this.header;
    }

    public final String component4() {
        return this.subheader;
    }

    public final Integer component5() {
        return this.basePrice;
    }

    public final Integer component6() {
        return this.renderId;
    }

    public final Integer component7() {
        return this.count;
    }

    public final Integer component8() {
        return this.type;
    }

    public final List<Double> component9() {
        return this.rot;
    }

    public final DonateItem copy(Integer num, Integer num2, String str, String str2, Integer num3, Integer num4, Integer num5, Integer num6, List<Double> list, Integer num7, Double d, List<Integer> list2, List<Integer> list3, List<Integer> list4, Integer num8, String str3, String str4, ArrayList<Integer> arrayList, Integer num9, Integer num10, Integer num11, int i, int i2, int i3, int i4, int i5) {
        return new DonateItem(num, num2, str, str2, num3, num4, num5, num6, list, num7, d, list2, list3, list4, num8, str3, str4, arrayList, num9, num10, num11, i, i2, i3, i4, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonateItem) {
            DonateItem donateItem = (DonateItem) obj;
            return Intrinsics.areEqual(this.internalId, donateItem.internalId) && Intrinsics.areEqual(this.gameId, donateItem.gameId) && Intrinsics.areEqual(this.header, donateItem.header) && Intrinsics.areEqual(this.subheader, donateItem.subheader) && Intrinsics.areEqual(this.basePrice, donateItem.basePrice) && Intrinsics.areEqual(this.renderId, donateItem.renderId) && Intrinsics.areEqual(this.count, donateItem.count) && Intrinsics.areEqual(this.type, donateItem.type) && Intrinsics.areEqual(this.rot, donateItem.rot) && Intrinsics.areEqual(this.modelId, donateItem.modelId) && Intrinsics.areEqual((Object) this.modelZoom, (Object) donateItem.modelZoom) && Intrinsics.areEqual(this.colors, donateItem.colors) && Intrinsics.areEqual(this.contains, donateItem.contains) && Intrinsics.areEqual(this.values, donateItem.values) && Intrinsics.areEqual(this.money, donateItem.money) && Intrinsics.areEqual(this.imageId, donateItem.imageId) && Intrinsics.areEqual(this.desc, donateItem.desc) && Intrinsics.areEqual(this.specs, donateItem.specs) && Intrinsics.areEqual(this.isNew, donateItem.isNew) && Intrinsics.areEqual(this.rubles, donateItem.rubles) && Intrinsics.areEqual(this.closed, donateItem.closed) && this.salePercent == donateItem.salePercent && this.saleTime == donateItem.saleTime && this.assignedId == donateItem.assignedId && this.upTag == donateItem.upTag && this.category == donateItem.category;
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.internalId;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.gameId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.header;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subheader;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.basePrice;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.renderId;
        int hashCode6 = (hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.count;
        int hashCode7 = (hashCode6 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.type;
        int hashCode8 = (hashCode7 + (num6 == null ? 0 : num6.hashCode())) * 31;
        List<Double> list = this.rot;
        int hashCode9 = (hashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num7 = this.modelId;
        int hashCode10 = (hashCode9 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Double d = this.modelZoom;
        int hashCode11 = (hashCode10 + (d == null ? 0 : d.hashCode())) * 31;
        List<Integer> list2 = this.colors;
        int hashCode12 = (hashCode11 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Integer> list3 = this.contains;
        int hashCode13 = (hashCode12 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<Integer> list4 = this.values;
        int hashCode14 = (hashCode13 + (list4 == null ? 0 : list4.hashCode())) * 31;
        Integer num8 = this.money;
        int hashCode15 = (hashCode14 + (num8 == null ? 0 : num8.hashCode())) * 31;
        String str3 = this.imageId;
        int hashCode16 = (hashCode15 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.desc;
        int hashCode17 = (hashCode16 + (str4 == null ? 0 : str4.hashCode())) * 31;
        ArrayList<Integer> arrayList = this.specs;
        int hashCode18 = (hashCode17 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        Integer num9 = this.isNew;
        int hashCode19 = (hashCode18 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.rubles;
        int hashCode20 = (hashCode19 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.closed;
        return ((((((((((hashCode20 + (num11 != null ? num11.hashCode() : 0)) * 31) + this.salePercent) * 31) + this.saleTime) * 31) + this.assignedId) * 31) + this.upTag) * 31) + this.category;
    }

    public String toString() {
        return "DonateItem(internalId=" + this.internalId + ", gameId=" + this.gameId + ", header=" + ((Object) this.header) + ", subheader=" + ((Object) this.subheader) + ", basePrice=" + this.basePrice + ", renderId=" + this.renderId + ", count=" + this.count + ", type=" + this.type + ", rot=" + this.rot + ", modelId=" + this.modelId + ", modelZoom=" + this.modelZoom + ", colors=" + this.colors + ", contains=" + this.contains + ", values=" + this.values + ", money=" + this.money + ", imageId=" + ((Object) this.imageId) + ", desc=" + ((Object) this.desc) + ", specs=" + this.specs + ", isNew=" + this.isNew + ", rubles=" + this.rubles + ", closed=" + this.closed + ", salePercent=" + this.salePercent + ", saleTime=" + this.saleTime + ", assignedId=" + this.assignedId + ", upTag=" + this.upTag + ", category=" + this.category + ')';
    }

    public DonateItem(Integer num, Integer num2, String str, String str2, Integer num3, Integer num4, Integer num5, Integer num6, List<Double> list, Integer num7, Double d, List<Integer> list2, List<Integer> list3, List<Integer> list4, Integer num8, String str3, String str4, ArrayList<Integer> arrayList, Integer num9, Integer num10, Integer num11, int i, int i2, int i3, int i4, int i5) {
        this.internalId = num;
        this.gameId = num2;
        this.header = str;
        this.subheader = str2;
        this.basePrice = num3;
        this.renderId = num4;
        this.count = num5;
        this.type = num6;
        this.rot = list;
        this.modelId = num7;
        this.modelZoom = d;
        this.colors = list2;
        this.contains = list3;
        this.values = list4;
        this.money = num8;
        this.imageId = str3;
        this.desc = str4;
        this.specs = arrayList;
        this.isNew = num9;
        this.rubles = num10;
        this.closed = num11;
        this.salePercent = i;
        this.saleTime = i2;
        this.assignedId = i3;
        this.upTag = i4;
        this.category = i5;
    }

    public DonateItem(Integer num, Integer num2, String str, String str2, Integer num3, Integer num4, Integer num5, Integer num6, List list, Integer num7, Double d, List list2, List list3, List list4, Integer num8, String str3, String str4, ArrayList arrayList, Integer num9, Integer num10, Integer num11, int i, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? null : num, (i6 & 2) != 0 ? null : num2, (i6 & 4) != 0 ? null : str, (i6 & 8) != 0 ? null : str2, (i6 & 16) != 0 ? null : num3, (i6 & 32) != 0 ? null : num4, (i6 & 64) != 0 ? null : num5, (i6 & 128) != 0 ? null : num6, (i6 & 256) != 0 ? null : list, (i6 & 512) != 0 ? null : num7, (i6 & 1024) != 0 ? null : d, (i6 & 2048) != 0 ? null : list2, (i6 & 4096) != 0 ? null : list3, (i6 & 8192) != 0 ? null : list4, (i6 & 16384) != 0 ? null : num8, (i6 & 32768) != 0 ? null : str3, (i6 & 65536) != 0 ? null : str4, (i6 & 131072) != 0 ? null : arrayList, (i6 & 262144) != 0 ? null : num9, (i6 & 524288) != 0 ? null : num10, (i6 & 1048576) != 0 ? null : num11, (i6 & 2097152) != 0 ? 0 : i, (i6 & 4194304) != 0 ? 0 : i2, (i6 & 8388608) != 0 ? 0 : i3, (i6 & 16777216) != 0 ? 0 : i4, (i6 & 33554432) == 0 ? i5 : 0);
    }

    public final Integer getInternalId() {
        return this.internalId;
    }

    public final void setInternalId(Integer num) {
        this.internalId = num;
    }

    public final Integer getGameId() {
        return this.gameId;
    }

    public final void setGameId(Integer num) {
        this.gameId = num;
    }

    public final String getHeader() {
        return this.header;
    }

    public final void setHeader(String str) {
        this.header = str;
    }

    public final String getSubheader() {
        return this.subheader;
    }

    public final void setSubheader(String str) {
        this.subheader = str;
    }

    public final Integer getBasePrice() {
        return this.basePrice;
    }

    public final void setBasePrice(Integer num) {
        this.basePrice = num;
    }

    public final Integer getRenderId() {
        return this.renderId;
    }

    public final void setRenderId(Integer num) {
        this.renderId = num;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final void setCount(Integer num) {
        this.count = num;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final List<Double> getRot() {
        return this.rot;
    }

    public final void setRot(List<Double> list) {
        this.rot = list;
    }

    public final Integer getModelId() {
        return this.modelId;
    }

    public final void setModelId(Integer num) {
        this.modelId = num;
    }

    public final Double getModelZoom() {
        return this.modelZoom;
    }

    public final void setModelZoom(Double d) {
        this.modelZoom = d;
    }

    public final List<Integer> getColors() {
        return this.colors;
    }

    public final void setColors(List<Integer> list) {
        this.colors = list;
    }

    public final List<Integer> getContains() {
        return this.contains;
    }

    public final void setContains(List<Integer> list) {
        this.contains = list;
    }

    public final List<Integer> getValues() {
        return this.values;
    }

    public final void setValues(List<Integer> list) {
        this.values = list;
    }

    public final Integer getMoney() {
        return this.money;
    }

    public final void setMoney(Integer num) {
        this.money = num;
    }

    public final String getImageId() {
        return this.imageId;
    }

    public final void setImageId(String str) {
        this.imageId = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final ArrayList<Integer> getSpecs() {
        return this.specs;
    }

    public final void setSpecs(ArrayList<Integer> arrayList) {
        this.specs = arrayList;
    }

    public final Integer isNew() {
        return this.isNew;
    }

    public final void setNew(Integer num) {
        this.isNew = num;
    }

    public final Integer getRubles() {
        return this.rubles;
    }

    public final void setRubles(Integer num) {
        this.rubles = num;
    }

    public final Integer getClosed() {
        return this.closed;
    }

    public final void setClosed(Integer num) {
        this.closed = num;
    }

    public final int getSalePercent() {
        return this.salePercent;
    }

    public final void setSalePercent(int i) {
        this.salePercent = i;
    }

    public final int getSaleTime() {
        return this.saleTime;
    }

    public final void setSaleTime(int i) {
        this.saleTime = i;
    }

    public final int getAssignedId() {
        return this.assignedId;
    }

    public final void setAssignedId(int i) {
        this.assignedId = i;
    }

    public final int getUpTag() {
        return this.upTag;
    }

    public final void setUpTag(int i) {
        this.upTag = i;
    }

    public final int getCategory() {
        return this.category;
    }

    public final void setCategory(int i) {
        this.category = i;
    }
}
