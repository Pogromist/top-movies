package com.delaroystudios.movieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.delaroystudios.movieapp.DetailActivity;
import com.delaroystudios.movieapp.MainActivity;
import com.delaroystudios.movieapp.R;
import com.delaroystudios.movieapp.model.Movie;

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
        final MainActivity mainActivity = new MainActivity();

        viewHolder.title.setText(movieList.get(i).getOriginalTitle());
        String vote = Double.toString(movieList.get(i).getVoteAverage());
        viewHolder.userRating.setText("Vote Average: " + vote);
        viewHolder.synopsis.setText(movieList.get(i).getOverview());
        viewHolder.dateOfRelease.setText(movieList.get(i).getReleaseDate());
        /*viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.onClickMain(view);
            }
        });*/

        String poster = "https://image.tmdb.org/t/p/w500" + movieList.get(i).getPosterPath();
        Glide.with(mContext)
                .load(poster)
                .into(viewHolder.poster);

    }

    public void setMovies(List<Movie> movie) {
        movieList = movie;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, userRating, dateOfRelease, synopsis;
        public ImageView poster;
        //public Button button;

        public MyViewHolder(final View view) {

            super(view);

            title = (TextView) view.findViewById(R.id.title);
            userRating = (TextView) view.findViewById(R.id.user_rating);
            poster = (ImageView) view.findViewById(R.id.poster);
            dateOfRelease = (TextView) view.findViewById(R.id.release_date);
            synopsis = (TextView) view.findViewById(R.id.overview);
            //button = (Button) view.findViewById(R.id.btnNotify);

            /*view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        /*Movie clickedDataItem = movieList.get(pos);
                        Intent intent = new Intent(mContext, DetailActivity.class);
                        intent.putExtra("movies", clickedDataItem );
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        mContext.startActivity(intent);
                        MainActivity mainActivity = new MainActivity();
                        mainActivity.onClickMain(v);
                        Toast.makeText(v.getContext(), "You clicked ", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(v.getContext(), "You miss clicked ", Toast.LENGTH_SHORT).show();
                    }
                }
            });*/
        }
    }
}
