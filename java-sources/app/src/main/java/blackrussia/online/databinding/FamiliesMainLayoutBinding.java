package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesMainLayoutBinding implements ViewBinding {
    public final View familyItem1;
    public final View familyItem2;
    public final View familyItem3;
    public final View familyItem4;
    public final View familyItem5;
    public final ImageView item1Icon;
    public final TextView item1Title;
    public final ImageView item2Icon;
    public final TextView item2Title;
    public final ImageView item3Icon;
    public final TextView item3Title;
    public final ImageView item4Icon;
    public final TextView item4Title;
    public final ImageView item5Icon;
    public final TextView item5Title;
    private final NestedScrollView rootView;

    private FamiliesMainLayoutBinding(NestedScrollView rootView, View familyItem1, View familyItem2, View familyItem3, View familyItem4, View familyItem5, ImageView item1Icon, TextView item1Title, ImageView item2Icon, TextView item2Title, ImageView item3Icon, TextView item3Title, ImageView item4Icon, TextView item4Title, ImageView item5Icon, TextView item5Title) {
        this.rootView = rootView;
        this.familyItem1 = familyItem1;
        this.familyItem2 = familyItem2;
        this.familyItem3 = familyItem3;
        this.familyItem4 = familyItem4;
        this.familyItem5 = familyItem5;
        this.item1Icon = item1Icon;
        this.item1Title = item1Title;
        this.item2Icon = item2Icon;
        this.item2Title = item2Title;
        this.item3Icon = item3Icon;
        this.item3Title = item3Title;
        this.item4Icon = item4Icon;
        this.item4Title = item4Title;
        this.item5Icon = item5Icon;
        this.item5Title = item5Title;
    }

    @Override
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FamiliesMainLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesMainLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_main_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesMainLayoutBinding bind(View rootView) {
        int i = R.id.family_item_1;
        View findViewById = rootView.findViewById(R.id.family_item_1);
        if (findViewById != null) {
            i = R.id.family_item_2;
            View findViewById2 = rootView.findViewById(R.id.family_item_2);
            if (findViewById2 != null) {
                i = R.id.family_item_3;
                View findViewById3 = rootView.findViewById(R.id.family_item_3);
                if (findViewById3 != null) {
                    i = R.id.family_item_4;
                    View findViewById4 = rootView.findViewById(R.id.family_item_4);
                    if (findViewById4 != null) {
                        i = R.id.family_item_5;
                        View findViewById5 = rootView.findViewById(R.id.family_item_5);
                        if (findViewById5 != null) {
                            i = R.id.item_1_icon;
                            ImageView imageView = (ImageView) rootView.findViewById(R.id.item_1_icon);
                            if (imageView != null) {
                                i = R.id.item_1_title;
                                TextView textView = (TextView) rootView.findViewById(R.id.item_1_title);
                                if (textView != null) {
                                    i = R.id.item_2_icon;
                                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.item_2_icon);
                                    if (imageView2 != null) {
                                        i = R.id.item_2_title;
                                        TextView textView2 = (TextView) rootView.findViewById(R.id.item_2_title);
                                        if (textView2 != null) {
                                            i = R.id.item_3_icon;
                                            ImageView imageView3 = (ImageView) rootView.findViewById(R.id.item_3_icon);
                                            if (imageView3 != null) {
                                                i = R.id.item_3_title;
                                                TextView textView3 = (TextView) rootView.findViewById(R.id.item_3_title);
                                                if (textView3 != null) {
                                                    i = R.id.item_4_icon;
                                                    ImageView imageView4 = (ImageView) rootView.findViewById(R.id.item_4_icon);
                                                    if (imageView4 != null) {
                                                        i = R.id.item_4_title;
                                                        TextView textView4 = (TextView) rootView.findViewById(R.id.item_4_title);
                                                        if (textView4 != null) {
                                                            i = R.id.item_5_icon;
                                                            ImageView imageView5 = (ImageView) rootView.findViewById(R.id.item_5_icon);
                                                            if (imageView5 != null) {
                                                                i = R.id.item_5_title;
                                                                TextView textView5 = (TextView) rootView.findViewById(R.id.item_5_title);
                                                                if (textView5 != null) {
                                                                    return new FamiliesMainLayoutBinding((NestedScrollView) rootView, findViewById, findViewById2, findViewById3, findViewById4, findViewById5, imageView, textView, imageView2, textView2, imageView3, textView3, imageView4, textView4, imageView5, textView5);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
