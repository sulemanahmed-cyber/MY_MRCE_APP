package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class my_loginn extends AppCompatActivity {
private EditText mEmailField,email;
private EditText mPasswordField,password;
private Button mLoginBtn,button2;
TextView mregister,mforgot;

private FirebaseAuth mAuth;
private FirebaseAuth.AuthStateListener mAuthListener;
private static final String TAG ="my_loginn";


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser=mAuth.getCurrentUser();
        if (currentUser==null){

        }

        else{
            Intent intent= new Intent(getApplicationContext(),cources.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_loginn);
        mAuth=FirebaseAuth.getInstance();
        /*mregister = findViewById(R.id.register_here);
        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Activity_Register.class));
            }
        });*/
/*
        button2=(Button) findViewById(R.id.button2);
*/
        mEmailField=(EditText) findViewById(R.id.email_et);
        mPasswordField=(EditText)findViewById(R.id.password_et);
        mLoginBtn=(Button) findViewById(R.id.login_btn);
        mforgot = findViewById(R.id.forgotpassword);

        /*mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
          if (firebaseAuth.getCurrentUser()  !=null){
              Intent intent= new Intent(getApplicationContext(),syllabus.class);
              startActivity(intent);

          }
            }
        };*/


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignin();

            }
        });
    }

    public void startSignin() {
        String email = mEmailField.getText().toString();
        String password = mPasswordField.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "empty details", Toast.LENGTH_SHORT).show();
        } else {

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(my_loginn.this, "login successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    } else
                    {
                        Toast.makeText(my_loginn.this, "error", Toast.LENGTH_SHORT).show();
                    }
                    /*if (!task.isSuccessful()) {

                        Toast.makeText(my_loginn.this, "Sign in problem", Toast.LENGTH_SHORT).show();
                    }*/
                }
            });
        }

     mforgot.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             final EditText resetmail = new EditText(v.getContext());
             AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
             passwordResetDialog.setTitle("reset password");
             passwordResetDialog.setMessage("enter your email");
             passwordResetDialog.setView(resetmail);

             passwordResetDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {
                     String mail = resetmail.getText().toString();
                     mAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                         @Override
                         public void onSuccess(Void aVoid) {
                             Toast.makeText(my_loginn.this, "reset link sent to your mail", Toast.LENGTH_SHORT).show();
                         }
                     }).addOnFailureListener(new OnFailureListener() {
                         @Override
                         public void onFailure(@NonNull Exception e) {
                             Toast.makeText(my_loginn.this, "Error ! reset link failed", Toast.LENGTH_SHORT).show();
                         }
                     });
                 }
             });
             passwordResetDialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialog, int which) {

                 }
             });
             passwordResetDialog.create().show();
         }
     });
    }



}
