package com.rockstargames.gtacr.adapters;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.network.DonateItem;
import com.rockstargames.gtacr.gui.GUIDonate;
import com.rockstargames.gtacr.gui.UILayoutDonateTile;
import java.util.ArrayList;

public class DonateTileAdapter extends RecyclerView.Adapter<DonateTileAdapter.ViewHolder> {
    private ArrayList<DonateItem> carPacks;
    private DisplayMetrics displayMetrics;
    private ArrayList<DonateItem> donateAccesories;
    private ArrayList<DonateItem> donateCars;
    private ArrayList<DonateItem> donatePacks;
    private ArrayList<DonateItem> donateSales;
    private ArrayList<DonateItem> donateSkins;
    private ArrayList<DonateItem> donateVips;
    private UILayoutDonateTile mLayout;
    private ArrayList<DonateItem> moneyPacks;
    private ArrayList<DonateItem> vipPacks;

    public void updatedItem(DonateItem item) {
        if (item.getType().intValue() == this.mLayout.getDonate().getCurrentPage()) {
            notifyItemChanged(item.getAssignedId());
        }
        if (this.mLayout.getDonate().getCurrentPage() == 0) {
            for (int i = 0; i < this.donateSales.size(); i++) {
                notifyItemChanged(i);
            }
        }
    }

    public void updateSurprise(int time) {
        this.donateSales.get(0).setSaleTime(time);
        if (this.mLayout.getDonate().getCurrentPage() == 0) {
            notifyItemChanged(0);
        }
    }

    public void updateAll() {
        notifyDataSetChanged();
    }

