package com.dreamteam.dreammovie.ExternalAPI.controllers;

import com.dreamteam.dreammovie.models.TvShow;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TvExternalController {

//method to get info from from API
        /*String uri = "";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        try{
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONParser jsonParser = new JSONParser();
            JSONObject responseJson =(JSONObject) jsonParser.parse(response.body().toString());
            return new ResponseEntity(responseJson, HttpStatus.OK);
        } catch (IOException e){
            e.printStackTrace();
        } catch(InterruptedException e){
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }



    return new ResponseEntity(null, HttpStatus.NOT_FOUND);*/

}
