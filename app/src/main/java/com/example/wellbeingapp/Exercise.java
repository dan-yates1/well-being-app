package com.example.wellbeingapp;

public class Exercise extends Activity {

    public Exercise(String name, String duration) {
        super(name, duration);
        setType("exercise");
        setIcon(R.drawable.ic_exercise);
    }
}
