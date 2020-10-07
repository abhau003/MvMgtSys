package com.arunabha.springboot.controller;

import com.arunabha.springboot.model.Movie;
import com.arunabha.springboot.model.MovieDetails;
import com.arunabha.springboot.model.Theatre;
import com.arunabha.springboot.service.TheatreService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TheatreController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TheatreService theatreService;

    @RequestMapping(method= RequestMethod.GET,value="/theatre/{theatreid}")
    @HystrixCommand(fallbackMethod = "failedmoviedetails")
    public Theatre GetMatchingTheatreCityController(@PathVariable int theatreid ) {
        //return (Theatre) theatreService.GetMatchingCityMatchingTheatreService(theatreid);
        String url = "http://movie-service/movie-details/" + theatreid;
        System.out.println("URL: " +url);
        List<Movie> movies = (List<Movie>) restTemplate.getForObject(url, MovieDetails.class).getMovieDetails();
        System.out.println("After accessing RestTemplate");
        Theatre theatre = theatreService.GetTheatreDetails(theatreid);
        System.out.println("After accessing TheatreService");
        System.out.println("TheatreController.GetMatchingTheatreCityController" + theatre);
        System.out.println("TheatreController.GetMatchingTheatreCityController" + movies);
        theatre.setMovieList(movies);
        if (theatre != null)
            theatre.setMsg("Theatre Data Fetched Successfully");
        else
            theatre.setMsg("Theatre Doesn't Exist");
        System.out.printf("Theatre: "+ theatre);
        System.out.println("Before returning Theatre from Main");
        return theatre;
        //return "Return Successful";
    }

    public Theatre failedmoviedetails(int theatreid){
        System.out.println("Movie API is Down, Please try Later !!!");
        //return "Movie API is Down, Please try Later !!!";
        //Theatre theatre = new Theatre();
        //theatre.setMsg("Movie API is Down, Cannot fetch Movie Details for Theatre with Theatre-ID: "+theatreid + "Please try Later !!!");
        //return theatre;
        System.out.println("Before returning Theatre from fallback");
        Theatre theatre = new Theatre();
        theatre.setMsg("Movie API is under Maintenance, please check back Later");
        return theatre;
    }
}
