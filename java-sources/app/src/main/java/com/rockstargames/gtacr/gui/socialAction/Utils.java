package com.rockstargames.gtacr.gui.socialAction;

import android.util.Log;
import blackrussia.online.network.SocialInteraction;
import kotlin.Metadata;

//@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/rockstargames/gtacr/gui/socialAction/Utils;", "", "()V", "BUTTON_BACK", "", "COMMUNICATION_TYPE", "DEFAULT_TYPE", "LOG_TAG", "", "MAIN_TYPE", "ORGANIZATION_TYPE", "SOCIAL_TYPE", "logThisAction", "", "thisAction", "Lblackrussia/online/network/SocialInteraction;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Utils {
    public static final int BUTTON_BACK = 0;
    public static final int COMMUNICATION_TYPE = 3;
    public static final int DEFAULT_TYPE = 0;
    public static final Utils INSTANCE = new Utils();
    public static final String LOG_TAG = "LOG_SOCIAL";
    public static final int MAIN_TYPE = 4;
    public static final int ORGANIZATION_TYPE = 1;
    public static final int SOCIAL_TYPE = 2;

    private Utils() {
    }

    public final void logThisAction(SocialInteraction socialInteraction) {
        StringBuilder sb = new StringBuilder();
        sb.append("id = ");
        sb.append(socialInteraction == null ? null : Integer.valueOf(socialInteraction.getId()));
        sb.append(", name = ");
        sb.append((Object) (socialInteraction == null ? null : socialInteraction.getName()));
        sb.append(", type = ");
        sb.append(socialInteraction == null ? null : Integer.valueOf(socialInteraction.getType()));
        sb.append(", org = ");
        sb.append(socialInteraction == null ? null : Integer.valueOf(socialInteraction.getOrg()));
        sb.append(", page = ");
        sb.append(socialInteraction != null ? Integer.valueOf(socialInteraction.getPage()) : null);
        Log.v(LOG_TAG, sb.toString());
    }
}
