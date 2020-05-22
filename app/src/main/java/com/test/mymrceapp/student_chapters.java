package com.test.mymrceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class student_chapters extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ArrayAdapter spin_12;
    Spinner spinner_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_chapters);
      /*  new ArrayAdapter<myspin>("hello","hii");*/

        spinner_1 =(findViewById(R.id.spin_1));



        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.group1,android.R.layout.simple_spinner_item);
        spinner_1.setAdapter(adapter);


        spinner_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Toast.makeText(student_chapters.this, "english_1", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        Toast.makeText(student_chapters.this, "Hindi_1", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
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

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onBackPressed() {
        finish();
    }

}
