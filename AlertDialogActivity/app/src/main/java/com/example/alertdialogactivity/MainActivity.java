package com.example.alertdialogactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btndialog1,btndialog2,btndialog3,btndialog4,btndialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
    }

    private void initview()
    {
        btndialog1=findViewById(R.id.btndialog1);
        btndialog2=findViewById(R.id.btndialog2);
        btndialog3=findViewById(R.id.btndialog3);
        btndialog4=findViewById(R.id.btndialog4);
        btndialog5=findViewById(R.id.btndialog5);

        btndialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Permission Manager");
                builder.setMessage("can you access your Location");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is yes button", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is no button", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is cancel button", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setCancelable(false);
                builder.show();
            }
        });


        btndialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Permission Manager");
                builder.setMessage("can you access your Location");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is yes button", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is no button", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is Dismiss button", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setCancelable(false);
                builder.show();
            }
        });


        btndialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Permission Manager");
                builder.setMessage("can you access your Location");
                builder.setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is Allow button", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is Deny button", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is cancel button", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setCancelable(false);
                builder.show();
            }
        });


        btndialog4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Permission Manager");
                builder.setMessage("can you access your Location");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is Ok button", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is Cancel button", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is Dismiss button", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setCancelable(false);
                builder.show();
            }
        });


        btndialog5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Permission Manager");
                builder.setMessage("can you access your Location");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is yes button", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is no button", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("Remind me later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "This is cancel button", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.setCancelable(false);
                builder.show();
            }
        });
    }

}