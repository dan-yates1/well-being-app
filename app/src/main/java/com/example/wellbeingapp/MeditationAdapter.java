package com.example.wellbeingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MeditationAdapter extends RecyclerView.Adapter<MeditationAdapter.ViewHolder> {

    private ArrayList<Activity> activityArrayList;

    public static class ViewHolder extends  RecyclerView.ViewHolder {
        private TextView title, duration;

        public ViewHolder(@NonNull View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.tvActivity);
            duration = (TextView) view.findViewById(R.id.tvTime);
        }
    }

    public MeditationAdapter(ArrayList<Activity> activityArrayList) {
        this.activityArrayList = activityArrayList;
    }

    @NonNull
    @Override
    public MeditationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_activity, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeditationAdapter.ViewHolder holder, int position) {
        holder.title.setText(activityArrayList.get(position).getName());
        holder.duration.setText(activityArrayList.get(position).getDuration());
    }

    @Override
    public int getItemCount() {
        return activityArrayList.size();
    }
}
