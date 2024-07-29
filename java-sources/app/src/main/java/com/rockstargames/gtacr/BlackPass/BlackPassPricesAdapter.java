package com.rockstargames.gtacr.BlackPass;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import org.json.JSONObject;

public class BlackPassPricesAdapter extends RecyclerView.Adapter<BlackPassPricesAdapter.ViewHolder> {
    BrBlackPass Parent;

    @Override
    public int getItemCount() {
        return 2;
    }

    public void createWindow() {
        this.Parent.showConfirmationDialog(App.getInstance().getBlackPassItems().getLevelPrices(), "Подтверждение", "повысить уровень", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlackPassPricesAdapter.this.Parent.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                v.startAnimation(BlackPassPricesAdapter.this.Parent.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("t", -1);
                            jSONObject.put("ty", 1);
                            jSONObject.put("la", 0);
                            jSONObject.put(GetKeys.GET_PLAYERS_ID, 0);
                            BlackPassPricesAdapter.this.Parent.mGUIManager.sendJsonData(22, jSONObject);
                        } catch (Exception unused) {
                        }
                        BlackPassPricesAdapter.this.Parent.closeDialog();
                    }
                }, 250L);
                v.setOnClickListener(null);
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlackPassPricesAdapter.this.Parent.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                v.startAnimation(BlackPassPricesAdapter.this.Parent.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BlackPassPricesAdapter.this.Parent.closeDialog();
                    }
                }, 250L);
            }
        });
    }

    public BlackPassPricesAdapter(BrBlackPass parent) {
        this.Parent = parent;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bp_level_price, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == 0) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) holder.RootFrame.getLayoutParams();
            layoutParams.width = NvEventQueueActivity.dpToPx((this.Parent.Level * 90) + 45, this.Parent.mContext);
            holder.RootFrame.setLayoutParams(layoutParams);
        } else {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) holder.RootFrame.getLayoutParams();
            layoutParams2.width = NvEventQueueActivity.dpToPx(((App.getInstance().getBlackPassItems().getStandartLevel().size() - this.Parent.Level) * 90) - 45, this.Parent.mContext);
            holder.RootFrame.setLayoutParams(layoutParams2);
        }
        if (position == 0 && this.Parent.Level != 0 && this.Parent.Level < App.getInstance().getBlackPassItems().getStandartLevel().size()) {
            holder.RootFrame.setVisibility(0);
            holder.Text.setText(String.format("%d BC", Integer.valueOf(App.getInstance().getBlackPassItems().getLevelPrices())));
        } else {
            holder.RootFrame.setVisibility(4);
        }
        holder.Frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlackPassPricesAdapter.this.Parent.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                view.startAnimation(BlackPassPricesAdapter.this.Parent.anim);
                BlackPassPricesAdapter.this.createWindow();
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FrameLayout Frame;
        FrameLayout RootFrame;
        TextView Text;

        ViewHolder(View view) {
            super(view);
            //BlackPassPricesAdapter.this = this$0;
            this.RootFrame = (FrameLayout) view.findViewById(R.id.bp_levelprice_root);
            this.Text = (TextView) view.findViewById(R.id.bp_levelprice_text);
            this.Frame = (FrameLayout) view.findViewById(R.id.bp_levelprice_frame);
        }
    }
}
