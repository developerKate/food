package com.example.food.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.food.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferences;

    private TextView calories, BMI, diet, healthText, excludedText;
    private Button btn;

    private List<String> health, excluded;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> dietDeserializer = new HashMap<String, String>();
        dietDeserializer.put("balanced", "Сбалансированная");
        dietDeserializer.put("high-protein", "С высоким содержание белка");
        dietDeserializer.put("low-carb", "С низким содержанием углеводов");
        dietDeserializer.put("low-fat", "С низким содержание жиров");

        health = new ArrayList<>();
        health.add("vegetarian");
        health.add("vegan");
        health.add("red-meat-free");
        health.add("No-oil-added");
        health.add("low-sugar");
        health.add("gluten-free");
        health.add("dairy-free");
        health.add("fish-free");

        Map<String, String> healthDeserializer = new HashMap<String, String>();
        healthDeserializer.put("vegetarian", "вегетарианец");
        healthDeserializer.put("vegan", "веган");
        healthDeserializer.put("red-meat-free", "без красного мяса");
        healthDeserializer.put("No-oil-added", "без масла");
        healthDeserializer.put("low-sugar", "без простых сахаров");
        healthDeserializer.put("gluten-free", "без глютена");
        healthDeserializer.put("dairy-free", "без лактозы");
        healthDeserializer.put("fish-free", "без рыбы");

        excluded = new ArrayList<>();
        excluded.add("milk");
        excluded.add("cheese");
        excluded.add("nuts");
        excluded.add("egg");
        excluded.add("mushrooms");
        excluded.add("chocolate");
        excluded.add("honey");
        excluded.add("coffee");

        Map<String, String> excludedDeserializer = new HashMap<String, String>();
        excludedDeserializer.put("milk", "молоко");
        excludedDeserializer.put("cheese", "сыр");
        excludedDeserializer.put("nuts", "орехи");
        excludedDeserializer.put("egg", "яйца");
        excludedDeserializer.put("mushrooms", "грибы");
        excludedDeserializer.put("chocolate", "шоколад");
        excludedDeserializer.put("honey", "мед");
        excludedDeserializer.put("coffee", "кофе");


        calories = findViewById(R.id.calories);
        BMI = findViewById(R.id.BMI);
        btn = findViewById(R.id.button);
        diet = findViewById(R.id.dietTextView);
        healthText = findViewById(R.id.healthTextView);
        excludedText =findViewById(R.id.excludedTextView);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecipeActivity.class);
                startActivity(intent);
            }
        });

        preferences = getSharedPreferences("settings", Context.MODE_PRIVATE);

        if (preferences.contains("BMI")) {
            int bmi = preferences.getInt("BMI", 0);
            calories.setText("Калории на день: " + bmi);
            int b = (int)(bmi * 0.3 / 4);
            int m = (int)(bmi * 0.3 / 9);
            int i = (int)(bmi * 0.4 / 4);

            BMI.setText("БЖУ: " + Integer.toString(b) + ", " + Integer.toString(m) + ", " + Integer.toString(i));
        }

        if (preferences.contains("diet")){
            diet.setText("Тип питания: " + dietDeserializer.get(preferences.getString("diet", "balanced")));
        }

        StringBuilder healthString = new StringBuilder();
        healthString.append("Ограничения по здоровью: ");
        for(int i = 0; i < health.size(); i++) {
            if(preferences.contains(health.get(i))){
                if (preferences.getBoolean(health.get(i), false)){
                    healthString.append(healthDeserializer.get(health.get(i))).append(", ");
                }
            }
        }

        healthText.setText(healthString);

        StringBuilder excludedString = new StringBuilder();
        excludedString.append("Исключенные продукты: ");
        for(int i = 0; i < excluded.size(); i++) {
            if(preferences.contains(excluded.get(i))){
                if (preferences.getBoolean(excluded.get(i), false)){
                    excludedString.append(excludedDeserializer.get(excluded.get(i))).append(", ");
                }
            }
        }

        excludedText.setText(excludedString);

    }

    public void goToCalculatorBMI(View view){
        Intent intent = new Intent(this, CalculatorBMIActivity.class);
        startActivity(intent);
    }

}