package com.rockstargames.gtacr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BrDialogGraphicsSettings implements ISAMPGUI {
    private GUIManager mManager = null;
    private PopupWindow mWindow = null;
    private NvEventQueueActivity mActivity = null;
    private View mView = null;

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public int getGuiId() {
        return 19;
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void onPacketIncoming(JSONObject json) {
    }

    public static ISAMPGUI newInstance() {
        return new BrDialogGraphicsSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextAsSettings(TextView text, int setting) {
        if (setting == 0) {
            text.setText("Стандартная");
            return;
        }
        if (setting == 1) {
            text.setText("Низкая");
        } else if (setting == 2) {
            text.setText("Средняя");
        } else {
            if (setting != 3) {
                return;
            }
            text.setText("Высокая");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextAsDrawSettings(TextView text, int setting) {
        if (setting <= 25) {
            text.setText("Низкая");
            return;
        }
        if (setting <= 50) {
            text.setText("Средняя");
        } else if (setting <= 75) {
            text.setText("Высокая");
        } else {
            text.setText("Оч. Высокая");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextAsSettingsDisabled(TextView text, int setting) {
        if (setting == 0) {
            text.setText("Отключено");
            return;
        }
        if (setting == 1) {
            text.setText("Низкие");
        } else if (setting == 2) {
            text.setText("Средние");
        } else {
            if (setting != 3) {
                return;
            }
            text.setText("Высокие");
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void show(JSONObject json, GUIManager manager, NvEventQueueActivity activity) {
        this.mManager = manager;
        this.mActivity = activity;
        int optInt = json.optInt("carrefl");
        int optInt2 = json.optInt("water");
        int optInt3 = json.optInt("sky");
        int optInt4 = json.optInt("aa");
        int optInt5 = json.optInt("lowerdd");
        int optInt6 = json.optInt("lowercars");
        int optInt7 = json.optInt("drawdist");
        if (this.mWindow == null) {
            this.mView = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.br_graphic_settings, (ViewGroup) null, false);
            PopupWindow popupWindow = new PopupWindow(this.mView, -2, -2, true);
            this.mWindow = popupWindow;
            popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
            this.mWindow.setSoftInputMode(16);
        }
        final TextView textView = (TextView) this.mView.findViewById(R.id.water_text);
        final TextView textView2 = (TextView) this.mView.findViewById(R.id.carrefl_text);
        final TextView textView3 = (TextView) this.mView.findViewById(R.id.distance_text);
        final SeekBar seekBar = (SeekBar) this.mView.findViewById(R.id.water_progress);
        final SeekBar seekBar2 = (SeekBar) this.mView.findViewById(R.id.carrefl_progress);
        final SeekBar seekBar3 = (SeekBar) this.mView.findViewById(R.id.distance_progress);
        seekBar2.setProgress(optInt);
        seekBar.setProgress(optInt2);
        seekBar3.setProgress(optInt7);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rockstargames.gtacr.BrDialogGraphicsSettings.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar4) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar4) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar4, int progress, boolean fromUser) {
                BrDialogGraphicsSettings.this.setTextAsSettings(textView, progress);
            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rockstargames.gtacr.BrDialogGraphicsSettings.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar4) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar4) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar4, int progress, boolean fromUser) {
                BrDialogGraphicsSettings.this.setTextAsSettingsDisabled(textView2, progress);
            }
        });
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rockstargames.gtacr.BrDialogGraphicsSettings.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar4) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar4) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar4, int progress, boolean fromUser) {
                BrDialogGraphicsSettings.this.setTextAsDrawSettings(textView3, progress);
            }
        });
        setTextAsSettings(textView, optInt2);
        setTextAsSettingsDisabled(textView2, optInt);
        setTextAsDrawSettings(textView3, optInt7);
        final Switch r7 = (Switch) this.mView.findViewById(R.id.switch_sky);
        r7.setChecked(optInt3 == 1);
        final Switch r12 = (Switch) this.mView.findViewById(R.id.switch_aa);
        r12.setChecked(optInt4 == 1);
        final Switch r13 = (Switch) this.mView.findViewById(R.id.switch_lower_dd);
        r13.setChecked(optInt5 == 1);
        final Switch r15 = (Switch) this.mView.findViewById(R.id.switch_lower_cars);
        r15.setChecked(optInt6 == 1);
        this.mView.findViewById(R.id.graphic_apply).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogGraphicsSettings.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("w", seekBar.getProgress());
                    jSONObject.put(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, seekBar2.getProgress());
                    jSONObject.put("d", seekBar3.getProgress());
                    int i = 1;
                    jSONObject.put("s", r7.isChecked() ? 1 : 0);
                    jSONObject.put("a", r12.isChecked() ? 1 : 0);
                    jSONObject.put("l", r13.isChecked() ? 1 : 0);
                    if (!r15.isChecked()) {
                        i = 0;
                    }
                    jSONObject.put("z", i);
                    BrDialogGraphicsSettings.this.mManager.sendJsonData(19, jSONObject);
                } catch (Exception unused) {
                }
                BrDialogGraphicsSettings.this.mManager.closeGUI(null, 19);
            }
        });
        this.mView.findViewById(R.id.graphic_close).setOnClickListener(new View.OnClickListener() { // from class: com.rockstargames.gtacr.BrDialogGraphicsSettings.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                BrDialogGraphicsSettings.this.mManager.closeGUI(null, 19);
            }
        });
        this.mWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public void close(JSONObject json) {
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // com.rockstargames.gtacr.ISAMPGUI
    public boolean isShowingGui() {
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow == null) {
            return false;
        }
        return popupWindow.isShowing();
    }
}
