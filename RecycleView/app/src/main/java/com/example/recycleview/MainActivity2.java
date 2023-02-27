package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txtid,txtname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtid = findViewById(R.id.txtid);
        txtname = findViewById(R.id.txtname);

        display();
    }

    private void display() {
        String id = getIntent().getStringExtra("id");
        String name = getIntent().getStringExtra("name");

        txtid.setText(id);
        txtname.setText(name);
    }
}