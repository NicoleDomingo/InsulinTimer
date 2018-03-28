package com.example.asus.insulintimer;

/**
 * Created by Mharjorie Sandel on 04/03/2018.
 */

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Report extends Fragment {
    private Spinner spin;
    private String date[] = {"Week", "Month", "3 Months"};
    private ArrayAdapter<String> dateadapter;
    public static Report newInstance() {
        Report fragment = new Report();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.report_layout, container, false);
        getActivity().setTitle("Reports");

        Bundle addActivityItems = getArguments();

        if(addActivityItems != null){
            String sugarNo= addActivityItems.getString("sugarNo");
            Log.d("Value:", sugarNo);
            String mealSelected = addActivityItems.getString("mealSelected");
            Log.d("mealSelectedReport", mealSelected);
            int mealPosition = addActivityItems.getInt("mealPosition");
            Log.d("mealSelectedPos", String.valueOf(mealPosition));
            String meal[] = addActivityItems.getStringArray("mealArray");
            Log.d ("Meal Array: ", Arrays.toString(meal));


            /*Set TEXT
            TextView sugarValue = (TextView) view.findViewById(R.id.tv_bs);
            sugarValue.setText(s);*/

        }

        spin = (Spinner) view.findViewById(R.id.spindate);
        dateadapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, date);
        spin.setAdapter(dateadapter);
        return view;


    }

}