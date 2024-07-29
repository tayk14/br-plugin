package com.rockstargames.gtacr.BlackPass;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.network.TasksInfoNew;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.common.DialogNoNavBar;
import com.rockstargames.gtacr.gui.entertainmentSystem.GUIEntertainmentSystemKt;
import com.rockstargames.gtacr.gui.inventory.GetKeys;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class BlackPassTasksAdapter extends RecyclerView.Adapter<BlackPassTasksAdapter.ViewHolder> {
    static final int TYPE_ACTIVE = 0;
    static final int TYPE_DONE = 2;
    static final int TYPE_GET = 1;
    static final int TYPE_LOCKED = -1;
    public static int UpdatePos = -1;
    boolean IsMarathon;
    boolean IsPremium;
    BrBlackPass Parent;
    public ArrayList<TasksInfoNew> tasksItems = App.getInstance().getBlackPassItems().getTasks();
    ArrayList<TaskType> tasksTypes = new ArrayList<>();

    public class TaskType {
        int id;
        int num;
        int type;

        TaskType() {
            //BlackPassTasksAdapter.this = this$0;
        }
    }

    public void createAcceptWindow(final int id, final DialogNoNavBar dialog, final int updatePos) {
        this.Parent.showConfirmationDialog(10, "Подтверждение", "сменить данное задание", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlackPassTasksAdapter.this.Parent.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                v.startAnimation(BlackPassTasksAdapter.this.Parent.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BlackPassTasksAdapter.UpdatePos = updatePos;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("t", -1);
                            jSONObject.put("ty", 1);
                            jSONObject.put("la", 1);
                            jSONObject.put(GetKeys.GET_PLAYERS_ID, id);
                            BlackPassTasksAdapter.this.Parent.mGUIManager.sendJsonData(22, jSONObject);
                        } catch (Exception unused) {
                        }
                        BlackPassTasksAdapter.this.Parent.closeDialog();
                        dialog.dismiss();
                    }
                }, 250L);
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlackPassTasksAdapter.this.Parent.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                v.startAnimation(BlackPassTasksAdapter.this.Parent.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BlackPassTasksAdapter.this.Parent.closeDialog();
                    }
                }, 250L);
            }
        });
    }

    void ShowTaskInfo(TasksInfoNew tasksInfo, final int id, final int position, boolean isPremium) {
        final DialogNoNavBar dialogNoNavBar = new DialogNoNavBar(this.Parent.mContext);
        dialogNoNavBar.requestWindowFeature(1);
        dialogNoNavBar.setContentView(R.layout.bp_task);
        dialogNoNavBar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialogNoNavBar.getWindow().setDimAmount(0.4f);
        if (this.IsMarathon) {
            ((TextView) dialogNoNavBar.findViewById(R.id.bp_task_header)).setText("Задание марафона не выполнено");
        } else if (position % 2 != 0) {
            ((TextView) dialogNoNavBar.findViewById(R.id.bp_task_header)).setText("Задание премиума не выполнено");
        } else {
            ((TextView) dialogNoNavBar.findViewById(R.id.bp_task_header)).setText("Задание стандарта не выполнено");
        }
        ((TextView) dialogNoNavBar.findViewById(R.id.bp_task_name)).setText(tasksInfo.getText());
        ((TextView) dialogNoNavBar.findViewById(R.id.bp_task_description)).setText(Html.fromHtml(tasksInfo.getDescription()));
        TextView textView = (TextView) dialogNoNavBar.findViewById(R.id.bp_task_exp);
        StringBuilder sb = new StringBuilder();
        sb.append("+ ");
        sb.append(this.IsMarathon ? 200 : isPremium ? 600 : GUIEntertainmentSystemKt.MIN_TIMER_ENTERTAINMENT_SYSTEM);
        sb.append(" очков сезонного опыта");
        textView.setText(sb.toString());
        ((TextView) dialogNoNavBar.findViewById(R.id.bp_task_coins)).setText("" + tasksInfo.getAward() + " P");
        ((Button) dialogNoNavBar.findViewById(R.id.bp_task_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlackPassTasksAdapter.this.Parent.mContext.getSoundApi().playSound("donate_click_close_sfx");
                view.startAnimation(BlackPassTasksAdapter.this.Parent.anim);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialogNoNavBar.dismiss();
                    }
                }, 250L);
            }
        });
        ((Button) dialogNoNavBar.findViewById(R.id.bp_task_exch)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (BlackPassTasksAdapter.UpdatePos != -1) {
                    return;
                }
                BlackPassTasksAdapter.this.Parent.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                view.startAnimation(BlackPassTasksAdapter.this.Parent.anim);
                BlackPassTasksAdapter blackPassTasksAdapter = BlackPassTasksAdapter.this;
                blackPassTasksAdapter.createAcceptWindow(id, dialogNoNavBar, blackPassTasksAdapter.IsMarathon ? position : position + 5);
            }
        });
        dialogNoNavBar.show();
    }

    public BlackPassTasksAdapter(JSONObject json, BrBlackPass blackPass, boolean isMarathon) {
        this.Parent = blackPass;
        this.IsMarathon = isMarathon;
        try {
            JSONArray jSONArray = json.getJSONArray("pi");
            int i = this.IsMarathon ? 0 : 15;
            while (true) {
                if (i >= (this.IsMarathon ? 15 : jSONArray.length())) {
                    return;
                }
                TaskType taskType = new TaskType();
                taskType.id = jSONArray.getInt(i);
                taskType.type = jSONArray.getInt(i + 1);
                taskType.num = jSONArray.getInt(i + 2);
                this.tasksTypes.add(taskType);
                i += 3;
            }
        } catch (Exception unused) {
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.bp_item_tasks, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
        layoutParams.setMargins(NvEventQueueActivity.dpToPx(5.0f, this.Parent.mContext), NvEventQueueActivity.dpToPx(5.0f, this.Parent.mContext), NvEventQueueActivity.dpToPx(5.0f, this.Parent.mContext), NvEventQueueActivity.dpToPx(0.0f, this.Parent.mContext));
        holder.Available.setLayoutParams(layoutParams);
        if (!this.IsMarathon) {
            this.IsPremium = position % 2 != 0;
            holder.Pos = position / 2;
            int i = this.IsPremium ? holder.Pos + 5 : holder.Pos;
            if (this.IsPremium && !this.Parent.ActivePremium) {
                holder.Available.setVisibility(4);
                holder.Locked.setVisibility(0);
                holder.Butt.setVisibility(4);
                return;
            }
            SetupItem(holder, i, position, this.tasksItems.get(this.tasksTypes.get(i).id));
            return;
        }
        holder.Pos = position;
        SetupItem(holder, position, position, this.tasksItems.get(this.tasksTypes.get(position).id));
    }

    void SetupItem(final ViewHolder holder, final int position, final int pos, final TasksInfoNew taskInfo) {
        holder.Butt.setVisibility(4);
        holder.Available.setOnClickListener(null);
        holder.Available.setVisibility(0);
        holder.Locked.setVisibility(4);
        holder.HeaderText.setText(taskInfo.getType());
        holder.TaskText.setText(taskInfo.getText());
        int i = 600;
        if (this.tasksTypes.get(position).type == 0) {
            holder.Ll.setVisibility(0);
            holder.Refresh.setVisibility(0);
            TextView textView = holder.ProgressText;
            textView.setText("" + this.tasksTypes.get(position).num + " из " + taskInfo.getNum());
            TextView textView2 = holder.ExpsText;
            StringBuilder sb = new StringBuilder();
            sb.append("+");
            if (this.IsMarathon) {
                i = 200;
            } else if (!this.IsPremium) {
                i = GUIEntertainmentSystemKt.MIN_TIMER_ENTERTAINMENT_SYSTEM;
            }
            sb.append(i);
            sb.append(" оч.");
            textView2.setText(sb.toString());
            holder.Header.setBackgroundResource(R.drawable.bp_header_gray);
            holder.HeaderText.setTextColor(-1);
            holder.progressBar.setProgress(0);
            holder.progressBar.setMax(taskInfo.getNum());
            holder.progressBar.setProgress(this.tasksTypes.get(position).num);
            final boolean z = this.IsPremium;
            holder.Available.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BlackPassTasksAdapter.this.Parent.mContext.getSoundApi().playSound("donate_click_in_or_next_sfx");
                    view.startAnimation(BlackPassTasksAdapter.this.Parent.anim);
                    BlackPassTasksAdapter blackPassTasksAdapter = BlackPassTasksAdapter.this;
                    blackPassTasksAdapter.ShowTaskInfo(taskInfo, blackPassTasksAdapter.tasksTypes.get(position).id, pos, z);
                }
            });
            return;
        }
        holder.Ll.setVisibility(8);
        holder.Header.setBackgroundResource(R.drawable.bp_yellow_header);
        holder.Refresh.setVisibility(4);
        holder.HeaderText.setTextColor(-16777216);
        if (this.tasksTypes.get(position).type == 1) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
            layoutParams.setMargins(NvEventQueueActivity.dpToPx(5.0f, this.Parent.mContext), NvEventQueueActivity.dpToPx(5.0f, this.Parent.mContext), NvEventQueueActivity.dpToPx(5.0f, this.Parent.mContext), NvEventQueueActivity.dpToPx(10.0f, this.Parent.mContext));
            holder.Available.setLayoutParams(layoutParams);
            holder.Butt.setVisibility(0);
            if (this.IsMarathon) {
                i = 200;
            } else if (!this.IsPremium) {
                i = GUIEntertainmentSystemKt.MIN_TIMER_ENTERTAINMENT_SYSTEM;
            }
            Button button = holder.Butt;
            button.setText("Получить +" + i + " оч.");
            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Resources resources;
                    int i2;
                    String charSequence;
                    BrBlackPass brBlackPass = BlackPassTasksAdapter.this.Parent;
                    if (taskInfo.getAward() != 0) {
                        resources = BlackPassTasksAdapter.this.Parent.mContext.getResources();
                        i2 = R.drawable.bp_money;
                    } else {
                        resources = BlackPassTasksAdapter.this.Parent.mContext.getResources();
                        i2 = R.drawable.bp_exp;
                    }
                    Drawable drawable = resources.getDrawable(i2);
                    if (taskInfo.getAward() != 0) {
                        charSequence = "" + taskInfo.getAward() + "P";
                    } else {
                        charSequence = holder.ExpsText.getText().toString();
                    }
                    brBlackPass.ShowPrizeWindow(drawable, charSequence, holder.Pos, BlackPassTasksAdapter.this.IsMarathon ? 0 : position >= 5 ? 2 : 1);
                    BlackPassTasksAdapter.this.tasksTypes.get(position).type = 2;
                    holder.Butt.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2, 1);
                    layoutParams2.setMargins(NvEventQueueActivity.dpToPx(5.0f, BlackPassTasksAdapter.this.Parent.mContext), NvEventQueueActivity.dpToPx(5.0f, BlackPassTasksAdapter.this.Parent.mContext), NvEventQueueActivity.dpToPx(5.0f, BlackPassTasksAdapter.this.Parent.mContext), NvEventQueueActivity.dpToPx(0.0f, BlackPassTasksAdapter.this.Parent.mContext));
                    holder.Available.setLayoutParams(layoutParams2);
                    holder.HeaderText.setText("Выполнено");
                    holder.Butt.setOnClickListener(null);
                    holder.Available.setOnClickListener(null);
                }
            };
            holder.Butt.setOnClickListener(onClickListener);
            holder.Available.setOnClickListener(onClickListener);
            return;
        }
        holder.HeaderText.setText("Выполнено");
    }

    @Override
    public int getItemCount() {
        return this.IsMarathon ? 5 : 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout Available;
        Button Butt;
        TextView ExpsText;
        RelativeLayout Header;
        TextView HeaderText;
        LinearLayout Ll;
        LinearLayout Locked;
        int Pos;
        TextView ProgressText;
        ImageView Refresh;
        TextView TaskText;
        ProgressBar progressBar;

        ViewHolder(View view) {
            super(view);
            //BlackPassTasksAdapter.this = this$0;
            this.Locked = (LinearLayout) view.findViewById(R.id.bp_itasks_locked);
            this.Available = (LinearLayout) view.findViewById(R.id.bp_itasks_avaible);
            this.Ll = (LinearLayout) view.findViewById(R.id.bp_itasks_ll);
            this.Header = (RelativeLayout) view.findViewById(R.id.bp_itasks_header);
            this.HeaderText = (TextView) view.findViewById(R.id.bp_itasks_htext);
            this.TaskText = (TextView) view.findViewById(R.id.bp_itasks_text);
            this.ProgressText = (TextView) view.findViewById(R.id.bp_itasks_ptext);
            this.ExpsText = (TextView) view.findViewById(R.id.bp_itasks_etext);
            this.Refresh = (ImageView) view.findViewById(R.id.bp_iatsks_refresh);
            this.progressBar = (ProgressBar) view.findViewById(R.id.bp_itask_progress);
            this.Butt = (Button) view.findViewById(R.id.bp_itasks_butt);
        }
    }
}
