package com.example.flixster20;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import models.Movie;

public class MovieAdapter extends RecyclerView.ViewHolder {
    public MovieAdapter(String aThis) {
        super();
    }

    public class MovieAdapter extends RecyclerView.Adapter<com.example.flixster20.MovieAdapter>;
    ViewHolder {


        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tvTitle =itemView.findViewById(R.id.tvTitle);
            tvOverview =itemView.findViewById(R.id.tvOverview);
            ivPoster =itemView.findViewById(R.id.ivPoster);

        }
    }

}
