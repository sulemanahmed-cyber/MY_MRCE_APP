package com.test.mymrceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class dummy_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_1);
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
