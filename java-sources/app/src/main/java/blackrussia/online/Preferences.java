package blackrussia.online;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class Preferences {
    public static final String EMAIL = "EMAIL";
    public static final String FILES = "FILES";
    private static final String NAME = "preferences";
    public static final String NIK = "NIK";
    public static final String NOTIFICATION = "NOTIFICATION";
    public static final String PRIVACY = "PRIVACY";
    public static String USER_BALANCE = "USER_BALANCE";
    public static String USER_COLOR = "USER_COLOR";
    public static String USER_NAME = "USER_NAME";
    public static String USER_PASSWORD = "USER_PASSWORD";
    public static String USER_SERVER = "USER_SERVER";

    public static <T> void putObject(Context context, String key, T object) {
        SharedPreferences.Editor edit = context.getSharedPreferences(NAME, 0).edit();
        edit.putString(key, new Gson().toJson(object));
        edit.apply();
    }

    public static <T> T getObject(Context context, String str, Class<T> cls) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, 0);
        if (sharedPreferences.contains(str)) {
            return (T) new Gson().fromJson(sharedPreferences.getString(str, ""), (Class) cls);
        }
        return null;
    }

    public static <T> void putList(Context context, String key, ArrayList<T> list) {
        SharedPreferences.Editor edit = context.getSharedPreferences(NAME, 0).edit();
        edit.putString(key, new Gson().toJson(list));
        edit.apply();
    }

    public static <T> void restoreList(Context context, String key, ArrayList<T> list, Class<T> type) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, 0);
        if (sharedPreferences.contains(key)) {
            list.clear();
            list.addAll((Collection) new Gson().fromJson(sharedPreferences.getString(key, ""), TypeToken.getParameterized(ArrayList.class, type).getType()));
        }
    }

    public static void putFilesData(Context context, String key, HashMap<String, String> map) {
        SharedPreferences.Editor edit = context.getSharedPreferences(NAME, 0).edit();
        edit.putString(key, new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create().toJson(map, new TypeToken<HashMap<String, String>>() { // from class: blackrussia.online.Preferences.1
        }.getType()));
        edit.apply();
    }

    public static HashMap<String, String> restoreFilesData(Context context, String key) {
        HashMap<String, String> hashMap = new HashMap<>();
        SharedPreferences sharedPreferences = context.getSharedPreferences(NAME, 0);
        if (sharedPreferences.contains(key)) {
            hashMap.putAll((Map) new Gson().fromJson(sharedPreferences.getString(key, ""), new TypeToken<HashMap<String, String>>() { // from class: blackrussia.online.Preferences.2
            }.getType()));
        }
        return hashMap;
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences.Editor edit = context.getSharedPreferences(NAME, 0).edit();
        edit.putString(key, value);
        edit.apply();
    }

    public static String getString(Context context, String key) {
        return context.getSharedPreferences(NAME, 0).getString(key, "");
    }

    public static String getString(Context context, String key, String def) {
        return context.getSharedPreferences(NAME, 0).getString(key, def);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences.Editor edit = context.getSharedPreferences(NAME, 0).edit();
        edit.putBoolean(key, value);
        edit.apply();
    }

    public static boolean getBoolean(Context context, String key) {
        return context.getSharedPreferences(NAME, 0).getBoolean(key, false);
    }

    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        return context.getSharedPreferences(NAME, 0).getBoolean(key, defaultValue);
    }

    public static void clear(Context context, String key) {
        context.getSharedPreferences(NAME, 0).edit().remove(key).apply();
    }

    public static boolean existKey(Context context, String key) {
        return context.getSharedPreferences(NAME, 0).contains(key);
    }
}
