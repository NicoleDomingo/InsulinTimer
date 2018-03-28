package com.example.asus.insulintimer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

/**
 * Created by Mharjorie Sandel on 10/03/2018.
 */

public class AddActivity extends Fragment {
    private String meal[] = {"Before Breakfast", "After Breakfast", "Before Lunch","After Lunch","Before Dinner","After Dinner",
            "Before Snack","After Snack", "Fasting", "Bedtime", "Other"};
    private ArrayAdapter<String> mealadapter;
    private String insulin[] = {"Rapid-acting", "Short-acting", "Intermediate- acting", "Long-acting"};
    private ArrayAdapter<String> insulinadapter;
    private Spinner spin1, spin2;
    private Button cancel,addB;
    private EditText sugarTxt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.addbs_layout);
        setHasOptionsMenu(true);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.add_menu, menu);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.addbs_layout, container, false);
        getActivity().setTitle("Add Reading");

        addB = (Button) view.findViewById(R.id.menu_addbs);
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.addbs_layout);

        spin1 = (Spinner) view.findViewById(R.id.spinner);
        mealadapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, meal);
        spin1.setAdapter(mealadapter);
        spin2 = (Spinner) view.findViewById(R.id.spinner1);
        insulinadapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, insulin);
        spin2.setAdapter(insulinadapter);


        sugarTxt = (EditText) view.findViewById(R.id.sugarTxt);

        cancel = (Button) view.findViewById(R.id.b_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fM = getActivity().getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                Home h= new Home();
                fT.replace(R.id.frame_layout, h);
                fT.commit();

                /* ADD
                String sugarNo = sugarTxt.getText().toString();
                String mealSelected = spin1.getSelectedItem().toString();
                int mealPosition = spin1.getSelectedItemPosition();
                Log.d ("Selected Value: ", mealSelected  + mealPosition) ;
                //Array
                Log.d ("Meal Array: ", Arrays.toString(meal));

                Bundle addActivityItems = new Bundle();
                addActivityItems.putString("sugarNo", sugarNo);
                Log.d ("Sugar1", sugarNo);
                addActivityItems.putString("mealSelected", mealSelected);
                addActivityItems.putInt("mealPosition", mealPosition);
                addActivityItems.putStringArray("mealArray", meal);


                FragmentManager fM = getActivity().getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                Home h= new Home();
                h.setArguments(addActivityItems);
                fT.replace(R.id.frame_layout, h);
                fT.commit();*/

            }
        });

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_addbs:
                String sugarNo = sugarTxt.getText().toString();
                String mealSelected = spin1.getSelectedItem().toString();
                int mealPosition = spin1.getSelectedItemPosition();
                Log.d ("Selected Value: ", mealSelected  + mealPosition) ;
                //Array
                Log.d ("Meal Array: ", Arrays.toString(meal));

                Bundle addActivityItems = new Bundle();
                addActivityItems.putString("sugarNo", sugarNo);
                Log.d ("Sugar1", sugarNo);
                addActivityItems.putString("mealSelected", mealSelected);
                addActivityItems.putInt("mealPosition", mealPosition);
                addActivityItems.putStringArray("mealArray", meal);


                FragmentManager fM = getActivity().getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                Home h= new Home();
                h.setArguments(addActivityItems);


                fT.replace(R.id.frame_layout, h);
                fT.commit();
                Toast.makeText(getActivity(), "Add!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Created by Mharjorie Sandel on 11/03/2018.
     */


}
