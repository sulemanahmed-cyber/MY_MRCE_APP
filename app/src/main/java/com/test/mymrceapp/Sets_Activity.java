package com.test.mymrceapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class Sets_Activity extends AppCompatActivity {
    private GridView setgrid;


    private FirebaseFirestore firestore;
    public static int category_id;
    private Dialog loadingDialog;
    public static List<String> catList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets_);


        Toolbar toolbar = findViewById(R.id.set_tooolbar);
        setSupportActionBar(toolbar);

        String title = getIntent().getStringExtra("CATEGORY");
         category_id = getIntent().getIntExtra("CATEGORY_ID",1);
        getSupportActionBar().setTitle(title);

        setgrid = findViewById(R.id.sets_grig);
        loadingDialog = new Dialog(Sets_Activity.this);
        loadingDialog . setContentView(R.layout.loading_progressbar);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.progress_background);
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        loadingDialog.show();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        firestore = FirebaseFirestore.getInstance();

        //issue in loadsets method
        loadSets();

 /*Sets_Adapter adapter = new Sets_Adapter(6);
        setgrid.setAdapter(adapter);*/

// i thing issue is with category id
    }

    public void loadSets() {
        catList.clear();
        firestore.collection("Online_Test").document("CAT" + String.valueOf(category_id))
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    //the code in if statement is not executing
                    if (doc.exists()) {
                        long sets = (long) doc.get("SETS");

                        Sets_Adapter adapter = new Sets_Adapter((int) sets);
                        setgrid.setAdapter(adapter);
                        loadingDialog.cancel();


                    } else {
                        Toast.makeText(Sets_Activity.this, "No CAT Document Exists", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(Sets_Activity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
                loadingDialog.cancel();
            }
        });
    }
}

