package sample.kingja.textswitcher;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Description:TODO
 * Create Time:2017/11/3 16:31
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class AnimatedNumber extends LinearLayout {
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
    }

    public void setNumber(Object number) {

    }
}
