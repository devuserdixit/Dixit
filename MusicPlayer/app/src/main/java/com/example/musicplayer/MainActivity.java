package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id();
    }

    private void id()
    {
        next1=findViewById(R.id.next1);

        next1.setOnClickListener( v -> {

            Intent i = new Intent(this,AdSecondActivity.class);
            startActivity(i);
            finish();
        });
    }
}