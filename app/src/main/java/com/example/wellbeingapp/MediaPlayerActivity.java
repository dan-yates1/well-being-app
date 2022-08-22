package com.example.wellbeingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MediaPlayerActivity extends AppCompatActivity implements View.OnClickListener, Runnable {

    private ImageButton btnBack;
    private FloatingActionButton btnPlayPause;
    private TextView tvTitle, tvTimePlayed, tvTimeLeft;
    private Activity activity;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    private String fileName = "four_minute_meditation.mp3";
    private boolean wasPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        initInterface();
        loadActivity();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int x = (int) Math.ceil(progress / 1000f);
                int minutes = (x / 60) % 60;
                int seconds = x % 60;
                tvTimePlayed.setText(String.format("%02d:%02d", minutes, seconds));

                if (progress > 0 && mediaPlayer != null && !mediaPlayer.isPlaying()) {
                    clearMediaPlayer();
                    btnPlayPause.setImageDrawable(ContextCompat.getDrawable(MediaPlayerActivity.this, android.R.drawable.ic_media_play));
                    MediaPlayerActivity.this.seekBar.setProgress(0);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(seekBar.getProgress());
                }
            }
        });
    }

    private void loadActivity() {
        activity = (Activity) getIntent().getSerializableExtra("activity");
        if (activity != null) {
            tvTitle.setText(activity.getName());
        }
    }

    private void initInterface() {
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        btnPlayPause.setOnClickListener(this);
        tvTitle = findViewById(R.id.tvTitle);
        tvTimePlayed = findViewById(R.id.tvTimePlayed);
        tvTimeLeft = findViewById(R.id.tvTimeLeft);
        seekBar = findViewById(R.id.seekBar);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                finish();
                break;
            case R.id.btnPlayPause:
                playAudio();
                break;
        }
    }

    private void playAudio() {
        try {
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                clearMediaPlayer();
                seekBar.setProgress(0);
                wasPlaying = true;
                btnPlayPause.setImageDrawable(ContextCompat.getDrawable(MediaPlayerActivity.this, android.R.drawable.ic_media_play));
            }

            if (!wasPlaying) {

                if (mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();
                }

                btnPlayPause.setImageDrawable(ContextCompat.getDrawable(MediaPlayerActivity.this, android.R.drawable.ic_media_pause));

                AssetFileDescriptor descriptor = getAssets().openFd(fileName);
                mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
                descriptor.close();

                mediaPlayer.prepare();
                mediaPlayer.setVolume(0.5f, 0.5f);
                mediaPlayer.setLooping(false);
                seekBar.setMax(mediaPlayer.getDuration());

                mediaPlayer.start();
                new Thread(this).start();
            }

            wasPlaying = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        int currentPosition = mediaPlayer.getCurrentPosition();
        int total = mediaPlayer.getDuration();

        while (mediaPlayer != null && mediaPlayer.isPlaying() && currentPosition < total) {
            try {
                Thread.sleep(1000);
                currentPosition = mediaPlayer.getCurrentPosition();
            } catch (InterruptedException e) {
                return;
            } catch (Exception e) {
                return;
            }
            seekBar.setProgress(currentPosition);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        clearMediaPlayer();
    }

    private void clearMediaPlayer() {
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}