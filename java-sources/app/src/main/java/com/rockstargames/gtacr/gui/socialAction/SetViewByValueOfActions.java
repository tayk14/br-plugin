package com.rockstargames.gtacr.gui.socialAction;

import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import blackrussia.online.R;
import blackrussia.online.databinding.SocialInteractionBinding;
import blackrussia.online.network.SocialInteraction;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.gui.fractions.Const;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010!\u001a\u0004\u0018\u00010\bJ\b\u0010\"\u001a\u0004\u0018\u00010\bJ\b\u0010#\u001a\u0004\u0018\u00010\bJ\b\u0010$\u001a\u0004\u0018\u00010\bJ\b\u0010%\u001a\u0004\u0018\u00010\bJ\b\u0010&\u001a\u0004\u0018\u00010\bJ\b\u0010'\u001a\u0004\u0018\u00010\bJ$\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\u001f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u001f2\u0006\u0010*\u001a\u00020\u0016H\u0002J\u0010\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002J\u0016\u00101\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0016J\u001e\u00105\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u0016J0\u00107\u001a\u00020.2\u0006\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00162\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001fH\u0002J.\u0010<\u001a\u00020.2\u0006\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00162\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001fJ\u0016\u0010=\u001a\u00020.2\u0006\u0010;\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u0016J\u0010\u0010>\u001a\u00020.2\u0006\u00108\u001a\u00020\u0016H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/rockstargames/gtacr/gui/socialAction/SetViewByValueOfActions;", "", "root", "Lcom/rockstargames/gtacr/gui/socialAction/GUISocialInteraction;", "binding", "Lblackrussia/online/databinding/SocialInteractionBinding;", "(Lcom/rockstargames/gtacr/gui/socialAction/GUISocialInteraction;Lblackrussia/online/databinding/SocialInteractionBinding;)V", "actionFromButton1", "Lblackrussia/online/network/SocialInteraction;", "actionFromButton2", "actionFromButton3", "actionFromButton4", "actionFromButton5", "actionFromButton6", "actionFromButton7", "backButtonsText", "", "getBinding", "()Lblackrussia/online/databinding/SocialInteractionBinding;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "iconAdditionally", "", "iconBack", "invisible", "resource", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "getRoot", "()Lcom/rockstargames/gtacr/gui/socialAction/GUISocialInteraction;", "thisActionsList", "", "visible", "getActionFromButton1", "getActionFromButton2", "getActionFromButton3", "getActionFromButton4", "getActionFromButton5", "getActionFromButton6", "getActionFromButton7", "getIntermediateListWithActions", "listWithActions", Const.PAGE_KEY, "getMarginInPixel", "resourcesId", "setMarque", "", "textButton", "Landroid/widget/TextView;", "setPlayersInfo", "playersNick", "", "playersId", "setStartButtons", "ifPlayerInOrganization", "setTextAndIconInButtons", "valueOfActions", "ifWithAdditionally", "", Const.FRACTION_TYPE_KEY, "startLogicForSetView", "updateButtonsText", "updateParameterForButton", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SetViewByValueOfActions {
    private SocialInteraction actionFromButton1;
    private SocialInteraction actionFromButton2;
    private SocialInteraction actionFromButton3;
    private SocialInteraction actionFromButton4;
    private SocialInteraction actionFromButton5;
    private SocialInteraction actionFromButton6;
    private SocialInteraction actionFromButton7;
    private final CharSequence backButtonsText;
    private final SocialInteractionBinding binding;
    private final NvEventQueueActivity context;
    private final int iconAdditionally;
    private final int iconBack;
    private final int invisible;
    private final Resources resource;
    private final GUISocialInteraction root;
    private List<SocialInteraction> thisActionsList;
    private int visible;

    public SetViewByValueOfActions(GUISocialInteraction root, SocialInteractionBinding binding) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.root = root;
        this.binding = binding;
        NvEventQueueActivity context = root.getContext();
        this.context = context;
        this.resource = context.getResources();
        this.invisible = 4;
        CharSequence text = context.getText(R.string.if_with_back);
        Intrinsics.checkNotNullExpressionValue(text, "context.getText(R.string.if_with_back)");
        this.backButtonsText = text;
        this.iconBack = R.drawable.social_interaction_icon_back;
        this.iconAdditionally = R.drawable.social_interaction_icon_additionally;
        this.thisActionsList = new ArrayList();
    }

    public final GUISocialInteraction getRoot() {
        return this.root;
    }

    public final SocialInteractionBinding getBinding() {
        return this.binding;
    }

    public final SocialInteraction getActionFromButton1() {
        return this.actionFromButton1;
    }

    public final SocialInteraction getActionFromButton2() {
        return this.actionFromButton2;
    }

    public final SocialInteraction getActionFromButton3() {
        return this.actionFromButton3;
    }

    public final SocialInteraction getActionFromButton4() {
        return this.actionFromButton4;
    }

    public final SocialInteraction getActionFromButton5() {
        return this.actionFromButton5;
    }

    public final SocialInteraction getActionFromButton6() {
        return this.actionFromButton6;
    }

    public final SocialInteraction getActionFromButton7() {
        return this.actionFromButton7;
    }

    public final void startLogicForSetView(int i, boolean z, int i2, List<SocialInteraction> list) {
        setTextAndIconInButtons(i, z, i2, list);
        updateParameterForButton(i);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                SetViewByValueOfActions.m396startLogicForSetView$lambda0(SetViewByValueOfActions.this);
            }
        }, 250L);
    }

    public static final void m396startLogicForSetView$lambda0(SetViewByValueOfActions this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.binding.button1;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.button1");
        this$0.setMarque(textView);
        TextView textView2 = this$0.binding.button2;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.button2");
        this$0.setMarque(textView2);
        TextView textView3 = this$0.binding.button3;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.button3");
        this$0.setMarque(textView3);
        TextView textView4 = this$0.binding.button4;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.button4");
        this$0.setMarque(textView4);
        TextView textView5 = this$0.binding.button5;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.button5");
        this$0.setMarque(textView5);
        TextView textView6 = this$0.binding.button6;
        Intrinsics.checkNotNullExpressionValue(textView6, "binding.button6");
        this$0.setMarque(textView6);
        TextView textView7 = this$0.binding.button7;
        Intrinsics.checkNotNullExpressionValue(textView7, "binding.button7");
        this$0.setMarque(textView7);
    }

    private final void setTextAndIconInButtons(int i, boolean z, int i2, List<SocialInteraction> list) {
        int i3 = i2 != 1 ? i2 != 2 ? i2 != 3 ? 0 : R.drawable.social_interaction_icon_chat : R.drawable.social_interaction_icon_exchange : R.drawable.social_interaction_icon_star;
        this.binding.button1.setCompoundDrawablesWithIntrinsicBounds(i3, 0, 0, 0);
        this.binding.button2.setCompoundDrawablesWithIntrinsicBounds(i3, 0, 0, 0);
        this.binding.button3.setCompoundDrawablesWithIntrinsicBounds(i3, 0, 0, 0);
        this.binding.button4.setCompoundDrawablesWithIntrinsicBounds(i3, 0, 0, 0);
        this.binding.button5.setCompoundDrawablesWithIntrinsicBounds(i3, 0, 0, 0);
        this.binding.button6.setCompoundDrawablesWithIntrinsicBounds(i3, 0, 0, 0);
        this.binding.button7.setCompoundDrawablesWithIntrinsicBounds(i3, 0, 0, 0);
        switch (i) {
            case 0:
                this.binding.buttonWithNickname.setVisibility(this.visible);
                Unit unit = Unit.INSTANCE;
                this.binding.button1.setVisibility(this.invisible);
                this.binding.button2.setVisibility(this.invisible);
                this.binding.button3.setVisibility(this.invisible);
                TextView textView = this.binding.button4;
                textView.setVisibility(this.visible);
                textView.setText(this.backButtonsText);
                textView.setCompoundDrawablesWithIntrinsicBounds(this.iconBack, 0, 0, 0);
                textView.invalidate();
                Unit unit2 = Unit.INSTANCE;
                this.binding.button5.setVisibility(this.invisible);
                this.binding.button6.setVisibility(this.invisible);
                this.binding.button7.setVisibility(this.invisible);
                return;
            case 1:
                this.binding.buttonWithNickname.setVisibility(this.visible);
                Unit unit3 = Unit.INSTANCE;
                this.binding.button1.setVisibility(this.invisible);
                this.binding.button2.setVisibility(this.invisible);
                TextView textView2 = this.binding.button3;
                textView2.setVisibility(this.visible);
                if (list != null) {
                    textView2.setText(list.get(0).getName());
                    this.actionFromButton3 = list.get(0);
                    Unit unit4 = Unit.INSTANCE;
                    Unit unit5 = Unit.INSTANCE;
                }
                textView2.invalidate();
                Unit unit6 = Unit.INSTANCE;
                this.binding.button4.setVisibility(this.invisible);
                TextView textView3 = this.binding.button5;
                textView3.setVisibility(this.visible);
                textView3.setText(this.backButtonsText);
                textView3.setCompoundDrawablesWithIntrinsicBounds(this.iconBack, 0, 0, 0);
                textView3.invalidate();
                Unit unit7 = Unit.INSTANCE;
                this.binding.button6.setVisibility(this.invisible);
                this.binding.button7.setVisibility(this.invisible);
                return;
            case 2:
                this.binding.buttonWithNickname.setVisibility(this.visible);
                Unit unit8 = Unit.INSTANCE;
                this.binding.button1.setVisibility(this.invisible);
                TextView textView4 = this.binding.button2;
                textView4.setVisibility(this.visible);
                if (list != null) {
                    textView4.setText(list.get(1).getName());
                    this.actionFromButton2 = list.get(1);
                    Unit unit9 = Unit.INSTANCE;
                    Unit unit10 = Unit.INSTANCE;
                }
                textView4.invalidate();
                Unit unit11 = Unit.INSTANCE;
                this.binding.button3.setVisibility(this.invisible);
                TextView textView5 = this.binding.button4;
                textView5.setVisibility(this.visible);
                textView5.setText(this.backButtonsText);
                textView5.setCompoundDrawablesWithIntrinsicBounds(this.iconBack, 0, 0, 0);
                textView5.invalidate();
                Unit unit12 = Unit.INSTANCE;
                this.binding.button5.setVisibility(this.invisible);
                TextView textView6 = this.binding.button6;
                textView6.setVisibility(this.visible);
                if (list != null) {
                    textView6.setText(list.get(0).getName());
                    this.actionFromButton6 = list.get(0);
                    Unit unit13 = Unit.INSTANCE;
                    Unit unit14 = Unit.INSTANCE;
                }
                textView6.invalidate();
                Unit unit15 = Unit.INSTANCE;
                this.binding.button7.setVisibility(this.invisible);
                return;
            case 3:
                this.binding.buttonWithNickname.setVisibility(this.visible);
                Unit unit16 = Unit.INSTANCE;
                this.binding.button1.setVisibility(this.invisible);
                TextView textView7 = this.binding.button2;
                textView7.setVisibility(this.visible);
                if (list != null) {
                    textView7.setText(list.get(2).getName());
                    this.actionFromButton2 = list.get(2);
                    Unit unit17 = Unit.INSTANCE;
                    Unit unit18 = Unit.INSTANCE;
                }
                textView7.invalidate();
                Unit unit19 = Unit.INSTANCE;
                TextView textView8 = this.binding.button3;
                textView8.setVisibility(this.visible);
                if (list != null) {
                    textView8.setText(list.get(1).getName());
                    this.actionFromButton3 = list.get(1);
                    Unit unit20 = Unit.INSTANCE;
                    Unit unit21 = Unit.INSTANCE;
                }
                textView8.invalidate();
                Unit unit22 = Unit.INSTANCE;
                this.binding.button4.setVisibility(this.invisible);
                TextView textView9 = this.binding.button5;
                textView9.setVisibility(this.visible);
                textView9.setText(this.backButtonsText);
                textView9.setCompoundDrawablesWithIntrinsicBounds(this.iconBack, 0, 0, 0);
                textView9.invalidate();
                Unit unit23 = Unit.INSTANCE;
                TextView textView10 = this.binding.button6;
                textView10.setVisibility(this.visible);
                if (list != null) {
                    textView10.setText(list.get(0).getName());
                    this.actionFromButton6 = list.get(0);
                    Unit unit24 = Unit.INSTANCE;
                    Unit unit25 = Unit.INSTANCE;
                }
                textView10.invalidate();
                Unit unit26 = Unit.INSTANCE;
                this.binding.button7.setVisibility(this.invisible);
                return;
            case 4:
                this.binding.buttonWithNickname.setVisibility(this.visible);
                Unit unit27 = Unit.INSTANCE;
                TextView textView11 = this.binding.button1;
                textView11.setVisibility(this.visible);
                if (list != null) {
                    textView11.setText(list.get(3).getName());
                    this.actionFromButton1 = list.get(3);
                    Unit unit28 = Unit.INSTANCE;
                    Unit unit29 = Unit.INSTANCE;
                }
                textView11.invalidate();
                Unit unit30 = Unit.INSTANCE;
                this.binding.button2.setVisibility(this.invisible);
                TextView textView12 = this.binding.button3;
                textView12.setVisibility(this.visible);
                if (list != null) {
                    textView12.setText(list.get(2).getName());
                    this.actionFromButton3 = list.get(2);
                    Unit unit31 = Unit.INSTANCE;
                    Unit unit32 = Unit.INSTANCE;
                }
                textView12.invalidate();
                Unit unit33 = Unit.INSTANCE;
                TextView textView13 = this.binding.button4;
                textView13.setVisibility(this.visible);
                textView13.setText(this.backButtonsText);
                textView13.setCompoundDrawablesWithIntrinsicBounds(this.iconBack, 0, 0, 0);
                textView13.invalidate();
                Unit unit34 = Unit.INSTANCE;
                TextView textView14 = this.binding.button5;
                textView14.setVisibility(this.visible);
                if (list != null) {
                    textView14.setText(list.get(1).getName());
                    this.actionFromButton5 = list.get(1);
                    Unit unit35 = Unit.INSTANCE;
                    Unit unit36 = Unit.INSTANCE;
                }
                textView14.invalidate();
                Unit unit37 = Unit.INSTANCE;
                this.binding.button6.setVisibility(this.invisible);
                TextView textView15 = this.binding.button7;
                textView15.setVisibility(this.visible);
                if (list != null) {
                    textView15.setText(list.get(0).getName());
                    this.actionFromButton7 = list.get(0);
                    Unit unit38 = Unit.INSTANCE;
                    Unit unit39 = Unit.INSTANCE;
                }
                textView15.invalidate();
                Unit unit40 = Unit.INSTANCE;
                return;
            case 5:
                this.binding.buttonWithNickname.setVisibility(this.visible);
                Unit unit41 = Unit.INSTANCE;
                TextView textView16 = this.binding.button1;
                textView16.setVisibility(this.visible);
                if (list != null) {
                    textView16.setText(list.get(4).getName());
                    this.actionFromButton1 = list.get(4);
                    Unit unit42 = Unit.INSTANCE;
                    Unit unit43 = Unit.INSTANCE;
                }
                textView16.invalidate();
                Unit unit44 = Unit.INSTANCE;
                TextView textView17 = this.binding.button2;
                textView17.setVisibility(this.visible);
                if (list != null) {
                    textView17.setText(list.get(3).getName());
                    this.actionFromButton2 = list.get(3);
                    Unit unit45 = Unit.INSTANCE;
                    Unit unit46 = Unit.INSTANCE;
                }
                textView17.invalidate();
                Unit unit47 = Unit.INSTANCE;
                TextView textView18 = this.binding.button3;
                textView18.setVisibility(this.visible);
                if (list != null) {
                    textView18.setText(list.get(2).getName());
                    this.actionFromButton3 = list.get(2);
                    Unit unit48 = Unit.INSTANCE;
                    Unit unit49 = Unit.INSTANCE;
                }
                textView18.invalidate();
                Unit unit50 = Unit.INSTANCE;
                this.binding.button4.setVisibility(this.invisible);
                TextView textView19 = this.binding.button5;
                textView19.setVisibility(this.visible);
                textView19.setText(this.backButtonsText);
                textView19.setCompoundDrawablesWithIntrinsicBounds(this.iconBack, 0, 0, 0);
                textView19.invalidate();
                Unit unit51 = Unit.INSTANCE;
                TextView textView20 = this.binding.button6;
                textView20.setVisibility(this.visible);
                if (list != null) {
                    textView20.setText(list.get(1).getName());
                    this.actionFromButton6 = list.get(1);
                    Unit unit52 = Unit.INSTANCE;
                    Unit unit53 = Unit.INSTANCE;
                }
                textView20.invalidate();
                Unit unit54 = Unit.INSTANCE;
                TextView textView21 = this.binding.button7;
                textView21.setVisibility(this.visible);
                if (list != null) {
                    textView21.setText(list.get(0).getName());
                    this.actionFromButton7 = list.get(0);
                    Unit unit55 = Unit.INSTANCE;
                    Unit unit56 = Unit.INSTANCE;
                }
                textView21.invalidate();
                Unit unit57 = Unit.INSTANCE;
                return;
            case 6:
                this.binding.buttonWithNickname.setVisibility(this.visible);
                Unit unit58 = Unit.INSTANCE;
                TextView textView22 = this.binding.button1;
                textView22.setVisibility(this.visible);
                if (z) {
                    if (list != null) {
                        textView22.setText(list.get(4).getName());
                        this.actionFromButton1 = list.get(4);
                        Unit unit59 = Unit.INSTANCE;
                        Unit unit60 = Unit.INSTANCE;
                    }
                } else if (list != null) {
                    textView22.setText(list.get(5).getName());
                    this.actionFromButton1 = list.get(5);
                    Unit unit61 = Unit.INSTANCE;
                    Unit unit62 = Unit.INSTANCE;
                }
                textView22.invalidate();
                Unit unit63 = Unit.INSTANCE;
                TextView textView23 = this.binding.button2;
                textView23.setVisibility(this.visible);
                if (z) {
                    if (list != null) {
                        textView23.setText(list.get(3).getName());
                        this.actionFromButton2 = list.get(3);
                        Unit unit64 = Unit.INSTANCE;
                        Unit unit65 = Unit.INSTANCE;
                    }
                } else if (list != null) {
                    textView23.setText(list.get(4).getName());
                    this.actionFromButton2 = list.get(4);
                    Unit unit66 = Unit.INSTANCE;
                    Unit unit67 = Unit.INSTANCE;
                }
                textView23.invalidate();
                Unit unit68 = Unit.INSTANCE;
                TextView textView24 = this.binding.button3;
                textView24.setVisibility(this.visible);
                if (z) {
                    textView24.setText(textView24.getContext().getText(R.string.if_with_additionally));
                    textView24.setCompoundDrawablesWithIntrinsicBounds(this.iconAdditionally, 0, 0, 0);
                } else if (list != null) {
                    textView24.setText(list.get(3).getName());
                    this.actionFromButton3 = list.get(3);
                    Unit unit69 = Unit.INSTANCE;
                    Unit unit70 = Unit.INSTANCE;
                }
                textView24.invalidate();
                Unit unit71 = Unit.INSTANCE;
                TextView textView25 = this.binding.button4;
                textView25.setVisibility(this.visible);
                textView25.setText(this.backButtonsText);
                textView25.setCompoundDrawablesWithIntrinsicBounds(this.iconBack, 0, 0, 0);
                textView25.invalidate();
                Unit unit72 = Unit.INSTANCE;
                TextView textView26 = this.binding.button5;
                textView26.setVisibility(this.visible);
                if (list != null) {
                    textView26.setText(list.get(2).getName());
                    this.actionFromButton5 = list.get(2);
                    Unit unit73 = Unit.INSTANCE;
                    Unit unit74 = Unit.INSTANCE;
                }
                textView26.invalidate();
                Unit unit75 = Unit.INSTANCE;
                TextView textView27 = this.binding.button6;
                textView27.setVisibility(this.visible);
                if (list != null) {
                    textView27.setText(list.get(1).getName());
                    this.actionFromButton6 = list.get(1);
                    Unit unit76 = Unit.INSTANCE;
                    Unit unit77 = Unit.INSTANCE;
                }
                textView27.invalidate();
                Unit unit78 = Unit.INSTANCE;
                TextView textView28 = this.binding.button7;
                textView28.setVisibility(this.visible);
                if (list != null) {
                    textView28.setText(list.get(0).getName());
                    this.actionFromButton7 = list.get(0);
                    Unit unit79 = Unit.INSTANCE;
                    Unit unit80 = Unit.INSTANCE;
                }
                textView28.invalidate();
                Unit unit81 = Unit.INSTANCE;
                return;
            default:
                return;
        }
    }

    private final void updateParameterForButton(int i) {
        ViewGroup.LayoutParams layoutParams = this.binding.buttonWithNickname.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ViewGroup.LayoutParams layoutParams3 = this.binding.button1.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        ViewGroup.LayoutParams layoutParams5 = this.binding.button2.getLayoutParams();
        Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
        ViewGroup.LayoutParams layoutParams7 = this.binding.button3.getLayoutParams();
        Objects.requireNonNull(layoutParams7, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) layoutParams7;
        ViewGroup.LayoutParams layoutParams9 = this.binding.button4.getLayoutParams();
        Objects.requireNonNull(layoutParams9, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) layoutParams9;
        ViewGroup.LayoutParams layoutParams11 = this.binding.button5.getLayoutParams();
        Objects.requireNonNull(layoutParams11, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) layoutParams11;
        ViewGroup.LayoutParams layoutParams13 = this.binding.button6.getLayoutParams();
        Objects.requireNonNull(layoutParams13, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams14 = (ConstraintLayout.LayoutParams) layoutParams13;
        ViewGroup.LayoutParams layoutParams15 = this.binding.button7.getLayoutParams();
        Objects.requireNonNull(layoutParams15, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams16 = (ConstraintLayout.LayoutParams) layoutParams15;
        int id = this.binding.closeInteraction.getId();
        switch (i) {
            case 0:
                layoutParams2.startToStart = id;
                layoutParams2.endToEnd = id;
                layoutParams2.bottomToTop = id;
                layoutParams2.setMargins(0, 0, 0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_0_elements_0_4));
                Unit unit = Unit.INSTANCE;
                layoutParams10.startToStart = id;
                layoutParams10.endToEnd = id;
                layoutParams10.topToBottom = id;
                layoutParams10.setMargins(0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_0_elements_0_4), 0, 0);
                Unit unit2 = Unit.INSTANCE;
                return;
            case 1:
                layoutParams2.startToStart = id;
                layoutParams2.endToEnd = id;
                layoutParams2.bottomToTop = id;
                layoutParams2.setMargins(0, 0, 0, getMarginInPixel(R.dimen.margin_bottom_if_1_elements_0));
                Unit unit3 = Unit.INSTANCE;
                layoutParams8.topToBottom = id;
                layoutParams8.startToEnd = id;
                layoutParams8.setMargins(getMarginInPixel(R.dimen.margin_end_and_start_if_1_elements_3_5), getMarginInPixel(R.dimen.margin_bottom_and_top_if_1_elements_3_5), 0, 0);
                Unit unit4 = Unit.INSTANCE;
                layoutParams12.topToBottom = id;
                layoutParams12.endToStart = id;
                layoutParams12.setMargins(0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_1_elements_3_5), getMarginInPixel(R.dimen.margin_end_and_start_if_1_elements_3_5), 0);
                Unit unit5 = Unit.INSTANCE;
                return;
            case 2:
                layoutParams2.startToStart = id;
                layoutParams2.endToEnd = id;
                layoutParams2.bottomToTop = id;
                layoutParams2.setMargins(0, 0, 0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_2_elements_0_4));
                Unit unit6 = Unit.INSTANCE;
                layoutParams10.startToStart = id;
                layoutParams10.endToEnd = id;
                layoutParams10.topToBottom = id;
                layoutParams10.setMargins(0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_2_elements_0_4), 0, 0);
                Unit unit7 = Unit.INSTANCE;
                layoutParams6.topToTop = id;
                layoutParams6.bottomToBottom = id;
                layoutParams6.startToEnd = id;
                layoutParams6.setMargins(getMarginInPixel(R.dimen.margin_end_and_start_if_2_elements_2_6), 0, 0, 0);
                Unit unit8 = Unit.INSTANCE;
                layoutParams14.topToTop = id;
                layoutParams14.bottomToBottom = id;
                layoutParams14.endToStart = id;
                layoutParams14.setMargins(0, 0, getMarginInPixel(R.dimen.margin_end_and_start_if_2_elements_2_6), 0);
                Unit unit9 = Unit.INSTANCE;
                return;
            case 3:
                layoutParams2.startToStart = id;
                layoutParams2.endToEnd = id;
                layoutParams2.bottomToTop = id;
                layoutParams2.setMargins(0, 0, 0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_3_elements_0));
                Unit unit10 = Unit.INSTANCE;
                layoutParams6.topToTop = id;
                layoutParams6.bottomToBottom = id;
                layoutParams6.startToEnd = id;
                layoutParams6.setMargins(getMarginInPixel(R.dimen.margin_end_and_start_if_3_elements_2_6), 0, 0, 0);
                Unit unit11 = Unit.INSTANCE;
                layoutParams14.topToTop = id;
                layoutParams14.bottomToBottom = id;
                layoutParams14.endToStart = id;
                layoutParams14.setMargins(0, 0, getMarginInPixel(R.dimen.margin_end_and_start_if_3_elements_2_6), 0);
                Unit unit12 = Unit.INSTANCE;
                layoutParams8.topToBottom = id;
                layoutParams8.startToEnd = id;
                layoutParams8.setMargins(getMarginInPixel(R.dimen.margin_end_and_start_if_3_elements_3_5), getMarginInPixel(R.dimen.margin_top_if_3_elements_3_5), 0, 0);
                Unit unit13 = Unit.INSTANCE;
                layoutParams12.topToBottom = id;
                layoutParams12.endToStart = id;
                layoutParams12.setMargins(0, getMarginInPixel(R.dimen.margin_top_if_3_elements_3_5), getMarginInPixel(R.dimen.margin_end_and_start_if_3_elements_3_5), 0);
                Unit unit14 = Unit.INSTANCE;
                return;
            case 4:
                layoutParams2.startToStart = id;
                layoutParams2.endToEnd = id;
                layoutParams2.bottomToTop = id;
                layoutParams2.setMargins(0, 0, 0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_4_elements_0_4));
                Unit unit15 = Unit.INSTANCE;
                layoutParams10.startToStart = id;
                layoutParams10.endToEnd = id;
                layoutParams10.topToBottom = id;
                layoutParams10.setMargins(0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_4_elements_0_4), 0, 0);
                Unit unit16 = Unit.INSTANCE;
                layoutParams4.bottomToTop = id;
                layoutParams4.startToEnd = id;
                layoutParams4.setMargins(getMarginInPixel(R.dimen.margin_end_and_start_if_4_elements_1_3_5_7), 0, 0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_4_elements_1_3_5_7));
                Unit unit17 = Unit.INSTANCE;
                layoutParams16.bottomToTop = id;
                layoutParams16.endToStart = id;
                layoutParams16.setMargins(0, 0, getMarginInPixel(R.dimen.margin_end_and_start_if_4_elements_1_3_5_7), getMarginInPixel(R.dimen.margin_bottom_and_top_if_4_elements_1_3_5_7));
                Unit unit18 = Unit.INSTANCE;
                layoutParams8.topToBottom = id;
                layoutParams8.startToEnd = id;
                layoutParams8.setMargins(getMarginInPixel(R.dimen.margin_end_and_start_if_4_elements_1_3_5_7), getMarginInPixel(R.dimen.margin_bottom_and_top_if_4_elements_1_3_5_7), 0, 0);
                Unit unit19 = Unit.INSTANCE;
                layoutParams12.topToBottom = id;
                layoutParams12.endToStart = id;
                layoutParams12.setMargins(0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_4_elements_1_3_5_7), getMarginInPixel(R.dimen.margin_end_and_start_if_4_elements_1_3_5_7), 0);
                Unit unit20 = Unit.INSTANCE;
                return;
            case 5:
                layoutParams2.startToStart = id;
                layoutParams2.endToEnd = id;
                layoutParams2.bottomToTop = id;
                layoutParams2.setMargins(0, 0, 0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_5_elements_0));
                Unit unit21 = Unit.INSTANCE;
                layoutParams4.bottomToTop = id;
                layoutParams4.startToEnd = id;
                layoutParams4.setMargins(getMarginInPixel(R.dimen.margin_end_and_start_if_5_elements_1_2_6_7), 0, 0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_5_elements_1_2_6_7));
                Unit unit22 = Unit.INSTANCE;
                layoutParams16.bottomToTop = id;
                layoutParams16.endToStart = id;
                layoutParams16.setMargins(0, 0, getMarginInPixel(R.dimen.margin_end_and_start_if_5_elements_1_2_6_7), getMarginInPixel(R.dimen.margin_bottom_and_top_if_5_elements_1_2_6_7));
                Unit unit23 = Unit.INSTANCE;
                layoutParams6.topToTop = -1;
                layoutParams6.bottomToBottom = -1;
                layoutParams6.startToEnd = id;
                layoutParams6.topToBottom = id;
                layoutParams6.startToEnd = id;
                layoutParams6.setMargins(getMarginInPixel(R.dimen.margin_end_and_start_if_5_elements_1_2_6_7), getMarginInPixel(R.dimen.margin_bottom_and_top_if_5_elements_1_2_6_7), 0, 0);
                Unit unit24 = Unit.INSTANCE;
                layoutParams14.topToTop = -1;
                layoutParams14.bottomToBottom = -1;
                layoutParams14.topToBottom = id;
                layoutParams14.endToStart = id;
                layoutParams14.setMargins(0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_5_elements_1_2_6_7), getMarginInPixel(R.dimen.margin_end_and_start_if_5_elements_1_2_6_7), 0);
                Unit unit25 = Unit.INSTANCE;
                layoutParams8.topToBottom = id;
                layoutParams8.startToEnd = id;
                layoutParams8.setMargins(getMarginInPixel(R.dimen.margin_end_and_start_if_5_elements_3_5), getMarginInPixel(R.dimen.margin_top_if_5_elements_3_5), 0, 0);
                Unit unit26 = Unit.INSTANCE;
                layoutParams12.topToBottom = id;
                layoutParams12.endToStart = id;
                layoutParams12.setMargins(0, getMarginInPixel(R.dimen.margin_top_if_5_elements_3_5), getMarginInPixel(R.dimen.margin_end_and_start_if_5_elements_3_5), 0);
                Unit unit27 = Unit.INSTANCE;
                return;
            case 6:
                layoutParams2.startToStart = id;
                layoutParams2.endToEnd = id;
                layoutParams2.bottomToTop = id;
                layoutParams2.setMargins(0, 0, 0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_6_elements_0_4));
                Unit unit28 = Unit.INSTANCE;
                layoutParams10.startToStart = id;
                layoutParams10.endToEnd = id;
                layoutParams10.topToBottom = id;
                layoutParams10.setMargins(0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_6_elements_0_4), 0, 0);
                Unit unit29 = Unit.INSTANCE;
                layoutParams4.bottomToTop = id;
                layoutParams4.startToEnd = id;
                layoutParams4.setMargins(getMarginInPixel(R.dimen.margin_end_and_start_if_6_elements_1_3_5_7), 0, 0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_6_elements_1_3_5_7));
                Unit unit30 = Unit.INSTANCE;
                layoutParams16.bottomToTop = id;
                layoutParams16.endToStart = id;
                layoutParams16.setMargins(0, 0, getMarginInPixel(R.dimen.margin_end_and_start_if_6_elements_1_3_5_7), getMarginInPixel(R.dimen.margin_bottom_and_top_if_6_elements_1_3_5_7));
                Unit unit31 = Unit.INSTANCE;
                layoutParams6.topToTop = id;
                layoutParams6.bottomToBottom = id;
                layoutParams6.startToEnd = id;
                layoutParams6.setMargins(getMarginInPixel(R.dimen.margin_end_and_start_if_6_elements_2_6), 0, 0, 0);
                Unit unit32 = Unit.INSTANCE;
                layoutParams14.topToTop = id;
                layoutParams14.bottomToBottom = id;
                layoutParams14.endToStart = id;
                layoutParams14.setMargins(0, 0, getMarginInPixel(R.dimen.margin_end_and_start_if_6_elements_2_6), 0);
                Unit unit33 = Unit.INSTANCE;
                layoutParams8.topToBottom = id;
                layoutParams8.startToEnd = id;
                layoutParams8.setMargins(getMarginInPixel(R.dimen.margin_end_and_start_if_6_elements_1_3_5_7), getMarginInPixel(R.dimen.margin_bottom_and_top_if_6_elements_1_3_5_7), 0, 0);
                Unit unit34 = Unit.INSTANCE;
                layoutParams12.topToBottom = id;
                layoutParams12.endToStart = id;
                layoutParams12.setMargins(0, getMarginInPixel(R.dimen.margin_bottom_and_top_if_6_elements_1_3_5_7), getMarginInPixel(R.dimen.margin_end_and_start_if_6_elements_1_3_5_7), 0);
                Unit unit35 = Unit.INSTANCE;
                return;
            default:
                return;
        }
    }

    private final void setMarque(TextView textView) {
        if (textView.getWidth() > getMarginInPixel(R.dimen.test_width)) {
            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            textView.setMarqueeRepeatLimit(-1);
            textView.setSelected(true);
            return;
        }
        textView.setEllipsize(null);
        textView.setMarqueeRepeatLimit(-1);
        textView.setSelected(false);
    }

    private final int getMarginInPixel(int i) {
        return this.resource.getDimensionPixelSize(i);
    }

    public final void setStartButtons(String playersNick, int i, int i2) {
        Intrinsics.checkNotNullParameter(playersNick, "playersNick");
        if (i2 == 0) {
            startLogicForSetView(1, false, 0, null);
            this.binding.button3.setText("Общение");
            this.binding.button3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.social_interaction_icon_chat, 0, 0, 0);
            this.binding.button5.setText("Социальные");
            this.binding.button5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.social_interaction_icon_exchange, 0, 0, 0);
        } else {
            startLogicForSetView(2, false, 0, null);
            this.binding.button2.setText("Общение");
            this.binding.button2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.social_interaction_icon_chat, 0, 0, 0);
            this.binding.button4.setText("Социальные");
            this.binding.button4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.social_interaction_icon_exchange, 0, 0, 0);
            this.binding.button6.setText("Рабочие");
            this.binding.button6.setCompoundDrawablesWithIntrinsicBounds(R.drawable.social_interaction_icon_star, 0, 0, 0);
        }
        setPlayersInfo(playersNick, i);
    }

    public final void setPlayersInfo(String playersNick, int i) {
        Intrinsics.checkNotNullParameter(playersNick, "playersNick");
        this.binding.buttonWithNickname.setText(this.context.getString(R.string.players_nick_with_id, new Object[]{playersNick, String.valueOf(i)}));
    }

    public final void updateButtonsText(int i, int i2) {
        if (i == 1) {
            this.thisActionsList = this.root.getThisListWithOrganizationMain();
        } else if (i == 2) {
            this.thisActionsList = this.root.getThisListWithSocialMain();
        } else if (i == 3) {
            this.thisActionsList = this.root.getThisListWithCommunicationMain();
        } else if (i == 4) {
            setStartButtons(this.root.getPlayersNick(), this.root.getPlayersId(), this.root.getStatusInOrganization());
            return;
        }
        int size = this.thisActionsList.size();
        boolean z = false;
        if (size <= 6) {
            startLogicForSetView(size, false, i, this.thisActionsList);
            return;
        }
        int i3 = 0;
        for (SocialInteraction socialInteraction : this.thisActionsList) {
            if (socialInteraction.getPage() == i2) {
                i3++;
            }
            if (socialInteraction.getPage() > i2) {
                z = true;
            }
        }
        if (z) {
            i3++;
        }
        startLogicForSetView(i3, z, i, getIntermediateListWithActions(this.thisActionsList, i2));
    }

    private final List<SocialInteraction> getIntermediateListWithActions(List<SocialInteraction> list, int i) {
        ArrayList arrayList = new ArrayList();
        for (SocialInteraction socialInteraction : list) {
            if (socialInteraction.getPage() == i) {
                arrayList.add(socialInteraction);
            }
        }
        return arrayList;
    }
}
