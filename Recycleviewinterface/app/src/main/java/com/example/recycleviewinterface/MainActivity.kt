package com.example.recycleviewinterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewinterface.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    var  list = ArrayList<ModalClass>()
    var name = ArrayList<String>()
    var id = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview();
    }

    private fun initview() {
        for (i in 0..name.size){
            var model = ModalClass(id,name)
            list.add(model)

            id.add(2)
            name.add("Dikshit")

            var adapter = MyAdapterClass(list)
            var manager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            binding.rcvList.layoutManager=manager
           binding.rcvList.adapter=adapter

        }
    }
}