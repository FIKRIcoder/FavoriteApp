package com.example.favoriteapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.favoriteapp.model.MoviesModel;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView imgMovie = findViewById(R.id.img_movie);
        TextView txtDate = findViewById(R.id.txt_date);
        TextView txtOverview = findViewById(R.id.txt_desc);
        TextView txtTitle = findViewById(R.id.txt_title);
        Intent intent = getIntent();
        if (intent != null) {
            MoviesModel movie = intent.getParcelableExtra("movies");
            if (movie != null) {
                txtTitle.setText(movie.getTitle());
                txtDate.setText(movie.getDate());
                txtOverview.setText(movie.getDescription());
                String urlImage = "https://image.tmdb.org/t/p/w500".concat(movie.getImg());

                Glide.with(DetailActivity.this).load(urlImage).error(R.drawable.ic_launcher_background).into(imgMovie);

                if (getSupportActionBar() != null) {
                    getSupportActionBar().setDisplayShowTitleEnabled(true);
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    getSupportActionBar().setTitle(movie.getTitle());
                }
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();

    }
}
