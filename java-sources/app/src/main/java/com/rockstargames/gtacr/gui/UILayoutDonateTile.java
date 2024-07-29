package com.rockstargames.gtacr.gui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.network.DonateItem;
import com.kingfisher.easyviewindicator.AnyViewIndicator;
import com.rockstargames.gtacr.adapters.DonateTileAdapter;
import com.rockstargames.gtacr.common.CenterItemLayoutManager;
import com.rockstargames.gtacr.common.UILayout;

public class UILayoutDonateTile extends UILayout {
    private Button mButtonBack;
    private GUIDonate mRoot;
    private DonateTileAdapter mTileAdapter;
    private AnyViewIndicator mTileIndicator;
    private RecyclerView mTileRV;
    private View mViewRoot = null;
    private TextView mPageHeaderText = null;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UILayoutDonateTile(GUIDonate root) {
        this.mRoot = null;
        this.mRoot = root;
    }

    public GUIDonate getDonate() {
        return this.mRoot;
    }

    public void updateItem(DonateItem item) {
        this.mTileAdapter.updatedItem(item);
    }

    public void updateAll() {
        this.mTileAdapter.updateAll();
    }

    public void updateEndedTiles() {
        this.mTileAdapter.updateEndedTiles();
    }

    public void updateSurprise(int time) {
        this.mTileAdapter.updateSurprise(time);
    }

    private void prepareTitles() {
        this.mTileRV = (RecyclerView) this.mViewRoot.findViewById(R.id.mainRV);
        this.mTileIndicator = (AnyViewIndicator) this.mViewRoot.findViewById(R.id.rvIndicator);
        DonateTileAdapter donateTileAdapter = new DonateTileAdapter(this);
        this.mTileAdapter = donateTileAdapter;
        this.mTileRV.setAdapter(donateTileAdapter);
        this.mTileRV.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                UILayoutDonateTile.this.mTileRV.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                UILayoutDonateTile.this.mTileRV.setLayoutManager(new CenterItemLayoutManager(UILayoutDonateTile.this.getContext(), 0, UILayoutDonateTile.this.mRoot.getItemWidth(), UILayoutDonateTile.this.mTileRV.getWidth(), UILayoutDonateTile.this.mTileAdapter.getItemCount()));
            }
        });
        int ceil = (int) Math.ceil(Double.valueOf(this.mTileAdapter.getItemCount() - 1).doubleValue() / 4.0d);
        this.mTileIndicator.setItemCount(ceil);
        if (ceil == 1) {
            this.mTileIndicator.setVisibility(4);
        } else {
            this.mTileIndicator.setVisibility(0);
        }
        this.mTileIndicator.setCurrentPosition(0);
        this.mTileRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int oldpage = -1;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState != 0) {
                    return;
                }
                int ceil2 = (int) (Math.ceil(Double.valueOf(((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition()).doubleValue() / 4.0d) - 1.0d);
                if (this.oldpage != ceil2) {
                    UILayoutDonateTile.this.mTileIndicator.setCurrentPosition(ceil2);
                }
                this.oldpage = ceil2;
            }
        });
    }

    @Override
    public View getView() {
        return this.mViewRoot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.donate_tiles, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        this.mPageHeaderText = (TextView) inflate.findViewById(R.id.donateTextHeader);
        Button button = (Button) this.mViewRoot.findViewById(R.id.donateButtonBack);
        this.mButtonBack = button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DonateItem selectedItem = UILayoutDonateTile.this.mRoot.getSelectedItem();
                UILayoutDonateTile.this.getDonate().getNvEvent().getSoundApi().playSound("donate_click_back_sfx");
                UILayoutDonateTile.this.mRoot.setCurrentPage(selectedItem.getCategory());
            }
        });
        prepareTitles();
        return this.mViewRoot;
    }

    private void updatePageText() {
        int currentPage = this.mRoot.getCurrentPage();
        if (currentPage == 0) {
            this.mPageHeaderText.setText("Акции и спецпредложения");
        } else if (currentPage == 1) {
            this.mPageHeaderText.setText("Транспорт");
        } else if (currentPage == 2) {
            this.mPageHeaderText.setText("Скины");
        } else if (currentPage == 3) {
            this.mPageHeaderText.setText("Наборы");
        } else if (currentPage == 4) {
            this.mPageHeaderText.setText("VIP пакеты");
        } else if (currentPage == 6) {
            this.mPageHeaderText.setText("Денежные пакеты");
        } else if (currentPage != 11) {
        } else {
            this.mPageHeaderText.setText("Аксессуары");
        }
    }

    public void onPageChanged(int i) {
        if (this.mButtonBack.getVisibility() == 0 && i < 5) {
            this.mRoot.popSelectedItem();
        }
        if (i == 7 || i == 9) {
            this.mButtonBack.setVisibility(0);
        } else {
            this.mButtonBack.setVisibility(8);
        }
        this.mTileAdapter.notifyDataSetChanged();
        int ceil = (int) Math.ceil(Double.valueOf(this.mTileAdapter.getItemCount() - 1).doubleValue() / 4.0d);
        this.mTileIndicator.setItemCount(ceil);
        if (ceil == 1) {
            this.mTileIndicator.setVisibility(4);
        } else {
            this.mTileIndicator.setVisibility(0);
        }
        updatePageText();
    }
}
