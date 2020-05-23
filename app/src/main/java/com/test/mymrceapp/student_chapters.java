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



    /*    spinner_1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(student_chapters.this, "Test_1", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }

        );*/


        navigationView=findViewById(R.id.navigation_menu);
        toolbar=findViewById(R.id.toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);
        expndbl_csi=findViewById(R.id.expndbl_csi);
        arrowBtn_Csi=findViewById(R.id.arrowBtn_csi);
        par_csi=findViewById(R.id.par_csi);
        grp_csi=findViewById(R.id.grp_csi);
        grp_csi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expndbl_csi.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(par_csi, new AutoTransition());
                    expndbl_csi.setVisibility(View.VISIBLE);
                    arrowBtn_Csi.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    TransitionManager.beginDelayedTransition(par_csi, new AutoTransition());
                    expndbl_csi.setVisibility(View.GONE);
                    arrowBtn_Csi.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onBackPressed() {
        finish();
    }

}
