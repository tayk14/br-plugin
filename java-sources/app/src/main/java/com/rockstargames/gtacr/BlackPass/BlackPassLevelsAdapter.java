package com.rockstargames.gtacr.BlackPass;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.network.LevelsInfoNew;
import com.rockstargames.gtacr.gui.entertainmentSystem.Utils;
import java.util.ArrayList;
import org.json.JSONObject;

public class BlackPassLevelsAdapter extends RecyclerView.Adapter<BlackPassLevelsAdapter.ViewHolder> {
    public boolean IsAwardActive;
    public boolean IsAwardActivePremium;
    public boolean IsStandardTaken;
    BrBlackPass Parent;
    ArrayList<LevelsInfoNew> standardLevels = App.getInstance().getBlackPassItems().getStandartLevel();
    ArrayList<LevelsInfoNew> premiumLevels = App.getInstance().getBlackPassItems().getPremiumLevel();
    int NumLevels = this.standardLevels.size();

    public BlackPassLevelsAdapter(JSONObject json, BrBlackPass parent) {
        this.Parent = parent;
        try {
            boolean z = true;
            this.IsAwardActive = json.getInt("is") != 0;
            if (!this.Parent.ActivePremium || json.getInt(Utils.KEY_GET_ARR_WITH_PLAYERS_START) == 0) {
                z = false;
            }
            this.IsAwardActivePremium = z;
        } catch (Exception unused) {
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bp_pass_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mPosition = position;
        holder.mType = this.standardLevels.get(position).getTypeId();
        holder.mPType = this.premiumLevels.get(position).getTypeId();
        TextView textView = holder.Pos;
        textView.setText("" + (position + 1));
        holder.Circle.setBackgroundResource(R.drawable.oval_red);
        holder.PrevLine.setBackgroundResource(R.drawable.yellow_gradient);
        holder.NextLine.setBackgroundResource(R.drawable.yellow_gradient);
        if (position >= this.Parent.Level - 1) {
            if (position >= this.Parent.Level) {
                holder.Circle.setBackgroundResource(R.drawable.oval_black);
                holder.PrevLine.setBackgroundColor(0);
            }
            holder.NextLine.setBackgroundColor(0);
        }
        SetupItems(holder, position);
    }

    @Override
    public int getItemCount() {
        return this.standardLevels.size();
    }

    void SetupItems(final ViewHolder holder, final int pos) {
        holder.Name.setText(this.standardLevels.get(pos).getName());
        holder.pName.setText(this.premiumLevels.get(pos).getName());
        holder.Frame.setVisibility(0);
        holder.pFrame.setVisibility(0);
        int i = pos + 5000;
        this.Parent.SetupAwardImg(holder.Frame, this.standardLevels.get(pos).getTypeId(), this.standardLevels.get(pos).getAwardId(), this.standardLevels.get(pos).getTexture(), this.standardLevels.get(pos).getRotX() != null ? this.standardLevels.get(pos).getRotX().floatValue() : 20.0f, this.standardLevels.get(pos).getRotY() != null ? this.standardLevels.get(pos).getRotY().floatValue() : 180.0f, this.standardLevels.get(pos).getRotZ() != null ? this.standardLevels.get(pos).getRotZ().floatValue() : 45.0f, i, holder);
        this.Parent.SetupAwardImg(holder.pFrame, this.premiumLevels.get(pos).getTypeId(), this.premiumLevels.get(pos).getAwardId(), this.premiumLevels.get(pos).getTexture(), this.premiumLevels.get(pos).getRotX() != null ? this.standardLevels.get(pos).getRotX().floatValue() : 20.0f, this.premiumLevels.get(pos).getRotY() != null ? this.standardLevels.get(pos).getRotY().floatValue() : 180.0f, this.premiumLevels.get(pos).getRotZ() != null ? this.standardLevels.get(pos).getRotZ().floatValue() : 45.0f, i + 1000, holder);
        holder.Name.setBackgroundResource(R.drawable.bp_yellow_header);
        holder.Name.setTextColor(-16777216);
        holder.pName.setBackgroundResource(R.drawable.bp_yellow_header);
        holder.pName.setTextColor(-16777216);
        holder.Window.setOnClickListener(null);
        holder.pWindow.setOnClickListener(null);
        int i2 = pos + 1;
        if (i2 > this.Parent.Level) {
            holder.Name.setBackgroundResource(R.drawable.bp_header_gray);
            holder.Name.setTextColor(-1);
            holder.Get.setVisibility(4);
            holder.Check.setVisibility(4);
            holder.Lock.setVisibility(0);
            holder.pName.setBackgroundResource(R.drawable.bp_header_gray);
            holder.pName.setTextColor(-1);
            holder.pGet.setVisibility(4);
            holder.pCheck.setVisibility(4);
            holder.pLock.setVisibility(0);
            return;
        }
        if ((i2 == this.Parent.Level || i2 == this.standardLevels.size()) && this.IsAwardActive) {
            holder.Get.setVisibility(0);
            holder.Check.setVisibility(0);
            holder.Lock.setVisibility(4);
            holder.Window.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.startAnimation(BlackPassLevelsAdapter.this.Parent.anim);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            BlackPassLevelsAdapter.this.Parent.ShowPrizeWindow(holder.Frame.getDrawable(), BlackPassLevelsAdapter.this.standardLevels.get(pos).getName(), pos, 0);
                            holder.Get.setVisibility(4);
                            holder.Window.setOnClickListener(null);
                            BlackPassLevelsAdapter.this.IsStandardTaken = true;
                        }
                    }, 250L);
                    view.setOnClickListener(null);
                }
            });
        } else {
            holder.Get.setVisibility(4);
            holder.Check.setVisibility(0);
            holder.Lock.setVisibility(4);
        }
        if (this.Parent.ActivePremium) {
            if (i2 == this.Parent.Level && this.IsAwardActivePremium) {
                holder.pGet.setVisibility(0);
                holder.pCheck.setVisibility(0);
                holder.pLock.setVisibility(4);
                holder.pWindow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        view.startAnimation(BlackPassLevelsAdapter.this.Parent.anim);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                BlackPassLevelsAdapter.this.Parent.ShowPrizeWindow(holder.pFrame.getDrawable(), BlackPassLevelsAdapter.this.premiumLevels.get(pos).getName(), pos, 1);
                                holder.pGet.setVisibility(4);
                                holder.pWindow.setOnClickListener(null);
                                BlackPassLevelsAdapter.this.IsStandardTaken = false;
                            }
                        }, 250L);
                        view.setOnClickListener(null);
                    }
                });
                return;
            }
            holder.pGet.setVisibility(4);
            holder.pCheck.setVisibility(0);
            holder.pLock.setVisibility(4);
            return;
        }
        holder.pName.setBackgroundResource(R.drawable.bp_header_gray);
        holder.pName.setTextColor(-1);
        holder.pName.setText(this.premiumLevels.get(pos).getName());
        holder.pGet.setVisibility(4);
        holder.pCheck.setVisibility(4);
        holder.pLock.setVisibility(0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView Check;
        FrameLayout Circle;
        ImageView Frame;
        TextView Get;
        ImageView Lock;
        TextView Name;
        View NextLine;
        TextView Pos;
        View PrevLine;
        FrameLayout Window;
        int mPType;
        int mPosition;
        int mType;
        ImageView pCheck;
        ImageView pFrame;
        TextView pGet;
        ImageView pLock;
        TextView pName;
        FrameLayout pWindow;

        ViewHolder(View view) {
            super(view);
            //BlackPassLevelsAdapter.this = this$0;
            this.mPType = -1;
            this.mType = -1;
            this.mPosition = -1;
            this.Pos = (TextView) view.findViewById(R.id.bp_ipass_pos);
            this.Name = (TextView) view.findViewById(R.id.bp_ipass_name);
            this.pName = (TextView) view.findViewById(R.id.bp_ipass_pname);
            this.Get = (TextView) view.findViewById(R.id.bp_ipass_get);
            this.pGet = (TextView) view.findViewById(R.id.bp_ipass_pget);
            this.Check = (ImageView) view.findViewById(R.id.bp_ipass_check);
            this.pCheck = (ImageView) view.findViewById(R.id.bp_ipass_pcheck);
            this.Lock = (ImageView) view.findViewById(R.id.bp_ipass_lock);
            this.pLock = (ImageView) view.findViewById(R.id.bp_ipass_plock);
            this.Frame = (ImageView) view.findViewById(R.id.bp_ipass_frame);
            this.pFrame = (ImageView) view.findViewById(R.id.bp_ipass_pframe);
            this.PrevLine = view.findViewById(R.id.bp_ipass_prev_line);
            this.NextLine = view.findViewById(R.id.bp_ipass_next_line);
            this.Circle = (FrameLayout) view.findViewById(R.id.bp_ipass_circle);
            this.Window = (FrameLayout) view.findViewById(R.id.bp_ipass_window);
            this.pWindow = (FrameLayout) view.findViewById(R.id.bp_ipass_pwindow);
        }
    }
}
