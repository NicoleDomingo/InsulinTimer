package com.example.asus.insulintimer;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Asus on 3/14/2018.
 */

public class Help extends Fragment{

    private String ques[] = {"How can I add my blood sugar reading?", "How can I add my blood sugar reading?",
    "How can I add my blood sugar reading?", "How can I add my blood sugar reading?"};
    private Spinner spin;
    private ArrayAdapter<String> quesadapter;

    public static Help newInstance() {
        Help fragment = new Help();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.help_layout);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.help_layout, container, false);
        getActivity().setTitle("Help");

        spin = (Spinner) view.findViewById(R.id.quesspin);
        quesadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, ques);
        spin.setAdapter(quesadapter);
        return view;
    }

}
