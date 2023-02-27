package com.example.selectphoto;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import com.example.selectphoto.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=ActivityMainBinding.inflate((getLayoutInflater()));
        setContentView(mainBinding.getRoot());

        view();
    }

    private void view() {

        mainBinding.btnGallery.setOnClickListener(v ->{
            openGallery();
        });

        mainBinding.btnCamera.setOnClickListener(v ->{
            openCamera();
        });
    }

    private void openCamera()
    {
        Intent camera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera,2);
    }

    private void openGallery() {
        Intent gallery=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,1);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK)
        {
            Uri uri = data.getData();
            mainBinding.image.setImageURI(uri);
        }
        else if (requestCode == 2)
        {
            Bitmap b = (Bitmap) data.getExtras().get("data");
            mainBinding.image.setImageBitmap(b);
        }
    }
}