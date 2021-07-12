package com.dreamteam.dreammovie.services;

import com.dreamteam.dreammovie.models.TvShows;
import com.dreamteam.dreammovie.repositories.TvShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TvShowService {

    @Autowired
    private TvShowRepository repository;

    public List<TvShows> getAll(){
        Iterable<TvShows> tvShows = repository.findAll();
        List<TvShows> listOfTvShows = new ArrayList<>();
        tvShows.forEach(listOfTvShows::add);
        return listOfTvShows;
    }

    public Optional<TvShows> getTvShowById (String id){
        Optional<TvShows> showFinded = repository.findById(id);
        return showFinded;
    }

    public TvShows createTvShow(TvShows tvShow){
        return repository.save(tvShow);
    }



    public void deleteTvShow(String id){
        repository.deleteById(id);
    }
}
