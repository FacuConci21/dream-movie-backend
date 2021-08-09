package com.dreamteam.dreammovie.controllers;


import com.dreamteam.dreammovie.models.TvShow;
import com.dreamteam.dreammovie.services.TvShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController @RequestMapping(value = "/api/tv")
public class tvShowController {

    @Autowired
    private TvShowService tvShowService;


    @GetMapping(value="/")
    public ResponseEntity<TvShow> getAll() {
       HashMap<String, List<TvShow>> hash = new HashMap<>();
        List<TvShow> tvShows = tvShowService.getAll();
        if( tvShows.isEmpty()){
            return new ResponseEntity(tvShows, HttpStatus.NOT_FOUND);
        } else {
            hash.put("response", tvShows);
            return new ResponseEntity(hash, HttpStatus.OK);
        }
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<TvShow> getShowById(@Valid @PathVariable long id){
        Optional<TvShow> showFinded = tvShowService.getTvShowById(Long.toString(id));
        if (showFinded.isEmpty()){
            return new ResponseEntity(showFinded,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity( showFinded, HttpStatus.OK);
        }
    }

    @PostMapping(value="/create")
    public ResponseEntity<TvShow> createTvShow(@Valid @RequestBody TvShow tvShow){
        TvShow tvShowCreated = tvShowService.createTvShow(tvShow);
        return new ResponseEntity(tvShowCreated, HttpStatus.CREATED);
    }

    @PatchMapping(value="/{id}")
    public ResponseEntity<TvShow> modifyTvShow(@Valid @PathVariable long id, @Valid @RequestBody TvShow tvShow){
        boolean showExist = tvShowService.existTvShow(Long.toString(id));
        if(showExist){
            tvShowService.modifyShow(id, tvShow);
            return new ResponseEntity( tvShow,HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<TvShow> deleteTvShow(@Valid @PathVariable long id){
        boolean showExist = tvShowService.existTvShow(Long.toString(id));
        if(showExist){
            tvShowService.deleteTvShow(Long.toString(id));
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}