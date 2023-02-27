package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtno1,edtno2,edtno3,edtno4,edtno5;
    TextView txtans;
    Button btncalc,btncle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intview();
        result();
        clear();
    }

    private void intview()
    {
        edtno1=findViewById(R.id.edtno1);
        edtno2=findViewById(R.id.edtno2);
        edtno3=findViewById(R.id.edtno3);
        edtno4=findViewById(R.id.edtno4);
        edtno5=findViewById(R.id.edtno5);
        txtans=findViewById(R.id.txtans);
        btncalc=findViewById(R.id.btncalc);
        btncle=findViewById(R.id.btncle);
    }

    private void result()
    {
        btncalc.setOnClickListener(v -> {
            String valu1=edtno1.getText().toString();
            String valu2=edtno2.getText().toString();
            String valu3=edtno3.getText().toString();
            String valu4=edtno4.getText().toString();
            String valu5=edtno5.getText().toString();

            int v1=Integer.parseInt(valu1);
            int v2=Integer.parseInt(valu2);
            int v3=Integer.parseInt(valu3);
            int v4=Integer.parseInt(valu4);
            int v5=Integer.parseInt(valu5);
            int Total;
            Total=v1+v2+v3+v4+v5;
            txtans.setText(Total+"");
        });
    }
    private void clear()
    {
        btncle.setOnClickListener(c ->{
            edtno1.setText("");
            edtno2.setText("");
            edtno3.setText("");
            edtno4.setText("");
            edtno5.setText("");
            txtans.setText("");
        });
    }
}