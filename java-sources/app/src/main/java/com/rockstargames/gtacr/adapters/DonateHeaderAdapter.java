package com.rockstargames.gtacr.adapters;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.rockstargames.gtacr.gui.GUIDonate;
import java.util.ArrayList;

public class DonateHeaderAdapter extends RecyclerView.Adapter<DonateHeaderAdapter.ViewHolder> {
    private GUIDonate brDonate;
    private ArrayList<FooterButton> items;
    private LayoutChangedListener listener;
    private int selected = 0;

    public interface LayoutChangedListener {
        void onLayoutChanged(int i);
    }

    public class FooterButton {
        public boolean selected = false;
        public String text;

        FooterButton(String text) {
            //DonateHeaderAdapter.this = this$0;
            this.text = text;
        }
    }

    public int getSelectedPage() {
        return this.selected;
    }

    public void setNewPage(int newpage) {
        int i = this.selected;
        if (i == newpage) {
            return;
        }
        if (i != -1) {
            this.items.get(i).selected = false;
            notifyItemChanged(this.selected);
        }
        this.selected = newpage;
        this.items.get(newpage).selected = true;
        notifyItemChanged(this.selected);
        this.listener.onLayoutChanged(newpage);
    }

    public DonateHeaderAdapter(GUIDonate brDonate, LayoutChangedListener listener) {
        this.items = null;
        this.listener = null;
        this.brDonate = brDonate;
        ArrayList<FooterButton> arrayList = new ArrayList<>();
        this.items = arrayList;
        arrayList.add(new FooterButton("Товары"));
        this.items.add(new FooterButton("Услуги"));
        this.items.add(new FooterButton("Black Pass"));
        this.items.add(new FooterButton("Кейсы"));
        this.items.get(0).selected = true;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Button button = new Button(this.brDonate.getNvEvent());
        button.setBackgroundColor(0);
        button.setTypeface(ResourcesCompat.getFont(this.brDonate.getNvEvent(), R.font.muller_bold));
        button.setTextSize(2, 9.0f);
        button.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return new ViewHolder(button);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        FooterButton footerButton = this.items.get(position);
        holder.button.setText(footerButton.text);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DonateHeaderAdapter.this.setNewPage(position);
            }
        });
        if (footerButton.selected) {
            holder.button.setTextColor(Color.parseColor("#FFFFFF"));
            holder.button.setBackgroundColor(Color.parseColor("#E2310C"));
            return;
        }
        holder.button.setTextColor(Color.parseColor("#6D6D6D"));
        holder.button.setBackgroundColor(0);
    }

    public void next() {
        int i = this.selected;
        if (i == -1) {
            return;
        }
        int i2 = i + 1;
        if (i2 >= this.items.size()) {
            i2 = 0;
        }
        setNewPage(i2);
    }

    public void previous() {
        int i = this.selected;
        if (i == -1) {
            return;
        }
        int i2 = i - 1;
        if (i2 < 0) {
            i2 = this.items.size() - 1;
        }
        setNewPage(i2);
    }

    public void deselectItem() {
        int i = this.selected;
        if (i != -1) {
            this.items.get(i).selected = false;
            notifyItemChanged(this.selected);
        }
        this.selected = -1;
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            //DonateHeaderAdapter.this = this$0;
            this.button = (Button) itemView;
        }
    }
}
