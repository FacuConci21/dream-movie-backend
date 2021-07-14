package com.dreamteam.dreammovie.services;

import com.dreamteam.dreammovie.models.Movie;
import com.dreamteam.dreammovie.models.TvShow;
import com.dreamteam.dreammovie.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movie> getAll() {
        Iterable<Movie> movies = this.moviesRepository.findAll();
        List<Movie> moviesList = new ArrayList<>();
        movies.forEach(moviesList::add);
        return moviesList;
    }

    public Optional<Movie> getMovieById(String id) {
        Optional<Movie> showFinded = this.moviesRepository.findById(id);
        return showFinded;
    }

    public Movie createMovie(Movie movie) {
        return this.moviesRepository.save(movie);
    }

    public void deleteMovie(String id){
        this.moviesRepository.deleteById(id);
    }
}
