package com.dreamteam.dreammovie.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document @Data
public class Movie {

    @Field
    @NotNull
    private boolean adult;

    @Field
    @NotBlank
    @JsonProperty("backdrop_path")
    private String backdropPath;

    @Field
    @NotBlank
    @JsonProperty("genre_ids")
    private long[] genreIDS;

    @Id @Field
    @NotNull private String id;

    @Field
    @NotBlank
    @JsonProperty("original_language")
    private String originalLanguage;

    @Field
    @NotBlank
    @JsonProperty("original_title")
    private String originalTitle;

    @Field
    @NotBlank
    private String overview;

    @Field
    @NotBlank
    private double popularity;

    @Field
    @NotBlank
    @JsonProperty("poster_path")
    private String posterPath;

    @Field
    @NotBlank
    @JsonProperty("release_date")
    private String releaseDate;

    @Field
    @NotBlank
    private String title;

    @Field
    @NotNull
    private boolean video;

    @Field
    @JsonProperty("ote_average")
    private double voteAverage;

    @Field
    @JsonProperty("ote_count")
    private long voteCount;
}
