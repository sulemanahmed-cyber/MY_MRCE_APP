package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class dummy_1 extends AppCompatActivity {
    Button verify;
    FirebaseAuth fAuth;
    TextView verify_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_1);

        verify = findViewById(R.id.verify);
        verify_msg = findViewById(R.id.tv1);
        fAuth = FirebaseAuth.getInstance();


        //google_email = fAuth.getCurrentUser().getUid();
        FirebaseUser user = fAuth.getCurrentUser();

        if(!user.isEmailVerified()){
            verify.setVisibility(View.VISIBLE);
            verify_msg.setVisibility(View.VISIBLE);

            verify.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirebaseUser user = fAuth.getCurrentUser();
                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(), "verification mail sent", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            });

        }

    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
