package com.dreamteam.dreammovie.services;

import com.dreamteam.dreammovie.models.Movie;
import com.dreamteam.dreammovie.models.TvShow;
import com.dreamteam.dreammovie.repositories.MoviesRepository;
import com.dreamteam.dreammovie.repositories.TvShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MoviesRepository repository;

    public Boolean existMovie(String id){
        return repository.existsById(id);
    }
    public List<Movie> getAll(){
        Iterable<Movie> tvShows = repository.findAll();
        List<Movie> listOfTvShows = new ArrayList<>();
        tvShows.forEach(listOfTvShows::add);
        return listOfTvShows;
    }

    public Optional<Movie> getMovieById (String id){
        Optional<Movie> movieFinded = repository.findById(id);
        return movieFinded;
    }

    public Movie modifyMovie(String id, Movie movie){
        if (movie.getId() == id ) {
            return repository.save(movie);
        }
        return null;
    }

    public Movie createMovie(Movie movie){
        return repository.save(movie);
    }

    public void deleteMovie (String id){
        repository.deleteById(id);
    }
}
