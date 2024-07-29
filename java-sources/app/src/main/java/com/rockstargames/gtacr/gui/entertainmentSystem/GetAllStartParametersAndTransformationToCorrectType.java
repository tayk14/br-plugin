package com.rockstargames.gtacr.gui.entertainmentSystem;

import blackrussia.online.R;
import com.rockstargames.gtacr.data.EntertainmentPlayersData;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;

//@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0002¨\u0006\u0015"}, d2 = {"Lcom/rockstargames/gtacr/gui/entertainmentSystem/GetAllStartParametersAndTransformationToCorrectType;", "", "()V", "getArrWithAllPlayers", "", "", "thisJsonArr", "Lorg/json/JSONArray;", "getArrWithCurrentTopGames", "getArrWithCurrentTopPositions", "getListWithTopPlayers0", "Lcom/rockstargames/gtacr/data/EntertainmentPlayersData;", "getListWithTopPlayers1", "getListWithTopPlayers2", "getListWithTopPlayers3", "getListWithTopPlayers4", "getListWithTopPlayers5", "transformationFromAnyToObject", "listAny", "", "thisGame", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetAllStartParametersAndTransformationToCorrectType {
    public final List<Integer> getArrWithAllPlayers(JSONArray jSONArray) {
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

    public final List<EntertainmentPlayersData> getListWithTopPlayers0(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                Object obj = null;
                try {
                    obj = jSONArray.get(i);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                Intrinsics.checkNotNullExpressionValue(obj, "thisJsonArr_[i]");
                arrayList.add(obj);
                i = i2;
            }
        }
        return transformationFromAnyToObject(arrayList, 0);
    }

    public final List<EntertainmentPlayersData> getListWithTopPlayers1(JSONArray jSONArray) {
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
                Intrinsics.checkNotNullExpressionValue(obj, "thisJsonArr_[i]");
                arrayList.add(obj);
                i = i2;
            }
        }
        return transformationFromAnyToObject(arrayList, 1);
    }

    public final List<EntertainmentPlayersData> getListWithTopPlayers2(JSONArray jSONArray) {
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
                Intrinsics.checkNotNullExpressionValue(obj, "thisJsonArr_[i]");
                arrayList.add(obj);
                i = i2;
            }
        }
        return transformationFromAnyToObject(arrayList, 2);
    }

    public final List<EntertainmentPlayersData> getListWithTopPlayers3(JSONArray jSONArray) {
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
                Intrinsics.checkNotNullExpressionValue(obj, "thisJsonArr_[i]");
                arrayList.add(obj);
                i = i2;
            }
        }
        return transformationFromAnyToObject(arrayList, 3);
    }

    public final List<EntertainmentPlayersData> getListWithTopPlayers4(JSONArray jSONArray) {
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
                Intrinsics.checkNotNullExpressionValue(obj, "thisJsonArr_[i]");
                arrayList.add(obj);
                i = i2;
            }
        }
        return transformationFromAnyToObject(arrayList, 4);
    }

    public final List<EntertainmentPlayersData> getListWithTopPlayers5(JSONArray jSONArray) {
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
                Intrinsics.checkNotNullExpressionValue(obj, "thisJsonArr_[i]");
                arrayList.add(obj);
                i = i2;
            }
        }
        return transformationFromAnyToObject(arrayList, 5);
    }

    private final List<EntertainmentPlayersData> transformationFromAnyToObject(List<Object> list, int i) {
        int i2;
        int i3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i4 = 0;
        int i5 = 1;
        int i6 = 1;
        while (i4 < list.size()) {
            arrayList3.add((String) list.get(i4));
            arrayList4.add((Integer) list.get(i5));
            arrayList2.add(Integer.valueOf(i6));
            i6++;
            i4 += 2;
            i5 += 2;
        }
        if (arrayList2.size() == arrayList3.size() && arrayList2.size() == arrayList4.size()) {
            int size = arrayList2.size();
            int i7 = 0;
            while (i7 < size) {
                int i8 = i7 + 1;
                int intValue = ((Number) arrayList2.get(i7)).intValue();
                if (intValue == 1) {
                    i2 = R.drawable.entertainment_system_top_1_left_res;
                    i3 = R.drawable.entertainment_system_top_1_right_res;
                } else if (intValue == 2) {
                    i2 = R.drawable.entertainment_system_top_2_left_res;
                    i3 = R.drawable.entertainment_system_top_2_right_res;
                } else if (intValue != 3) {
                    i2 = 0;
                    i3 = 0;
                } else {
                    i2 = R.drawable.entertainment_system_top_3_left_res;
                    i3 = R.drawable.entertainment_system_top_3_right_res;
                }
                int intValue2 = ((Number) arrayList4.get(i7)).intValue();
                arrayList.add(new EntertainmentPlayersData(((Number) arrayList2.get(i7)).intValue(), (String) arrayList3.get(i7), i, intValue2 == 0 ? "-" : String.valueOf(intValue2), i2, i3));
                i7 = i8;
            }
        }
        return arrayList;
    }

    public final List<Integer> getArrWithCurrentTopPositions(JSONArray jSONArray) {
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

    public final List<Integer> getArrWithCurrentTopGames(JSONArray jSONArray) {
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
}
