package com.example.wellbeingapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ViewHolder> {

    private ArrayList<Activity> activityArrayList;
    private SelectListener listener;

    public static class ViewHolder extends  RecyclerView.ViewHolder {
        private TextView tvTitle, tvDuration;
        private ImageView ivIcon;
        private ConstraintLayout clMain;

        public ViewHolder(@NonNull View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tvActivity);
            tvDuration = view.findViewById(R.id.tvTime);
            clMain = view.findViewById(R.id.clMain);
            ivIcon = view.findViewById(R.id.ivActivity);
        }
    }

    public ActivityAdapter(ArrayList<Activity> activityArrayList, SelectListener listener) {
        this.activityArrayList = activityArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ActivityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_activity, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvTitle.setText(activityArrayList.get(position).getName());
        holder.tvDuration.setText(activityArrayList.get(position).getDuration());
        holder.ivIcon.setImageResource(activityArrayList.get(position).getIcon());

        holder.clMain.setOnClickListener(view -> listener.onItemClicked(activityArrayList.get(position)));
    }

    @Override
    public int getItemCount() {
        return activityArrayList.size();
    }
}
