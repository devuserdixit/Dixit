package com.example.masterproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.masterproject.databinding.FragmentDiscoverBinding
import com.google.firebase.database.DatabaseReference

//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.DatabaseReference
//import com.google.firebase.database.FirebaseDatabase
//import com.google.firebase.database.ValueEventListener

class DiscoverFragment : Fragment() {

    lateinit var binding: FragmentDiscoverBinding

//    lateinit var firebaseDatabase: DatabaseReference
//    var CulturalExperiencesList = ArrayList<CulturalModalClass>()
//    var CulturalSightsList = ArrayList<CulturalModalClass>()
//    var TravelMomeriesList = ArrayList<CulturalModalClass>()
//    var CulturalWorldList = ArrayList<CulturalModalClass>()
//    lateinit var adapter1: CulturalExperiencesAdapter
//    lateinit var adapter2 : CulturalSightsAdapter
//    lateinit var adapter3 : TravelMemoriesAdapter
//    lateinit var adapter4 : CulturalWorldAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiscoverBinding.inflate(layoutInflater, container, false)
        return binding.root

//        CulturalExperiences()
//        CulturalSights()
//        TravelMemories()
//        CultureArroundtheWorld()
    }

//    private fun CulturalSights() {
//        adapter2 = CulturalSightsAdapter(this, CulturalSightsList)
//        firebaseDatabase = FirebaseDatabase.getInstance().reference
//        firebaseDatabase.child("Cultural sights")
//            .addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    CulturalSightsList.clear()
//                    for (i in snapshot.children) {
//                        var CultureSightsData = i.getValue(CulturalModalClass::class.java)
//                        CultureSightsData?.let { d -> CulturalExperiencesList.add(d) }
//                        CultureSightsData?.name=i.child("title").value.toString()
//                        CultureSightsData?.image = i.child("url").value.toString()
//                    }
//                    var manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//                    binding.rcvCulturalSights.layoutManager = manager
//                    binding.rcvCulturalSights.adapter = adapter2
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                }
//            })
//    }
//
//    private fun CulturalExperiences() {
//        adapter1 = CulturalExperiencesAdapter(this, CulturalExperiencesList)
//        firebaseDatabase = FirebaseDatabase.getInstance().reference
//        firebaseDatabase.child("cultural experiences")
//            .addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    CulturalExperiencesList.clear()
//                    for (i in snapshot.children) {
//                        var CultureExperiencesData = i.getValue(CulturalModalClass::class.java)
//                        CultureExperiencesData?.let { d -> CulturalExperiencesList.add(d) }
//                        CultureExperiencesData?.name=i.child("title").value.toString()
//                        CultureExperiencesData?.image = i.child("url").value.toString()
//
//                    }
//                    var manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//                    binding.rcvCulturalExperiences.layoutManager = manager
//                    binding.rcvCulturalExperiences.adapter = adapter1
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    Log.e("TAG", "onCancelled: $error")
//                }
//            })
//    }
//
//    private fun TravelMemories() {
//        adapter3 = TravelMemoriesAdapter(this, TravelMomeriesList)
//        firebaseDatabase = FirebaseDatabase.getInstance().reference
//        firebaseDatabase.child("Travel memories")
//            .addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    TravelMomeriesList.clear()
//                    for (i in snapshot.children) {
//                        var TravelMemoriesData = i.getValue(CulturalModalClass::class.java)
//                        TravelMemoriesData?.let { d -> TravelMomeriesList.add(d) }
//                        TravelMemoriesData?.name=i.child("title").value.toString()
//                        TravelMemoriesData?.image = i.child("url").value.toString()
//                    }
//                    var manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//                    binding.rcvTravelMemories.layoutManager = manager
//                    binding.rcvTravelMemories.adapter = adapter3
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    Log.e("TAG", "onCancelled: $error")
//                }
//            })
//    }
//
//    private fun CultureArroundtheWorld() {
//        adapter4 = CulturalWorldAdapter(this, CulturalWorldList)
//        firebaseDatabase = FirebaseDatabase.getInstance().reference
//        firebaseDatabase.child("culture around the world")
//            .addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    CulturalWorldList.clear()
//                    for (i in snapshot.children) {
//                        var CultureWorldData = i.getValue(CulturalModalClass::class.java)
//                        CultureWorldData?.let { d -> CulturalWorldList.add(d) }
//                        CultureWorldData?.name=i.child("title").value.toString()
//                        CultureWorldData?.image = i.child("url").value.toString()
//                    }
//                    var manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//                    binding.rcvCulturalWorld.layoutManager = manager
//                    binding.rcvCulturalWorld.adapter = adapter4
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    Log.e("TAG", "onCancelled: $error")
//                }
//            })
//    }
}