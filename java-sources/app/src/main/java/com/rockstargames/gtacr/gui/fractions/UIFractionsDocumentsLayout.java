package com.rockstargames.gtacr.gui.fractions;

import android.content.Context;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionsDocumentsLayoutBinding;
import blackrussia.online.network.fraction.data.FractionsDocumentsItem;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.FractionsDocumentsAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsDocumentsViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

//@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0002J\u0016\u0010\u001d\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\b\u0010!\u001a\u00020\u0014H\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020 H\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010#\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002J\b\u0010'\u001a\u00020\u0014H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/UIFractionsDocumentsLayout;", "Lcom/rockstargames/gtacr/common/UILayout;", "documentsViewModel", "Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsDocumentsViewModel;", "(Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsDocumentsViewModel;)V", "_binding", "Lblackrussia/online/databinding/FractionsDocumentsLayoutBinding;", "anim", "Landroid/view/animation/Animation;", "binding", "getBinding", "()Lblackrussia/online/databinding/FractionsDocumentsLayoutBinding;", "blockedSpam", "", "documentId", "", "documentNumber", "getView", "Landroid/view/View;", "hideButtonAcquainted", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "removeObservers", "setDocumentsAdapter", "list", "", "Lblackrussia/online/network/fraction/data/FractionsDocumentsItem;", "setupButtonClickListeners", "setupDescription", "item", "setupDocumentTitle", "setupObservers", "setupRecyclerView", "showButtonAcquainted", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIFractionsDocumentsLayout extends UILayout {
    private FractionsDocumentsLayoutBinding _binding;
    private Animation anim;
    private boolean blockedSpam;
    private int documentId;
    private int documentNumber;
    private final FractionsDocumentsViewModel documentsViewModel;

    public UIFractionsDocumentsLayout(FractionsDocumentsViewModel documentsViewModel) {
        Intrinsics.checkNotNullParameter(documentsViewModel, "documentsViewModel");
        this.documentsViewModel = documentsViewModel;
        this.documentId = -1;
        this.documentNumber = -1;
    }

    private final FractionsDocumentsLayoutBinding getBinding() {
        FractionsDocumentsLayoutBinding fractionsDocumentsLayoutBinding = this._binding;
        Intrinsics.checkNotNull(fractionsDocumentsLayoutBinding);
        return fractionsDocumentsLayoutBinding;
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
        this._binding = FractionsDocumentsLayoutBinding.inflate(inflater);
        this.anim = AnimationUtils.loadAnimation(getContext(), R.anim.button_click);
        setupRecyclerView();
        setupButtonClickListeners();
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void setupButtonClickListeners() {
        getBinding().buttonAcquaintedWithDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIFractionsDocumentsLayout.m285setupButtonClickListeners$lambda1(UIFractionsDocumentsLayout.this, view);
            }
        });
    }

    public static final void m285setupButtonClickListeners$lambda1(UIFractionsDocumentsLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.startAnimation(this$0.anim);
        if (this$0.blockedSpam) {
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {

            }
        }, 200L);
        this$0.blockedSpam = true;
    }

    public static final void m286setupButtonClickListeners$lambda1$lambda0(UIFractionsDocumentsLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.blockedSpam = false;
        this$0.documentsViewModel.sendButtonAcquaintedPressed(this$0.documentId, this$0.documentNumber);
        this$0.documentsViewModel.setTestingList(this$0.documentId);
    }

    private final void setupObservers() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(context);
        if (lifecycleOwner == null) {
            return;
        }
        this.documentsViewModel.getDocumentsListLivedata().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIFractionsDocumentsLayout.m287setupObservers$lambda5$lambda4(UIFractionsDocumentsLayout.this, (List) obj);
            }
        });
    }

    public static final void m287setupObservers$lambda5$lambda4(UIFractionsDocumentsLayout this$0, List list) {
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<blackrussia.online.network.fraction.data.FractionsDocumentsItem>");
        this$0.setDocumentsAdapter(TypeIntrinsics.asMutableList(list));
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((FractionsDocumentsItem) obj).isClicked()) {
                break;
            }
        }
        FractionsDocumentsItem fractionsDocumentsItem = (FractionsDocumentsItem) obj;
        if (fractionsDocumentsItem == null) {
            return;
        }
        this$0.documentNumber = list.indexOf(fractionsDocumentsItem);
        if (fractionsDocumentsItem.getDocumentStatus()) {
            this$0.hideButtonAcquainted();
        } else {
            this$0.showButtonAcquainted();
        }
        this$0.setupDescription(fractionsDocumentsItem);
        this$0.setupDocumentTitle(fractionsDocumentsItem);
        this$0.documentId = fractionsDocumentsItem.getDocumentId();
    }

    private final void removeObservers() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(context);
        if (lifecycleOwner == null) {
            return;
        }
        this.documentsViewModel.getDocumentsListLivedata().removeObservers(lifecycleOwner);
    }

    private final void setupRecyclerView() {
        RecyclerView recyclerView = getBinding().recyclerViewTasksList;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter(new FractionsDocumentsAdapter(new ArrayList()));
    }

    private final void setDocumentsAdapter(final List<FractionsDocumentsItem> list) {
        RecyclerView recyclerView = getBinding().recyclerViewTasksList;
        FractionsDocumentsAdapter fractionsDocumentsAdapter = new FractionsDocumentsAdapter(list);
        fractionsDocumentsAdapter.setOnItemClickListener(new Function1<FractionsDocumentsItem, Unit>() {

            @Override
            public Unit invoke(FractionsDocumentsItem fractionsDocumentsItem) {
                invoke2(fractionsDocumentsItem);
                return Unit.INSTANCE;
            }

            public final void invoke2(FractionsDocumentsItem item) {
                Intrinsics.checkNotNullParameter(item, "item");
                if (item.getDocumentStatus()) {
                    UIFractionsDocumentsLayout.this.hideButtonAcquainted();
                } else {
                    UIFractionsDocumentsLayout.this.showButtonAcquainted();
                }
                UIFractionsDocumentsLayout.this.documentNumber = list.indexOf(item);
                UIFractionsDocumentsLayout.this.documentId = item.getDocumentId();
                UIFractionsDocumentsLayout.this.setupDescription(item);
                UIFractionsDocumentsLayout.this.setupDocumentTitle(item);
            }
        });
        recyclerView.setAdapter(fractionsDocumentsAdapter);
    }

    public final void hideButtonAcquainted() {
        getBinding().buttonAcquaintedWithDocument.setVisibility(4);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(getBinding().getRoot());
        constraintSet.connect(R.id.text_view_document_description, 4, R.id.body_right_block, 4);
        constraintSet.applyTo(getBinding().getRoot());
    }

    public final void showButtonAcquainted() {
        getBinding().buttonAcquaintedWithDocument.setVisibility(0);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(getBinding().getRoot());
        constraintSet.connect(R.id.text_view_document_description, 4, R.id.button_acquainted_with_document, 3);
        constraintSet.applyTo(getBinding().getRoot());
    }

    public final void setupDescription(FractionsDocumentsItem fractionsDocumentsItem) {
        TextView textView = getBinding().textViewDocumentDescription;
        textView.setText(fractionsDocumentsItem.getDescription());
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setScrollY(10);
    }

    public final void setupDocumentTitle(FractionsDocumentsItem fractionsDocumentsItem) {
        TextView textView = getBinding().textViewDocumentTitle;
        textView.setText(fractionsDocumentsItem.getTitle());
        textView.setSelected(true);
    }

    @Override
    public void onLayoutShown() {
        GUIManager.hideSystemUI(getBinding().getRoot());
        setupObservers();
    }

    @Override
    public void onLayoutClose() {
        removeObservers();
    }
}
