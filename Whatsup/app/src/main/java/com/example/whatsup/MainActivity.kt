package com.example.whatsup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whatsup.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import layout.WhatsupAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }
    private fun initview() {
//        tab name
        binding.tablayout.addTab(binding.tablayout.newTab().setText("Chats"))
        binding.tablayout.addTab(binding.tablayout.newTab().setText("Status"))
        binding.tablayout.addTab(binding.tablayout.newTab().setText("Calls"))
//        send value by constructor in adapter

        var adapter = WhatsupAdapter(supportFragmentManager,binding.tablayout.tabCount)
        binding.viewpager.adapter = adapter

//select tab listener
        binding.tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
               binding.viewpager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
//        change page - perform tab select
        binding.viewpager.addOnPageChangeListener(TabLayoutOnPageChangeListener(binding.tablayout))
    }
}