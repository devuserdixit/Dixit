package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AdFourthActivity extends AppCompatActivity {

    TextView next4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_fourth);

        id();
    }

    private void id()
    {
        next4=findViewById(R.id.next4);

        next4.setOnClickListener( v -> {
            Intent i = new Intent(this,AdFifthActivity.class);
            startActivity(i);
            finish();
        });
    }
}