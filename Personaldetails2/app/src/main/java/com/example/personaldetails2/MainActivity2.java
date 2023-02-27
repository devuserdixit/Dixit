package com.example.personaldetails2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity2 extends AppCompatActivity {


    TextView edtlanguage,edthobby,edtFname,edtLname, edtNumber, edtEmail, edtAddress, edt10Percentage, edt12Percentage, edtFPercentage, edt10Pass, edt12Pass, edtCPass, edtExperience, edtFuture,chkJourney, chkSpeaking, chkWriting, chkC, chkCPlus, chkJava, chkAndroid, chkKotlin, chkPhp, chkHtml, chkCss, chkWeb,rgGender, rgStatus;
    TextView hobby,language;
    CircleImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       output();
        imgloud();
    }

    private void imgloud()
    {
        image=findViewById(R.id.image);
        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(image);
//        Glide.with(this).load("https://source.unsplash.com/user/c_v_r/1900x800").into(image);
    }


    private void output(){

        edtFname = findViewById(R.id.edtFname);
        edtLname = findViewById(R.id.edtLname);
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
        edthobby=findViewById(R.id.edthobby);
        edtlanguage=findViewById(R.id.edtlanguage);
//        chkJourney = findViewById(R.id.chkJourney);
//        chkSpeaking = findViewById(R.id.chkSpeaking);
//        chkWriting = findViewById(R.id.chkWriting);
//        chkC = findViewById(R.id.chkC);
//        chkCPlus = findViewById(R.id.chkCPlus);
//        chkJava = findViewById(R.id.chkJava);
//        chkAndroid = findViewById(R.id.chkAndroid);
//        chkKotlin = findViewById(R.id.chkKotlin);
//        chkPhp = findViewById(R.id.chkPhp);
//        chkHtml = findViewById(R.id.chkHtml);
//        chkCss = findViewById(R.id.chkCss);
//        chkWeb = findViewById(R.id.chkWeb);
        rgGender = findViewById(R.id.rgGender);
        rgStatus = findViewById(R.id.rgStatus);


        String FirstName=getIntent().getStringExtra("Firstname");
        String Lastname=getIntent().getStringExtra("Lastname");
        String MobileNumber=getIntent().getStringExtra("Mobile Number");
        String Email=getIntent().getStringExtra("Email");
        String Address=getIntent().getStringExtra("Address");
        String Experience=getIntent().getStringExtra("Experience");
        String Future=getIntent().getStringExtra("Future");

        String hobby=getIntent().getStringExtra("hobby");
//        String Hobby1=getIntent().getStringExtra("Hobby1");
//        String Hobby2=getIntent().getStringExtra("Hobby2");
//        String Hobby3=getIntent().getStringExtra("Hobby3");

        String Gender=getIntent().getStringExtra("Gender");
        String Status=getIntent().getStringExtra("Status");

        String language=getIntent().getStringExtra("language");
//        String Language1=getIntent().getStringExtra("Language1");
//        String Language2=getIntent().getStringExtra("Language2");
//        String Language3=getIntent().getStringExtra("Language3");
//        String Language4=getIntent().getStringExtra("Language4");
//        String Language5=getIntent().getStringExtra("Language5");
//        String Language6=getIntent().getStringExtra("Language6");
//        String Language7=getIntent().getStringExtra("Language7");
//        String Language8=getIntent().getStringExtra("Language8");
//        String Language9=getIntent().getStringExtra("Language9");

        String Percentage10=getIntent().getStringExtra("Percentage10");
        String Percentage12=getIntent().getStringExtra("Percentage12");
        String FinalPercentage=getIntent().getStringExtra("FinalPercentage");
        String PassYear10=getIntent().getStringExtra("passyear10");
        String PassYear12=getIntent().getStringExtra("passyear12");
        String PassYearFinal=getIntent().getStringExtra("FinalPassyear");

        edtFname.setText(FirstName);
        edtLname.setText(Lastname);
        edtNumber.setText(MobileNumber);
        edtEmail.setText(Email);
        edtAddress.setText(Address);
        edt10Percentage.setText(Percentage10);
        edt12Percentage.setText(Percentage12);
        edtFPercentage.setText(FinalPercentage);
        edt10Pass.setText(PassYear10);
        edt12Pass.setText(PassYear12);
        edtCPass.setText(PassYearFinal);
        edtExperience.setText(Experience);
        edtFuture.setText(Future);

        edthobby.setText(hobby);
//        chkJourney.setText(Hobby1);
//        chkSpeaking.setText(Hobby2);
//        chkWriting.setText(Hobby3);

        edtlanguage.setText(language);
//        chkC.setText(Language1);
//        chkCPlus.setText(Language2);
//        chkJava.setText(Language3);
//        chkAndroid.setText(Language4);
//        chkKotlin.setText(Language5);
//        chkPhp.setText(Language6);
//        chkHtml.setText(Language7);
//        chkCss.setText(Language8);
//        chkWeb.setText(Language9);

        rgGender.setText(Gender);
        rgStatus.setText(Status);

    }
}