package com.test.mymrceapp;

import android.app.Application;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class home extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /*FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null && firebaseUser.isEmailVerified()){
            startActivity(new Intent(home.this,MainActivity.class));
        }*/
    }
}
