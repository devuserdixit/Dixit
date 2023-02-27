package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SongsPageActivity extends AppCompatActivity {

    LinearLayout songGarmi,taron,karaar,kesariya,khairiyat,shayad,lovedose,down,desi,vaste,sune,jabtak,gabru,lahore,india;
    TextView songs,playlists,folders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_page);

        id();
    }

    private void id()
    {
        songGarmi=findViewById(R.id.songGarmi);

        songGarmi.setOnClickListener( v -> {
            Intent i = new Intent(this,MusicSingerActivity.class);
            startActivity(i);
        });

//        taron=findViewById(R.id.taron);
//
//        taron.setOnClickListener( v -> {
//            Intent i = new Intent(this,MusicSingerActivity.class);
//            startActivity(i);
//        });
//
//        karaar=findViewById(R.id.karaar);
//
//        karaar.setOnClickListener( v -> {
//            Intent i = new Intent(this,MusicSingerActivity.class);
//            startActivity(i);
//        });
//
//        kesariya=findViewById(R.id.kesariya);
//
//        kesariya.setOnClickListener( v -> {
//            Intent i = new Intent(this,MusicSingerActivity.class);
//            startActivity(i);
//        });
//
//        khairiyat=findViewById(R.id.khairiyat);
//
//        khairiyat.setOnClickListener( v -> {
//            Intent i = new Intent(this,MusicSingerActivity.class);
//            startActivity(i);
//        });
//
//        shayad=findViewById(R.id.shayad);
//
//        shayad.setOnClickListener( v -> {
//            Intent i = new Intent(this,MusicSingerActivity.class);
//            startActivity(i);
//        });
//
//        lovedose=findViewById(R.id.lovedose);
//
//        lovedose.setOnClickListener( v -> {
//            Intent i = new Intent(this,MusicSingerActivity.class);
//            startActivity(i);
//        });
//
//        down=findViewById(R.id.down);
//
//        down.setOnClickListener( v -> {
//            Intent i = new Intent(this,MusicSingerActivity.class);
//            startActivity(i);
//        });
//
//        desi=findViewById(R.id.desi);
//
//        desi.setOnClickListener( v -> {
//            Intent i = new Intent(this,MusicSingerActivity.class);
//            startActivity(i);
//        });
//
//        vaste=findViewById(R.id.vaste);
//
//        vaste.setOnClickListener( v -> {
//            Intent i = new Intent(this,MusicSingerActivity.class);
//            startActivity(i);
//        });
//
//        sune=findViewById(R.id.sune);
//
//        sune.setOnClickListener( v -> {
//            Intent i = new Intent(this,MusicSingerActivity.class);
//            startActivity(i);
//        });
//
//        jabtak=findViewById(R.id.jabtak);
//
//        jabtak.setOnClickListener( v -> {
//            Intent i = new Intent(this,MusicSingerActivity.class);
//            startActivity(i);
//        });
//
//        gabru=findViewById(R.id.gabru);
//
//        gabru.setOnClickListener( v -> {
//            Intent i = new Intent(this,MusicSingerActivity.class);
//            startActivity(i);
//        });
//
//        lahore=findViewById(R.id.lahore);
//
//        lahore.setOnClickListener( v -> {
//            Intent i = new Intent(this,MusicSingerActivity.class);
//            startActivity(i);
//        });
//
//        india=findViewById(R.id.india);
//
//        india.setOnClickListener( v -> {
//            Intent i = new Intent(this,MusicSingerActivity.class);
//            startActivity(i);
//        });

        playlists=findViewById(R.id.playlists);

        playlists.setOnClickListener( v -> {
            Intent i = new Intent(this,PlaylistsActivity.class);
            startActivity(i);
            finish();
        });

        folders=findViewById(R.id.folders);

        folders.setOnClickListener(v ->{
            Intent i = new Intent(this,FolderActivity.class);
            startActivity(i);
            finish();
        });
    }

}