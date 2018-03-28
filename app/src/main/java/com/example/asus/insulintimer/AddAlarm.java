package com.example.asus.insulintimer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mharjorie Sandel on 11/03/2018.
 */

public class AddAlarm extends Fragment {
    Button saveAlarm;
    private String format;
    private int hour, minute, fhour;
    private TimePicker timePicker;


    public static AddAlarm newInstance() {
        AddAlarm fragment = new AddAlarm();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getActivity().setTitle("Add Alarm");
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        //setContentView(R.layout.addalarm_layout);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.add_alarm, menu);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.addalarm_layout, container, false);

        saveAlarm = (Button) view.findViewById(R.id.menu_savealarm);

        timePicker = (TimePicker) view.findViewById(R.id.timePicker);
        return view;
    }
    /*public void getTime(){


        saveAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hour = timePicker.getCurrentHour();
                minute = timePicker.getCurrentMinute();

                format(hour);
                if (hour > 12){
                    fhour = hour - 12;
                }
                else {
                    fhour = hour;
                }


                Bundle bundle = new Bundle();
                bundle.putInt("hrs",fhour);
                bundle.putInt("minutes", minute);

                //set Fragmentclass Arguments
                //ItemThree fragobj = new ItemThree();
                //fragobj.setArguments(bundle);


                Schedule fragobj = new Schedule();
                fragobj.setArguments(bundle);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, fragobj);
                transaction.commit();
                Log.d("Check:", "HELLO");




            }

        });
    }*/

    public void format(int hour){
        if (hour ==0){
            hour += 12;
            format = "AM";
        } else if (hour == 12){
            format = "PM";
        } else if (hour > 12){
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_savealarm:
                hour = timePicker.getCurrentHour();
                minute = timePicker.getCurrentMinute();

                format(hour);
                if (hour > 12){
                    fhour = hour - 12;
                }
                else {
                    fhour = hour;
                }


                Bundle bundle = new Bundle();
                bundle.putInt("hrs",fhour);
                bundle.putInt("minutes", minute);

                //set Fragmentclass Arguments
                //ItemThree fragobj = new ItemThree();
                //fragobj.setArguments(bundle);


                Schedule fragobj = new Schedule();
                fragobj.setArguments(bundle);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, fragobj);
                transaction.commit();
                Log.d("Check:", "HELLO");
                /*FragmentManager fM = getActivity().getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                Schedule h= new Schedule();
                fT.replace(R.id.frame_layout,h);
                fT.commit();*/

                // insert something for the db to add row
                Toast.makeText(getContext(), "New alarm added!", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }




}
