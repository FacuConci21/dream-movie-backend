package com.dreamteam.dreammovie.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "movies") @Data
public class Movie {

    @Id
    private String id;

    @Field @JsonProperty("original_language")
    private String originalLanguage;

    @Field @JsonProperty("original_title")
    private String originalTitle;

    @Field @JsonProperty("release_date")
    private Date releaseDate;

    @Field
    private String title;

} // Movie
