package com.example.kif.lessonanimation;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Activity4 extends AppCompatActivity {


    private AnimatedVectorDrawable mightyMorphinAnimatedVectorDrawable;
    private AnimatedVectorDrawable mightyMorphinAnimatedVectorDrawableReversed;
    private ImageView animatorImageView;
    private boolean isShowingAndroid = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        animatorImageView = (ImageView) findViewById(R.id.path_morph_animated_vector);
        mightyMorphinAnimatedVectorDrawable = (AnimatedVectorDrawable) getDrawable(R.drawable.consolidated_animated_vector);
        mightyMorphinAnimatedVectorDrawableReversed = (AnimatedVectorDrawable) getDrawable(R.drawable.consolidated_animated_vector_reverse);
        animatorImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                morph();
            }
        });
    }

    public void morph() {
        AnimatedVectorDrawable prevDrawable = isShowingAndroid ? mightyMorphinAnimatedVectorDrawableReversed : mightyMorphinAnimatedVectorDrawable;
        if (prevDrawable.isRunning()) {
            prevDrawable.stop();
        }

        AnimatedVectorDrawable currentDrawable = isShowingAndroid ? mightyMorphinAnimatedVectorDrawable : mightyMorphinAnimatedVectorDrawableReversed;
        animatorImageView.setImageDrawable(currentDrawable);
        currentDrawable.start();
        isShowingAndroid = !isShowingAndroid;
    }

}
