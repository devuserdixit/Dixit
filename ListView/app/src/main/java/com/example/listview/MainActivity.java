package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String contactar[] = {"Ambulance","Police","Fire","Aniket","Sumit","Kenil","Sajan","Hardik","Dignesh","Dhruv","Hasu","Maulik","Jenish","Sanjay","Himanshu","Paras","Ronak","Dharam","Akshit","Akshar"};
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contact();
    }

    private void contact() {
        listview = findViewById(R.id.listview);
        ContactAdapter adapter = new ContactAdapter(contactar,MainActivity.this);
        listview.setAdapter(adapter);

        listview.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}