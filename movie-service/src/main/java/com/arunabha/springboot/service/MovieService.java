package com.arunabha.springboot.service;

import com.arunabha.springboot.dao.MovieDao;
import com.arunabha.springboot.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieDao movieDao;

    public List<Movie> GetAllMoviesMatchingTheatreService(int theatre_id) throws DataAccessException {
        return (List<Movie>) movieDao.ReadAllMoviesForMatchingTheatre(theatre_id);
    }
}
