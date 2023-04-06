package com.example.recycleviewinvoke

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewinvoke.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var list = ArrayList<CountryModal>()
    var name = ArrayList<String>()
    var countrycode = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview();
    }

    private fun initview() {
        for (i in 0..name.size) {
            var model = CountryModal(countrycode,name)
            list.add(model)

            countrycode.add(91)
            name.add("India")

            countrycode.add(92)
            name.add("Pakistan")

            var adapter = CountryAdapter(list)
            var manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            binding.rcvlist.layoutManager = manager
            binding.rcvlist.adapter = adapter

        }
    }
}