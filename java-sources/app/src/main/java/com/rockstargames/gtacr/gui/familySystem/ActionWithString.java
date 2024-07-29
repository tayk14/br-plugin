package com.rockstargames.gtacr.gui.familySystem;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/ActionWithString;", "", "()V", "convertStringToHtmlType", "Landroid/text/Spanned;", "currentText", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ActionWithString {
    public final Spanned convertStringToHtmlType(String currentText) {
        Spanned finalTextSpanned;
        int i = 0;
        Intrinsics.checkNotNullParameter(currentText, "currentText");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int length = currentText.length();
        String str = "";
        String str2 = "";
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (currentText.charAt(i2) == '{') {
                arrayList.add(Integer.valueOf(i3));
            } else if (arrayList.size() == 0 && currentText.charAt(i2) != '/' && currentText.charAt(i2) != '\\') {
                str2 = Intrinsics.stringPlus(str2, Character.valueOf(currentText.charAt(i2)));
            }
            i2 = i3;
        }
        if (!Intrinsics.areEqual(str2, "")) {
            arrayList3.add(str2);
            str2 = "";
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer pos = (Integer) it.next();
            int length2 = currentText.length();
            String str3 = "";
            int i4 = 0;
            boolean z = false;
            while (i4 < length2) {
                int i5 = i4 + 1;
                Intrinsics.checkNotNullExpressionValue(pos, "pos");
                int intValue = i4 - pos.intValue();
                if (intValue >= 0 && intValue < 6) {
                    str3 = Intrinsics.stringPlus(str3, Character.valueOf(currentText.charAt(i4) == '-' ? '0' : currentText.charAt(i4)));
                } else if (i4 - pos.intValue() > 6 && !z) {
                    if (currentText.charAt(i4) != '{') {
                        if (currentText.charAt(i4) != '/' && currentText.charAt(i4) != '\\') {
                            str2 = Intrinsics.stringPlus(str2, Character.valueOf(currentText.charAt(i4)));
                        }
                    } else if (!Intrinsics.areEqual(str2, "")) {
                        arrayList3.add(str2);
                        str2 = "";
                        i4 = i5;
                        z = true;
                    }
                }
                i4 = i5;
            }
            if (str3.length() == 6) {
                arrayList2.add(str3);
            }
        }
        if (!Intrinsics.areEqual(str2, "")) {
            arrayList3.add(str2);
        }
        if (arrayList3.size() > arrayList.size()) {
            Object obj = arrayList3.get(0);
            Intrinsics.checkNotNullExpressionValue(obj, "savedTextArr[0]");
            str = (String) obj;
            if (arrayList3.size() - 1 == arrayList2.size()) {
                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                    str = str + "<font color=\"" + ((String) arrayList2.get(i6)) + "\">" + ((String) arrayList3.get(i)) + "</font>";
                }
            }
        } else if (arrayList3.size() == arrayList2.size()) {
            for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                str = str + "<font color=\"#" + ((String) arrayList2.get(i7)) + "\">" + ((String) arrayList3.get(i7)) + "</font>";
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            finalTextSpanned = Html.fromHtml(str, 0);
        } else {
            finalTextSpanned = Html.fromHtml(str);
        }
        Intrinsics.checkNotNullExpressionValue(finalTextSpanned, "finalTextSpanned");
        return finalTextSpanned;
    }
}
