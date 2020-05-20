package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class contact extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    AlertDialog alertDialog;
    TextView google_name ,google_email,verify_msg;
    Button google_signout;
    GoogleSignInClient mGoogleSignInClient;
    Button verify;
    FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        navigationView=findViewById(R.id.navigation_menu);
        toolbar=findViewById(R.id.toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);
/*
        verify = findViewById(R.id.verify);
        verify_msg = findViewById(R.id.tv1);
        fAuth = FirebaseAuth.getInstance();
*/

        //google_email = fAuth.getCurrentUser().getUid();

     /*   if(!user.isEmailVerified()){
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

        }*/

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       /* google_name = findViewById(R.id.google_name);
        google_email = findViewById(R.id.google_email);
        google_signout = findViewById(R.id.google_signout);*/
        /*google_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    // ...
                    case R.id.google_signout:
                        signOut();
                        break;
                    // ...
                }

            }
        });*/
     //to get account information
       /* GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
           String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();

            Uri personPhoto = acct.getPhotoUrl();

            google_name.setText(personName);
            google_email.setText(personEmail);


        }
*/


      /*  navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.nav_home:
                        Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        *//*  Toast.makeText(MainActivity.this, "HOME CLICKED", Toast.LENGTH_SHORT).show();*//*
                        break;

                    case R.id.nav_syllabus:
                        Intent intent3 = new Intent(getApplicationContext(),syllabus.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_cources:
                        Intent intent1= new Intent(getApplicationContext(), cources.class);
                        startActivity(intent1);
                        *//* Toast.makeText(MainActivity.this, "SETTINGS CLICKED", Toast.LENGTH_SHORT).show();*//*
                        break ;

                    case R.id.nav_gallery:
                        Intent intent2= new Intent(getApplicationContext(), gallery.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_bus_routes:
                        Intent intent4 = new Intent(getApplicationContext(),bus_routes.class);
                        startActivity(intent4);
                        break;
                    case R.id.nav_notice:
                        Intent intent5 = new Intent(getApplicationContext(),notice.class);
                        startActivity(intent5);
                        break;

                    case R.id.nav_faculty:
                        Intent intent6 = new Intent(getApplicationContext(),faculty.class);
                        startActivity(intent6);
                        break;
                    case R.id.nav_events:
                        Intent intent7 = new Intent(getApplicationContext(),events.class);
                        startActivity(intent7);
                        break;

                    case R.id.nav_studentc:
                        Intent intent8 = new Intent(getApplicationContext(),student_chapters.class);
                        startActivity(intent8);
                        break;
                    case R.id.nav_cells:
                        Intent intent9 = new Intent(getApplicationContext(),cells.class);
                        startActivity(intent9);
                        break;
                    case R.id.nav_notification:
                        Intent intent10 = new Intent(getApplicationContext(),notification.class);
                        startActivity(intent10);
                        break;
                    case R.id.nav_canteen:
                        Intent intent11 = new Intent(getApplicationContext(),canteen.class);
                        startActivity(intent11);
                        break;
                    case R.id.nav_contact:
                        Intent intent12 = new Intent(getApplicationContext(),contact.class);
                        startActivity(intent12);
                        break;
                    case R.id.nav_dum_1:
                        Intent intent13 = new Intent(getApplicationContext(),dummy_1.class);
                        startActivity(intent13);
                        break;
                }

                return false;
            }
        });*/


    }
   /* private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // ...
                        Toast.makeText(contact.this, "signed out", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
    }
*/
   /* private void setUpToolbar()
    {

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }
    @Override
    public void onBackPressed() {
        finish();
    }*/
}
