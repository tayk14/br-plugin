package com.rockstargames.gtacr.gui.fractions;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionsQuestsLayoutBinding;
import blackrussia.online.network.fraction.data.FractionQuestsItem;
import com.bumptech.glide.Glide;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.FractionsQuestsAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsQuestsViewModel;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

//@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u0016\u0010\u001e\u001a\u00020\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0 H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/UIFractionQuestsLayout;", "Lcom/rockstargames/gtacr/common/UILayout;", "questsViewModel", "Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsQuestsViewModel;", "(Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsQuestsViewModel;)V", "_binding", "Lblackrussia/online/databinding/FractionsQuestsLayoutBinding;", "anim", "Landroid/view/animation/Animation;", "binding", "getBinding", "()Lblackrussia/online/databinding/FractionsQuestsLayoutBinding;", "questsAdapter", "Lcom/rockstargames/gtacr/adapters/FractionsQuestsAdapter;", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "", "onLayoutShown", "removeObservers", "setInfoAboutQuest", "clickedItem", "Lblackrussia/online/network/fraction/data/FractionQuestsItem;", "setLogicForOnQuestItemClick", "setObservers", "setupQuestsAdapter", "list", "", "setupRecyclerView", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIFractionQuestsLayout extends UILayout {
    private FractionsQuestsLayoutBinding _binding;
    private Animation anim;
    private FractionsQuestsAdapter questsAdapter;
    private final FractionsQuestsViewModel questsViewModel;

    public UIFractionQuestsLayout(FractionsQuestsViewModel questsViewModel) {
        Intrinsics.checkNotNullParameter(questsViewModel, "questsViewModel");
        this.questsViewModel = questsViewModel;
    }

    private final FractionsQuestsLayoutBinding getBinding() {
        FractionsQuestsLayoutBinding fractionsQuestsLayoutBinding = this._binding;
        Intrinsics.checkNotNull(fractionsQuestsLayoutBinding);
        return fractionsQuestsLayoutBinding;
    }

    @Override
    public View getView() {
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FractionsQuestsLayoutBinding.inflate(inflater);
        this.anim = AnimationUtils.loadAnimation(getBinding().getRoot().getContext(), R.anim.button_click);
        setupRecyclerView();
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void setObservers() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(context);
        if (lifecycleOwner == null) {
            return;
        }
        this.questsViewModel.getQuestsLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIFractionQuestsLayout.m268setObservers$lambda3$lambda2(UIFractionQuestsLayout.this, (List) obj);
            }
        });
    }

    public static final void m268setObservers$lambda3$lambda2(UIFractionQuestsLayout this$0, List list) {
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<blackrussia.online.network.fraction.data.FractionQuestsItem>");
        this$0.setupQuestsAdapter(TypeIntrinsics.asMutableList(list));
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((FractionQuestsItem) obj).isClicked()) {
                break;
            }
        }
        FractionQuestsItem fractionQuestsItem = (FractionQuestsItem) obj;
        if (fractionQuestsItem == null) {
            return;
        }
        this$0.setInfoAboutQuest(fractionQuestsItem);
    }

    private final void setupRecyclerView() {
        RecyclerView recyclerView = getBinding().recyclerViewTasksList;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
    }

    private final void setupQuestsAdapter(List<FractionQuestsItem> list) {
        this.questsAdapter = new FractionsQuestsAdapter(list);
        setLogicForOnQuestItemClick();
        getBinding().recyclerViewTasksList.setAdapter(this.questsAdapter);
    }

    private final void setLogicForOnQuestItemClick() {
        FractionsQuestsAdapter fractionsQuestsAdapter = this.questsAdapter;
        if (fractionsQuestsAdapter == null) {
            return;
        }
        fractionsQuestsAdapter.setOnQuestItemClickListener(new Function1<FractionQuestsItem, Unit>() {

            @Override
            public Unit invoke(FractionQuestsItem fractionQuestsItem) {
                invoke2(fractionQuestsItem);
                return Unit.INSTANCE;
            }

            public final void invoke2(FractionQuestsItem clickedItem) {
                Intrinsics.checkNotNullParameter(clickedItem, "clickedItem");
                UIFractionQuestsLayout.this.setInfoAboutQuest(clickedItem);
            }
        });
    }

    public final void setInfoAboutQuest(final FractionQuestsItem fractionQuestsItem) {
        String string = getContext().getString(R.string.fractions_quest_title, fractionQuestsItem.getTitle());
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…title, clickedItem.title)");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.color_FFA61D)), 8, spannableString.length(), 33);
        FractionsQuestsLayoutBinding binding = getBinding();
        binding.questsTitle.setText(FractionsUtilsKt.transformSpannableToUpperCase(spannableString));
        TextView textView = binding.valueGoalsDescription;
        textView.setText(fractionQuestsItem.getGoal());
        textView.setScrollY(10);
        textView.setMovementMethod(new ScrollingMovementMethod());
        TextView textView2 = binding.valueQuestsDescription;
        textView2.setText(fractionQuestsItem.getDescription());
        textView2.setScrollY(10);
        textView2.setMovementMethod(new ScrollingMovementMethod());
        if (fractionQuestsItem.getMoneyReward() == 0) {
            binding.award2Value.setVisibility(4);
            binding.award2Item.setVisibility(4);
        } else {
            binding.award2Value.setVisibility(0);
            binding.award2Item.setVisibility(0);
            binding.award2Value.setText(getContext().getString(R.string.fractions_quests_award_1, Integer.valueOf(fractionQuestsItem.getMoneyReward())));
        }
        binding.award1Value.setText(getContext().getString(R.string.fractions_quests_award_2, Integer.valueOf(fractionQuestsItem.getScoreReward())));
        if (fractionQuestsItem.getScoreReward() < 0) {
            Glide.with(binding.award1Item).load(Integer.valueOf((int) R.drawable.fractions_shop_item_gold_down_icon_res)).into(binding.award1Item);
        } else {
            Glide.with(binding.award1Item).load(Integer.valueOf((int) R.drawable.fractions_shop_item_gold_up_icon_res)).into(binding.award1Item);
        }
        if (fractionQuestsItem.getTokenReward() == 0) {
            binding.award3Item.setVisibility(4);
            binding.award3Value.setVisibility(4);
        } else {
            binding.award3Item.setVisibility(0);
            binding.award3Value.setVisibility(0);
            binding.award3Value.setText(getContext().getString(R.string.fractions_quests_award_3, Integer.valueOf(fractionQuestsItem.getTokenReward())));
        }
        binding.buttonStartQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIFractionQuestsLayout.m267setInfoAboutQuest$lambda9$lambda8(UIFractionQuestsLayout.this, fractionQuestsItem, view);
            }
        });
    }

    public static final void m267setInfoAboutQuest$lambda9$lambda8(UIFractionQuestsLayout this$0, FractionQuestsItem clickedItem, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clickedItem, "$clickedItem");
        view.startAnimation(this$0.anim);
        this$0.questsViewModel.sendStartQuest(clickedItem.getId());
    }

    @Override
    public void onLayoutShown() {
        GUIManager.hideSystemUI(getBinding().getRoot());
        setObservers();
    }

    private final void removeObservers() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(context);
        if (lifecycleOwner == null) {
            return;
        }
        this.questsViewModel.getQuestsLiveData().removeObservers(lifecycleOwner);
    }

    @Override
    public void onLayoutClose() {
        removeObservers();
    }
}
