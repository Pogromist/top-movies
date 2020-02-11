package com.delaroystudios.movieapp.api;

import com.delaroystudios.movieapp.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    @GET ("discover/movie")
    Call<MoviesResponse> getTopFilms (@Query("api_key") String apiKey, @Query("sort_by") String sortBy,
                                      @Query("primary_release_year") String releaseYear );

}
