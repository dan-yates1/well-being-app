package com.example.wellbeingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvSleep, tvMeditation, tvExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInterface();
    }

    private void initInterface() {
        tvSleep = findViewById(R.id.tvSleep);
        tvSleep.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSleep:
                startActivity(new Intent(this, SleepActivity.class));
                break;
        }
    }
}