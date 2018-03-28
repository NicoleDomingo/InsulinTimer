package com.example.asus.insulintimer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Asus on 3/10/2018.
 */

public class AlarmAdapter extends RecyclerView.Adapter <AlarmAdapter.MyViewHolder> {
    private List<AlarmData> alarmArrayList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView timeTxt, dayTxt;


        public MyViewHolder(View view) {
            super(view);
            timeTxt = (TextView) view.findViewById(R.id.tv_time);
            dayTxt = (TextView) view.findViewById(R.id.tv_alarm);
        }
    }


    public AlarmAdapter(List<AlarmData> alarmArrayList) {
        this.alarmArrayList = alarmArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alarm_layout,parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        AlarmData al = alarmArrayList.get(position);
        holder.dayTxt.setText(al.getDay());
        holder.timeTxt.setText(al.getHour() + ":" + al.getMinute() + "");


    }

    @Override
    public int getItemCount() {
        return alarmArrayList.size();
    }
}
    /*public AlarmAdapter(List<AlarmData> alarmArrayList) {

            this.alarmArrayList = alarmArrayList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedulelist,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }


    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView timeTxt;
        private TextView dayTxt;

        public ListViewHolder(View itemView) {
            super(itemView);
            timeTxt = (TextView) itemView.findViewById(R.id.timeTxt);
            dayTxt = (TextView) itemView.findViewById(R.id.dayTxt);
            itemView.setOnClickListener(this);
        }



        public void bindView(int position){
          AlarmData alarm = alarmArrayList.get(position);
          dayTxt.setText(alarm.getDay());
          timeTxt.setText(alarm.getHour() + ":" + alarm.getMinute() + "");

        }

        @Override
        public void onClick(View view) {

        }
    }
    @Override
    public int getItemCount() {
        return alarmArrayList.size();
    }*/

