package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class Splash extends AppCompatActivity {
    public static List<String> catList = new ArrayList<>();
    private FirebaseFirestore firestore;
   // public static int selected_cat_index = 0;

    private static  int SPLASH_SCREEN = 5000;
    Animation topanimaton,bottomanimation;
     ImageView image;
     TextView logo,slogan;
       SharedPreferences onBoardingScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        firestore = FirebaseFirestore.getInstance();


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        topanimaton = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        image = findViewById(R.id.mimage);
        logo = findViewById(R.id.full);
        slogan = findViewById(R.id.half);
        image.setAnimation(topanimaton);
        logo.setAnimation(bottomanimation);
        slogan.setAnimation(bottomanimation);
       new Handler().postDelayed(new Runnable() {


           @Override
           public void run() {
               loadData();


           }
       },SPLASH_SCREEN);

    }

   private void loadData() {
        catList.clear();
        firestore.collection("Online_Test").document("Categories")
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful())
                {
                    DocumentSnapshot doc= task.getResult();
                    if (doc.exists()){
                        long count = (long)doc.get("COUNT");
                        for(int i=1 ; i<= count ; i++){
                            /*String catName = doc.getString("CAT" + String.valueOf(i) + "_NAME");
                            String catID = doc.getString("CAT" + String.valueOf(i) + "_ID");

                            catList.add(new CategoryModel(catID,catName));*/

                           String catName = doc.getString("CAT" + String.valueOf(i) );

                           catList.add(catName);
                        }
                        startActivity(new Intent(getApplicationContext(),IntroActivity.class));
                        finish();
                    } else {
                        Toast.makeText(Splash.this, "No Category Document Exists", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }else
                {
                    Toast.makeText(Splash.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
