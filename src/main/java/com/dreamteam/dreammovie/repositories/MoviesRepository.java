package com.dreamteam.dreammovie.repositories;

import com.dreamteam.dreammovie.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MoviesRepository extends MongoRepository<Movie, String> {

}
