package com.dreamteam.dreammovie.controllers;

import com.dreamteam.dreammovie.models.TvShows;
import com.dreamteam.dreammovie.repositories.TvShowRepository;
import com.dreamteam.dreammovie.services.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @PostMapping(value="/tv/create")
    public ResponseEntity<TvShows> createTvShow(@Valid @RequestBody TvShows tvShow){
        TvShows tvShowCreated = tvShowService.createTvShow(tvShow);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping(value="/tv/delete")
    public ResponseEntity<TvShows> deleteTvShow(@Valid @RequestParam(value="id") String id){
       try{
           tvShowService.deleteTvShow(id);
           return new ResponseEntity(HttpStatus.OK);
       } catch (Exception e){
           return new ResponseEntity(HttpStatus.NOT_FOUND);
       }

    }
}
