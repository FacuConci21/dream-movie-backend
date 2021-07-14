package com.dreamteam.dreammovie.controllers;

import com.dreamteam.dreammovie.models.Movie;
import com.dreamteam.dreammovie.models.TvShow;
import com.dreamteam.dreammovie.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping(value = "/movies")
    public ResponseEntity<Movie> getAll() {
        List<Movie> movies = this.moviesService.getAll();
        if( movies.isEmpty()){
            return new ResponseEntity(movies, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(movies, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@Valid @PathVariable String id) {
        Optional<Movie> showFinded = this.moviesService.getMovieById(id);
        if (showFinded.isEmpty()){
            return new ResponseEntity(showFinded,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(showFinded, HttpStatus.OK);
        }
    }

    @PostMapping(value="/movies/create")
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie) {
        Movie newMovie = this.moviesService.createMovie(movie);
        return new ResponseEntity(movie, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/movies/delete/{id}")
    public ResponseEntity<Movie> deleteMovie(@Valid @PathVariable String id){
        Optional<Movie> showFinded = this.moviesService.getMovieById(id);
        if(showFinded.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            this.moviesService.deleteMovie(id);
            return new ResponseEntity( "deleted succesfully", HttpStatus.OK);
        }
    }
}
