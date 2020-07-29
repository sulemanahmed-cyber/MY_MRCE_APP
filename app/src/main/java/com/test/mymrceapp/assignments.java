package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);

//old upload_images
        /*buttonUpload=(Button) findViewById(R.id.buttonUpload);*/


        //commented so as to disable uploading
        /*  buttonUpload_cse = (Button) findViewById(R.id.buttonUpload_cse);*/


        //old upload_images
        /* editPDFName = (EditText)findViewById(R.id.txt_pdfName);*/
        /*editPDFName = (EditText) findViewById(R.id.txt_pdfName_cse);*/

        storageReference = FirebaseStorage.getInstance().getReference();

        //old upload_images
        /* databaseReference = FirebaseDatabase.getInstance().getReference("images");*/
        databaseReference = FirebaseDatabase.getInstance().getReference("cse");



           /*buttonChoose.setOnClickListener(this);
           buttonUpload.setOnClickListener(this);*/

        //old upload_images
       /* buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectPDFFile_imgs();

            }
        });*/


      /*  buttonUpload_cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editPDFName.getText().toString().isEmpty()) {
                    editPDFName.setError("Please Enter The Name");
                } else {
                    selectPDFFile_cse();
                }


            }
        });*/
    }/////////////////////////////////////////////////////////// ON CREATE ENDS ////////////////////////////////////////////////////////////


//old upload_images
    ///private void selectPDFFile_imgs() {
    //     Intent intent = new Intent();
    //   intent.setType("*/*");
    // intent.setAction(Intent.ACTION_GET_CONTENT);
    //startActivityForResult(Intent.createChooser(intent,"Select PDF File"),1);
    //}*//

    //private void selectPDFFile_cse() {
    //Intent intent = new Intent();
    //intent.setType("*/*");
    //intent.setAction(Intent.ACTION_GET_CONTENT);
    //  startActivityForResult(Intent.createChooser(intent, "Select PDF File"), 2);

    //}




/*
    //commented so as to disable uploading

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //old upload_images
        */
/*if (requestCode==1 && resultCode==RESULT_OK && data != null && data.getData()!=null)
        {
            if (data.getData()!=null){
           uploadPDFFile(data.getData());
            }

            else{
                Toast.makeText(this, "NO FILE CHOOSEN", Toast.LENGTH_SHORT).show();
            }
        }*//*

        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            if (data.getData() != null) {
                uploadPDFFile_cse(data.getData());
            } else {
                Toast.makeText(this, "NO FILE CHOOSEN", Toast.LENGTH_SHORT).show();
            }
        }

    }
*/


    //commented so as to disable uploading
   /* private void uploadPDFFile_cse(Uri data) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading..");
        progressDialog.show();
        StorageReference reference = storageReference.child("cse/" + System.currentTimeMillis() + ".pdf");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                        while (!uri.isComplete()) ;
                        Uri url = uri.getResult();

                        uploadPDF uploadPDF = new uploadPDF(editPDFName.getText().toString(), url.toString());
                        databaseReference.child(databaseReference.push().getKey()).setValue(uploadPDF);
                        Toast.makeText(assignments.this, "uploaded", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
                progressDialog.setMessage(((int) progress) + "% Uploaded..");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }*/


    //old upload_images
    /*private void uploadPDFFile(Uri data) {// imgs//
        final ProgressDialog progressDialog= new ProgressDialog(this);
        progressDialog.setTitle("Uploading..");
        progressDialog.show();
        StorageReference reference = storageReference.child("images/"+System.currentTimeMillis()+".pdf");
        reference.putFile(data)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                        while(!uri.isComplete());
                        Uri url = uri.getResult();

                        uploadPDF uploadPDF = new uploadPDF(editPDFName.getText().toString(),url.toString());
                        databaseReference.child(databaseReference.push().getKey()).setValue(uploadPDF);
                        Toast.makeText(assignments.this, "uploaded", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                double progress = (100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.setMessage(((int)progress)+"% Uploaded..");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }*/




  /*  private void uploadFile(){

        if (filepath!=null){

        Context context;
        final ProgressDialog progressDialog= new ProgressDialog(this);
        progressDialog.setTitle("Uploading..");
        progressDialog.show();
        StorageReference riversRef = storageReference.child("images/"+ UUID.randomUUID().toString());
        riversRef.putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                       progressDialog.dismiss();
                        Toast.makeText(assignments.this, "File Uploaded", Toast.LENGTH_SHORT).show();
                          }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                         progressDialog.dismiss();
                    }
                })
                 .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                     @Override
                     public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                         double progress= (100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                         progressDialog.setMessage(((int)progress)+"% Uploaded..");
                     }
                 });
        ;
        }
        else{

        }
    }*/


    //old upload_images
    /*public void btn_action(View view) {
        startActivity(new Intent(getApplicationContext(),Main2Activity.class));
    }*/

    public void btn_action_cse(View view) {
        startActivity(new Intent(getApplicationContext(), cse_asnmnt.class));
    }
}
