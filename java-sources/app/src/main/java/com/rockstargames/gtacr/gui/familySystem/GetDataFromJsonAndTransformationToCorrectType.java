package com.rockstargames.gtacr.gui.familySystem;

import android.text.Spanned;
import com.rockstargames.gtacr.data.FamilyNotificationData;
import com.rockstargames.gtacr.data.FamilyPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;

//@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004J \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\u0013"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/GetDataFromJsonAndTransformationToCorrectType;", "", "()V", "getJsonArrayAndIntCollectionReturnFamilyNotificationList", "", "Lcom/rockstargames/gtacr/data/FamilyNotificationData;", "thisJsonArray", "Lorg/json/JSONArray;", "thisIntCollection", "", "getJsonArrayReturnFamilyPlayer", "Lcom/rockstargames/gtacr/data/FamilyPlayer;", "jsonArrayWithNick", "jsonArrayWithRankAndStatus", "getJsonArrayReturnIntList", "getJsonArrayReturnSpannedList", "Landroid/text/Spanned;", "getJsonArrayReturnStringList", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetDataFromJsonAndTransformationToCorrectType {
    public final List<Integer> getJsonArrayReturnIntList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            int length = jSONArray.length();
            while (i < length) {
                int i2 = i + 1;
                Object obj = null;
                try {
                    obj = jSONArray.get(i);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
                arrayList.add(Integer.valueOf(((Integer) obj).intValue()));
                i = i2;
            }
        }
        return arrayList;
    }

    public final List<String> getJsonArrayReturnStringList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            int length = jSONArray.length();
            while (i < length) {
                int i2 = i + 1;
                Object obj = null;
                try {
                    obj = jSONArray.get(i);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                arrayList.add((String) obj);
                i = i2;
            }
        }
        return arrayList;
    }

    public final List<Spanned> getJsonArrayReturnSpannedList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            int length = jSONArray.length();
            while (i < length) {
                int i2 = i + 1;
                ActionWithString actionWithString = new ActionWithString();
                Object obj = null;
                try {
                    obj = jSONArray.get(i);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                arrayList.add(actionWithString.convertStringToHtmlType((String) obj));
                i = i2;
            }
        }
        return arrayList;
    }

    public final List<FamilyNotificationData> getJsonArrayAndIntCollectionReturnFamilyNotificationList(JSONArray jSONArray, List<Integer> thisIntCollection) {
        Intrinsics.checkNotNullParameter(thisIntCollection, "thisIntCollection");
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            int i2 = 0;
            int i3 = 1;
            while (i < jSONArray.length()) {
                Object obj = null;
                try {
                    obj = jSONArray.get(i);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                Object obj2 = null;
                try {
                    obj2 = jSONArray.get(i3);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.String");
                arrayList.add(new FamilyNotificationData((String) obj, (String) obj2, thisIntCollection.get(i2).intValue()));
                i += 2;
                i3 += 2;
                i2++;
            }
        }
        return arrayList;
    }

    public final List<FamilyPlayer> getJsonArrayReturnFamilyPlayer(JSONArray jSONArray, JSONArray jSONArray2) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray2 != null && jSONArray.length() == jSONArray2.length() / 2) {
            int i = 1;
            int i2 = 0;
            int i3 = 0;
            while (i2 < jSONArray.length()) {
                Object obj = null;
                try {
                    obj = jSONArray.get(i2);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                String str = (String) obj;
                Object obj2 = jSONArray2.get(i3);
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) obj2).intValue();
                Object obj3 = jSONArray2.get(i);
                Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                arrayList.add(new FamilyPlayer(str, intValue, ((Integer) obj3).intValue(), false, 8, null));
                i2++;
                i3 += 2;
                i += 2;
            }
        }
        return arrayList;
    }
}
