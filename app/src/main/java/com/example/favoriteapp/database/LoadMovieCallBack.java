package com.example.favoriteapp.database;

import android.database.Cursor;

public interface LoadMovieCallBack {
    void postExecute(Cursor movies);
}
