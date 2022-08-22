package com.example.wellbeingapp;

import androidx.annotation.DrawableRes;

import java.io.Serializable;

public class Activity implements Serializable {

    private String name;
    private String duration;
    @DrawableRes
    private int icon = 0; // default
    private String type = null; // default

    public Activity(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
