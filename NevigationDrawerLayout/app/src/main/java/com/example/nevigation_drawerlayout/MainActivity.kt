package com.example.nevigation_drawerlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import com.example.nevigation_drawerlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview();
    }

    private fun initview() {
        binding.imgmenu.setOnClickListener {
            binding.drawerlayout.openDrawer(GravityCompat.START)
        }
    }
}