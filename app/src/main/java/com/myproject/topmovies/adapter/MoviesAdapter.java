package com.myproject.topmovies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myproject.topmovies.R;
import com.myproject.topmovies.model.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Movie> movieList;


    public MoviesAdapter(Context mContext, List<Movie> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @Override
    public MoviesAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_card, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MoviesAdapter.MyViewHolder viewHolder, int i) {

        viewHolder.title.setText(movieList.get(i).getOriginalTitle());
        String vote = Double.toString(movieList.get(i).getVoteAverage());
        viewHolder.userRating.setText("Vote Average: " + vote);
        viewHolder.synopsis.setText(movieList.get(i).getOverview());
        viewHolder.dateOfRelease.setText(movieList.get(i).getReleaseDate());

        String poster = "https://image.tmdb.org/t/p/w500" + movieList.get(i).getPosterPath();
        Glide.with(mContext)
                .load(poster)
                .into(viewHolder.poster);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, userRating, dateOfRelease, synopsis;
        public ImageView poster;

        public MyViewHolder(final View view) {

            super(view);

            title = (TextView) view.findViewById(R.id.title);
            userRating = (TextView) view.findViewById(R.id.user_rating);
            poster = (ImageView) view.findViewById(R.id.poster);
            dateOfRelease = (TextView) view.findViewById(R.id.release_date);
            synopsis = (TextView) view.findViewById(R.id.overview);
        }
    }
}
