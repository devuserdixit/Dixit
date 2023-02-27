package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AdFifthActivity extends AppCompatActivity {

    TextView next5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_fifth);

        id();
    }

    private void id()
    {
        next5=findViewById(R.id.next5);

        next5.setOnClickListener( v -> {
            Intent i = new Intent(this,AllSingersActivity.class);
            startActivity(i);
            finish();
        });
    }
}