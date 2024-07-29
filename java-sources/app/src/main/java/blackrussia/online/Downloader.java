package blackrussia.online;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import blackrussia.online.Downloader;
import blackrussia.online.activities.LoaderActivity;
import blackrussia.online.network.ApiService;
import blackrussia.online.network.MyFile;
import blackrussia.online.network.UserAgentInterceptor;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.UByte;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes.dex */
public class Downloader {
    public static final String ADRENO_TEGRA = "adrenotegra";
    private static final String APK = "blackrussia_client.apk";
    public static final String ETC = "etc";
    public static final String MALI = "mali";
    public static final String POWER_VR = "powervr";
    private LoaderActivity activity;
    private String currentFolder;
    private int downloadCount;
    private String gamePath;
    private volatile boolean isNeedInstallAPK;
    private long countSizeFiles = 0;
    private long countSizeTextures = 0;
    private long finalTotalSizeFiles = -1;
    private long finalTotalSizeTextures = -1;
    private long tempSizeFiles = 0;
    private long tempSizeTextures = 0;
    private Handler handler = new Handler();
    private String downloadURL = Settings.API;

    public Downloader(LoaderActivity activity) {
        this.activity = activity;
    }

    public void checkFiles(String folder) {
        this.currentFolder = folder;
        getFiles();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: blackrussia.online.Downloader$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Callback<ArrayList<MyFile>> {
        AnonymousClass1() {
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ArrayList<MyFile>> call, final Response<ArrayList<MyFile>> response) {
            if (response.body() != null) {
                Downloader.this.activity.runOnUiThread(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$1$jM1_KRs4WA6-Uq8DvHS9o1eq2y8
                    @Override // java.lang.Runnable
                    public final void run() {
                        Downloader.AnonymousClass1.this.lambda$onResponse$4$Downloader$1(response);
                    }
                });
            } else {
                Downloader.this.reload();
            }
        }

        public /* synthetic */ void lambda$onResponse$4$Downloader$1(final Response response) {
            String substring;
            Downloader downloader = Downloader.this;
            downloader.gamePath = downloader.activity.getExternalFilesDir(null).getAbsolutePath();
            Downloader.this.gamePath = Downloader.this.gamePath.replace("blackrussia.online/files", "") + Settings.CLIENT_PACKAGE + "/files/";
            File file = new File(Downloader.this.gamePath.replace("/files/", ""));
            if (!file.exists()) {
                file.mkdirs();
            }
            int i = 0;
            File file2 = new File(Downloader.this.gamePath.substring(0, Downloader.this.gamePath.lastIndexOf("/")));
            if (!file2.exists()) {
                file2.mkdirs();
            }
            int i2 = 1;
            try {
                PackageInfo packageInfo = Downloader.this.activity.getPackageManager().getPackageInfo(Settings.CLIENT_PACKAGE, 0);
                PackageInfo packageArchiveInfo = Downloader.this.activity.getPackageManager().getPackageArchiveInfo(Downloader.this.gamePath + Downloader.APK, 0);
                if (packageArchiveInfo != null && !packageInfo.versionName.equalsIgnoreCase(packageArchiveInfo.versionName)) {
                    Downloader.this.isNeedInstallAPK = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                Downloader.this.isNeedInstallAPK = true;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Downloader.ADRENO_TEGRA);
            arrayList.add(Downloader.MALI);
            arrayList.add(Downloader.POWER_VR);
            arrayList.add(Downloader.ETC);
            arrayList.remove(Downloader.this.currentFolder);
            final ArrayList arrayList2 = (ArrayList) response.body();
            final ArrayList arrayList3 = new ArrayList();
            int size = arrayList2.size() - 1;
            long j = 0;
            while (size >= 0) {
                if (((MyFile) arrayList2.get(size)).getPath().startsWith((String) arrayList.get(i)) || ((MyFile) arrayList2.get(size)).getPath().startsWith((String) arrayList.get(i2)) || ((MyFile) arrayList2.get(size)).getPath().startsWith((String) arrayList.get(2))) {
                    arrayList2.remove(size);
                } else {
                    if (((MyFile) arrayList2.get(size)).getPath().contains("texdb") && !((MyFile) arrayList2.get(size)).getPath().contains("texdb/player") && !((MyFile) arrayList2.get(size)).getPath().contains("texdb/playerhi") && !((MyFile) arrayList2.get(size)).getPath().contains("texdb/menu")) {
                        if (Downloader.this.currentFolder.equals(Downloader.ETC) || Downloader.this.currentFolder.equals(Downloader.ADRENO_TEGRA) || !((MyFile) arrayList2.get(size)).getName().contains(".dxt.")) {
                            if (Downloader.this.currentFolder.equals(Downloader.ETC) || Downloader.this.currentFolder.equals(Downloader.MALI) || !((MyFile) arrayList2.get(size)).getName().contains(".etc.")) {
                                if (!Downloader.this.currentFolder.equals(Downloader.ETC) && !Downloader.this.currentFolder.equals(Downloader.POWER_VR) && ((MyFile) arrayList2.get(size)).getName().contains(".pvr.")) {
                                    arrayList2.remove(size);
                                }
                            } else {
                                arrayList2.remove(size);
                            }
                        } else {
                            arrayList2.remove(size);
                        }
                    }
                    if (!((MyFile) arrayList2.get(size)).getPath().startsWith("high") && !((MyFile) arrayList2.get(size)).getPath().startsWith("notrees")) {
                        if (((MyFile) arrayList2.get(size)).getPath().startsWith(Downloader.this.currentFolder)) {
                            arrayList3.add(arrayList2.get(size));
                            arrayList2.remove(size);
                        } else {
                            String path = ((MyFile) arrayList2.get(size)).getPath();
                            if (path.startsWith("high/")) {
                                path = path.replace("high/", "files/");
                            }
                            if (path.startsWith("notrees/")) {
                                path = path.replace("notrees/", "files/SAMP/");
                            }
                            if (path.startsWith("files/")) {
                                path = path.substring(path.indexOf("files/") + 6);
                            }
                            File file3 = new File(Downloader.this.gamePath + path + ((MyFile) arrayList2.get(size)).getName());
                            if (file3.exists() && ((MyFile) arrayList2.get(size)).getName().equalsIgnoreCase("settings.ini")) {
                                arrayList2.remove(size);
                            } else if (file3.exists() && ((MyFile) arrayList2.get(size)).getName().equalsIgnoreCase("gta_sa.set")) {
                                arrayList2.remove(size);
                            } else {
                                String str = App.getInstance().getDataFiles().get(((MyFile) arrayList2.get(size)).getPath() + ((MyFile) arrayList2.get(size)).getName());
                                if (str != null && str.equals(((MyFile) arrayList2.get(size)).getDate()) && file3.exists() && file3.length() == ((MyFile) arrayList2.get(size)).getSize()) {
                                    arrayList2.remove(size);
                                } else {
                                    if (((MyFile) arrayList2.get(size)).getName().equalsIgnoreCase(Downloader.APK)) {
                                        Downloader.this.isNeedInstallAPK = true;
                                    }
                                    j += ((MyFile) arrayList2.get(size)).getSize();
                                }
                            }
                        }
                    } else {
                        arrayList2.remove(size);
                    }
                }
                size--;
                i2 = 1;
                i = 0;
            }
            ArrayList arrayList4 = new ArrayList();
            for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
                if (((MyFile) arrayList3.get(size2)).getName().endsWith(".saa")) {
                    File file4 = new File(Downloader.this.gamePath + ((MyFile) arrayList3.get(size2)).getName());
                    String str2 = App.getInstance().getDataFiles().get(((MyFile) arrayList3.get(size2)).getPath() + ((MyFile) arrayList3.get(size2)).getName());
                    if (str2 != null && str2.equals(((MyFile) arrayList3.get(size2)).getDate()) && file4.exists() && file4.length() == ((MyFile) arrayList3.get(size2)).getSize()) {
                        arrayList4.add(((MyFile) arrayList3.get(size2)).getName().substring(0, ((MyFile) arrayList3.get(size2)).getName().indexOf(".saa")));
                    }
                }
            }
            for (int size3 = arrayList3.size() - 1; size3 >= 0; size3--) {
                Iterator it = arrayList4.iterator();
                while (true) {
                    if (it.hasNext()) {
                        String str3 = (String) it.next();
                        if (((MyFile) arrayList3.get(size3)).getName().endsWith(".saa")) {
                            substring = ((MyFile) arrayList3.get(size3)).getName().substring(0, ((MyFile) arrayList3.get(size3)).getName().indexOf(".saa"));
                        } else {
                            substring = ((MyFile) arrayList3.get(size3)).getName().substring(0, ((MyFile) arrayList3.get(size3)).getName().indexOf(".zip"));
                        }
                        if (substring.equalsIgnoreCase(str3)) {
                            arrayList3.remove(size3);
                            break;
                        }
                    }
                }
            }
            long j2 = 0;
            for (int size4 = arrayList3.size() - 1; size4 >= 0; size4--) {
                if (((MyFile) arrayList3.get(size4)).getName().endsWith(".zip")) {
                    j2 += ((MyFile) arrayList3.get(size4)).getSize();
                }
            }
            if (arrayList2.size() > 0) {
                Downloader.this.activity.runOnUiThread(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$1$tQHz2BFasSOjSYrx0rZMqtkMjL8
                    @Override // java.lang.Runnable
                    public final void run() {
                        Downloader.AnonymousClass1.this.lambda$null$0$Downloader$1();
                    }
                });
            }
            if (Downloader.this.finalTotalSizeFiles == -1) {
                Downloader.this.finalTotalSizeFiles = j;
            }
            if (Downloader.this.finalTotalSizeTextures == -1) {
                Downloader.this.finalTotalSizeTextures = j2;
            }
            new Thread(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$1$n8zlQVJ2lCYog34UNvufVvuwW6A
                @Override // java.lang.Runnable
                public final void run() {
                    Downloader.AnonymousClass1.this.lambda$null$3$Downloader$1(arrayList2, arrayList3);
                }
            }).start();
        }

        public /* synthetic */ void lambda$null$0$Downloader$1() {
            Downloader.this.activity.setProgressFilesLoad(0);
        }

        public /* synthetic */ void lambda$null$3$Downloader$1(final ArrayList myFiles, final ArrayList textures) {
            for (int i = 0; i < myFiles.size(); i++) {
                try {
                    Downloader.this.downloadFiles((MyFile) myFiles.get(i));
                } catch (Exception e) {
                    e.printStackTrace();
                    if (App.getInstance().getLinkList().size() > 0) {
                        Downloader.this.downloadURL = App.getInstance().getLinkList().get(App.getInstance().rnd(App.getInstance().getLinkList().size()));
                    }
                    Downloader.this.reload();
                    return;
                }
            }
            Downloader.this.activity.runOnUiThread(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$1$ZQlrhhwJtn9SEDmAOZc7M6nAzCw
                @Override // java.lang.Runnable
                public final void run() {
                    Downloader.AnonymousClass1.this.lambda$null$1$Downloader$1();
                }
            });
            if (textures.size() > 0) {
                Downloader.this.activity.runOnUiThread(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$1$mXKY_unzUGfCCzRPmUfIGeHTHNw
                    @Override // java.lang.Runnable
                    public final void run() {
                        Downloader.AnonymousClass1.this.lambda$null$2$Downloader$1();
                    }
                });
            }
            int i2 = 0;
            for (int i3 = 0; i3 < textures.size(); i3++) {
                if (!((MyFile) textures.get(i3)).getName().endsWith(".saa")) {
                    i2++;
                    try {
                        Downloader.this.downloadTextures((MyFile) textures.get(i3), textures, i2);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if (App.getInstance().getTempNik() != null) {
                Downloader.this.writeNik();
                App.getInstance().setTempNik(null);
            }
            try {
                PackageInfo packageInfo = Downloader.this.activity.getPackageManager().getPackageInfo("blackrussia.online", 0);
                PackageInfo packageArchiveInfo = Downloader.this.activity.getPackageManager().getPackageArchiveInfo(Downloader.this.gamePath + "launcher.apk", 0);
                if (packageArchiveInfo == null || packageInfo.versionName.equalsIgnoreCase(packageArchiveInfo.versionName)) {
                    Downloader.this.activity.startMainActivity();
                } else if (Downloader.this.activity.isFinishing()) {
                    Downloader.this.activity.mInstallLauncher = true;
                } else {
                    Downloader.this.installLauncher();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public /* synthetic */ void lambda$null$1$Downloader$1() {
            Downloader.this.activity.setFileName("");
        }

        public /* synthetic */ void lambda$null$2$Downloader$1() {
            Downloader.this.activity.setProgressTexturesLoad(0);
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ArrayList<MyFile>> call, Throwable t) {
            Downloader.this.reload();
        }
    }

    private void getFiles() {
        ApiService.getInstance().getApiService().getFiles().enqueue(new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reload() {
        this.countSizeFiles -= this.tempSizeFiles;
        this.countSizeTextures -= this.tempSizeTextures;
        this.tempSizeFiles = 0L;
        this.tempSizeTextures = 0L;
        int i = this.downloadCount;
        if (i < 2) {
            this.downloadCount = i + 1;
            this.activity.startUpdate();
        } else {
            this.downloadCount = 0;
            this.activity.runOnUiThread(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$hfeqesZuWq5cZ-jzPcE1MqS1wcs
                @Override // java.lang.Runnable
                public final void run() {
                    Downloader.this.lambda$reload$0$Downloader();
                }
            });
        }
    }

    public /* synthetic */ void lambda$reload$0$Downloader() {
        this.activity.setRepeatButtonVisibility(0);
        this.activity.setErrorConnection();
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 4, expect 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void downloadTextures(MyFile texture, final ArrayList<MyFile> textures, final int currentZip) throws Exception {
        okhttp3.Response execute = new OkHttpClient.Builder().addInterceptor(new UserAgentInterceptor("")).build().newCall(new Request.Builder().url(this.downloadURL + texture.getPath() + texture.getName()).build()).execute();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(execute.body().byteStream());
        FileOutputStream fileOutputStream = new FileOutputStream(this.gamePath + texture.getName());
        byte[] bArr = new byte[8192];
        int progress = this.activity.getProgress();
        this.tempSizeTextures = 0L;
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read == -1) {
                break;
            }
            long j = read;
            this.tempSizeTextures += j;
            this.countSizeTextures += j;
            fileOutputStream.write(bArr, 0, read);
            int i = (int) ((this.countSizeTextures * 100) / this.finalTotalSizeTextures);
            if (i > progress) {
                if (i > 100) {
                    i = 100;
                }
                int finalI = i;
                this.activity.runOnUiThread(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$WzsgrDi07bPGcLgQW56cYYpCJW4
                    @Override // java.lang.Runnable
                    public final void run() {
                        Downloader.this.lambda$downloadTextures$1$Downloader(finalI);
                    }
                });
                Log.d("progress", "" + (((((float) this.countSizeTextures) * 1.0f) * 100.0f) / ((float) this.finalTotalSizeTextures)) + " | " + this.countSizeTextures + " / " + this.finalTotalSizeTextures);
                progress = i;
            }
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        execute.body().close();
        this.activity.runOnUiThread(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$woilWT7wraVBJQAcSfq5YEpDNc8
            @Override // java.lang.Runnable
            public final void run() {
                Downloader.this.lambda$downloadTextures$2$Downloader(currentZip, textures);
            }
        });
        File file = new File(this.gamePath + texture.getName());
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
        byte[] bArr2 = new byte[65536];
        for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
            File file2 = new File(this.gamePath + File.separator + nextEntry.getName());
            if (nextEntry.isDirectory()) {
                file2.mkdir();
            } else {
                new File(file2.getParent()).mkdirs();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                while (true) {
                    try {
                        int read2 = zipInputStream.read(bArr2);
                        if (read2 <= 0) {
                            break;
                        } else {
                            fileOutputStream2.write(bArr2, 0, read2);
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (th == null) {
                                fileOutputStream2.close();
                                throw th2;
                            }
                            try {
                                fileOutputStream2.close();
                                throw th2;
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                                throw th2;
                            }
                        }
                    }
                }
                fileOutputStream2.close();
            }
        }
        zipInputStream.closeEntry();
        zipInputStream.close();
        String str = texture.getName().substring(0, texture.getName().indexOf(".zip")) + ".saa";
        new File(this.gamePath + texture.getName().substring(0, texture.getName().indexOf(".zip")));
        if (file.length() != texture.getSize()) {
            throw new Exception("bad length");
        }
        Iterator<MyFile> it = textures.iterator();
        while (it.hasNext()) {
            MyFile next = it.next();
            if (next.getName().equalsIgnoreCase(str)) {
                App.getInstance().getDataFiles().put(next.getPath() + next.getName(), next.getDate());
                Preferences.putFilesData(App.getInstance(), Preferences.FILES, App.getInstance().getDataFiles());
                file.delete();
            }
        }
    }

    public /* synthetic */ void lambda$downloadTextures$1$Downloader(final int finalProgress) {
        this.activity.setProgressTexturesLoad(finalProgress);
        LoaderActivity loaderActivity = this.activity;
        double d = this.countSizeTextures;
        Double.isNaN(d);
        double d2 = this.finalTotalSizeTextures;
        Double.isNaN(d2);
        loaderActivity.setLoaded((d * 1.0d) / 1048576.0d, (d2 * 1.0d) / 1048576.0d);
    }

    public /* synthetic */ void lambda$downloadTextures$2$Downloader(final int currentZip, final ArrayList textures) {
        this.activity.setProgressUnzip(currentZip, textures.size() / 2);
    }

    public static String fileToMD5(String filePath) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            try {
                byte[] bArr = new byte[1024];
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                int i = 0;
                while (i != -1) {
                    i = fileInputStream.read(bArr);
                    if (i > 0) {
                        messageDigest.update(bArr, 0, i);
                    }
                }
                String convertHashToString = convertHashToString(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused) {
                }
                return convertHashToString;
            } catch (Exception unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            fileInputStream = null;
        } catch (Throwable th2) {

        }
        return filePath;
    }

    private static String convertHashToString(byte[] md5Bytes) {
        String str = "";
        for (byte b : md5Bytes) {
            str = str + Integer.toString((b & UByte.MAX_VALUE) + 256, 16).substring(1);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadFiles(MyFile myFile) throws Exception {
        String path = myFile.getPath();
        if (path.startsWith("high/")) {
            path = path.replace("high/", "files/");
        }
        if (path.startsWith("notrees/")) {
            path = path.replace("notrees/", "files/SAMP/");
        }
        String str = this.gamePath;
        String substring = str.substring(0, str.lastIndexOf("/"));
        if (path.startsWith("files/")) {
            path = path.substring(path.indexOf("files/") + 6);
        }
        String[] split = path.split("/");
        String str2 = "";
        for (int i = 0; i < split.length; i++) {
            str2 = i > 0 ? str2 + "/" + split[i] : str2 + split[i];
            File file = new File(substring + "/" + str2);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        Logger.i("Downloading from " + this.downloadURL + myFile.getPath() + myFile.getName());
        okhttp3.Response execute = new OkHttpClient.Builder().addInterceptor(new UserAgentInterceptor("")).build().newCall(new Request.Builder().url(this.downloadURL + myFile.getPath() + myFile.getName()).build()).execute();
        if (execute.code() != 200) {
            throw new IOException();
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(execute.body().byteStream());
        FileOutputStream fileOutputStream = new FileOutputStream(new File(this.gamePath + path + myFile.getName()));
        byte[] bArr = new byte[8192];
        int progress = this.activity.getProgress();
        this.tempSizeFiles = 0L;
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read == -1) {
                break;
            }
            Log.d("progress", "" + (((((float) this.countSizeFiles) * 1.0f) * 100.0f) / ((float) this.finalTotalSizeFiles)) + " | " + this.countSizeFiles + " / " + this.finalTotalSizeFiles);
            fileOutputStream.write(bArr, 0, read);
            long j = (long) read;
            this.tempSizeFiles = this.tempSizeFiles + j;
            long j2 = this.countSizeFiles + j;
            this.countSizeFiles = j2;
            int i2 = (int) ((j2 * 100) / this.finalTotalSizeFiles);
            if (i2 > progress) {
                if (i2 > 100) {
                    i2 = 100;
                }
                int finalI = i2;
                this.activity.runOnUiThread(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$LSmj1JpO9Q2yTQI086uIJ_DXGn4
                    @Override // java.lang.Runnable
                    public final void run() {
                        Downloader.this.lambda$downloadFiles$3$Downloader(finalI);
                    }
                });
                progress = i2;
            }
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        execute.body().close();
        String path2 = myFile.getPath();
        if (myFile.getName().equals("gta_sa.set")) {
            path2 = path2.replace("high", "files");
        }
        App.getInstance().getDataFiles().put(path2 + myFile.getName(), myFile.getDate());
        Preferences.putFilesData(App.getInstance(), Preferences.FILES, App.getInstance().getDataFiles());
    }

    public /* synthetic */ void lambda$downloadFiles$3$Downloader(final int finalProgress) {
        this.activity.setProgressFilesLoad(finalProgress);
        LoaderActivity loaderActivity = this.activity;
        double d = this.countSizeFiles;
        Double.isNaN(d);
        double d2 = this.finalTotalSizeFiles;
        Double.isNaN(d2);
        loaderActivity.setLoaded((d * 1.0d) / 1048576.0d, (d2 * 1.0d) / 1048576.0d);
    }

    private void installAPK() {
        try {
            if (this.activity.getPackageManager().getPackageInfo(Settings.CLIENT_PACKAGE, 0).versionName.equalsIgnoreCase(this.activity.getPackageManager().getPackageArchiveInfo(this.gamePath + APK, 0).versionName)) {
                this.activity.startUpdate();
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (App.getInstance().getTempNik() != null) {
            writeNik();
            App.getInstance().setTempNik(null);
        }
        this.activity.runOnUiThread(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$g2SRu66jggzR-zKH72K3CFMkBZI
            @Override // java.lang.Runnable
            public final void run() {
                Downloader.this.lambda$installAPK$8$Downloader();
            }
        });
    }

    public /* synthetic */ void lambda$installAPK$8$Downloader() {
        final Dialog dialog = new Dialog(this.activity);
        dialog.setContentView(R.layout.item_dialog_settings);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(-1, -2);
        ((TextView) dialog.findViewById(R.id.message)).setText(this.activity.getResources().getString(R.string.installClientMessage));
        ((TextView) dialog.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.-$$Lambda$Downloader$cjAfpOORB7qMcr4Fk9oobcwHmsk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Downloader.this.lambda$null$5$Downloader(dialog, view);
            }
        });
        TextView textView = (TextView) dialog.findViewById(R.id.ok);
        textView.setText(this.activity.getResources().getString(R.string.install));
        textView.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.-$$Lambda$Downloader$WF5DDB5vlbLeXK-J4Muuj9tPx4w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Downloader.this.lambda$null$7$Downloader(dialog, view);
            }
        });
        dialog.show();
    }

    public /* synthetic */ void lambda$null$5$Downloader(final Dialog dialog, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this.activity, R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$0tHLgsbgaAL4fxC7wFOPZyazKHk
            @Override // java.lang.Runnable
            public final void run() {
                Downloader.this.lambda$null$4$Downloader(dialog);
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$4$Downloader(final Dialog dialog) {
        dialog.dismiss();
        App.getInstance().setStartGame(false);
        this.activity.startMainActivity();
    }

    public /* synthetic */ void lambda$null$7$Downloader(final Dialog dialog, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this.activity, R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$fljJJtiQMQklVzww5YLz0DcWsO0
            @Override // java.lang.Runnable
            public final void run() {
                Downloader.this.lambda$null$6$Downloader(dialog);
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$6$Downloader(final Dialog dialog) {
        dialog.dismiss();
        try {
            File file = new File(this.gamePath + APK);
            Uri fromFile = Uri.fromFile(file);
            if (Build.VERSION.SDK_INT >= 24) {
                fromFile = FileProvider.getUriForFile(this.activity, this.activity.getPackageName() + ".provider", file);
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            intent.addFlags(1);
            this.activity.startActivityForResult(intent, 101);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this.activity, "Ошибка, сбросьте настройки", 1).show();
            this.activity.startMainActivity();
        }
    }

    public void installLauncher() {
        this.activity.runOnUiThread(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$p37fozUyCk4kpvisxX1FHa2VDjA
            @Override // java.lang.Runnable
            public final void run() {
                Downloader.this.lambda$installLauncher$13$Downloader();
            }
        });
    }

    public /* synthetic */ void lambda$installLauncher$13$Downloader() {
        final Dialog dialog = new Dialog(this.activity);
        dialog.setContentView(R.layout.item_dialog_settings);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(-1, -2);
        ((TextView) dialog.findViewById(R.id.message)).setText(this.activity.getResources().getString(R.string.updateLauncherMessage));
        ((TextView) dialog.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.-$$Lambda$Downloader$06gSZ0aK3KqNh_1xw3wVrwG1beQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Downloader.this.lambda$null$10$Downloader(dialog, view);
            }
        });
        TextView textView = (TextView) dialog.findViewById(R.id.ok);
        textView.setText(this.activity.getResources().getString(R.string.install));
        textView.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.-$$Lambda$Downloader$x6JH0GPNJ8MBul4rK_i2OtxQopQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Downloader.this.lambda$null$12$Downloader(dialog, view);
            }
        });
        dialog.show();
    }

    public /* synthetic */ void lambda$null$10$Downloader(final Dialog dialog, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this.activity, R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$mfZ-mNHHoLUcjkHz77Jiz4vmFtM
            @Override // java.lang.Runnable
            public final void run() {
                Downloader.this.lambda$null$9$Downloader(dialog);
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$9$Downloader(final Dialog dialog) {
        dialog.dismiss();
        App.getInstance().setStartGame(false);
        this.activity.startMainActivity();
    }

    public /* synthetic */ void lambda$null$12$Downloader(final Dialog dialog, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(this.activity, R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.-$$Lambda$Downloader$o8dVgYcIUOQiRMCZgOs_IwMWoJ0
            @Override // java.lang.Runnable
            public final void run() {
                Downloader.this.lambda$null$11$Downloader(dialog);
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$11$Downloader(final Dialog dialog) {
        dialog.dismiss();
        try {
            File file = new File(this.gamePath + "launcher.apk");
            Uri fromFile = Uri.fromFile(file);
            if (Build.VERSION.SDK_INT >= 24) {
                fromFile = FileProvider.getUriForFile(this.activity, this.activity.getPackageName() + ".provider", file);
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            intent.setFlags(268435456);
            intent.addFlags(1);
            this.activity.startActivityForResult(intent, 101);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this.activity, "Ошибка, сбросьте настройки", 1).show();
            this.activity.startMainActivity();
        }
    }

    private boolean isAppInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeNik() {
        Throwable th;
        FileWriter fileWriter;
        IOException e;
        String absolutePath = this.activity.getExternalFilesDir(null).getAbsolutePath();
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(absolutePath.replace("blackrussia.online/files", ""));
        sb.append(Settings.CLIENT_PACKAGE);
        sb.append("/files/SAMP/settings.ini");
        String sb2 = sb.toString();
        try {
            str = readUsingBufferedReader(sb2);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        String replaceAll = str.replaceAll("name =.*", "name = " + App.getInstance().getTempNik());
        File file = new File(sb2);
        file.delete();
        try {
            try {
                fileWriter = new FileWriter(file);
            } catch (IOException e3) {
                e = e3;
                fileWriter = null;
            } catch (Throwable th2) {
                th = th2;
                fileWriter = null;
                try {
                    fileWriter.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
            try {
                try {
                    fileWriter.write(replaceAll);
                    fileWriter.close();
                } catch (Throwable th3) {
                    th = th3;
                    fileWriter.close();
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                fileWriter.close();
            }
        } catch (Throwable e6) {
            e6.printStackTrace();
        }
    }

    private String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String property = System.getProperty("line.separator");
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
                sb.append(property);
            } else {
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }
        }
    }
}
