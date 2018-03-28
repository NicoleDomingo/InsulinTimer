package com.example.asus.insulintimer;

/**
 * Created by Mharjorie Sandel on 09/03/2018.
 */

public class Tip {

    private String title;
    private String desc;

    public Tip(String title, String desc) {
        this.title = title;
        this.desc = desc;

    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }



}
