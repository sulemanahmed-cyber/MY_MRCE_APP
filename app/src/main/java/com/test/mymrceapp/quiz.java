package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class quiz extends AppCompatActivity {

    Button quiz_btn;
    public static List<String> catList = new ArrayList<>();
    public AlertDialog alertDialog1;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        quiz_btn = findViewById(R.id.start_quiz);
        firestore = FirebaseFirestore.getInstance();
        /*alertDialog1 = new AlertDialog.Builder(
                quiz.this).create();

        // Setting Dialog Title
        alertDialog1.setTitle("Not Connected to INTERNET");

        // Setting Dialog Message
        alertDialog1.setMessage("Please Connect To Internet");

        // Setting Icon to Dialog
        alertDialog1.setIcon(R.drawable.mrce);

        // Setting OK Button

        alertDialog1.setCancelable(false);
        // Showing Alert Message
*/
        quiz_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Online_Test.class));
            }
        });

    }

   /* private void loadData() {
        alertDialog1.show();
        catList.clear();
        firestore.collection("Online_Test").document("Categories")
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    if (doc.exists()) {
                        long count = (long) doc.get("COUNT");
                        for (int i = 1; i <= count; i++) {
                            *//*String catName = doc.getString("CAT" + String.valueOf(i) + "_NAME");
                            String catID = doc.getString("CAT" + String.valueOf(i) + "_ID");

                            catList.add(new CategoryModel(catID,catName));*//*

                            String catName = doc.getString("CAT" + String.valueOf(i));

                            catList.add(catName);
                        }
                        startActivity(new Intent(getApplicationContext(), IntroActivity.class));
                        finish();
                    } else {
                        Toast.makeText(quiz.this, "No Category Document Exists", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } else {
                    Toast.makeText(quiz.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        alertDialog1.dismiss();

    }*/
}
