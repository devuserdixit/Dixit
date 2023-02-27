package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtvalu1,edtvalu2;
    TextView txtResult;
    Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       intview();
    }

    private void intview()
    {
        edtvalu1=findViewById(R.id.edtvalu1);
        edtvalu2=findViewById(R.id.edtvalue2);
        txtResult=findViewById(R.id.txtresult);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);

        btn1.setOnClickListener(v -> {
            String valu1=edtvalu1.getText().toString();
            String valu2=edtvalu2.getText().toString();

            int v1=Integer.parseInt(valu1);
            int v2=Integer.parseInt(valu2);
            int result;
            result=v1+v2;
            txtResult.setText(result+"");
        });

        btn2.setOnClickListener(g -> {
            String valu1=edtvalu1.getText().toString();
            String valu2=edtvalu2.getText().toString();

            int v1=Integer.parseInt(valu1);
            int v2=Integer.parseInt(valu2);
            int result;
            result=v1-v2;
            txtResult.setText(result+"");
        });

        btn3.setOnClickListener(i -> {
            String valu1=edtvalu1.getText().toString();
            String valu2=edtvalu2.getText().toString();

            int v1=Integer.parseInt(valu1);
            int v2=Integer.parseInt(valu2);
            int result;
            result=v1*v2;
            txtResult.setText(result+"");
        });

        btn4.setOnClickListener(c -> {
            String valu1=edtvalu1.getText().toString();
            String valu2=edtvalu2.getText().toString();

            int v1=Integer.parseInt(valu1);
            int v2=Integer.parseInt(valu2);
            int result;
            result=v1/v2;
            txtResult.setText(result+"");
        });
    }
}