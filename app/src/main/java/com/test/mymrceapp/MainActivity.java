package com.test.mymrceapp;

import      androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.ArrayList;
import java.util.List;

import static com.test.mymrceapp.my_loginn.flag;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    AlertDialog alertDialog;
    ViewFlipper v_flipper;
    GridLayout gridLayout;
    ViewPager  viewPager;
    Adapter adapter;
    Button button,logout1;
    FirebaseAuth fAuth;

    List<Model> models;
    Integer[] colors=null;
    ArgbEvaluator argbEvaluator= new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        gridLayout= findViewById(R.id.gridLayout5);
       button = findViewById(R.id.my_abt);
       logout1 = findViewById(R.id.logout1);

      /* button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),Activity_Register.class);
               startActivity(intent);
           }
       });
*/





        setToggleEvent(gridLayout);
        models=new ArrayList<>();
        models.add(new Model(R.drawable.the_nn,"Sri. Ch. Malla Reddy","Founder Chairman, MRGI"));
        models.add(new Model(R.drawable.pres_bhadra,"Dr. Ch. Bhadra Reddy","(President, MRGI)"));
        models.add(new Model(R.drawable.nss_1,"nss","this is Nss"));
        models.add(new Model(R.drawable.nss_1,"nss_1","this is nss_1"));

        adapter=new Adapter(models,this);

        viewPager=findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(10,0,130,0);
         viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
             @Override
             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

             }

             @Override
             public void onPageSelected(int position) {

                /* switch (position){
                     case 0:
                         drawerLayout.setBackgroundResource(R.color.cpl);
                         Toast.makeText(MainActivity.this, "1st page", Toast.LENGTH_SHORT).show();
                         break;


                     case 1:

                         drawerLayout.setBackgroundResource(R.color.brown);
                         Toast.makeText(MainActivity.this, "second page", Toast.LENGTH_SHORT).show();
                         break;

                     case 2:

                         drawerLayout.setBackgroundResource(R.color.cpd);
                         Toast.makeText(MainActivity.this, "third  page", Toast.LENGTH_SHORT).show();
                         break;


                 }*/
             }

             @Override
             public void onPageScrollStateChanged(int state) {

             }
         });
        Integer[] colors_temp={getResources().getColor(R.color.cpl),
                getResources().getColor(R.color.cp),
                getResources().getColor(R.color.cpd),
                getResources().getColor(R.color.lavender)};

       /* viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position<(adapter.getCount()-1)&&position<(colors.length-1)){
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                            positionOffset,
                            colors[position],
                            colors[position+1]));
                }
                else{
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }


            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/




        //firebase
        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (task.isSuccessful()){
                            String token = task.getResult().getToken();
                            String message = getString(R.string.fcm_token,token);
                        }

                    }
                });

        //viewflipper
        int images []={R.drawable.mrce1,R.drawable.mrce2,R.drawable.person,R.drawable.mrce};
        v_flipper=findViewById(R.id.v_flipper);
               for (int image:images){
                   flipperImages(image);
               }

       v_flipper.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getApplicationContext(),my_loginn.class);
               startActivity(intent);
           }
       });
        //toolbar and navigation code <navstarts>
        setUpToolbar();
        navigationView= (NavigationView)findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
              switch(menuItem.getItemId()){
                    case R.id.nav_home:
                        Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                      /*  Toast.makeText(MainActivity.this, "HOME CLICKED", Toast.LENGTH_SHORT).show();*/
                        break;

                  case R.id.nav_syllabus:
                      Intent intent3 = new Intent(getApplicationContext(),syllabus.class);
                      startActivity(intent3);
                      break;

                    case R.id.nav_cources:
                        Intent intent1= new Intent(getApplicationContext(), cources.class);
                        startActivity(intent1);
                        /* Toast.makeText(MainActivity.this, "SETTINGS CLICKED", Toast.LENGTH_SHORT).show();*/
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
                      /*
                      if(user.isAnonymous()){
                          startActivity(new Intent(getApplicationContext(),Activity_Register.class));
                      } else {
                          startActivity(new Intent(getApplicationContext(),contact.class));
                      }

                      /*fAuth = FirebaseAuth.getInstance();
                      FirebaseUser user = fAuth.getCurrentUser();
                      if(user.isEmailVerified()){
                          startActivity(new Intent(getApplicationContext(),contact.class));
                      }else {
                          startActivity(new Intent(getApplicationContext(),Activity_Register.class));
                      }*/

                     if(flag==1){
                         Intent intent12 = new Intent(getApplicationContext(),contact.class);
                         startActivity(intent12);
                     }else {
                         Intent intent12 = new Intent(getApplicationContext(),Activity_Register.class);
                         startActivity(intent12);
                     }
                      break;
                  case R.id.nav_dum_1:


                      Intent intent13 = new Intent(getApplicationContext(),dummy_1.class);
                      startActivity(intent13);
                      break;


              }

                return false;
            }
        });

           //<navends/>
    }

