package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AdSecondActivity extends AppCompatActivity {

    TextView next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_second);

        id();
    }

    private void id()
    {
       next2=findViewById(R.id.next2);

        next2.setOnClickListener( v -> {

            Intent i = new Intent(this,AdThirdActivity.class);
            startActivity(i);
            finish();
        });
    }
}