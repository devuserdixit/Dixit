package com.example.relationallayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initview();
    }
    void initview()
    {
        Button btnSubmit=findViewById(R.id.btnSubmit);
        EditText edtName=findViewById(R.id.edtName);
        EditText edtPassword=findViewById(R.id.edtPassword);
        EditText edtcPassword=findViewById(R.id.edtcPassword);
        EditText edtAddress=findViewById(R.id.edtAddress);
        CheckBox chkCricket=findViewById(R.id.chkCricket);
        CheckBox chkFootball=findViewById(R.id.chkFootball);
        CheckBox chkHockey=findViewById(R.id.chkHockey);

        
        btnSubmit.setOnClickListener(view -> {
            
            String name=edtName.getText().toString();
            String Password=edtPassword.getText().toString();
            String confirmPassword=edtcPassword.getText().toString();
            String Address=edtAddress.getText().toString();
            boolean a=chkCricket.isChecked();
            boolean b=chkFootball.isChecked();
            boolean c=chkHockey.isChecked();

            Log.e("TAG1", "Username="+name);
            Log.e("TAG2", "Password="+Password);
            Log.e("TAG3", "confirmPassword="+confirmPassword);
            Log.e("TAG4", "Address="+Address);
            Log.e("TAG4", "Cricket="+a);

//
//            if(chkCricket.isChecked())
//            {
//                Log.e("TAG","initview:"+chkCricket.getText().toString());
//            }
//            if(chkFootball.isChecked())
//            {
//                Log.e("TAG","initview:"+chkFootball.getText().toString());
//            }
//            if(chkHockey.isChecked())
//            {
//                Log.e("TAG","initview:"+chkHockey.getText().toString());
//            }


        });
    }
}