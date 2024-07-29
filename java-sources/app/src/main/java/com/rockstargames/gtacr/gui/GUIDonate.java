package com.rockstargames.gtacr.gui;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.network.DonateItem;
import com.appsflyer.AppsFlyerLib;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.BlackPass.BrBlackPass;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.GameRender;
import com.rockstargames.gtacr.ISAMPGUI;
import com.rockstargames.gtacr.adapters.DonateFooterAdapter;
import com.rockstargames.gtacr.adapters.DonateHeaderAdapter;
import com.rockstargames.gtacr.adapters.DonateTileAdapter;
import com.rockstargames.gtacr.common.DialogNoNavBar;
import com.rockstargames.gtacr.common.GUIPopupWindow;
import com.rockstargames.gtacr.common.UIContainer;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import com.rockstargames.gtacr.gui.inventory.PutKeys;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

public class GUIDonate implements ISAMPGUI, DonateHeaderAdapter.LayoutChangedListener, DonateFooterAdapter.PageChangedListener {
    public static final int ACCESORIES = 11;
    public static final int CARS = 1;
    public static final int DETAIL_CAR = 7;
    public static final int DETAIL_VIP = 9;
    public static final int LAYOUT_DONATE_BLACKPASS = 2;
    public static final int LAYOUT_DONATE_CASE = 3;
    public static final int LAYOUT_DONATE_DEPOSIT_COINS = 4;
    public static final int LAYOUT_DONATE_PREVIEW_CAR = 5;
    public static final int LAYOUT_DONATE_PREVIEW_PACK = 6;
    public static final int LAYOUT_DONATE_SERVICES = 1;
    public static final int LAYOUT_DONATE_TILE = 0;
    public static final int MENU_DETAIL_PACK = 8;
    public static final int MONEY = 6;
    public static final int PACKS = 3;
    public static final int SALES = 0;
    public static final int SERVICES = 5;
    public static final int SKINS = 2;
    public static final int VIP = 4;
    private UIContainer container;
    private DisplayMetrics displayMetrics;
    private BrBlackPass mBlackPass;
    private int mDoubleDonate;
    private String mEmail;
    private DonateFooterAdapter mFooterAdapter;
    private RecyclerView mFooterRV;
    private DonateHeaderAdapter mHeaderAdapter;
    private RecyclerView mHeaderRV;
    private boolean mIsCloseLimit;
    private JSONObject mJson;
    private String mNick;
    private ProgressDialog mProgressDialog;
    private int mServer;
    private Activity mContext = null;
    private GUIManager mGUIManager = null;
    private PopupWindow mWindow = null;
    private View mViewRoot = null;
    private int mSelectedPage = 0;
    private Handler mHandler = null;
    private Runnable mRunnable = null;
    private int[] mLimits = null;
    private final int mExchangeCoef = 1000;
    private Dialog dialog = null;
    private Stack<DonateItem> mSelectedItems = null;
    private boolean mDonateDontWork = false;
    private DonateItem mPurchasedItem = null;
    private Runnable mTimeoutRunnable = null;

    @Override
    public int getGuiId() {
        return 22;
    }

    public static ISAMPGUI newInstance() {
        return new GUIDonate();
    }

    public String getEmail() {
        return this.mEmail;
    }

    public String getNick() {
        return this.mNick;
    }

    public int getServer() {
        return this.mServer;
    }

    public int[] getLimits() {
        return this.mLimits;
    }

    public int getLimitItemOffset(int id) {
        if (this.mLimits == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int[] iArr = this.mLimits;
            if (i >= iArr.length) {
                return -1;
            }
            if (iArr[i] == id) {
                return i;
            }
            i += 2;
        }
    }

