package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ModalClass> list = new ArrayList<>();

ArrayList<Integer> imgList = new ArrayList<>();
    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<Integer> runspeedList = new ArrayList<>();


    RecyclerView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
    }

    private void initview() {


        setdatalist();

        user = findViewById(R.id.user);
     OnClickListener listener=new OnClickListener() {
    @Override
    public void onclick(String animalname, int animalspeed, int animalimage) {
        Intent i=new Intent(MainActivity.this,MainActivity2.class);
        i.putExtra("name",animalname);
        i.putExtra("speed",animalspeed);
        i.putExtra("image",animalimage);
        startActivity(i);

    }
};
        for(int i=0;i<nameList.size();i++) {
            ModalClass model = new ModalClass();
            model.setAnimalname(nameList.get(i));
            model.setAnimalspeed(runspeedList.get(i));
            model.setAnimalimage(imgList.get(i));
            list.add(model);

            AnimalsAdapter adapter = new AnimalsAdapter(list,listener);
            LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
            user.setLayoutManager(manager);
            user.setAdapter(adapter);

        }

    }
    private void setdatalist() {

        nameList.add("Lion");
        nameList.add("Jaguar");
        nameList.add("Elephant");
        nameList.add("Hippo");
        nameList.add("Dog");
        nameList.add("Tiger");
        nameList.add("Cow");
        nameList.add("Horse");
        nameList.add("Donkey");
        nameList.add("Camel");

        runspeedList.add(70);
        runspeedList.add(90);
        runspeedList.add(15);
        runspeedList.add(15);
        runspeedList.add(50);
        runspeedList.add(75);
        runspeedList.add(10);
        runspeedList.add(60);
        runspeedList.add(40);
        runspeedList.add(25);

        imgList.add(R.drawable.lion);
        imgList.add(R.drawable.jaguar);
        imgList.add(R.drawable.elephant);
        imgList.add(R.drawable.hippo);
        imgList.add(R.drawable.dog);
        imgList.add(R.drawable.tiger);
        imgList.add(R.drawable.cow);
        imgList.add(R.drawable.horse);
        imgList.add(R.drawable.donkey);
        imgList.add(R.drawable.camel);

    }
}