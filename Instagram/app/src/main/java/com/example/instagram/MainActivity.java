package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.instagram.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//Horizontal
    ArrayList<ModalClass> instagramList = new ArrayList<>();

    ActivityMainBinding mainBinding;

    ArrayList<Integer> imageList = new ArrayList<>();
    ArrayList<String> nameList = new ArrayList<>();

//    vertical
    ArrayList<VerticleModalClass> instaverticalList = new ArrayList<>();

    ArrayList<Integer> ImageLogoList = new ArrayList<>();
    ArrayList<String> nameList2 = new ArrayList<>();
    ArrayList<Integer> ImagePostList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        Horizontal();
        Vertical();
    }
//horizontal
    private void Horizontal() {

        information();

        OnClicklListener listener = new OnClicklListener() {
            @Override
            public void onclick(String Name, int Image) {
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("name",Name);
                i.putExtra("image",Image);
                startActivity(i);
            }
        };

        for (int i=0;i<13;i++)
        {
            ModalClass modal = new ModalClass();
            modal.setName(nameList.get(i));
            modal.setImage(imageList.get(i));
            instagramList.add(modal);
        }
        InstaAdapter adapter = new InstaAdapter(instagramList,listener);

        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mainBinding.instagram.setLayoutManager(manager);
        mainBinding.instagram.setAdapter(adapter);
    }

    private void information() {
        imageList.add(R.drawable.shiv);
        imageList.add(R.drawable.khodal);
        imageList.add(R.drawable.akshay);
        imageList.add(R.drawable.shiv);
        imageList.add(R.drawable.hritik);
        imageList.add(R.drawable.hanuman);
        imageList.add(R.drawable.krishna);
        imageList.add(R.drawable.khodal);
        imageList.add(R.drawable.akshay);
        imageList.add(R.drawable.shiv);
        imageList.add(R.drawable.hritik);
        imageList.add(R.drawable.hanuman);
        imageList.add(R.drawable.krishna);

        nameList.add("Your Story");
        nameList.add("Khodal");
        nameList.add("akshay");
        nameList.add("shiva");
        nameList.add("hritik");
        nameList.add("hanuman");
        nameList.add("krishna");
        nameList.add("Khodal");
        nameList.add("akshay");
        nameList.add("shiva");
        nameList.add("hritik");
        nameList.add("hanuman");
        nameList.add("krishna");
    }
//vertical
    private void Vertical() {

        information2();

        for (int i=0;i<nameList2.size();i++)
        {
            VerticleModalClass modal2 = new VerticleModalClass();
            modal2.setName(nameList2.get(i));
            modal2.setImageLogo(ImageLogoList.get(i));
            modal2.setImagePost(ImagePostList.get(i));
            instaverticalList.add(modal2);
        }
        VerticleAdapter adapter = new VerticleAdapter(instaverticalList);

        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mainBinding.instagram2.setLayoutManager(manager);
        mainBinding.instagram2.setAdapter(adapter);
    }

    private void information2() {
        ImagePostList.add(R.drawable.khodal);
        ImagePostList.add(R.drawable.akshay);
        ImagePostList.add(R.drawable.shiv);
        ImagePostList.add(R.drawable.hritik);
        ImagePostList.add(R.drawable.hanuman);
        ImagePostList.add(R.drawable.krishna);
        ImagePostList.add(R.drawable.khodal);
        ImagePostList.add(R.drawable.akshay);
        ImagePostList.add(R.drawable.shiv);
        ImagePostList.add(R.drawable.hritik);
        ImagePostList.add(R.drawable.hanuman);
        ImagePostList.add(R.drawable.krishna);

        ImageLogoList.add(R.drawable.khodal);
        ImageLogoList.add(R.drawable.akshay);
        ImageLogoList.add(R.drawable.shiv);
        ImageLogoList.add(R.drawable.hritik);
        ImageLogoList.add(R.drawable.hanuman);
        ImageLogoList.add(R.drawable.krishna);
        ImageLogoList.add(R.drawable.khodal);
        ImageLogoList.add(R.drawable.akshay);
        ImageLogoList.add(R.drawable.shiv);
        ImageLogoList.add(R.drawable.hritik);
        ImageLogoList.add(R.drawable.hanuman);
        ImageLogoList.add(R.drawable.krishna);

        nameList2.add("Khodal");
        nameList2.add("akshay");
        nameList2.add("shiva");
        nameList2.add("hritik");
        nameList2.add("hanuman");
        nameList2.add("krishna");
        nameList2.add("Khodal");
        nameList2.add("akshay");
        nameList2.add("shiva");
        nameList2.add("hritik");
        nameList2.add("hanuman");
        nameList2.add("krishna");
    }
}