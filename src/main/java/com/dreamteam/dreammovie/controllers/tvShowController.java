package com.dreamteam.dreammovie.controllers;

import com.dreamteam.dreammovie.models.TvShows;
import com.dreamteam.dreammovie.repositories.TvShowRepository;
import com.dreamteam.dreammovie.services.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class tvShowController {

    @Autowired
    private TvShowService tvShowService;

    @GetMapping(value="/tv")
    public ResponseEntity<TvShows> getAll () {
        List<TvShows> tvShows = tvShowService.getAll();
        if( tvShows.isEmpty()){
            return new ResponseEntity(tvShows, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(tvShows, HttpStatus.OK);
        }
    }
}
