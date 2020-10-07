package com.arunabha.springboot.model;

import java.util.List;

public class Theatre {

    private int theatre_id;
    private String theatre_name;
    private List<Movie> movieList;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTheatre_id() {
        return theatre_id;
    }

    public void setTheatre_id(int theatre_id) {
        this.theatre_id = theatre_id;
    }

    public String getTheatre_name() {
        return theatre_name;
    }

    public void setTheatre_name(String theatre_name) {
        this.theatre_name = theatre_name;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatre_id=" + theatre_id +
                ", theatre_name='" + theatre_name + '\'' +
                ", movieList=" + movieList +
                '}';
    }
}
