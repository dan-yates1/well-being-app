package com.example.wellbeingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SelectListener {

    private TextView tvSleep, tvMeditation, tvExercise;
    private ImageView ivProfilePic;
    private ArrayList<Activity> suggestedActivitiesList;
    private RecyclerView rvSuggested;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInterface();
        populateSuggestedActivitiesList();
        initRecyclerView();
    }

    private void initRecyclerView() {
        rvSuggested.setHasFixedSize(true);
        rvSuggested.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.rv_divider));
        rvSuggested.addItemDecoration(dividerItemDecoration);
        ActivityAdapter adapter = new ActivityAdapter(suggestedActivitiesList, this);
        rvSuggested.setAdapter(adapter);
    }

    private void populateSuggestedActivitiesList() {
        suggestedActivitiesList = new ArrayList<>();
        suggestedActivitiesList.add(new Meditation("Guided Meditation 2", "4-minutes", "four_minute_meditation.mp3"));
        suggestedActivitiesList.add(new Exercise("Walk", "30-minutes"));
        suggestedActivitiesList.add(new Sleep("LOFI Mix", "1-hour"));
    }

    private void initInterface() {
        tvSleep = findViewById(R.id.tvSleep);
        tvSleep.setOnClickListener(this);
        ivProfilePic = findViewById(R.id.ivProfilePic);
        ivProfilePic.setOnClickListener(this);
        tvMeditation = findViewById(R.id.tvMeditation);
        tvMeditation.setOnClickListener(this);
        tvExercise = findViewById(R.id.tvExercise);
        tvExercise.setOnClickListener(this);
        rvSuggested = findViewById(R.id.rvActivities);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSleep:
                startActivity(new Intent(this, SleepActivity.class));
                break;
            case R.id.tvMeditation:
                startActivity(new Intent(this, MeditationActivity.class));
                break;
            case R.id.tvExercise:
                startActivity(new Intent(this, ExerciseActivity.class));
                break;
            case R.id.ivProfilePic:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void onItemClicked(Activity activity) {
        switch (activity.getType()) {
            case "meditation":
                startActivity(new Intent(this, MediaPlayerActivity.class).putExtra("activity", activity));
                break;
            case "exercise":
                break;
            case "sleep":
                break;
        }
    }
}