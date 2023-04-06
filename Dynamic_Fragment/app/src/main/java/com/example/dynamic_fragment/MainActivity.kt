package com.example.dynamic_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var loutContainer : FrameLayout
    lateinit var homefragment : ImageView
    lateinit var searchfragment : ImageView
    lateinit var libraryfragment : ImageView
    lateinit var premiumfragment : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initview()
    }

    private fun initview() {
        loutContainer = findViewById(R.id.loutContainer)
        homefragment = findViewById(R.id.homefragment)
        searchfragment = findViewById(R.id.searchfragment)
        libraryfragment = findViewById(R.id.libraryfragment)
        premiumfragment = findViewById(R.id.premiumfragment)

        loutFragment(homefragment())
        homefragment.setOnClickListener{
            loutFragment(homefragment())
        }
        searchfragment.setOnClickListener {
            loutFragment(searchfragment())
        }
        libraryfragment.setOnClickListener {
            loutFragment(libraryfragment())
        }
        premiumfragment.setOnClickListener {
            loutFragment(premiumfragment())
        }
    }

    fun loutFragment(f : Fragment)
    {
        val fm : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.loutContainer,f)
        fragmentTransaction.commit()
    }
}