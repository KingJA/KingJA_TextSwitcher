package sample.kingja.textswitcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Description:TODO
 * Create Time:2017/11/6 14:52
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class SampleActivity extends AppCompatActivity {

    private AnimatedNumber animateNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animateview);
        animateNumber = findViewById(R.id.animateNumber);
        animateNumber.setNumber(99);
    }

    public void onAdd(View view) {
        int currentNumber = animateNumber.getCurrentNumber();
        animateNumber.setNumber(++currentNumber);
    }

    public void onReduce(View view) {
        int currentNumber = animateNumber.getCurrentNumber();
        animateNumber.setNumber(--currentNumber);
    }
}
