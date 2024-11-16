package com.example.atomica;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstances {

    public static final Retrofit VIDEOFIT= new Retrofit.Builder().
            baseUrl("https://yt-api.p.rapidapi.com/").addConverterFactory(GsonConverterFactory.create()).build();
}
