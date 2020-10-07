package com.arunabha.springboot.dao;

import com.arunabha.springboot.model.Movie;
import com.arunabha.springboot.model.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TheatreDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Theatre ReadMatchingTheatre(int theatreid) {
        String sql="select * from theatre where theatre_id=?";
        String sql_new="select count(*) from theatre where theatre_id=?";
        int count = jdbcTemplate.queryForObject(sql_new, Integer.class,theatreid);
        if (count != 0)
                return (Theatre) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Theatre>(Theatre.class), theatreid);
        else {
            Theatre theatre = new Theatre();
            theatre.setTheatre_id(0);
            theatre.setTheatre_name("Requested Resource Not Available");
            theatre.setMovieList(null);
            return theatre;
        }
    }
}
