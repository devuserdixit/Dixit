package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

public class MusicSingerActivity extends AppCompatActivity {

    ImageView back,play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_singer);

        id();
        song();

    }


    private void id()
    {
        back=findViewById(R.id.back);

        back.setOnClickListener( v -> {
            Intent i = new Intent(this,SongsPageActivity.class);
            startActivity(i);
        });
    }

    private void song()
    {
        play=findViewById(R.id.play);

        MediaPlayer mp3 = MediaPlayer.create(this,R.raw.garmi);

        play.setOnClickListener(v->{

            if(mp3.isPlaying())
            {
                mp3.stop();
                recreate();
            }
            else
            {
                mp3.start();
            }

        });
    }

}