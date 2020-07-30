package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class cse_asnmnt extends AppCompatActivity {
    ListView myPDFListView;
    DatabaseReference databaseReference;
    List<uploadPDF> uploadPDFS;
    SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_asnmnt);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        myPDFListView = (ListView) findViewById(R.id.pdflist);
        uploadPDFS = new ArrayList<>();
        viewAllFiles();
        myPDFListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                uploadPDF uploadPDF = uploadPDFS.get(position);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(uploadPDF.getUrl()));
                startActivity(intent);
            }
        });

    }/////////////////////////////////////////////////////////// ON CREATE ENDS ////////////////////////////////////////////////////////////

    private void viewAllFiles() {
        databaseReference = FirebaseDatabase.getInstance().getReference("cse");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    uploadPDF uploadPDF = postSnapshot.getValue(com.test.mymrceapp.uploadPDF.class);
                    uploadPDFS.add(uploadPDF);
                }
                String[] cse1 = new String[uploadPDFS.size()];
                for (int i = 0; i < cse1.length; i++) {
                    cse1[i] = uploadPDFS.get(i).getName();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, cse1) {
                  /*  @NonNull
                    @Override
                    public View getView(int position, View convertView,  ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        TextView myText = (TextView) view.findViewById(android.R.id.text1);
                        myText.setTextColor(Color.BLACK);
                        return view;
                    }*/
                };

                myPDFListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
