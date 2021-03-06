package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


public class my_loginn extends AppCompatActivity {

    private EditText mEmailField, email;
    Toolbar toolbar;
    private EditText mPasswordField, password;
    private Button mLoginBtn, button2;
    TextView mregister, mforgot;
    SignInButton google_button;
    private FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;
    int RC_SIGN_IN = 0;
/*public static int flag;*/
private FirebaseAuth.AuthStateListener mAuthListener;
private static final String TAG ="my_loginn";
    int positionOfSelectedDataFromSpinner;

    @Override
    protected void onStart() {
        super.onStart();
/*
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
*/


       /* FirebaseUser currentUser=mAuth.getCurrentUser();
        if (currentUser==null){

        }

        else{
            Intent intent= new Intent(getApplicationContext(),cources.class);
            startActivity(intent);
        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_loginn);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("login");


        Context context = this;
        if (InternetConnection.checkConnection(context)) {
            // Its Available...

            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build();
            mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

            google_button = findViewById(R.id.google_button);
            mAuth = FirebaseAuth.getInstance();
            mregister = findViewById(R.id.register_here);
            mregister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(),Activity_Register.class));
                }
            });

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
            mEmailField = (EditText) findViewById(R.id.email_et);
            mPasswordField = (EditText) findViewById(R.id.password_et);
            mLoginBtn = (Button) findViewById(R.id.login_btn);
            mforgot = findViewById(R.id.forgotpassword);

            String userName = mEmailField.getText().toString();
            SharedPreferences prefs = this.getSharedPreferences(
                    "com.example.app", Context.MODE_PRIVATE);
            prefs.edit().putString("name", userName).apply();


            google_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.google_button:
                            SignIn();
                            break;
                    }

                }
            });
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


            mforgot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final EditText resetmail = new EditText(v.getContext());
                    final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                    passwordResetDialog.setTitle("reset password");
                    passwordResetDialog.setMessage("enter your email");
                    passwordResetDialog.setView(resetmail);

                    passwordResetDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(final DialogInterface dialog, int which) {

                            String email = resetmail.getText().toString();
                            if (TextUtils.isEmpty(email)) {
                                //  resetmail.setError("Please Provide valid mail !!");

                                Toast.makeText(my_loginn.this, "please provide mail !!", Toast.LENGTH_SHORT).show();
                            } else {


                                final String mail = resetmail.getText().toString().trim();
                           /* if (mail.equals("null")) {
                                resetmail.setError("please provide mail !");
                               // Toast.makeText(my_loginn.this, "enter your email ", Toast.LENGTH_SHORT).show();
                            }*/

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


            //Internet Checking
        } else {
            Toast.makeText(this, "Please Connect To Internet", Toast.LENGTH_SHORT).show();
            // Not Available...


            AlertDialog alertDialog1 = new AlertDialog.Builder(
                    my_loginn.this).create();

            // Setting Dialog Title
            alertDialog1.setTitle("Not Connected to INTERNET");

            // Setting Dialog Message
            alertDialog1.setMessage("Please Connect To Internet");

            // Setting Icon to Dialog
            alertDialog1.setIcon(R.drawable.mrce);

            // Setting OK Button

            alertDialog1.setCancelable(false);
            // Showing Alert Message
            alertDialog1.show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void SignIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            /*flag=1;*/
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w( "Error", "signInResult:failed code=" + e.getStatusCode());
        }
    }


    public void startSignin() {
        String email = mEmailField.getText().toString();
        String password = mPasswordField.getText().toString();

        if (TextUtils.isEmpty(email)) {
            mEmailField.setError("Enter your email id");
            Toast.makeText(this, "empty Email", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            mPasswordField.setError("enter your password");
            Toast.makeText(this, "empty Password", Toast.LENGTH_SHORT).show();
        } else {

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        if (mAuth.getCurrentUser().isEmailVerified()) {

                            startActivity(new Intent(my_loginn.this, MainActivity.class));
                            Toast.makeText(my_loginn.this, "login successfull", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(my_loginn.this, "please verify your email address", Toast.LENGTH_SHORT).show();
                        }

                        /*  Toast.makeText(my_loginn.this, "login successfull", Toast.LENGTH_SHORT).show();
                         *//*flag=1;*//*
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));*/
                    } else {
                        Toast.makeText(my_loginn.this, "error", Toast.LENGTH_SHORT).show();
                    }
                    /*if (!task.isSuccessful()) {

                        Toast.makeText(my_loginn.this, "Sign in problem", Toast.LENGTH_SHORT).show();
                    }*/
                }
            });
        }


    }


}
