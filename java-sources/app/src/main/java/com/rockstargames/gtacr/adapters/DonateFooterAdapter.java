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

public class DonateFooterAdapter extends RecyclerView.Adapter<DonateFooterAdapter.ViewHolder> {
    private GUIDonate brDonate;
    private ArrayList<FooterButton> items;
    private PageChangedListener listener;
    private int selected = 0;

    public interface PageChangedListener {
        void onPageChanged(int i);
    }

    public class FooterButton {
        public int id;
        public boolean selected = false;
        public String text;

        FooterButton(String text, int id) {
            //DonateFooterAdapter.this = this$0;
            this.text = text;
            this.id = id;
        }
    }

    public void setSelectedPage(int newpage) {
        if (newpage == this.brDonate.getCurrentPage()) {
            return;
        }
        for (int i = 0; i < this.items.size(); i++) {
            FooterButton footerButton = this.items.get(i);
            if (footerButton.selected) {
                footerButton.selected = false;
                notifyItemChanged(i);
            }
        }
        this.selected = newpage;
        this.items.get(newpage).selected = true;
        notifyItemChanged(this.selected);
        this.listener.onPageChanged(this.items.get(this.selected).id);
    }

    public void deselectPage() {
        for (int i = 0; i < this.items.size(); i++) {
            FooterButton footerButton = this.items.get(i);
            if (footerButton.selected) {
                footerButton.selected = false;
                notifyItemChanged(i);
            }
        }
    }

    public DonateFooterAdapter(GUIDonate brDonate, PageChangedListener listener) {
        this.brDonate = null;
        this.items = null;
        this.brDonate = brDonate;
        ArrayList<FooterButton> arrayList = new ArrayList<>();
        this.items = arrayList;
        arrayList.add(new FooterButton("Акции", 0));
        this.items.add(new FooterButton("Транспорт", 1));
        this.items.add(new FooterButton("Скины", 2));
        this.items.add(new FooterButton("Наборы", 3));
        this.items.add(new FooterButton("VIP", 4));
        this.items.add(new FooterButton("Аксессуары", 11));
        this.items.get(0).selected = true;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Button button = new Button(this.brDonate.getNvEvent());
        button.setBackgroundColor(0);
        button.setTypeface(ResourcesCompat.getFont(this.brDonate.getNvEvent(), R.font.muller_bold));
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
                DonateFooterAdapter.this.setSelectedPage(position);
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

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public void next() {
        int i = this.selected + 1;
        this.selected = i;
        if (i >= this.items.size()) {
            this.selected = 0;
        }
        setSelectedPage(this.selected);
    }

    public void previous() {
        int i = this.selected - 1;
        this.selected = i;
        if (i < 0) {
            this.selected = this.items.size() - 1;
        }
        setSelectedPage(this.selected);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            //DonateFooterAdapter.this = this$0;
            this.button = (Button) itemView;
        }
    }
}
