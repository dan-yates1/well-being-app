package com.example.wellbeingapp;

public class Sleep extends Activity{

    public Sleep(String name, String duration) {
        super(name, duration);
        setType("sleep");
        setIcon(R.drawable.ic_sleep);
    }
}
