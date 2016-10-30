package com.firman.swipetodismiss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup RecyclerView
        RecyclerView movieRecyclerView = (RecyclerView) findViewById(R.id.movie_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        movieRecyclerView.setLayoutManager(linearLayoutManager);

        // Setup Adapter
        MovieAdapter movieAdapter = new MovieAdapter(this, getMovies());
        movieRecyclerView.setAdapter(movieAdapter);

        // Setup ItemTouchHelper
        ItemTouchHelper.Callback callback = new MovieTouchHelper(movieAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(movieRecyclerView);
    }

    private List<Movie> getMovies(){
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Janda Kembang"));
        movieList.add(new Movie("Warkop DKI Reborn"));
        movieList.add(new Movie("Goyang Dumang"));
        movieList.add(new Movie("Goyang Karawang"));
        movieList.add(new Movie("Casion Royale Comic 8"));
        return movieList;
    }
}

