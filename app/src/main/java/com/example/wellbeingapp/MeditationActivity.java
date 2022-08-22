package com.example.wellbeingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MeditationActivity extends AppCompatActivity implements View.OnClickListener, SelectListener {

    private ImageButton btnBack;
    private RecyclerView rvMeditation, rvBodyMeditation;
    private ArrayList<Activity> meditationList, bodyMeditationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);

        initInterface();
        populateMeditationList();
        initMeditationRecyclerView();
        populateBodyMeditationList();
        initBodyMeditationRecyclerView();
    }

    private void initBodyMeditationRecyclerView() {
        rvBodyMeditation.setHasFixedSize(true);
        rvBodyMeditation.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.rv_divider));
        rvBodyMeditation.addItemDecoration(dividerItemDecoration);
        ActivityAdapter adapter = new ActivityAdapter(bodyMeditationList, this);
        rvBodyMeditation.setAdapter(adapter);
    }

    private void populateBodyMeditationList() {
        bodyMeditationList = new ArrayList<>();
        bodyMeditationList.add(new Meditation("Body Meditation 1", "12-minutes", "body_scan_meditation.mp3"));
    }

    private void initMeditationRecyclerView() {
        rvMeditation.setHasFixedSize(true);
        rvMeditation.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.rv_divider));
        rvMeditation.addItemDecoration(dividerItemDecoration);
        ActivityAdapter adapter = new ActivityAdapter(meditationList, this);
        rvMeditation.setAdapter(adapter);
    }

    private void populateMeditationList() {
        meditationList = new ArrayList<>();
        meditationList.add(new Meditation("Guided Meditation 1", "1-minute", "one_minute_meditation.mp3"));
        meditationList.add(new Meditation("Guided Meditation 2", "4-minutes", "four_minute_meditation.mp3"));
        meditationList.add(new Meditation("Guided Meditation 3", "10-minutes", "ten_minute_meditation.mp3"));
        meditationList.add(new Meditation("Guided Meditation 4", "15-minutes", "fifteen_minute_meditation.mp3"));
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

    @Override
    public void onItemClicked(Activity activity) {
        startActivity(new Intent(this, MediaPlayerActivity.class).putExtra("activity", activity));
    }
}