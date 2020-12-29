package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class events extends AppCompatActivity implements ValueEventListener {
    Toolbar toolbar;
    TextView tv1, tv2, tv3;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference db_heading = databaseReference.child("notice/heading");
    private DatabaseReference db_detail = databaseReference.child("notice/detail");
    private DatabaseReference db_reference = databaseReference.child("notice/reference");
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        drawerLayout = findViewById(R.id.drawer_events);
        toolbar = findViewById(R.id.toolbar_events);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Events");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar = findViewById(R.id.toolbar_events);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);

    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot){
   if (dataSnapshot.getValue(String.class)!=null) {
       String key = dataSnapshot.getKey();
       if (key.equals("heading")) {
           String heading = (String) dataSnapshot.getValue(String.class);
           tv1.setText(heading);
       }
       if (key.equals("detail")) {
           String detail = (String) dataSnapshot.getValue(String.class);
           tv2.setText(detail);
       }
       if (key.equals("reference")) {
           String reference = (String) dataSnapshot.getValue(String.class);
           tv3.setText(reference);
       }
   }


    }
    @Override
    public void onCancelled (DatabaseError databaseError){


    }

    @Override
    protected void onStart() {
        super.onStart();
        db_heading.addValueEventListener(this);
        db_detail.addValueEventListener(this);
        db_reference.addValueEventListener(this);
    }
}