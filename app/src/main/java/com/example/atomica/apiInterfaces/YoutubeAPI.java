package com.example.atomica.apiInterfaces;

import com.example.atomica.reponses.VideoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface YoutubeAPI {
    @GET("search")
    Call<VideoResponse> searchVideos(
            @Query("query") String query, // Pass the query string
            @Header("X-RapidAPI-Key") String apiKey, // Add your API key as a header
            @Header("X-RapidAPI-Host") String apiHost // Add the RapidAPI host as a header
    );
}
