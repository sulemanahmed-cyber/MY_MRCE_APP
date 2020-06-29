package com.test.mymrceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class cells extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    MaterialBetterSpinner materialBetterSpinner;
    Spinner spinner;
    String[] SPINNER_DATA = {"-SELECT_COURCE-", "CSE", "ECE", "IT", "MECHANICAL"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cells);
        navigationView=findViewById(R.id.navigation_menu);
        toolbar=findViewById(R.id.toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(cells.this, android.R.layout.simple_dropdown_item_1line, SPINNER_DATA);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(cells.this, "SELECT COURCE", Toast.LENGTH_SHORT).show();
                        break;


                    case 1:
                        Intent intent = new Intent(cells.this, Main2Activity.class);
                        startActivity(intent);

                        Toast.makeText(cells.this, "CSE", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:


                        Intent intent1 = new Intent(cells.this, cse_asnmnt.class);
                        startActivity(intent1);

                        Toast.makeText(cells.this, "ECE", Toast.LENGTH_SHORT).show();
                        break;

                    case 3:
                        Toast.makeText(cells.this, "IT", Toast.LENGTH_SHORT).show();
                        break;

                    case 4:
                        Toast.makeText(cells.this, "MECH", Toast.LENGTH_SHORT).show();
                        break;


                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
