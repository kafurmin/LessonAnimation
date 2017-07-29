package com.example.kif.lessonanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        switch (view.getId()){
            case(R.id.button):
                startActivity(new Intent(this, Activity1.class));
                    break;
            case(R.id.button2):
                startActivity(new Intent(this, Activity2.class));
                break;
            case(R.id.button3):
                startActivity(new Intent(this, Activity3.class));
                break;
            case(R.id.button4):
                startActivity(new Intent(this, Activity4.class));
                break;

        }
    }
}
