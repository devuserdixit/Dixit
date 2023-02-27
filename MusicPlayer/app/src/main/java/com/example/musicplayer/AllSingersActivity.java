package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class AllSingersActivity extends AppCompatActivity {

    LinearLayout imgArijit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_singers);

        id();
    }

    private void id()
    {
        imgArijit=findViewById(R.id.imgArijit);

        imgArijit.setOnClickListener( v -> {
            Intent i = new Intent(this,SongsPageActivity.class);
            startActivity(i);
        });
    }
}