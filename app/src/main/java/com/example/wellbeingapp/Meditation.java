package com.example.wellbeingapp;

public class Meditation {

    private String name;
    private String duration;

    public Meditation(String name, String duration) {
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
