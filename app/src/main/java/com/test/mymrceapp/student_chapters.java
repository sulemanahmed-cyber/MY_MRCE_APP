package com.test.mymrceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class student_chapters extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    LinearLayout par_csi, expndbl_csi,grp_csi;
    Button arrowBtn_Csi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_chapters);







    }
    @Override
    public void onBackPressed() {
        finish();
    }

}
