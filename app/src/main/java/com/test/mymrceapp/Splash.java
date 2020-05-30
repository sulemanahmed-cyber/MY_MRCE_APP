package com.test.mymrceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    private static  int SPLASH_SCREEN = 5000;
    Animation topanimaton,bottomanimation;
     ImageView image;
     TextView logo,slogan;
       SharedPreferences onBoardingScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        topanimaton = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        image = findViewById(R.id.mimage);
        logo = findViewById(R.id.full);
        slogan = findViewById(R.id.half);
        image.setAnimation(topanimaton);
        logo.setAnimation(bottomanimation);
        slogan.setAnimation(bottomanimation);
       new Handler().postDelayed(new Runnable() {

           @Override
           public void run() {
               startActivity(new Intent(getApplicationContext(),IntroActivity.class));
               finish();
           }
       },SPLASH_SCREEN);

    }
}
