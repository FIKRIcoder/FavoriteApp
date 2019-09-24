package com.example.favoriteapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.favoriteapp.DetailActivity;
import com.example.favoriteapp.R;
import com.example.favoriteapp.model.MoviesModel;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private ArrayList<MoviesModel> movieArrayList;
    private Context context;

    public RecycleViewAdapter(ArrayList<MoviesModel> movieArrayList, Context context) {
        this.movieArrayList = movieArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MoviesModel movie = movieArrayList.get(position);
        holder.txtDate.setText(movie.getDate());
        holder.txtDes.setText(movie.getDescription());
        holder.txtTitle.setText(movie.getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500".concat(movie.getImg())).into(holder.imgPoster);
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDetail = new Intent(context, DetailActivity.class);
                intentDetail.putExtra("movies", movie);
                context.startActivity(intentDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView txtTitle;
        TextView txtDes;
        TextView txtDate;
        CardView container;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_movie);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtDes = itemView.findViewById(R.id.txt_desc);
            txtDate = itemView.findViewById(R.id.txt_date);
            container = itemView.findViewById(R.id.card_view);
        }
    }
}

