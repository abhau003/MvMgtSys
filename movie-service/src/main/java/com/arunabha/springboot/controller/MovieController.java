package com.arunabha.springboot.controller;

import com.arunabha.springboot.model.Movie;
import com.arunabha.springboot.model.MovieDetails;
import com.arunabha.springboot.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(method= RequestMethod.GET,value="movie-details/{id}")
    public MovieDetails GetAllMoviesMatchingTheatreController(@PathVariable int id) {
     //  return (List<Movie>) movieService.GetAllMoviesMatchingTheatreService(id);
    List<Movie> movies = (List<Movie>) movieService.GetAllMoviesMatchingTheatreService(id);
    MovieDetails movieDetails = new MovieDetails();
    movieDetails.setMovieDetails(movies);
    return movieDetails;
    }
}
