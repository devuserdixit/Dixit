package com.example.modalclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Student1
        StudentsModal data1 = new StudentsModal();
        data1.setName("jay");
        data1.setId(1);
        data1.setEnglish(70.88);
        data1.setHindi(80.55);
        data1.setGujarati(73.66);

        String name=data1.getName();
        Log.e("TAG", "Name: "+name );
        int id=data1.getid();
        Log.e("TAG", "Id: "+id);
        Double english=data1.getenglish();
        Log.e("TAG", "English: "+english );
        Double hindi=data1.gethindi();
        Log.e("TAG", "Hindi: "+hindi );
        Double gujarati=data1.getgujarati();
        Log.e("TAG", "Gujarati: "+gujarati );


        //        Student2
        StudentsModal data2 = new StudentsModal();
        data2.setName("Sanjay");
        data2.setId(2);
        data2.setEnglish(75.80);
        data2.setHindi(85.75);
        data2.setGujarati(63.86);

        String name2=data2.getName();
        Log.e("TAG", "Name: "+name2 );
        int id2=data2.getid();
        Log.e("TAG", "Id: "+id2);
        Double english2=data2.getenglish();
        Log.e("TAG", "English: "+english2 );
        Double hindi2=data2.gethindi();
        Log.e("TAG", "Hindi: "+hindi2 );
        Double gujarati2=data2.getgujarati();
        Log.e("TAG", "Gujarati: "+gujarati2);

        //        Student3
        StudentsModal data3 = new StudentsModal();
        data3.setName("himanshu");
        data3.setId(3);
        data3.setEnglish(87.76);
        data3.setHindi(90.54);
        data3.setGujarati(65.33);

        String name3=data3.getName();
        Log.e("TAG", "Name: "+name3 );
        int id3=data3.getid();
        Log.e("TAG", "Id: "+id3);
        Double english3=data3.getenglish();
        Log.e("TAG", "English: "+english3);
        Double hindi3=data3.gethindi();
        Log.e("TAG", "Hindi: "+hindi3 );
        Double gujarati3=data3.getgujarati();
        Log.e("TAG", "Gujarati: "+gujarati3 );


        //        Student4
        StudentsModal data4 = new StudentsModal();
        data4.setName("hasu");
        data4.setId(4);
        data4.setEnglish(67.76);
        data4.setHindi(76.89);
        data4.setGujarati(80.89);

        String name4=data4.getName();
        Log.e("TAG", "Name: "+name4 );
        int id4=data4.getid();
        Log.e("TAG", "Id: "+id4);
        Double english4=data4.getenglish();
        Log.e("TAG", "English: "+english4 );
        Double hindi4=data4.gethindi();
        Log.e("TAG", "Hindi: "+hindi4 );
        Double gujarati4=data4.getgujarati();
        Log.e("TAG", "Gujarati: "+gujarati4 );


       //        Student5
        StudentsModal data5 = new StudentsModal();
        data5.setName("Bhavesh");
        data5.setId(5);
        data5.setEnglish(54.21);
        data5.setHindi(64.67);
        data5.setGujarati(75.49);

        String name5=data5.getName();
        Log.e("TAG", "Name: "+name5 );
        int id5=data5.getid();
        Log.e("TAG", "Id: "+id5);
        Double english5=data5.getenglish();
        Log.e("TAG", "English: "+english5);
        Double hindi5=data5.gethindi();
        Log.e("TAG", "Hindi: "+hindi5 );
        Double gujarati5=data5.getgujarati();
        Log.e("TAG", "Gujarati: "+gujarati5 );
    }
}