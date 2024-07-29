package com.rockstargames.gtacr.gui.familySystem;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import blackrussia.online.network.FamilySystemShopObj;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GameRender;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ>\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/FamilyUseful;", "", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Lcom/nvidia/devtech/NvEventQueueActivity;)V", "renderCar", "", GetKeys.GET_PLAYERS_ID, "", "modelId", "bodyColor", "wheelColor", "thisObject", "Landroid/widget/FrameLayout;", "renderShopItem", "Landroid/widget/ImageView;", "thisItem", "Lblackrussia/online/network/FamilySystemShopObj;", "rotX", "", "rotY", "rotZ", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FamilyUseful {
    private final NvEventQueueActivity context;

    public FamilyUseful(NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final void renderShopItem(int i, int i2, final ImageView thisObject, final FamilySystemShopObj thisItem, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(thisObject, "thisObject");
        Intrinsics.checkNotNullParameter(thisItem, "thisItem");
        GameRender gameRender = this.context.getGameRender();
        if (gameRender == null) {
            return;
        }
        gameRender.RequestRender(0, i, i2, 3, 3, f, f2, f3, 0.9f, new GameRender.GameRenderListener() {
            @Override
            public final void OnRenderComplete(int i3, byte[] bArr, long j) {
                FamilyUseful.m163renderShopItem$lambda3(FamilyUseful.this, thisObject, thisItem, i3, bArr, j);
            }
        });
    }

    public static final void m163renderShopItem$lambda3(FamilyUseful this$0, final ImageView thisObject, final FamilySystemShopObj thisItem, int i, byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        Intrinsics.checkNotNullParameter(thisItem, "$thisItem");
        final Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
        createBitmap.setHasAlpha(true);
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
        Intrinsics.checkNotNullExpressionValue(asIntBuffer, "wrap(buffer)\n           …           .asIntBuffer()");
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        createBitmap.setPixels(iArr, 0, 512, 0, 0, 512, 512);
        this$0.context.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                //FamilyUseful.m164renderShopItem$lambda3$lambda2$lambda1(FamilyUseful.this, thisObject, createBitmap, thisItem);
            }
        });
    }

    public static final void m164renderShopItem$lambda3$lambda2$lambda1(FamilyUseful this_run, ImageView thisObject, Bitmap bitmap, FamilySystemShopObj thisItem) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        Intrinsics.checkNotNullParameter(thisItem, "$thisItem");
        thisObject.setImageBitmap(bitmap);
        thisItem.setThisRender(bitmap);
        thisObject.animate().alpha(1.0f).setDuration(300L);
    }

    public final void renderCar(int i, int i2, int i3, int i4, final FrameLayout thisObject) {
        Intrinsics.checkNotNullParameter(thisObject, "thisObject");
        GameRender gameRender = this.context.getGameRender();
        if (gameRender == null) {
            return;
        }
        gameRender.RequestRender(7, i, i2, i3, i4, 20.0f, 180.0f, 45.0f, 0.82f, new GameRender.GameRenderListener() {
            @Override
            public final void OnRenderComplete(int i5, byte[] bArr, long j) {
                FamilyUseful.m161renderCar$lambda7(FamilyUseful.this, thisObject, i5, bArr, j);
            }
        });
    }

    public static final void m161renderCar$lambda7(FamilyUseful this$0, final FrameLayout thisObject, int i, byte[] bArr, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        final Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
        createBitmap.setHasAlpha(true);
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
        Intrinsics.checkNotNullExpressionValue(asIntBuffer, "wrap(buffer)\n           …           .asIntBuffer()");
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        createBitmap.setPixels(iArr, 0, 512, 0, 0, 512, 512);
        this$0.context.runOnUiThread(new Runnable() {
            @Override
            public final void run() {
                //FamilyUseful.m162renderCar$lambda7$lambda6$lambda5(FamilyUseful.this, thisObject, createBitmap);
            }
        });
    }

    public static final void m162renderCar$lambda7$lambda6$lambda5(FamilyUseful this_run, FrameLayout thisObject, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(thisObject, "$thisObject");
        thisObject.setBackground(new BitmapDrawable(this_run.context.getResources(), bitmap));
        thisObject.animate().alpha(1.0f).setDuration(300L);
    }
}
