package com.example.food.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.SearchView;

import com.example.food.R;
import com.example.food.RecipeAdapter;
import com.example.food.apis.APIClient;
import com.example.food.fragments.BreakfastRecipeFragment;
import com.example.food.fragments.DinnerRecipeFragment;
import com.example.food.fragments.LunchRecipeFragment;
import com.example.food.root;
import com.example.food.utils.APICredentials;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        assert navHostFragment != null;

        loadFragment(new BreakfastRecipeFragment());

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.breakfastNav:
                        fragment = new BreakfastRecipeFragment();
                        break;

                    case R.id.lunchNav:
                        fragment = new LunchRecipeFragment();
                        break;

                    case R.id.dinnerNav:
                        fragment = new DinnerRecipeFragment();
                        break;
                }

                return loadFragment(fragment);
            }
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainerView, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}