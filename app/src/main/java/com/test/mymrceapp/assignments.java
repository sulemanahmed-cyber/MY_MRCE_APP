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

    private static final int PICK_IMAGE_REQUEST = 234;
    ListView listview;
    Button addButton;
    private ImageView imageView;
    private Button buttonChoose, buttonUpload;
    private Uri filepath;
    private StorageReference storageReference;
    EditText GetValue;
    String[] ListElements = new String[] {
            "Android",
            "PHP",
            "Python",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);

        imageView=(ImageView) findViewById(R.id.imageView);
        buttonChoose=(Button) findViewById(R.id.buttonChoose);
        buttonUpload=(Button) findViewById(R.id.buttonUpload);

         storageReference=FirebaseStorage.getInstance().getReference();
        listview = findViewById(R.id.listView1);
        addButton = findViewById(R.id.button1);
        GetValue = findViewById(R.id.editText1);

           /*buttonChoose.setOnClickListener(this);
           buttonUpload.setOnClickListener(this);*/




        final List<String> ListElementsArrayList = new ArrayList<>(Arrays.asList(ListElements));
        final ArrayAdapter<String> adapter = new ArrayAdapter<>
                (assignments.this, android.R.layout.simple_list_item_1, ListElementsArrayList);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch (position){
                    case 0:
                        Toast.makeText(assignments.this, "01", Toast.LENGTH_SHORT).show();
                       break;
                    case 1:
                        Toast.makeText(assignments.this, "02", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(assignments.this, "03", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(assignments.this, "04", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(assignments.this, ++position, Toast.LENGTH_SHORT).show();
                        break;




                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListElementsArrayList.add(GetValue.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        buttonChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadFile();
            }
        });
    }


    private void showFileChooser(){
       Intent intent= new Intent();
       intent.setType("image/*");
       intent.setAction(Intent.ACTION_GET_CONTENT);
       startActivityForResult(Intent.createChooser(intent,"select an image"), PICK_IMAGE_REQUEST);

    }

    /*@Override
    public void onClick(View v) {
        if (view == buttonChoose){
            //open chooser
            showFileChooser();
            }
        else if (view == buttonUpload){
            //upload to firebase storage
        }

    }*/


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data != null && data.getData()!=null)
        {
                filepath=data.getData();

            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),filepath);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void uploadFile(){

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
    }

}
