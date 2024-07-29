package com.rockstargames.gtacr.gui.inventory;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import blackrussia.online.databinding.InventoryDialogBinding;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\b\u0010!\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\b\u0010#\u001a\u00020\u001aH\u0002J\b\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u001aH\u0002J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u0017H\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020\u001aH\u0002J\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/rockstargames/gtacr/gui/inventory/GuideForInventory;", "", "binding", "Lblackrussia/online/databinding/InventoryDialogBinding;", "layoutUsersInventory", "Lcom/rockstargames/gtacr/gui/inventory/UILayoutUsersInventory;", "layoutExchange", "Lcom/rockstargames/gtacr/gui/inventory/UILayoutExchange;", "(Lblackrussia/online/databinding/InventoryDialogBinding;Lcom/rockstargames/gtacr/gui/inventory/UILayoutUsersInventory;Lcom/rockstargames/gtacr/gui/inventory/UILayoutExchange;)V", "parameters", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "text1", "", "text10", "text2", "text3", "text4", "text5", "text6", "text7", "text8", "text9", "whichStateClosed", "", "getClosedState", "getHelp", "", "helpsNumber", "logicForHelp1", "logicForHelp10", "logicForHelp2", "logicForHelp3", "logicForHelp4", "logicForHelp5", "logicForHelp6", "logicForHelp7", "logicForHelp8", "logicForHelp9", "setArrHelp", RemoteConfigConstants.ResponseFieldKey.STATE, "setClosedState", "currentState", "setLogicForClick", "visibleHelp", "isVisible", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuideForInventory {
    private final InventoryDialogBinding binding;
    private final UILayoutExchange layoutExchange;
    private final UILayoutUsersInventory layoutUsersInventory;
    private final ConstraintLayout.LayoutParams parameters;
    private final String text1;
    private final String text10;
    private final String text2;
    private final String text3;
    private final String text4;
    private final String text5;
    private final String text6;
    private final String text7;
    private final String text8;
    private final String text9;
    private int whichStateClosed;

    public GuideForInventory(InventoryDialogBinding binding, UILayoutUsersInventory layoutUsersInventory, UILayoutExchange layoutExchange) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(layoutUsersInventory, "layoutUsersInventory");
        Intrinsics.checkNotNullParameter(layoutExchange, "layoutExchange");
        this.binding = binding;
        this.layoutUsersInventory = layoutUsersInventory;
        this.layoutExchange = layoutExchange;
        ViewGroup.LayoutParams layoutParams = binding.window.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        this.parameters = (ConstraintLayout.LayoutParams) layoutParams;
        this.text1 = "Это Ваш инвентарь.\nВыберите ячейку с документами, чтобы\nвзаимодействовать с ними.\nПомните, взаимодействие происходит\nтолько с активным предметом.";
        this.text2 = "Выберите кнопку 'Обмен', чтобы обменяться товаром.";
        this.text3 = "Добро пожаловать в трейд.\nМесто, где Вы сможете обменяться своими предметами с другими игроками.";
        this.text4 = "Это - ваш инвентарь. Всё, что находится в этом поле,\nодновременно находится и в Вашем инвентаре.\n\nЕсли вы желаете что-то отдать игроку -\nиспользуйте предметы именно из инвентаря.";
        this.text5 = "Это поле трейда (обмена) - место, в которое игроки кладут\nпредметы для обмена.\n\nИменно здесь отображаются предметы, которые Вы отдадите\nи получите в результате обмена.";
        this.text6 = "Выберите документы и положите их в поле\nдля обмена.";
        this.text7 = "Нажмите смену просмотра поля обмена.\nИзменив поле, Вы сможете узнать,\nчто получите Вы в результате обмена.";
        this.text8 = "Теперь Вы просматриваете то, что отдает Вам Тетя Лена.\nТетя Лена дает Вам канистру, возможно она пригодится.";
        this.text9 = "Нажмите кнопку 'Обменяться',\nчтобы предложить обмен.";
        this.text10 = "При обмене с реальным игроком убедитесь, что Вас устраивают переданные предметы.\nПерепроверьте что отдает игрок и что отдаете Вы.\nПосле - подтвердите обмен, нажав кнопку 'Подтвердить'.";
    }

    public final void getHelp(int i) {
        visibleHelp(true);
        switch (i) {
            case 1:
                logicForHelp1();
                setClosedState(1);
                break;
            case 2:
                logicForHelp2();
                setClosedState(2);
                break;
            case 3:
                logicForHelp3();
                setClosedState(3);
                break;
            case 4:
                logicForHelp4();
                setClosedState(4);
                break;
            case 5:
                logicForHelp5();
                setClosedState(5);
                break;
            case 6:
                logicForHelp6();
                setClosedState(6);
                break;
            case 7:
                logicForHelp7();
                setClosedState(7);
                break;
            case 8:
                logicForHelp8();
                setClosedState(8);
                break;
            case 9:
                logicForHelp9();
                setClosedState(9);
                break;
            case 10:
                logicForHelp10();
                setClosedState(10);
                break;
        }
        setLogicForClick();
    }

    private final void logicForHelp1() {
        ConstraintLayout.LayoutParams layoutParams = this.parameters;
        if (this.layoutUsersInventory.getItemsWidth() == 0) {
            layoutParams.width = this.layoutUsersInventory.getInventoryWidth();
            layoutParams.height = this.layoutUsersInventory.getInventoryHeight();
            layoutParams.setMarginStart(this.layoutUsersInventory.getInventoryLocation()[0]);
            layoutParams.topMargin = this.layoutUsersInventory.getInventoryLocation()[1];
            this.binding.window.setVisibility(0);
        } else {
            layoutParams.width = this.layoutUsersInventory.getItemsWidth();
            layoutParams.height = this.layoutUsersInventory.getItemsHeight();
            layoutParams.setMarginStart(this.layoutUsersInventory.getItemsLocation()[0]);
            layoutParams.topMargin = this.layoutUsersInventory.getItemsLocation()[1];
        }
        InventoryDialogBinding inventoryDialogBinding = this.binding;
        inventoryDialogBinding.window.setLayoutParams(this.parameters);
        inventoryDialogBinding.helpText1.setVisibility(0);
        inventoryDialogBinding.helpText1.setText(this.text1);
    }

    private final void logicForHelp2() {
        ConstraintLayout.LayoutParams layoutParams = this.parameters;
        layoutParams.width = this.layoutUsersInventory.getExchangeWidth();
        layoutParams.height = this.layoutUsersInventory.getExchangeHeight();
        layoutParams.setMarginStart(this.layoutUsersInventory.getExchangeLocation()[0]);
        layoutParams.topMargin = this.layoutUsersInventory.getExchangeLocation()[1];
        InventoryDialogBinding inventoryDialogBinding = this.binding;
        inventoryDialogBinding.window.setLayoutParams(this.parameters);
        inventoryDialogBinding.helpText2.setVisibility(0);
        inventoryDialogBinding.helpText2.setText(this.text2);
    }

    private final void logicForHelp3() {
        ConstraintLayout.LayoutParams layoutParams = this.parameters;
        layoutParams.width = 0;
        layoutParams.height = 0;
        layoutParams.setMarginStart(this.binding.invMainButtonsBlock.getWidth());
        layoutParams.topMargin = this.binding.getRoot().getHeight() / 3;
        InventoryDialogBinding inventoryDialogBinding = this.binding;
        inventoryDialogBinding.window.setLayoutParams(this.parameters);
        inventoryDialogBinding.helpText2.setVisibility(0);
        inventoryDialogBinding.helpText2.setText(this.text3);
    }

    private final void logicForHelp4() {
        ConstraintLayout.LayoutParams layoutParams = this.parameters;
        layoutParams.width = this.layoutExchange.getInventoryWidth();
        layoutParams.height = this.layoutExchange.getInventoryHeight();
        layoutParams.setMarginStart(this.layoutExchange.getInventoryLocation()[0]);
        layoutParams.topMargin = this.layoutExchange.getInventoryLocation()[1];
        InventoryDialogBinding inventoryDialogBinding = this.binding;
        inventoryDialogBinding.window.setLayoutParams(this.parameters);
        inventoryDialogBinding.window.setVisibility(0);
        inventoryDialogBinding.helpText1.setVisibility(0);
        inventoryDialogBinding.helpText1.setText(this.text4);
    }

    private final void logicForHelp5() {
        ConstraintLayout.LayoutParams layoutParams = this.parameters;
        layoutParams.width = this.layoutExchange.getOtherPlayersInvWidth();
        layoutParams.height = this.layoutExchange.getOtherPlayersInvHeight();
        layoutParams.setMarginStart(this.layoutExchange.getOtherPlayersInvLocation()[0]);
        layoutParams.topMargin = this.layoutExchange.getOtherPlayersInvLocation()[1];
        InventoryDialogBinding inventoryDialogBinding = this.binding;
        inventoryDialogBinding.window.setLayoutParams(this.parameters);
        inventoryDialogBinding.window.setVisibility(0);
        inventoryDialogBinding.helpText2.setVisibility(0);
        inventoryDialogBinding.helpText2.setText(this.text5);
    }

    private final void logicForHelp6() {
        ConstraintLayout.LayoutParams layoutParams = this.parameters;
        layoutParams.width = this.layoutExchange.getAllInvWidth();
        layoutParams.height = this.layoutExchange.getAllInvHeight();
        layoutParams.setMarginStart(this.layoutExchange.getAllInvLocation()[0]);
        layoutParams.topMargin = this.layoutExchange.getAllInvLocation()[1];
        InventoryDialogBinding inventoryDialogBinding = this.binding;
        inventoryDialogBinding.window.setLayoutParams(this.parameters);
        inventoryDialogBinding.helpText3.setVisibility(0);
        inventoryDialogBinding.helpText3.setText(this.text6);
    }

    private final void logicForHelp7() {
        ConstraintLayout.LayoutParams layoutParams = this.parameters;
        layoutParams.width = this.layoutExchange.getButtonChangeInvWidth();
        layoutParams.height = this.layoutExchange.getButtonChangeInvHeight();
        layoutParams.setMarginStart(this.layoutExchange.getButtonChangeInvLocation()[0]);
        layoutParams.topMargin = this.layoutExchange.getButtonChangeInvLocation()[1];
        InventoryDialogBinding inventoryDialogBinding = this.binding;
        inventoryDialogBinding.window.setLayoutParams(this.parameters);
        inventoryDialogBinding.helpText3.setVisibility(0);
        inventoryDialogBinding.helpText3.setText(this.text7);
    }

    private final void logicForHelp8() {
        ConstraintLayout.LayoutParams layoutParams = this.parameters;
        if (this.layoutExchange.getFirstOthersItemWidth() == 0) {
            layoutParams.width = this.layoutExchange.getOtherPlayersInvWidth();
            layoutParams.height = this.layoutExchange.getOtherPlayersInvHeight();
            layoutParams.setMarginStart(this.layoutExchange.getOtherPlayersInvLocation()[0]);
            layoutParams.topMargin = this.layoutExchange.getOtherPlayersInvLocation()[1];
        } else {
            layoutParams.width = this.layoutExchange.getFirstOthersItemWidth();
            layoutParams.height = this.layoutExchange.getFirstOthersItemHeight();
            layoutParams.setMarginStart(this.layoutExchange.getFirstOthersItemLocation()[0]);
            layoutParams.topMargin = this.layoutExchange.getFirstOthersItemLocation()[1];
        }
        InventoryDialogBinding inventoryDialogBinding = this.binding;
        inventoryDialogBinding.window.setLayoutParams(this.parameters);
        inventoryDialogBinding.helpText2.setVisibility(0);
        inventoryDialogBinding.helpText2.setText(this.text8);
    }

    private final void logicForHelp9() {
        ConstraintLayout.LayoutParams layoutParams = this.parameters;
        layoutParams.width = this.layoutExchange.getButtonApplyWidth();
        layoutParams.height = this.layoutExchange.getButtonApplyHeight();
        layoutParams.setMarginStart(this.layoutExchange.getButtonApplyLocation()[0]);
        layoutParams.topMargin = this.layoutExchange.getButtonApplyLocation()[1];
        InventoryDialogBinding inventoryDialogBinding = this.binding;
        inventoryDialogBinding.window.setLayoutParams(this.parameters);
        inventoryDialogBinding.helpText1.setVisibility(0);
        inventoryDialogBinding.helpText1.setText(this.text9);
    }

    private final void logicForHelp10() {
        ConstraintLayout.LayoutParams layoutParams = this.parameters;
        layoutParams.width = this.layoutExchange.getButtonApplyWidth();
        layoutParams.height = this.layoutExchange.getButtonApplyHeight();
        layoutParams.setMarginStart(this.layoutExchange.getButtonApplyLocation()[0]);
        layoutParams.topMargin = this.layoutExchange.getButtonApplyLocation()[1];
        InventoryDialogBinding inventoryDialogBinding = this.binding;
        inventoryDialogBinding.window.setLayoutParams(this.parameters);
        inventoryDialogBinding.helpText1.setVisibility(0);
        inventoryDialogBinding.helpText1.setText(this.text10);
    }

    private final void setLogicForClick() {
        InventoryDialogBinding inventoryDialogBinding = this.binding;
        inventoryDialogBinding.topBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GuideForInventory.m326setLogicForClick$lambda25$lambda20(GuideForInventory.this, view);
            }
        });
        inventoryDialogBinding.leftBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GuideForInventory.m327setLogicForClick$lambda25$lambda21(GuideForInventory.this, view);
            }
        });
        inventoryDialogBinding.rightBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GuideForInventory.m328setLogicForClick$lambda25$lambda22(GuideForInventory.this, view);
            }
        });
        inventoryDialogBinding.bottomBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GuideForInventory.m329setLogicForClick$lambda25$lambda23(GuideForInventory.this, view);
            }
        });
        inventoryDialogBinding.window.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                GuideForInventory.m330setLogicForClick$lambda25$lambda24(GuideForInventory.this, view);
            }
        });
    }

    public static final void m326setLogicForClick$lambda25$lambda20(GuideForInventory this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.visibleHelp(false);
    }

    public static final void m327setLogicForClick$lambda25$lambda21(GuideForInventory this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.visibleHelp(false);
    }

    public static final void m328setLogicForClick$lambda25$lambda22(GuideForInventory this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.visibleHelp(false);
    }

    public static final void m329setLogicForClick$lambda25$lambda23(GuideForInventory this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.visibleHelp(false);
    }

    public static final void m330setLogicForClick$lambda25$lambda24(GuideForInventory this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.visibleHelp(false);
    }

    public final void visibleHelp(boolean z) {
        if (z) {
            InventoryDialogBinding inventoryDialogBinding = this.binding;
            inventoryDialogBinding.topBlack.setVisibility(0);
            inventoryDialogBinding.leftBlack.setVisibility(0);
            inventoryDialogBinding.rightBlack.setVisibility(0);
            inventoryDialogBinding.bottomBlack.setVisibility(0);
            return;
        }
        InventoryDialogBinding inventoryDialogBinding2 = this.binding;
        inventoryDialogBinding2.window.setVisibility(4);
        inventoryDialogBinding2.topBlack.setVisibility(4);
        inventoryDialogBinding2.leftBlack.setVisibility(4);
        inventoryDialogBinding2.rightBlack.setVisibility(4);
        inventoryDialogBinding2.bottomBlack.setVisibility(4);
        inventoryDialogBinding2.helpText1.setVisibility(4);
        inventoryDialogBinding2.helpText2.setVisibility(4);
        setArrHelp(this.whichStateClosed);
    }

    private final void setArrHelp(int i) {
        if (i == 3) {
            getHelp(4);
        } else if (i == 4) {
            getHelp(5);
        } else if (i == 5) {
            getHelp(6);
        } else if (i != 8) {
        } else {
            getHelp(9);
        }
    }

    private final void setClosedState(int i) {
        this.whichStateClosed = i;
    }

    public final int getClosedState() {
        return this.whichStateClosed;
    }
}
