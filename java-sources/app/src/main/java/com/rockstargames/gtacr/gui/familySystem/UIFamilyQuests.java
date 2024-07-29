package com.rockstargames.gtacr.gui.familySystem;

import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.App;
import blackrussia.online.R;
import blackrussia.online.databinding.FamiliesQuestsLayoutBinding;
import blackrussia.online.network.FamilySystemTasksObj;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.FamilyQuestsAdapter;
import com.rockstargames.gtacr.common.UILayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0013H\u0016J\b\u0010&\u001a\u00020\u0013H\u0016J\b\u0010'\u001a\u00020\u0013H\u0002J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010)\u001a\u00020\u0013H\u0002J\u0006\u0010*\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u000b\u001a6\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\fj\u0002`\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/rockstargames/gtacr/gui/familySystem/UIFamilyQuests;", "Lcom/rockstargames/gtacr/common/UILayout;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "actionsWithJSON", "Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/familySystem/ActionsWithJSON;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FamiliesQuestsLayoutBinding;", "onClickQuestInFamilyQuestsList", "Lkotlin/Function2;", "Lblackrussia/online/network/FamilySystemTasksObj;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "thisItem", "", "position", "", "Lcom/rockstargames/gtacr/gui/familySystem/OnClickQuestInFamilyQuestsList;", "questsAdapter", "Lcom/rockstargames/gtacr/adapters/FamilyQuestsAdapter;", "questsList", "", "thisQuestsId", "timesOldClickOnButtonStart", "", "timesOldClickOnQuest", "clearQuestsCheckStatus", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "setDataInView", "setInfoAboutQuest", "setLogicForQuestsClick", "setStartParameters", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIFamilyQuests extends UILayout {
    private final ActionsWithJSON actionsWithJSON;
    private Animation anim;
    private FamiliesQuestsLayoutBinding binding;
    private final NvEventQueueActivity context;
    private Function2<? super FamilySystemTasksObj, ? super Integer, Unit> onClickQuestInFamilyQuestsList;
    private FamilyQuestsAdapter questsAdapter;
    private final List<FamilySystemTasksObj> questsList;
    private int thisQuestsId;
    private long timesOldClickOnButtonStart;
    private long timesOldClickOnQuest;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIFamilyQuests(NvEventQueueActivity context, ActionsWithJSON actionsWithJSON) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionsWithJSON, "actionsWithJSON");
        this.context = context;
        this.actionsWithJSON = actionsWithJSON;
        this.questsList = new ArrayList();
        this.thisQuestsId = -1;
    }

    public final void setStartParameters() {
        if (this.questsList.size() > 0) {
            clearQuestsCheckStatus();
            FamilySystemTasksObj familySystemTasksObj = this.questsList.get(0);
            setInfoAboutQuest(familySystemTasksObj);
            this.thisQuestsId = familySystemTasksObj.getId();
        }
        setDataInView();
    }

    private final void clearQuestsCheckStatus() {
        int size = this.questsList.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            this.questsList.get(i).setClicked(i == 0);
            i = i2;
        }
    }

    @Override
    public View getView() {
        FamiliesQuestsLayoutBinding familiesQuestsLayoutBinding = this.binding;
        if (familiesQuestsLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesQuestsLayoutBinding = null;
        }
        ConstraintLayout root = familiesQuestsLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FamiliesQuestsLayoutBinding inflate = FamiliesQuestsLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        FamiliesQuestsLayoutBinding familiesQuestsLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        this.questsList.addAll(App.getInstance().getFamilySystemList().getTasksList());
        setLogicForQuestsClick();
        FamiliesQuestsLayoutBinding familiesQuestsLayoutBinding2 = this.binding;
        if (familiesQuestsLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesQuestsLayoutBinding2 = null;
        }
        familiesQuestsLayoutBinding2.buttonStartQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIFamilyQuests.m194onCreateView$lambda1(UIFamilyQuests.this, view);
            }
        });
        FamiliesQuestsLayoutBinding familiesQuestsLayoutBinding3 = this.binding;
        if (familiesQuestsLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesQuestsLayoutBinding3 = null;
        }
        familiesQuestsLayoutBinding3.valueQuestsDescription.setMovementMethod(new ScrollingMovementMethod());
        FamiliesQuestsLayoutBinding familiesQuestsLayoutBinding4 = this.binding;
        if (familiesQuestsLayoutBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            familiesQuestsLayoutBinding = familiesQuestsLayoutBinding4;
        }
        ConstraintLayout root = familiesQuestsLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public static final void m194onCreateView$lambda1(UIFamilyQuests this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (System.currentTimeMillis() - this$0.timesOldClickOnButtonStart > 500) {
            this$0.timesOldClickOnButtonStart = System.currentTimeMillis();
            this$0.actionsWithJSON.startQuest(this$0.thisQuestsId);
        }
    }

    private final void setDataInView() {
        List<FamilySystemTasksObj> list = this.questsList;
        Function2<? super FamilySystemTasksObj, ? super Integer, Unit> function2 = this.onClickQuestInFamilyQuestsList;
        FamilyQuestsAdapter familyQuestsAdapter = null;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onClickQuestInFamilyQuestsList");
            function2 = null;
        }
        this.questsAdapter = new FamilyQuestsAdapter(list, function2, this.context);
        FamiliesQuestsLayoutBinding familiesQuestsLayoutBinding = this.binding;
        if (familiesQuestsLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesQuestsLayoutBinding = null;
        }
        RecyclerView recyclerView = familiesQuestsLayoutBinding.questionsList;
        FamiliesQuestsLayoutBinding familiesQuestsLayoutBinding2 = this.binding;
        if (familiesQuestsLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesQuestsLayoutBinding2 = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(familiesQuestsLayoutBinding2.getRoot().getContext(), 1, false));
        FamilyQuestsAdapter familyQuestsAdapter2 = this.questsAdapter;
        if (familyQuestsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("questsAdapter");
        } else {
            familyQuestsAdapter = familyQuestsAdapter2;
        }
        recyclerView.setAdapter(familyQuestsAdapter);
    }

    private final void setLogicForQuestsClick() {
        this.onClickQuestInFamilyQuestsList = new Function2<FamilySystemTasksObj, Integer, Unit>() {
            @Override
            public Unit invoke(FamilySystemTasksObj familySystemTasksObj, Integer num) {
                invoke(familySystemTasksObj, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(FamilySystemTasksObj thisItem, int i) {
                long j;
                FamilyQuestsAdapter familyQuestsAdapter;
                Intrinsics.checkNotNullParameter(thisItem, "thisItem");
                long currentTimeMillis = System.currentTimeMillis();
                j = UIFamilyQuests.this.timesOldClickOnQuest;
                if (currentTimeMillis - j > 300) {
                    UIFamilyQuests.this.timesOldClickOnQuest = System.currentTimeMillis();
                    thisItem.setClicked(true);
                    familyQuestsAdapter = UIFamilyQuests.this.questsAdapter;
                    if (familyQuestsAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("questsAdapter");
                        familyQuestsAdapter = null;
                    }
                    familyQuestsAdapter.notifyItemChanged(i);
                    familyQuestsAdapter.setCheckOnlyElement(i);
                    UIFamilyQuests.this.thisQuestsId = thisItem.getId();
                    UIFamilyQuests.this.setInfoAboutQuest(thisItem);
                }
            }
        };
    }

    public final void setInfoAboutQuest(FamilySystemTasksObj familySystemTasksObj) {
        int scoreReward;
        FamiliesQuestsLayoutBinding familiesQuestsLayoutBinding = this.binding;
        if (familiesQuestsLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            familiesQuestsLayoutBinding = null;
        }
        SpannableString spannableString = new SpannableString(familySystemTasksObj.getTitle());
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.color_FFA61D)), 0, spannableString.length(), 33);
        familiesQuestsLayoutBinding.questsTitle.setText(this.context.getString(R.string.families_questions_title, new Object[]{spannableString}));
        familiesQuestsLayoutBinding.valueQuestsDescription.setText(familySystemTasksObj.getDescription());
        familiesQuestsLayoutBinding.present1Value.setText(this.context.getString(R.string.families_quests_present_1, new Object[]{String.valueOf(familySystemTasksObj.getMoneyReward())}));
        if (familySystemTasksObj.getScoreReward() < 0) {
            scoreReward = familySystemTasksObj.getScoreReward() * (-1);
            familiesQuestsLayoutBinding.present2Item.setImageResource(R.drawable.families_shop_item_gold_down_icon_res);
        } else {
            scoreReward = familySystemTasksObj.getScoreReward();
            familiesQuestsLayoutBinding.present2Item.setImageResource(R.drawable.families_shop_item_gold_up_icon_res);
        }
        familiesQuestsLayoutBinding.present2Value.setText(this.context.getString(R.string.families_quests_present_2, new Object[]{String.valueOf(scoreReward)}));
        familiesQuestsLayoutBinding.present3Value.setText(this.context.getString(R.string.families_quests_present_3, new Object[]{String.valueOf(familySystemTasksObj.getTokenReward())}));
    }
}
