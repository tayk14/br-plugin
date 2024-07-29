package com.rockstargames.gtacr.adapters;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.InventoryChatItemBinding;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.data.MessageData;
import com.rockstargames.gtacr.gui.inventory.GUIUsersInventory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/rockstargames/gtacr/adapters/InventoryChatAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/adapters/InventoryChatAdapter$ViewHolder;", "messagesList", "", "Lcom/rockstargames/gtacr/data/MessageData;", "playersNick", "", "mainRoot", "Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;", "(Ljava/util/List;Ljava/lang/String;Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;)V", "binding", "Lblackrussia/online/databinding/InventoryChatItemBinding;", "selectedItem", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InventoryChatAdapter extends RecyclerView.Adapter<InventoryChatAdapter.ViewHolder> {
    private InventoryChatItemBinding binding;
    private final GUIUsersInventory mainRoot;
    private final List<MessageData> messagesList;
    private final String playersNick;
    private int selectedItem;

    public InventoryChatAdapter(List<MessageData> messagesList, String playersNick, GUIUsersInventory mainRoot) {
        Intrinsics.checkNotNullParameter(messagesList, "messagesList");
        Intrinsics.checkNotNullParameter(playersNick, "playersNick");
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        this.messagesList = messagesList;
        this.playersNick = playersNick;
        this.mainRoot = mainRoot;
        this.selectedItem = -1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        InventoryChatItemBinding inflate = InventoryChatItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        return new ViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.messagesList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.messagesList.size();
    }

    //@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/rockstargames/gtacr/adapters/InventoryChatAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/InventoryChatItemBinding;", "(Lcom/rockstargames/gtacr/adapters/InventoryChatAdapter;Lblackrussia/online/databinding/InventoryChatItemBinding;)V", "bind", "", "message", "Lcom/rockstargames/gtacr/data/MessageData;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final InventoryChatItemBinding binding;
        final InventoryChatAdapter this$0;

        public ViewHolder(InventoryChatAdapter this$0, InventoryChatItemBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(MessageData message) {
            Intrinsics.checkNotNullParameter(message, "message");
            int players = message.getPlayers();
            if (players == 0) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(20);
                layoutParams.addRule(3, this.binding.chatPlayersNick.getId());
                this.binding.chatTextMessage.setLayoutParams(layoutParams);
                TextView textView = this.binding.chatTextMessage;
                NvEventQueueActivity mainContext = this.this$0.mainRoot.getMainContext();
                Resources resources = mainContext == null ? null : mainContext.getResources();
                Intrinsics.checkNotNull(resources);
                textView.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.inv_bg_message_if_other, null));
                TextView textView2 = this.binding.chatTextMessage;
                NvEventQueueActivity mainContext2 = this.this$0.mainRoot.getMainContext();
                Intrinsics.checkNotNull(mainContext2);
                textView2.setTextColor(ContextCompat.getColor(mainContext2, R.color.black));
                this.binding.chatPlayersNick.setText(this.this$0.playersNick);
                this.binding.chatTextMessage.setVisibility(0);
                this.binding.chatTextMessage.setText(message.getMessage());
                this.binding.blockWithActions.setVisibility(8);
            } else if (players == 1) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(21);
                layoutParams2.addRule(3, this.binding.chatPlayersNick.getId());
                this.binding.chatTextMessage.setLayoutParams(layoutParams2);
                TextView textView3 = this.binding.chatTextMessage;
                NvEventQueueActivity mainContext3 = this.this$0.mainRoot.getMainContext();
                Resources resources2 = mainContext3 == null ? null : mainContext3.getResources();
                Intrinsics.checkNotNull(resources2);
                textView3.setBackground(ResourcesCompat.getDrawable(resources2, R.drawable.inv_bg_button_apply, null));
                TextView textView4 = this.binding.chatTextMessage;
                NvEventQueueActivity mainContext4 = this.this$0.mainRoot.getMainContext();
                Intrinsics.checkNotNull(mainContext4);
                textView4.setTextColor(ContextCompat.getColor(mainContext4, R.color.white));
                TextView textView5 = this.binding.chatPlayersNick;
                NvEventQueueActivity mainContext5 = this.this$0.mainRoot.getMainContext();
                textView5.setText(mainContext5 != null ? mainContext5.getText(R.string.inv_title_message_if_you) : null);
                this.binding.chatTextMessage.setVisibility(0);
                this.binding.chatTextMessage.setText(message.getMessage());
                this.binding.blockWithActions.setVisibility(8);
            } else if (players != 2) {
            } else {
                this.binding.blockWithActions.setVisibility(0);
                this.binding.chatPlayersNick.setText("");
                this.binding.chatTextMessage.setVisibility(8);
                int actionStatus = message.getActionStatus();
                if (actionStatus == 1) {
                    String itemsName = message.getItemsName();
                    SpannableString spannableString = new SpannableString(this.this$0.playersNick + " добавил " + itemsName + " в товары для обмена");
                    spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.inv_items_name_color_in_chat)), this.this$0.playersNick.length() + 1 + 7 + 1, this.this$0.playersNick.length() + 1 + 7 + 1 + itemsName.length(), 33);
                    this.binding.finalActionText.setText(spannableString);
                } else if (actionStatus == 2) {
                    String itemsName2 = message.getItemsName();
                    SpannableString spannableString2 = new SpannableString(this.this$0.playersNick + " убрал " + itemsName2 + " из товаров для обмена");
                    spannableString2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.inv_items_name_color_in_chat)), this.this$0.playersNick.length() + 1 + 5 + 1, this.this$0.playersNick.length() + 1 + 5 + 1 + itemsName2.length(), 33);
                    this.binding.finalActionText.setText(spannableString2);
                } else if (actionStatus == 3) {
                    this.binding.finalActionText.setText(new SpannableString(this.this$0.playersNick + ' ' + ("установил доплату в размере " + message.getValueOfMoney() + " рублей")));
                } else if (actionStatus != 4) {
                } else {
                    this.binding.finalActionText.setText(new SpannableString(this.this$0.playersNick + ' ' + ("изменил доплату. Новое значение: " + message.getValueOfMoney() + " рублей")));
                }
            }
        }
    }
}
