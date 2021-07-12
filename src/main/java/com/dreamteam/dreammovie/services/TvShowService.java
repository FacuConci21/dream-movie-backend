package com.dreamteam.dreammovie.services;

import com.dreamteam.dreammovie.models.TvShows;
import com.dreamteam.dreammovie.repositories.TvShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TvShowService {

    @Autowired
    private TvShowRepository repository;

    public List<TvShows> getAll(){
        Iterable<TvShows> tvShows = repository.findAll();
        List<TvShows> listOfTvShows = new ArrayList<>();
        listOfTvShows.forEach(listOfTvShows::add);
        return listOfTvShows;
    }
}
