package com.rockstargames.gtacr.gui.drivingSchool;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import blackrussia.online.R;
import blackrussia.online.databinding.DrivingSchoolEndTestBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/rockstargames/gtacr/gui/drivingSchool/LogicForDialogEndTest;", "", "mainRoot", "Lcom/rockstargames/gtacr/gui/drivingSchool/GUIDrivingSchool;", "binding", "Lblackrussia/online/databinding/DrivingSchoolEndTestBinding;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Lcom/rockstargames/gtacr/gui/drivingSchool/GUIDrivingSchool;Lblackrussia/online/databinding/DrivingSchoolEndTestBinding;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "setLogicAndView", "", "statusTest", "", "correctAnswers", "allQuestions", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LogicForDialogEndTest {
    private final DrivingSchoolEndTestBinding binding;
    private final NvEventQueueActivity context;
    private final GUIDrivingSchool mainRoot;

    public LogicForDialogEndTest(GUIDrivingSchool mainRoot, DrivingSchoolEndTestBinding binding, NvEventQueueActivity nvEventQueueActivity) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mainRoot = mainRoot;
        this.binding = binding;
        this.context = nvEventQueueActivity;
    }

    public final void setLogicAndView(int i, int i2, int i3) {
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.binding.getRoot().getContext(), R.anim.button_click);
        DrivingSchoolEndTestBinding drivingSchoolEndTestBinding = this.binding;
        if (i == 0) {
            ImageView imageView = drivingSchoolEndTestBinding.iconResultFace;
            NvEventQueueActivity nvEventQueueActivity = this.context;
            Intrinsics.checkNotNull(nvEventQueueActivity);
            imageView.setImageDrawable(ResourcesCompat.getDrawable(nvEventQueueActivity.getResources(), R.drawable.driving_school_icon_cry_res, null));
            drivingSchoolEndTestBinding.titleResultTest.setText(this.context.getText(R.string.driving_school_title_if_not_gud));
            drivingSchoolEndTestBinding.textResultTest.setText(this.context.getText(R.string.driving_school_text_if_not_gud));
            drivingSchoolEndTestBinding.valueResultTest.setText(this.context.getString(R.string.driving_school_value_correct_answers_in_end_test, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
        } else if (i == 1) {
            ImageView imageView2 = drivingSchoolEndTestBinding.iconResultFace;
            NvEventQueueActivity nvEventQueueActivity2 = this.context;
            Intrinsics.checkNotNull(nvEventQueueActivity2);
            imageView2.setImageDrawable(ResourcesCompat.getDrawable(nvEventQueueActivity2.getResources(), R.drawable.driving_school_icon_shy_res, null));
            drivingSchoolEndTestBinding.titleResultTest.setText(this.context.getText(R.string.driving_school_title_if_gud));
            drivingSchoolEndTestBinding.textResultTest.setText(this.context.getText(R.string.driving_school_text_if_gud));
            drivingSchoolEndTestBinding.valueResultTest.setText(this.context.getText(R.string.driving_school_text_for_additional_info_if_gud));
        }
        drivingSchoolEndTestBinding.buttonStartPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                //LogicForDialogEndTest.m129setLogicAndView$lambda2$lambda1(loadAnimation, this, view);
            }
        });
    }

    public static final void m129setLogicAndView$lambda2$lambda1(Animation animation, LogicForDialogEndTest this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.startAnimation(animation);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                //LogicForDialogEndTest.m130setLogicAndView$lambda2$lambda1$lambda0(LogicForDialogEndTest.this);
            }
        }, 250L);
    }

    public static final void m130setLogicAndView$lambda2$lambda1$lambda0(LogicForDialogEndTest this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mainRoot.sendToServerClickButton(5);
    }
}