private void setToggleEvent(GridLayout gridLayout){
        for(int i =0 ;i <gridLayout.getChildCount(); i++){
            final CardView cardView = (CardView) gridLayout.getChildAt(i);
            final int finalI = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(finalI == 0)
                    {
                        Intent intent = new Intent(MainActivity.this,syllabus.class);
                        startActivity(intent);
                    }
                    if(finalI == 1)
                    {
                        Intent intent = new Intent(MainActivity.this,cources.class);
                        startActivity(intent);
                    }
                    if(finalI == 2)
                    {
                        Intent intent = new Intent(MainActivity.this,bus_routes.class);
                        startActivity(intent);
                    }
                    if(finalI == 3)
                    {
                        Intent intent = new Intent(MainActivity.this,events.class);
                        startActivity(intent);
                    }
                    if(finalI == 4)
                    {
                        Intent intent = new Intent(MainActivity.this,faculty.class);
                        startActivity(intent);
                    }
                    if(finalI == 5)
                    {
                        Intent intent = new Intent(MainActivity.this,student_chapters.class);
                        startActivity(intent);
                    }
                    if(finalI == 6)
                    {
                        Intent intent = new Intent(MainActivity.this,canteen.class);
                        startActivity(intent);
                    }
                    if(finalI == 7)
                    {
                        Intent intent = new Intent(MainActivity.this,dummy_1.class);
                        startActivity(intent);
                    }
                    if(finalI == 8)
                    {
                       /* Intent intent = new Intent(MainActivity.this,contact.class);
                        startActivity(intent);*/
                        if(flag==1){
                            Intent intent12 = new Intent(getApplicationContext(),contact.class);
                            startActivity(intent12);
                        }else {
                            Intent intent12 = new Intent(getApplicationContext(),Activity_Register.class);
                            startActivity(intent12);
                        }
                      /*  fAuth = FirebaseAuth.getInstance();
                        FirebaseUser user = fAuth.getCurrentUser();
                        if(user.isEmailVerified()){
                            startActivity(new Intent(getApplicationContext(),contact.class));
                        }else {
                            startActivity(new Intent(getApplicationContext(),Activity_Register.class));
                        }*/
                    }
                }
            });
        }
}
    //view flipper images
    public void  flipperImages(int image){
        ImageView imageView= new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
     }



    //toolbar code
    private void setUpToolbar()
    {
    drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
    toolbar=(Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
   /* getActionBar().setDisplayHomeAsUpEnabled(true);
    getActionBar().setDisplayShowTitleEnabled(false);*/
    actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
    drawerLayout.addDrawerListener(actionBarDrawerToggle);
    actionBarDrawerToggle.syncState();


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel =
                    new NotificationChannel("MyNotifications", "MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }



    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Please confirm");
        builder.setMessage("Do you want to exit the app?");
        builder.setCancelable(true);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do something when user want to exit the app
                // Let allow the system to handle the event, such as exit the app
                /*MainActivity.super.onBackPressed();*/
                finishAffinity();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do something when want to stay in the app
                Toast.makeText(MainActivity.this,"thank you", Toast.LENGTH_LONG).show();
            }
        });

        // Create the alert dialog using alert dialog builder
        AlertDialog dialog = builder.create();

        // Finally, display the dialog when user press back button
        dialog.show();
    }


    public void my_register(View view) {
        Toast.makeText(this, "okie", Toast.LENGTH_SHORT).show();


        Intent intent_reg= new Intent(getApplicationContext(),Activity_Register.class);
        startActivity(intent_reg);


    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();


    }
}
