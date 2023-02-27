package com.example.bankdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btnsbi, btnhdfc, btnicici, btnkotak, btnpnb, btnbob, btnvarachha, btnyes, btnaxis, btnunion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
    }

    private void initview() {
        btnsbi = findViewById(R.id.btnsbi);
        btnhdfc = findViewById(R.id.btnhdfc);
        btnicici = findViewById(R.id.btnicici);
        btnkotak = findViewById(R.id.btnkotak);
        btnpnb = findViewById(R.id.btnpnb);
        btnbob = findViewById(R.id.btnbob);
        btnvarachha = findViewById(R.id.btnvarachha);
        btnyes = findViewById(R.id.btnyes);
        btnaxis = findViewById(R.id.btnaxis);
        btnunion = findViewById(R.id.btnunion);

        btnsbi.setOnClickListener(v -> {
            Intent intent =new Intent(this,WebViewActivity.class);
            intent.putExtra("url","https://www.onlinesbi.sbi");
            startActivity(intent);
        });

        btnhdfc.setOnClickListener(v -> {
            Intent intent =new Intent(this,WebViewActivity.class);
            intent.putExtra("url","https://www.hdfcbank.com");
            startActivity(intent);
        });

        btnicici.setOnClickListener(v -> {
            Intent intent =new Intent(this,WebViewActivity.class);
            intent.putExtra("url","https://www.icicibank.com");
            startActivity(intent);
        });

        btnkotak.setOnClickListener(v -> {
            Intent intent =new Intent(this,WebViewActivity.class);
            intent.putExtra("url","https://www.kotak.com/en/home.html");
            startActivity(intent);
        });

        btnpnb.setOnClickListener(v -> {
            Intent intent =new Intent(this,WebViewActivity.class);
            intent.putExtra("url","https://www.pnbindia.in");
            startActivity(intent);
        });

        btnbob.setOnClickListener(v -> {
            Intent intent =new Intent(this,WebViewActivity.class);
            intent.putExtra("url","https://www.bankofbaroda.in");
            startActivity(intent);
        });

        btnvarachha.setOnClickListener(v -> {
            Intent intent =new Intent(this,WebViewActivity.class);
            intent.putExtra("url","https://www.varachhabank.com");
            startActivity(intent);
        });

        btnyes.setOnClickListener(v -> {
            Intent intent =new Intent(this,WebViewActivity.class);
            intent.putExtra("url","https://www.yesbank.in");
            startActivity(intent);
        });

        btnaxis.setOnClickListener(v -> {
            Intent intent =new Intent(this,WebViewActivity.class);
            intent.putExtra("url","https://www.axisbank.com");
            startActivity(intent);
        });

        btnunion.setOnClickListener(v -> {
            Intent intent =new Intent(this,WebViewActivity.class);
            intent.putExtra("url","https://www.unionbankofindia.co.in");
            startActivity(intent);
        });

    }
}