package com.rockstargames.gtacr.gui.fractions;

import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionsBuyTokensLayoutBinding;
import com.bumptech.glide.Glide;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.common.CustomEditTextWithBackPressEvent;
import com.rockstargames.gtacr.gui.Useful;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsMainViewModel;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0016H\u0002J\u0006\u0010\u001a\u001a\u00020\u0012R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/UIBuyTokensDialog;", "", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "mainRoot", "Lcom/rockstargames/gtacr/gui/fractions/GUIFractionSystem;", "mainViewModel", "Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsMainViewModel;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/fractions/GUIFractionSystem;Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsMainViewModel;)V", "anim", "Landroid/view/animation/Animation;", "binding", "Lblackrussia/online/databinding/FractionsBuyTokensLayoutBinding;", "blockedSpam", "", "dialogBuyTokens", "Landroid/widget/PopupWindow;", "closeDialog", "", "removeObservers", "setBCValue", "bcValue", "", "setObservers", "setValuePrice", "sum", "showDialog", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIBuyTokensDialog {
    private Animation anim;
    private FractionsBuyTokensLayoutBinding binding;
    private boolean blockedSpam;
    private final NvEventQueueActivity context;
    private PopupWindow dialogBuyTokens;
    private final GUIFractionSystem mainRoot;
    private final FractionsMainViewModel mainViewModel;

    public UIBuyTokensDialog(NvEventQueueActivity context, GUIFractionSystem mainRoot, FractionsMainViewModel mainViewModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(mainViewModel, "mainViewModel");
        this.context = context;
        this.mainRoot = mainRoot;
        this.mainViewModel = mainViewModel;
        Object systemService = context.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        FractionsBuyTokensLayoutBinding inflate = FractionsBuyTokensLayoutBinding.inflate((LayoutInflater) systemService);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        Animation loadAnimation = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        Intrinsics.checkNotNullExpressionValue(loadAnimation, "loadAnimation(binding.ro…ext, R.anim.button_click)");
        this.anim = loadAnimation;
        this.dialogBuyTokens = new PopupWindow((View) this.binding.getRoot(), -1, -1, true);
        setObservers();
        PopupWindow popupWindow = this.dialogBuyTokens;
        if (popupWindow != null) {
            popupWindow.setSoftInputMode(16);
        }
        this.binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIBuyTokensDialog.m249_init_$lambda1(UIBuyTokensDialog.this, view);
            }
        });
        this.binding.buttonByuTokens.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIBuyTokensDialog.m250_init_$lambda3(UIBuyTokensDialog.this, view);
            }
        });
        PopupWindow popupWindow2 = this.dialogBuyTokens;
        if (popupWindow2 != null) {
            popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public final void onDismiss() {
                    UIBuyTokensDialog.m251_init_$lambda4(UIBuyTokensDialog.this);
                }
            });
        }
        CustomEditTextWithBackPressEvent customEditTextWithBackPressEvent = this.binding.editTextTokens;
        Intrinsics.checkNotNullExpressionValue(customEditTextWithBackPressEvent, "binding.editTextTokens");
        customEditTextWithBackPressEvent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                FractionsMainViewModel fractionsMainViewModel;
                FractionsMainViewModel fractionsMainViewModel2;
                FractionsMainViewModel fractionsMainViewModel3;
                Editable editable2 = editable;
                if (!(editable2 == null || editable2.length() == 0)) {
                    fractionsMainViewModel3 = UIBuyTokensDialog.this.mainViewModel;
                    fractionsMainViewModel3.sendKeyWithType(7, 1, Const.FRACTION_ADD_TOKENS_TOKEN_AMOUNT, Integer.parseInt(editable.toString()));
                    return;
                }
                fractionsMainViewModel = UIBuyTokensDialog.this.mainViewModel;
                fractionsMainViewModel.sendKeyWithType(7, 1, Const.FRACTION_ADD_TOKENS_TOKEN_AMOUNT, 0);
                fractionsMainViewModel2 = UIBuyTokensDialog.this.mainViewModel;
                fractionsMainViewModel2.setAddTokensPrice(0);
            }
        });
        this.binding.editTextTokens.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                boolean m252_init_$lambda6;
                m252_init_$lambda6 = UIBuyTokensDialog.m252_init_$lambda6(UIBuyTokensDialog.this, view, i, keyEvent);
                return m252_init_$lambda6;
            }
        });
        this.binding.editTextTokens.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() {
            @Override
            public final void callback() {
                UIBuyTokensDialog.m253_init_$lambda7(UIBuyTokensDialog.this);
            }
        });
    }

    public static final void m249_init_$lambda1(UIBuyTokensDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.startAnimation(this$0.anim);
        if (this$0.blockedSpam) {
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UIBuyTokensDialog.m259lambda1$lambda0(this$0);
            }
        }, 200L);
        this$0.blockedSpam = true;
    }

    public static final void m259lambda1$lambda0(UIBuyTokensDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.blockedSpam = false;
        this$0.closeDialog();
    }

    public static final void m250_init_$lambda3(UIBuyTokensDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.startAnimation(this$0.anim);
        if (this$0.blockedSpam) {
            return;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                UIBuyTokensDialog.m260lambda3$lambda2(this$0);
            }
        }, 200L);
        this$0.blockedSpam = true;
    }

    public static final void m260lambda3$lambda2(UIBuyTokensDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.blockedSpam = false;
        this$0.mainViewModel.sendButtonPressed(7, 14);
        this$0.binding.editTextTokens.getEditableText().clear();
    }

    public static final void m251_init_$lambda4(UIBuyTokensDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.removeObservers();
        this$0.mainRoot.closeAndroidsButtons();
        this$0.mainViewModel.sendButtonPressed(7, 21);
        this$0.binding.editTextTokens.getEditableText().clear();
    }

    public static final boolean m252_init_$lambda6(UIBuyTokensDialog this$0, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == 66) {
            Object systemService = this$0.context.getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(this$0.binding.getRoot().getWindowToken(), 0);
            view.setFocusable(false);
            view.setFocusableInTouchMode(true);
            return true;
        }
        return false;
    }

    public static final void m253_init_$lambda7(UIBuyTokensDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object systemService = this$0.context.getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(this$0.binding.getRoot().getWindowToken(), 0);
        this$0.binding.editTextTokens.setFocusable(false);
        this$0.binding.editTextTokens.setFocusableInTouchMode(true);
    }

    private final void setObservers() {
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(this.context);
        if (lifecycleOwner == null) {
            return;
        }
        this.mainViewModel.getAddTokensPriceLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIBuyTokensDialog.m261setObservers$lambda10$lambda8(UIBuyTokensDialog.this, (Integer) obj);
            }
        });
        this.mainViewModel.getAddAddTokensBCValueLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIBuyTokensDialog.m262setObservers$lambda10$lambda9(UIBuyTokensDialog.this, (Integer) obj);
            }
        });
    }

    public static final void m261setObservers$lambda10$lambda8(UIBuyTokensDialog this$0, Integer price) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(price, "price");
        this$0.setValuePrice(price.intValue());
    }

    public static final void m262setObservers$lambda10$lambda9(UIBuyTokensDialog this$0, Integer bcValue) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(bcValue, "bcValue");
        this$0.setBCValue(bcValue.intValue());
    }

    private final void removeObservers() {
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(this.context);
        if (lifecycleOwner == null) {
            return;
        }
        this.mainViewModel.getAddTokensPriceLiveData().removeObservers(lifecycleOwner);
        this.mainViewModel.getAddAddTokensBCValueLiveData().removeObservers(lifecycleOwner);
    }

    public final void showDialog() {
        PopupWindow popupWindow = this.dialogBuyTokens;
        if (popupWindow != null) {
            popupWindow.showAtLocation(this.context.getParentLayout(), 17, 0, 0);
        }
        new Useful().closeAndroidsInterface(this.context, this.dialogBuyTokens);
        Glide.with(this.binding.getRoot().getContext()).load(Integer.valueOf((int) R.drawable.fractions_new_rank_layout_bg)).centerCrop().into(this.binding.bgEffectShadow);
    }

    private final void closeDialog() {
        PopupWindow popupWindow = this.dialogBuyTokens;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    private final void setBCValue(int i) {
        String string = this.context.getString(R.string.fractions_buy_tokens_bc_value, new Object[]{new Useful().getPriceWithSpacesForInt(i)});
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ithSpacesForInt(bcValue))");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.context, R.color.color_FFA61D)), this.context.getString(R.string.fractions_buy_tokens_bc_value).length() - 5, spannableString.length(), 33);
        this.binding.textViewBcValue.setText(spannableString);
    }

    private final void setValuePrice(int i) {
        String string = this.context.getString(R.string.fractions_buy_tokens_buy_for, new Object[]{new Useful().getPriceWithSpacesForInt(i)});
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…iceWithSpacesForInt(sum))");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.context, R.color.color_FFA61D)), 14, spannableString.length(), 33);
        this.binding.textViewBuyTokensFor.setText(FractionsUtilsKt.transformSpannableToUpperCase(spannableString));
    }
}
