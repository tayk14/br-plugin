package com.rockstargames.gtacr.gui.halloween;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import blackrussia.online.R;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.GameRender;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.gui.tuning.TuningConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public class UILayoutHalloweenGamePrize extends UILayout {
    private GUIHalloweenGame mRoot;
    private View mViewRoot = null;
    private ImageView mImage = null;
    private TextView mSubHeader = null;
    private TextView mHeader = null;

    @Override
    public void onLayoutClose() {
    }

    public UILayoutHalloweenGamePrize(GUIHalloweenGame root) {
        this.mRoot = null;
        this.mRoot = root;
    }

    @Override
    public View getView() {
        return this.mViewRoot;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View inflate = inflater.inflate(R.layout.halloween_game_prize, (ViewGroup) null, false);
        this.mViewRoot = inflate;
        this.mImage = (ImageView) inflate.findViewById(R.id.image);
        this.mSubHeader = (TextView) this.mViewRoot.findViewById(R.id.info);
        this.mHeader = (TextView) this.mViewRoot.findViewById(R.id.header);
        return this.mViewRoot;
    }

    @Override
    public void onLayoutShown() {
        String optString = this.mRoot.getJson().optString("n");
        int optInt = this.mRoot.getJson().optInt(TuningConstants.KEY_GET_OLD_INSTALL_DETAIL, -1);
        this.mSubHeader.setText(this.mRoot.getJson().optString("m"));
        this.mHeader.setText(this.mRoot.getJson().optString("h"));
        if (optString != null && !optString.equals("null") && !optString.equals("")) {
            this.mImage.setImageResource(getContext().getResources().getIdentifier(optString, "drawable", getContext().getPackageName()));
        } else if (optInt == -1) {
        } else {
            final NvEventQueueActivity nvEventQueueActivity = (NvEventQueueActivity) getContext();
            nvEventQueueActivity.getGameRender().RequestRender(this.mRoot.getJson().optInt("s"), 0, optInt, 1, 0, (float) this.mRoot.getJson().optDouble("q1"), (float) this.mRoot.getJson().optDouble("q2"), (float) this.mRoot.getJson().optDouble("q3"), (float) this.mRoot.getJson().optDouble("z"), new GameRender.GameRenderListener() {
                @Override
                public void OnRenderComplete(int id, byte[] buffer, long length) {
                    final Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
                    createBitmap.setHasAlpha(true);
                    IntBuffer asIntBuffer = ByteBuffer.wrap(buffer).order(ByteOrder.BIG_ENDIAN).asIntBuffer();
                    int[] iArr = new int[asIntBuffer.remaining()];
                    asIntBuffer.get(iArr);
                    createBitmap.setPixels(iArr, 0, 512, 0, 0, 512, 512);
                    nvEventQueueActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            UILayoutHalloweenGamePrize.this.mImage.setImageBitmap(createBitmap);
                            UILayoutHalloweenGamePrize.this.mImage.animate().alpha(1.0f).setDuration(300L);
                        }
                    });
                }
            });
        }
    }
}
