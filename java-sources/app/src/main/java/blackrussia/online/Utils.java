package blackrussia.online;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;

/* loaded from: classes.dex */
public class Utils {
    public static void setBackground(Activity activity, int resource, final View view) {
        Glide.with(activity).load(Integer.valueOf(resource)).signature(new ObjectKey(Long.valueOf(System.currentTimeMillis()))).into( new CustomTarget<Drawable>() { // from class: blackrussia.online.Utils.1
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable placeholder) {
            }

            public void onResourceReady(Drawable resource2, Transition<? super Drawable> transition) {
                view.setBackground(resource2);
            }
        });
    }
}
