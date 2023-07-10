package com.example.bankdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AppCompatButton btnsbi, btnhdfc, btnicici, btnkotak, btnpnb, btnbob, btnvarachha, btnyes, btnaxis, btnunion;
    ImageView sbiphone, hdfcphone, iciciphone, kotakphone, punjabphone, bobphone, varachaaphone, yesphone, axisphone, unionphone;
    ImageView sbishare,hdfcshare,icicishare,kotakshare,punjabshare,bobshare,varachaashare,yesshare,axisshare,unionshare;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Website();
        Call();
        share();

    }

    private void share() {
        sbishare = findViewById(R.id.sbishare);
        hdfcshare = findViewById(R.id.hdfcshare);
        icicishare = findViewById(R.id.icicishare);
        kotakshare = findViewById(R.id.kotakshare);
        punjabshare = findViewById(R.id.punjabshare);
        bobshare = findViewById(R.id.bobshare);
        varachaashare = findViewById(R.id.varachaashare);
        yesshare = findViewById(R.id.yesshare);
        axisshare = findViewById(R.id.axisshare);
        unionshare = findViewById(R.id.unionshare);

        sbishare.setOnClickListener(view -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://www.onlinesbi.sbi/";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });

        hdfcshare.setOnClickListener(view -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://www.hdfcbank.com/y";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });

        icicishare.setOnClickListener(view -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://www.icicibank.com/";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });

        kotakshare.setOnClickListener(view -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://www.kotak.com/en/home.html";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });

        punjabshare.setOnClickListener(view -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://www.pnbindia.in/";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });

        bobshare.setOnClickListener(view -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://www.bankofbaroda.in/";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });

        varachaashare.setOnClickListener(view -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://www.varachhabank.com/";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });

        yesshare.setOnClickListener(view -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://www.yesbank.in/";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });

        axisshare.setOnClickListener(view -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://www.axisbank.com/";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });

        unionshare.setOnClickListener(view -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://www.unionbankofindia.co.in/english/home.aspx";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        });
    }


    private void Website() {
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
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("url", "https://www.onlinesbi.sbi");
            startActivity(intent);
        });

        btnhdfc.setOnClickListener(v -> {
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("url", "https://www.hdfcbank.com");
            startActivity(intent);
        });

        btnicici.setOnClickListener(v -> {
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("url", "https://www.icicibank.com");
            startActivity(intent);
        });

        btnkotak.setOnClickListener(v -> {
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("url", "https://www.kotak.com/en/home.html");
            startActivity(intent);
        });

        btnpnb.setOnClickListener(v -> {
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("url", "https://www.pnbindia.in");
            startActivity(intent);
        });

        btnbob.setOnClickListener(v -> {
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("url", "https://www.bankofbaroda.in");
            startActivity(intent);
        });

        btnvarachha.setOnClickListener(v -> {
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("url", "https://www.varachhabank.com");
            startActivity(intent);
        });

        btnyes.setOnClickListener(v -> {
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("url", "https://www.yesbank.in");
            startActivity(intent);
        });

        btnaxis.setOnClickListener(v -> {
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("url", "https://www.axisbank.com");
            startActivity(intent);
        });

        btnunion.setOnClickListener(v -> {
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("url", "https://www.unionbankofindia.co.in");
            startActivity(intent);
        });
    }

    private void Call() {
        sbiphone = findViewById(R.id.sbiphone);
        hdfcphone = findViewById(R.id.hdfcphone);
        iciciphone = findViewById(R.id.iciciphone);
        kotakphone = findViewById(R.id.kotakphone);
        punjabphone = findViewById(R.id.punjabphone);
        bobphone = findViewById(R.id.bobphone);
        varachaaphone = findViewById(R.id.varachaaphone);
        yesphone = findViewById(R.id.yesphone);
        axisphone = findViewById(R.id.axisphone);
        unionphone = findViewById(R.id.unionphone);

        sbiphone.setOnClickListener(view -> {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + 18001234));
            startActivity(callIntent);
        });

//        hdfcphone.setOnClickListener(view -> {
//            Intent callIntent = new Intent(Intent.ACTION_CALL);
//            callIntent.setData(Uri.parse("tel:" +18002026161));
//            startActivity(callIntent);
//        });

        iciciphone.setOnClickListener(view -> {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + 18001080));//change the number
            startActivity(callIntent);
        });

//        kotakphone.setOnClickListener(view -> {
//            Intent callIntent = new Intent(Intent.ACTION_CALL);
//            callIntent.setData(Uri.parse("tel:" +18602662666));//change the number
//            startActivity(callIntent);
//        });

//        punjabphone.setOnClickListener(view -> {
//            Intent callIntent = new Intent(Intent.ACTION_CALL);
//            callIntent.setData(Uri.parse("tel:" + 18001802222));//change the number
//            startActivity(callIntent);
//        });
//
//        bobphone.setOnClickListener(view -> {
//            Intent callIntent = new Intent(Intent.ACTION_CALL);
//            callIntent.setData(Uri.parse("tel:" + 18001024455));//change the number
//            startActivity(callIntent);
//        });
//
//        varachaaphone.setOnClickListener(view -> {
//            Intent callIntent = new Intent(Intent.ACTION_CALL);
//            callIntent.setData(Uri.parse("tel:" + 18002587750));//change the number
//            startActivity(callIntent);
//        });

        yesphone.setOnClickListener(view -> {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + 18001200));//change the number
            startActivity(callIntent);
        });

//        axisphone.setOnClickListener(view -> {
//            Intent callIntent = new Intent(Intent.ACTION_CALL);
//            callIntent.setData(Uri.parse("tel:" +18604195555));//change the number
//            startActivity(callIntent);
//        });

        unionphone.setOnClickListener(view -> {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + 2401622));//change the number
            startActivity(callIntent);
        });

    }
}