    public void BuyCoinsDialog(final int price) {
        showResultDialog(0, "Недостаточно средств.", "Пополните счет прямо сейчас!", "ОШИБКА", "ПОПОЛНИТЬ", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GUIDonate.this.closeDialog();
                GUIDonate.this.container.setCurrentLayout(4);
                GUIDonate.this.hideFooter();
                ((UILayoutDonateDepositCoins) GUIDonate.this.container.getLayout(4)).setInputCoins(price);
            }
        });
    }

    @Override
    public void onPacketIncoming(JSONObject json) {
        int i;
        int i2;
        JSONArray jSONArray;
        int i3;
        JSONArray jSONArray2;
        int optInt = json.optInt("t");
        if (optInt == -1) {
            this.mBlackPass.onJsonDataIncoming(json);
            return;
        }
        String str = "TEST SERVER";
        int i4 = 0;
        if (optInt == 0) {
            int optInt2 = json.optInt("y");
            final int optInt3 = json.optInt(TuningConstants.KEY_GET_DETAILS_LIST_WITH_COST_AND_STATUS);
            DonateItem itemFromInternalId = getItemFromInternalId(json.optInt("g"));
            if (itemFromInternalId != null) {
                itemFromInternalId.setSalePercent(0);
                itemFromInternalId.setSaleTime(0);
                ((UILayoutDonateTile) this.container.getLayout(0)).updateItem(itemFromInternalId);
            }
            if (optInt2 == 1) {
                closeProgress();
                closeDialog();
                String priceWithSpaces = GUIManager.getPriceWithSpaces(json.optInt(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL));
                ((TextView) this.mViewRoot.findViewById(R.id.headerCoins)).setText(GUIManager.getPriceWithSpaces(json.optInt("s")));
                ((TextView) this.mViewRoot.findViewById(R.id.headerRubles)).setText(priceWithSpaces);
                showResultDialog(1, json.optString("m"), json.optString("n"), "ВЫПОЛНЕНО", "ВЕРНУТЬСЯ", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        GUIDonate.this.closeDialog();
                    }
                });
                if (this.mPurchasedItem != null) {
                    if (getNvEvent().getCurrServer() < App.getInstance().getServerList().size() && !App.getInstance().getServerList().get(getNvEvent().getCurrServer()).getFirstName().contains("test")) {
                        str = App.getInstance().getServerList().get(getNvEvent().getCurrServer()).getFirstName();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(FirebaseAnalytics.Param.ITEM_ID, this.mPurchasedItem.getInternalId());
                    hashMap.put(FirebaseAnalytics.Param.ITEM_NAME, this.mPurchasedItem.getHeader());
                    hashMap.put("server", str);
                    hashMap.put("user_nickname", getNvEvent().getNick());
                    i = 1;
                    if (json.optInt(TuningConstants.KEY_GET_ALL_COLLAPSE, 0) == 1) {
                        AppsFlyerLib.getInstance().logEvent(getNvEvent(), "1Pokupka", hashMap);
                    } else {
                        AppsFlyerLib.getInstance().logEvent(getNvEvent(), "RePokupka", hashMap);
                    }
                } else {
                    i = 1;
                }
                i2 = 0;
            } else {
                i = 1;
                i2 = 0;
                if (optInt3 > 0) {
                    closeProgress();
                    closeDialog();
                    if (itemFromInternalId.getRubles() != null) {
                        showResultDialog(0, json.optString("m"), json.optString("n"), "ОШИБКА", "Вернуться", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                GUIDonate.this.closeDialog();
                            }
                        });
                    } else {
                        showResultDialog(0, json.optString("m"), json.optString("n"), "ОШИБКА", "ПОПОЛНИТЬ", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                GUIDonate.this.closeDialog();
                                GUIDonate.this.container.setCurrentLayout(4);
                                GUIDonate.this.hideFooter();
                                ((UILayoutDonateDepositCoins) GUIDonate.this.container.getLayout(4)).setInputCoins(optInt3);
                            }
                        });
                    }
                } else {
                    closeProgress();
                    closeDialog();
                    showResultDialog(0, json.optString("m"), json.optString("n"), "ОШИБКА", "ВЕРНУТЬСЯ", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            GUIDonate.this.closeDialog();
                        }
                    });
                }
            }
            Runnable runnable = this.mTimeoutRunnable;
            if (runnable != null) {
                this.mViewRoot.removeCallbacks(runnable);
                this.mTimeoutRunnable = null;
            }
            int optInt4 = json.optInt(GetKeys.GET_PLAYERS_ID);
            if (this.mLimits == null || getLimitItemOffset(optInt4) < 0) {
                return;
            }
            int limitItemOffset = getLimitItemOffset(optInt4);
            int[] iArr = this.mLimits;
            int i5 = limitItemOffset + i;
            int i6 = iArr[i5];
            if (i6 > 0) {
                iArr[i5] = i6 - i;
                DonateItem itemFromInternalId2 = getItemFromInternalId(optInt4);
                if (itemFromInternalId2 != null) {
                    UILayoutDonateTile uILayoutDonateTile = (UILayoutDonateTile) this.container.getLayout(i2);
                    uILayoutDonateTile.updateEndedTiles();
                    uILayoutDonateTile.updateItem(itemFromInternalId2);
                }
            }
        } else if (optInt == 2) {
            UILayoutDonateTile uILayoutDonateTile2 = (UILayoutDonateTile) this.container.getLayout(0);
            uILayoutDonateTile2.updateSurprise(json.optInt(TuningConstants.KEY_GET_ID_DETAIL));
            try {
                jSONArray = json.getJSONArray("s");
            } catch (Exception e) {
                FirebaseCrashlytics.getInstance().log(json.toString());
                FirebaseCrashlytics.getInstance().recordException(e);
                jSONArray = null;
            }
            if (jSONArray != null) {
                while (i4 < jSONArray.length()) {
                    DonateItem itemFromInternalId3 = getItemFromInternalId(jSONArray.optInt(i4));
                    if (itemFromInternalId3 != null) {
                        itemFromInternalId3.setSaleTime(jSONArray.optInt(i4 + 1));
                        uILayoutDonateTile2.updateItem(itemFromInternalId3);
                    }
                    i4 += 2;
                }
            }
        } else if (optInt == 3) {
            String priceWithSpaces2 = GUIManager.getPriceWithSpaces(json.optInt("s"));
            String priceWithSpaces3 = GUIManager.getPriceWithSpaces(json.optInt(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL));
            try {
                i3 = new DecimalFormat("#,###,###", new DecimalFormatSymbols(Locale.getDefault())).parse(((TextView) this.mViewRoot.findViewById(R.id.headerCoins)).getText().toString()).intValue();
                System.out.println(i3);
            } catch (Exception unused) {
                i3 = 99999;
            }
            if (json.optInt("d") > 0) {
                if (getNvEvent().getCurrServer() < App.getInstance().getServerList().size() && !App.getInstance().getServerList().get(getNvEvent().getCurrServer()).getFirstName().contains("test")) {
                    str = App.getInstance().getServerList().get(getNvEvent().getCurrServer()).getFirstName();
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("server", str);
                hashMap2.put("user_nickname", getNvEvent().getNick());
                hashMap2.put("cash", Integer.valueOf(json.optInt(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL) - i3));
                if (json.optInt("f") != 0) {
                    AppsFlyerLib.getInstance().logEvent(getNvEvent(), "1Donate", hashMap2);
                } else {
                    AppsFlyerLib.getInstance().logEvent(getNvEvent(), "ReDonate", hashMap2);
                }
            }
            ((TextView) this.mViewRoot.findViewById(R.id.headerCoins)).setText(priceWithSpaces3);
            ((TextView) this.mViewRoot.findViewById(R.id.headerRubles)).setText(priceWithSpaces2);
        } else {
            if (optInt == 5) {
                ((UILayoutDonateDepositCoins) this.container.getLayout(4)).setCoins(json.optInt("s"));
            } else if (optInt != 6) {
                if (optInt != 7) {
                    if (optInt != 8) {
                        return;
                    }
                    UILayoutDonateTile uILayoutDonateTile3 = (UILayoutDonateTile) this.container.getLayout(0);
                    try {
                        jSONArray2 = json.getJSONArray("s");
                    } catch (Exception unused2) {
                        jSONArray2 = null;
                    }
                    if (jSONArray2 != null) {
                        while (i4 < jSONArray2.length()) {
                            DonateItem itemFromInternalId4 = getItemFromInternalId(jSONArray2.optInt(i4));
                            if (itemFromInternalId4 != null) {
                                itemFromInternalId4.setSalePercent(jSONArray2.optInt(i4 + 1));
                                itemFromInternalId4.setSaleTime(jSONArray2.optInt(i4 + 2));
                                uILayoutDonateTile3.updateItem(itemFromInternalId4);
                            }
                            i4 += 2;
                        }
                        return;
                    }
                    return;
                }
                JSONArray optJSONArray = json.optJSONArray("b");
                int length = optJSONArray.length();
                int[] iArr2 = new int[length];
                for (int i7 = 0; i7 < optJSONArray.length(); i7++) {
                    iArr2[i7] = optJSONArray.optInt(i7);
                }
                if (this.mLimits == null) {
                    this.mLimits = iArr2;
                } else {
                    for (int i8 = 0; i8 < length; i8 += 2) {
                        if (getLimitItemOffset(iArr2[i8]) >= 0) {
                            this.mLimits[getLimitItemOffset(iArr2[i8]) + 1] = iArr2[i8 + 1];
                        }
                    }
                }
                UILayoutDonateTile uILayoutDonateTile4 = (UILayoutDonateTile) this.container.getLayout(0);
                uILayoutDonateTile4.updateEndedTiles();
                uILayoutDonateTile4.updateAll();
                return;
            }
            int optInt5 = json.optInt(GetKeys.GET_PLAYERS_ID);
            if (this.mLimits == null || getLimitItemOffset(optInt5) < 0) {
                return;
            }
            int limitItemOffset2 = getLimitItemOffset(optInt5);
            int[] iArr3 = this.mLimits;
            int i9 = limitItemOffset2 + 1;
            if (iArr3[i9] > 0) {
                iArr3[i9] = 0;
                DonateItem itemFromInternalId5 = getItemFromInternalId(optInt5);
                if (itemFromInternalId5 != null) {
                    UILayoutDonateTile uILayoutDonateTile5 = (UILayoutDonateTile) this.container.getLayout(0);
                    uILayoutDonateTile5.updateEndedTiles();
                    uILayoutDonateTile5.updateItem(itemFromInternalId5);
                }
            }
        }
    }

    public void setCurrentPage(int newpage) {
        this.container.setCurrentLayout(0);
        if (newpage < 5) {
            this.mFooterAdapter.setSelectedPage(newpage);
        } else {
            onPageChanged(newpage);
        }
    }

    public int getCurrentPage() {
        return this.mSelectedPage;
    }

    private void prepareFooter() {
        this.mFooterRV = (RecyclerView) this.mViewRoot.findViewById(R.id.footerRV);
        DonateFooterAdapter donateFooterAdapter = new DonateFooterAdapter(this, this);
        this.mFooterAdapter = donateFooterAdapter;
        this.mFooterRV.setAdapter(donateFooterAdapter);
        this.mFooterRV.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false) {
            @Override
            public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                lp.width = getWidth() / GUIDonate.this.mFooterAdapter.getItemCount();
                return super.checkLayoutParams(lp);
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            this.mFooterRV.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(final View view, final Outline outline) {
                    float dpToPx = NvEventQueueActivity.dpToPx(7.0f, GUIDonate.this.mContext);
                    outline.setRoundRect(0, 0, view.getWidth(), (int) (view.getHeight() + dpToPx), dpToPx);
                }
            });
            this.mFooterRV.setClipToOutline(true);
        }
    }

    public JSONObject getJson() {
        return this.mJson;
    }

    public void showProgress() {
        ProgressDialog progressDialog = new ProgressDialog(this.mContext, R.style.MyTheme);
        this.mProgressDialog = progressDialog;
        progressDialog.setProgressStyle(1);
        this.mProgressDialog.setIndeterminateDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.progressbar_custom));
        this.mProgressDialog.setCancelable(false);
        this.mProgressDialog.setProgressStyle(16973854);
        this.mProgressDialog.show();
    }

    public void closeProgress() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            try {
                progressDialog.dismiss();
            } catch (Exception unused) {
            }
            this.mProgressDialog = null;
        }
    }

    public static DonateItem getItemFromInternalId(int id) {
        ArrayList<DonateItem> donateItems = App.getInstance().getDonateItems();
        for (int i = 0; i < donateItems.size(); i++) {
            DonateItem donateItem = donateItems.get(i);
            if (donateItem.getInternalId().intValue() == id) {
                return donateItem;
            }
        }
        return null;
    }

    public NvEventQueueActivity getNvEvent() {
        return (NvEventQueueActivity) this.mContext;
    }

    public PopupWindow getWindow() {
        return this.mWindow;
    }

    public GUIManager getGUIManager() {
        return this.mGUIManager;
    }

    public static int getItemPrice(DonateItem item) {
        if (item.getSalePercent() != 0) {
            return (int) (item.getBasePrice().intValue() * (1.0f - (item.getSalePercent() / 100.0f)));
        }
        return item.getBasePrice().intValue();
    }

    public void prepareItemTile(final DonateTileAdapter.ViewHolder holder, final DonateItem item, int position) {
        int i;
        int i2;
        int i3;
        holder.limitLayout.setVisibility(8);
        holder.button.setAlpha(1.0f);
        if (item.isNew() == null || item.isNew().intValue() == 0) {
            holder.newBadge.setVisibility(8);
        } else if (item.isNew().intValue() == 1) {
            holder.newBadge.setVisibility(0);
            holder.newBadge.setText("NEW");
        } else if (item.isNew().intValue() == 2) {
            holder.newBadge.setText("EVENT");
        }
        if (item.getUpTag() == 100) {
            holder.layoutDefault.setVisibility(8);
            holder.layoutSuprise.setVisibility(0);
            holder.badgeText.setVisibility(8);
            holder.badgeTime.setVisibility(8);
            holder.badgePercent.setVisibility(8);
            if (item.getSaleTime() == 0) {
                holder.donateSupriseTime.setText("");
                ((View) holder.donateSupriseTime.getParent()).findViewById(R.id.surpriseStatus).setVisibility(4);
                holder.button.setVisibility(0);
                holder.button.setText("Получить");
                holder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (v.getAlpha() < 1.0f) {
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("t", 2);
                            GUIDonate.this.mGUIManager.sendJsonData(22, jSONObject);
                        } catch (Exception unused) {
                        }
                    }
                });
                return;
            }
            int saleTime = item.getSaleTime() / 3600;
            ((View) holder.donateSupriseTime.getParent()).findViewById(R.id.surpriseStatus).setVisibility(0);
            TextView textView = holder.donateSupriseTime;
            textView.setText(String.format("%02d", Integer.valueOf(saleTime)) + " ч. " + String.format("%02d", Integer.valueOf((item.getSaleTime() - (saleTime * 3600)) / 60)) + " мин.");
            holder.button.setVisibility(8);
            return;
        }
        holder.layoutDefault.setVisibility(0);
        if (holder.button.getVisibility() == 8) {
            holder.button.setVisibility(0);
        }
        holder.layoutSuprise.setVisibility(8);
        if (item.getUpTag() == 200) {
            holder.header.setText("Другая сумма");
            holder.button.setText("Приобрести");
            holder.price.setText("");
            holder.additionaHeader.setVisibility(8);
            holder.subHeader.setText("На ваш выбор");
            holder.badgeText.setVisibility(8);
            holder.badgeTime.setVisibility(8);
            holder.badgePercent.setVisibility(8);
            holder.newBadge.setVisibility(8);
            holder.imageView.setImageDrawable(getDrawableByName("any_amount"));
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GUIDonate.this.dialog = new DialogNoNavBar(GUIDonate.this.getNvEvent());
                    GUIDonate.this.dialog.requestWindowFeature(1);
                    GUIDonate.this.dialog.setContentView(R.layout.br_popup_input);
                    GUIDonate.this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    GUIDonate.this.dialog.getWindow().setDimAmount(0.4f);
                    final EditText editText = (EditText) GUIDonate.this.dialog.findViewById(R.id.input);
                    TextView textView2 = (TextView) GUIDonate.this.dialog.findViewById(R.id.info);
                    final TextView textView3 = (TextView) GUIDonate.this.dialog.findViewById(R.id.value);
                    LinearLayout linearLayout = (LinearLayout) GUIDonate.this.dialog.findViewById(R.id.subedit);
                    GUIDonate.this.dialog.findViewById(R.id.dw_button_cancel).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            if (GUIDonate.this.dialog != null) {
                                GUIDonate.this.dialog.dismiss();
                                GUIDonate.this.dialog = null;
                            }
                        }
                    });
                    ((Button) GUIDonate.this.dialog.findViewById(R.id.dw_button_ok)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            String obj;
                            if (editText.getEditableText() == null || !((obj = editText.getEditableText().toString()) == null || obj.length() <= 0 || obj.charAt(0) == '0')) {
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("t", 4);
                                    jSONObject.put("v", editText.getEditableText().toString());
                                    GUIDonate.this.mGUIManager.sendJsonData(22, jSONObject);
                                } catch (Exception unused) {
                                }
                                GUIDonate.this.showProgress();
                            }
                        }
                    });
                    editText.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            int i4;
                            try {
                                i4 = Integer.valueOf(s.toString()).intValue();
                            } catch (Exception unused) {
                                i4 = 0;
                            }
                            TextView textView4 = textView3;
                            textView4.setText(GUIManager.getPriceWithSpaces(i4 * 1000) + " ₽");
                        }
                    });
                    GUIDonate.this.dialog.show();
                }
            });
            return;
        }
        holder.price.setPaintFlags(holder.priceStroked.getPaintFlags() & (-17));
        holder.price.setVisibility(0);
        holder.header.setText(item.getHeader());
        if (item.getType().intValue() == 2 || item.getType().intValue() == 7) {
            holder.subHeader.setText(item.getSubheader());
        } else {
            holder.subHeader.setText("");
        }
        if (this.mSelectedPage == 0) {
            if (position == 1) {
                holder.header.setText("Для вас");
                holder.subHeader.setText(item.getHeader());
            }
            if (position == 2) {
                holder.header.setText("Акция дня");
                holder.subHeader.setText(item.getHeader());
            }
            if (position == 3) {
                holder.header.setText("Товар дня");
                holder.subHeader.setText(item.getHeader());
            }
        }
        if (item.getUpTag() != 0) {
            holder.additionaHeader.setVisibility(0);
            if (item.getUpTag() == 2) {
                holder.additionaHeader.setText("Популярно");
            } else if (item.getUpTag() == 1) {
                holder.additionaHeader.setText("Лидер продаж");
            }
        } else {
            holder.additionaHeader.setVisibility(8);
        }
        if (item.getSaleTime() != 0) {
            holder.badgeText.setVisibility(0);
            holder.badgeTime.setVisibility(0);
            int saleTime2 = item.getSaleTime() / 3600;
            TextView textView2 = holder.badgeTime;
            textView2.setText(String.format("%02d", Integer.valueOf(saleTime2)) + ":" + String.format("%02d", Integer.valueOf((item.getSaleTime() - (saleTime2 * 3600)) / 60)));
        } else {
            holder.badgeText.setVisibility(8);
            holder.badgeTime.setVisibility(8);
        }
        String valueOf = String.valueOf(item.getBasePrice());
        if (item.getSalePercent() != 0) {
            if (item.getType().intValue() == 2 || item.getType().intValue() == 6 || item.getType().intValue() == 5 || item.getType().intValue() == 11) {
                holder.priceStroked.setGravity(17);
                holder.price.setVisibility(8);
            } else {
                holder.priceStroked.setGravity(0);
                holder.price.setVisibility(0);
            }
            holder.badgePercent.setVisibility(0);
            holder.priceStroked.setVisibility(0);
            holder.priceStroked.setPaintFlags(holder.priceStroked.getPaintFlags() | 16);
            holder.price.setGravity(5);
            TextView textView3 = holder.badgePercent;
            textView3.setText("-" + item.getSalePercent() + "%");
            TextView textView4 = holder.priceStroked;
            textView4.setText(valueOf + GUIManager.getPriceText(item));
            valueOf = String.valueOf(getItemPrice(item));
            TextView textView5 = holder.price;
            textView5.setText(valueOf + GUIManager.getPriceText(item));
        } else {
            holder.badgePercent.setVisibility(8);
            holder.priceStroked.setVisibility(8);
            holder.price.setGravity(17);
            TextView textView6 = holder.price;
            textView6.setText(valueOf + GUIManager.getPriceText(item));
            if (item.getType().intValue() == 2 || item.getType().intValue() == 6 || item.getType().intValue() == 11) {
                holder.priceStroked.setVisibility(8);
                holder.price.setVisibility(8);
            }
        }
        holder.button.setText("Смотреть");
        holder.button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        if (item.getType().intValue() == 2 || item.getType().intValue() == 6 || item.getType().intValue() == 11) {
            Button button = holder.button;
            button.setText(GUIManager.getPriceWithSpaces(Integer.valueOf(valueOf).intValue()) + GUIManager.getPriceText(item));
            holder.button.setCompoundDrawablesWithIntrinsicBounds(ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.basket_icon_small, null), (Drawable) null, (Drawable) null, (Drawable) null);
            holder.button.setOnClickListener(new AnonymousClass10(item, valueOf, item));
        }
        if (item.getType().intValue() == 6) {
            holder.imageView.setImageDrawable(getDrawableByName(item.getImageId()));
            holder.subHeader.setText(item.getSubheader());
        }
        if (item.getType().intValue() == 5) {
            if (item.getSalePercent() != 0) {
                holder.price.setText(valueOf);
                holder.price.setPaintFlags(holder.priceStroked.getPaintFlags() | 16);
                String priceWithSpaces = GUIManager.getPriceWithSpaces(getItemPrice(item));
                Button button2 = holder.button;
                button2.setText(priceWithSpaces + GUIManager.getPriceText(item));
            } else {
                Button button3 = holder.button;
                button3.setText(GUIManager.getPriceWithSpaces(getItemPrice(item)) + GUIManager.getPriceText(item));
                holder.price.setText("");
            }
            holder.button.setCompoundDrawablesWithIntrinsicBounds(ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.basket_icon_small, null), (Drawable) null, (Drawable) null, (Drawable) null);
            holder.imageView.setImageDrawable(getDrawableByName(item.getImageId()));
            holder.button.setOnClickListener(new AnonymousClass11(item, item));
        }
        if (item.getType().intValue() == 7) {
            holder.button.setText("Смотреть");
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getAlpha() < 1.0f) {
                        return;
                    }
                    item.setCategory(GUIDonate.this.mSelectedPage);
                    GUIDonate.this.mSelectedItems.push(item);
                    GUIDonate.this.getNvEvent().getSoundApi().playSound("donate_click_in_or_next_sfx");
                    v.startAnimation(AnimationUtils.loadAnimation(GUIDonate.this.getNvEvent(), R.anim.button_click));
                    GUIDonate.this.container.setCurrentLayout(5);
                }
            });
        }
        if (item.getType().intValue() == 1) {
            holder.priceStroked.setVisibility(8);
            holder.price.setText("");
            holder.imageView.setImageDrawable(getDrawableByName(item.getImageId()));
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getAlpha() < 1.0f) {
                        return;
                    }
                    item.setCategory(GUIDonate.this.mSelectedPage);
                    GUIDonate.this.mSelectedItems.push(item);
                    GUIDonate.this.getNvEvent().getSoundApi().playSound("donate_click_in_or_next_sfx");
                    v.startAnimation(AnimationUtils.loadAnimation(GUIDonate.this.getNvEvent(), R.anim.button_click));
                    GUIDonate.this.setCurrentPage(7);
                }
            });
        }
        if (item.getType().intValue() == 3) {
            holder.imageView.setImageDrawable(getDrawableByName(item.getImageId()));
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getAlpha() < 1.0f) {
                        return;
                    }
                    item.setCategory(GUIDonate.this.mSelectedPage);
                    GUIDonate.this.mSelectedItems.push(item);
                    GUIDonate.this.getNvEvent().getSoundApi().playSound("donate_click_in_or_next_sfx");
                    v.startAnimation(AnimationUtils.loadAnimation(GUIDonate.this.getNvEvent(), R.anim.button_click));
                    GUIDonate.this.container.setCurrentLayout(6);
                }
            });
        }
        if (item.getType().intValue() == 9) {
            holder.imageView.setImageDrawable(getDrawableByName(item.getImageId()));
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getAlpha() < 1.0f) {
                        return;
                    }
                    item.setCategory(GUIDonate.this.mSelectedPage);
                    GUIDonate.this.mSelectedItems.push(item);
                    GUIDonate.this.getNvEvent().getSoundApi().playSound("donate_click_in_or_next_sfx");
                    v.startAnimation(AnimationUtils.loadAnimation(GUIDonate.this.getNvEvent(), R.anim.button_click));
                    GUIDonate.this.container.setCurrentLayout(6);
                }
            });
        }
        if (item.getType().intValue() == 4) {
            holder.imageView.setImageDrawable(getDrawableByName(item.getImageId()));
            holder.priceStroked.setVisibility(8);
            holder.price.setGravity(17);
            holder.price.setVisibility(0);
            TextView textView7 = holder.price;
            textView7.setText("Посмотри что включает в себя набор " + item.getHeader());
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getAlpha() < 1.0f) {
                        return;
                    }
                    item.setCategory(GUIDonate.this.mSelectedPage);
                    GUIDonate.this.mSelectedItems.push(item);
                    GUIDonate.this.getNvEvent().getSoundApi().playSound("donate_click_in_or_next_sfx");
                    v.startAnimation(AnimationUtils.loadAnimation(GUIDonate.this.getNvEvent(), R.anim.button_click));
                    GUIDonate.this.setCurrentPage(9);
                }
            });
        }
        if (item.getType().intValue() == 11) {
            holder.imageView.setAlpha(0.0f);
            getNvEvent().getGameRender().RequestRender(0, item.getInternalId().intValue(), item.getModelId().intValue(), 0, 0, item.getRot().get(0).floatValue(), item.getRot().get(1).floatValue(), item.getRot().get(2).floatValue(), item.getModelZoom().floatValue(), new GameRender.GameRenderListener() {
                @Override
                public void OnRenderComplete(int id, byte[] buffer, long length) {
                    final Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
                    createBitmap.setHasAlpha(true);
                    IntBuffer asIntBuffer = ByteBuffer.wrap(buffer).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
                    int[] iArr = new int[asIntBuffer.remaining()];
                    asIntBuffer.get(iArr);
                    createBitmap.setPixels(iArr, 0, 512, 0, 0, 512, 512);
                    GUIDonate.this.getNvEvent().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            holder.imageView.setImageBitmap(createBitmap);
                            holder.imageView.animate().alpha(1.0f).setDuration(300L);
                        }
                    });
                }
            });
        }
        if (item.getType().intValue() == 7 || item.getType().intValue() == 2) {
            holder.imageView.setAlpha(0.0f);
            if (item.getType().intValue() == 7) {
                int intValue = item.getColors().get(0).intValue();
                i2 = item.getColors().get(1).intValue();
                i = intValue;
            } else {
                i = 0;
                i2 = 0;
            }
            getNvEvent().getGameRender().RequestRender(item.getType().intValue(), item.getInternalId().intValue(), item.getGameId().intValue(), i, i2, 20.0f, 180.0f, 45.0f, 0.78f, new GameRender.GameRenderListener() {
                @Override
                public void OnRenderComplete(int id, byte[] buffer, long length) {
                    final Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
                    createBitmap.setHasAlpha(true);
                    IntBuffer asIntBuffer = ByteBuffer.wrap(buffer).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
                    int[] iArr = new int[asIntBuffer.remaining()];
                    asIntBuffer.get(iArr);
                    createBitmap.setPixels(iArr, 0, 512, 0, 0, 512, 512);
                    GUIDonate.this.getNvEvent().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            holder.imageView.setImageBitmap(createBitmap);
                            holder.imageView.animate().alpha(1.0f).setDuration(300L);
                        }
                    });
                }
            });
        }
        if (this.mLimits == null || getLimitItemOffset(item.getInternalId().intValue()) < 0 || (i3 = this.mLimits[getLimitItemOffset(item.getInternalId().intValue()) + 1]) < 0) {
            return;
        }
        holder.limitLayout.setVisibility(0);
        TextView textView8 = holder.limitCount;
        textView8.setText(i3 + " шт.");
        if (i3 == 0 || this.mIsCloseLimit) {
            holder.button.setAlpha(0.5f);
        }
    }

    public class AnonymousClass10 implements View.OnClickListener {
        final DonateItem val$finalItem;
        final String val$finalPrice;
        final DonateItem val$item;

        AnonymousClass10(final DonateItem val$finalItem, final String val$finalPrice, final DonateItem val$item) {
            //GUIDonate.this = this$0;
            this.val$item = val$finalItem;
            this.val$finalPrice = val$finalPrice;
            this.val$finalItem = val$item;
        }

        @Override
        public void onClick(View v) {
            if (v.getAlpha() < 1.0f) {
                return;
            }
            v.startAnimation(AnimationUtils.loadAnimation(GUIDonate.this.getNvEvent(), R.anim.button_click));
            v.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GUIDonate.this.showConfirmationDialog(AnonymousClass10.this.val$item, Integer.valueOf(AnonymousClass10.this.val$finalPrice).intValue(), "Подтверждение", "Да", "Нет", new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("t", 0);
                                jSONObject.put("m", GUIDonate.getItemPrice(AnonymousClass10.this.val$finalItem));
                                jSONObject.put(TuningConstants.KEY_GET_ID_DETAIL, AnonymousClass10.this.val$finalItem.getInternalId());
                                jSONObject.put(Const.FRACTION_CLOSE_KEY, AnonymousClass10.this.val$finalItem.getCount());
                                GUIDonate.this.mGUIManager.sendJsonData(22, jSONObject);
                                GUIDonate.this.mPurchasedItem = AnonymousClass10.this.val$finalItem;
                            } catch (Exception unused) {
                            }
                            GUIDonate.this.showProgress();
                        }
                    }, new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            GUIDonate.this.closeDialog();
                        }
                    });
                }
            }, 250L);
        }
    }

    public class AnonymousClass11 implements View.OnClickListener {
        final DonateItem val$finalItem;
        final DonateItem val$item;

        AnonymousClass11(final DonateItem val$finalItem, final DonateItem val$item) {
            //GUIDonate.this = this$0;
            this.val$item = val$finalItem;
            this.val$finalItem = val$item;
        }

        @Override
        public void onClick(View v) {
            if (v.getAlpha() < 1.0f) {
                return;
            }
            v.startAnimation(AnimationUtils.loadAnimation(GUIDonate.this.getNvEvent(), R.anim.button_click));
            final int itemPrice = GUIDonate.getItemPrice(this.val$item);
            v.postDelayed(new Runnable() {
                @Override
                public void run() {
                    GUIDonate.this.showConfirmationDialog(AnonymousClass11.this.val$item, itemPrice, "Подтверждение", "Да", "Нет", new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("t", 0);
                                jSONObject.put("m", GUIDonate.getItemPrice(AnonymousClass11.this.val$finalItem));
                                jSONObject.put(TuningConstants.KEY_GET_ID_DETAIL, AnonymousClass11.this.val$finalItem.getInternalId());
                                jSONObject.put(Const.FRACTION_CLOSE_KEY, AnonymousClass11.this.val$finalItem.getCount());
                                GUIDonate.this.mGUIManager.sendJsonData(22, jSONObject);
                                GUIDonate.this.mPurchasedItem = AnonymousClass11.this.val$finalItem;
                            } catch (Exception unused) {
                            }
                            if (AnonymousClass11.this.val$finalItem.getGameId().intValue() != -20) {
                                GUIDonate.this.showProgress();
                                return;
                            }
                            GUIDonate.this.closeDialog();
                            GUIDonate.this.cancelTimeout();
                        }
                    }, new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            GUIDonate.this.closeDialog();
                        }
                    });
                }
            }, 250L);
        }
    }

    public void showResultDialog(int success, String msg, String boldMsg, String caption, String butOk, View.OnClickListener listener) {
        if (this.dialog != null) {
            closeDialog();
        }
        DialogNoNavBar dialogNoNavBar = new DialogNoNavBar(getNvEvent());
        this.dialog = dialogNoNavBar;
        dialogNoNavBar.requestWindowFeature(1);
        this.dialog.setContentView(R.layout.br_dialog_error_success);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialog.getWindow().setDimAmount(0.4f);
        ((TextView) this.dialog.findViewById(R.id.dw_default)).setText(GUIManager.transfromColors(msg));
        if (success == 0) {
            this.dialog.findViewById(R.id.dw_icon).setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.checkbox_red_icon));
            getNvEvent().getSoundApi().playSound("donate_error_sfx");
        } else {
            getNvEvent().getSoundApi().playSound("donate_success_sfx");
        }
        ((TextView) this.dialog.findViewById(R.id.dw_bold)).setText(GUIManager.transfromColors(boldMsg));
        ((TextView) this.dialog.findViewById(R.id.dw_caption)).setText(caption);
        Button button = (Button) this.dialog.findViewById(R.id.dw_button_ok);
        button.setText(butOk);
        button.setOnClickListener(listener);
        this.dialog.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GUIDonate.this.closeDialog();
            }
        });
        this.dialog.show();
        GUIManager.hideSystemUI(this.dialog.getWindow().getDecorView());
    }

    public void showResultDialog(int success, String msg, String boldMsg, String caption, String butOk, View.OnClickListener listener, DialogInterface.OnDismissListener dismissListener) {
        if (this.dialog != null) {
            closeDialog();
        }
        DialogNoNavBar dialogNoNavBar = new DialogNoNavBar(getNvEvent());
        this.dialog = dialogNoNavBar;
        dialogNoNavBar.requestWindowFeature(1);
        this.dialog.setContentView(R.layout.br_dialog_error_success);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialog.getWindow().setDimAmount(0.4f);
        ((TextView) this.dialog.findViewById(R.id.dw_default)).setText(GUIManager.transfromColors(msg));
        if (success == 0) {
            this.dialog.findViewById(R.id.dw_icon).setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.checkbox_red_icon));
            getNvEvent().getSoundApi().playSound("donate_error_sfx");
        } else {
            getNvEvent().getSoundApi().playSound("donate_success_sfx");
        }
        ((TextView) this.dialog.findViewById(R.id.dw_bold)).setText(GUIManager.transfromColors(boldMsg));
        ((TextView) this.dialog.findViewById(R.id.dw_caption)).setText(caption);
        Button button = (Button) this.dialog.findViewById(R.id.dw_button_ok);
        button.setText(butOk);
        button.setOnClickListener(listener);
        this.dialog.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GUIDonate.this.closeDialog();
            }
        });
        this.dialog.setOnDismissListener(dismissListener);
        this.dialog.show();
        GUIManager.hideSystemUI(this.dialog.getWindow().getDecorView());
    }

    public void startTimeout() {
        Runnable runnable = this.mTimeoutRunnable;
        if (runnable != null) {
            this.mViewRoot.removeCallbacks(runnable);
            this.mTimeoutRunnable = null;
        }
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("y", 0);
                    jSONObject.put("m", "Ошибка");
                    jSONObject.put("n", "Таймаут ответа от сервера");
                    jSONObject.put("t", 0);
                    GUIDonate.this.onPacketIncoming(jSONObject);
                } catch (Exception unused) {
                }
            }
        };
        this.mTimeoutRunnable = runnable2;
        this.mViewRoot.postDelayed(runnable2, 3000L);
    }

    public void cancelTimeout() {
        Runnable runnable = this.mTimeoutRunnable;
        if (runnable != null) {
            this.mViewRoot.removeCallbacks(runnable);
            this.mTimeoutRunnable = null;
        }
    }

    public void showConfirmationDialog(int price, String caption, String butOk, String butNo, View.OnClickListener listenerOk, View.OnClickListener listenerCancel) {
        showConfirmationDialog(null, price, caption, butOk, butNo, listenerOk, listenerCancel);
    }

    public void showConfirmationDialog(DonateItem item, int price, String caption, String butOk, String butNo, final View.OnClickListener listenerOk, View.OnClickListener listenerCancel) {
        if (this.dialog != null) {
            closeDialog();
        }
        DialogNoNavBar dialogNoNavBar = new DialogNoNavBar(getNvEvent());
        this.dialog = dialogNoNavBar;
        dialogNoNavBar.requestWindowFeature(1);
        this.dialog.setContentView(R.layout.br_popup);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialog.getWindow().setDimAmount(0.4f);
        ((TextView) this.dialog.findViewById(R.id.dw_info)).setText(GUIManager.transfromColors("Вы действительно желаете\n{f4b939}приобрести данный товар за " + price + GUIManager.getPriceText(item) + "?"));
        ((TextView) this.dialog.findViewById(R.id.dw_caption)).setText(caption);
        Button button = (Button) this.dialog.findViewById(R.id.dw_button_ok);
        button.setText(butOk);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GUIDonate.this.startTimeout();
                listenerOk.onClick(v);
            }
        });
        Button button2 = (Button) this.dialog.findViewById(R.id.dw_button_cancel);
        button2.setText(butNo);
        button2.setOnClickListener(listenerCancel);
        getNvEvent().getSoundApi().playSound("donate_pop_up_sfx");
        this.dialog.show();
        GUIManager.hideSystemUI(this.dialog.getWindow().getDecorView());
    }

    public void closeDialog() {
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.cancel();
        }
        getNvEvent().getParentLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    GUIManager.hideSystemUI(GUIDonate.this.getWindow().getContentView());
                } catch (Exception unused) {
                }
            }
        }, 300L);
        this.dialog = null;
    }

    public void setImageForItem(ImageView image, DonateItem item, int color1, int color2) {
        image.setAlpha(0.0f);
        getNvEvent().getGameRender().RequestRender(item.getType().intValue(), item.getInternalId().intValue(), item.getGameId().intValue(), color1, color2, 20.0f, 180.0f, 45.0f, 0.78f, new AnonymousClass24(image));
    }

    public class AnonymousClass24 implements GameRender.GameRenderListener {
        final ImageView val$image;

        AnonymousClass24(final ImageView val$image) {
            //GUIDonate.this = this$0;
            this.val$image = val$image;
        }

        @Override
        public void OnRenderComplete(int id, final byte[] buffer, long length) {
            GUIDonate.this.getNvEvent().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    final Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
                    createBitmap.setHasAlpha(true);
                    IntBuffer asIntBuffer = ByteBuffer.wrap(buffer).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
                    int[] iArr = new int[asIntBuffer.remaining()];
                    asIntBuffer.get(iArr);
                    createBitmap.setPixels(iArr, 0, 512, 0, 0, 512, 512);
                    GUIDonate.this.getNvEvent().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AnonymousClass24.this.val$image.setImageBitmap(createBitmap);
                            AnonymousClass24.this.val$image.animate().alpha(1.0f).setDuration(300L);
                        }
                    });
                }
            });
        }
    }

    public Drawable getDrawableByName(String name) {
        int identifier = this.mContext.getResources().getIdentifier(name, "drawable", this.mContext.getPackageName());
        if (identifier == 0) {
            return ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.back2, null);
        }
        return ResourcesCompat.getDrawable(this.mContext.getResources(), identifier, null);
    }

    public int getItemWidth() {
        return (int) (this.displayMetrics.widthPixels / 4.5f);
    }

    @Override
    public void onLayoutChanged(int newlayout) {
        if (newlayout == 1 || newlayout == 2) {
            hideFooter();
        } else {
            showFooter();
        }
        this.container.setCurrentLayout(newlayout);
        this.mHeaderAdapter.setNewPage(newlayout);
    }

    private void prepareHeader() {
        this.mHeaderRV = (RecyclerView) this.mViewRoot.findViewById(R.id.headerRV);
        DonateHeaderAdapter donateHeaderAdapter = new DonateHeaderAdapter(this, this);
        this.mHeaderAdapter = donateHeaderAdapter;
        this.mHeaderRV.setAdapter(donateHeaderAdapter);
        this.mHeaderRV.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false) {
            @Override
            public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                lp.width = getWidth() / GUIDonate.this.mHeaderAdapter.getItemCount();
                return super.checkLayoutParams(lp);
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            this.mHeaderRV.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(final View view, final Outline outline) {
                    float dpToPx = NvEventQueueActivity.dpToPx(7.0f, GUIDonate.this.mContext);
                    outline.setRoundRect(0, (int) (0.0f - dpToPx), view.getWidth(), view.getHeight(), dpToPx);
                }
            });
            this.mHeaderRV.setClipToOutline(true);
        }
    }

    public void hideFooter() {
        this.mFooterRV.setVisibility(8);
        this.mViewRoot.findViewById(R.id.footerLeft).setVisibility(8);
        this.mViewRoot.findViewById(R.id.footerRight).setVisibility(8);
    }

    public void showFooter() {
        this.mFooterRV.setVisibility(0);
        this.mViewRoot.findViewById(R.id.footerLeft).setVisibility(0);
        this.mViewRoot.findViewById(R.id.footerRight).setVisibility(0);
    }

    public DonateItem getSelectedItem() {
        if (this.mSelectedItems.empty()) {
            return null;
        }
        return this.mSelectedItems.peek();
    }

    public void popSelectedItem() {
        if (this.mSelectedItems.empty()) {
            return;
        }
        this.mSelectedItems.pop();
    }

    public boolean isSelectedItemStackEmpty() {
        return this.mSelectedItems.empty();
    }

    public int getDoubleDonate() {
        return this.mDoubleDonate;
    }

    public void hideSystemUI() {
        getNvEvent().getParentLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    GUIManager.hideSystemUI(GUIDonate.this.mWindow.getContentView());
                } catch (Exception unused) {
                    GUIDonate.this.getNvEvent().getParentLayout().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            GUIManager.hideSystemUI(GUIDonate.this.mWindow.getContentView());
                        }
                    }, 1000L);
                }
            }
        }, 300L);
    }

    @Override
    public void show(JSONObject json, GUIManager manager, final NvEventQueueActivity activity) {
        this.mGUIManager = manager;
        this.mContext = activity;
        this.mHandler = new Handler();
        this.mRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    GUIManager.hideSystemUI(GUIDonate.this.mWindow.getContentView());
                } catch (Exception unused) {
                }
                GUIDonate.this.mHandler.postDelayed(GUIDonate.this.mRunnable, 1000L);
            }
        };
        this.mJson = json;
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        this.displayMetrics = new DisplayMetrics();
        getNvEvent().getWindowManager().getDefaultDisplay().getMetrics(this.displayMetrics);
        this.mEmail = json.optString(PutKeys.PUT_MONEY);
        this.mNick = json.optString(GetKeys.GET_NUMBER_IN_SLOT);
        this.mDoubleDonate = json.optInt("ds");
        this.mServer = json.optInt("sv");
        this.mIsCloseLimit = json.optInt("li") != 0;
        if (this.mWindow == null) {
            this.mViewRoot = layoutInflater.inflate(R.layout.donate, (ViewGroup) null, false);
            GUIPopupWindow gUIPopupWindow = new GUIPopupWindow(this.mViewRoot, -1, -1, true);
            this.mWindow = gUIPopupWindow;
            gUIPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("t", 3);
                        GUIDonate.this.mGUIManager.sendJsonData(22, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
            this.mWindow.setAnimationStyle(R.style.PopupWindowAnimation);
        }
        this.mHandler.postDelayed(this.mRunnable, 100L);
        if (App.getInstance().getDonateItems().size() < 1 || App.getInstance().getCarColorItems().size() < 1) {
            showResultDialog(0, "Произошла неизвестная ошибка. Повторите позже", "", "Ошибка", "Закрыть", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (GUIDonate.this.dialog != null) {
                        GUIDonate.this.dialog.dismiss();
                        GUIDonate.this.dialog = null;
                    }
                    GUIDonate.this.mGUIManager.closeGUI(null, 22);
                }
            }, new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    GUIDonate.this.mGUIManager.closeGUI(null, 22);
                }
            });
            this.mDonateDontWork = true;
            return;
        }
        prepareHeader();
        prepareFooter();
        this.mSelectedItems = new Stack<>();
        UIContainer uIContainer = (UIContainer) this.mViewRoot.findViewById(R.id.container);
        this.container = uIContainer;
        uIContainer.addLayout(0, new UILayoutDonateTile(this));
        this.container.addLayout(1, new UILayoutDonateServices(this));
        BrBlackPass brBlackPass = new BrBlackPass(this.mGUIManager, activity, this);
        this.mBlackPass = brBlackPass;
        this.container.addLayout(2, brBlackPass);
        this.container.addLayout(3, new UILayout() {
            @Override
            public View getView() {
                return null;
            }

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container) {
                return null;
            }

            @Override
            public void onLayoutClose() {
            }

            @Override
            public void onLayoutShown() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("t", 1);
                    GUIDonate.this.mGUIManager.sendJsonData(22, jSONObject);
                } catch (Exception unused) {
                }
                GUIDonate.this.mGUIManager.closeGUI(null, 22);
            }
        });
        this.container.addLayout(4, new UILayoutDonateDepositCoins(this));
        this.container.addLayout(5, new UILayoutDonatePreviewCar(this));
        this.container.addLayout(6, new UILayoutDonatePreviewPack(this));
        showFooter();
        if (json.optInt("lc", -1) == -1) {
            this.container.setCurrentLayout(0);
        } else {
            onLayoutChanged(json.optInt("lc", -1));
        }
        if (this.container.getCurrentLayoutId() == 2) {
            this.mBlackPass.EnableActivateLayout(true);
        }
        this.mViewRoot.findViewById(R.id.headerLeft).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(GUIDonate.this.mContext, R.anim.button_click));
                GUIDonate.this.mHeaderAdapter.previous();
            }
        });
        this.mViewRoot.findViewById(R.id.headerRight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(GUIDonate.this.mContext, R.anim.button_click));
                GUIDonate.this.mHeaderAdapter.next();
            }
        });
        this.mViewRoot.findViewById(R.id.footerLeft).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(GUIDonate.this.mContext, R.anim.button_click));
                GUIDonate.this.mFooterAdapter.previous();
            }
        });
        this.mViewRoot.findViewById(R.id.footerRight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(GUIDonate.this.mContext, R.anim.button_click));
                GUIDonate.this.mFooterAdapter.next();
            }
        });
        String priceWithSpaces = GUIManager.getPriceWithSpaces(json.optInt(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL));
        String priceWithSpaces2 = GUIManager.getPriceWithSpaces(json.optInt("d"));
        ((TextView) this.mViewRoot.findViewById(R.id.headerRubles)).setText(priceWithSpaces);
        ((TextView) this.mViewRoot.findViewById(R.id.headerCoins)).setText(priceWithSpaces2);
        this.mViewRoot.findViewById(R.id.donateButtonMoneyPlus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GUIDonate.this.getNvEvent().getSoundApi().playSound("donate_click_in_or_next_sfx");
                v.startAnimation(AnimationUtils.loadAnimation(GUIDonate.this.mContext, R.anim.button_click));
                GUIDonate.this.showFooter();
                GUIDonate.this.mFooterAdapter.deselectPage();
                GUIDonate.this.mHeaderAdapter.setNewPage(0);
                GUIDonate.this.setCurrentPage(6);
            }
        });
        this.mViewRoot.findViewById(R.id.donateButtonBCPlus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GUIDonate.this.getNvEvent().getSoundApi().playSound("donate_click_in_or_next_sfx");
                v.startAnimation(AnimationUtils.loadAnimation(GUIDonate.this.mContext, R.anim.button_click));
                GUIDonate.this.hideFooter();
                GUIDonate.this.mHeaderAdapter.deselectItem();
                GUIDonate.this.container.setCurrentLayout(4);
            }
        });
        this.mViewRoot.findViewById(R.id.headerExit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GUIDonate.this.getNvEvent().getSoundApi().playSound("donate_click_close_sfx");
                v.startAnimation(AnimationUtils.loadAnimation(GUIDonate.this.mContext, R.anim.button_click));
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("t", 3);
                    GUIDonate.this.mGUIManager.sendJsonData(22, jSONObject);
                } catch (Exception unused) {
                }
                GUIDonate.this.mGUIManager.closeGUI(null, 22);
            }
        });
        activity.getParentLayout().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    GUIManager.hideSystemUI(GUIDonate.this.mWindow.getContentView());
                } catch (Exception unused) {
                    activity.getParentLayout().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            GUIManager.hideSystemUI(GUIDonate.this.mWindow.getContentView());
                        }
                    }, 1000L);
                }
            }
        }, 300L);
        this.mWindow.showAtLocation(activity.getParentLayout(), 17, 0, 0);
    }

    @Override
    public void close(JSONObject json) {
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            try {
                handler.removeCallbacks(this.mRunnable);
            } catch (Exception e) {
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
    }

    @Override
    public boolean isShowingGui() {
        if (this.mDonateDontWork) {
            return true;
        }
        PopupWindow popupWindow = this.mWindow;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }

    @Override
    public void onPageChanged(int i) {
        this.mSelectedPage = i;
        this.container.setCurrentLayout(0);
        ((UILayoutDonateTile) this.container.getLayout(0)).onPageChanged(this.mSelectedPage);
        getNvEvent().getSoundApi().playSound("donate_click_in_or_next_sfx");
    }
}
