package blackrussia.online.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import blackrussia.online.R;

public final class FamiliesMenuMainLayoutBinding implements ViewBinding {
    public final TextView ammunitionTitle;
    public final TextView ammunitionValue;
    public final TextView armorTitle;
    public final TextView armorValue;
    public final View bgFamilySkin;
    public final View bodyFamilyInfo;
    public final View bodyRightBlock;
    public final FrameLayout familySkin;
    public final TextView familyStatusTitle;
    public final TextView familyStatusValue;
    public final View leftTitleDiver;
    public final TextView masksTitle;
    public final TextView masksValue;
    public final TextView materialsTitle;
    public final TextView materialsValue;
    public final RecyclerView menuList;
    public final TextView moneyTitle;
    public final TextView moneyValue;
    public final TextView oilsTitle;
    public final TextView oilsValue;
    public final TextView peopleTitle;
    public final TextView peopleValue;
    public final TextView playersNick;
    public final TextView reputationsTitle;
    public final TextView reputationsValue;
    private final ConstraintLayout rootView;
    public final View tablesTitleLeftBlock;
    public final TextView titleLeftBlock;
    public final TextView titleRightBlock;
    public final TextView upgradePeopleTitle;
    public final TextView upgradePeopleValue;
    public final TextView upgradeStorageTitle;
    public final TextView upgradeStorageValue;
    public final TextView upgradeWeaponTitle;
    public final TextView upgradeWeaponValue;

    private FamiliesMenuMainLayoutBinding(ConstraintLayout rootView, TextView ammunitionTitle, TextView ammunitionValue, TextView armorTitle, TextView armorValue, View bgFamilySkin, View bodyFamilyInfo, View bodyRightBlock, FrameLayout familySkin, TextView familyStatusTitle, TextView familyStatusValue, View leftTitleDiver, TextView masksTitle, TextView masksValue, TextView materialsTitle, TextView materialsValue, RecyclerView menuList, TextView moneyTitle, TextView moneyValue, TextView oilsTitle, TextView oilsValue, TextView peopleTitle, TextView peopleValue, TextView playersNick, TextView reputationsTitle, TextView reputationsValue, View tablesTitleLeftBlock, TextView titleLeftBlock, TextView titleRightBlock, TextView upgradePeopleTitle, TextView upgradePeopleValue, TextView upgradeStorageTitle, TextView upgradeStorageValue, TextView upgradeWeaponTitle, TextView upgradeWeaponValue) {
        this.rootView = rootView;
        this.ammunitionTitle = ammunitionTitle;
        this.ammunitionValue = ammunitionValue;
        this.armorTitle = armorTitle;
        this.armorValue = armorValue;
        this.bgFamilySkin = bgFamilySkin;
        this.bodyFamilyInfo = bodyFamilyInfo;
        this.bodyRightBlock = bodyRightBlock;
        this.familySkin = familySkin;
        this.familyStatusTitle = familyStatusTitle;
        this.familyStatusValue = familyStatusValue;
        this.leftTitleDiver = leftTitleDiver;
        this.masksTitle = masksTitle;
        this.masksValue = masksValue;
        this.materialsTitle = materialsTitle;
        this.materialsValue = materialsValue;
        this.menuList = menuList;
        this.moneyTitle = moneyTitle;
        this.moneyValue = moneyValue;
        this.oilsTitle = oilsTitle;
        this.oilsValue = oilsValue;
        this.peopleTitle = peopleTitle;
        this.peopleValue = peopleValue;
        this.playersNick = playersNick;
        this.reputationsTitle = reputationsTitle;
        this.reputationsValue = reputationsValue;
        this.tablesTitleLeftBlock = tablesTitleLeftBlock;
        this.titleLeftBlock = titleLeftBlock;
        this.titleRightBlock = titleRightBlock;
        this.upgradePeopleTitle = upgradePeopleTitle;
        this.upgradePeopleValue = upgradePeopleValue;
        this.upgradeStorageTitle = upgradeStorageTitle;
        this.upgradeStorageValue = upgradeStorageValue;
        this.upgradeWeaponTitle = upgradeWeaponTitle;
        this.upgradeWeaponValue = upgradeWeaponValue;
    }

