package com.example.androidphpmysql.CreatePlant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("get_plants.php")
    Call<List<com.example.androidphpmysql.CreatePlant.Plants>> getPlants();

    @FormUrlEncoded
    @POST("add_plants.php")
    Call<com.example.androidphpmysql.CreatePlant.Plants> insertPlants(
            @Field("key") String key,
            @Field("name") String name,
            @Field("species") String species,
            @Field("breed") String breed,
            @Field("gender") int gender,
            @Field("birth") String birth,
            @Field("picture") String picture);

    @FormUrlEncoded
    @POST("update_plants.php")
    Call<com.example.androidphpmysql.CreatePlant.Plants> updatePlants(
            @Field("key") String key,
            @Field("id") int id,
            @Field("name") String name,
            @Field("species") String species,
            @Field("breed") String breed,
            @Field("gender") int gender,
            @Field("birth") String birth,
            @Field("picture") String picture);

    @FormUrlEncoded
    @POST("delete_plants.php")
    Call<com.example.androidphpmysql.CreatePlant.Plants> deletePlants(
            @Field("key") String key,
            @Field("id") int id,
            @Field("picture") String picture);

    @FormUrlEncoded
    @POST("update_love.php")
    Call<com.example.androidphpmysql.CreatePlant.Plants> updateLove(
            @Field("key") String key,
            @Field("id") int id,
            @Field("love") boolean love);

}
