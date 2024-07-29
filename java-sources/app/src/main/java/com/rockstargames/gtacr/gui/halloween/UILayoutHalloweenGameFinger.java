package com.rockstargames.gtacr.gui.halloween;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.common.UILayout;
import java.util.Random;
import org.json.JSONObject;

public class UILayoutHalloweenGameFinger extends UILayout {
    private GUIHalloweenGame mRoot;
    private View mViewRoot = null;
    private Button mFinger = null;
    private int mLineWidth = -1;
    private int mChunk = -1;
    private FrameLayout mLine = null;
    private RunVerticalLineView mVerticalLine = null;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public class RunVerticalLineView extends View {
        private Drawable drawable;
        private int maxWidth;
        boolean reverse;
        float x;

        public RunVerticalLineView(Context context, int maxWidth) {
            super(context);
            //UILayoutHalloweenGameFinger.this = this$0;
            this.x = 0.0f;
            this.reverse = false;
            this.drawable = null;
            this.maxWidth = -1;
            this.maxWidth = maxWidth;
            setWillNotDraw(false);
            this.drawable = ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.halloween_vertical_finger_line, null);
        }

        public boolean isHitted() {
            return this.x >= ((float) (UILayoutHalloweenGameFinger.this.mChunk * 100)) && this.x <= ((float) ((UILayoutHalloweenGameFinger.this.mChunk * 100) + (UILayoutHalloweenGameFinger.this.mLineWidth / 4)));
        }

        @Override
        public void draw(Canvas canvas) {
            int i = 0;
            super.draw(canvas);
            Drawable drawable = this.drawable;
            float f = this.x;
            drawable.setBounds((int) f, 0, ((int) f) + 20, canvas.getHeight());
            this.drawable.draw(canvas);
            double d = this.x;
            Double.isNaN(d);
            double cos = (Math.cos(Math.toRadians(d * 3.0d)) * 5.0d) + 20.0d;
            if (this.reverse) {
                double d2 = this.x;
                Double.isNaN(d2);
                this.x = (float) (d2 - cos);
            } else {
                double d3 = this.x;
                Double.isNaN(d3);
                this.x = (float) (d3 + cos);
            }
            float f2 = this.x;
            if (((int) f2) >= this.maxWidth - 20) {
                this.reverse = true;
                this.x = i - 20;
            } else if (((int) f2) <= 0) {
                this.reverse = false;
                this.x = 0.0f;
            }
            invalidate();
        }
    }

    public UILayoutHalloweenGameFinger(GUIHalloweenGame root) {
        this.mRoot = null;
        this.mRoot = root;
    }

    @Override
    public View getView() {
        return this.mViewRoot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.halloween_game_finger, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        this.mLine = (FrameLayout) inflate.findViewById(R.id.line);
        Button button = (Button) this.mViewRoot.findViewById(R.id.finger);
        this.mFinger = button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (UILayoutHalloweenGameFinger.this.mVerticalLine.isHitted()) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("s", 1);
                        UILayoutHalloweenGameFinger.this.mRoot.getGuiManager().sendJsonData(UILayoutHalloweenGameFinger.this.mRoot.getGuiId(), jSONObject);
                        UILayoutHalloweenGameFinger.this.mRoot.close(null);
                    } else {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("s", 0);
                        UILayoutHalloweenGameFinger.this.mRoot.getGuiManager().sendJsonData(UILayoutHalloweenGameFinger.this.mRoot.getGuiId(), jSONObject2);
                        UILayoutHalloweenGameFinger.this.mRoot.close(null);
                    }
                } catch (Exception unused) {
                }
            }
        });
        this.mViewRoot.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                UILayoutHalloweenGameFinger.this.mViewRoot.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((NvEventQueueActivity) UILayoutHalloweenGameFinger.this.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) UILayoutHalloweenGameFinger.this.mLine.getLayoutParams();
                layoutParams.width = displayMetrics.widthPixels - (NvEventQueueActivity.dpToPx(40.0f, UILayoutHalloweenGameFinger.this.getContext()) * 2);
                UILayoutHalloweenGameFinger.this.mLine.setLayoutParams(layoutParams);
                UILayoutHalloweenGameFinger.this.mLineWidth = layoutParams.width;
                UILayoutHalloweenGameFinger uILayoutHalloweenGameFinger = UILayoutHalloweenGameFinger.this;
                uILayoutHalloweenGameFinger.mChunk = (uILayoutHalloweenGameFinger.mLineWidth / 100) / (new Random().nextInt(5) + 2);
                View view = new View(UILayoutHalloweenGameFinger.this.getContext());
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(UILayoutHalloweenGameFinger.this.mLineWidth / 4, -1);
                layoutParams2.setMargins(UILayoutHalloweenGameFinger.this.mChunk * 100, 0, 0, 0);
                layoutParams2.gravity = 3;
                view.setLayoutParams(layoutParams2);
                view.setBackgroundColor(Color.parseColor("#43CD7F"));
                ((ViewGroup) UILayoutHalloweenGameFinger.this.mViewRoot.findViewById(R.id.subline)).addView(view);
                UILayoutHalloweenGameFinger uILayoutHalloweenGameFinger2 = UILayoutHalloweenGameFinger.this;
                UILayoutHalloweenGameFinger uILayoutHalloweenGameFinger3 = UILayoutHalloweenGameFinger.this;
                uILayoutHalloweenGameFinger2.mVerticalLine = new RunVerticalLineView(uILayoutHalloweenGameFinger3.getContext(), UILayoutHalloweenGameFinger.this.mLineWidth);
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
                layoutParams3.gravity = 3;
                UILayoutHalloweenGameFinger.this.mVerticalLine.setLayoutParams(layoutParams3);
                UILayoutHalloweenGameFinger.this.mLine.addView(UILayoutHalloweenGameFinger.this.mVerticalLine);
            }
        });
        return this.mViewRoot;
    }
}
