package com.example.asus.insulintimer;


import android.support.annotation.NonNull;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.Toast;

import sql.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DB
        myDb = new DatabaseHelper(this);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        Helper.disableShiftMode(bottomNavigationView);


        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.menu_home:
                                selectedFragment = Home.newInstance();
                                Toast.makeText(MainActivity.this, "Home!", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_profile:
                                selectedFragment = Profile.newInstance();
                                Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_schedule:
                                selectedFragment = Schedule.newInstance();
                                Toast.makeText(MainActivity.this, "Schedule!", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_report:
                                selectedFragment = Report.newInstance();
                                Toast.makeText(MainActivity.this, "Report!", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_about:
                                Toast.makeText(MainActivity.this, "About!", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_help:
                                Toast.makeText(MainActivity.this, "Help!", Toast.LENGTH_SHORT).show();
                                break;

                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, Home.newInstance());
        transaction.commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.menu_about:
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, About.newInstance());
                transaction.commit();
                Toast.makeText(MainActivity.this, "About!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_help:
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.frame_layout, Help.newInstance());
                transaction1.commit();
                Toast.makeText(MainActivity.this, "Help!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_logout:
                finish();
                Toast.makeText(MainActivity.this, "Help!", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}