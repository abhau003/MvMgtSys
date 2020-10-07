package com.arunabha.springboot.service;

import com.arunabha.springboot.dao.TheatreDao;
import com.arunabha.springboot.model.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TheatreService {

    @Autowired
    private TheatreDao theatreDao;

    public Theatre GetTheatreDetails(int theatreid) {
        return (Theatre) theatreDao.ReadMatchingTheatre(theatreid);
    }
}