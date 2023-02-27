package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SettingActivity extends AppCompatActivity {

    String settingar[] = {"About phone","System apps updater","Security status","SIM cards & mobile networks","Wi-Fi","Bluetooth","Portable hotspot","VPN","Connection & sharing","Always on display","Display","Sound","Notifications","Home Screen","Wallpaper","Themes","Passwords","Safety","Battery","Apps"};
    ListView listview2;
    int imgar[] ={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,R.drawable.img11,R.drawable.img12,R.drawable.img13,R.drawable.img14,R.drawable.img15,R.drawable.img16,R.drawable.img17,R.drawable.img18,R.drawable.img19,R.drawable.img20};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        contact();
    }

    private void contact() {
        listview2 = findViewById(R.id.listview2);
        SettingAdapter adapter = new SettingAdapter(settingar,imgar,SettingActivity.this);
        listview2.setAdapter(adapter);

        listview2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}