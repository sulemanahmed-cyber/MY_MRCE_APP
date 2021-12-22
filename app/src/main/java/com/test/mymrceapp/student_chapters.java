package com.test.mymrceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

public class student_chapters extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    LinearLayout par_csi, expndbl_csi,grp_csi;
    Button arrowBtn_Csi;
    ImageView csi;
    public static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_chapters);
        drawerLayout=findViewById(R.id.drawer_layout);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Student Chapters");

        csi=findViewById(R.id.im5);
        //Glide.with(student_chapters.context).load("https://www.acpce.org/en/wp-content/uploads/2017/06/csi-logo.png").into(csi);






    }
    @Override
    public void onBackPressed() {
        finish();
    }

}
