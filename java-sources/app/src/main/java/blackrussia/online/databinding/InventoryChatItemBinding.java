package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class InventoryChatItemBinding implements ViewBinding {
    public final RelativeLayout blockWithActions;
    public final TextView chatPlayersNick;
    public final TextView chatTextMessage;
    public final TextView finalActionText;
    private final RelativeLayout rootView;

    private InventoryChatItemBinding(RelativeLayout rootView, RelativeLayout blockWithActions, TextView chatPlayersNick, TextView chatTextMessage, TextView finalActionText) {
        this.rootView = rootView;
        this.blockWithActions = blockWithActions;
        this.chatPlayersNick = chatPlayersNick;
        this.chatTextMessage = chatTextMessage;
        this.finalActionText = finalActionText;
    }

    @Override
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static InventoryChatItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static InventoryChatItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.inventory_chat_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static InventoryChatItemBinding bind(View rootView) {
        int i = R.id.block_with_actions;
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.block_with_actions);
        if (relativeLayout != null) {
            i = R.id.chat_players_nick;
            TextView textView = (TextView) rootView.findViewById(R.id.chat_players_nick);
            if (textView != null) {
                i = R.id.chat_text_message;
                TextView textView2 = (TextView) rootView.findViewById(R.id.chat_text_message);
                if (textView2 != null) {
                    i = R.id.final_action_text;
                    TextView textView3 = (TextView) rootView.findViewById(R.id.final_action_text);
                    if (textView3 != null) {
                        return new InventoryChatItemBinding((RelativeLayout) rootView, relativeLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
