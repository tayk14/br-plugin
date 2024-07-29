package com.rockstargames.gtacr.gui.inventory;

import android.app.Dialog;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import com.rockstargames.gtacr.adapters.InventoryChatAdapter;
import com.rockstargames.gtacr.data.MessageData;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0002J \u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\u0006\u0010\u001a\u001a\u00020\u0011J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/rockstargames/gtacr/gui/inventory/UIChat;", "", "dialog", "Landroid/app/Dialog;", "messagesList", "", "Lcom/rockstargames/gtacr/data/MessageData;", "mainRoot", "Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;", "playersNickname", "", "(Landroid/app/Dialog;Ljava/util/List;Lcom/rockstargames/gtacr/gui/inventory/GUIUsersInventory;Ljava/lang/String;)V", "messageAdapter", "Lcom/rockstargames/gtacr/adapters/InventoryChatAdapter;", "viewMessage", "Landroidx/recyclerview/widget/RecyclerView;", "closeChat", "", "createDialog", "getMessageAboutExchangeItems", "otherNick", "action", "", "item", "setClickableLogic", "setItemsInChat", "setStartLogic", "updateMessage", "ifMyMessage", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIChat {
    private final Dialog dialog;
    private final GUIUsersInventory mainRoot;
    private InventoryChatAdapter messageAdapter;
    private final List<MessageData> messagesList;
    private final String playersNickname;
    private RecyclerView viewMessage;

    public UIChat(Dialog dialog, List<MessageData> messagesList, GUIUsersInventory mainRoot, String playersNickname) {
        Intrinsics.checkNotNullParameter(messagesList, "messagesList");
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(playersNickname, "playersNickname");
        this.dialog = dialog;
        this.messagesList = messagesList;
        this.mainRoot = mainRoot;
        this.playersNickname = playersNickname;
    }

    public final void setStartLogic() {
        createDialog();
        setClickableLogic();
        setItemsInChat();
    }

    private final void createDialog() {
        Dialog dialog = this.dialog;
        if (dialog == null) {
            return;
        }
        dialog.setContentView(R.layout.inventory_layout_chat);
        dialog.setCancelable(false);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        dialog.show();
    }

    private final void setClickableLogic() {
        Dialog dialog = this.dialog;
        Button button = dialog == null ? null : (Button) dialog.findViewById(R.id.inv_chat_close_chat);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    UIChat.m339setClickableLogic$lambda1(UIChat.this, view);
                }
            });
        }
        Dialog dialog2 = this.dialog;
        final EditText editText = dialog2 == null ? null : (EditText) dialog2.findViewById(R.id.edit_text_message_in_chat);
        Dialog dialog3 = this.dialog;
        View findViewById = dialog3 != null ? dialog3.findViewById(R.id.chat_button_send_message) : null;
        if (findViewById == null) {
            return;
        }
        findViewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                UIChat.m340setClickableLogic$lambda2(editText, UIChat.this, view);
            }
        });
    }

    public static final void m339setClickableLogic$lambda1(UIChat this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.closeChat();
    }

    public static final void m340setClickableLogic$lambda2(EditText editText, UIChat this$0, View view) {
        Editable text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String valueOf = String.valueOf(editText == null ? null : editText.getText());
        if (valueOf.length() > 0) {
            this$0.mainRoot.sendMessageToServer(31, valueOf);
            this$0.mainRoot.setNewMessage(true, 1, valueOf, 0, "", 0);
            if (editText == null || (text = editText.getText()) == null) {
                return;
            }
            text.clear();
        }
    }

    public final void closeChat() {
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.mainRoot.closeAndroidsInterface();
    }

    private final void setItemsInChat() {
        Dialog dialog = this.dialog;
        InventoryChatAdapter inventoryChatAdapter = null;
        this.viewMessage = dialog == null ? null : (RecyclerView) dialog.findViewById(R.id.inv_chat_body_with_messages);
        this.messageAdapter = new InventoryChatAdapter(this.messagesList, this.playersNickname, this.mainRoot);
        RecyclerView recyclerView = this.viewMessage;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mainRoot.getMainContext(), 1, false));
        InventoryChatAdapter inventoryChatAdapter2 = this.messageAdapter;
        if (inventoryChatAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageAdapter");
        } else {
            inventoryChatAdapter = inventoryChatAdapter2;
        }
        recyclerView.setAdapter(inventoryChatAdapter);
    }

    public final void updateMessage(boolean z) {
        InventoryChatAdapter inventoryChatAdapter = this.messageAdapter;
        if (inventoryChatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("messageAdapter");
            inventoryChatAdapter = null;
        }
        inventoryChatAdapter.notifyDataSetChanged();
        if (z) {
            this.mainRoot.setCounter(0);
            GUIUsersInventory gUIUsersInventory = this.mainRoot;
            gUIUsersInventory.updateCountWithNewMessages(gUIUsersInventory.getCounter());
        }
    }

    public final void getMessageAboutExchangeItems(String otherNick, boolean z, String str) {
        Intrinsics.checkNotNullParameter(otherNick, "otherNick");
        Objects.requireNonNull(this.viewMessage, "null cannot be cast to non-null type android.view.View");
    }
}
