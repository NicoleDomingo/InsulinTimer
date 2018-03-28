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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Home extends Fragment {
    private List<Tip> tipList= new ArrayList<>();
    private RecyclerView recyclerView;
    private TipAdapter tipAdapter;
    private Spinner spin;
    private ImageView iv;
    private Button tap, min, max, down;
    private ScrollView sv;
    private String days[] = {"Today", "Last 7 days", "Last 30 days", "Last 90 days"};
    private ArrayAdapter<String> daysadapter;

    public static Home newInstance() {
        Home fragment = new Home();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_layout, container, false);
        getActivity().setTitle("Home");

        Bundle sugar = getArguments();

        if(sugar != null){
            String s = sugar.getString("sugarNo");
            Log.d("Value:", s);
            TextView sugarValue = (TextView) view.findViewById(R.id.tv_bs);
            sugarValue.setText(s);

        }

        //recycler view
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        tipAdapter = new TipAdapter(tipList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tipAdapter);
        prepareData();

        //data
        spin = (Spinner) view.findViewById(R.id.spin);
        iv = (ImageView) view.findViewById(R.id.imageView);
        sv = (ScrollView) view.findViewById(R.id.scroll);
        sv.smoothScrollTo(0,view.getTop());
        tap = (Button) view.findViewById(R.id.b_tap);
        min = (Button) view.findViewById(R.id.b_min);
        min.getBackground().setAlpha(64);
        max = (Button) view.findViewById(R.id.b_max);
        max.getBackground().setAlpha(64);
        down = (Button) view.findViewById(R.id.b_down);
        down.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                sv.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
        tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fM = getActivity().getSupportFragmentManager();
                FragmentTransaction fT = fM.beginTransaction();
                AddActivity add= new AddActivity();

                fT.replace(R.id.frame_layout, add);
                fT.commit();

                // /Intent addIntent = new Intent(getContext(), AddActivity.class);
                //startActivity(addIntent);
                Toast.makeText(getContext(), "Home!", Toast.LENGTH_SHORT).show();

            }
        });

        daysadapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, days);
        spin.setAdapter(daysadapter);
        return view;
    }
    private void prepareData() {
        Tip t = new Tip("What Testing Can Tell You", "Why checking at new times can help.");
        tipList.add(t);

        t = new Tip("3 Worthy Breakfast Oats", "Try these diabetes-friendly oatmeal bowls!");
        tipList.add(t);
        tipAdapter.notifyDataSetChanged();
    }

}