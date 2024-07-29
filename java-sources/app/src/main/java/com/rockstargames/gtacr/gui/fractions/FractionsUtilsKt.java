package com.rockstargames.gtacr.gui.fractions;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GameRender;
import com.rockstargames.gtacr.data.FractionsShopItem;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;

//@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001aN\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f\u001a\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011\u001a\f\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u0015\u001a\u0010\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017*\u00020\u0018\u001a\u0010\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017*\u00020\u0018¨\u0006\u001b"}, d2 = {"renderShopItem", "", "activity", "Lcom/nvidia/devtech/NvEventQueueActivity;", GetKeys.GET_PLAYERS_ID, "", "modelId", "thisObject", "Landroid/widget/ImageView;", "thisItem", "Lcom/rockstargames/gtacr/data/FractionsShopItem;", "rotX", "", "rotY", "rotZ", "zoom", "transformSpannableToUpperCase", "", "source", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/content/Context;", "toMutableIntList", "", "Lorg/json/JSONArray;", "toMutableStringList", "", "app_cppRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FractionsUtilsKt {
    public static final void renderShopItem(final NvEventQueueActivity activity, int i, int i2, final ImageView thisObject, final FractionsShopItem thisItem) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(thisObject, "thisObject");
        Intrinsics.checkNotNullParameter(thisItem, "thisItem");
        GameRender gameRender = activity.getGameRender();
        if (gameRender == null) {
            return;
        }
        gameRender.RequestRender(0, i, i2, 3, 3, 20.0f, 180.0f, 0.0f, 0.8f, new GameRender.GameRenderListener() {
            @Override
            public final void OnRenderComplete(int i3, byte[] bArr, long j) {
                FractionsUtilsKt.m231renderShopItem$lambda3(activity, thisObject, thisItem, i3, bArr, j);
            }
        });
    }

    public static final void m231renderShopItem$lambda3(NvEventQueueActivity activity, final ImageView thisObject, final FractionsShopItem thisItem, int i, byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        Intrinsics.checkNotNullParameter(thisItem, "$thisItem");
        final Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
        createBitmap.setHasAlpha(true);
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
        Intrinsics.checkNotNullExpressionValue(asIntBuffer, "wrap(buffer)\n           …           .asIntBuffer()");
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        createBitmap.setPixels(iArr, 0, 512, 0, 0, 512, 512);
        activity.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                FractionsUtilsKt.m232renderShopItem$lambda3$lambda2$lambda1(thisObject, createBitmap, thisItem);
            }
        });
    }

    public static final void m232renderShopItem$lambda3$lambda2$lambda1(ImageView thisObject, Bitmap bitmap, FractionsShopItem thisItem) {
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        Intrinsics.checkNotNullParameter(thisItem, "$thisItem");
        thisObject.setImageBitmap(bitmap);
        thisItem.setRender(bitmap);
        thisObject.animate().alpha(1.0f).setDuration(300L);
    }

    public static final void renderShopItem(final NvEventQueueActivity activity, int i, int i2, final ImageView thisObject, final FractionsShopItem thisItem, float f, float f2, float f3, float f4) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(thisObject, "thisObject");
        Intrinsics.checkNotNullParameter(thisItem, "thisItem");
        GameRender gameRender = activity.getGameRender();
        if (gameRender == null) {
            return;
        }
        gameRender.RequestRender(0, i, i2, 3, 3, f, f2, f3, f4, new GameRender.GameRenderListener() {
            @Override
            public final void OnRenderComplete(int i3, byte[] bArr, long j) {
                FractionsUtilsKt.m233renderShopItem$lambda7(activity, thisObject, thisItem, i3, bArr, j);
            }
        });
    }

    public static final void m233renderShopItem$lambda7(NvEventQueueActivity activity, final ImageView thisObject, final FractionsShopItem thisItem, int i, byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        Intrinsics.checkNotNullParameter(thisItem, "$thisItem");
        final Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
        createBitmap.setHasAlpha(true);
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
        Intrinsics.checkNotNullExpressionValue(asIntBuffer, "wrap(buffer)\n           …           .asIntBuffer()");
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        createBitmap.setPixels(iArr, 0, 512, 0, 0, 512, 512);
        activity.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                FractionsUtilsKt.m234renderShopItem$lambda7$lambda6$lambda5(thisObject, createBitmap, thisItem);
            }
        });
    }

    public static final void m234renderShopItem$lambda7$lambda6$lambda5(ImageView thisObject, Bitmap bitmap, FractionsShopItem thisItem) {
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        Intrinsics.checkNotNullParameter(thisItem, "$thisItem");
        thisObject.setImageBitmap(bitmap);
        thisItem.setRender(bitmap);
        thisObject.animate().alpha(1.0f).setDuration(300L);
    }

    public static final CharSequence transformSpannableToUpperCase(CharSequence source) {
        Intrinsics.checkNotNullParameter(source, "source");
        String upperCase = source.toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        SpannableString spannableString = new SpannableString(upperCase);
        TextUtils.copySpansFrom((Spanned) source, 0, source.length(), null, spannableString, 0);
        return spannableString;
    }

    public static final LifecycleOwner lifecycleOwner(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        int i = 20;
        while (true) {
            int i2 = i - 1;
            if (i <= 0 || (context instanceof LifecycleOwner)) {
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(context, "curContext as ContextWrapper).baseContext");
            i = i2;
        }
        if (context instanceof LifecycleOwner) {
            return (LifecycleOwner) context;
        }
        return null;
    }

    public static final List<Integer> toMutableIntList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            try {
                if (jSONArray.getString(i) != null) {
                    try {
                        arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            i = i2;
        }
        return arrayList;
    }

    public static final List<String> toMutableStringList(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            try {
                if (jSONArray.getString(i) != null) {
                    String string = null;
                    try {
                        string = jSONArray.getString(i);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    Intrinsics.checkNotNullExpressionValue(string, "this.getString(i)");
                    arrayList.add(string);
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            i = i2;
        }
        return arrayList;
    }
}
