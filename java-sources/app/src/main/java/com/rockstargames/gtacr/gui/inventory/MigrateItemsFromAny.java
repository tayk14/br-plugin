package com.rockstargames.gtacr.gui.inventory;

import blackrussia.online.network.InvItems;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

//@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J*\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¨\u0006\u0010"}, d2 = {"Lcom/rockstargames/gtacr/gui/inventory/MigrateItemsFromAny;", "", "()V", "addOtherParametersInList", "", "newList", "", "Lblackrussia/online/network/InvItems;", "allItems", "migrateDataFromAnyToObject", FirebaseAnalytics.Param.ITEMS, "ifSlot", "", "updateItemAfterMigrate", "thisItem", "migrateItem", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MigrateItemsFromAny {
    public final void migrateDataFromAnyToObject(List<Object> items, List<InvItems> newList, boolean z) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(newList, "newList");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        IntProgression step = RangesKt.step(RangesKt.until(0, items.size()), 3);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                int i = first + step2;
                arrayList.add(Integer.valueOf(Integer.parseInt(items.get(first).toString())));
                if (first == last) {
                    break;
                }
                first = i;
            }
        }
        IntProgression step3 = RangesKt.step(RangesKt.until(1, items.size()), 3);
        int first2 = step3.getFirst();
        int last2 = step3.getLast();
        int step4 = step3.getStep();
        if ((step4 > 0 && first2 <= last2) || (step4 < 0 && last2 <= first2)) {
            while (true) {
                int i2 = first2 + step4;
                if (items.get(first2) instanceof String) {
                    arrayList2.add(1);
                    arrayList3.add(items.get(first2).toString());
                } else {
                    arrayList2.add(Integer.valueOf(Integer.parseInt(items.get(first2).toString())));
                    arrayList3.add("");
                }
                if (first2 == last2) {
                    break;
                }
                first2 = i2;
            }
        }
        IntProgression step5 = RangesKt.step(RangesKt.until(2, items.size()), 3);
        int first3 = step5.getFirst();
        int last3 = step5.getLast();
        int step6 = step5.getStep();
        if ((step6 > 0 && first3 <= last3) || (step6 < 0 && last3 <= first3)) {
            while (true) {
                int i3 = first3 + step6;
                arrayList4.add(Integer.valueOf(Integer.parseInt(items.get(first3).toString())));
                if (first3 == last3) {
                    break;
                }
                first3 = i3;
            }
        }
        int size = newList.size();
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4 + 1;
            int size2 = arrayList4.size();
            int i6 = 0;
            while (i6 < size2) {
                int i7 = i6 + 1;
                if (i4 == ((Number) arrayList4.get(i6)).intValue()) {
                    int i8 = z ? i4 + 2 : i4;
                    if (i8 == 8 && z) {
                        InvItems invItems = newList.get(1);
                        invItems.setId(((Number) arrayList.get(i6)).intValue());
                        invItems.setItemsValue(((Number) arrayList2.get(i6)).intValue());
                        invItems.setTextIfException((String) arrayList3.get(i6));
                    } else {
                        InvItems invItems2 = newList.get(i8);
                        invItems2.setId(((Number) arrayList.get(i6)).intValue());
                        invItems2.setItemsValue(((Number) arrayList2.get(i6)).intValue());
                        invItems2.setTextIfException((String) arrayList3.get(i6));
                    }
                }
                i6 = i7;
            }
            i4 = i5;
        }
    }

    public final void addOtherParametersInList(List<InvItems> newList, List<InvItems> allItems) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        Intrinsics.checkNotNullParameter(allItems, "allItems");
        for (InvItems invItems : newList) {
            Iterator<InvItems> it = allItems.iterator();
            while (true) {
                if (it.hasNext()) {
                    InvItems next = it.next();
                    if (invItems.getId() == next.getId()) {
                        updateItemAfterMigrate(invItems, next);
                        break;
                    }
                }
            }
        }
    }

    private final void updateItemAfterMigrate(InvItems invItems, InvItems invItems2) {
        invItems.setName(invItems2.getName());
        invItems.setDesc(invItems2.getDesc());
        invItems.setModelid(invItems2.getModelid());
        invItems.setWeight(invItems2.getWeight());
        invItems.setAddw(invItems2.getAddw());
        invItems.setFold(invItems2.getFold());
        invItems.setShiftX(invItems2.getShiftX());
        invItems.setShiftY(invItems2.getShiftY());
        invItems.setShiftZ(invItems2.getShiftZ());
        invItems.setX(invItems2.getX());
        invItems.setY(invItems2.getY());
        invItems.setZ(invItems2.getZ());
        invItems.setZoom(invItems2.getZoom());
        invItems.setThisBitmap(invItems2.getThisBitmap());
        invItems.setWhoseItem(0);
        int id = invItems.getId();
        if (id == 58) {
            invItems.setTextIfException(String.valueOf(invItems.getItemsValue()));
            invItems.setItemsValue(1);
        } else if (id != 134) {
        } else {
            invItems.setModelid(invItems.getItemsValue());
            invItems.setItemsValue(1);
        }
    }
}
