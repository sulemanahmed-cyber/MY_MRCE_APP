
package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Activity_Register extends AppCompatActivity {
    EditText mEmail, mPassword, mName, mRollnumber;
    Button mRegister;
    private FirebaseAuth fAuth;
    Toolbar toolbar;
    TextView mlogin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__register);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Register");

        mEmail = findViewById(R.id.editText4);
        mPassword = findViewById(R.id.editText3);
        mName = findViewById(R.id.name);
        mRollnumber = findViewById(R.id.roll_number);


        mRegister = findViewById(R.id.button3);
        fAuth = FirebaseAuth.getInstance();
        mlogin = findViewById(R.id.login_here);
        /*progressBar = findViewById(R.id.progressBar);*/
        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), my_loginn.class));
            }
        });

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();

        }
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString().trim();
                final String password = mPassword.getText().toString().trim();
                final String rollnumber = mRollnumber.getText().toString().trim();
                final String name = mName.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("email is required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("password is required");
                    return;
                }

                if (TextUtils.isEmpty(rollnumber)) {
                    mRollnumber.setError("Roll Number is required");
                    return;
                }

                if (TextUtils.isEmpty(name)) {
                    mName.setError("Name is required");
                    return;
                }


                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user1 = new User(
                                    name,
                                    email,
                                    rollnumber
                            );
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Activity_Register.this, "REGISTRATION SUCCESFUL", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(Activity_Register.this, "An Error occured", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

                            //verification
                            FirebaseUser user = fAuth.getCurrentUser();
                            user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {


                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Activity_Register.this, "verification mail sent", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Activity_Register.this, "failed", Toast.LENGTH_SHORT).show();

                                }
                            });

                            Toast.makeText(Activity_Register.this, "user created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), dummy_1.class));
                        } else {
                            Toast.makeText(Activity_Register.this, "error", Toast.LENGTH_SHORT).show();
                        }
                    }


                });
            }
        });
    }


}

