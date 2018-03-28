package com.example.asus.insulintimer;

import java.sql.Time;

/**
 * Created by Asus on 3/10/2018.
 */

public class AlarmData {
    private String day;
    private int hour, minute;

    public AlarmData() {
    }

    public AlarmData(String day, int hour, int minute){
        this.day=day;
        this.hour=hour;
        this.minute=minute;
    }
    public String getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }




}
