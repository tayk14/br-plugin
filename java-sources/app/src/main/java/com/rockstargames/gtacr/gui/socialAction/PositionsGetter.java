package com.rockstargames.gtacr.gui.socialAction;

import android.widget.TextView;
import blackrussia.online.databinding.SocialInteractionBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b6\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010B\u001a\u00020CR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001a\u0010\u0012\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001c\u0010\nR\u0011\u0010\u001d\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000eR\u001a\u0010\u001f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\nR\u001a\u0010\"\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\b\"\u0004\b$\u0010\nR\u0011\u0010%\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000eR\u001a\u0010'\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\b\"\u0004\b)\u0010\nR\u001a\u0010*\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\nR\u0011\u0010-\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u000eR\u001a\u0010/\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\b\"\u0004\b1\u0010\nR\u001a\u00102\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\nR\u0011\u00105\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u000eR\u001a\u00107\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\b\"\u0004\b9\u0010\nR\u001a\u0010:\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\b\"\u0004\b<\u0010\nR\u0011\u0010=\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u000eR\u001a\u0010?\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\b\"\u0004\bA\u0010\n¨\u0006D"}, d2 = {"Lcom/rockstargames/gtacr/gui/socialAction/PositionsGetter;", "", "binding", "Lblackrussia/online/databinding/SocialInteractionBinding;", "(Lblackrussia/online/databinding/SocialInteractionBinding;)V", "button1Height", "", "getButton1Height", "()I", "setButton1Height", "(I)V", "button1Location", "", "getButton1Location", "()[I", "button1Width", "getButton1Width", "setButton1Width", "button2Height", "getButton2Height", "setButton2Height", "button2Location", "getButton2Location", "button2Width", "getButton2Width", "setButton2Width", "button3Height", "getButton3Height", "setButton3Height", "button3Location", "getButton3Location", "button3Width", "getButton3Width", "setButton3Width", "button4Height", "getButton4Height", "setButton4Height", "button4Location", "getButton4Location", "button4Width", "getButton4Width", "setButton4Width", "button5Height", "getButton5Height", "setButton5Height", "button5Location", "getButton5Location", "button5Width", "getButton5Width", "setButton5Width", "button6Height", "getButton6Height", "setButton6Height", "button6Location", "getButton6Location", "button6Width", "getButton6Width", "setButton6Width", "button7Height", "getButton7Height", "setButton7Height", "button7Location", "getButton7Location", "button7Width", "getButton7Width", "setButton7Width", "getPositions", "", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PositionsGetter {
    private final SocialInteractionBinding binding;
    private int button1Height;
    private final int[] button1Location;
    private int button1Width;
    private int button2Height;
    private final int[] button2Location;
    private int button2Width;
    private int button3Height;
    private final int[] button3Location;
    private int button3Width;
    private int button4Height;
    private final int[] button4Location;
    private int button4Width;
    private int button5Height;
    private final int[] button5Location;
    private int button5Width;
    private int button6Height;
    private final int[] button6Location;
    private int button6Width;
    private int button7Height;
    private final int[] button7Location;
    private int button7Width;

    public PositionsGetter(SocialInteractionBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.button1Location = new int[]{0, 0};
        this.button2Location = new int[]{0, 0};
        this.button3Location = new int[]{0, 0};
        this.button4Location = new int[]{0, 0};
        this.button5Location = new int[]{0, 0};
        this.button6Location = new int[]{0, 0};
        this.button7Location = new int[]{0, 0};
    }

    public final int[] getButton1Location() {
        return this.button1Location;
    }

    public final int getButton1Height() {
        return this.button1Height;
    }

    public final void setButton1Height(int i) {
        this.button1Height = i;
    }

    public final int getButton1Width() {
        return this.button1Width;
    }

    public final void setButton1Width(int i) {
        this.button1Width = i;
    }

    public final int[] getButton2Location() {
        return this.button2Location;
    }

    public final int getButton2Height() {
        return this.button2Height;
    }

    public final void setButton2Height(int i) {
        this.button2Height = i;
    }

    public final int getButton2Width() {
        return this.button2Width;
    }

    public final void setButton2Width(int i) {
        this.button2Width = i;
    }

    public final int[] getButton3Location() {
        return this.button3Location;
    }

    public final int getButton3Height() {
        return this.button3Height;
    }

    public final void setButton3Height(int i) {
        this.button3Height = i;
    }

    public final int getButton3Width() {
        return this.button3Width;
    }

    public final void setButton3Width(int i) {
        this.button3Width = i;
    }

    public final int[] getButton4Location() {
        return this.button4Location;
    }

    public final int getButton4Height() {
        return this.button4Height;
    }

    public final void setButton4Height(int i) {
        this.button4Height = i;
    }

    public final int getButton4Width() {
        return this.button4Width;
    }

    public final void setButton4Width(int i) {
        this.button4Width = i;
    }

    public final int[] getButton5Location() {
        return this.button5Location;
    }

    public final int getButton5Height() {
        return this.button5Height;
    }

    public final void setButton5Height(int i) {
        this.button5Height = i;
    }

    public final int getButton5Width() {
        return this.button5Width;
    }

    public final void setButton5Width(int i) {
        this.button5Width = i;
    }

    public final int[] getButton6Location() {
        return this.button6Location;
    }

    public final int getButton6Height() {
        return this.button6Height;
    }

    public final void setButton6Height(int i) {
        this.button6Height = i;
    }

    public final int getButton6Width() {
        return this.button6Width;
    }

    public final void setButton6Width(int i) {
        this.button6Width = i;
    }

    public final int[] getButton7Location() {
        return this.button7Location;
    }

    public final int getButton7Height() {
        return this.button7Height;
    }

    public final void setButton7Height(int i) {
        this.button7Height = i;
    }

    public final int getButton7Width() {
        return this.button7Width;
    }

    public final void setButton7Width(int i) {
        this.button7Width = i;
    }

    public final void getPositions() {
        TextView textView = this.binding.button1;
        textView.getLocationInWindow(getButton1Location());
        setButton1Height(textView.getHeight());
        setButton1Width(textView.getWidth());
        TextView textView2 = this.binding.button2;
        textView2.getLocationInWindow(getButton2Location());
        setButton2Height(textView2.getHeight());
        setButton2Width(textView2.getWidth());
        TextView textView3 = this.binding.button3;
        textView3.getLocationInWindow(getButton3Location());
        setButton3Height(textView3.getHeight());
        setButton3Width(textView3.getWidth());
        TextView textView4 = this.binding.button4;
        textView4.getLocationInWindow(getButton4Location());
        setButton4Height(textView4.getHeight());
        setButton4Width(textView4.getWidth());
        TextView textView5 = this.binding.button5;
        textView5.getLocationInWindow(getButton5Location());
        setButton5Height(textView5.getHeight());
        setButton5Width(textView5.getWidth());
        TextView textView6 = this.binding.button6;
        textView6.getLocationInWindow(getButton6Location());
        setButton6Height(textView6.getHeight());
        setButton6Width(textView6.getWidth());
        TextView textView7 = this.binding.button7;
        textView7.getLocationInWindow(getButton7Location());
        setButton7Height(textView7.getHeight());
        setButton7Width(textView7.getWidth());
    }
}
