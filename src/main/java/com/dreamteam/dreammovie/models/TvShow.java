package com.dreamteam.dreammovie.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Document(value = "tvShows")
@Data
public class TvShow {

    @Field
    @NotBlank
    @JsonProperty("backdrop_path")
    private String backdropPath;
    @Field
    @JsonProperty("first_air_date")
    private String firstAirDate;
    @Field
    @NotBlank
    @JsonProperty("genre_ids")
    private long[] genreIDS;

    @Id @Field
    @NotNull
    private long id;

    @Field
    @NotBlank
    private String name;

    @Field
    @NotBlank
    @JsonProperty("origin_country")
    private String[] originCountry;

    @Field
    @JsonProperty("original_language")
    private String originalLanguage;

    @Field
    @NotBlank
    @JsonProperty("original_name")
    private String originalName;

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
    @JsonProperty("ote_average")
    private double voteAverage;

    @Field
    @JsonProperty("ote_count")
    private long voteCount;
}
