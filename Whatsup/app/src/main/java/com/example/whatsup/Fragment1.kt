package com.example.whatsup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.whatsup.databinding.Fragment1Binding

class Fragment1 : Fragment() {

    lateinit var chatsbinding: Fragment1Binding

    var imageList = ArrayList<Int>()
    var nameList = ArrayList<String>()
    var subNameList = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        chatsbinding = Fragment1Binding.inflate(layoutInflater,container,false)

        initview()
        return chatsbinding.root
    }

    private fun initview() {
        information()
    }

    private fun information() {

        imageList.clear()

        imageList.add(R.drawable.image3)
        imageList.add(R.drawable.image3)
        imageList.add(R.drawable.image3)
        imageList.add(R.drawable.image3)
        imageList.add(R.drawable.image3)
        imageList.add(R.drawable.image3)
        imageList.add(R.drawable.image3)
        imageList.add(R.drawable.image3)

        nameList.clear()

        nameList.add("Dikshit")
        nameList.add("Dixit")
        nameList.add("Dikshit")
        nameList.add("Dikshit")
        nameList.add("Dikshit")
        nameList.add("Dikshit")
        nameList.add("Dikshit")
        nameList.add("Dikshit")

        subNameList.clear()

        subNameList.add("Hello Friends")
        subNameList.add("Hello Friends")
        subNameList.add("Hello Friends")
        subNameList.add("Hello Friends")
        subNameList.add("Hello Friends")
        subNameList.add("Hello Friends")
        subNameList.add("Hello Friends")
        subNameList.add("Hello Friends")
    }

}