package com.example.project_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

//    var name : String = "Dikshit"
//    var id : Int = 1
//    var english : Int = 78
//    var maths : Int = 60
//    var hindi : Int = 75
//    var gujarati : Int = 80
//    var Tecnology : Int = 67
//    var mydata : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initview()

    }

    private fun initview() {

       var standard1 = ModalClass(1,"Akshay")
       var standard2 = ModalClass(1,"Brijesh")
       var standard3 = ModalClass(1,"Chandan")
       var standard4 = ModalClass(1,"Dikshit")
       var standard5 = ModalClass(1,"Elvish")

        Log.e("TAG", "initview: "+standard1.id+"="+standard1.name)
        Log.e("TAG", "initview: "+standard2.id+"="+standard2.name)
        Log.e("TAG", "initview: "+standard3.id+"="+standard3.name)
        Log.e("TAG", "initview: "+standard4.id+"="+standard4.name)
        Log.e("TAG", "initview: "+standard5.id+"="+standard5.name)

    }
}