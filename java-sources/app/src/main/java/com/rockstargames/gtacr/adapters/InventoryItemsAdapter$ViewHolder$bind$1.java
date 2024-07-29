package com.rockstargames.gtacr.adapters;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import blackrussia.online.databinding.InventoryItemsItemBinding;
import blackrussia.online.network.InvItems;
import com.rockstargames.gtacr.adapters.InventoryItemsAdapter;
import com.rockstargames.gtacr.gui.inventory.GUIUsersInventory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

//@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010¨\u0006("}, d2 = {"com/rockstargames/gtacr/adapters/InventoryItemsAdapter$ViewHolder$bind$1", "Landroid/view/View$OnTouchListener;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "isStopUsed", "", "()Z", "setStopUsed", "(Z)V", "motionXEnd", "", "getMotionXEnd", "()I", "setMotionXEnd", "(I)V", "motionXStart", "getMotionXStart", "setMotionXStart", "motionYEnd", "getMotionYEnd", "setMotionYEnd", "motionYStart", "getMotionYStart", "setMotionYStart", "startTime", "", "getStartTime", "()J", "setStartTime", "(J)V", "testCount", "getTestCount", "setTestCount", "onTouch", "v", "Landroid/view/View;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InventoryItemsAdapter$ViewHolder$bind$1 implements View.OnTouchListener {
    final Ref.BooleanRef $isEnd;
    final InvItems $item;
    final Function2<InvItems, Integer, Unit> $itemsClickListener;
    final GUIUsersInventory $mainRoot;
    private boolean isStopUsed;
    private int motionXEnd;
    private int motionXStart;
    private int motionYEnd;
    private int motionYStart;
    private long startTime;
    final InventoryItemsAdapter.ViewHolder this$0;
    final InventoryItemsAdapter this$1;
    private int testCount = 500;
    private final Handler handler = new Handler();

    public InventoryItemsAdapter$ViewHolder$bind$1(InventoryItemsAdapter.ViewHolder viewHolder, InvItems invItems, Ref.BooleanRef booleanRef, Function2<? super InvItems, ? super Integer, Unit> function2, InventoryItemsAdapter inventoryItemsAdapter, GUIUsersInventory gUIUsersInventory) {
        this.this$0 = viewHolder;
        this.$item = invItems;
        this.$isEnd = booleanRef;
        this.$itemsClickListener = (Function2<InvItems, Integer, Unit>) function2;
        this.this$1 = inventoryItemsAdapter;
        this.$mainRoot = gUIUsersInventory;
    }

    public final int getMotionXStart() {
        return this.motionXStart;
    }

    public final void setMotionXStart(int i) {
        this.motionXStart = i;
    }

    public final int getMotionYStart() {
        return this.motionYStart;
    }

    public final void setMotionYStart(int i) {
        this.motionYStart = i;
    }

    public final int getMotionXEnd() {
        return this.motionXEnd;
    }

    public final void setMotionXEnd(int i) {
        this.motionXEnd = i;
    }

    public final int getMotionYEnd() {
        return this.motionYEnd;
    }

    public final void setMotionYEnd(int i) {
        this.motionYEnd = i;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    public final boolean isStopUsed() {
        return this.isStopUsed;
    }

    public final void setStopUsed(boolean z) {
        this.isStopUsed = z;
    }

    public final int getTestCount() {
        return this.testCount;
    }

    public final void setTestCount(int i) {
        this.testCount = i;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    @Override
    public boolean onTouch(View r13, android.view.MotionEvent r14) {
        /*blackrussia.online.databinding.InventoryItemsItemBinding r13;
        blackrussia.online.databinding.InventoryItemsItemBinding r0;
        blackrussia.online.databinding.InventoryItemsItemBinding r13;
        blackrussia.online.databinding.InventoryItemsItemBinding r13;
        blackrussia.online.databinding.InventoryItemsItemBinding r13;
        com.rockstargames.gtacr.gui.inventory.UILayoutUsersInventory r13;
        com.rockstargames.gtacr.gui.inventory.UILayoutUsersInventory r1;
        com.rockstargames.gtacr.gui.inventory.UILayoutUsersInventory r13;
        com.rockstargames.gtacr.gui.inventory.UILayoutUsersInventory r13;
        com.rockstargames.gtacr.gui.inventory.UILayoutUsersInventory r13;
        com.rockstargames.gtacr.gui.inventory.UILayoutUsersInventory r1;
        com.rockstargames.gtacr.gui.inventory.UILayoutUsersInventory r13;
        com.rockstargames.gtacr.gui.inventory.UILayoutUsersInventory r13;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, "v");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, "event");
        r13 = r12.this$0.binding;
        int r13 = r13.getRoot().getHeight();
        final kotlin.jvm.internal.Ref.IntRef r9 = new kotlin.jvm.internal.Ref.IntRef();
        r9.element = r13;
        final long r5 = 1000 / (r13 / 5);
        r0 = r12.this$0.binding;
        android.view.ViewGroup.LayoutParams r0 = r0.testBottomFill.getLayoutParams();
        java.util.Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        final android.view.ViewGroup.MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0;
        final kotlin.jvm.internal.Ref.BooleanRef r3 = r12.$isEnd;
        final com.rockstargames.gtacr.adapters.InventoryItemsAdapter.ViewHolder r8 = r12.this$0;
        java.lang.Thread r10 = new java.lang.Thread(new java.lang.Runnable() {
            {
            }

            @Override
            public final void run() {
                com.rockstargames.gtacr.adapters.InventoryItemsAdapter$ViewHolder$bind$1.m99onTouch$lambda1(kotlin.jvm.internal.Ref.IntRef.this, r2, r3, r4, r6, r7);
            }
        });
        int r1 = r14.getAction();
        if (r1 == 0) {
            r12.motionXStart = (int) r14.getX();
            r12.motionYStart = (int) r14.getY();
            r12.startTime = java.lang.System.currentTimeMillis();
            r13 = r12.this$0.binding;
            r13.testBottomFill.setVisibility(0);
            r0.topMargin = r9.element;
            r13 = r12.this$0.binding;
            r13.testBottomFill.setLayoutParams(r0);
            if (r12.$item.getItemsValue() != 0) {
                r10.start();
            }
        } else {
            if (r1 != 1) {
                if (r1 == 2) {
                    if (r12.testCount < 5 && !r12.isStopUsed) {
                        r12.isStopUsed = true;
                        r12.$isEnd.element = true;
                        r12.$itemsClickListener.invoke(r12.$item, java.lang.Integer.valueOf(r12.this$0.getLayoutPosition()));
                        r12.$item.setCheck(true);
                        r13 = r12.this$1.thisRoot;
                        if (r13.getOldTimeWithMigrateAndUsed() != java.lang.System.currentTimeMillis()) {
                            long r13 = java.lang.System.currentTimeMillis();
                            r1 = r12.this$1.thisRoot;
                            if (r13 - r1.getOldTimeWithMigrateAndUsed() > 1200) {
                                r13 = r12.this$1.thisRoot;
                                r13.setOldTimeWithMigrateAndUsed(java.lang.System.currentTimeMillis());
                                r13 = r12.this$1.thisRoot;
                                r13.setIntermediateOldPositionInInvIfUsed(r12.this$0.getLayoutPosition());
                                r12.$mainRoot.sendIdAndPositionToServer(19, r12.$item.getId(), r12.this$0.getLayoutPosition());
                            }
                        }
                    }
                }
            }
            r12.motionXEnd = (int) r14.getX();
            int r14 = (int) r14.getY();
            r12.motionYEnd = r14;
            int r1 = r12.motionXStart - r12.motionXEnd;
            if (r1 < 0) {
                r1 *= -1;
            }
            int r6 = r12.motionYStart - r14;
            if (r6 < 0) {
                r6 *= -1;
            }
            int r13 = r13 / 3;
            if (r13 > r1 || r13 > r6) {
                r12.$itemsClickListener.invoke(r12.$item, java.lang.Integer.valueOf(r12.this$0.getLayoutPosition()));
                r12.$item.setCheck(true);
            }
            r13 = r12.this$0.binding;
            r13.testBottomFill.setVisibility(4);
            r12.$isEnd.element = true;
            double r13 = java.lang.System.currentTimeMillis() - r12.startTime;
            java.lang.Double.isNaN(r13);
            double r13 = r13 / 1000.0d;
            if (r12.$item.getItemsValue() != 0 && !r12.isStopUsed && r13 >= 1.0d) {
                r13 = r12.this$1.thisRoot;
                if (r13.getOldTimeWithMigrateAndUsed() != java.lang.System.currentTimeMillis()) {
                    long r13 = java.lang.System.currentTimeMillis();
                    r1 = r12.this$1.thisRoot;
                    if (r13 - r1.getOldTimeWithMigrateAndUsed() > 1200) {
                        r13 = r12.this$1.thisRoot;
                        r13.setOldTimeWithMigrateAndUsed(java.lang.System.currentTimeMillis());
                        r13 = r12.this$1.thisRoot;
                        r13.setIntermediateOldPositionInInvIfUsed(r12.this$0.getLayoutPosition());
                        r12.$mainRoot.sendIdAndPositionToServer(19, r12.$item.getId(), r12.this$0.getLayoutPosition());
                    }
                }
            }
            try {
                r12.this$1.notifyItemChanged(r12.this$0.getLayoutPosition());
            } catch (java.lang.Exception unused) {
            }
        }*/
        return true;
    }

    public static final void m99onTouch$lambda1(final Ref.IntRef margin, Ref.BooleanRef isEnd, InventoryItemsAdapter$ViewHolder$bind$1 this$0, long j, final ViewGroup.MarginLayoutParams param, final InventoryItemsAdapter.ViewHolder this$1) {
        Intrinsics.checkNotNullParameter(margin, "$margin");
        Intrinsics.checkNotNullParameter(isEnd, "$isEnd");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        while (margin.element > 0 && !isEnd.element) {
            this$0.testCount = margin.element;
            margin.element -= 5;
            SystemClock.sleep(j);
            this$0.handler.post(new Runnable() {
                @Override
                public final void run() {
                    InventoryItemsAdapter$ViewHolder$bind$1.m100onTouch$lambda1$lambda0(param, margin, this$1);
                }
            });
        }
    }

    public static final void m100onTouch$lambda1$lambda0(ViewGroup.MarginLayoutParams param, Ref.IntRef margin, InventoryItemsAdapter.ViewHolder this$0) {
        InventoryItemsItemBinding inventoryItemsItemBinding;
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(margin, "$margin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        param.topMargin = margin.element;
        //inventoryItemsItemBinding = this$0.binding;
        //inventoryItemsItemBinding.testBottomFill.setLayoutParams(param);
    }
}
