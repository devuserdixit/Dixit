package com.example.aswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNumber;
    Button btnSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();

    }

    private void initview()
    {
        edtNumber=findViewById(R.id.edtNumber);
        btnSub=findViewById(R.id.btnSub);

        btnSub.setOnClickListener(v ->{
            String v1=edtNumber.getText().toString();

            Toast.makeText(this,""+v1,Toast.LENGTH_SHORT).show();
        });
    }
}