package com.example.food.apis;

import com.example.food.root;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface APIClient {
    @GET("/api/recipes/v2")
    Call<root> searchRecipes(@Query("type")String type,
                             @Query("q")String query,
                             @Query("app_id")String idApp,
                             @Query("app_key")String keyApp,
                             @Query("random")boolean isRandom,
                             @Header("Accept-Language")String language,
                             @Query("diet")ArrayList<String> diet,
                             @Query("health")ArrayList<String> health,
                             @Query("mealType")ArrayList<String> mealType,
                             @Query("calories")String calories,
                             @Query("excluded")ArrayList<String> excluded);

}
