package com.example.personaldetails2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtFName, edtLName, edtNumber, edtEmail, edtAddress, edt10Percentage, edt12Percentage, edtFPercentage, edt10Pass, edt12Pass, edtCPass, edtExperience, edtFuture;
    CheckBox chkJourney, chkSpeaking, chkWriting, chkC, chkCPlus, chkJava, chkAndroid, chkKotlin, chkPhp, chkHtml, chkCss, chkWeb;

    RadioGroup rgGender, rgStatus;
    AppCompatButton btnSubmit;
    String gender, status;
    StringBuilder hobby = new StringBuilder();
    StringBuilder skill = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id();
        output();
    }

    private void id() {
        edtFName = findViewById(R.id.edtFName);
        edtLName = findViewById(R.id.edtLName);
        edtNumber = findViewById(R.id.edtNumber);
        edtEmail = findViewById(R.id.edtEmail);
        edtAddress = findViewById(R.id.edtAddress);
        edt10Percentage = findViewById(R.id.edt10Percentage);
        edt12Percentage = findViewById(R.id.edt12Percentage);
        edtFPercentage = findViewById(R.id.edtFPercentage);
        edt10Pass = findViewById(R.id.edt10Pass);
        edt12Pass = findViewById(R.id.edt12Pass);
        edtCPass = findViewById(R.id.edtCPass);
        edtExperience = findViewById(R.id.edtExperience);
        edtFuture = findViewById(R.id.edtFuture);


        chkJourney = findViewById(R.id.chkJourney);
        chkSpeaking = findViewById(R.id.chkSpeaking);
        chkWriting = findViewById(R.id.chkWriting);


        chkC = findViewById(R.id.chkC);
        chkCPlus = findViewById(R.id.chkCPlus);
        chkJava = findViewById(R.id.chkJava);
        chkAndroid = findViewById(R.id.chkAndroid);
        chkKotlin = findViewById(R.id.chkKotlin);
        chkPhp = findViewById(R.id.chkPhp);
        chkHtml = findViewById(R.id.chkHtml);
        chkCss = findViewById(R.id.chkCss);
        chkWeb = findViewById(R.id.chkWeb);
        rgGender = findViewById(R.id.rgGender);
        rgStatus = findViewById(R.id.rgStatus);
        btnSubmit = findViewById(R.id.btnSubmit);
    }

    private void output() {
        btnSubmit.setOnClickListener(v -> {
            String Firstname = edtFName.getText().toString();
            String Lastname = edtLName.getText().toString();
            String MobileNumber = edtNumber.getText().toString();
            String Email = edtEmail.getText().toString();
            String Address = edtAddress.getText().toString();
            String Experience = edtExperience.getText().toString();
            String Future = edtFuture.getText().toString();
            String Percentage10 = edt10Percentage.getText().toString();
            String Percentage12 = edt12Percentage.getText().toString();
            String PercentageF = edtFPercentage.getText().toString();
            String Pass10 = edt10Pass.getText().toString();
            String Pass12 = edt12Pass.getText().toString();
            String PassF = edtCPass.getText().toString();

            int selectedId = rgGender.getCheckedRadioButtonId();
            RadioButton rb = findViewById(selectedId);

            if (selectedId != -1) {
                gender = rb.getText().toString();
            }

            //Hobby
            if (chkJourney.isChecked()) {
                //hobby2 = chkSpeaking.getText().toString();
                hobby.append(" " + chkJourney.getText().toString());
            }
            if (chkSpeaking.isChecked()) {
                //hobby2 = chkSpeaking.getText().toString();
                hobby.append(" " + chkSpeaking.getText().toString());
            }
            if (chkWriting.isChecked()) {
                //hobby3 = chkWriting.getText().toString();
                hobby.append(" " + chkWriting.getText().toString());
            }

            //Status
            int selectedId1 = rgStatus.getCheckedRadioButtonId();
            RadioButton rb1 = findViewById(selectedId1);

            if (selectedId1 != -1) {
                status = rb1.getText().toString();
            }


            //languages
            if (chkC.isChecked()) {
                // language1 = chkC.getText().toString();
                skill.append(" " + chkC.getText().toString());
            }
            if (chkCPlus.isChecked()) {
                // language2 = chkCPlus.getText().toString();
                skill.append(" " + chkCPlus.getText().toString());
            }
            if (chkJava.isChecked()) {
                // language3 = chkJava.getText().toString();
                skill.append(" " + chkJava.getText().toString());
            }
            if (chkAndroid.isChecked()) {
                //language4 = chkAndroid.getText().toString();
                skill.append(" " + chkAndroid.getText().toString());
            }
            if (chkKotlin.isChecked()) {
                // language5 = chkKotlin.getText().toString();
                skill.append(" " + chkKotlin.getText().toString());
            }
            if (chkPhp.isChecked()) {
                //  language6 = chkPhp.getText().toString();
                skill.append(" " + chkPhp.getText().toString());
            }
            if (chkHtml.isChecked()) {
                // language7 = chkHtml.getText().toString();
                skill.append(" " + chkHtml.getText().toString());
            }
            if (chkCss.isChecked()) {
                //  language8 = chkCss.getText().toString();
                skill.append(" " + chkCss.getText().toString());
            }
            if (chkWeb.isChecked()) {
                // language9 = chkWeb.getText().toString();
                skill.append(" " + chkWeb.getText().toString());
            }


            if (Firstname.isEmpty()) {
                Toast.makeText(this, "First name is empty", Toast.LENGTH_SHORT).show();
            } else if (Firstname.length() < 3 || Firstname.length() > 10) {
                Toast.makeText(this, "Enter Firstname Minimum 4 to 10 digit", Toast.LENGTH_SHORT).show();
            } else if (Lastname.isEmpty()) {
                Toast.makeText(this, "Last name is empty", Toast.LENGTH_SHORT).show();
            } else if (Lastname.length() < 3 || Lastname.length() > 10) {
                Toast.makeText(this, "Enter Lastname Minimum 4 to 10 digit", Toast.LENGTH_SHORT).show();
            } else if (MobileNumber.isEmpty()) {
                Toast.makeText(this, "MobileNumber is empty", Toast.LENGTH_SHORT).show();
            } else if (MobileNumber.length() < 10) {
                Toast.makeText(this, "Enter MobileNumber Minimum 4 to 10 digit", Toast.LENGTH_SHORT).show();
            } else if (Email.isEmpty()) {
                Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT).show();
            } else if (Address.isEmpty()) {
                Toast.makeText(this, "Address is empty", Toast.LENGTH_SHORT).show();
            } else if (gender == null) {
                Toast.makeText(this, "Gender is Empty", Toast.LENGTH_SHORT).show();
            }

//            else if(hobby1 == null && hobby2 == null && hobby3 == null)
//            {
//                Toast.makeText(this, "Hobby is empty", Toast.LENGTH_SHORT).show();
//            }
            else if (hobby == null) {
                Toast.makeText(this, "Please select your Hobby", Toast.LENGTH_SHORT).show();
            } else if (status == null) {
                Toast.makeText(this, "Status is empty", Toast.LENGTH_SHORT).show();
            } else if (Percentage10.isEmpty()) {
                Toast.makeText(this, "Percentage10 is empty", Toast.LENGTH_SHORT).show();
            } else if (Percentage12.isEmpty()) {
                Toast.makeText(this, "Percentage12 is empty", Toast.LENGTH_SHORT).show();
            } else if (PercentageF.isEmpty()) {
                Toast.makeText(this, "PercentageF is empty", Toast.LENGTH_SHORT).show();
            } else if (Pass10.isEmpty()) {
                Toast.makeText(this, "Pass10 is empty", Toast.LENGTH_SHORT).show();
            } else if (Pass12.isEmpty()) {
                Toast.makeText(this, "Pass12 is empty", Toast.LENGTH_SHORT).show();
            } else if (PassF.isEmpty()) {
                Toast.makeText(this, "PassF is empty", Toast.LENGTH_SHORT).show();
            } else if (Experience.isEmpty()) {
                Toast.makeText(this, "Experience is empty", Toast.LENGTH_SHORT).show();
            } else if (Future.isEmpty()) {
                Toast.makeText(this, "Future is empty", Toast.LENGTH_SHORT).show();
            }

//            else if(language1 == null && language2 == null && language3 == null && language4 == null && language5 == null && language6 == null && language7 == null && language8 == null && language9 == null)
//            {
//                Toast.makeText(this, "Language is empty", Toast.LENGTH_SHORT).show();
//            }

            else if (skill == null) {
                Toast.makeText(this, "Please select your Language", Toast.LENGTH_SHORT).show();
            } else {

                Intent i = new Intent(MainActivity.this, MainActivity2.class);

                i.putExtra("Firstname", "Firstname           :  " + Firstname);
                i.putExtra("Lastname", "Lastname           :  " + Lastname);
                i.putExtra("Mobile Number", "Mobile Number :  " + MobileNumber);
                i.putExtra("Email", "Email                   :  " + Email);
                i.putExtra("Address", "Address              :  " + Address);
                i.putExtra("Experience", "Experience        :  " + Experience);
                i.putExtra("Future", "Future                :  " + Future);
                i.putExtra("hobby", "hobby                 :  " + hobby);

                i.putExtra("Gender", "Gender               :  " + gender);
                i.putExtra("Status", "Status                :  " + status);
                i.putExtra("language", "language           :  " + skill);
                i.putExtra("Percentage10", "Percentage10   :  " + Percentage10);
                i.putExtra("Percentage12", "Percentage12   :  " + Percentage12);
                i.putExtra("FinalPercentage", "FinalPercentage :  " + PercentageF);
                i.putExtra("passyear10", "passyear10        :  " + Pass10);
                i.putExtra("passyear12", "passyear12        :  " + Pass12);
                i.putExtra("FinalPassyear", "FinalPassyear   :  " + PassF);


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Permission Manager");
                builder.setMessage("Are you sure to Submit?");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int a) {
                        Toast.makeText(MainActivity.this, "This is yes button", Toast.LENGTH_SHORT).show();


                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                        builder1.setTitle("Permission Manager");
                        builder1.setMessage("Are you sure to Continue?");
                        builder1.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int a) {
                                Toast.makeText(MainActivity.this, "This is yes button", Toast.LENGTH_SHORT).show();


                                startActivity(i);
                            }
                        });
                        builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int a) {
                                Toast.makeText(MainActivity.this, "This is no button", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder1.setCancelable(false);
                        builder1.show();
                    }
                });


                builder.setCancelable(false);
                builder.show();

             }
     });
  }
}
