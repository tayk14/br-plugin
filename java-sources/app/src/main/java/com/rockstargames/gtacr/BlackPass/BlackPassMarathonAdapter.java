package com.rockstargames.gtacr.BlackPass;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.network.LevelsInfoNew;
import com.rockstargames.gtacr.GUIManager;
import java.util.ArrayList;
import org.json.JSONObject;

public class BlackPassMarathonAdapter extends RecyclerView.Adapter<BlackPassMarathonAdapter.ViewHolder> {
    public int CurrLevel;
    public boolean IsAwardActive;
    BrBlackPass Parent;
    ArrayList<LevelsInfoNew> marathonLevels = App.getInstance().getBlackPassItems().getMarathonLevel();

    public void ShowAwardWindow(Drawable img, String name) {
        View inflate = ((LayoutInflater) this.Parent.mContext.getSystemService("layout_inflater")).inflate(R.layout.bp_prize, (ViewGroup) null, false);
        final PopupWindow popupWindow = new PopupWindow(inflate, -1, -1, true);
        popupWindow.setAnimationStyle(R.style.PopupWindowAnimation);
        popupWindow.setSoftInputMode(16);
        this.Parent.mGUIManager.setCustomTouchInterceptor(popupWindow);
        GUIManager.hideSystemUI(inflate);
        ((ImageView) inflate.findViewById(R.id.bp_prize_img)).setImageDrawable(img);
        ((TextView) inflate.findViewById(R.id.bp_prize_name)).setText(name);
        ((TextView) inflate.findViewById(R.id.bp_prize_hat)).setText("Награда за марафон");
        ((Button) inflate.findViewById(R.id.bp_prize_get)).setVisibility(4);
        ((Button) inflate.findViewById(R.id.bp_prize_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlackPassMarathonAdapter.this.Parent.mContext.getSoundApi().playSound("donate_click_close_sfx");
                view.startAnimation(BlackPassMarathonAdapter.this.Parent.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        popupWindow.dismiss();
                    }
                }, 250L);
            }
        });
        popupWindow.showAtLocation(this.Parent.mContext.getParentLayout(), 17, 0, 0);
    }

    public BlackPassMarathonAdapter(JSONObject json, BrBlackPass blackPass) {
        this.Parent = blackPass;
        try {
            this.CurrLevel = json.getInt("cl");
            this.IsAwardActive = json.getInt("lt") == 0;
        } catch (Exception unused) {
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bp_item_marathon, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mPosition = position;
        holder.mType = this.marathonLevels.get(position).getTypeId();
        TextView textView = holder.Pos;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        int i = position + 1;
        sb.append(i);
        textView.setText(sb.toString());
        holder.Circle.setBackgroundResource(R.drawable.oval_red);
        holder.PrevLine.setBackgroundResource(R.drawable.yellow_gradient);
        holder.NextLine.setBackgroundResource(R.drawable.yellow_gradient);
        int i2 = this.CurrLevel;
        if (position >= i2 - 1) {
            if (position >= i2) {
                holder.Circle.setBackgroundResource(R.drawable.oval_black);
                holder.PrevLine.setBackgroundColor(-14671574);
            }
            holder.NextLine.setBackgroundColor(-14671574);
        }
        holder.Prize.setVisibility(0);
        this.Parent.SetupAwardImg(holder.Prize, this.marathonLevels.get(position).getTypeId(), this.marathonLevels.get(position).getAwardId(), this.marathonLevels.get(position).getTexture(), this.marathonLevels.get(position).getRotX() != null ? this.marathonLevels.get(position).getRotX().floatValue() : 20.0f, this.marathonLevels.get(position).getRotY() != null ? this.marathonLevels.get(position).getRotY().floatValue() : 180.0f, this.marathonLevels.get(position).getRotZ() != null ? this.marathonLevels.get(position).getRotZ().floatValue() : 45.0f, position + 10000, holder);
        holder.Prize.setOnClickListener(null);
        if (i == this.CurrLevel && this.IsAwardActive) {
            holder.Butt.setVisibility(0);
            Button button = holder.Butt;
            button.setText("Получить " + this.marathonLevels.get(position).getName());
            holder.Name.setVisibility(4);
            holder.Check.setVisibility(0);
            holder.Check.setImageResource(R.drawable.bp_check);
            holder.Butt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.startAnimation(BlackPassMarathonAdapter.this.Parent.anim);
                    BlackPassMarathonAdapter.this.Parent.ShowPrizeWindow(holder.Prize.getDrawable(), BlackPassMarathonAdapter.this.marathonLevels.get(position).getName(), position, -1);
                }
            });
            return;
        }
        holder.Name.setVisibility(0);
        holder.Name.setText(this.marathonLevels.get(position).getName());
        holder.Butt.setVisibility(4);
        if (i > this.CurrLevel) {
            holder.Check.setVisibility(0);
            holder.Check.setImageResource(R.drawable.bp_lock);
            holder.Prize.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.startAnimation(BlackPassMarathonAdapter.this.Parent.anim);
                    BlackPassMarathonAdapter.this.ShowAwardWindow(holder.Prize.getDrawable(), BlackPassMarathonAdapter.this.marathonLevels.get(position).getName());
                }
            });
            return;
        }
        holder.Check.setVisibility(0);
        holder.Check.setImageResource(R.drawable.bp_check);
        holder.Butt.setVisibility(4);
    }

    @Override
    public int getItemCount() {
        return this.marathonLevels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button Butt;
        ImageView Check;
        FrameLayout Circle;
        TextView Name;
        View NextLine;
        TextView Pos;
        View PrevLine;
        ImageView Prize;
        int mPosition;
        int mType;

        ViewHolder(View view) {
            super(view);
            //BlackPassMarathonAdapter.this = this$0;
            this.mType = -1;
            this.mPosition = -1;
            this.Pos = (TextView) view.findViewById(R.id.bp_imarathon_num);
            this.Name = (TextView) view.findViewById(R.id.bp_imarathon_text);
            this.Butt = (Button) view.findViewById(R.id.bp_imarathon_butt);
            this.Prize = (ImageView) view.findViewById(R.id.bp_imarathon_img);
            this.Check = (ImageView) view.findViewById(R.id.bp_imarathon_check);
            this.Circle = (FrameLayout) view.findViewById(R.id.bp_imarathon_circle);
            this.PrevLine = view.findViewById(R.id.bp_imarathon_prev_line);
            this.NextLine = view.findViewById(R.id.bp_imarathon_next_line);
        }
    }
}
