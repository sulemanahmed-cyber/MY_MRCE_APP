package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.FirebaseApp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class assignments extends AppCompatActivity  {

    private static final int PICK_IMAGE_REQUEST = 234;
    ListView listview;
    Button addButton;
    private ImageView imageView;
    TextView textFile;
    private Uri filepath;
    private StorageReference storageReference;
    EditText GetValue;
    private Button buttonChoose, buttonUpload, buttonDownload;

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
        buttonDownload = (Button) findViewById(R.id.buttonDownload);
        textFile = (TextView) findViewById(R.id.textFile);

         storageReference=FirebaseStorage.getInstance().getReference();
        listview = findViewById(R.id.listView1);
        addButton = findViewById(R.id.button1);
        GetValue = findViewById(R.id.editText1);

           /*buttonChoose.setOnClickListener(this);
           buttonUpload.setOnClickListener(this);*/



/*

// Create a reference with an initial file path and name
        StorageReference pathReference = storageReference.child("images/"+ UUID.randomUUID().toString());
*/




       /*  buttonDownload.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 storageReference=FirebaseStorage.getInstance().getReference();
                 storageReference=storageReference.child("profile.jpg");
                 storageReference.child("images/"+ UUID.randomUUID().toString()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                     @Override
                     public void onSuccess(Uri uri) {
                         // Got the download URL for 'users/me/profile.png'
                         String url=uri.toString();
                     downloadFile(assignments.this,"profile",".jpg",DIRECTORY_DOWNLOADS);
                     }
                 }).addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception exception) {
                         // Handle any errors
                     }
                 });

             }
         });*/




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
        intent.setType("*/*");
       intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "select a PDF"), PICK_IMAGE_REQUEST);

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

            filepath = data.getData();


           /* try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),filepath);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }*/


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


    private void downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {

        DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);

        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(filepath.parse(url));

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);


    }


}
