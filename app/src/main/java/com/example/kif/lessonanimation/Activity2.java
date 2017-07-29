package com.example.kif.lessonanimation;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    private Fragment fragment1;

    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        fragment1 = new Fragment_2_1();

        transaction = getFragmentManager().beginTransaction();

        // transaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_in_right);

        transaction.replace(R.id.base_fragment, fragment1);


        transaction.commit();
    }
}
