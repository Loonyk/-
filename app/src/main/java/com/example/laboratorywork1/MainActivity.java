package com.example.laboratorywork1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Sleep sleep = new Sleep(this);
        sleep.start();
    }

    public void openNewActivity(){
        Intent intent = new Intent(".Main2Activity");
        startActivity(intent);
        finish();
    }
}
