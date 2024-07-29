package com.rockstargames.gtacr;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.DialogFragment;

/* loaded from: classes2.dex */
public class NotificationDialogFragment extends DialogFragment {
    private String mInfo;

    public NotificationDialogFragment(String info) {
        this.mInfo = info;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(this.mInfo + "\n\nУ вас проблема с файлами игры. Нажмите кнопку «Починить игру» в настройках лаунчера.").setPositiveButton("Закрыть", new DialogInterface.OnClickListener() { // from class: com.rockstargames.gtacr.NotificationDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int id) {
                System.exit(0);
            }
        });
        setCancelable(false);
        final AlertDialog create = builder.create();
        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.rockstargames.gtacr.NotificationDialogFragment.2
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                create.getButton(-1).setTextColor(SupportMenu.CATEGORY_MASK);
            }
        });
        return create;
    }
}
