package com.example.wellbeingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvSleep, tvMeditation, tvExercise;
    private ImageView ivProfilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initInterface();
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
}