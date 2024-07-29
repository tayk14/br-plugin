package com.rockstargames.gtacr.gui.tuning;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.network.Tune;
import com.rockstargames.gtacr.GUIManager;
import com.rockstargames.gtacr.adapters.TuningBoxAdapter;
import com.rockstargames.gtacr.data.TuningBoxItem;
import java.util.ArrayList;
import java.util.List;

public class TuningOpeningBox {
    private View bgBoxView;
    private View boxView;
    private Button buttonExitForCardView;
    private ConstraintLayout buttonOpenBox;
    private RelativeLayout cardInvisible;
    private RelativeLayout cardProcessOpening;
    private RelativeLayout cardVisible;
    private Context context;
    private GUITuning mainRoot;
    private TextView nameDetailBox;
    private TextView typeDetailBox;
    private LinearLayout view1;
    private TextView viewCostThisBox;
    private TextView viewCurrencyBox;
    private TextView viewNameInvisibleBox;
    private TextView viewNameThisBox;
    private Animation anim = null;
    private TuningBoxAdapter boxAdapter = null;
    private RecyclerView recVListItemsBox = null;
    private List<Tune> boxItems = new ArrayList();
    private List<TuningBoxItem> boxNames = new ArrayList();
    private int statusOpeningBox = 0;

    public TuningOpeningBox(GUITuning mainRoot, View view, Context context) {
        this.boxView = null;
        this.boxView = view;
        this.mainRoot = mainRoot;
        this.context = context;
    }

    public void startOpeningBox(int cost, int currency) {
        findViewDataInLayout();
        setData();
        setDataBoxListInView();
        listenerActions();
        setDataInView(cost, currency);
    }

    private void findViewDataInLayout() {
        this.recVListItemsBox = (RecyclerView) this.boxView.findViewById(R.id.recv_box_items);
        this.buttonExitForCardView = (Button) this.boxView.findViewById(R.id.button_exit_card_view);
        this.buttonOpenBox = (ConstraintLayout) this.boxView.findViewById(R.id.tuning_price_box);
        this.viewCostThisBox = (TextView) this.boxView.findViewById(R.id.tuning_value_price_box);
        this.viewCurrencyBox = (TextView) this.boxView.findViewById(R.id.tuning_currency_box);
        this.viewNameThisBox = (TextView) this.boxView.findViewById(R.id.name_this_box);
        this.viewNameInvisibleBox = (TextView) this.boxView.findViewById(R.id.title_check_box_invisible);
        this.nameDetailBox = (TextView) this.boxView.findViewById(R.id.name_detail_in_box);
        this.typeDetailBox = (TextView) this.boxView.findViewById(R.id.type_detail_in_box);
        this.view1 = (LinearLayout) this.boxView.findViewById(R.id.view_box_buying);
        this.cardProcessOpening = (RelativeLayout) this.boxView.findViewById(R.id.block_open_cards);
        this.cardInvisible = (RelativeLayout) this.boxView.findViewById(R.id.box_card_invisible);
        this.cardVisible = (RelativeLayout) this.boxView.findViewById(R.id.box_card_visible);
        this.bgBoxView = this.boxView.findViewById(R.id.bg_box_open_card);
    }

    private void setData() {
        setNamesInBoxList();
        this.boxAdapter = new TuningBoxAdapter(this.boxNames);
        this.anim = AnimationUtils.loadAnimation(this.context, R.anim.button_click);
    }

    private void setDataBoxListInView() {
        this.recVListItemsBox.setAdapter(this.boxAdapter);
        this.recVListItemsBox.setLayoutManager(setVerticalLayout());
    }

    private RecyclerView.LayoutManager setVerticalLayout() {
        return new LinearLayoutManager(this.context, 1, false);
    }

    private void setNamesInBoxList() {
        this.boxNames.clear();
        this.boxNames = this.mainRoot.getNamesForBox();
    }

    private void setDataInView(int boxCost, int currency) {
        String str;
        if (currency == 0) {
            this.buttonOpenBox.setVisibility(0);
            str = "₽";
        } else if (currency == 1) {
            this.buttonOpenBox.setVisibility(0);
            str = "BC";
        } else {
            this.buttonOpenBox.setVisibility(4);
            str = "";
        }
        String priceWithSpaces = GUIManager.getPriceWithSpaces(boxCost);
        this.viewNameThisBox.setText("С деталями");
        this.viewCostThisBox.setText(priceWithSpaces);
        this.viewCurrencyBox.setText(str);
        this.viewNameInvisibleBox.setText("С деталями");
    }

    public void setDataOpeningBox(String typeDetail, String nameDetail) {
        this.nameDetailBox.setText(typeDetail);
        this.typeDetailBox.setText(nameDetail);
    }

    private void listenerActions() {
        this.buttonExitForCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                TuningOpeningBox.this.lambda$listenerActions$1$TuningOpeningBox(view);
            }
        });
        this.buttonOpenBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                TuningOpeningBox.this.lambda$listenerActions$3$TuningOpeningBox(view);
            }
        });
        this.cardInvisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                TuningOpeningBox.this.lambda$listenerActions$6$TuningOpeningBox(view);
            }
        });
        this.cardVisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                TuningOpeningBox.this.lambda$listenerActions$7$TuningOpeningBox(view);
            }
        });
    }

    public void lambda$listenerActions$1$TuningOpeningBox(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                TuningOpeningBox.this.lambda$null$0$TuningOpeningBox();
            }
        }, 250L);
    }

    public void lambda$null$0$TuningOpeningBox() {
        this.mainRoot.closeBoxCardView();
    }

    public void lambda$listenerActions$3$TuningOpeningBox(View view) {
        view.startAnimation(this.anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                TuningOpeningBox.this.lambda$null$2$TuningOpeningBox();
            }
        }, 250L);
    }

    public void lambda$null$2$TuningOpeningBox() {
        if (this.mainRoot.getDetailItem() != null) {
            this.mainRoot.putIntegerDataToServer(11, this.mainRoot.getDetailItem().getId());
        }
    }

    public void lambda$listenerActions$6$TuningOpeningBox(View view) {
        this.statusOpeningBox = 0;
        this.cardVisible.setVisibility(0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                TuningOpeningBox.this.lambda$null$4$TuningOpeningBox();
            }
        }, 800L);
        new Handler().postDelayed(new Runnable() {
            @Override
            public final void run() {
                TuningOpeningBox.this.lambda$null$5$TuningOpeningBox();
            }
        }, 1500L);
    }

    public void lambda$null$4$TuningOpeningBox() {
        this.cardInvisible.setVisibility(8);
    }

    public void lambda$null$5$TuningOpeningBox() {
        this.bgBoxView.setVisibility(0);
        this.bgBoxView.setBackground(AppCompatResources.getDrawable(this.context, R.drawable.tuning_bg_box_card_visible));
    }

    public void lambda$listenerActions$7$TuningOpeningBox(View view) {
        this.mainRoot.closeBoxCardView();
    }

    public void isTrueOpeningBox() {
        this.view1.setVisibility(8);
        this.cardProcessOpening.setVisibility(0);
    }

    public void setStatusOpeningBox(int statusOpeningBox) {
        this.statusOpeningBox = statusOpeningBox;
    }

    public int getStatusOpeningBox() {
        return this.statusOpeningBox;
    }
}
