package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PlaylistsActivity extends AppCompatActivity {

    TextView songs,playlists,folders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlists);

        id();
    }

    private void id()
    {
        songs=findViewById(R.id.songs);

        songs.setOnClickListener( v -> {
            Intent i = new Intent(this,SongsPageActivity.class);
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