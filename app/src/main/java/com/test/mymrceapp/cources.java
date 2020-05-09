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

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class cources extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    ConstraintLayout expandableView;
    Button arrowBtn;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cources);
        setUpToolbar();

        expandableView = findViewById(R.id.expandableView);
        arrowBtn = findViewById(R.id.arrowBtn);
        cardView = findViewById(R.id.cardView);

        arrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                    arrowBtn.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        navigationView= (NavigationView)findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.nav_home:
                        Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        /*  Toast.makeText(MainActivity.this, "HOME CLICKED", Toast.LENGTH_SHORT).show();*/
                        break;
                    case R.id.nav_cources:
                        Intent intent1= new Intent(getApplicationContext(), cources.class);
                        startActivity(intent1);
                        /* Toast.makeText(MainActivity.this, "SETTINGS CLICKED", Toast.LENGTH_SHORT).show();*/
                        break ;

                    case R.id.nav_gallery:
                        Intent intent2= new Intent(getApplicationContext(), gallery.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_syllabus:
                        Intent intent3 = new Intent(getApplicationContext(),syllabus.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_bus_routes:
                        Intent intent4 = new Intent(getApplicationContext(),bus_routes.class);
                        startActivity(intent4);
                        break;
                    case R.id.nav_notice:
                        Intent intent5 = new Intent(getApplicationContext(),notice.class);
                        startActivity(intent5);
                        break;
                    case R.id.nav_faculty:
                        Intent intent6 = new Intent(getApplicationContext(),faculty.class);
                        startActivity(intent6);
                        break;
                    case R.id.nav_events:
                        Intent intent7 = new Intent(getApplicationContext(),events.class);
                        startActivity(intent7);
                        break;
                    case R.id.nav_studentc:
                        Intent intent8 = new Intent(getApplicationContext(),student_chapters.class);
                        startActivity(intent8);
                        break;
                    case R.id.nav_cells:
                        Intent intent9 = new Intent(getApplicationContext(),cells.class);
                        startActivity(intent9);
                        break;
                    case R.id.nav_notification:
                        Intent intent10 = new Intent(getApplicationContext(),notification.class);
                        startActivity(intent10);
                        break;
                    case R.id.nav_canteen:
                        Intent intent11 = new Intent(getApplicationContext(),canteen.class);
                        startActivity(intent11);
                        break;
                    case R.id.nav_contact:
                        Intent intent12 = new Intent(getApplicationContext(),contact.class);
                        startActivity(intent12);
                        break;

                    case R.id.nav_dum_1:
                        Intent intent13 = new Intent(getApplicationContext(),dummy_1.class);
                        startActivity(intent13);
                        break;


                }

                return false;
            }
        });


    }

    private void setUpToolbar()
    {
        drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    @Override
    public void onBackPressed() {
        finish();
    }


}
