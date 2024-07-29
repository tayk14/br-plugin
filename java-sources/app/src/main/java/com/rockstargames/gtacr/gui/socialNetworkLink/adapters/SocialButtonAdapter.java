package com.rockstargames.gtacr.gui.socialNetworkLink.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.Utils;
import blackrussia.online.databinding.SocialNetworkLinkButtonBinding;
import com.rockstargames.gtacr.gui.socialNetworkLink.GUISocialNetworkLink;
import com.rockstargames.gtacr.gui.socialNetworkLink.adapters.SocialButtonAdapter;
import com.rockstargames.gtacr.gui.socialNetworkLink.data.SocialButtonObj;
import com.rockstargames.gtacr.gui.socialNetworkLink.network.SocialNetworkActionWithJSON;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/rockstargames/gtacr/gui/socialNetworkLink/adapters/SocialButtonAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rockstargames/gtacr/gui/socialNetworkLink/adapters/SocialButtonAdapter$ViewHolder;", "mainRoot", "Lcom/rockstargames/gtacr/gui/socialNetworkLink/GUISocialNetworkLink;", "buttonsList", "", "Lcom/rockstargames/gtacr/gui/socialNetworkLink/data/SocialButtonObj;", "actionWithJSON", "Lcom/rockstargames/gtacr/gui/socialNetworkLink/network/SocialNetworkActionWithJSON;", "(Lcom/rockstargames/gtacr/gui/socialNetworkLink/GUISocialNetworkLink;Ljava/util/List;Lcom/rockstargames/gtacr/gui/socialNetworkLink/network/SocialNetworkActionWithJSON;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SocialButtonAdapter extends RecyclerView.Adapter<SocialButtonAdapter.ViewHolder> {
    private final SocialNetworkActionWithJSON actionWithJSON;
    private final List<SocialButtonObj> buttonsList;
    private final GUISocialNetworkLink mainRoot;

    public SocialButtonAdapter(GUISocialNetworkLink mainRoot, List<SocialButtonObj> buttonsList, SocialNetworkActionWithJSON socialNetworkActionWithJSON) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(buttonsList, "buttonsList");
        this.mainRoot = mainRoot;
        this.buttonsList = buttonsList;
        this.actionWithJSON = socialNetworkActionWithJSON;
    }

    //@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/rockstargames/gtacr/gui/socialNetworkLink/adapters/SocialButtonAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lblackrussia/online/databinding/SocialNetworkLinkButtonBinding;", "(Lcom/rockstargames/gtacr/gui/socialNetworkLink/adapters/SocialButtonAdapter;Lblackrussia/online/databinding/SocialNetworkLinkButtonBinding;)V", "bind", "", "buttonItem", "Lcom/rockstargames/gtacr/gui/socialNetworkLink/data/SocialButtonObj;", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final SocialNetworkLinkButtonBinding binding;
        final SocialButtonAdapter this$0;

        public ViewHolder(SocialButtonAdapter this$0, SocialNetworkLinkButtonBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = this$0;
            this.binding = binding;
        }

        public final void bind(final SocialButtonObj buttonItem) {
            Intrinsics.checkNotNullParameter(buttonItem, "buttonItem");
            SocialNetworkLinkButtonBinding socialNetworkLinkButtonBinding = this.binding;
            final SocialButtonAdapter socialButtonAdapter = this.this$0;
            final Animation loadAnimation = AnimationUtils.loadAnimation(socialNetworkLinkButtonBinding.getRoot().getContext(), R.anim.button_click);
            if (buttonItem.isActive() == 1) {
                socialNetworkLinkButtonBinding.socialNetworkLinkButtonBorder.setBackground(ResourcesCompat.getDrawable(this.binding.getRoot().getContext().getResources(), R.drawable.social_network_link_button_border_active, null));
                socialNetworkLinkButtonBinding.socialNetworkLinkButtonAura.setVisibility(0);
                socialNetworkLinkButtonBinding.socialNetworkLinkButtonName.setBackground(ResourcesCompat.getDrawable(this.binding.getRoot().getContext().getResources(), R.drawable.social_network_link_button_aura_active, null));
                Utils.setBackground(socialButtonAdapter.mainRoot.getMainActivity(), buttonItem.getButtonResIdIfActive(), this.binding.socialNetworkLinkButtonIcon);
                socialNetworkLinkButtonBinding.socialNetworkLinkButtonName.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.white));
                socialNetworkLinkButtonBinding.socialNetworkLinkButtonBgColorNotActive.setVisibility(4);
                socialNetworkLinkButtonBinding.socialNetworkLinkButtonBgStyleNotActive.setVisibility(4);
            } else {
                socialNetworkLinkButtonBinding.socialNetworkLinkButtonBorder.setBackground(ResourcesCompat.getDrawable(this.binding.getRoot().getContext().getResources(), R.drawable.social_network_link_button_border_not_active, null));
                socialNetworkLinkButtonBinding.socialNetworkLinkButtonAura.setVisibility(4);
                socialNetworkLinkButtonBinding.socialNetworkLinkButtonName.setBackground(ResourcesCompat.getDrawable(this.binding.getRoot().getContext().getResources(), R.drawable.social_network_link_button_aura_not_active, null));
                Utils.setBackground(socialButtonAdapter.mainRoot.getMainActivity(), buttonItem.getButtonResIdIfNotActive(), this.binding.socialNetworkLinkButtonIcon);
                socialNetworkLinkButtonBinding.socialNetworkLinkButtonName.setTextColor(ContextCompat.getColor(this.binding.getRoot().getContext(), R.color.color_6F717C));
                socialNetworkLinkButtonBinding.socialNetworkLinkButtonBgColorNotActive.setVisibility(0);
                socialNetworkLinkButtonBinding.socialNetworkLinkButtonBgStyleNotActive.setVisibility(0);
            }
            this.binding.socialNetworkLinkButtonName.setText(buttonItem.getButtonName());
            socialNetworkLinkButtonBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public final void onClick(View view) {
                    //SocialButtonAdapter.ViewHolder.m403bind$lambda1$lambda0(SocialButtonObj.this, loadAnimation, socialButtonAdapter, view);
                }
            });
        }

        public static final void m403bind$lambda1$lambda0(SocialButtonObj buttonItem, Animation animation, SocialButtonAdapter this$0, View view) {
            Intrinsics.checkNotNullParameter(buttonItem, "$buttonItem");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (buttonItem.isActive() == 1) {
                view.startAnimation(animation);
                SocialNetworkActionWithJSON socialNetworkActionWithJSON = this$0.actionWithJSON;
                if (socialNetworkActionWithJSON != null) {
                    socialNetworkActionWithJSON.sendSocialNetworkButton(buttonItem.getButtonId());
                }
                this$0.mainRoot.close(null);
            }
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        SocialNetworkLinkButtonBinding inflate = SocialNetworkLinkButtonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f…           parent, false)");
        return new ViewHolder(this, inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.buttonsList.get(i));
    }

    @Override
    public int getItemCount() {
        return this.buttonsList.size();
    }
}
