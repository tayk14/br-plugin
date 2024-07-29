package com.rockstargames.gtacr.gui.fractions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionsTestingResultLayoutBinding;
import com.bumptech.glide.Glide;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.data.FractionsTestingResult;
import com.rockstargames.gtacr.gui.Useful;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsDocumentsViewModel;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0016\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/UIFractionsTestResultDialog;", "", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "documentsViewModel", "Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsDocumentsViewModel;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsDocumentsViewModel;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FractionsTestingResultLayoutBinding;", "dialogTestResult", "Landroid/widget/PopupWindow;", "closeDialog", "", "removeObservers", "setData", "testResult", "Lcom/rockstargames/gtacr/data/FractionsTestingResult;", "setViewModelObservers", "setupPositiveResult", "setupSetupNegativeResult", "showDialog", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIFractionsTestResultDialog {
    private Animation anim;
    private FractionsTestingResultLayoutBinding binding;
    private final NvEventQueueActivity context;
    private PopupWindow dialogTestResult;
    private final FractionsDocumentsViewModel documentsViewModel;

    public UIFractionsTestResultDialog(NvEventQueueActivity context, FractionsDocumentsViewModel documentsViewModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(documentsViewModel, "documentsViewModel");
        this.context = context;
        this.documentsViewModel = documentsViewModel;
        Object systemService = context.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        FractionsTestingResultLayoutBinding inflate = FractionsTestingResultLayoutBinding.inflate((LayoutInflater) systemService);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        Glide.with(inflate.bgViewRays).load(Integer.valueOf((int) R.drawable.fractions_testing_result_bg)).into(inflate.bgViewRays);
        Glide.with(inflate.bgViewEllipse).load(Integer.valueOf((int) R.drawable.fractions_new_rank_ellipse_bg)).into(inflate.bgViewEllipse);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.binding.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        this.dialogTestResult = new PopupWindow((View) this.binding.getRoot(), -1, -1, true);
        this.binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIFractionsTestResultDialog.m289_init_$lambda1(UIFractionsTestResultDialog.this, view);
            }
        });
        PopupWindow popupWindow = this.dialogTestResult;
        if (popupWindow == null) {
            return;
        }
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public final void onDismiss() {
                UIFractionsTestResultDialog.m290_init_$lambda2(UIFractionsTestResultDialog.this);
            }
        });
    }

    public static final void m289_init_$lambda1(UIFractionsTestResultDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.closeDialog();
    }

    public static final void m290_init_$lambda2(UIFractionsTestResultDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.documentsViewModel.sendButtonPressed(6, 12);
        this$0.removeObservers();
        this$0.documentsViewModel.setTestingResult(null);
    }

    private final void setViewModelObservers() {
        Context context = this.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(context);
        if (lifecycleOwner == null) {
            return;
        }
        this.documentsViewModel.getTestingResultLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIFractionsTestResultDialog.m293setViewModelObservers$lambda4$lambda3(UIFractionsTestResultDialog.this, (FractionsTestingResult) obj);
            }
        });
    }

    public static final void m293setViewModelObservers$lambda4$lambda3(UIFractionsTestResultDialog this$0, FractionsTestingResult fractionsTestingResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (fractionsTestingResult != null) {
            this$0.setData(fractionsTestingResult);
        }
    }

    private final void removeObservers() {
        Context context = this.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(context);
        if (lifecycleOwner == null) {
            return;
        }
        this.documentsViewModel.getTestingResultLiveData().removeObservers(lifecycleOwner);
    }

    private final void closeDialog() {
        PopupWindow popupWindow = this.dialogTestResult;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    public final void showDialog() {
        PopupWindow popupWindow = this.dialogTestResult;
        if (popupWindow != null) {
            popupWindow.showAtLocation(this.context.getParentLayout(), 17, 0, 0);
        }
        new Useful().closeAndroidsInterface(this.context, this.dialogTestResult);
        setViewModelObservers();
    }

    private final void setData(FractionsTestingResult fractionsTestingResult) {
        if (fractionsTestingResult.getTestingResult() == 1) {
            setupPositiveResult(fractionsTestingResult);
        } else {
            setupSetupNegativeResult(fractionsTestingResult);
        }
    }

    private final void setupPositiveResult(FractionsTestingResult fractionsTestingResult) {
        FractionsTestingResultLayoutBinding fractionsTestingResultLayoutBinding = this.binding;
        Glide.with(fractionsTestingResultLayoutBinding.imageViewSun).load(Integer.valueOf((int) R.drawable.fractions_testing_positive_res)).into(fractionsTestingResultLayoutBinding.imageViewSun);
        fractionsTestingResultLayoutBinding.textViewTitleOfResult.setText(R.string.fractions_congratulation);
        fractionsTestingResultLayoutBinding.textViewDescriptionOfResult.setText(fractionsTestingResultLayoutBinding.getRoot().getContext().getString(R.string.fractions_testing_you_passed_test));
        fractionsTestingResultLayoutBinding.textViewCorrectAnswers.setText(fractionsTestingResultLayoutBinding.getRoot().getContext().getString(R.string.fractions_testing_correct_answers, Integer.valueOf(fractionsTestingResult.getTestingTotal()), Integer.valueOf(fractionsTestingResult.getQuantityOfQuestions())));
    }

    private final void setupSetupNegativeResult(FractionsTestingResult fractionsTestingResult) {
        FractionsTestingResultLayoutBinding fractionsTestingResultLayoutBinding = this.binding;
        Glide.with(fractionsTestingResultLayoutBinding.imageViewSun).load(Integer.valueOf((int) R.drawable.fractions_testing_sad_res)).into(fractionsTestingResultLayoutBinding.imageViewSun);
        fractionsTestingResultLayoutBinding.textViewTitleOfResult.setText(R.string.fractions_testing_sorry);
        fractionsTestingResultLayoutBinding.textViewDescriptionOfResult.setText(R.string.fractions_testing_you_did_not_pass_test);
        fractionsTestingResultLayoutBinding.textViewCorrectAnswers.setText(fractionsTestingResultLayoutBinding.getRoot().getContext().getString(R.string.fractions_testing_correct_answers, Integer.valueOf(fractionsTestingResult.getTestingTotal()), Integer.valueOf(fractionsTestingResult.getQuantityOfQuestions())));
    }
}
