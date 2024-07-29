package com.rockstargames.gtacr.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.DrivingSchoolQuestionsItemBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.DrivingSchoolAnswersAdapter;
import com.rockstargames.gtacr.data.DrivingAnswer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001bB]\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012>\u0010\b\u001a:\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tj\u0004\u0018\u0001`\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\rH\u0016J\u001c\u0010\u0013\u001a\u00020\u000f2\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000RF\u0010\b\u001a:\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tj\u0004\u0018\u0001`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/rockstargames/gtacr/adapters/DrivingSchoolAnswersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/DrivingSchoolAnswersAdapter$ViewHolder;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "answers", "", "Lcom/rockstargames/gtacr/data/DrivingAnswer;", "onAnswerClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "", "position", "", "Lcom/rockstargames/gtacr/gui/drivingSchool/OnAnswerClickListener;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnlyItemCheck", "thisPosition", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DrivingSchoolAnswersAdapter extends RecyclerView.Adapter<DrivingSchoolAnswersAdapter.ViewHolder> {
    private final List<DrivingAnswer> answers;
    private final NvEventQueueActivity context;
    private final Function2<DrivingAnswer, Integer, Unit> onAnswerClickListener;

    public DrivingSchoolAnswersAdapter(NvEventQueueActivity nvEventQueueActivity, List<DrivingAnswer> answers, Function2<? super DrivingAnswer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(answers, "answers");
        this.context = nvEventQueueActivity;
        this.answers = answers;
        this.onAnswerClickListener = (Function2<DrivingAnswer, Integer, Unit>) function2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        DrivingSchoolQuestionsItemBinding inflate = DrivingSchoolQuestionsItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f…           parent, false)");
        return new ViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.answers.get(i));
    }

    @Override
    public int getItemCount() {
        return this.answers.size();
    }

    //@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/rockstargames/gtacr/adapters/DrivingSchoolAnswersAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/DrivingSchoolQuestionsItemBinding;", "(Lcom/rockstargames/gtacr/adapters/DrivingSchoolAnswersAdapter;Lblackrussia/online/databinding/DrivingSchoolQuestionsItemBinding;)V", "bind", "", "answer", "Lcom/rockstargames/gtacr/data/DrivingAnswer;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final DrivingSchoolQuestionsItemBinding binding;
        final DrivingSchoolAnswersAdapter this$0;

        public ViewHolder(DrivingSchoolAnswersAdapter this$0, DrivingSchoolQuestionsItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final DrivingAnswer answer) {
            Intrinsics.checkNotNullParameter(answer, "answer");
            DrivingSchoolQuestionsItemBinding drivingSchoolQuestionsItemBinding = this.binding;
            final DrivingSchoolAnswersAdapter drivingSchoolAnswersAdapter = this.this$0;
            drivingSchoolQuestionsItemBinding.questionsText.setText(answer.getAnswersText());
            if (answer.isChecked()) {
                NvEventQueueActivity nvEventQueueActivity = drivingSchoolAnswersAdapter.context;
                if (nvEventQueueActivity != null) {
                    drivingSchoolQuestionsItemBinding.questionsBg.setBackground(ResourcesCompat.getDrawable(nvEventQueueActivity.getResources(), R.drawable.driving_school_bg_active_answer, null));
                }
            } else {
                NvEventQueueActivity nvEventQueueActivity2 = drivingSchoolAnswersAdapter.context;
                if (nvEventQueueActivity2 != null) {
                    drivingSchoolQuestionsItemBinding.questionsBg.setBackground(ResourcesCompat.getDrawable(nvEventQueueActivity2.getResources(), R.drawable.driving_school_bg_not_active_answer, null));
                }
            }
            drivingSchoolQuestionsItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //DrivingSchoolAnswersAdapter.ViewHolder.m51bind$lambda3$lambda2(this$0, answer, DrivingSchoolAnswersAdapter.this, view);
                }
            });
        }

        public static final void m51bind$lambda3$lambda2(DrivingSchoolAnswersAdapter this$0, DrivingAnswer answer, ViewHolder this$1, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(answer, "$answer");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Function2 function2 = this$0.onAnswerClickListener;
            if (function2 == null) {
                return;
            }
            function2.invoke(answer, Integer.valueOf(this$1.getLayoutPosition()));
        }
    }

    public final void setOnlyItemCheck(int i) {
        int size = this.answers.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            if (i2 != i && this.answers.get(i2).isChecked()) {
                this.answers.get(i2).setChecked(false);
                notifyItemChanged(i2);
            }
            i2 = i3;
        }
    }
}
