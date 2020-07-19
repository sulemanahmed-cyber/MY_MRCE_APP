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
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;

import com.google.android.material.navigation.NavigationView;

public class cources extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    LinearLayout expandableView_Hs, expandableView_Cse, expandableView_Ece, expandableView_It, expandableView_Mec, expandableView_Ite;
    Button arrowBtn_Hs, arrowBtn_Cse, arrowBtn_Ece, arrowBtn_It, arrowBtn_Mec, arrowBtn_Ite;
    CardView cardView_Hs, cardView_Cse, cardview_Ece, cardview_It, cardview_Mec, cardview_Ite;

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


      /*  navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        *//*  Toast.makeText(MainActivity.this, "HOME CLICKED", Toast.LENGTH_SHORT).show();*//*
                        break;
                    case R.id.nav_cources:
                        Intent intent1 = new Intent(getApplicationContext(), cources.class);
                        startActivity(intent1);
                        *//* Toast.makeText(MainActivity.this, "SETTINGS CLICKED", Toast.LENGTH_SHORT).show();*//*
                        break;

                    case R.id.nav_gallery:
                        Intent intent2 = new Intent(getApplicationContext(), gallery.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_syllabus:
                        Intent intent3 = new Intent(getApplicationContext(), syllabus.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_bus_routes:
                        Intent intent4 = new Intent(getApplicationContext(), bus_routes.class);
                        startActivity(intent4);
                        break;
                    case R.id.nav_notice:
                        Intent intent5 = new Intent(getApplicationContext(), notice.class);
                        startActivity(intent5);
                        break;
                    case R.id.nav_faculty:
                        Intent intent6 = new Intent(getApplicationContext(), faculty.class);
                        startActivity(intent6);
                        break;
                    case R.id.nav_events:
                        Intent intent7 = new Intent(getApplicationContext(), events.class);
                        startActivity(intent7);
                        break;
                    case R.id.nav_studentc:
                        Intent intent8 = new Intent(getApplicationContext(), student_chapters.class);
                        startActivity(intent8);
                        break;
                    case R.id.nav_cells:
                        Intent intent9 = new Intent(getApplicationContext(), cells.class);
                        startActivity(intent9);
                        break;
                    case R.id.nav_notification:
                        Intent intent10 = new Intent(getApplicationContext(), notification.class);
                        startActivity(intent10);
                        break;
                    case R.id.nav_canteen:
                        Intent intent11 = new Intent(getApplicationContext(), canteen.class);
                        startActivity(intent11);
                        break;
                    case R.id.nav_contact:
                        Intent intent12 = new Intent(getApplicationContext(), contact.class);
                        startActivity(intent12);
                        break;

                    case R.id.nav_dum_1:
                        Intent intent13 = new Intent(getApplicationContext(), dummy_1.class);
                        startActivity(intent13);
                        break;


                }

                return false;
            }
        });
*/

    }

 /*  private void setUpToolbar() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       toolbar.setTitle("Cources");


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);


        drawerLayout.addDrawerListener(actionBarDrawerToggle);


        actionBarDrawerToggle.syncState();



    }

    @Override
    public void onBackPressed() {
        finish();
    }*/


}
