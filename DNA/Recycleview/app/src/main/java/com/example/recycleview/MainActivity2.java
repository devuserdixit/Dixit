package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txtname,txtrun;
    ImageView imganimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtname = findViewById(R.id.txtname);
        txtrun = findViewById(R.id.txtrun);
        imganimal = findViewById(R.id.imganimal);

        display();
    }

    private void display() {



        Bundle bundle = getIntent().getExtras();
        if (bundle !=null)
        {
            int picture = bundle.getInt("image");
            imganimal.setImageResource(picture);

        }
        String name = getIntent().getStringExtra("name");
        String speed = getIntent().getStringExtra("speed");
    }
}