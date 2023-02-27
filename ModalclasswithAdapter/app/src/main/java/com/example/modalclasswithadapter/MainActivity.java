package com.example.modalclasswithadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ModalClassActivity> contactname = new ArrayList<>();

    GridView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
    }

    private void initview() {

        ModalClassActivity c1 = new ModalClassActivity();
        c1.setId(1);
        c1.setcontactname("1234567890");

        ModalClassActivity c2 = new ModalClassActivity();
        c2.setId(2);
        c2.setcontactname("0987654321");

        contactname.add(c1);
        contactname.add(c2);

        list=findViewById(R.id.list);
        ContactAdapter adapter = new ContactAdapter(contactname,this);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ModalClassActivity value=contactname.get(i);
                Toast.makeText(MainActivity.this, "selected "+ value.getContactname(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}