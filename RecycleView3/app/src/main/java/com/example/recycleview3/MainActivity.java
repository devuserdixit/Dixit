package com.example.recycleview3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ModalClass> List = new ArrayList();

    ArrayList<String> usernameList = new ArrayList<>();
    ArrayList<Integer> userrunList =new ArrayList<>();
    ArrayList<Integer> userWicketList = new ArrayList<>();

    RecyclerView rcvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initview();
    }

    private void initview() {

        setdetailList();

        for(int i=0;i<usernameList.size();i++)
        {
            ModalClass modal= new ModalClass();
            modal.setUsername(usernameList.get(i));
            modal.setUserrun(userrunList.get(i));
            modal.setUserwicket(userWicketList.get(i));
            List.add(modal);
        }

        rcvUser = findViewById(R.id.rcvUser);

        CricketAdapter adapter = new CricketAdapter(List);

        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvUser.setLayoutManager(manager);
        rcvUser.setAdapter(adapter);
    }

    private void setdetailList() {

        usernameList.add("Virat Kohli");
        usernameList.add("M.S.Dhoni");
        usernameList.add("Sachin Tendulkar");
        usernameList.add("Ravindra jadeja");
        usernameList.add("Bumrah");
        usernameList.add("Suryakumar Yadav");
        usernameList.add("Hardik Pandya");
        usernameList.add("Rishabh Pant");
        usernameList.add("Krish gel");
        usernameList.add("K.L.Rahul");

        userrunList.add(100);
        userrunList.add(200);
        userrunList.add(300);
        userrunList.add(40);
        userrunList.add(50);
        userrunList.add(60);
        userrunList.add(70);
        userrunList.add(80);
        userrunList.add(900);
        userrunList.add(100);

        userWicketList.add(10);
        userWicketList.add(7);
        userWicketList.add(10);
        userWicketList.add(30);
        userWicketList.add(35);
        userWicketList.add(5);
        userWicketList.add(30);
        userWicketList.add(8);
        userWicketList.add(2);
        userWicketList.add(15);
    }
}