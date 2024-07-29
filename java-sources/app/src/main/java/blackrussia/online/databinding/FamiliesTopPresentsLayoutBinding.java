package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesTopPresentsLayoutBinding implements ViewBinding {
    public final View accessories1Bg;
    public final ImageView accessories1Item;
    public final TextView accessories1Title;
    public final TextView accessories1ValueDays;
    public final View accessories2Bg;
    public final ImageView accessories2Item;
    public final TextView accessories2Title;
    public final TextView accessories2ValueDays;
    public final View accessories3Bg;
    public final ImageView accessories3Item;
    public final TextView accessories3Title;
    public final TextView accessories3ValueDays;
    public final ImageView cup1;
    public final ImageView cup2;
    public final ImageView cup3;
    public final RecyclerView presents1;
    public final RecyclerView presents2;
    public final RecyclerView presents3;
    private final ConstraintLayout rootView;
    public final TextView title1;
    public final TextView title2;
    public final TextView title3;
    public final View top1Position;
    public final View top2Position;
    public final View top3Position;

    private FamiliesTopPresentsLayoutBinding(ConstraintLayout rootView, View accessories1Bg, ImageView accessories1Item, TextView accessories1Title, TextView accessories1ValueDays, View accessories2Bg, ImageView accessories2Item, TextView accessories2Title, TextView accessories2ValueDays, View accessories3Bg, ImageView accessories3Item, TextView accessories3Title, TextView accessories3ValueDays, ImageView cup1, ImageView cup2, ImageView cup3, RecyclerView presents1, RecyclerView presents2, RecyclerView presents3, TextView title1, TextView title2, TextView title3, View top1Position, View top2Position, View top3Position) {
        this.rootView = rootView;
        this.accessories1Bg = accessories1Bg;
        this.accessories1Item = accessories1Item;
        this.accessories1Title = accessories1Title;
        this.accessories1ValueDays = accessories1ValueDays;
        this.accessories2Bg = accessories2Bg;
        this.accessories2Item = accessories2Item;
        this.accessories2Title = accessories2Title;
        this.accessories2ValueDays = accessories2ValueDays;
        this.accessories3Bg = accessories3Bg;
        this.accessories3Item = accessories3Item;
        this.accessories3Title = accessories3Title;
        this.accessories3ValueDays = accessories3ValueDays;
        this.cup1 = cup1;
        this.cup2 = cup2;
        this.cup3 = cup3;
        this.presents1 = presents1;
        this.presents2 = presents2;
        this.presents3 = presents3;
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
        this.top1Position = top1Position;
        this.top2Position = top2Position;
        this.top3Position = top3Position;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesTopPresentsLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesTopPresentsLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_top_presents_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesTopPresentsLayoutBinding bind(View rootView) {
        int i = R.id.accessories_1_bg;
        View findViewById = rootView.findViewById(R.id.accessories_1_bg);
        if (findViewById != null) {
            i = R.id.accessories_1_item;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.accessories_1_item);
            if (imageView != null) {
                i = R.id.accessories_1_title;
                TextView textView = (TextView) rootView.findViewById(R.id.accessories_1_title);
                if (textView != null) {
                    i = R.id.accessories_1_value_days;
                    TextView textView2 = (TextView) rootView.findViewById(R.id.accessories_1_value_days);
                    if (textView2 != null) {
                        i = R.id.accessories_2_bg;
                        View findViewById2 = rootView.findViewById(R.id.accessories_2_bg);
                        if (findViewById2 != null) {
                            i = R.id.accessories_2_item;
                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.accessories_2_item);
                            if (imageView2 != null) {
                                i = R.id.accessories_2_title;
                                TextView textView3 = (TextView) rootView.findViewById(R.id.accessories_2_title);
                                if (textView3 != null) {
                                    i = R.id.accessories_2_value_days;
                                    TextView textView4 = (TextView) rootView.findViewById(R.id.accessories_2_value_days);
                                    if (textView4 != null) {
                                        i = R.id.accessories_3_bg;
                                        View findViewById3 = rootView.findViewById(R.id.accessories_3_bg);
                                        if (findViewById3 != null) {
                                            i = R.id.accessories_3_item;
                                            ImageView imageView3 = (ImageView) rootView.findViewById(R.id.accessories_3_item);
                                            if (imageView3 != null) {
                                                i = R.id.accessories_3_title;
                                                TextView textView5 = (TextView) rootView.findViewById(R.id.accessories_3_title);
                                                if (textView5 != null) {
                                                    i = R.id.accessories_3_value_days;
                                                    TextView textView6 = (TextView) rootView.findViewById(R.id.accessories_3_value_days);
                                                    if (textView6 != null) {
                                                        i = R.id.cup_1;
                                                        ImageView imageView4 = (ImageView) rootView.findViewById(R.id.cup_1);
                                                        if (imageView4 != null) {
                                                            i = R.id.cup_2;
                                                            ImageView imageView5 = (ImageView) rootView.findViewById(R.id.cup_2);
                                                            if (imageView5 != null) {
                                                                i = R.id.cup_3;
                                                                ImageView imageView6 = (ImageView) rootView.findViewById(R.id.cup_3);
                                                                if (imageView6 != null) {
                                                                    i = R.id.presents_1;
                                                                    RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.presents_1);
                                                                    if (recyclerView != null) {
                                                                        i = R.id.presents_2;
                                                                        RecyclerView recyclerView2 = (RecyclerView) rootView.findViewById(R.id.presents_2);
                                                                        if (recyclerView2 != null) {
                                                                            i = R.id.presents_3;
                                                                            RecyclerView recyclerView3 = (RecyclerView) rootView.findViewById(R.id.presents_3);
                                                                            if (recyclerView3 != null) {
                                                                                i = R.id.title_1;
                                                                                TextView textView7 = (TextView) rootView.findViewById(R.id.title_1);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.title_2;
                                                                                    TextView textView8 = (TextView) rootView.findViewById(R.id.title_2);
                                                                                    if (textView8 != null) {
                                                                                        i = R.id.title_3;
                                                                                        TextView textView9 = (TextView) rootView.findViewById(R.id.title_3);
                                                                                        if (textView9 != null) {
                                                                                            i = R.id.top_1_position;
                                                                                            View findViewById4 = rootView.findViewById(R.id.top_1_position);
                                                                                            if (findViewById4 != null) {
                                                                                                i = R.id.top_2_position;
                                                                                                View findViewById5 = rootView.findViewById(R.id.top_2_position);
                                                                                                if (findViewById5 != null) {
                                                                                                    i = R.id.top_3_position;
                                                                                                    View findViewById6 = rootView.findViewById(R.id.top_3_position);
                                                                                                    if (findViewById6 != null) {
                                                                                                        return new FamiliesTopPresentsLayoutBinding((ConstraintLayout) rootView, findViewById, imageView, textView, textView2, findViewById2, imageView2, textView3, textView4, findViewById3, imageView3, textView5, textView6, imageView4, imageView5, imageView6, recyclerView, recyclerView2, recyclerView3, textView7, textView8, textView9, findViewById4, findViewById5, findViewById6);
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
