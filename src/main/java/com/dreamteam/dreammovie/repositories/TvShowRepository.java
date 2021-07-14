package com.dreamteam.dreammovie.repositories;

import com.dreamteam.dreammovie.models.TvShow;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tv-shows", path="tv")
public interface TvShowRepository extends MongoRepository<TvShow, String> {

}
