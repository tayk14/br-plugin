package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class InventoryLayoutChatBinding implements ViewBinding {
    public final View chatButtonSendMessage;
    public final CoordinatorLayout coordinatorForSnackbar;
    public final EditText editTextMessageInChat;
    public final RecyclerView invChatBodyWithMessages;
    public final Button invChatCloseChat;
    public final View invChatVerticalLine;
    private final ConstraintLayout rootView;

    private InventoryLayoutChatBinding(ConstraintLayout rootView, View chatButtonSendMessage, CoordinatorLayout coordinatorForSnackbar, EditText editTextMessageInChat, RecyclerView invChatBodyWithMessages, Button invChatCloseChat, View invChatVerticalLine) {
        this.rootView = rootView;
        this.chatButtonSendMessage = chatButtonSendMessage;
        this.coordinatorForSnackbar = coordinatorForSnackbar;
        this.editTextMessageInChat = editTextMessageInChat;
        this.invChatBodyWithMessages = invChatBodyWithMessages;
        this.invChatCloseChat = invChatCloseChat;
        this.invChatVerticalLine = invChatVerticalLine;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static InventoryLayoutChatBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryLayoutChatBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_layout_chat, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryLayoutChatBinding bind(View rootView) {
        int i = R.id.chat_button_send_message;
        View findViewById = rootView.findViewById(R.id.chat_button_send_message);
        if (findViewById != null) {
            i = R.id.coordinator_for_snackbar;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) rootView.findViewById(R.id.coordinator_for_snackbar);
            if (coordinatorLayout != null) {
                i = R.id.edit_text_message_in_chat;
                EditText editText = (EditText) rootView.findViewById(R.id.edit_text_message_in_chat);
                if (editText != null) {
                    i = R.id.inv_chat_body_with_messages;
                    RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.inv_chat_body_with_messages);
                    if (recyclerView != null) {
                        i = R.id.inv_chat_close_chat;
                        Button button = (Button) rootView.findViewById(R.id.inv_chat_close_chat);
                        if (button != null) {
                            i = R.id.inv_chat_vertical_line;
                            View findViewById2 = rootView.findViewById(R.id.inv_chat_vertical_line);
                            if (findViewById2 != null) {
                                return new InventoryLayoutChatBinding((ConstraintLayout) rootView, findViewById, coordinatorLayout, editText, recyclerView, button, findViewById2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
