package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    AlertDialog alertDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //toolbar and navigation code <navstarts>
        setUpToolbar();
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

                  case R.id.nav_syllabus:
                      Intent intent3 = new Intent(getApplicationContext(),syllabus.class);
                      startActivity(intent3);
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

           //<navends/>
    }

    //toolbar code
    private void setUpToolbar()
    {
    drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
    toolbar=(Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
   /* getActionBar().setDisplayHomeAsUpEnabled(true);
    getActionBar().setDisplayShowTitleEnabled(false);*/
    actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
    drawerLayout.addDrawerListener(actionBarDrawerToggle);
    actionBarDrawerToggle.syncState();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel =
                    new NotificationChannel("MyNotifications", "MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }



    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Please confirm");
        builder.setMessage("Do you want to exit the app?");
        builder.setCancelable(true);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do something when user want to exit the app
                // Let allow the system to handle the event, such as exit the app
                /*MainActivity.super.onBackPressed();*/
                finishAffinity();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do something when want to stay in the app
                Toast.makeText(MainActivity.this,"thank you", Toast.LENGTH_LONG).show();
            }
        });

        // Create the alert dialog using alert dialog builder
        AlertDialog dialog = builder.create();

        // Finally, display the dialog when user press back button
        dialog.show();
    }



}
