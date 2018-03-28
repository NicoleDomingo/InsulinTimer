package com.example.asus.insulintimer;

/**
 * Created by Mharjorie Sandel on 04/03/2018.
 */

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Schedule extends Fragment {
    private Button addalarm;
    private List<AlarmData> alarmArrayList = new ArrayList<>();
    private RecyclerView alarmListRV;
    private AlarmAdapter alarmAd;
    private String day;
    private Bundle a;  private int hour, mins, format= 0;

    public static Schedule newInstance() {
        Schedule fragment = new Schedule();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.alarm_menu, menu);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.schedule_layout, container, false);
        getActivity().setTitle("Schedule");
        addalarm = (Button) view.findViewById(R.id.addalarm);

        a = getArguments();

        if(a != null){
            hour =a.getInt("hrs");
            mins =a.getInt("minutes");
            Log.d("TIMECLICKED", "onCreateView: "+ hour);
        }
        else{
            Log.d("Clicked", "naaaaaaaah");
        }

        alarmListRV = (RecyclerView) view.findViewById(R.id.alarmList );
        alarmAd = new AlarmAdapter(alarmArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        alarmListRV.setLayoutManager(mLayoutManager);
        // set the adapter
        alarmListRV.setAdapter(alarmAd);
        prepareAlarmData();

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.addalarm:

                FragmentManager fM = getActivity().getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                AddAlarm h= new AddAlarm();
                fT.replace(R.id.frame_layout,h);
                fT.commit();

                Toast.makeText(getContext(), "Add New Alarm!", Toast.LENGTH_SHORT).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
    private void prepareAlarmData(){
        AlarmData alarm1 = new AlarmData("Monday",4,50);
        alarmArrayList.add(alarm1);
        alarm1 = new AlarmData("Tuesday",6,10);
        alarmArrayList.add(alarm1);
        alarm1 = new AlarmData("Wednesday",4,50);
        alarmArrayList.add(alarm1);
        alarm1 = new AlarmData("Thursday",6,10);
        alarmArrayList.add(alarm1);
        alarm1 = new AlarmData("Friday",4,50);
        alarmArrayList.add(alarm1);
        alarm1 = new AlarmData("Saturday",6,10);
        alarmArrayList.add(alarm1);
        if (a != null){

            alarm1= new AlarmData(day+ "", hour, mins);

            alarmArrayList.add(alarm1);
            Log.d("LUMABAS","LUMABAS:" + hour );
        }
        alarmAd.notifyDataSetChanged();
    }
}