package com.example.mydrawtexttest;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    private MyDrawTextView2 myDrawTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        myDrawTextView2 = findViewById(R.id.my_draw_text_view2_id);

        findViewById(R.id.change_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnimation();
            }
        });
    }

    public void setAnimation() {
        ValueAnimator valueAnimator = ObjectAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float animatedValue = (Float) animation.getAnimatedValue();
                myDrawTextView2.setProgress(animatedValue);
            }
        });
        valueAnimator.start();
    }
}