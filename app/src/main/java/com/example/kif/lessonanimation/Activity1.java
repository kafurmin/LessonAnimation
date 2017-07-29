package com.example.kif.lessonanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.transition.TransitionManager;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class Activity1 extends AppCompatActivity {
    private Button button;
    private Button button01;
    private Button button02;
    private Button button03;
    private int savedTextSize;
    private boolean positionChanged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        button = (Button) findViewById(R.id.Button1);
        button01 = (Button) findViewById(R.id.Button01);
        button02 = (Button) findViewById(R.id.Button02);
        button03 = (Button) findViewById(R.id.Button03);

        savedTextSize=18;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePosition();
            }
        });
    }
    private void changePosition() {
        TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.viewRoot));

        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) button.getLayoutParams();


        if (positionChanged) {
            button01.setVisibility(View.GONE);
            button02.setVisibility(View.GONE);

            lp.gravity = Gravity.CENTER;
            button.setWidth(button.getWidth()/((int)(1.5)));
            button.setHeight(button.getHeight()/2);
            button.setTextSize(savedTextSize);
            button.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        } else {

              button01.setVisibility(View.INVISIBLE);
            button02.setVisibility(View.INVISIBLE);

            lp.gravity = Gravity.END;
            button.setWidth(button.getWidth()*((int)(1.5)));
            button.setHeight(button.getHeight()*2);

            button.setTextSize((int)(savedTextSize*1.2));
            button.setTextColor(getResources().getColor(R.color.colorAccent));

        }
        positionChanged = !positionChanged;
        button.setLayoutParams(lp);

        Animation animRotateIn_icon = AnimationUtils.loadAnimation(this,
                R.anim.button_anim);

        button.startAnimation(animRotateIn_icon);
    }
}
