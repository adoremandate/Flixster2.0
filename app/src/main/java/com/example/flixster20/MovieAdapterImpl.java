package com.example.flixster20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import models.Movie;

public class MovieAdapterImpl extends MovieAdapter.MovieAdapter {
    @NonNull
    @Override
    public MovieAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView;
        movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(movieView);
        MovieAdapter movieAdapter = (MovieAdapter) viewHolder;
        return movieAdapter;

    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter holder, int position) {
        Movie movie =movies.get(position);
        holder.bind(movie);



    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public Viewholder(@NonNull View itemView) {
        super(itemView);
        tvTitle =itemView.findViewById(R.id.tvTitle);
        tvOverview =itemView.findViewById(R.id.tvOverview);
        ivPoster =itemView.findViewById(R.id.ivPoster);

    }
    Context context;
    List<Movie> movies;

    public MovieAdapterImpl(Context context, List<Movie> movies) {
  this.context = context;
    this.movies =movies;
    }

    {
        Context context;
        List<Movie> movies;

        public void bind(Movie movie);{
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            Glide.with(context.load(movie.getPosterpath()).into(ivPoster)


    }

    }
}
