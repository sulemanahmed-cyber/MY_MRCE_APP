package com.test.mymrceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class notice extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    EditText password;
    Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        password = (EditText) findViewById(R.id.password);
        enter = (Button) findViewById(R.id.enter);
        navigationView = findViewById(R.id.navigation_menu);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString().equals("8899")) {
                    Intent intent = new Intent(notice.this, college_admin.class);
                    startActivity(intent);
                }

                if (password.getText().toString().equals("9966")) {
                    Toast.makeText(notice.this, "PASSWORD WORKING", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(notice.this, "WRONG PASSWORD", Toast.LENGTH_SHORT).show();

                }

            }
        });


    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