    public void updateEndedTiles() {
        int limitItemOffset;
        int limitItemOffset2;
        int limitItemOffset3;
        int limitItemOffset4;
        int limitItemOffset5;
        int limitItemOffset6;
        int limitItemOffset7;
        int limitItemOffset8;
        int limitItemOffset9;
        int i = 0;
        if (this.donateSales != null) {
            int i2 = 0;
            while (i2 < this.donateSales.size()) {
                DonateItem donateItem = this.donateSales.get(i2);
                if (donateItem != null && donateItem.getInternalId() != null && (limitItemOffset9 = this.mLayout.getDonate().getLimitItemOffset(donateItem.getInternalId().intValue())) >= 0 && this.mLayout.getDonate().getLimits()[limitItemOffset9 + 1] == 0) {
                    this.donateSales.remove(donateItem);
                    i2--;
                }
                i2++;
            }
        }
        if (this.donateCars != null) {
            int i3 = 0;
            while (i3 < this.donateCars.size()) {
                DonateItem donateItem2 = this.donateCars.get(i3);
                if (donateItem2 != null && donateItem2.getInternalId() != null && (limitItemOffset8 = this.mLayout.getDonate().getLimitItemOffset(donateItem2.getInternalId().intValue())) >= 0 && this.mLayout.getDonate().getLimits()[limitItemOffset8 + 1] == 0) {
                    this.donateCars.remove(donateItem2);
                    i3--;
                }
                i3++;
            }
        }
        if (this.donateSkins != null) {
            int i4 = 0;
            while (i4 < this.donateSkins.size()) {
                DonateItem donateItem3 = this.donateSkins.get(i4);
                if (donateItem3 != null && donateItem3.getInternalId() != null && (limitItemOffset7 = this.mLayout.getDonate().getLimitItemOffset(donateItem3.getInternalId().intValue())) >= 0 && this.mLayout.getDonate().getLimits()[limitItemOffset7 + 1] == 0) {
                    this.donateSkins.remove(donateItem3);
                    i4--;
                }
                i4++;
            }
        }
        if (this.donatePacks != null) {
            int i5 = 0;
            while (i5 < this.donatePacks.size()) {
                DonateItem donateItem4 = this.donatePacks.get(i5);
                if (donateItem4 != null && donateItem4.getInternalId() != null && (limitItemOffset6 = this.mLayout.getDonate().getLimitItemOffset(donateItem4.getInternalId().intValue())) >= 0 && this.mLayout.getDonate().getLimits()[limitItemOffset6 + 1] == 0) {
                    this.donatePacks.remove(donateItem4);
                    i5--;
                }
                i5++;
            }
        }
        if (this.donateVips != null) {
            int i6 = 0;
            while (i6 < this.donateVips.size()) {
                DonateItem donateItem5 = this.donateVips.get(i6);
                if (donateItem5 != null && donateItem5.getInternalId() != null && (limitItemOffset5 = this.mLayout.getDonate().getLimitItemOffset(donateItem5.getInternalId().intValue())) >= 0 && this.mLayout.getDonate().getLimits()[limitItemOffset5 + 1] == 0) {
                    this.donateVips.remove(donateItem5);
                    i6--;
                }
                i6++;
            }
        }
        if (this.moneyPacks != null) {
            int i7 = 0;
            while (i7 < this.moneyPacks.size()) {
                DonateItem donateItem6 = this.moneyPacks.get(i7);
                if (donateItem6 != null && donateItem6.getInternalId() != null && (limitItemOffset4 = this.mLayout.getDonate().getLimitItemOffset(donateItem6.getInternalId().intValue())) >= 0 && this.mLayout.getDonate().getLimits()[limitItemOffset4 + 1] == 0) {
                    this.moneyPacks.remove(donateItem6);
                    i7--;
                }
                i7++;
            }
        }
        if (this.vipPacks != null) {
            int i8 = 0;
            while (i8 < this.vipPacks.size()) {
                DonateItem donateItem7 = this.vipPacks.get(i8);
                if (donateItem7 != null && donateItem7.getInternalId() != null && (limitItemOffset3 = this.mLayout.getDonate().getLimitItemOffset(donateItem7.getInternalId().intValue())) >= 0 && this.mLayout.getDonate().getLimits()[limitItemOffset3 + 1] == 0) {
                    this.vipPacks.remove(donateItem7);
                    i8--;
                }
                i8++;
            }
        }
        if (this.carPacks != null) {
            int i9 = 0;
            while (i9 < this.carPacks.size()) {
                DonateItem donateItem8 = this.carPacks.get(i9);
                if (donateItem8 != null && donateItem8.getInternalId() != null && (limitItemOffset2 = this.mLayout.getDonate().getLimitItemOffset(donateItem8.getInternalId().intValue())) >= 0 && this.mLayout.getDonate().getLimits()[limitItemOffset2 + 1] == 0) {
                    this.carPacks.remove(donateItem8);
                    i9--;
                }
                i9++;
            }
        }
        if (this.donateAccesories != null) {
            while (i < this.donateAccesories.size()) {
                DonateItem donateItem9 = this.donateAccesories.get(i);
                if (donateItem9 != null && donateItem9.getInternalId() != null && (limitItemOffset = this.mLayout.getDonate().getLimitItemOffset(donateItem9.getInternalId().intValue())) >= 0 && this.mLayout.getDonate().getLimits()[limitItemOffset + 1] == 0) {
                    this.donateAccesories.remove(donateItem9);
                    i--;
                }
                i++;
            }
        }
    }

