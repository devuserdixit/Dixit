package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardView cvimage1,cvimage2,cvimage3,cvimage4,cvimage5,cvimage6,cvimage7,cvimage8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id();
        output();
    }

    private void id()
    {
        cvimage1=findViewById(R.id.cvimage1);
        cvimage2=findViewById(R.id.cvimage2);
        cvimage3=findViewById(R.id.cvimage3);
        cvimage4=findViewById(R.id.cvimage4);
        cvimage5=findViewById(R.id.cvimage5);
        cvimage6=findViewById(R.id.cvimage6);
        cvimage7=findViewById(R.id.cvimage7);
        cvimage8=findViewById(R.id.cvimage8);
    }

    private void output()
    {
        cvimage1.setOnClickListener(v1 -> {
            //Toast.makeText(this, "Image 1 is clicked", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,MainActivity2.class);
            startActivity(i);
        });
        cvimage2.setOnClickListener(v2 -> {
//            Toast.makeText(this, "Image 2 is clicked", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,MainActivity2.class);
            startActivity(i);
        });
        cvimage3.setOnClickListener(v3 -> {
//            Toast.makeText(this, "Image 3 is clicked", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,MainActivity2.class);
            startActivity(i);
        });
        cvimage4.setOnClickListener(v4 -> {
//            Toast.makeText(this, "Image 4 is clicked", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,MainActivity2.class);
            startActivity(i);
        });
        cvimage5.setOnClickListener(v5 -> {
//            Toast.makeText(this, "Image 5 is clicked", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,MainActivity2.class);
            startActivity(i);
        });
        cvimage6.setOnClickListener(v6 -> {
//            Toast.makeText(this, "Image 6 is clicked", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,MainActivity2.class);
            startActivity(i);
        });
        cvimage7.setOnClickListener(v7 -> {
//            Toast.makeText(this, "Image 7 is clicked", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,MainActivity2.class);
            startActivity(i);
        });
        cvimage8.setOnClickListener(v8 -> {
//            Toast.makeText(this, "Image 8 is clicked", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(this,MainActivity2.class);
            startActivity(i);
        });
    }

}