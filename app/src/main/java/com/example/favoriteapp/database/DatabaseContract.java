package com.example.favoriteapp.database;

import android.net.Uri;
import android.provider.BaseColumns;

public class DatabaseContract {
    private static final String AUTHORITY = "com.example.moviecatalog3";
    private static final String SCHEME = "content";

    public static final class MovieColumns implements BaseColumns {
        private static final String TABLE_NAME = "tb_movie";
        public static final String ORIGINAL_TITLE = "original_tittle";
        public static final String DATE = "original_date";
        public  static final String DESCRIPTION = "original_description";
        public  static final String LANG = "original_lang";
        public  static final String IMG = "original_img";
        public static final Uri CONTENT_URI = new Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build();
    }
}
