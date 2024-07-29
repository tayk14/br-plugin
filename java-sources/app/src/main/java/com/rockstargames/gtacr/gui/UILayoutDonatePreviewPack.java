package com.rockstargames.gtacr.gui;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.network.DonateItem;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.DonatePackAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.gui.fractions.Const;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import org.json.JSONObject;

public class UILayoutDonatePreviewPack extends UILayout {
    private Button mButtonPackBuy;
    private TextView mHeader;
    private ImageView mImage;
    private RecyclerView mRV;
    private GUIDonate mRoot;
    private TextView mStrokedPrice;
    private View mViewRoot = null;

    public UILayoutDonatePreviewPack(GUIDonate root) {
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
        View inflate = inflater.inflate(R.layout.donate_pack_preview, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        this.mStrokedPrice = (TextView) inflate.findViewById(R.id.strokedPrice);
        this.mButtonPackBuy = (Button) this.mViewRoot.findViewById(R.id.button);
        this.mHeader = (TextView) this.mViewRoot.findViewById(R.id.header);
        this.mRV = (RecyclerView) this.mViewRoot.findViewById(R.id.donatePackRV);
        this.mImage = (ImageView) this.mViewRoot.findViewById(R.id.image);
        this.mViewRoot.findViewById(R.id.donateButtonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DonateItem selectedItem = UILayoutDonatePreviewPack.this.mRoot.getSelectedItem();
                UILayoutDonatePreviewPack.this.getDonate().getNvEvent().getSoundApi().playSound("donate_click_back_sfx");
                UILayoutDonatePreviewPack.this.mRoot.setCurrentPage(selectedItem.getCategory());
            }
        });
        this.mRV.setLayoutManager(new LinearLayoutManager(getContext()));
        return this.mViewRoot;
    }

    @Override
    public void onLayoutShown() {
        DonateItem selectedItem = this.mRoot.getSelectedItem();
        this.mRV.setAdapter(null);
        this.mRV.setAdapter(new DonatePackAdapter(this));
        String priceWithSpaces = GUIManager.getPriceWithSpaces(selectedItem.getBasePrice().intValue());
        if (selectedItem.getSalePercent() != 0) {
            this.mStrokedPrice.setVisibility(0);
            TextView textView = this.mStrokedPrice;
            textView.setText(priceWithSpaces + GUIManager.getBCText());
            TextView textView2 = this.mStrokedPrice;
            textView2.setPaintFlags(textView2.getPaintFlags() | 16);
            String priceWithSpaces2 = GUIManager.getPriceWithSpaces(Integer.valueOf(GUIDonate.getItemPrice(selectedItem)).intValue());
            Button button = this.mButtonPackBuy;
            button.setText(priceWithSpaces2 + GUIManager.getBCText());
        } else {
            this.mStrokedPrice.setVisibility(8);
            Button button2 = this.mButtonPackBuy;
            button2.setText(priceWithSpaces + GUIManager.getBCText());
        }
        this.mImage.setImageDrawable(this.mRoot.getDrawableByName(selectedItem.getImageId()));
        this.mButtonPackBuy.setOnClickListener(new AnonymousClass2(selectedItem, selectedItem));
        if (selectedItem.getType().intValue() == 3) {
            TextView textView3 = this.mHeader;
            textView3.setText(Html.fromHtml("<font color='#FFFFFF'>Набор</font> <font color='#E2310C'>" + selectedItem.getHeader() + "</font>"));
        }
        if (selectedItem.getType().intValue() != 9 || selectedItem.getDesc() == null) {
            return;
        }
        this.mHeader.setText(GUIManager.transfromColors(selectedItem.getDesc()));
    }

    public class AnonymousClass2 implements View.OnClickListener {
        final DonateItem val$finalItem;
        final DonateItem val$item;

        AnonymousClass2(final DonateItem val$finalItem, final DonateItem val$item) {
            //UILayoutDonatePreviewPack.this = this$0;
            this.val$item = val$finalItem;
            this.val$finalItem = val$item;
        }

        @Override
        public void onClick(View v) {
            v.startAnimation(AnimationUtils.loadAnimation(UILayoutDonatePreviewPack.this.getContext(), R.anim.button_click));
            final int itemPrice = GUIDonate.getItemPrice(this.val$item);
            v.postDelayed(new Runnable() {
                @Override
                public void run() {
                    UILayoutDonatePreviewPack.this.mRoot.showConfirmationDialog(AnonymousClass2.this.val$item, itemPrice, "Подтверждение", "Да", "Нет", new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("t", 0);
                                jSONObject.put("m", GUIDonate.getItemPrice(AnonymousClass2.this.val$finalItem));
                                jSONObject.put(TuningConstants.KEY_GET_ID_DETAIL, AnonymousClass2.this.val$finalItem.getInternalId());
                                jSONObject.put(Const.FRACTION_CLOSE_KEY, AnonymousClass2.this.val$finalItem.getCount());
                                UILayoutDonatePreviewPack.this.getDonate().getGUIManager().sendJsonData(22, jSONObject);
                            } catch (Exception unused) {
                            }
                            UILayoutDonatePreviewPack.this.mRoot.showProgress();
                        }
                    }, new View.OnClickListener() {
                        @Override
                        public void onClick(View v2) {
                            UILayoutDonatePreviewPack.this.mRoot.closeDialog();
                        }
                    });
                }
            }, 250L);
        }
    }

    @Override
    public void onLayoutClose() {
        if (this.mRoot.isSelectedItemStackEmpty()) {
            return;
        }
        this.mRoot.popSelectedItem();
    }
}
