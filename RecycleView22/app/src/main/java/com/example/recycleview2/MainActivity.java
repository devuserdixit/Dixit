package com.example.recycleview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ModalClass> List = new ArrayList<>();

    ArrayList<String> usernameList = new ArrayList<>();
    ArrayList<Integer> usernumberList = new ArrayList<>();

    RecyclerView rcvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
    }

    private void initview()
    {

        setdetailList();

        for (int i = 0; i <usernameList.size(); i++)
        {
            ModalClass model = new ModalClass();
            model.setUsername(usernameList.get(i));
            model.setNumber(usernumberList.get(i));
            List.add(model);
        }

        rcvUser = findViewById(R.id.rcvUser);

        UserAdapter adapter = new UserAdapter(List);

        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvUser.setLayoutManager(manager);
        rcvUser.setAdapter(adapter);

    }


    private void setdetailList() {
        usernameList.add("Sanjay");
        usernameList.add("Himanshu");
        usernameList.add("Purvish");
        usernameList.add("Dikshit");
        usernameList.add("Shruti");
        usernameList.add("Dhruv");
        usernameList.add("Vensi");
        usernameList.add("Akshay");
        usernameList.add("Maulik");
        usernameList.add("Hasu");
        usernameList.add("Jenish");
        usernameList.add("Ronak");
        usernameList.add("Pratik");
        usernameList.add("Akshar");
        usernameList.add("Vinit");

        usernumberList.add(901628593);
        usernumberList.add(901628593);
        usernumberList.add(901628593);
        usernumberList.add(901628593);
        usernumberList.add(901628593);
        usernumberList.add(901628593);
        usernumberList.add(901628593);
        usernumberList.add(901628593);
        usernumberList.add(901628593);
        usernumberList.add(901628593);
        usernumberList.add(901628593);
        usernumberList.add(901628593);
        usernumberList.add(901628593);
        usernumberList.add(901628593);
        usernumberList.add(901628593);
    }
}