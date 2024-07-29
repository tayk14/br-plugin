package com.rockstargames.gtacr.gui;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.network.DonateItem;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.DonateServiceAdapter;
import com.rockstargames.gtacr.adapters.DonateTileAdapter;
import com.rockstargames.gtacr.common.UILayout;

public class UILayoutDonateServices extends UILayout implements DonateServiceAdapter.ServiceChangedListener {
    private GUIDonate mRoot;
    private DonateServiceAdapter mServicesAdapter;
    private RecyclerView mServicesRV;
    private View mTile;
    private DonateTileAdapter.ViewHolder mTileHolder;
    private View mViewRoot = null;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UILayoutDonateServices(GUIDonate root) {
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
        View inflate = inflater.inflate(R.layout.donate_services, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        View findViewById = inflate.findViewById(R.id.tileDonateFrame);
        this.mTile = findViewById;
        this.mTileHolder = new DonateTileAdapter.ViewHolder(findViewById);
        this.mServicesAdapter = new DonateServiceAdapter(this, this);
        RecyclerView recyclerView = (RecyclerView) this.mViewRoot.findViewById(R.id.donateServicesRV);
        this.mServicesRV = recyclerView;
        recyclerView.setAdapter(this.mServicesAdapter);
        this.mServicesRV.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mTileHolder.subHeader.setVisibility(8);
        this.mTileHolder.button.setCompoundDrawablesWithIntrinsicBounds(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.basket_icon, null), (Drawable) null, (Drawable) null, (Drawable) null);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTileHolder.header.getLayoutParams();
        layoutParams.topMargin = NvEventQueueActivity.dpToPx(20.0f, getContext());
        this.mTileHolder.header.setLayoutParams(layoutParams);
        return this.mViewRoot;
    }

    @Override
    public void onServiceChanged(DonateItem newService) {
        this.mRoot.prepareItemTile(this.mTileHolder, newService, 4);
    }
}
