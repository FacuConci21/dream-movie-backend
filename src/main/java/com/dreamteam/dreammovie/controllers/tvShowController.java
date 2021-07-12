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
    public ResponseEntity<TvShows> getAll() {
        List<TvShows> tvShows = tvShowService.getAll();
        if( tvShows.isEmpty()){
            return new ResponseEntity(tvShows, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(tvShows, HttpStatus.OK);
        }
    }

    @GetMapping(value="/tv/{id}")
    public ResponseEntity<TvShows> getShowById(@Valid @PathVariable String id){
        Optional<TvShows> showFinded = tvShowService.getTvShowById(id);
        if (showFinded.isEmpty()){
            return new ResponseEntity(showFinded,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity( showFinded, HttpStatus.OK);
        }
    }

    @PostMapping(value="/tv/create")
    public ResponseEntity<TvShows> createTvShow(@Valid @RequestBody TvShows tvShow){
        TvShows tvShowCreated = tvShowService.createTvShow(tvShow);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping(value="/tv/delete/{id}")
    public ResponseEntity<TvShows> deleteTvShow(@Valid @PathVariable String id){
        Optional<TvShows> showFinded = tvShowService.getTvShowById(id);
        if(showFinded.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            tvShowService.deleteTvShow(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
}
