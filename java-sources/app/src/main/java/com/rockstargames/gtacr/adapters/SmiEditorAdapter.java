package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.rockstargames.gtacr.data.DataSmiInfoAll;
import java.util.List;

public class SmiEditorAdapter extends RecyclerView.Adapter<SmiEditorAdapter.DialogSmiHolder> {
    private final int column;
    private final List<DataSmiInfoAll> lDataSmiInfoAll;
    private final OnUserClickListenerSmiEditor onUserClickListenerSmiEditor;

    public interface OnUserClickListenerSmiEditor {
        void clickable(DataSmiInfoAll dataSmiInfoAll, int getPosition, int getColumn);
    }

    public SmiEditorAdapter(List<DataSmiInfoAll> dataSmiInfoAll, OnUserClickListenerSmiEditor onUserClickListenerSmiEditor, int column) {
        this.lDataSmiInfoAll = dataSmiInfoAll;
        this.onUserClickListenerSmiEditor = onUserClickListenerSmiEditor;
        this.column = column;
    }

    @Override
    public DialogSmiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DialogSmiHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.smi_item, parent, false));
    }

    @Override
    public void onBindViewHolder(DialogSmiHolder holder, int position) {
        holder.nameElement.setText(this.lDataSmiInfoAll.get(position).getNameSmiElement());
        holder.switchCompat.setChecked(this.lDataSmiInfoAll.get(position).getCheckedSwitchSmiElement());
    }

    @Override
    public int getItemCount() {
        return this.lDataSmiInfoAll.size();
    }

    public void setOnlyCheckedElement(int getPosition) {
        for (int i = 0; i < this.lDataSmiInfoAll.size(); i++) {
            if (i != getPosition && this.lDataSmiInfoAll.get(i).getCheckedSwitchSmiElement()) {
                this.lDataSmiInfoAll.get(i).setCheckedSwitchSmiElement(false);
                notifyItemChanged(i);
            }
        }
    }

    public class DialogSmiHolder extends RecyclerView.ViewHolder {
        TextView nameElement;
        SwitchCompat switchCompat;

        public DialogSmiHolder(View itemView) {
            super(itemView);
            //SmiEditorAdapter.this = this$0;
            this.nameElement = (TextView) itemView.findViewById(R.id.name_smi_element);
            SwitchCompat switchCompat = (SwitchCompat) itemView.findViewById(R.id.switch_smi_element);
            this.switchCompat = switchCompat;
            switchCompat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DataSmiInfoAll dataSmiInfoAll = (DataSmiInfoAll) SmiEditorAdapter.this.lDataSmiInfoAll.get(DialogSmiHolder.this.getLayoutPosition());
                    if (!dataSmiInfoAll.getCheckedSwitchSmiElement()) {
                        dataSmiInfoAll.setCheckedSwitchSmiElement(true);
                    } else {
                        dataSmiInfoAll.setCheckedSwitchSmiElement(false);
                    }
                    SmiEditorAdapter.this.onUserClickListenerSmiEditor.clickable(dataSmiInfoAll, DialogSmiHolder.this.getLayoutPosition(), SmiEditorAdapter.this.column);
                }
            });
        }
    }
}
