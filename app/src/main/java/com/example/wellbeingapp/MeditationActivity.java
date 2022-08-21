package com.example.wellbeingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MeditationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnBack;
    private RecyclerView rvMeditation, rvBodyMeditation;
    private ArrayList<Activity> activityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);

        initInterface();
        populateMeditationList();
        initRecyclerViews();
    }

    private void initRecyclerViews() {
        rvMeditation.setHasFixedSize(true);
        rvMeditation.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        MeditationAdapter adapter = new MeditationAdapter(activityList);
        rvMeditation.setAdapter(adapter);
    }

    private void populateMeditationList() {
        activityList = new ArrayList<>();
        activityList.add(new Activity("Test 1", "10-minutes"));
        activityList.add(new Activity("Test 2", "15-minutes"));
        activityList.add(new Activity("Test 3", "20-minutes"));
    }

    private void initInterface() {
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        rvBodyMeditation = findViewById(R.id.rvBodyMeditation);
        rvMeditation = findViewById(R.id.rvMeditation);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
        }
    }
}