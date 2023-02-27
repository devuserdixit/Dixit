package com.example.arraylistwithlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ArrayList<String> food = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        food();
    }

    private void food()
    {
        list = findViewById(R.id.list);
        food.add("Pizza");
        food.add("Burger");
        food.add("HotDog");
        food.add("Momos");
        food.add("Panipuri");
        food.add("Sandwich");
        food.add("Manchuriyam");
        food.add("Dhosa");
        food.add("Noddles");
        food.add("Gathiya");

        FoodAdapter adapter = new FoodAdapter(food,MainActivity.this);
        list.setAdapter(adapter);

        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}