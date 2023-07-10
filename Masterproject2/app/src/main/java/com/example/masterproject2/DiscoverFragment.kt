package com.example.masterproject2

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.masterproject2.databinding.FragmentDiscoverBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class DiscoverFragment : Fragment() {

    lateinit var binding: FragmentDiscoverBinding
    var TravelMomeriesList = ArrayList<CulturalModalClass>()
    lateinit var adapter3 : TravelMemoriesAdapter
    lateinit var firebaseDatabase: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiscoverBinding.inflate(inflater, container, false)
        return binding.root

        TravelMemories()
    }
    private fun TravelMemories() {
        adapter3 = TravelMemoriesAdapter(this, TravelMomeriesList)
        firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("Travel memories")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    TravelMomeriesList.clear()
                    for (i in snapshot.children) {
                        var TravelMemoriesData = i.getValue(CulturalModalClass::class.java)
                        TravelMemoriesData?.let { d -> TravelMomeriesList.add(d) }
                        TravelMemoriesData?.name=i.child("title").value.toString()
                        TravelMemoriesData?.image = i.child("url").value.toString()
                    }
                    var manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    binding.rcvTravelMemories.layoutManager = manager
                    binding.rcvTravelMemories.adapter = adapter3
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("TAG", "onCancelled: $error")
                }
            })
    }
}