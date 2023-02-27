package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txtname;
    ImageView imgstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtname = findViewById(R.id.txtname);
        imgstatus = findViewById(R.id.imgstatus);

        display();
    }

    private void display() {

        String name = getIntent().getStringExtra("name");

        Bundle bundle = getIntent().getExtras();
        if (bundle !=null)
        {
            int picture = bundle.getInt("image");
            imgstatus.setImageResource(picture);

        }

        txtname.setText(name);
    }
}