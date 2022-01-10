package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.FirebaseApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class assignments extends AppCompatActivity  {

/* private static final int PICK_IMAGE_REQUEST = 234; */

    EditText editPDFName, txt_pdfName_cse;


    private Button buttonUpload, buttonUpload_cse;
    private Uri filepath;
    private StorageReference storageReference;
    DatabaseReference databaseReference;
    Toolbar toolbar;
    DrawerLayout drawerLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);
        toolbar = findViewById(R.id.toolbar_Assign);
        drawerLayout = findViewById(R.id.drawer_Assign);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



       /* storageReference = FirebaseStorage.getInstance().getReference();

           databaseReference = FirebaseDatabase.getInstance().getReference("cse");*/




    }/////////////////////////////////////////////////////////// ON CREATE ENDS ////////////////////////////////////////////////////////////









    public void btn_action_cse(View view) {
        startActivity(new Intent(getApplicationContext(), cse_asnmnt.class));
    }
}
