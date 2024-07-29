package com.rockstargames.gtacr;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import blackrussia.online.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrDialogMenuHelp.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/rockstargames/gtacr/BrDialogMenuHelp;", "", "rootView", "Landroid/view/View;", "myWidth", "", "myHeight", "myLocation", "", "(Landroid/view/View;II[I)V", "parameters", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "windowMenu", "setPosition", "", "startGuide", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BrDialogMenuHelp {
    private final int myHeight;
    private final int[] myLocation;
    private final int myWidth;
    private final ConstraintLayout.LayoutParams parameters;
    private final View rootView;
    private final View windowMenu;

    public BrDialogMenuHelp(View rootView, int i, int i2, int[] myLocation) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(myLocation, "myLocation");
        this.rootView = rootView;
        this.myWidth = i;
        this.myHeight = i2;
        this.myLocation = myLocation;
        View findViewById = rootView.findViewById(R.id.window_menu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.window_menu)");
        this.windowMenu = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.parameters = (ConstraintLayout.LayoutParams) layoutParams;
    }

    public final void startGuide() {
        setPosition();
    }

    private final void setPosition() {
        ConstraintLayout.LayoutParams layoutParams = this.parameters;
        layoutParams.width = this.myWidth;
        layoutParams.height = this.myHeight;
        layoutParams.setMarginStart(this.myLocation[0]);
        layoutParams.topMargin = this.myLocation[1];
        this.windowMenu.setLayoutParams(this.parameters);
    }
}
