package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import static com.test.mymrceapp.Splash.catList;

public class Online_Test extends AppCompatActivity {
    private GridView catgrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online__test);
        Toolbar toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setTitle("Categories");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        catgrid = findViewById(R.id.gridview);



       /* List<String> catList = new ArrayList<>();
        catList.add("cat1");
        catList.add("cat2");
        catList.add("cat3");
        catList.add("cat4");
        catList.add("cat5");
        catList.add("cat6");*/
        CategoryGridAdapter adapter = new CategoryGridAdapter(catList);
        catgrid.setAdapter(adapter);

    }


}
