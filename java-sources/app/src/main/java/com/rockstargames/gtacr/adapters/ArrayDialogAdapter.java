package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.rockstargames.gtacr.data.ArrayDialog;

import blackrussia.online.*;

import java.util.List;

public class ArrayDialogAdapter extends RecyclerView.Adapter<ArrayDialogAdapter.ArrayDialogHolder> {
    private List<ArrayDialog> lDataDialogMenu;
    private OnUserClickListener onUserClickListener;
    public interface OnUserClickListener {
        void click(ArrayDialog dataDialogMenu, View view);
    }

    public ArrayDialogAdapter(List<ArrayDialog> list, OnUserClickListener onUserClickListener) {
        this.lDataDialogMenu = list;
        this.onUserClickListener = onUserClickListener;
    }

    @Override
    public ArrayDialogHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ArrayDialogHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu_action_item, viewGroup, false));
    }

    public void onBindViewHolder(ArrayDialogHolder ArrayDialogHolder, int i) {
        ArrayDialog dataDialogMenu = this.lDataDialogMenu.get(i);
        ArrayDialogHolder.nameBlockButton.setText(dataDialogMenu.getNameButton());
        ArrayDialogHolder.imageViewBlockButton.setImageResource(dataDialogMenu.getImgDrawableButton());
    }

    @Override
    public int getItemCount() {
        return this.lDataDialogMenu.size();
    }

    public class ArrayDialogHolder extends RecyclerView.ViewHolder {
        ImageView bcgFill;
        ImageView imageViewBlockButton;
        TextView nameBlockButton;

        public ArrayDialogHolder(View view) {
            super(view);
            view.setOnClickListener(view2 -> ArrayDialogAdapter.this.onUserClickListener.click(ArrayDialogAdapter.this.lDataDialogMenu.get(ArrayDialogHolder.this.getLayoutPosition()), view2));
        }
    }
}
