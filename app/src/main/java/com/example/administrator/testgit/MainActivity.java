package com.example.administrator.testgit;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView bull;
    private ObjectAnimator animator;
    private android.widget.Button btn;
    private RelativeLayout activitymain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.activitymain = (RelativeLayout) findViewById(R.id.activity_main);
        this.btn = (Button) findViewById(R.id.btn);
        init();
    }
public  int dp2px(int dp){
    return (int) (getResources().getDisplayMetrics().density*dp);
}
    private void init() {
        bull = new ImageView(this);
        bull.setBackgroundResource(R.drawable.bg_ball);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(dp2px(100),dp2px(100));
        params.addRule(RelativeLayout.ALIGN_LEFT,R.id.btn);
        params.addRule(RelativeLayout.ALIGN_RIGHT,R.id.btn);
        params.addRule(RelativeLayout.BELOW,R.id.btn);
        bull.setLayoutParams(params);
        activitymain.addView(bull);
    }

    public void click(View view){
        startAnimation();
    }

    private void startAnimation() {

        PropertyValuesHolder holder =PropertyValuesHolder.ofFloat("translationY",0,dp2px(180));
        PropertyValuesHolder holder1 =PropertyValuesHolder.ofFloat("translationX",0,dp2px(180));
        animator = ObjectAnimator.ofPropertyValuesHolder(bull,holder,holder1);
        animator.setDuration(800);
        animator.setRepeatCount(2);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }
}
