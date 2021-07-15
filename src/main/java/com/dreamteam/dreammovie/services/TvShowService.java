package com.dreamteam.dreammovie.services;

import com.dreamteam.dreammovie.models.TvShow;
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

    public Boolean existTvShow(String id){
       return repository.existsById(id);
    }
    public List<TvShow> getAll(){
        Iterable<TvShow> tvShows = repository.findAll();
        List<TvShow> listOfTvShows = new ArrayList<>();
        tvShows.forEach(listOfTvShows::add);
        return listOfTvShows;
    }

    public Optional<TvShow> getTvShowById (String id){
        Optional<TvShow> showFinded = repository.findById(id);
        return showFinded;
    }

    public TvShow modifyShow(String id, TvShow tvShow){
       if (tvShow.getId() == id ) {
           return repository.save(tvShow);
       }
       return null;
    }

    public TvShow createTvShow(TvShow tvShow){
        return repository.save(tvShow);
    }

    public void deleteTvShow(String id){
        repository.deleteById(id);
    }
}
