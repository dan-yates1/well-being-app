package com.example.wellbeingapp;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.common.io.LineReader;

import java.util.ArrayList;

public class MeditationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnBack;
    private RecyclerView rvMeditation, rvBodyMeditation;
    private ArrayList<Meditation> meditationList;

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
        MeditationAdapter adapter = new MeditationAdapter(meditationList);
        rvMeditation.setAdapter(adapter);
    }

    private void populateMeditationList() {
        meditationList = new ArrayList<>();
        meditationList.add(new Meditation("Test 1", "10-minutes"));
        meditationList.add(new Meditation("Test 2", "15-minutes"));
        meditationList.add(new Meditation("Test 3", "20-minutes"));
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