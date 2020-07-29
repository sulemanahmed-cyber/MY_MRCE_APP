package com.test.mymrceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class placements extends AppCompatActivity {
    public static Context context;
    ImageView img_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placements);
        context = getApplicationContext();
        img_1 = (ImageView) findViewById(R.id.img_1);


        Glide.with(placements.context).load("https://drive.google.com/drive/u/1/folders/1eieiAf9F1T2TkiOzFKB2bYobDNE3-pN9").into(img_1);


    }


}