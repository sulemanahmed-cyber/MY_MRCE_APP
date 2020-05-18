
package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Activity_Register extends AppCompatActivity {
    EditText mEmail,mPassword,mrollnumber;
    Button mRegister;
    FirebaseAuth fAuth;
    TextView mlogin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__register);
        mEmail = findViewById(R.id.editText4);
        mPassword= findViewById(R.id.editText3);
        mRegister = findViewById(R.id.button3);
        fAuth = FirebaseAuth.getInstance();
        mlogin = findViewById(R.id.login_here);
        mrollnumber = findViewById(R.id.roll_number);
        /*progressBar = findViewById(R.id.progressBar);*/
        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),my_loginn.class));
            }
        });

        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
         finish();

        }
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String roll_number = mrollnumber.getText().toString().toUpperCase().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("email is required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("password is required");
                    return;
                }
                if (TextUtils.isEmpty(roll_number)){
                    mrollnumber.setError("enter  roll number");
                }
                if(password.length() < 6){
                    mPassword.setError("password must be greater than 6 characters");
                }
                if(roll_number.length() < 10 ){
                    mrollnumber.setError("enter a valid jntu roll number");
                }

/*
                progressBar.setVisibility(View.VISIBLE);
*/


                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()){
                           Toast.makeText(Activity_Register.this, "user created", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getApplicationContext(),MainActivity.class));
                       }  else {
                           Toast.makeText(Activity_Register.this, "error", Toast.LENGTH_SHORT).show();
                       }
                   }


               });
            }
        });
    }
}

