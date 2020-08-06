package com.test.mymrceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class canteen extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    AutoCompleteTextView textView;
    SearchView searchView;
    public static Context context;

    ListView listView;
    ImageView coca;
    ArrayList<String> list1 = new ArrayList<String>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen);
        navigationView = findViewById(R.id.navigation_menu);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        listView = findViewById(R.id.list);
        coca = findViewById(R.id.coca);
        context = getApplicationContext();
        Glide.with(canteen.context).load("https://www.coca-cola.com.co/content/dam/brands/lc/coca-cola/images/updates/68042/banners%20en%20ingles_2000x1334px.jpg").into(coca);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        searchView = findViewById(R.id.search);

        list1.add("veg rice ");
        list1.add("veg biryani");
        list1.add("veg manchurya");
        list1.add("idli");
        list1.add("puri");
        list1.add("chicken rice");
        list1.add("chicken manchurya");
        list1.add("chapati");
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list1);
        listView.setAdapter(arrayAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });


    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
