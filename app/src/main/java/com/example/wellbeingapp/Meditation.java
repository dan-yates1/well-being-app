package com.example.wellbeingapp;

public class Meditation extends Activity {

    private String fileName;

    public Meditation(String name, String duration, String fileName) {
        super(name, duration);
        this.fileName = fileName;
        setType("meditation");
        setIcon(R.drawable.ic_meditation);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
