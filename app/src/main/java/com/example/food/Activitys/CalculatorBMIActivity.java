package com.example.food.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.food.Activitys.MainActivity;
import com.example.food.R;

import java.util.HashMap;
import java.util.Map;

public class CalculatorBMIActivity extends AppCompatActivity {

    EditText height, weight, age;
    RadioGroup gender;
    Spinner activity, diet;
    CheckBox vegetarian, vegan, redMeat, oil, sugar, gluten, lactose, fish, milk, cheese, nuts, egg, mushrooms, chocolate, honey, coffee;
    Button calculateButton;


    private SharedPreferences preferences;

    int BMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_bmi);

        preferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
        Intent intent = new Intent(this, MainActivity.class);

        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        activity = findViewById(R.id.activity);
        calculateButton = findViewById(R.id.calculateBtn);
        diet = findViewById(R.id.dietSpinner);
        vegetarian = findViewById(R.id.vegetarianCheckBox);
        vegan = findViewById(R.id.veganCheckBox);
        redMeat = findViewById(R.id.redMeatCheckBox);
        oil = findViewById(R.id.oilCheckBox);
        sugar = findViewById(R.id.sugarCheckBox);
        gluten = findViewById(R.id.glutenCheckBox);
        lactose = findViewById(R.id.lactoseCheckBox);
        fish = findViewById(R.id.fishCheckBox);
        milk = findViewById(R.id.milkCheckBox);
        cheese = findViewById(R.id.cheeseCheckBox);
        nuts = findViewById(R.id.nutsCheckBox);
        egg = findViewById(R.id.eggCheckBox);
        mushrooms = findViewById(R.id.mushroomsCheckBox);
        chocolate = findViewById(R.id.chocolateCheckBox);
        honey = findViewById(R.id.honeyCheckBox);
        coffee = findViewById(R.id.coffeeCheckBox);


        Map<String, String> dietSerializer = new HashMap<String, String>();
        dietSerializer.put("Сбалансированная", "balanced");
        dietSerializer.put("С высоким содержание белка", "high-protein");
        dietSerializer.put("С низким содержанием углеводов", "low-carb");
        dietSerializer.put("С низким содержание жиров", "low-fat");

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float h = Float.parseFloat(height.getText().toString());
                float w = Float.parseFloat(weight.getText().toString());
                float a = Float.parseFloat(age.getText().toString());
                String g = findViewById(gender.getCheckedRadioButtonId()).toString();
                String active = activity.getSelectedItem().toString();
                BMI = calculateBMI(h, w, a, g, active);

                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("BMI", BMI);
                editor.putString("diet", dietSerializer.get(diet.getSelectedItem().toString()));
                editor.putBoolean("vegetarian", vegetarian.isChecked());
                editor.putBoolean("vegan", vegan.isChecked());
                editor.putBoolean("red-meat-free", redMeat.isChecked());
                editor.putBoolean("No-oil-added", oil.isChecked());
                editor.putBoolean("low-sugar", sugar.isChecked());
                editor.putBoolean("gluten-free", gluten.isChecked());
                editor.putBoolean("dairy-free", lactose.isChecked());
                editor.putBoolean("fish-free", fish.isChecked());
                editor.putBoolean("milk", milk.isChecked());
                editor.putBoolean("cheese", cheese.isChecked());
                editor.putBoolean("nuts", nuts.isChecked());
                editor.putBoolean("egg", egg.isChecked());
                editor.putBoolean("mushrooms", mushrooms.isChecked());
                editor.putBoolean("chocolate", chocolate.isChecked());
                editor.putBoolean("honey", honey.isChecked());
                editor.putBoolean("coffee", coffee.isChecked());
                editor.apply();

                Log.d("BMI", Integer.toString(BMI));
                startActivity(intent);
            }
        });
    }

    private int calculateBMI(float height, float weight, float age, String gender, String activity) {
        int genderIndex = 0;

        if (gender.equals("Мужской"))
            genderIndex = -161;
        else
            genderIndex = 5;


        float activityIndex = Float.parseFloat(activity.split(" ")[0]);


        return (int) (((weight*10) + (height*6.25) - (age*5) + genderIndex)*activityIndex);

    }
}