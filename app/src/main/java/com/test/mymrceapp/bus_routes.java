package com.test.mymrceapp;

import androidx.appcompat.app.AppCompatActivity;

import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;


import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

public class bus_routes extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    public static Context context;
    ImageView bus_mrgi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_routes);
        navigationView = findViewById(R.id.navigation_menu);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        bus_mrgi = (ImageView) findViewById(R.id.bus_mrgi);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Bus Routes");
        context = getApplicationContext();

        Glide.with(bus_routes.context).load("http://www.mrce.in/img/transport_2.jpg").into(bus_mrgi);

    }


   /* @Override
    public void onBackPressed() {
        finish();
    }*/
}
