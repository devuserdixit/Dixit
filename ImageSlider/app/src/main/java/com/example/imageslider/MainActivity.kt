package com.example.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import java.util.function.IntFunction

class MainActivity : AppCompatActivity() {
   lateinit var txtCount : TextView
lateinit var imageViewMain : ViewPager
var images = intArrayOf(R.drawable.image1,
        R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initview()
    }

    private fun initview() {
        imageViewMain = findViewById(R.id.imageViewMain)
        txtCount = findViewById(R.id.txtCount)

        imageViewMain.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position : Int,
                positionOffset : Float,
                positionOffsetPixels : Int
            ){
                Log.e("TAG", "onPageScrolled: " )
            }

            override fun onPageSelected(position: Int) {
                txtCount.text="${position+1}/5"
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })

        var ImageAdapter = ImageAdapter(images)
        imageViewMain.adapter = ImageAdapter
    }
}