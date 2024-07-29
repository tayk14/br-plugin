package com.rockstargames.gtacr.gui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.ResourcesCompat;
import blackrussia.online.R;
import blackrussia.online.network.InvItems;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.GameRender;
import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fJx\u0010\u0017\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'J@\u0010(\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'J8\u0010+\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020,¨\u0006-"}, d2 = {"Lcom/rockstargames/gtacr/gui/Useful;", "", "()V", "closeAndroidsInterface", "", "myContext", "Lcom/nvidia/devtech/NvEventQueueActivity;", "popup", "Landroid/widget/PopupWindow;", "getDrawableByName", "Landroid/graphics/drawable/Drawable;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "context", "getPriceWithDotForInt", "number", "", "getPriceWithSpacesForInt", "getPriceWithSpacesForLong", "", "getTextWithHtmlStyles", "Landroid/text/Spanned;", "currentText", "renderItem", Const.FRACTION_TYPE_KEY, GetKeys.GET_PLAYERS_ID, "modelId", TypedValues.Custom.S_COLOR, "thisObject", "Landroid/widget/ImageView;", "x", "", "y", "z", "zoom", "shiftX", "shiftY", "shiftZ", "item", "Lblackrussia/online/network/InvItems;", "renderPlate", "itemsId", "region", "renderSkin", "Landroid/widget/FrameLayout;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Useful {
    public final Drawable getDrawableByName(String name, NvEventQueueActivity nvEventQueueActivity) {
        Resources resources;
        Resources resources2;
        Intrinsics.checkNotNullParameter(name, "name");
        Integer valueOf = (nvEventQueueActivity == null || (resources = nvEventQueueActivity.getResources()) == null) ? null : Integer.valueOf(resources.getIdentifier(name, "drawable", nvEventQueueActivity.getPackageName()));
        if (valueOf != null && valueOf.intValue() == 0) {
            Resources resources3 = nvEventQueueActivity.getResources();
            if (resources3 == null) {
                return null;
            }
            return ResourcesCompat.getDrawable(resources3, R.drawable.back2, null);
        } else if (nvEventQueueActivity == null || (resources2 = nvEventQueueActivity.getResources()) == null || valueOf == null) {
            return null;
        } else {
            return ResourcesCompat.getDrawable(resources2, valueOf.intValue(), null);
        }
    }

    public final void renderItem(final NvEventQueueActivity nvEventQueueActivity, int i, int i2, int i3, int i4, final ImageView thisObject, float f, float f2, float f3, float f4, float f5, float f6, float f7, final InvItems item) {
        GameRender gameRender;
        GameRender gameRender2;
        Intrinsics.checkNotNullParameter(thisObject, "thisObject");
        Intrinsics.checkNotNullParameter(item, "item");
        if (nvEventQueueActivity != null && (gameRender2 = nvEventQueueActivity.getGameRender()) != null) {
            gameRender2.SetOffsets(f5, f6, f7);
        }
        thisObject.setAlpha(0.0f);
        if (nvEventQueueActivity == null || (gameRender = nvEventQueueActivity.getGameRender()) == null) {
            return;
        }
        gameRender.RequestRender(i, i2, i3, i4, i4, f, f2, f3, f4, new GameRender.GameRenderListener() {
            @Override
            public final void OnRenderComplete(int i5, byte[] bArr, long j) {
                Useful.m113renderItem$lambda6(Useful.this, thisObject, nvEventQueueActivity, item, i5, bArr, j);
            }
        });
    }

    public static final void m113renderItem$lambda6(Useful this$0, final ImageView thisObject, NvEventQueueActivity nvEventQueueActivity, final InvItems item, int i, byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        Intrinsics.checkNotNullParameter(item, "$item");
        thisObject.setScaleX(-1.0f);
        final Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
        createBitmap.setHasAlpha(true);
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
        Intrinsics.checkNotNullExpressionValue(asIntBuffer, "wrap(buffer)\n           …           .asIntBuffer()");
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        createBitmap.setPixels(iArr, 0, 512, 0, 0, 512, 512);
        nvEventQueueActivity.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                //Useful.m114renderItem$lambda6$lambda5$lambda4(Useful.this, thisObject, createBitmap, item);
            }
        });
    }

    public static final void m114renderItem$lambda6$lambda5$lambda4(Useful this_run, ImageView thisObject, Bitmap bitmap, InvItems item) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        Intrinsics.checkNotNullParameter(item, "$item");
        thisObject.setImageBitmap(bitmap);
        item.setThisBitmap(bitmap);
        thisObject.animate().alpha(1.0f).setDuration(300L);
    }

    public final void renderSkin(final NvEventQueueActivity nvEventQueueActivity, int i, int i2, int i3, int i4, final FrameLayout thisObject) {
        GameRender gameRender;
        Intrinsics.checkNotNullParameter(thisObject, "thisObject");
        if (nvEventQueueActivity == null || (gameRender = nvEventQueueActivity.getGameRender()) == null) {
            return;
        }
        gameRender.RequestRender(i, i2, i3, i4, i4, 20.0f, 180.0f, 0.0f, 0.9f, new GameRender.GameRenderListener() {
            @Override
            public final void OnRenderComplete(int i5, byte[] bArr, long j) {
                Useful.m117renderSkin$lambda10(Useful.this, thisObject, nvEventQueueActivity, i5, bArr, j);
            }
        });
    }

    public static final void m117renderSkin$lambda10(Useful this$0, final FrameLayout thisObject, final NvEventQueueActivity nvEventQueueActivity, int i, byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        thisObject.setScaleX(-1.0f);
        final Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
        createBitmap.setHasAlpha(true);
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
        Intrinsics.checkNotNullExpressionValue(asIntBuffer, "wrap(buffer)\n           …           .asIntBuffer()");
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        createBitmap.setPixels(iArr, 0, 512, 0, 0, 512, 512);
        nvEventQueueActivity.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                //Useful.m118renderSkin$lambda10$lambda9$lambda8(Useful.this, nvEventQueueActivity, createBitmap, thisObject);
            }
        });
    }

    public static final void m118renderSkin$lambda10$lambda9$lambda8(Useful this_run, NvEventQueueActivity nvEventQueueActivity, Bitmap bitmap, FrameLayout thisObject) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        thisObject.setBackground(new BitmapDrawable(nvEventQueueActivity.getResources(), bitmap));
        thisObject.animate().alpha(1.0f).setDuration(300L);
    }

    public final void renderPlate(final NvEventQueueActivity nvEventQueueActivity, int i, int i2, String number, String region, final ImageView thisObject, final InvItems item) {
        GameRender gameRender;
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(thisObject, "thisObject");
        Intrinsics.checkNotNullParameter(item, "item");
        if (nvEventQueueActivity == null || (gameRender = nvEventQueueActivity.getGameRender()) == null) {
            return;
        }
        gameRender.RequestTexturePlate(i, i2, number, region, 0.0f, 180.0f, 0.0f, 0.78f, new GameRender.GameTextureListener() {
            @Override
            public final void OnTextureGet(int i3, Bitmap bitmap) {
                Useful.m115renderPlate$lambda14(Useful.this, thisObject, nvEventQueueActivity, item, i3, bitmap);
            }
        });
    }

    public static final void m115renderPlate$lambda14(Useful this$0, final ImageView thisObject, NvEventQueueActivity nvEventQueueActivity, final InvItems item, int i, final Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        Intrinsics.checkNotNullParameter(item, "$item");
        thisObject.setScaleX(-1.0f);
        nvEventQueueActivity.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                //Useful.m116renderPlate$lambda14$lambda13$lambda12(Useful.this, thisObject, bitmap, item);
            }
        });
    }

    public static final void m116renderPlate$lambda14$lambda13$lambda12(Useful this_run, ImageView thisObject, Bitmap bitmap, InvItems item) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        Intrinsics.checkNotNullParameter(item, "$item");
        thisObject.setImageBitmap(bitmap);
        item.setThisBitmap(bitmap);
        thisObject.animate().alpha(1.0f).setDuration(300L);
    }

    public final void closeAndroidsInterface(final NvEventQueueActivity nvEventQueueActivity, final PopupWindow popupWindow) {
        FrameLayout parentLayout;
        if (nvEventQueueActivity == null || (parentLayout = nvEventQueueActivity.getParentLayout()) == null) {
            return;
        }
        parentLayout.postDelayed(new Runnable() {
            @Override
            public final void run() {
                Useful.m108closeAndroidsInterface$lambda18(popupWindow, nvEventQueueActivity);
            }
        }, 300L);
    }

    public static final void m108closeAndroidsInterface$lambda18(final PopupWindow popupWindow, NvEventQueueActivity nvEventQueueActivity) {
        if (popupWindow == null) {
            return;
        }
        try {
            GUIManager.hideSystemUI(popupWindow.getContentView());
        } catch (Exception unused) {
            nvEventQueueActivity.getParentLayout().postDelayed(new Runnable() {
                @Override
                public final void run() {
                    Useful.m109closeAndroidsInterface$lambda18$lambda17(popupWindow);
                }
            }, 1000L);
        }
    }

    public static final void m109closeAndroidsInterface$lambda18$lambda17(PopupWindow popupWindow) {
        if (popupWindow == null) {
            return;
        }
        GUIManager.hideSystemUI(popupWindow.getContentView());
    }

    public final String getPriceWithSpacesForLong(long j) {
        return new DecimalFormat("#,###,###", new DecimalFormatSymbols(Locale.getDefault())).format(j);
    }

    public final String getPriceWithSpacesForInt(int i) {
        return new DecimalFormat("#,###,###", new DecimalFormatSymbols(Locale.getDefault())).format(i);
    }

    public final String getPriceWithDotForInt(int i) {
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance();
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormatSymbols.setGroupingSeparator('.');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return decimalFormat.format(Integer.valueOf(i)).toString();
    }

    public final Spanned getTextWithHtmlStyles(String currentText) {
        Intrinsics.checkNotNullParameter(currentText, "currentText");
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned fromHtml = Html.fromHtml(currentText, 0);
            Intrinsics.checkNotNullExpressionValue(fromHtml, "{\n            Html.fromH…ML_MODE_LEGACY)\n        }");
            return fromHtml;
        }
        Spanned fromHtml2 = Html.fromHtml(currentText);
        Intrinsics.checkNotNullExpressionValue(fromHtml2, "{\n            Html.fromHtml(currentText)\n        }");
        return fromHtml2;
    }
}
