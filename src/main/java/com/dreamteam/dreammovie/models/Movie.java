package com.dreamteam.dreammovie.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document @Data
public class Movie {
    @Id private String id;
    @Field private String name;
}
