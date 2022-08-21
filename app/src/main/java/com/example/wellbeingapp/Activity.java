package com.example.wellbeingapp;

import android.media.Image;

public class Activity {

    private String name;
    private String duration;

    public Activity(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