    @Override
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamiliesMenuMainLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FamiliesMenuMainLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.families_menu_main_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamiliesMenuMainLayoutBinding bind(View rootView) {
        int i = R.id.ammunition_title;
        TextView textView = (TextView) rootView.findViewById(R.id.ammunition_title);
        if (textView != null) {
            i = R.id.ammunition_value;
            TextView textView2 = (TextView) rootView.findViewById(R.id.ammunition_value);
            if (textView2 != null) {
                i = R.id.armor_title;
                TextView textView3 = (TextView) rootView.findViewById(R.id.armor_title);
                if (textView3 != null) {
                    i = R.id.armor_value;
                    TextView textView4 = (TextView) rootView.findViewById(R.id.armor_value);
                    if (textView4 != null) {
                        i = R.id.bg_family_skin;
                        View findViewById = rootView.findViewById(R.id.bg_family_skin);
                        if (findViewById != null) {
                            i = R.id.body_family_info;
                            View findViewById2 = rootView.findViewById(R.id.body_family_info);
                            if (findViewById2 != null) {
                                i = R.id.body_right_block;
                                View findViewById3 = rootView.findViewById(R.id.body_right_block);
                                if (findViewById3 != null) {
                                    i = R.id.family_skin;
                                    FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.family_skin);
                                    if (frameLayout != null) {
                                        i = R.id.family_status_title;
                                        TextView textView5 = (TextView) rootView.findViewById(R.id.family_status_title);
                                        if (textView5 != null) {
                                            i = R.id.family_status_value;
                                            TextView textView6 = (TextView) rootView.findViewById(R.id.family_status_value);
                                            if (textView6 != null) {
                                                i = R.id.left_title_diver;
                                                View findViewById4 = rootView.findViewById(R.id.left_title_diver);
                                                if (findViewById4 != null) {
                                                    i = R.id.masks_title;
                                                    TextView textView7 = (TextView) rootView.findViewById(R.id.masks_title);
                                                    if (textView7 != null) {
                                                        i = R.id.masks_value;
                                                        TextView textView8 = (TextView) rootView.findViewById(R.id.masks_value);
                                                        if (textView8 != null) {
                                                            i = R.id.materials_title;
                                                            TextView textView9 = (TextView) rootView.findViewById(R.id.materials_title);
                                                            if (textView9 != null) {
                                                                i = R.id.materials_value;
                                                                TextView textView10 = (TextView) rootView.findViewById(R.id.materials_value);
                                                                if (textView10 != null) {
                                                                    i = R.id.menu_list;
                                                                    RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.menu_list);
                                                                    if (recyclerView != null) {
                                                                        i = R.id.money_title;
                                                                        TextView textView11 = (TextView) rootView.findViewById(R.id.money_title);
                                                                        if (textView11 != null) {
                                                                            i = R.id.money_value;
                                                                            TextView textView12 = (TextView) rootView.findViewById(R.id.money_value);
                                                                            if (textView12 != null) {
                                                                                i = R.id.oils_title;
                                                                                TextView textView13 = (TextView) rootView.findViewById(R.id.oils_title);
                                                                                if (textView13 != null) {
                                                                                    i = R.id.oils_value;
                                                                                    TextView textView14 = (TextView) rootView.findViewById(R.id.oils_value);
                                                                                    if (textView14 != null) {
                                                                                        i = R.id.people_title;
                                                                                        TextView textView15 = (TextView) rootView.findViewById(R.id.people_title);
                                                                                        if (textView15 != null) {
                                                                                            i = R.id.people_value;
                                                                                            TextView textView16 = (TextView) rootView.findViewById(R.id.people_value);
                                                                                            if (textView16 != null) {
                                                                                                i = R.id.players_nick;
                                                                                                TextView textView17 = (TextView) rootView.findViewById(R.id.players_nick);
                                                                                                if (textView17 != null) {
                                                                                                    i = R.id.reputations_title;
                                                                                                    TextView textView18 = (TextView) rootView.findViewById(R.id.reputations_title);
                                                                                                    if (textView18 != null) {
                                                                                                        i = R.id.reputations_value;
                                                                                                        TextView textView19 = (TextView) rootView.findViewById(R.id.reputations_value);
                                                                                                        if (textView19 != null) {
                                                                                                            i = R.id.tables_title_left_block;
                                                                                                            View findViewById5 = rootView.findViewById(R.id.tables_title_left_block);
                                                                                                            if (findViewById5 != null) {
                                                                                                                i = R.id.title_left_block;
                                                                                                                TextView textView20 = (TextView) rootView.findViewById(R.id.title_left_block);
                                                                                                                if (textView20 != null) {
                                                                                                                    i = R.id.title_right_block;
                                                                                                                    TextView textView21 = (TextView) rootView.findViewById(R.id.title_right_block);
                                                                                                                    if (textView21 != null) {
                                                                                                                        i = R.id.upgrade_people_title;
                                                                                                                        TextView textView22 = (TextView) rootView.findViewById(R.id.upgrade_people_title);
                                                                                                                        if (textView22 != null) {
                                                                                                                            i = R.id.upgrade_people_value;
                                                                                                                            TextView textView23 = (TextView) rootView.findViewById(R.id.upgrade_people_value);
                                                                                                                            if (textView23 != null) {
                                                                                                                                i = R.id.upgrade_storage_title;
                                                                                                                                TextView textView24 = (TextView) rootView.findViewById(R.id.upgrade_storage_title);
                                                                                                                                if (textView24 != null) {
                                                                                                                                    i = R.id.upgrade_storage_value;
                                                                                                                                    TextView textView25 = (TextView) rootView.findViewById(R.id.upgrade_storage_value);
                                                                                                                                    if (textView25 != null) {
                                                                                                                                        i = R.id.upgrade_weapon_title;
                                                                                                                                        TextView textView26 = (TextView) rootView.findViewById(R.id.upgrade_weapon_title);
                                                                                                                                        if (textView26 != null) {
                                                                                                                                            i = R.id.upgrade_weapon_value;
                                                                                                                                            TextView textView27 = (TextView) rootView.findViewById(R.id.upgrade_weapon_value);
                                                                                                                                            if (textView27 != null) {
                                                                                                                                                return new FamiliesMenuMainLayoutBinding((ConstraintLayout) rootView, textView, textView2, textView3, textView4, findViewById, findViewById2, findViewById3, frameLayout, textView5, textView6, findViewById4, textView7, textView8, textView9, textView10, recyclerView, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, findViewById5, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27);
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
