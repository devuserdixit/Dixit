package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AdThirdActivity extends AppCompatActivity {

    TextView next3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_third);

        id();
    }

    private void id()
    {
        next3=findViewById(R.id.next3);

        next3.setOnClickListener( v -> {
            Intent i = new Intent(this,AllSingersActivity.class);
            startActivity(i);
            finish();
        });
    }
}