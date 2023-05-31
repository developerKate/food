package com.example.food.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.food.R;
import com.example.food.RecipeAdapter;
import com.example.food.apis.APIClient;
import com.example.food.apis.RetrofitInstance;
import com.example.food.root;
import com.example.food.utils.APICredentials;
import com.example.food.utils.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LunchRecipeFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<root.Hits> recipes;
    private RecipeAdapter adapter;

    private SharedPreferences preferences;
    private List<String> health, excluded;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lunch_recipe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<String> dietList = new ArrayList<>();
        ArrayList<String> healthList = new ArrayList<>();
        ArrayList<String> mealType = new ArrayList<>();
        mealType.add("Lunch");
        ArrayList<String> excludedList = new ArrayList<>();

        preferences = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
        if (preferences.contains("diet")){
            dietList.add(preferences.getString("diet", "balanced"));
        }

        health = new ArrayList<>();
        health.add("vegetarian");
        health.add("vegan");
        health.add("red-meat-free");
        health.add("No-oil-added");
        health.add("low-sugar");
        health.add("gluten-free");
        health.add("dairy-free");
        health.add("fish-free");

        for(int i = 0; i < health.size(); i++) {
            if(preferences.contains(health.get(i))){
                if (preferences.getBoolean(health.get(i), false)){
                    healthList.add(health.get(i));
                }
            }
        }

        if(healthList.isEmpty())
            healthList.add("alcohol-free");

        excluded = new ArrayList<>();
        excluded.add("milk");
        excluded.add("cheese");
        excluded.add("nuts");
        excluded.add("egg");
        excluded.add("mushrooms");
        excluded.add("chocolate");
        excluded.add("honey");
        excluded.add("coffee");

        for(int i = 0; i < excluded.size(); i++) {
            if(preferences.contains(excluded.get(i))){
                if (preferences.getBoolean(excluded.get(i), false)){
                    excludedList.add(excluded.get(i));
                }
            }
        }

        if(excludedList.isEmpty())
            excludedList.add("bear");

        String calories = "";
        if (preferences.contains("BMI")) {
            int bmi = preferences.getInt("BMI", 0);
            calories = Integer.toString(bmi / 3 - 100) + "-" + Integer.toString(bmi/3 + 100);
        }


        recyclerView = view.findViewById(R.id.recipe_recycler);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(view.getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipes.get(position).getRecipe().getUrl()));
                        startActivity(browserIntent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        Retrofit retrofit = RetrofitInstance.getInstance();
        APIClient apiClient = retrofit.create(APIClient.class);
        Call<root> searchRecipesCall = apiClient.searchRecipes(APICredentials.TYPE,
                "", APICredentials.APP_ID, APICredentials.API_KEY, true,
                "en", dietList, healthList, mealType, calories, excludedList);

        searchRecipesCall.enqueue(new Callback<root>() {
            @Override
            public void onResponse(Call<root> call, Response<root> response) {
                if (response.isSuccessful() && response.body() != null) {
                    recipes = response.body().getHits();
                    int size = recipes.size();
                    if (size > 10){
                        size = 10;
                    }
                    for (int i = 0; i < size; i++) {
                        root.Hits recipe = recipes.get(i);
                        Log.d("RECIPE", recipe.getRecipe().getUrl());
                        recipes.add(recipe);
                    }
                    recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                    recyclerView.setHasFixedSize(true);
                    adapter = new RecipeAdapter(view.getContext(), recipes);
                    recyclerView.setAdapter(adapter);
                }else{
                    Log.d("RECIPE", "НЕТ РЕЦЕПТОВ");
                }
            }

            @Override
            public void onFailure(Call<root> call, Throwable t) {
                Log.v("Tag", t.getMessage().toString());
            }
        });
    }
}