    public DonateTileAdapter(UILayoutDonateTile r7) {
        org.json.JSONArray r2;
        //int r7;
        org.json.JSONArray r0 = null;
        /*r6.mLayout = null;
        r6.donateSales = null;
        r6.donateCars = null;
        r6.donateSkins = null;
        r6.donatePacks = null;
        r6.donateVips = null;
        r6.moneyPacks = null;
        r6.vipPacks = null;
        r6.carPacks = null;
        r6.donateAccesories = null;
        r6.mLayout = r7;
        r6.donateSales = new java.util.ArrayList<>();
        r6.donateCars = new java.util.ArrayList<>();
        r6.donateSkins = new java.util.ArrayList<>();
        r6.donatePacks = new java.util.ArrayList<>();
        r6.donateVips = new java.util.ArrayList<>();
        r6.moneyPacks = new java.util.ArrayList<>();
        r6.vipPacks = new java.util.ArrayList<>();
        r6.carPacks = new java.util.ArrayList<>();
        r6.donateAccesories = new java.util.ArrayList<>();*/
        ArrayList<blackrussia.online.network.DonateItem> r1 = blackrussia.online.App.getInstance().getDonateItems();
        org.json.JSONObject r7i = r7.getDonate().getJson();
        try {
            r2 = r7i.getJSONArray("s");
            try {
                r0 = r7i.getJSONArray("i");
            } catch (Exception e) {
                //r3 = e;
                com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance().log(r7.toString());
                //com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance().recordException(r3);
                blackrussia.online.network.DonateItem r3 = new blackrussia.online.network.DonateItem();
                r3.setUpTag(100);
                r3.setSaleTime(r7i.optInt(com.rockstargames.gtacr.gui.tuning.TuningConstants.KEY_GET_ID_DETAIL));
                //r6.donateSales.add(r3);
                blackrussia.online.network.DonateItem r7j = new blackrussia.online.network.DonateItem();
                r7j.setUpTag(200);
                //r6.moneyPacks.add(r7);
                if (r0 != null) {
                }
                if (r2 != null) {
                }
                //while (r7 < r1.size()) {
                //}
            }
        } catch (Exception e) {
            //r3 = e;
            r2 = null;
        }
        blackrussia.online.network.DonateItem r3 = new blackrussia.online.network.DonateItem();
        r3.setUpTag(100);
        r3.setSaleTime(r7i.optInt(com.rockstargames.gtacr.gui.tuning.TuningConstants.KEY_GET_ID_DETAIL));
        //r6.donateSales.add(r3);
        blackrussia.online.network.DonateItem r7x = new blackrussia.online.network.DonateItem();
        r7x.setUpTag(200);
        //r6.moneyPacks.add(r7);
        if (r0 != null) {
            for (int r3i = 0; r3i < r0.length(); r3i += 2) {
                blackrussia.online.network.DonateItem r4 = GUIDonate.getItemFromInternalId(r0.optInt(r3i));
                if (r4 != null) {
                    r4.setUpTag(r0.optInt(r3i + 1));
                }
            }
        }
        if (r2 != null) {
            for (int r0k = 0; r0k < r2.length(); r0k += 3) {
                blackrussia.online.network.DonateItem r3j = GUIDonate.getItemFromInternalId(r2.optInt(r0k));
                if (r3 != null) {
                    r3.setSaleTime(r2.optInt(r0k + 1));
                    r3.setSalePercent(r2.optInt(r0k + 2));
                    //r6.donateSales.add(r3);
                }
            }
        }
        /*for (r7 = 0; r7 < r1.size(); r7++) {
            blackrussia.online.network.DonateItem r0 = r1.get(r7);
            int r2 = r6.mLayout.getDonate().getLimitItemOffset(r0.getInternalId().intValue());
            if (r0 != null && ((r0.getClosed() == null || r0.getClosed().intValue() == 0) && (r2 < 0 || r6.mLayout.getDonate().getLimits()[r2 + 1] != 0))) {
                int r2 = r0.getType().intValue();
                if (r2 == 0) {
                    r6.donateSales.add(r0);
                    r0.setAssignedId(r6.donateSales.size() - 1);
                } else if (r2 == 1) {
                    r6.donateCars.add(r0);
                    r0.setAssignedId(r6.donateCars.size() - 1);
                } else if (r2 == 2) {
                    r6.donateSkins.add(r0);
                    r0.setAssignedId(r6.donateSkins.size() - 1);
                } else if (r2 == 3) {
                    r6.donatePacks.add(r0);
                    r0.setAssignedId(r6.donatePacks.size() - 1);
                } else if (r2 == 4) {
                    r6.donateVips.add(r0);
                    r0.setAssignedId(r6.donateVips.size() - 1);
                } else if (r2 == 6) {
                    r6.moneyPacks.add(r0);
                    r0.setAssignedId(r6.moneyPacks.size() - 1);
                } else if (r2 == 7) {
                    r6.carPacks.add(r0);
                    r0.setAssignedId(r6.carPacks.size() - 1);
                } else if (r2 == 9) {
                    r6.vipPacks.add(r0);
                    r0.setAssignedId(r6.vipPacks.size() - 1);
                } else if (r2 == 11) {
                    r6.donateAccesories.add(r0);
                    r0.setAssignedId(r6.donateAccesories.size() - 1);
                }
            }
        }*/
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.donate_tile, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DonateItem donateItem;
        int currentPage = this.mLayout.getDonate().getCurrentPage();
        if (currentPage == 0) {
            donateItem = this.donateSales.get(position);
        } else if (currentPage == 1) {
            donateItem = this.donateCars.get(position);
        } else if (currentPage == 2) {
            donateItem = this.donateSkins.get(position);
        } else if (currentPage == 3) {
            donateItem = this.donatePacks.get(position);
        } else if (currentPage == 4) {
            donateItem = this.donateVips.get(position);
        } else if (currentPage == 6) {
            donateItem = this.moneyPacks.get(position);
        } else if (currentPage == 7) {
            donateItem = GUIDonate.getItemFromInternalId(this.mLayout.getDonate().getSelectedItem().getContains().get(position).intValue());
        } else if (currentPage == 9) {
            donateItem = GUIDonate.getItemFromInternalId(this.mLayout.getDonate().getSelectedItem().getContains().get(position).intValue());
        } else {
            donateItem = currentPage != 11 ? null : this.donateAccesories.get(position);
        }
        this.mLayout.getDonate().prepareItemTile(holder, donateItem, position);
        ViewGroup.LayoutParams layoutParams = holder.tileDonateFrame.getLayoutParams();
        layoutParams.width = this.mLayout.getDonate().getItemWidth();
        holder.tileDonateFrame.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        int currentPage = this.mLayout.getDonate().getCurrentPage();
        if (currentPage != 0) {
            if (currentPage != 1) {
                if (currentPage != 2) {
                    if (currentPage != 3) {
                        if (currentPage != 4) {
                            if (currentPage != 6) {
                                if (currentPage != 7) {
                                    if (currentPage != 9) {
                                        if (currentPage != 11) {
                                            return 1;
                                        }
                                        return this.donateAccesories.size();
                                    }
                                    return this.mLayout.getDonate().getSelectedItem().getContains().size();
                                }
                                return this.mLayout.getDonate().getSelectedItem().getContains().size();
                            }
                            return this.moneyPacks.size();
                        }
                        return this.donateVips.size();
                    }
                    return this.donatePacks.size();
                }
                return this.donateSkins.size();
            }
            return this.donateCars.size();
        }
        return this.donateSales.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView additionaHeader;
        public TextView badgePercent;
        public TextView badgeText;
        public TextView badgeTime;
        public Button button;
        public TextView donateSupriseTime;
        public TextView header;
        public ImageView imageView;
        public ViewGroup layoutDefault;
        public ViewGroup layoutSuprise;
        public TextView limitCount;
        public LinearLayout limitLayout;
        public TextView newBadge;
        public TextView price;
        public TextView priceStroked;
        public RelativeLayout relativeHeaderTitle;
        public TextView subHeader;
        public FrameLayout tileDonateFrame;

        public ViewHolder(View itemView) {
            super(itemView);
            this.relativeHeaderTitle = (RelativeLayout) itemView.findViewById(R.id.relative_header_tile);
            this.donateSupriseTime = (TextView) itemView.findViewById(R.id.donateSupriseTime);
            this.tileDonateFrame = (FrameLayout) itemView.findViewById(R.id.tileDonateFrame);
            this.layoutDefault = (ViewGroup) itemView.findViewById(R.id.linear_layout_default);
            this.layoutSuprise = (ViewGroup) itemView.findViewById(R.id.linear_layout_surprise);
            this.header = (TextView) itemView.findViewById(R.id.brDonateTileHeader);
            this.subHeader = (TextView) itemView.findViewById(R.id.brDonateTileSubheader);
            this.imageView = (ImageView) itemView.findViewById(R.id.brDonateTileImage);
            this.button = (Button) itemView.findViewById(R.id.donate_button);
            this.price = (TextView) itemView.findViewById(R.id.donatePrice);
            this.priceStroked = (TextView) itemView.findViewById(R.id.donatePriceStroked);
            this.badgeText = (TextView) itemView.findViewById(R.id.donateBadgeText);
            this.badgeTime = (TextView) itemView.findViewById(R.id.donateBadgeTime);
            this.badgePercent = (TextView) itemView.findViewById(R.id.donateBadgePercent);
            this.additionaHeader = (TextView) itemView.findViewById(R.id.brAdditionalDonate);
            this.newBadge = (TextView) itemView.findViewById(R.id.donateBadgeNew);
            this.limitLayout = (LinearLayout) itemView.findViewById(R.id.donateLimitLL);
            this.limitCount = (TextView) itemView.findViewById(R.id.donateLimitCount);
        }
    }
}
