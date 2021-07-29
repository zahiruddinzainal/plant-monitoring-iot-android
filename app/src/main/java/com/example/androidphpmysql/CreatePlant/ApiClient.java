package com.example.androidphpmysql.CreatePlant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiClient {

    private static final String BASE_URL = "http://192.168.0.106/plants/";
    private static Retrofit retrofit;

    static Retrofit getApiClient(){

        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
