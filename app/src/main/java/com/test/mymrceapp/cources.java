package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

public class cources extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    LinearLayout expandableView_Hs, expandableView_Cse, expandableView_Ece, expandableView_It, expandableView_Mec, expandableView_Ite;
    Button arrowBtn_Hs, arrowBtn_Cse, arrowBtn_Ece, arrowBtn_It, arrowBtn_Mec, arrowBtn_Ite;
    CardView cardView_Hs, cardView_Cse, cardview_Ece, cardview_It, cardview_Mec, cardview_Ite;
    public static Context context;
    ImageView im_hs, im_it, im_cse, im_ece, im_mec, im_ite, c_im_hs, c_im_it, c_im_cse, c_im_ece, c_im_mec, c_im_ite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cources);


        navigationView = findViewById(R.id.navigation_menu);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Courses");

        im_hs = (ImageView) findViewById(R.id.imageView_Hs);
        im_cse = (ImageView) findViewById(R.id.imageView_Cse);
        im_it = (ImageView) findViewById(R.id.imageView_It);
        im_mec = (ImageView) findViewById(R.id.imageView_Mec);
        im_ece = (ImageView) findViewById(R.id.imageView_Ece);
        im_ite = (ImageView) findViewById(R.id.imageView_Ite);

        c_im_hs = (ImageView) findViewById(R.id.circleImage_Hs);
        c_im_cse = (ImageView) findViewById(R.id.circleImage_Cse);
        c_im_it = (ImageView) findViewById(R.id.circleImage_It);
        c_im_mec = (ImageView) findViewById(R.id.circleImage_Mec);
        c_im_ece = (ImageView) findViewById(R.id.circleImage_Ece);
        c_im_ite = (ImageView) findViewById(R.id.circleImage_Ite);


        expandableView_Hs = findViewById(R.id.expandableView_Hs);
        expandableView_Cse = findViewById(R.id.expandableView_Cse);
        expandableView_Ece = findViewById(R.id.expandableView_Ece);
        expandableView_It = findViewById(R.id.expandableView_It);
        expandableView_Mec = findViewById(R.id.expandableView_Mec);
        expandableView_Ite = findViewById(R.id.expandableView_Ite);


        arrowBtn_Hs = findViewById(R.id.arrowBtn_Hs);
        arrowBtn_Cse = findViewById(R.id.arrowBtn_Cse);
        arrowBtn_Ece = findViewById(R.id.arrowBtn_Ece);
        arrowBtn_It = findViewById(R.id.arrowBtn_It);
        arrowBtn_Mec = findViewById(R.id.arrowBtn_Mec);
        arrowBtn_Ite = findViewById(R.id.arrowBtn_Ite);


        cardView_Hs = findViewById(R.id.cardView_Hs);
        cardView_Cse = findViewById(R.id.cardView_Cse);
        cardview_Ece = findViewById(R.id.cardView_Ece);
        cardview_It = findViewById(R.id.cardView_It);
        cardview_Mec = findViewById(R.id.cardView_Mec);
        cardview_Ite = findViewById(R.id.cardView_Ite);

        context = getApplicationContext();

        ///GLIDES_im
        Glide.with(cources.context).load("https://www.careerguide.com/blog/wp-content/uploads/2018/01/Social_Sciences_and_Humanities_wordle.png").into(im_hs);
        Glide.with(cources.context).load("https://i.ytimg.com/vi/SzJ46YA_RaA/maxresdefault.jpg").into(im_cse);
        Glide.with(cources.context).load("https://assets.skyfilabs.com/images/blog/eceminiproject.jpg").into(im_ece);
        Glide.with(cources.context).load("https://c8.alamy.com/comp/HRP8HD/word-cloud-with-terms-about-information-technology-flat-style-HRP8HD.jpg").into(im_it);
        Glide.with(cources.context).load("https://excellentacademyofengineering.com/images/project/it-engg.jpg").into(im_ite);
        Glide.with(cources.context).load("https://indoreinstitute.com/wp-content/uploads/2019/12/me.jpg").into(im_mec);

        ///GLIDES_C_IM
        Glide.with(cources.context).load("https://www.careerguide.com/blog/wp-content/uploads/2018/01/Social_Sciences_and_Humanities_wordle.png").into(c_im_hs);
        Glide.with(cources.context).load("https://i.ytimg.com/vi/SzJ46YA_RaA/maxresdefault.jpg").into(c_im_cse);
        Glide.with(cources.context).load("https://assets.skyfilabs.com/images/blog/eceminiproject.jpg").into(c_im_ece);
        Glide.with(cources.context).load("https://c8.alamy.com/comp/HRP8HD/word-cloud-with-terms-about-information-technology-flat-style-HRP8HD.jpg").into(c_im_it);
        Glide.with(cources.context).load("https://excellentacademyofengineering.com/images/project/it-engg.jpg").into(c_im_ite);
        Glide.with(cources.context).load("https://indoreinstitute.com/wp-content/uploads/2019/12/me.jpg").into(c_im_mec);


        //Hs onclickkkkk
        arrowBtn_Hs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView_Hs.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardView_Hs, new AutoTransition());
                    expandableView_Hs.setVisibility(View.VISIBLE);
                    arrowBtn_Hs.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView_Hs, new AutoTransition());
                    expandableView_Hs.setVisibility(View.GONE);
                    arrowBtn_Hs.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });


        //CsE onclickkkkk


        arrowBtn_Cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView_Cse.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardView_Cse, new AutoTransition());
                    expandableView_Cse.setVisibility(View.VISIBLE);
                    arrowBtn_Cse.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView_Cse, new AutoTransition());
                    expandableView_Cse.setVisibility(View.GONE);
                    arrowBtn_Cse.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        //EcE on clickkkk
        arrowBtn_Ece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView_Ece.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardview_Ece, new AutoTransition());
                    expandableView_Ece.setVisibility(View.VISIBLE);
                    arrowBtn_Ece.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardview_Ece, new AutoTransition());
                    expandableView_Ece.setVisibility(View.GONE);
                    arrowBtn_Ece.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }

            }
        });
        //It on clickkkk
        arrowBtn_It.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView_It.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardview_It, new AutoTransition());
                    expandableView_It.setVisibility(View.VISIBLE);
                    arrowBtn_It.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardview_It, new AutoTransition());
                    expandableView_It.setVisibility(View.GONE);
                    arrowBtn_It.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        //mec on clickkkkk
        arrowBtn_Mec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView_Mec.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardview_Mec, new AutoTransition());
                    expandableView_Mec.setVisibility(View.VISIBLE);
                    arrowBtn_Mec.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardview_Mec, new AutoTransition());
                    expandableView_Mec.setVisibility(View.GONE);
                    arrowBtn_Mec.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }

            }
        });

        //ite on clickkkkk
        arrowBtn_Ite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView_Ite.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(cardview_Ite, new AutoTransition());
                    expandableView_Ite.setVisibility(View.VISIBLE);
                    arrowBtn_Ite.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardview_Ite, new AutoTransition());
                    expandableView_Ite.setVisibility(View.GONE);
                    arrowBtn_Ite.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }

            }
        });


    }




}
