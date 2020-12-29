package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class syllabus extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String,List<String>> listItem;
    MainAdapter adapter;
    public Spinner spin;
    int positionToShowToSpinner;
    //EXPNDBL URLS

    //1year h&s url;
    String hcsurl="https://jntuh.ac.in/uploads/academics/R18B.TechIYearSyllabusofEEECSEIT1.pdf";
    String hecurl="https://jntuh.ac.in/uploads/academics/R18B.TechIYearSyllabusofECEEIE.pdf";
    String hmeurl="https://jntuh.ac.in/uploads/academics/R18B.TechIYearSyllabusofNon_CircuitBranches.pdf";
    //CSE urls
    String cse2url = "https://jntuh.ac.in/uploads/academics/R18B.TECHCSEIIYearSyllabus.pdf";
    String cse3url = "https://jntuh.ac.in/uploads/academics/R18B.Tech.CSEIIIYearSyllabus.pdf";
    String cse4url = "https://jntuh.ac.in/uploads/academics/R16B.TechCSEIVYearRevisedSyllabusWithModifiedDataMiningLab.pdf";
    //IT urls
    String it2url="https://jntuh.ac.in/uploads/academics/R18B.TECHITIIYearSyllabus.pdf";
    String it3url="https://jntuh.ac.in/uploads/academics/R18B.Tech.ITIIIYearSyllabus.pdf";
    String it4url="https://jntuh.ac.in/uploads/academics/R16B.TechITIVYearRevisedSyllabus.pdf";
    //ECE urls
    String ece2url="https://jntuh.ac.in/uploads/academics/R18B.TECHECEIIYearSyllabus.pdf";
    String ece3url="https://jntuh.ac.in/uploads/academics/R18B.Tech.ECEIIIYearSyllabus.pdf";
    String ece4url="https://jntuh.ac.in/uploads/academics/R16B.TechECEIVYearRevisedSyllabus1.pdf";
    //MECH urls
    String mec2url="https://jntuh.ac.in/uploads/academics/R18B.TECHMECHANICALENGGIIYearSyllabus.pdf";
    String mec3url="https://jntuh.ac.in/uploads/academics/R18B.Tech.MechanicalEngg.IIIYearSyllabus.pdf";
    String mec4url="https://jntuh.ac.in/uploads/academics/R16B.TechMechanicalEngineeringIVYearRevisedSyllabus.pdf";
    //ITE urls
    String ite2url="https://jntuh.ac.in/uploads/academics/R18B.TechITEIIIYearSyllabus.pdf";
    String ite3url="https://jntuh.ac.in/uploads/academics/R18B.TechITEIIIYearSyllabus.pdf";
    String ite4url="https://jntuh.ac.in/uploads/academics/R18B.TechITEIIIYearSyllabus.pdf";

       int g;
       int c;




    /* Intent i = new Intent(Intent.ACTION_VIEW);
i.setData(Uri.parse(url));
    startActivity(i);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Syllabus");
        navigationView= findViewById(R.id.navigation_menu);






        //expandable view code <exstarts>
        expandableListView=findViewById(R.id.expandable_listview);
        listGroup= new ArrayList<>();
        listItem= new HashMap<>();
        adapter=new MainAdapter(this,listGroup,listItem);
        expandableListView.setAdapter(adapter);


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {



                    if (groupPosition == 0 && childPosition==0 ){

                        Intent ihs1=new Intent(Intent.ACTION_VIEW);
                        ihs1.setData(Uri.parse(hcsurl));
                        startActivity(ihs1);
                    }
                    if (groupPosition == 0 && childPosition==1 ){
                        Intent ihs2=new Intent(Intent.ACTION_VIEW);
                        ihs2.setData(Uri.parse(hecurl));
                        startActivity(ihs2);
                    }
                    if (groupPosition == 0 && childPosition==2 ){
                        Intent ihs3=new Intent(Intent.ACTION_VIEW);
                        ihs3.setData(Uri.parse(hmeurl));
                        startActivity(ihs3);
                    }
                    if (groupPosition == 1 && childPosition==0 ){
                        Intent ics1=new Intent(Intent.ACTION_VIEW);
                        ics1.setData(Uri.parse(cse2url));
                        startActivity(ics1); }
                    if (groupPosition == 1 && childPosition==1 ){
                        Intent ics2=new Intent(Intent.ACTION_VIEW);
                        ics2.setData(Uri.parse(cse3url));
                        startActivity(ics2);
                     } if (groupPosition == 1 && childPosition==2 ){
                        Intent ics3=new Intent(Intent.ACTION_VIEW);
                        ics3.setData(Uri.parse(cse4url));
                        startActivity(ics3);
                     }
                    if (groupPosition == 2 && childPosition==0 ){
                        Intent iit1=new Intent(Intent.ACTION_VIEW);
                        iit1.setData(Uri.parse(it2url));
                        startActivity(iit1);
                     }
                    if (groupPosition == 2 && childPosition==1 ){
                        Intent iit2=new Intent(Intent.ACTION_VIEW);
                        iit2.setData(Uri.parse(it3url));
                        startActivity(iit2);
                    }
                    if (groupPosition == 2 && childPosition==2 ){
                        Intent iit3=new Intent(Intent.ACTION_VIEW);
                        iit3.setData(Uri.parse(it4url));
                        startActivity(iit3);
                    }
                    if (groupPosition == 3 && childPosition==0 ){
                        Intent iec1=new Intent(Intent.ACTION_VIEW);
                        iec1.setData(Uri.parse(ece2url));
                        startActivity(iec1);
                    }
                    if (groupPosition == 3 && childPosition==1 ){
                        Intent iec2=new Intent(Intent.ACTION_VIEW);
                        iec2.setData(Uri.parse(ece3url));
                        startActivity(iec2);
                     }
                    if (groupPosition == 3 && childPosition==2 ){
                        Intent iec3=new Intent(Intent.ACTION_VIEW);
                        iec3.setData(Uri.parse(ece4url));
                        startActivity(iec3);
                     }
                    if (groupPosition == 4 && childPosition==0 ){
                        Intent ime1=new Intent(Intent.ACTION_VIEW);
                        ime1.setData(Uri.parse(mec2url));
                        startActivity(ime1);
                    }
                    if (groupPosition == 4 && childPosition==1 ){
                        Intent ime2=new Intent(Intent.ACTION_VIEW);
                        ime2.setData(Uri.parse(mec3url));
                        startActivity(ime2);
                    }
                    if (groupPosition == 4 && childPosition==2 ){
                        Intent ime3=new Intent(Intent.ACTION_VIEW);
                        ime3.setData(Uri.parse(mec4url));
                        startActivity(ime3);
                    }
                    if (groupPosition == 5 && childPosition==0 ){
                        Intent iie1=new Intent(Intent.ACTION_VIEW);
                        iie1.setData(Uri.parse(ite2url));
                        startActivity(iie1);
                    }
                    if (groupPosition == 5 && childPosition==1 ){
                        Toast.makeText(syllabus.this, "no data", Toast.LENGTH_SHORT).show();
                    }
                    if (groupPosition == 5 && childPosition==2 ){
                        Toast.makeText(syllabus.this, "no data1", Toast.LENGTH_SHORT).show();

                    }






                    return false;
                }
            });



        initListData();




        //<EXPNDBLends/>


    }



    //expndbl method <starts>
    private void initListData() {
        listGroup.add(getString(R.string.group1));
        listGroup.add(getString(R.string.group2));
        listGroup.add(getString(R.string.group3));
        listGroup.add(getString(R.string.group4));
        listGroup.add(getString(R.string.group5));
        listGroup.add(getString(R.string.group6));
        String[] array;
        List<String> list1 = new ArrayList<>();
        array = getResources().getStringArray(R.array.group1);
        for (String item :array) {
            list1.add(item);
        }
        List<String> list2 = new ArrayList<>();
        array = getResources().getStringArray(R.array.group2);
        for (String item :array) {
            list2.add(item);
        }
        List<String> list3 = new ArrayList<>();
        array = getResources().getStringArray(R.array.group3);
        for (String item :array) {
            list3.add(item);
        }
        List<String> list4 = new ArrayList<>();
        array = getResources().getStringArray(R.array.group4);
        for (String item :array) {
            list4.add(item);
        }
        List<String> list5 = new ArrayList<>();
        array = getResources().getStringArray(R.array.group5);
        for (String item :array) {
            list5.add(item);
        }
        List<String> list6 = new ArrayList<>();
        array = getResources().getStringArray(R.array.group6);
        for (String item :array) {
            list6.add(item);
        }
        listItem.put(listGroup.get(0),list1);
        listItem.put(listGroup.get(1),list2);
        listItem.put(listGroup.get(2),list3);
        listItem.put(listGroup.get(3),list4);
        listItem.put(listGroup.get(4),list5);
        listItem.put(listGroup.get(5),list6);
        adapter.notifyDataSetChanged();

    }
    //epndbl method <ends/>

}