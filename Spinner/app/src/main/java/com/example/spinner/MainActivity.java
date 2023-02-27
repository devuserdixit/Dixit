package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.spinner.databinding.ActivityMainBinding;

import java.util.ArrayList;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding Binding;

    //    String[] list={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    ArrayList<String> list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Binding = ActivityMainBinding.inflate((getLayoutInflater()));
        setContentView(Binding.getRoot());

        initview();


    }

    private void initview() {
        list.add("Sunday");
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        Binding.spinner.setAdapter(adapter);

        Binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String name = (String) list.get(i);
                Log.e("TAG","onItemSelected: "+name);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}