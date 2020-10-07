package com.arunabha.springboot.model;

import java.util.List;

public class MovieDetails {

    private List<Movie> movieDetails;

    public List<Movie> getMovieDetails() {
        return movieDetails;
    }

    public void setMovieDetails(List<Movie> movieDetails) {
        this.movieDetails = movieDetails;
    }

    @Override
    public String toString() {
        return "MovieDetails{" +
                "movieDetails=" + movieDetails +
                '}';
    }
}
