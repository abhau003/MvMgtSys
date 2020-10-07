package com.arunabha.springboot.dao;

import com.arunabha.springboot.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Movie> ReadAllMoviesForMatchingTheatre(int theatre_id) {
        String sql="select * from movie where theatre_id = ?";
            return (List<Movie>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Movie>(Movie.class), theatre_id);
    }
}
