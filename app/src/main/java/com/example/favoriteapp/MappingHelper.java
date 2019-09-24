package com.example.favoriteapp;

import android.database.Cursor;

import com.example.favoriteapp.model.MoviesModel;

import java.util.ArrayList;

import static com.example.favoriteapp.database.DatabaseContract.MovieColumns.DATE;
import static com.example.favoriteapp.database.DatabaseContract.MovieColumns.DESCRIPTION;
import static com.example.favoriteapp.database.DatabaseContract.MovieColumns.IMG;
import static com.example.favoriteapp.database.DatabaseContract.MovieColumns.LANG;
import static com.example.favoriteapp.database.DatabaseContract.MovieColumns.ORIGINAL_TITLE;

public class MappingHelper {
    static ArrayList<MoviesModel> mapCursorToArrayList(Cursor movieCursor) {
        ArrayList<MoviesModel> moviesList = new ArrayList<>();
        while (movieCursor.moveToNext()) {
            String title = movieCursor.getString(movieCursor.getColumnIndexOrThrow(ORIGINAL_TITLE));
            String date = movieCursor.getString(movieCursor.getColumnIndexOrThrow(DATE));
            String image = movieCursor.getString(movieCursor.getColumnIndexOrThrow(IMG));
            String desc = movieCursor.getString(movieCursor.getColumnIndexOrThrow(DESCRIPTION));
            String language = movieCursor.getString(movieCursor.getColumnIndexOrThrow(LANG));
            moviesList.add(new MoviesModel(title,image,date,desc,language));
        }

        return moviesList;
    }
}

