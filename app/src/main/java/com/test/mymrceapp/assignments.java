package com.test.mymrceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class assignments extends AppCompatActivity {

    ListView listview;
    Button addButton;
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


        listview = findViewById(R.id.listView1);
        addButton = findViewById(R.id.button1);
        GetValue = findViewById(R.id.editText1);

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
    }
}
