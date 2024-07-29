package com.rockstargames.gtacr.gui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.network.DonateItem;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.DonateCarColorAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

public class UILayoutDonatePreviewCar extends UILayout {
    private ProgressBar mAcceleration;
    private DonateCarColorAdapter mAdapter;
    private ProgressBar mBoot;
    private Button mButton;
    private ProgressBar mCapacity;
    private TextView mCarName;
    private ImageView mImage;
    private ProgressBar mMaxSpeed;
    private TextView mPriceStroked;
    private RecyclerView mRV;
    private GUIDonate mRoot;
    private TextView mTextAcceleration;
    private TextView mTextBoot;
    private TextView mTextCapacity;
    private TextView mTextMaxSpeed;
    private View mViewRoot = null;

    public UILayoutDonatePreviewCar(GUIDonate root) {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.donate_car_preview, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        this.mRV = (RecyclerView) inflate.findViewById(R.id.colorSelectRV);
        DonateCarColorAdapter donateCarColorAdapter = new DonateCarColorAdapter(this);
        this.mAdapter = donateCarColorAdapter;
        this.mRV.setAdapter(donateCarColorAdapter);
        this.mRV.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mViewRoot.findViewById(R.id.donateButtonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DonateItem selectedItem = UILayoutDonatePreviewCar.this.mRoot.getSelectedItem();
                UILayoutDonatePreviewCar.this.getDonate().getNvEvent().getSoundApi().playSound("donate_click_back_sfx");
                UILayoutDonatePreviewCar.this.mRoot.setCurrentPage(selectedItem.getCategory());
            }
        });
        this.mCarName = (TextView) this.mViewRoot.findViewById(R.id.donateCarPreviewName);
        this.mPriceStroked = (TextView) this.mViewRoot.findViewById(R.id.priceStroked);
        this.mButton = (Button) this.mViewRoot.findViewById(R.id.button);
        this.mMaxSpeed = (ProgressBar) this.mViewRoot.findViewById(R.id.progress_max);
        this.mAcceleration = (ProgressBar) this.mViewRoot.findViewById(R.id.progress_0100);
        this.mCapacity = (ProgressBar) this.mViewRoot.findViewById(R.id.progress_capacity);
        this.mBoot = (ProgressBar) this.mViewRoot.findViewById(R.id.progress_boot);
        this.mTextMaxSpeed = (TextView) this.mViewRoot.findViewById(R.id.text_max);
        this.mTextAcceleration = (TextView) this.mViewRoot.findViewById(R.id.text_0100);
        this.mTextCapacity = (TextView) this.mViewRoot.findViewById(R.id.text_capacity);
        this.mTextBoot = (TextView) this.mViewRoot.findViewById(R.id.text_boot);
        this.mImage = (ImageView) this.mViewRoot.findViewById(R.id.donateCarPreviewImage);
        return this.mViewRoot;
    }

    public void updatePrice() {
        DonateItem selectedItem = this.mRoot.getSelectedItem();
        String priceFromInt = GUIManager.getPriceFromInt(selectedItem.getBasePrice().intValue() + this.mAdapter.getCarColorPrice());
        int itemPrice = (int) (GUIDonate.getItemPrice(selectedItem) + this.mAdapter.getCarColorPrice());
        if (selectedItem.getSalePercent() != 0) {
            TextView textView = this.mPriceStroked;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            TextView textView2 = this.mPriceStroked;
            textView2.setText(priceFromInt + GUIManager.getBCText());
            String priceFromInt2 = GUIManager.getPriceFromInt(itemPrice);
            Button button = this.mButton;
            button.setText(priceFromInt2 + GUIManager.getBCText());
            return;
        }
        Button button2 = this.mButton;
        button2.setText(priceFromInt + GUIManager.getBCText());
        this.mPriceStroked.setText("");
    }

    @Override
    public void onLayoutShown() {
        DonateItem selectedItem = this.mRoot.getSelectedItem();
        this.mAdapter.resetColor();
        updatePrice();
        TextView textView = this.mCarName;
        textView.setText(selectedItem.getHeader() + " " + selectedItem.getSubheader());
        this.mMaxSpeed.setProgress(selectedItem.getSpecs().get(0).intValue());
        this.mAcceleration.setProgress(selectedItem.getSpecs().get(1).intValue());
        this.mCapacity.setProgress(selectedItem.getSpecs().get(2).intValue());
        this.mBoot.setProgress(selectedItem.getSpecs().get(3).intValue());
        TextView textView2 = this.mTextMaxSpeed;
        textView2.setText(selectedItem.getSpecs().get(0) + " км/ч");
        TextView textView3 = this.mTextAcceleration;
        textView3.setText(selectedItem.getSpecs().get(1) + " сек");
        TextView textView4 = this.mTextCapacity;
        textView4.setText(selectedItem.getSpecs().get(2) + " чел.");
        TextView textView5 = this.mTextBoot;
        textView5.setText(selectedItem.getSpecs().get(3) + " кг");
        this.mButton.setOnClickListener(new AnonymousClass2(selectedItem, selectedItem));
        this.mRoot.setImageForItem(this.mImage, selectedItem, 0, 0);
    }

    public class AnonymousClass2 implements View.OnClickListener {
        final DonateItem val$finalItem;
        final DonateItem val$item;

        AnonymousClass2(final DonateItem val$finalItem, final DonateItem val$item) {
            //UILayoutDonatePreviewCar.this = this$0;
            this.val$item = val$finalItem;
            this.val$finalItem = val$item;
        }

        @Override
        public void onClick(View v) {
            v.startAnimation(AnimationUtils.loadAnimation(UILayoutDonatePreviewCar.this.getContext(), R.anim.button_click));
            final int itemPrice = GUIDonate.getItemPrice(this.val$item) + ((int) UILayoutDonatePreviewCar.this.mAdapter.getCarColorPrice());
            v.postDelayed(new Runnable() {
                @Override
                public void run() {
                    UILayoutDonatePreviewCar.this.mRoot.showConfirmationDialog(AnonymousClass2.this.val$item, itemPrice, "Подтверждение", "Да", "Нет", new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("t", 0);
                                jSONObject.put("m", GUIDonate.getItemPrice(AnonymousClass2.this.val$finalItem));
                                jSONObject.put(TuningConstants.KEY_GET_ID_DETAIL, AnonymousClass2.this.val$finalItem.getInternalId());
                                jSONObject.put("l", UILayoutDonatePreviewCar.this.mAdapter.getSelectedGameColor());
                                UILayoutDonatePreviewCar.this.getDonate().getGUIManager().sendJsonData(22, jSONObject);
                            } catch (Exception unused) {
                            }
                            UILayoutDonatePreviewCar.this.mRoot.showProgress();
                        }
                    }, new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            UILayoutDonatePreviewCar.this.mRoot.closeDialog();
                        }
                    });
                }
            }, 250L);
        }
    }

    @Override
    public void onLayoutClose() {
        this.mRoot.popSelectedItem();
    }

    public void changeCarColorPreview(int newcolor) {
        GUIDonate gUIDonate = this.mRoot;
        gUIDonate.setImageForItem(this.mImage, gUIDonate.getSelectedItem(), newcolor, newcolor);
    }
}
