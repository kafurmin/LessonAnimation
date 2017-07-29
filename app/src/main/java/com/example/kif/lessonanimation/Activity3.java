package com.example.kif.lessonanimation;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Fragment fragment3;
        FragmentTransaction transaction;

        fragment3 = new Fragment_3_1();

        transaction = getFragmentManager().beginTransaction();

        transaction.replace(R.id.base_fragment3, fragment3);


        transaction.commit();
    }
}
