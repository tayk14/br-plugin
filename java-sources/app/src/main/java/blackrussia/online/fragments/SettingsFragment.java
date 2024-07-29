package blackrussia.online.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.fragment.app.Fragment;
import blackrussia.online.App;
import blackrussia.online.Preferences;
import blackrussia.online.R;
import blackrussia.online.Settings;
import blackrussia.online.activities.LoaderActivity;
import blackrussia.online.activities.MainActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class SettingsFragment extends Fragment {
    private Handler handler = new Handler();
    public boolean isPlayTime = false;
    private TextView nikText;
    private ToggleButton notification;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_settings, container, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.changeNik);
        this.nikText = (TextView) inflate.findViewById(R.id.nikText);
        TextView textView = (TextView) inflate.findViewById(R.id.reinstallGame);
        TextView textView2 = (TextView) inflate.findViewById(R.id.resetSettings);
        ToggleButton toggleButton = (ToggleButton) inflate.findViewById(R.id.notification);
        this.notification = toggleButton;
        toggleButton.setChecked(Preferences.getBoolean(App.getInstance(), Preferences.NOTIFICATION, true));
        this.notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$-wWcmzzLvqw-YRGwpNM63uPCkm0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Preferences.putBoolean(App.getInstance(), Preferences.NOTIFICATION, z);
            }
        });
        setNick();
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$9nrHs8KZMnJAsNqXUjtivcXXNvs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.this.lambda$onCreateView$1$SettingsFragment(view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$1UdFNM_x1P5X20-oUXMmjb-Uud4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.this.lambda$onCreateView$2$SettingsFragment(view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$cNuo9RnQMshFaEn1zDM08Fi3Ycs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.this.lambda$onCreateView$3$SettingsFragment(view);
            }
        });
        ((TextView) inflate.findViewById(R.id.privacyPolicy)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$XsMEMN_EGZWh5QBo6-zG2SsFjdY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.this.lambda$onCreateView$4$SettingsFragment(view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.telegramButton)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$NYKaqiFofZxGG94eYOTtu9rdu0Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.this.lambda$onCreateView$6$SettingsFragment(view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.vkButton)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$l1xXzNMubwgNl0GJpSm29KtlhFY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.this.lambda$onCreateView$8$SettingsFragment(view);
            }
        });
        ((ImageView) inflate.findViewById(R.id.discordButton)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$dCBNrMmXmByg3jyTLmL7NwVFvUA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.this.lambda$onCreateView$10$SettingsFragment(view);
            }
        });
        return inflate;
    }

    public /* synthetic */ void lambda$onCreateView$1$SettingsFragment(View view1) {
        view1.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$1q3xHUFEy420VVCzMr3QjQ-YpWs
            @Override // java.lang.Runnable
            public final void run() {
                SettingsFragment.this.onClickChangeNick();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$onCreateView$2$SettingsFragment(View view1) {
        view1.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$mGJEbfjS0gUDZCDGWwpU8-8eIQI
            @Override // java.lang.Runnable
            public final void run() {
                SettingsFragment.this.onClickReinstallGame();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$onCreateView$3$SettingsFragment(View view1) {
        view1.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$zXNuPVy6coJUHaXYSPNi3H2yPiY
            @Override // java.lang.Runnable
            public final void run() {
                SettingsFragment.this.onClickResetSettings();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$onCreateView$4$SettingsFragment(View view1) {
        view1.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$K6yJKPi9wM8d-T-X7LVEAj6idAk
            @Override // java.lang.Runnable
            public final void run() {
                SettingsFragment.this.onClickPrivacyPolicy();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$onCreateView$6$SettingsFragment(View view1) {
        view1.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$176g9ozHh1jZyNwfAd-wamYOaDo
            @Override // java.lang.Runnable
            public final void run() {
                SettingsFragment.this.lambda$null$5$SettingsFragment();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$5$SettingsFragment() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Settings.URL_TELEGRAM)));
    }

    public /* synthetic */ void lambda$onCreateView$8$SettingsFragment(View view1) {
        view1.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$M7c9q2Iul5OszCgRvPmvPCGVOK8
            @Override // java.lang.Runnable
            public final void run() {
                SettingsFragment.this.lambda$null$7$SettingsFragment();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$7$SettingsFragment() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Settings.URL_VK)));
    }

    public /* synthetic */ void lambda$onCreateView$10$SettingsFragment(View view1) {
        view1.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$0WLDhHgxO732P-fZqRCYOJtgu30
            @Override // java.lang.Runnable
            public final void run() {
                SettingsFragment.this.lambda$null$9$SettingsFragment();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$9$SettingsFragment() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(Settings.URL_DISCORD)));
    }

    private void setNick() {
        if (App.isExternalStorageAvailable(getActivity())) {
            String absolutePath = getActivity().getExternalFilesDir(null).getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            String str = "";
            sb.append(absolutePath.replace("blackrussia.online/files", ""));
            sb.append(Settings.CLIENT_PACKAGE);
            sb.append("/files/SAMP/settings.ini");
            try {
                Matcher matcher = Pattern.compile("name = .*", 2).matcher(readUsingBufferedReader(sb.toString()));
                for (int i = 0; matcher.find(i); i = matcher.end()) {
                    str = matcher.group(0);
                }
                if (str == null || str.length() <= 0) {
                    return;
                }
                String substring = str.substring(str.indexOf("name = ") + 7);
                if (substring.length() > 0) {
                    this.nikText.setText(substring);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickPrivacyPolicy() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.link_privacy))));
    }

    private String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String property = System.getProperty("line.separator");
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            sb.append(readLine);
            sb.append(property);
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void writeUsingFileWriter(String data, String path, String nik) {
        File file = new File(path);
        if (!file.exists()) {
            App.getInstance().setTempNik(nik);
            return;
        }
        file.delete();
        FileWriter fileWriter = null;
        try {
            try {
                try {
                    FileWriter fileWriter2 = new FileWriter(file);
                    try {
                        fileWriter2.write(data);
                        fileWriter2.close();
                    } catch (IOException e) {
                        e = e;
                        fileWriter = fileWriter2;
                        e.printStackTrace();
                        fileWriter.close();
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = fileWriter2;
                        try {
                            fileWriter.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e3) {

                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        } catch (Throwable th2) {

        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickChangeNick() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.item_change_nik);
        dialog.setCancelable(true);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(-1, -2);
        final EditText editText = (EditText) dialog.findViewById(R.id.editText);
        ((TextView) dialog.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$HiOs03FxU1jxJre3jlisRXOd1XQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.this.lambda$onClickChangeNick$11$SettingsFragment(dialog, view);
            }
        });
        ((TextView) dialog.findViewById(R.id.save)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$uAQfjRC9ws6EdrDbTXioeNg1-YM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.this.lambda$onClickChangeNick$13$SettingsFragment(editText, dialog, view);
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$JZoFI_lb3d85VKhJLV96lL1v4h4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ((InputMethodManager) App.getInstance().getSystemService("input_method")).toggleSoftInput(1, 0);
            }
        });
        dialog.show();
        editText.requestFocus();
        ((InputMethodManager) App.getInstance().getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public /* synthetic */ void lambda$onClickChangeNick$11$SettingsFragment(final Dialog dialog, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        Handler handler = this.handler;
        dialog.getClass();
        handler.postDelayed(new $$Lambda$G2sZv_QBDDjB3nPadjUdMmz4hc(dialog), 200L);
    }

    public /* synthetic */ void lambda$onClickChangeNick$13$SettingsFragment(final EditText editText, final Dialog dialog, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        final String obj = editText.getText().toString();
        if (obj.isEmpty()) {
            Toast.makeText(App.getInstance(), App.getInstance().getResources().getString(R.string.enterNik), 1).show();
            return;
        }
        if (!obj.contains("_")) {
            Toast.makeText(App.getInstance(), App.getInstance().getResources().getString(R.string.mustContains_), 1).show();
        } else if (obj.length() < 4) {
            Toast.makeText(App.getInstance(), App.getInstance().getResources().getString(R.string.minLengthNik), 1).show();
        } else {
            this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$VRUr35qUfyWJmULJAYLteyjIysc
                @Override // java.lang.Runnable
                public final void run() {
                    SettingsFragment.this.lambda$null$12$SettingsFragment(obj, dialog);
                }
            }, 200L);
        }
    }

    public /* synthetic */ void lambda$null$12$SettingsFragment(final String string, final Dialog dialog) {
        this.nikText.setText(string);
        if (!this.isPlayTime) {
            Toast.makeText(App.getInstance(), App.getInstance().getResources().getString(R.string.saved), 1).show();
        }
        if (App.isExternalStorageAvailable(getActivity())) {
            String absolutePath = getActivity().getExternalFilesDir(null).getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            String str = "";
            sb.append(absolutePath.replace("blackrussia.online/files", ""));
            sb.append(Settings.CLIENT_PACKAGE);
            sb.append("/files/SAMP/settings.ini");
            String sb2 = sb.toString();
            try {
                str = readUsingBufferedReader(sb2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            writeUsingFileWriter(str.replaceAll("name =.*", "name = " + string), sb2, string);
            if (this.isPlayTime) {
                ((MainActivity) getContext()).onClickPlay();
                this.isPlayTime = false;
            }
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickReinstallGame() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.item_dialog_settings);
        dialog.setCancelable(true);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(-1, -2);
        ((TextView) dialog.findViewById(R.id.message)).setText(App.getInstance().getResources().getString(R.string.reinstallGameQ));
        ((TextView) dialog.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$LAFJ5R5izMB9JP6DkL_iEPCW8Qs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.this.lambda$onClickReinstallGame$15$SettingsFragment(dialog, view);
            }
        });
        ((TextView) dialog.findViewById(R.id.ok)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$Q5XSU37c2SzCxWTKvU4PheF-coQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.this.lambda$onClickReinstallGame$17$SettingsFragment(dialog, view);
            }
        });
        dialog.show();
    }

    public /* synthetic */ void lambda$onClickReinstallGame$15$SettingsFragment(final Dialog dialog, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        Handler handler = this.handler;
        dialog.getClass();
        handler.postDelayed(new $$Lambda$G2sZv_QBDDjB3nPadjUdMmz4hc(dialog), 200L);
    }

    public /* synthetic */ void lambda$onClickReinstallGame$17$SettingsFragment(final Dialog dialog, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$7xT_Kdhr7alRPXcUQSNk6_TxABU
            @Override // java.lang.Runnable
            public final void run() {
                SettingsFragment.this.lambda$null$16$SettingsFragment(dialog);
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$16$SettingsFragment(final Dialog dialog) {
        if (App.isExternalStorageAvailable(getActivity())) {
            for (File file : new File(getActivity().getExternalFilesDir(null).getAbsolutePath()).listFiles()) {
                if (!file.getName().equals(".com.google.firebase") && !file.getName().equals("crashtool")) {
                    deleteFile(file);
                }
            }
            resetSetting();
            resetUserData();
            App.getInstance().getDataFiles().clear();
            Preferences.putFilesData(App.getInstance(), Preferences.FILES, App.getInstance().getDataFiles());
            dialog.dismiss();
            Toast.makeText(App.getInstance(), App.getInstance().getResources().getString(R.string.after_reinstall_message), 1).show();
        }
    }

    private void deleteFile(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                deleteFile(file2);
            }
        }
        file.delete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickResetSettings() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.item_dialog_settings);
        dialog.setCancelable(true);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().setLayout(-1, -2);
        ((TextView) dialog.findViewById(R.id.message)).setText(App.getInstance().getResources().getString(R.string.resetSettingsQ));
        ((TextView) dialog.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$-B1qqeehmOCgIksfh2Bh4JKfYn8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.this.lambda$onClickResetSettings$18$SettingsFragment(dialog, view);
            }
        });
        ((TextView) dialog.findViewById(R.id.ok)).setOnClickListener(new View.OnClickListener() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$YRTf04AwTt2j5gOQJ6hn8y2sL6k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.this.lambda$onClickResetSettings$20$SettingsFragment(dialog, view);
            }
        });
        dialog.show();
    }

    public /* synthetic */ void lambda$onClickResetSettings$18$SettingsFragment(final Dialog dialog, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        Handler handler = this.handler;
        dialog.getClass();
        handler.postDelayed(new $$Lambda$G2sZv_QBDDjB3nPadjUdMmz4hc(dialog), 200L);
    }

    public /* synthetic */ void lambda$onClickResetSettings$20$SettingsFragment(final Dialog dialog, View view) {
        view.startAnimation(AnimationUtils.loadAnimation(App.getInstance(), R.anim.button_click));
        this.handler.postDelayed(new Runnable() { // from class: blackrussia.online.fragments.-$$Lambda$SettingsFragment$C5GYqb5yoPd6nnmbDXD70BgrQCI
            @Override // java.lang.Runnable
            public final void run() {
                SettingsFragment.this.lambda$null$19$SettingsFragment(dialog);
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$null$19$SettingsFragment(final Dialog dialog) {
        resetSetting();
        dialog.dismiss();
    }

    private void resetSetting() {
        this.nikText.setText(getString(R.string.nik));
        if (App.isExternalStorageAvailable(getActivity())) {
            String absolutePath = getActivity().getExternalFilesDir(null).getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            String str = "";
            sb.append(absolutePath.replace("blackrussia.online/files", ""));
            sb.append(Settings.CLIENT_PACKAGE);
            sb.append("/files/SAMP/settings.ini");
            String sb2 = sb.toString();
            try {
                str = readUsingBufferedReader(sb2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            writeUsingFileWriter(str.replaceAll("name =.*", "name = "), sb2, null);
            this.notification.setChecked(true);
            Preferences.putBoolean(App.getInstance(), Preferences.NOTIFICATION, true);
        }
    }

    public void startSplashActivity() {
        startActivity(new Intent(App.getInstance(), (Class<?>) LoaderActivity.class));
        getActivity().finish();
    }

    private void resetUserData() {
        Preferences.putString(App.getInstance(), Preferences.USER_NAME, "");
        Preferences.putString(App.getInstance(), Preferences.USER_PASSWORD, "");
        Preferences.putString(App.getInstance(), Preferences.USER_SERVER, "");
        Preferences.putString(App.getInstance(), Preferences.USER_COLOR, "");
        Preferences.putString(App.getInstance(), Preferences.USER_BALANCE, "");
    }
}
