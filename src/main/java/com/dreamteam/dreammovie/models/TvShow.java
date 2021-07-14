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
    @JsonIgnore
    @Id private String id;

    @Field
    @NotBlank
    private String name;

    @JsonProperty("number_of_episodes")
    @NotNull
    @Field short numberOfEpisodes;

    @JsonProperty("number_of_seasons")
    @NotNull
    @Field byte numberOfSeasons;

    @JsonProperty("poster_path")
    @NotBlank
    @Field String poster;

}
