package com.dreamteam.dreammovie.controllers;

import com.dreamteam.dreammovie.models.Movie;
import com.dreamteam.dreammovie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;


    @GetMapping(value="/")
    public ResponseEntity<Movie> getAll() {
        HashMap<String, List<Movie>> hash = new HashMap<>();
        List<Movie> tvShows = movieService.getAll();
        if( tvShows.isEmpty()){
            return new ResponseEntity(tvShows, HttpStatus.NOT_FOUND);
        } else {
            hash.put("response", tvShows);
            return new ResponseEntity(hash, HttpStatus.OK);
        }
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Movie> getMovieById(@Valid @PathVariable long id){
        Optional<Movie> showFinded = movieService.getMovieById(Long.toString(id));
        if (showFinded.isEmpty()){
            return new ResponseEntity(showFinded,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity( showFinded, HttpStatus.OK);
        }
    }

    @PostMapping(value="/create")
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie){
        Movie tvShowCreated = movieService.createMovie(movie);
        return new ResponseEntity(tvShowCreated, HttpStatus.CREATED);
    }

    @PatchMapping(value="/{id}")
    public ResponseEntity<Movie> modifyMovie(@Valid @PathVariable long id, @Valid @RequestBody Movie movie){
        boolean showExist = movieService.existMovie(Long.toString(id));
        if(showExist){
            movieService.modifyMovie(Long.toString(id), movie);
            return new ResponseEntity( movie,HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Movie> deleteMovie(@Valid @PathVariable long id){
        boolean movieExist = movieService.existMovie(Long.toString(id));
        if(movieExist){
            movieService.deleteMovie(Long.toString(id));
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
