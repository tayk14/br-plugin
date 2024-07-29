package com.rockstargames.gtacr.gui.fractions;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.FractionsControlLayoutBinding;
import blackrussia.online.network.fraction.data.FractionControlListOfPlayers;
import blackrussia.online.network.fraction.data.FractionControlPlayerInfo;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.FractionsControlManagementAdapter;
import com.rockstargames.gtacr.adapters.FractionsControlSortByAdapter;
import com.rockstargames.gtacr.adapters.FractionsControlStaffListAdapter;
import com.rockstargames.gtacr.common.CustomEditTextWithBackPressEvent;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.FractionsSortByItem;
import com.rockstargames.gtacr.gui.CustomTypefaceSpanTextStyleBold;
import com.rockstargames.gtacr.gui.Useful;
import com.rockstargames.gtacr.gui.fractions.viewmodel.FractionsControlViewModel;
import com.rockstargames.gtacr.gui.inventory.Constants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

//@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0013H\u0002J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140 2\u0006\u0010!\u001a\u00020\u0014H\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140 2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020&H\u0016J\u001c\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020-H\u0016J\b\u0010/\u001a\u00020-H\u0002J\u001e\u00100\u001a\u00020-2\u0006\u00101\u001a\u0002022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160 H\u0002J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020-H\u0002J\b\u00107\u001a\u00020-H\u0002J\b\u00108\u001a\u00020-H\u0002J\b\u00109\u001a\u00020-H\u0002J\b\u0010:\u001a\u00020-H\u0002J\b\u0010;\u001a\u00020-H\u0002J\b\u0010<\u001a\u00020-H\u0002J\u0018\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$H\u0002J\u0010\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u000205H\u0002J\u0016\u0010C\u001a\u00020-2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160 H\u0002J\b\u0010D\u001a\u00020-H\u0002J\u000e\u0010E\u001a\u00020-2\u0006\u0010!\u001a\u00020\u0014J\b\u0010F\u001a\u00020-H\u0002J\b\u0010G\u001a\u00020-H\u0002J\u0016\u0010H\u001a\u00020-2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00160 H\u0002J\b\u0010J\u001a\u00020-H\u0002J\b\u0010K\u001a\u00020-H\u0002J\b\u0010L\u001a\u00020-H\u0002J\b\u0010M\u001a\u00020-H\u0002J\b\u0010N\u001a\u00020-H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/rockstargames/gtacr/gui/fractions/UIFractionsControlLayout;", "Lcom/rockstargames/gtacr/common/UILayout;", "activity", "Lcom/nvidia/devtech/NvEventQueueActivity;", "controlViewModel", "Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsControlViewModel;", "(Lcom/nvidia/devtech/NvEventQueueActivity;Lcom/rockstargames/gtacr/gui/fractions/viewmodel/FractionsControlViewModel;)V", "_binding", "Lblackrussia/online/databinding/FractionsControlLayoutBinding;", "anim", "Landroid/view/animation/Animation;", "binding", "getBinding", "()Lblackrussia/online/databinding/FractionsControlLayoutBinding;", "controlManagementAdapter", "Lcom/rockstargames/gtacr/adapters/FractionsControlManagementAdapter;", "fractionsControlSortByAdapter", "Lcom/rockstargames/gtacr/adapters/FractionsControlSortByAdapter;", "listOfImagesForAdapter", "", "", "listOfPlayers", "Lblackrussia/online/network/fraction/data/FractionControlListOfPlayers;", "menuSortedPressed", "sortedListOfPlayers", "staffListAdapter", "Lcom/rockstargames/gtacr/adapters/FractionsControlStaffListAdapter;", "timeOldClickOnPlayerItem", "", "getListForSortByAdapter", "Lcom/rockstargames/gtacr/data/FractionsSortByItem;", "getListOfImagesForAdapter", "", "fractionId", "getListOfImagesFunction", "link", "", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "", "onLayoutShown", "removeVMObservers", "setEditTextChangeListener", "enteredTextLocation", "Landroid/text/Editable;", "setInfoAboutPlayer", "clickedItem", "Lblackrussia/online/network/fraction/data/FractionControlPlayerInfo;", "setLogicForOnMinusRankClickListener", "setLogicForOnMinusReprimandsListener", "setLogicForOnPlayerItemClick", "setLogicForOnPlusRankClickListener", "setLogicForOnPlusReprimandsListener", "setLogicForOnSortByItemClickListener", "setOnDismissFromFractionClickListener", "setTextRegular", "", TypedValues.Custom.S_STRING, "fullText", "setupControlManagementAdapter", "item", "setupEditTextSearch", "setupFractionsControlSortByAdapter", "setupListOfImagesForAdapter", "setupLiveDataObservers", "setupOnClickListeners", "setupStaffListAdapter", "list", "setupStaffListRecyclerView", "sortAscending", "sortDescending", "sortOnlyOffline", "sortOnlyOnline", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIFractionsControlLayout extends UILayout {
    private FractionsControlLayoutBinding _binding;
    private final NvEventQueueActivity activity;
    private Animation anim;
    private FractionsControlManagementAdapter controlManagementAdapter;
    private final FractionsControlViewModel controlViewModel;
    private FractionsControlSortByAdapter fractionsControlSortByAdapter;
    private final List<Integer> listOfImagesForAdapter;
    private List<FractionControlListOfPlayers> listOfPlayers;
    private int menuSortedPressed;
    private List<FractionControlListOfPlayers> sortedListOfPlayers;
    private FractionsControlStaffListAdapter staffListAdapter;
    private long timeOldClickOnPlayerItem;

    public UIFractionsControlLayout(NvEventQueueActivity activity, FractionsControlViewModel controlViewModel) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(controlViewModel, "controlViewModel");
        this.activity = activity;
        this.controlViewModel = controlViewModel;
        this.listOfPlayers = new ArrayList();
        this.sortedListOfPlayers = new ArrayList();
        this.menuSortedPressed = 3;
        this.listOfImagesForAdapter = new ArrayList();
    }

    private final FractionsControlLayoutBinding getBinding() {
        FractionsControlLayoutBinding fractionsControlLayoutBinding = this._binding;
        Intrinsics.checkNotNull(fractionsControlLayoutBinding);
        return fractionsControlLayoutBinding;
    }

    @Override
    public View getView() {
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this._binding = FractionsControlLayoutBinding.inflate(LayoutInflater.from(getContext()));
        this.anim = AnimationUtils.loadAnimation(getContext(), R.anim.button_click);
        this.controlViewModel.setMenuSortedPressed(3);
        setupStaffListRecyclerView();
        setupOnClickListeners();
        setupFractionsControlSortByAdapter();
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void setupLiveDataObservers() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(context);
        if (lifecycleOwner == null) {
            return;
        }
        this.controlViewModel.getNewPlayersReprimandLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIFractionsControlLayout.m273setupLiveDataObservers$lambda8$lambda0(UIFractionsControlLayout.this, (Integer) obj);
            }
        });
        this.controlViewModel.getNewPlayersRankLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIFractionsControlLayout.m274setupLiveDataObservers$lambda8$lambda2(UIFractionsControlLayout.this, (Integer) obj);
            }
        });
        this.controlViewModel.getNewPlayersPosition().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIFractionsControlLayout.m275setupLiveDataObservers$lambda8$lambda3(UIFractionsControlLayout.this, (String) obj);
            }
        });
        this.controlViewModel.getStaffListLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIFractionsControlLayout.m276setupLiveDataObservers$lambda8$lambda4(UIFractionsControlLayout.this, (List) obj);
            }
        });
        this.controlViewModel.getSortedStaffListLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIFractionsControlLayout.m277setupLiveDataObservers$lambda8$lambda5(UIFractionsControlLayout.this, (List) obj);
            }
        });
        this.controlViewModel.getMenuSortedPressedLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIFractionsControlLayout.m278setupLiveDataObservers$lambda8$lambda6(UIFractionsControlLayout.this, (Integer) obj);
            }
        });
        this.controlViewModel.getInfoAboutPlayerLiveData().observe(lifecycleOwner, new Observer() {
            @Override
            public final void onChanged(Object obj) {
                UIFractionsControlLayout.m279setupLiveDataObservers$lambda8$lambda7(UIFractionsControlLayout.this, (FractionControlPlayerInfo) obj);
            }
        });
    }

    public static final void m273setupLiveDataObservers$lambda8$lambda0(UIFractionsControlLayout this$0, Integer newReprimand) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GUIManager.hideSystemUI(this$0.getBinding().getRoot());
        Intrinsics.checkNotNullExpressionValue(newReprimand, "newReprimand");
        if (newReprimand.intValue() >= 0) {
            TextView textView = this$0.getBinding().textViewPlayersReprimands;
            String string = this$0.getContext().getString(R.string.fractions_control_players_reprimands);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ntrol_players_reprimands)");
            String string2 = this$0.getContext().getString(R.string.fractions_control_players_reprimands, newReprimand);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…            newReprimand)");
            textView.setText(this$0.setTextRegular(string, string2));
            FractionsControlManagementAdapter fractionsControlManagementAdapter = this$0.controlManagementAdapter;
            FractionControlPlayerInfo item = fractionsControlManagementAdapter == null ? null : fractionsControlManagementAdapter.getItem();
            if (item != null) {
                item.setReprimand(newReprimand.intValue());
            }
            FractionsControlManagementAdapter fractionsControlManagementAdapter2 = this$0.controlManagementAdapter;
            if (fractionsControlManagementAdapter2 == null) {
                return;
            }
            fractionsControlManagementAdapter2.notifyItemChanged(1);
        }
    }

    public static final void m274setupLiveDataObservers$lambda8$lambda2(UIFractionsControlLayout this$0, Integer newRank) {
        List<FractionControlListOfPlayers> list;
        Object obj = null;
        FractionControlListOfPlayers fractionControlListOfPlayers;
        List<FractionControlListOfPlayers> list2;
        List<FractionControlListOfPlayers> list3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GUIManager.hideSystemUI(this$0.getBinding().getRoot());
        Intrinsics.checkNotNullExpressionValue(newRank, "newRank");
        int intValue = newRank.intValue();
        if (1 <= intValue && intValue < 11) {
            TextView textView = this$0.getBinding().textViewPlayersRank;
            String string = this$0.getContext().getString(R.string.fractions_control_players_rank);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ons_control_players_rank)");
            String string2 = this$0.getContext().getString(R.string.fractions_control_players_rank, newRank);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…ol_players_rank, newRank)");
            textView.setText(this$0.setTextRegular(string, string2));
            FractionsControlManagementAdapter fractionsControlManagementAdapter = this$0.controlManagementAdapter;
            FractionControlListOfPlayers fractionControlListOfPlayers2 = null;
            FractionControlPlayerInfo item = fractionsControlManagementAdapter == null ? null : fractionsControlManagementAdapter.getItem();
            if (item != null) {
                item.setRank(newRank.intValue());
            }
            FractionsControlManagementAdapter fractionsControlManagementAdapter2 = this$0.controlManagementAdapter;
            if (fractionsControlManagementAdapter2 != null) {
                fractionsControlManagementAdapter2.notifyItemChanged(0);
            }
            FractionsControlStaffListAdapter fractionsControlStaffListAdapter = this$0.staffListAdapter;
            if (fractionsControlStaffListAdapter == null || (list = fractionsControlStaffListAdapter.getList()) == null) {
                fractionControlListOfPlayers = null;
            } else {
                fractionControlListOfPlayers = (FractionControlListOfPlayers) obj;
            }
            FractionsControlStaffListAdapter fractionsControlStaffListAdapter2 = this$0.staffListAdapter;
            Integer valueOf = (fractionsControlStaffListAdapter2 == null || (list2 = fractionsControlStaffListAdapter2.getList()) == null) ? null : Integer.valueOf(CollectionsKt.indexOf((List<? extends FractionControlListOfPlayers>) list2, fractionControlListOfPlayers));
            if (valueOf != null && valueOf.intValue() > -1) {
                FractionsControlStaffListAdapter fractionsControlStaffListAdapter3 = this$0.staffListAdapter;
                if (fractionsControlStaffListAdapter3 != null && (list3 = fractionsControlStaffListAdapter3.getList()) != null) {
                    fractionControlListOfPlayers2 = list3.get(valueOf.intValue());
                }
                if (fractionControlListOfPlayers2 != null) {
                    fractionControlListOfPlayers2.setRank(newRank.intValue());
                }
                FractionsControlStaffListAdapter fractionsControlStaffListAdapter4 = this$0.staffListAdapter;
                if (fractionsControlStaffListAdapter4 == null) {
                    return;
                }
                fractionsControlStaffListAdapter4.notifyItemChanged(valueOf.intValue());
                return;
            }
            Toast.makeText(this$0.getContext(), (int) R.string.fractions_control_error, 1).show();
        }
    }

    public static final void m275setupLiveDataObservers$lambda8$lambda3(UIFractionsControlLayout this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        TextView textView = this$0.getBinding().textViewPosition;
        String string = this$0.getContext().getString(R.string.fractions_control_players_position);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…control_players_position)");
        String string2 = this$0.getContext().getString(R.string.fractions_control_players_position, str);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…rs_position, newPosition)");
        textView.setText(this$0.setTextRegular(string, string2));
    }

    public static final void m276setupLiveDataObservers$lambda8$lambda4(UIFractionsControlLayout this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list != null) {
            this$0.listOfPlayers = list;
            this$0.setupEditTextSearch(list);
            int i = this$0.menuSortedPressed;
            if (i == 0) {
                this$0.sortOnlyOnline();
            } else if (i == 1) {
                this$0.sortOnlyOffline();
            } else if (i == 2) {
                this$0.sortAscending();
            } else if (i != 3) {
            } else {
                this$0.sortDescending();
            }
        }
    }

    public static final void m277setupLiveDataObservers$lambda8$lambda5(UIFractionsControlLayout this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list != null) {
            this$0.setupStaffListAdapter(list);
        }
    }

    public static final void m278setupLiveDataObservers$lambda8$lambda6(UIFractionsControlLayout this$0, Integer menuSortedPressed_) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (menuSortedPressed_ != null && menuSortedPressed_.intValue() == 0) {
            Intrinsics.checkNotNullExpressionValue(menuSortedPressed_, "menuSortedPressed_");
            this$0.menuSortedPressed = menuSortedPressed_.intValue();
            this$0.sortOnlyOnline();
        } else if (menuSortedPressed_ != null && menuSortedPressed_.intValue() == 1) {
            Intrinsics.checkNotNullExpressionValue(menuSortedPressed_, "menuSortedPressed_");
            this$0.menuSortedPressed = menuSortedPressed_.intValue();
            this$0.sortOnlyOffline();
        } else if (menuSortedPressed_ != null && menuSortedPressed_.intValue() == 2) {
            Intrinsics.checkNotNullExpressionValue(menuSortedPressed_, "menuSortedPressed_");
            this$0.menuSortedPressed = menuSortedPressed_.intValue();
            this$0.sortAscending();
        } else if (menuSortedPressed_ != null && menuSortedPressed_.intValue() == 3) {
            Intrinsics.checkNotNullExpressionValue(menuSortedPressed_, "menuSortedPressed_");
            this$0.menuSortedPressed = menuSortedPressed_.intValue();
            this$0.sortDescending();
        } else {
            this$0.sortDescending();
        }
    }

    public static final void m279setupLiveDataObservers$lambda8$lambda7(UIFractionsControlLayout this$0, FractionControlPlayerInfo fractionControlPlayerInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (fractionControlPlayerInfo != null) {
            this$0.setInfoAboutPlayer(fractionControlPlayerInfo);
        }
    }

    private final void removeVMObservers() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LifecycleOwner lifecycleOwner = FractionsUtilsKt.lifecycleOwner(context);
        if (lifecycleOwner == null) {
            return;
        }
        this.controlViewModel.getNewPlayersReprimandLiveData().removeObservers(lifecycleOwner);
        this.controlViewModel.getNewPlayersRankLiveData().removeObservers(lifecycleOwner);
        this.controlViewModel.getNewPlayersPosition().removeObservers(lifecycleOwner);
        this.controlViewModel.getStaffListLiveData().removeObservers(lifecycleOwner);
        this.controlViewModel.getSortedStaffListLiveData().removeObservers(lifecycleOwner);
        this.controlViewModel.getMenuSortedPressedLiveData().removeObservers(lifecycleOwner);
        this.controlViewModel.getInfoAboutPlayerLiveData().removeObservers(lifecycleOwner);
    }

    private final void setupStaffListRecyclerView() {
        getBinding().recyclerViewStaffList.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    }

    private final void setupEditTextSearch(final List<FractionControlListOfPlayers> list) {
        CustomEditTextWithBackPressEvent customEditTextWithBackPressEvent = getBinding().editTextSearchPlayer;
        Intrinsics.checkNotNullExpressionValue(customEditTextWithBackPressEvent, "binding.editTextSearchPlayer");
        customEditTextWithBackPressEvent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                int i;
                Editable editable2 = editable;
                if (editable2 == null || StringsKt.isBlank(editable2)) {
                    i = UIFractionsControlLayout.this.menuSortedPressed;
                    if (i == 0) {
                        UIFractionsControlLayout.this.sortOnlyOnline();
                        return;
                    } else if (i == 1) {
                        UIFractionsControlLayout.this.sortOnlyOffline();
                        return;
                    } else if (i == 2) {
                        UIFractionsControlLayout.this.sortAscending();
                        return;
                    } else if (i != 3) {
                        return;
                    } else {
                        UIFractionsControlLayout.this.sortDescending();
                        return;
                    }
                }
                UIFractionsControlLayout.this.setEditTextChangeListener(editable, list);
            }
        });
    }

    public final void setEditTextChangeListener(Editable editable, List<FractionControlListOfPlayers> list) {
        ArrayList arrayList = new ArrayList();
        String lowerCase = editable.toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        for (FractionControlListOfPlayers fractionControlListOfPlayers : list) {
            String lowerCase2 = fractionControlListOfPlayers.getNickname().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        }
        this.controlViewModel.setSortedStaffListLiveData(arrayList);
    }

    private final void setupOnClickListeners() {
        final FractionsControlLayoutBinding binding = getBinding();
        binding.imageButtonSearchPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIFractionsControlLayout.m280setupOnClickListeners$lambda15$lambda12(UIFractionsControlLayout.this, binding, view);
            }
        });
        binding.editTextSearchPlayer.setOnBackPressListener(new CustomEditTextWithBackPressEvent.MyEditTextListener() {
            @Override
            public final void callback() {
                UIFractionsControlLayout.m282setupOnClickListeners$lambda15$lambda13(UIFractionsControlLayout.this, binding);
            }
        });
        binding.imageButtonSortBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIFractionsControlLayout.m283setupOnClickListeners$lambda15$lambda14(UIFractionsControlLayout.this, binding, view);
            }
        });
    }

    public static final void m280setupOnClickListeners$lambda15$lambda12(UIFractionsControlLayout this$0, FractionsControlLayoutBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        view.startAnimation(this$0.anim);
        if (this_with.editTextSearchPlayer.getVisibility() == 0) {
            this_with.editTextSearchPlayer.setVisibility(4);
            this_with.imageButtonSortBy.setVisibility(0);
            this_with.textViewFractionStaffTitle.setVisibility(0);
            GUIManager.hideSystemUI(this$0.getBinding().getRoot());
            return;
        }
        this_with.editTextSearchPlayer.setVisibility(0);
        this_with.editTextSearchPlayer.setFocusable(false);
        this_with.editTextSearchPlayer.setFocusableInTouchMode(true);
        this_with.imageButtonSortBy.setVisibility(4);
        this_with.textViewFractionStaffTitle.setVisibility(4);
        if (this_with.recyclerViewSortBy.getVisibility() == 0) {
            this_with.recyclerViewSortBy.setVisibility(4);
            this_with.imageButtonSortBy.setBackgroundColor(ContextCompat.getColor(this$0.getContext(), R.color.transparent));
        }
        GUIManager.hideSystemUI(this$0.getBinding().getRoot());
        this_with.editTextSearchPlayer.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public final boolean onKey(View view2, int i, KeyEvent keyEvent) {
                return true;
            }
        });
    }

    public static final boolean m281setupOnClickListeners$lambda15$lambda12$lambda11(UIFractionsControlLayout this$0, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == 66) {
            Object systemService = this$0.getContext().getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(this$0.getBinding().getRoot().getWindowToken(), 0);
            view.setFocusable(false);
            view.setFocusableInTouchMode(true);
            return true;
        }
        return false;
    }

    public static final void m282setupOnClickListeners$lambda15$lambda13(UIFractionsControlLayout this$0, FractionsControlLayoutBinding this_with) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Object systemService = this$0.getContext().getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(this$0.getBinding().getRoot().getWindowToken(), 0);
        this_with.editTextSearchPlayer.setFocusable(false);
        this_with.editTextSearchPlayer.setFocusableInTouchMode(true);
    }

    public static final void m283setupOnClickListeners$lambda15$lambda14(UIFractionsControlLayout this$0, FractionsControlLayoutBinding this_with, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        view.startAnimation(this$0.anim);
        if (this_with.recyclerViewSortBy.getVisibility() == 0) {
            this_with.recyclerViewSortBy.setVisibility(4);
            this_with.imageButtonSortBy.setBackgroundColor(ContextCompat.getColor(this$0.getContext(), R.color.transparent));
            return;
        }
        this_with.recyclerViewSortBy.setVisibility(0);
        this_with.imageButtonSortBy.setBackgroundColor(ContextCompat.getColor(this$0.getContext(), R.color.color_444754));
    }

    public final void sortOnlyOnline() {
        this.sortedListOfPlayers.clear();
        for (FractionControlListOfPlayers fractionControlListOfPlayers : this.listOfPlayers) {
            if (fractionControlListOfPlayers.getOnline() == 1) {
                this.sortedListOfPlayers.add(fractionControlListOfPlayers);
            }
        }
        this.controlViewModel.setSortedStaffListLiveData(this.sortedListOfPlayers);
    }

    public final void sortOnlyOffline() {
        this.sortedListOfPlayers.clear();
        for (FractionControlListOfPlayers fractionControlListOfPlayers : this.listOfPlayers) {
            if (fractionControlListOfPlayers.getOnline() == 0) {
                this.sortedListOfPlayers.add(fractionControlListOfPlayers);
            }
        }
        this.controlViewModel.setSortedStaffListLiveData(this.sortedListOfPlayers);
    }

    public final void sortAscending() {
        List<FractionControlListOfPlayers> list = this.sortedListOfPlayers;
        list.clear();
        list.addAll(this.listOfPlayers);
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new Comparator() {
                @Override
                public int compare(Object o, Object t1) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((FractionControlListOfPlayers) o).getRank()), Integer.valueOf(((FractionControlListOfPlayers) t1).getRank()));
                }
            });
        }
        this.controlViewModel.setSortedStaffListLiveData(this.sortedListOfPlayers);
    }

    public final void sortDescending() {
        List<FractionControlListOfPlayers> list = this.sortedListOfPlayers;
        list.clear();
        list.addAll(this.listOfPlayers);
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new Comparator() {
                @Override
                public int compare(Object o, Object t1) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((FractionControlListOfPlayers) o).getRank()), Integer.valueOf(((FractionControlListOfPlayers) t1).getRank()));
                }
            });
        }
        this.controlViewModel.setSortedStaffListLiveData(this.sortedListOfPlayers);
    }

    private final void setLogicForOnPlayerItemClick() {
        FractionsControlStaffListAdapter fractionsControlStaffListAdapter = this.staffListAdapter;
        if (fractionsControlStaffListAdapter == null) {
            return;
        }
        fractionsControlStaffListAdapter.setOnPlayerItemClickListener(new Function2<FractionControlListOfPlayers, Integer, Unit>() {

            @Override
            public Unit invoke(FractionControlListOfPlayers fractionControlListOfPlayers, Integer num) {
                invoke(fractionControlListOfPlayers, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(FractionControlListOfPlayers clickedItem, int i) {
                long j;
                FractionsControlStaffListAdapter fractionsControlStaffListAdapter2;
                FractionsControlViewModel fractionsControlViewModel;
                Intrinsics.checkNotNullParameter(clickedItem, "clickedItem");
                long currentTimeMillis = System.currentTimeMillis();
                j = UIFractionsControlLayout.this.timeOldClickOnPlayerItem;
                if (currentTimeMillis - j > 300) {
                    UIFractionsControlLayout.this.timeOldClickOnPlayerItem = System.currentTimeMillis();
                    clickedItem.setClicked(true);
                    fractionsControlStaffListAdapter2 = UIFractionsControlLayout.this.staffListAdapter;
                    if (fractionsControlStaffListAdapter2 != null) {
                        fractionsControlStaffListAdapter2.setCheckOnlyForOneItem(i);
                        fractionsControlStaffListAdapter2.notifyItemChanged(i);
                    }
                    fractionsControlViewModel = UIFractionsControlLayout.this.controlViewModel;
                    fractionsControlViewModel.sendPlayerChosenId(clickedItem.getId());
                }
            }
        });
    }

    private final void setLogicForOnSortByItemClickListener() {
        FractionsControlSortByAdapter fractionsControlSortByAdapter = this.fractionsControlSortByAdapter;
        if (fractionsControlSortByAdapter == null) {
            return;
        }
        fractionsControlSortByAdapter.setOnSortByItemClickListener(new Function1<Integer, Unit>() {

            @Override
            public Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                FractionsControlViewModel fractionsControlViewModel;
                fractionsControlViewModel = UIFractionsControlLayout.this.controlViewModel;
                fractionsControlViewModel.setMenuSortedPressed(i);
            }
        });
    }

    private final void setLogicForOnMinusRankClickListener() {
        FractionsControlManagementAdapter fractionsControlManagementAdapter = this.controlManagementAdapter;
        if (fractionsControlManagementAdapter == null) {
            return;
        }
        fractionsControlManagementAdapter.setOnMinusRankClickListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            public final void invoke2() {
                FractionsControlViewModel fractionsControlViewModel;
                fractionsControlViewModel = UIFractionsControlLayout.this.controlViewModel;
                fractionsControlViewModel.sendChangeRank(0);
            }
        });
    }

    private final void setLogicForOnPlusRankClickListener() {
        FractionsControlManagementAdapter fractionsControlManagementAdapter = this.controlManagementAdapter;
        if (fractionsControlManagementAdapter == null) {
            return;
        }
        fractionsControlManagementAdapter.setOnPlusRankClickListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            public final void invoke2() {
                FractionsControlViewModel fractionsControlViewModel;
                fractionsControlViewModel = UIFractionsControlLayout.this.controlViewModel;
                fractionsControlViewModel.sendChangeRank(1);
            }
        });
    }

    private final void setLogicForOnPlusReprimandsListener() {
        FractionsControlManagementAdapter fractionsControlManagementAdapter = this.controlManagementAdapter;
        if (fractionsControlManagementAdapter == null) {
            return;
        }
        fractionsControlManagementAdapter.setOnPlusReprimandsClickListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            public final void invoke2() {
                FractionsControlViewModel fractionsControlViewModel;
                fractionsControlViewModel = UIFractionsControlLayout.this.controlViewModel;
                fractionsControlViewModel.sendChangeReprimands(1);
            }
        });
    }

    private final void setLogicForOnMinusReprimandsListener() {
        FractionsControlManagementAdapter fractionsControlManagementAdapter = this.controlManagementAdapter;
        if (fractionsControlManagementAdapter == null) {
            return;
        }
        fractionsControlManagementAdapter.setOnMinusReprimandsClickListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            public final void invoke2() {
                FractionsControlViewModel fractionsControlViewModel;
                fractionsControlViewModel = UIFractionsControlLayout.this.controlViewModel;
                fractionsControlViewModel.sendChangeReprimands(0);
            }
        });
    }

    private final void setOnDismissFromFractionClickListener() {
        FractionsControlManagementAdapter fractionsControlManagementAdapter = this.controlManagementAdapter;
        if (fractionsControlManagementAdapter == null) {
            return;
        }
        fractionsControlManagementAdapter.setOnDismissFromFractionClickListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            public final void invoke2() {
                FractionsControlViewModel fractionsControlViewModel;
                fractionsControlViewModel = UIFractionsControlLayout.this.controlViewModel;
                fractionsControlViewModel.sendButtonPressed(18);
            }
        });
    }

    private final void setInfoAboutPlayer(FractionControlPlayerInfo fractionControlPlayerInfo) {
        FractionsControlLayoutBinding binding = getBinding();
        Useful useful = new Useful();
        NvEventQueueActivity nvEventQueueActivity = this.activity;
        int skinId = fractionControlPlayerInfo.getSkinId();
        FrameLayout frameLayoutRenderSkin = binding.frameLayoutRenderSkin;
        Intrinsics.checkNotNullExpressionValue(frameLayoutRenderSkin, "frameLayoutRenderSkin");
        useful.renderSkin(nvEventQueueActivity, 2, Constants.ID_SKIN, skinId, 1, frameLayoutRenderSkin);
        binding.textViewPlayersNickname.setText(fractionControlPlayerInfo.getNickname());
        TextView textView = binding.textViewPlayersLevel;
        String string = getContext().getString(R.string.fractions_control_players_level);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     …ns_control_players_level)");
        String string2 = getContext().getString(R.string.fractions_control_players_level, Integer.valueOf(fractionControlPlayerInfo.getLevel()));
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(\n     …level, clickedItem.level)");
        textView.setText(setTextRegular(string, string2));
        TextView textView2 = binding.textViewPosition;
        String string3 = getContext().getString(R.string.fractions_control_players_position);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…control_players_position)");
        String string4 = getContext().getString(R.string.fractions_control_players_position, fractionControlPlayerInfo.getRankName());
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri…    clickedItem.rankName)");
        textView2.setText(setTextRegular(string3, string4));
        TextView textView3 = binding.textViewPlayersRank;
        String string5 = getContext().getString(R.string.fractions_control_players_rank);
        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri…ons_control_players_rank)");
        String string6 = getContext().getString(R.string.fractions_control_players_rank, Integer.valueOf(fractionControlPlayerInfo.getRank()));
        Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri…s_rank, clickedItem.rank)");
        textView3.setText(setTextRegular(string5, string6));
        TextView textView4 = binding.textViewPlayersReprimands;
        String string7 = getContext().getString(R.string.fractions_control_players_reprimands);
        Intrinsics.checkNotNullExpressionValue(string7, "context.getString(\n     …ntrol_players_reprimands)");
        String string8 = getContext().getString(R.string.fractions_control_players_reprimands, Integer.valueOf(fractionControlPlayerInfo.getReprimand()));
        Intrinsics.checkNotNullExpressionValue(string8, "context.getString(\n     …primand\n                )");
        textView4.setText(setTextRegular(string7, string8));
        TextView textView5 = binding.textViewPlayersPhoneNumber;
        String string9 = getContext().getString(R.string.fractions_control_players_phone_number);
        Intrinsics.checkNotNullExpressionValue(string9, "context.getString(\n     …rol_players_phone_number)");
        String string10 = getContext().getString(R.string.fractions_control_players_phone_number, fractionControlPlayerInfo.getPhoneNumber());
        Intrinsics.checkNotNullExpressionValue(string10, "context.getString(\n     …eNumber\n                )");
        textView5.setText(setTextRegular(string9, string10));
        setupControlManagementAdapter(fractionControlPlayerInfo);
    }

    private final CharSequence setTextRegular(String str, String str2) {
        int length = str.length() - 4;
        int length2 = str2.length();
        if (length > length2) {
            return str2;
        }
        Typeface font = ResourcesCompat.getFont(getContext(), R.font.montserrat_regular);
        if (font != null) {
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new CustomTypefaceSpanTextStyleBold("", font), length, length2, 18);
            return spannableString;
        }
        return str2;
    }

    private final void setupFractionsControlSortByAdapter() {
        this.fractionsControlSortByAdapter = new FractionsControlSortByAdapter(getListForSortByAdapter(), 3);
        RecyclerView recyclerView = getBinding().recyclerViewSortBy;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter(this.fractionsControlSortByAdapter);
        setLogicForOnSortByItemClickListener();
    }

    private final List<FractionsSortByItem> getListForSortByAdapter() {
        Context context = getContext();
        String string = context.getString(R.string.fractions_control_sort_by_only_online);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.fract…trol_sort_by_only_online)");
        String string2 = context.getString(R.string.fractions_control_sort_by_only_offline);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.fract…rol_sort_by_only_offline)");
        String string3 = context.getString(R.string.fractions_control_sort_by_rank_ascending);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.fract…l_sort_by_rank_ascending)");
        String string4 = context.getString(R.string.fractions_control_sort_by_rank_descending);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.fract…_sort_by_rank_descending)");
        return CollectionsKt.mutableListOf(new FractionsSortByItem(string, false), new FractionsSortByItem(string2, false), new FractionsSortByItem(string3, false), new FractionsSortByItem(string4, true));
    }

    private final void setupControlManagementAdapter(FractionControlPlayerInfo fractionControlPlayerInfo) {
        this.controlManagementAdapter = new FractionsControlManagementAdapter(fractionControlPlayerInfo);
        RecyclerView recyclerView = getBinding().recyclerViewControlFraction;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter(this.controlManagementAdapter);
        setLogicForOnMinusRankClickListener();
        setLogicForOnPlusRankClickListener();
        setLogicForOnPlusReprimandsListener();
        setLogicForOnMinusReprimandsListener();
        setOnDismissFromFractionClickListener();
    }

    private final void setupStaffListAdapter(List<FractionControlListOfPlayers> list) {
        this.staffListAdapter = new FractionsControlStaffListAdapter(list, this.listOfImagesForAdapter);
        getBinding().recyclerViewStaffList.setAdapter(this.staffListAdapter);
        setLogicForOnPlayerItemClick();
    }

    public final void setupListOfImagesForAdapter(int i) {
        this.listOfImagesForAdapter.addAll(getListOfImagesForAdapter(i));
    }

    @Override
    public void onLayoutShown() {
        GUIManager.hideSystemUI(getBinding().getRoot());
        setupLiveDataObservers();
    }

    @Override
    public void onLayoutClose() {
        removeVMObservers();
        this.controlViewModel.setStaffListLiveData(new ArrayList());
        this.controlViewModel.setSortedStaffListLiveData(new ArrayList());
        this.controlViewModel.setInfoAboutPlayer(null);
        this.controlViewModel.sendPlayerChosenId(-1);
        this.sortedListOfPlayers = new ArrayList();
        this.listOfPlayers = new ArrayList();
    }

    private final List<Integer> getListOfImagesFunction(String str) {
        Resources resources;
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (i < 11) {
            int i2 = i + 1;
            String stringPlus = Intrinsics.stringPlus(str, Integer.valueOf(i));
            Context context = getContext();
            if (context != null && (resources = context.getResources()) != null) {
                arrayList.add(Integer.valueOf(resources.getIdentifier(stringPlus, "drawable", context.getPackageName())));
            }
            i = i2;
        }
        return arrayList;
    }

    private final List<Integer> getListOfImagesForAdapter(int i) {
        if (i != 11) {
            switch (i) {
                case 1:
                    return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_GOVERNMENT);
                case 2:
                    return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_DEFENSE_DEPARTMENT_TURNED);
                case 3:
                    return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_DEFENSE_HOSPITAL);
                case 4:
                    return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_DEFENSE_MASS_MEDIA);
                case 5:
                    return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_DEFENSE_MVD_TURNED);
                case 6:
                    return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_DEFENSE_MVD_TURNED);
                case 7:
                    return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_DEFENSE_MVD_TURNED);
                default:
                    return new ArrayList();
            }
        }
        return getListOfImagesFunction(Const.FRACTION_DRAWABLE_PATH_DEFENSE_MVD_TURNED);
    }
}
