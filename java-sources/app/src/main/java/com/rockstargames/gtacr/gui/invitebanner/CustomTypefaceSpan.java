package com.rockstargames.gtacr.gui.invitebanner;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/rockstargames/gtacr/gui/invitebanner/CustomTypefaceSpan;", "Landroid/text/style/MetricAffectingSpan;", "font", "Landroid/graphics/Typeface;", "(Landroid/graphics/Typeface;)V", "update", "", "textPaint", "Landroid/text/TextPaint;", "updateDrawState", "updateMeasureState", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CustomTypefaceSpan extends MetricAffectingSpan {
    private final Typeface font;

    public CustomTypefaceSpan(Typeface typeface) {
        this.font = typeface;
    }

    @Override
    public void updateMeasureState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        update(textPaint);
    }

    @Override
    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        update(textPaint);
    }

    private final void update(TextPaint textPaint) {
        Typeface typeface = textPaint.getTypeface();
        textPaint.setTypeface(Typeface.create(this.font, typeface == null ? 0 : typeface.getStyle()));
    }
}
