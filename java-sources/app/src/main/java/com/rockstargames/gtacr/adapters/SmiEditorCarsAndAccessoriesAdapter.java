package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.network.SmiInfo;
import java.util.List;

public class SmiEditorCarsAndAccessoriesAdapter extends RecyclerView.Adapter<SmiEditorCarsAndAccessoriesAdapter.DialogSmiHolder> {
    private List<SmiInfo> lCarAndAccessoriesList;
    private OnUserClickCarsAndAccessories onUserClickCarsAndAccessories;

    public interface OnUserClickCarsAndAccessories {
        void userClick(SmiInfo smiInfo, int getPosition);
    }

    public SmiEditorCarsAndAccessoriesAdapter(List<SmiInfo> smiInfoList, OnUserClickCarsAndAccessories onUserClickCarsAndAccessories) {
        this.lCarAndAccessoriesList = smiInfoList;
        this.onUserClickCarsAndAccessories = onUserClickCarsAndAccessories;
    }

    public void setOnlyCheckedElement(int getPosition) {
        for (int i = 0; i < this.lCarAndAccessoriesList.size(); i++) {
            if (i != getPosition && this.lCarAndAccessoriesList.get(i).isChecked()) {
                this.lCarAndAccessoriesList.get(i).setChecked(false);
                notifyItemChanged(i);
            }
        }
    }

    @Override
    public DialogSmiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DialogSmiHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.smi_item, parent, false));
    }

    @Override
    public void onBindViewHolder(DialogSmiHolder holder, int position) {
        SmiInfo smiInfo = this.lCarAndAccessoriesList.get(position);
        holder.nameElement.setText(smiInfo.getName());
        holder.switchCompat.setChecked(smiInfo.isChecked());
    }

    @Override
    public int getItemCount() {
        return this.lCarAndAccessoriesList.size();
    }

    public class DialogSmiHolder extends RecyclerView.ViewHolder {
        TextView nameElement;
        SwitchCompat switchCompat;

        public DialogSmiHolder(View itemView) {
            super(itemView);
            //SmiEditorCarsAndAccessoriesAdapter.this = this$0;
            this.nameElement = (TextView) itemView.findViewById(R.id.name_smi_element);
            SwitchCompat switchCompat = (SwitchCompat) itemView.findViewById(R.id.switch_smi_element);
            this.switchCompat = switchCompat;
            switchCompat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SmiInfo smiInfo = (SmiInfo) SmiEditorCarsAndAccessoriesAdapter.this.lCarAndAccessoriesList.get(DialogSmiHolder.this.getLayoutPosition());
                    if (!smiInfo.isChecked()) {
                        smiInfo.setChecked(true);
                    } else {
                        smiInfo.setChecked(false);
                    }
                    SmiEditorCarsAndAccessoriesAdapter.this.onUserClickCarsAndAccessories.userClick(smiInfo, DialogSmiHolder.this.getLayoutPosition());
                }
            });
        }
    }
}
