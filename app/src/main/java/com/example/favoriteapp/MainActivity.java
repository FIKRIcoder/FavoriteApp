package com.example.favoriteapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.favoriteapp.adapter.RecycleViewAdapter;
import com.example.favoriteapp.database.LoadMovieCallBack;
import com.example.favoriteapp.model.MoviesModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import static com.example.favoriteapp.MappingHelper.mapCursorToArrayList;
import static com.example.favoriteapp.database.DatabaseContract.MovieColumns.CONTENT_URI;

public class MainActivity extends AppCompatActivity implements LoadMovieCallBack {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new getData(this, this).execute();
    }

    @Override
    public void postExecute(Cursor movies) {
        ArrayList<MoviesModel> moviesList = mapCursorToArrayList(movies);
        if (moviesList.size() > 0) {
            RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(moviesList, MainActivity.this);
            @SuppressLint("WrongConstant") LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recycleViewAdapter);
        }
    }


    public static class getData extends AsyncTask<Void, Void, Cursor> {
        private final WeakReference<Context> weakContext;
        private final WeakReference<LoadMovieCallBack> weakCallback;

        private getData(Context context, LoadMovieCallBack callback) {
            weakContext = new WeakReference<>(context);
            weakCallback = new WeakReference<>(callback);
        }

        @Override
        protected Cursor doInBackground(Void... voids) {
            return weakContext.get().getContentResolver().query(CONTENT_URI, null, null, null, null);
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);
            weakCallback.get().postExecute(cursor);
        }
    }
}
