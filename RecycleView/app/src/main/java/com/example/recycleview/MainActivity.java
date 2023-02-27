package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    ArrayList<ModalClass> List = new ArrayList<>();

    ArrayList<String> usernameList = new ArrayList<>();
    ArrayList<Integer> useridList = new ArrayList<>();

    RecyclerView rcvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
    }

    private void initview() {

        setNameList();

        for (int i=0;i<7;i++)
        {
            ModalClass model = new ModalClass();
            model.setUsername(usernameList.get(i));
            model.setId(useridList.get(i));
            List.add(model);
        }

        rcvUser=findViewById(R.id.rcvUser);

        ClickListner listner =new ClickListner() {
            @Override
            public void onclick(int id,String name) {
                Log.e("TAG", "onclick:==== "+id +"  "+name);

                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("id",id);
                i.putExtra("name",name);
                startActivity(i);
            }
        };
        UserAdapter adapter = new UserAdapter(List,listner);

        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvUser.setLayoutManager(manager);
        rcvUser.setAdapter(adapter);

    }

    private void setNameList() {
      usernameList.add("Dikshit");
      usernameList.add("Sanjay");
      usernameList.add("Himanshu");
      usernameList.add("Akshay");
      usernameList.add("Puravish");
      usernameList.add("Vensi");
      usernameList.add("Shruti");

      useridList.add(1);
      useridList.add(2);
      useridList.add(3);
      useridList.add(4);
      useridList.add(5);
      useridList.add(6);
      useridList.add(7);
    }
}