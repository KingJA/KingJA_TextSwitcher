package sample.kingja.textswitcher;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.LinkedList;

/**
 * Description:TODO
 * Create Time:2017/11/3 16:31
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class AnimatedNumber extends LinearLayout {
    private StringBuffer oldNumbers = new StringBuffer();
    private StringBuffer targetNumbers = new StringBuffer();
    private LinkedList<AnimateTextSwitcher> animateNumbers = new LinkedList<>();
    private int currentNumber;

    public AnimatedNumber(Context context) {
        this(context, null);
    }

    public AnimatedNumber(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimatedNumber(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAnimatedNumber(context, attrs);
    }

    private void initAnimatedNumber(Context context, AttributeSet attrs) {
        //init attrs
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);
    }

    public void setNumber(int currentNumber) {
        this.currentNumber = currentNumber;
        if (animateNumbers.size() == 0) {
            fillNumbers(currentNumber);
            addTextSwitchers();
        } else {
            fillTargetNumbers(currentNumber);
            refreshNumbers();
        }
    }

    private void refreshNumbers() {
        for (int i = targetNumbers.length() - 1; i >= 0; i--) {
            if (targetNumbers.charAt(i) != oldNumbers.charAt(i)) {
                animateNumbers.get(targetNumbers.length() - 1 - i).setText(String.valueOf(targetNumbers.charAt(i)));
                oldNumbers.replace(i, i, String.valueOf(targetNumbers.charAt(i)));
            }
        }
    }

    public int getCurrentNumber() {
        return currentNumber;
    }


    private void addTextSwitchers() {
        for (int i = 0; i < oldNumbers.length(); i++) {
            AnimateTextSwitcher animateTextSwitcher = new AnimateTextSwitcher(getContext());
            animateTextSwitcher.setText(String.valueOf(oldNumbers.charAt(i)));
            addView(animateTextSwitcher);
            animateNumbers.addFirst(animateTextSwitcher);
        }
    }

    private void fillTargetNumbers(int number) {
        targetNumbers.delete(0, targetNumbers.length());
        while (number > 0) {
            targetNumbers.insert(0, number % 10);
            number /= 10;
        }
    }

    private void fillNumbers(int number) {
        while (number > 0) {
            oldNumbers.insert(0, number % 10);
            number /= 10;
        }
    }


    static class AnimateTextSwitcher extends TextSwitcher implements ViewSwitcher.ViewFactory {

        public AnimateTextSwitcher(Context context) {
            this(context, null);
        }

        public AnimateTextSwitcher(Context context, AttributeSet attrs) {
            super(context, attrs);
            initAnimateTextSwitcher();

        }

        private void initAnimateTextSwitcher() {
            setFactory(this);
            Animation in = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
            Animation out = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);
            setInAnimation(in);
            setOutAnimation(out);
        }

        @Override
        public View makeView() {
            TextView textView = new TextView(getContext());
            textView.setTextColor(Color.BLACK);
            textView.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            textView.setTextSize(30);
            return textView;
        }
    }
}
