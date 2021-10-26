package com.example.flixster20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import models.Movie;
import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {
    public static final String Now_playing_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    public static final String Tag = "mainActivity";

    List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvMovies = findViewById(R.id.rvMovies);
        rvMovies.setAdapter(movies);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        movies = new ArrayList<>();

        MovieAdapter.MovieAdapter movieAdapter = new MovieAdapter.MovieAdapter("this");


        AsyncHttpClient client = new AsyncHttpClient();
        client.get(Now_playing_URL, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {
                Log.d(Tag, " Onsucess");
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results = jsonObject.getJSONArray("results");
                    Log.i(Tag, "results:"+ results.toString());
                    movies.addAll(Movie.fromJsonArray(results));
                    movieAdapter.notifyDataSetChanged();
                    Log.i(Tag, "movies:" + movies.size());

                    List<Movie> movies = Movie.fromJsonArray(results);
                } catch (JSONException e) {
                    Log.e(Tag, " Hit json exception", e);
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
               Log.d(Tag, " Onfailure");

            }
        });
    }
}