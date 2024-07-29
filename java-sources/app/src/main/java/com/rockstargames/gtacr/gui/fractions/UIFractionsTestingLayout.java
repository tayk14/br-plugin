package com.rockstargames.gtacr.gui.fractions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionsTestingLayoutBinding;
import blackrussia.online.network.fraction.data.FractionsTestingItem;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.FractionsTestingAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.FractionsTestingResult;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsDocumentsViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

//@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0003J\u001a\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\u0016\u0010#\u001a\u00020\u00192\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110%H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/UIFractionsTestingLayout;", "Lcom/rockstargames/gtacr/common/UILayout;", "documentsViewModel", "Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsDocumentsViewModel;", "(Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsDocumentsViewModel;)V", "_binding", "Lblackrussia/online/databinding/FractionsTestingLayoutBinding;", "anim", "Landroid/view/animation/Animation;", "binding", "getBinding", "()Lblackrussia/online/databinding/FractionsTestingLayoutBinding;", "count", "", "documentId", "mainList", "", "Lblackrussia/online/network/fraction/data/FractionsTestingItem;", "resultDialog", "Lcom/rockstargames/gtacr/gui/fractions/UIFractionsTestResultDialog;", "testingAdapter", "Lcom/rockstargames/gtacr/adapters/FractionsTestingAdapter;", "getView", "Landroid/view/View;", "nextQuestion", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "removeObservers", "setupObservers", "setupTestingAdapter", "list", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIFractionsTestingLayout extends UILayout {
    private FractionsTestingLayoutBinding _binding;
    private Animation anim;
    private int count;
    private int documentId;
    private final FractionsDocumentsViewModel documentsViewModel;
    private List<FractionsTestingItem> mainList;
    private UIFractionsTestResultDialog resultDialog;
    private FractionsTestingAdapter testingAdapter;

    public UIFractionsTestingLayout(FractionsDocumentsViewModel documentsViewModel) {
        Intrinsics.checkNotNullParameter(documentsViewModel, "documentsViewModel");
        this.documentsViewModel = documentsViewModel;
        this.mainList = new ArrayList();
        this.documentId = -1;
    }

    private final FractionsTestingLayoutBinding getBinding() {
        FractionsTestingLayoutBinding fractionsTestingLayoutBinding = this._binding;
        Intrinsics.checkNotNull(fractionsTestingLayoutBinding);
        return fractionsTestingLayoutBinding;
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
        this._binding = FractionsTestingLayoutBinding.inflate(inflater);
        this.anim = AnimationUtils.loadAnimation(getBinding().getRoot().getContext(), R.anim.button_click);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void setupObservers() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(context);
        if (lifecycleOwner == null) {
            return;
        }
        this.documentsViewModel.getTestingLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIFractionsTestingLayout.m295setupObservers$lambda3$lambda0(UIFractionsTestingLayout.this, (List) obj);
            }
        });
        this.documentsViewModel.getDocumentIdLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIFractionsTestingLayout.m296setupObservers$lambda3$lambda1(UIFractionsTestingLayout.this, (Integer) obj);
            }
        });
        this.documentsViewModel.getTestingResultLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIFractionsTestingLayout.m297setupObservers$lambda3$lambda2(UIFractionsTestingLayout.this, (FractionsTestingResult) obj);
            }
        });
    }

    public static final void m295setupObservers$lambda3$lambda0(UIFractionsTestingLayout this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        ((FractionsTestingItem) list.get(0)).setAnswerClicked(-1);
        Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<blackrussia.online.network.fraction.data.FractionsTestingItem>");
        this$0.mainList = TypeIntrinsics.asMutableList(list);
        this$0.setupTestingAdapter(list);
        this$0.getBinding().textViewQuestionTitle.setText(((FractionsTestingItem) list.get(this$0.count)).getTestingQuestion());
    }

    public static final void m296setupObservers$lambda3$lambda1(UIFractionsTestingLayout this$0, Integer documentId_) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(documentId_, "documentId_");
        this$0.documentId = documentId_.intValue();
    }

    public static final void m297setupObservers$lambda3$lambda2(UIFractionsTestingLayout this$0, FractionsTestingResult fractionsTestingResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (fractionsTestingResult != null) {
            this$0.getBinding().loader.setVisibility(4);
        }
    }

    private final void removeObservers() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(context);
        if (lifecycleOwner == null) {
            return;
        }
        this.documentsViewModel.getTestingLiveData().removeObservers(lifecycleOwner);
        this.documentsViewModel.getDocumentIdLiveData().removeObservers(lifecycleOwner);
        this.documentsViewModel.getTestingResultLiveData().removeObservers(lifecycleOwner);
    }

    @Override
    public void onLayoutShown() {
        GUIManager.hideSystemUI(getBinding().getRoot());
        setupObservers();
    }

    @Override
    public void onLayoutClose() {
        this.count = 0;
        this.documentId = -1;
        this.resultDialog = null;
        FractionsTestingLayoutBinding binding = getBinding();
        binding.loader.setVisibility(4);
        binding.recyclerViewTesting.setVisibility(0);
        binding.textViewQuestionTitle.setVisibility(0);
        binding.leftTitleDiver.setVisibility(0);
        binding.topTitleBlock.setVisibility(0);
        binding.bottomBody.setVisibility(0);
        binding.textViewTestingTitle.setVisibility(0);
        removeObservers();
    }

    private final void setupTestingAdapter(final List<FractionsTestingItem> list) {
        final FractionsTestingAdapter fractionsTestingAdapter = new FractionsTestingAdapter(list);
        fractionsTestingAdapter.setOnItemClickListener(new Function1<Integer, Unit>() {
            @Override
            public Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                FractionsDocumentsViewModel fractionsDocumentsViewModel;
                fractionsDocumentsViewModel = UIFractionsTestingLayout.this.documentsViewModel;
                fractionsDocumentsViewModel.sendAnswerChosen(i);
                UIFractionsTestingLayout.this.nextQuestion();
                fractionsTestingAdapter.notifyItemRangeChanged(0, list.size());
            }
        });
        this.testingAdapter = fractionsTestingAdapter;
        getBinding().recyclerViewTesting.setAdapter(this.testingAdapter);
    }

    public final void nextQuestion() {
        if (this.count < this.mainList.size() - 1) {
            this.count++;
            getBinding().textViewQuestionTitle.setText(this.mainList.get(this.count).getTestingQuestion());
            FractionsTestingAdapter fractionsTestingAdapter = this.testingAdapter;
            if (fractionsTestingAdapter != null) {
                fractionsTestingAdapter.nextAnswersForQuestion(this.count);
            }
            FractionsTestingAdapter fractionsTestingAdapter2 = this.testingAdapter;
            if (fractionsTestingAdapter2 == null) {
                return;
            }
            fractionsTestingAdapter2.notifyDataSetChanged();
            return;
        }
        FractionsTestingLayoutBinding binding = getBinding();
        binding.loader.setVisibility(0);
        binding.recyclerViewTesting.setVisibility(4);
        binding.textViewQuestionTitle.setVisibility(4);
        binding.leftTitleDiver.setVisibility(4);
        binding.topTitleBlock.setVisibility(4);
        binding.bottomBody.setVisibility(4);
        binding.textViewTestingTitle.setVisibility(4);
    }
}
