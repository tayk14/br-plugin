package com.rockstargames.gtacr.gui;

import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.Preferences;
import blackrussia.online.R;
import blackrussia.online.Settings;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.DonateDepositCoinsAdapter;
import com.rockstargames.gtacr.common.UILayout;
import org.json.JSONObject;

public class UILayoutDonateDepositCoins extends UILayout {
    private DonateDepositCoinsAdapter mAdapter;
    private RecyclerView mRV;
    private GUIDonate mRoot;
    private View mViewRoot = null;
    private boolean mDeactivatedValue = true;
    private boolean mDeactivatedEmail = true;

    @Override
    public void onLayoutClose() {
    }

    public UILayoutDonateDepositCoins(GUIDonate root) {
        this.mRoot = null;
        this.mRoot = root;
    }

    public GUIDonate getDonate() {
        return this.mRoot;
    }

    @Override
    public View getView() {
        return this.mViewRoot;
    }

    public void setCoins(int coins) {
        try {
            TextView textView = (TextView) this.mViewRoot.findViewById(R.id.sales);
            textView.setVisibility(0);
            textView.setText("С учётом акции: " + GUIManager.getPriceWithSpaces(coins) + GUIManager.getBCText());
        } catch (Exception unused) {
        }
    }

    public void setInputCoins(int coins) {
        try {
            ((EditText) this.mViewRoot.findViewById(R.id.value)).setText(String.valueOf(coins));
        } catch (Exception unused) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.donate_coins_deposit, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        final EditText editText = (EditText) inflate.findViewById(R.id.value);
        final EditText editText2 = (EditText) this.mViewRoot.findViewById(R.id.email);
        final Button button = (Button) this.mViewRoot.findViewById(R.id.button);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    UILayoutDonateDepositCoins.this.mDeactivatedValue = false;
                    if (!UILayoutDonateDepositCoins.this.mDeactivatedEmail && !UILayoutDonateDepositCoins.this.mDeactivatedValue) {
                        button.setBackground(ResourcesCompat.getDrawable(UILayoutDonateDepositCoins.this.getContext().getResources(), R.drawable.donate_tile_button, null));
                    }
                    Button button2 = button;
                    button2.setText(GUIManager.getPriceWithSpaces(Integer.valueOf(editText.getEditableText().toString()).intValue()) + " ₽");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("t", 5);
                    jSONObject.put("s", Integer.valueOf(editText.getEditableText().toString()));
                    UILayoutDonateDepositCoins.this.getDonate().getGUIManager().sendJsonData(22, jSONObject);
                } catch (Exception unused) {
                    UILayoutDonateDepositCoins.this.mDeactivatedValue = true;
                    button.setBackground(ResourcesCompat.getDrawable(UILayoutDonateDepositCoins.this.getContext().getResources(), R.drawable.donate_tile_button_greyp, null));
                    Button button3 = button;
                    button3.setText(GUIManager.getPriceWithSpaces(0) + " ₽");
                }
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (editText2.getEditableText().toString().length() > 0) {
                        UILayoutDonateDepositCoins.this.mDeactivatedEmail = false;
                        Preferences.putString(App.getInstance(), Preferences.EMAIL, editText2.getText().toString());
                        if (UILayoutDonateDepositCoins.this.mDeactivatedEmail || UILayoutDonateDepositCoins.this.mDeactivatedValue) {
                            return;
                        }
                        button.setBackground(ResourcesCompat.getDrawable(UILayoutDonateDepositCoins.this.getContext().getResources(), R.drawable.donate_tile_button, null));
                        return;
                    }
                    throw new Throwable();
                } catch (Throwable unused) {
                    UILayoutDonateDepositCoins.this.mDeactivatedEmail = true;
                    button.setBackground(ResourcesCompat.getDrawable(UILayoutDonateDepositCoins.this.getContext().getResources(), R.drawable.donate_tile_button_greyp, null));
                }
            }
        });
        this.mRV = (RecyclerView) this.mViewRoot.findViewById(R.id.rv);
        this.mAdapter = new DonateDepositCoinsAdapter(this);
        this.mRV.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mRV.setAdapter(this.mAdapter);
        if (!this.mRoot.getEmail().equals("0")) {
            editText2.setText(this.mRoot.getEmail());
        } else {
            String string = Preferences.getString(App.getInstance(), Preferences.EMAIL);
            if (string != null) {
                editText2.setText(string);
            }
        }
        ((TextView) this.mViewRoot.findViewById(R.id.sales)).setVisibility(8);
        NvEventQueueActivity.fixEditTextForAndroid10Xiaomi(editText);
        NvEventQueueActivity.fixEditTextForAndroid10Xiaomi(editText2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UILayoutDonateDepositCoins.this.mDeactivatedEmail || UILayoutDonateDepositCoins.this.mDeactivatedValue) {
                    return;
                }
                try {
                    new CustomTabsIntent.Builder().build().launchUrl(UILayoutDonateDepositCoins.this.mRoot.getNvEvent(), Uri.parse(Settings.URL_DONATE + "&server=server" + UILayoutDonateDepositCoins.this.mRoot.getServer() + "&account=" + UILayoutDonateDepositCoins.this.mRoot.getNick() + "&mail=" + editText2.getText().toString().replace("@", "%40") + "&summa=" + ((Object) editText.getText())));
                } catch (Exception e) {
                    FirebaseCrashlytics.getInstance().recordException(e);
                    Toast.makeText(App.getInstance(), UILayoutDonateDepositCoins.this.mRoot.getNvEvent().getString(R.string.error_message_about_browser), 1).show();
                }
            }
        });
        return this.mViewRoot;
    }

    @Override
    public void onLayoutShown() {
        this.mViewRoot.findViewById(R.id.x2).setVisibility(this.mRoot.getDoubleDonate() == 1 ? 0 : 8);
        this.mViewRoot.findViewById(R.id.hot).setVisibility(this.mRoot.getDoubleDonate() != 0 ? 8 : 0);
    }
}
