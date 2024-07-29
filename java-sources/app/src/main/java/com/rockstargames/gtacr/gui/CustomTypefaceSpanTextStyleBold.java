package com.rockstargames.gtacr.gui;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/rockstargames/gtacr/gui/CustomTypefaceSpanTextStyleBold;", "Landroid/text/style/TypefaceSpan;", "family", "", "newType", "Landroid/graphics/Typeface;", "(Ljava/lang/String;Landroid/graphics/Typeface;)V", "updateDrawState", "", "ds", "Landroid/text/TextPaint;", "updateMeasureState", "paint", "Companion", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomTypefaceSpanTextStyleBold extends TypefaceSpan {
    public static final Companion Companion = new Companion(null);
    private final Typeface newType;

    public CustomTypefaceSpanTextStyleBold(String str, Typeface newType) {
        super(str);
        Intrinsics.checkNotNullParameter(newType, "newType");
        this.newType = newType;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        Companion.applyCustomTypeFace(ds, this.newType);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Companion.applyCustomTypeFace(paint, this.newType);
    }

    //@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, d2 = {"Lcom/rockstargames/gtacr/gui/CustomTypefaceSpanTextStyleBold$Companion;", "", "()V", "applyCustomTypeFace", "", "paint", "Landroid/graphics/Paint;", "tf", "Landroid/graphics/Typeface;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void applyCustomTypeFace(Paint paint, Typeface typeface) {
            Typeface typeface2 = paint.getTypeface();
            int style = (typeface2 == null ? 0 : typeface2.getStyle()) & (typeface.getStyle() ^ (-1));
            if ((style & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((style & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.setTypeface(typeface);
        }
    }
}
