package com.rockstargames.gtacr.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.HintItemBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.data.HintQuestData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/rockstargames/gtacr/adapters/TutorialAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/TutorialAdapter$ViewHolder;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "questsList", "", "Lcom/rockstargames/gtacr/data/HintQuestData;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Ljava/util/List;)V", "binding", "Lblackrussia/online/databinding/HintItemBinding;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TutorialAdapter extends RecyclerView.Adapter<TutorialAdapter.ViewHolder> {
    private HintItemBinding binding;
    private final NvEventQueueActivity context;
    private final List<HintQuestData> questsList;

    public TutorialAdapter(NvEventQueueActivity context, List<HintQuestData> questsList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(questsList, "questsList");
        this.context = context;
        this.questsList = questsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        HintItemBinding inflate = HintItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        return new ViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.questsList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.questsList.size();
    }

    //@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/rockstargames/gtacr/adapters/TutorialAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/HintItemBinding;", "(Lcom/rockstargames/gtacr/adapters/TutorialAdapter;Lblackrussia/online/databinding/HintItemBinding;)V", "bind", "", "quest", "Lcom/rockstargames/gtacr/data/HintQuestData;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final HintItemBinding binding;
        final TutorialAdapter this$0;

        public ViewHolder(TutorialAdapter this$0, HintItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(HintQuestData quest) {
            Intrinsics.checkNotNullParameter(quest, "quest");
            HintItemBinding hintItemBinding = this.binding;
            TutorialAdapter tutorialAdapter = this.this$0;
            Drawable mutate = hintItemBinding.hintProgressQuest.getProgressDrawable().mutate();
            Intrinsics.checkNotNullExpressionValue(mutate, "this.hintProgressQuest.progressDrawable.mutate()");
            if (quest.getIfMainQuest()) {
                mutate.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(R.color.color_FFDE67, BlendModeCompat.SRC_ATOP));
                hintItemBinding.hintProgressQuest.setProgressDrawable(mutate);
            } else {
                mutate.setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(R.color.diving_school_green_text_color, BlendModeCompat.SRC_ATOP));
                hintItemBinding.hintProgressQuest.setProgressDrawable(mutate);
            }
            hintItemBinding.hintTitleAdditionalQuestItem.setText(quest.getQuestsText());
            hintItemBinding.hintStatusQuest.setText(tutorialAdapter.context.getString(R.string.hint_quests_value, new Object[]{String.valueOf(quest.getThisQuestsStatus()), String.valueOf(quest.getMaxQuestsStatus())}));
            if (quest.getThisQuestsStatus() == quest.getMaxQuestsStatus()) {
                hintItemBinding.hintTitleAdditionalQuestItem.setPaintFlags(hintItemBinding.hintTitleAdditionalQuestItem.getPaintFlags() | 16);
            }
            hintItemBinding.hintProgressQuest.setMax(quest.getMaxQuestsStatus());
            hintItemBinding.hintProgressQuest.setProgress(quest.getThisQuestsStatus());
        }
    }
}
