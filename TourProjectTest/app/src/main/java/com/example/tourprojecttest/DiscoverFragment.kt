package com.example.tourprojecttest

import android.content.Intent
import android.media.Rating
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tourprojecttest.databinding.FragmentDiscoverBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DiscoverFragment : Fragment() {

    lateinit var binding: FragmentDiscoverBinding
    lateinit var firebaseDatabase: DatabaseReference

    var CulturalExperiencesList = ArrayList<CulturalModalClass>()
    var CulturalSightsList = ArrayList<CulturalModalClass>()
    var TravelMemoriesList = ArrayList<CulturalModalClass>()
    var CulturalWorldList = ArrayList<CulturalModalClass>()

    lateinit var adapter1: CulturalExperiencesAdapter
    lateinit var adapter2: CulturalSightsAdapter
    lateinit var adapter3: TravelMemoriesAdapter
    lateinit var adapter4: CulturalWorldAdapter

    lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiscoverBinding.inflate(layoutInflater, container, false)


//        CulturalExperiences()
        CulturalSights()
        TravelMemories()
        CultureArroundtheWorld()

        return binding.root
    }

    private fun TravelMemories() {
        adapter3 = TravelMemoriesAdapter(this, TravelMemoriesList, {
            val intent = Intent(activity, DisplayPlaceActivity::class.java)
            intent.putExtra("title", it.title)
            intent.putExtra("Travelmemories", true)
            activity?.startActivity(intent)
        }, { status, title ->

            firebaseDatabase.child("Travelmemories").child(title).child("details")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var title = snapshot.child("title").value.toString()
                        var url = snapshot.child("url").value.toString()
                        var Aboutthisplace = snapshot.child("About this place").value.toString()
                        var Rating = snapshot.child("Rating").value.toString()

                        Log.e(
                            "TAG",
                            "like: " + title + " " + url + " " + Aboutthisplace + " " + Rating
                        )

                        firebaseDatabase.child("Travelmemories").child(title).child("details")
                            .child("user_data_storage").child(auth.currentUser?.uid!!)
                            .child(title)
                            .setValue(
                                LikeModelCass(
                                    url, title, Aboutthisplace, Rating
                                )
                            )

                        firebaseDatabase.child("user").child(auth.currentUser?.uid!!)
                            .child("user_records").child("status").child(title).setValue(
                                LikeModelCass(
                                    url, title, Aboutthisplace, Rating
                                )
                            )

                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })
        })
        firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("Travelmemories").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                TravelMemoriesList.clear()
                for (i in snapshot.children) {
                    val TravelMemoriesData = i.getValue(CulturalModalClass::class.java)

                    Log.e(
                        "TAG",
                        "onDataChange: " + TravelMemoriesData?.url + " " + TravelMemoriesData?.title
                    )
                    TravelMemoriesData?.let { d -> TravelMemoriesList.add(d) }
                    TravelMemoriesData?.title = i.child("title").value.toString()
                    TravelMemoriesData?.url = i.child("url").value.toString()

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

    private fun CulturalSights() {
        adapter2 = CulturalSightsAdapter(this, CulturalSightsList, {
            val intent = Intent(activity, DisplayPlaceActivity::class.java)
            intent.putExtra("title", it.title)
            intent.putExtra("Culturalsights", true)
            activity?.startActivity(intent)
        }, { status, title ->

            firebaseDatabase.child("Culturalsights").child(title).child("details")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var title = snapshot.child("title").value.toString()
                        var url = snapshot.child("url").value.toString()
                        var Aboutthisplace = snapshot.child("About this place").value.toString()
                        var Rating = snapshot.child("Rating").value.toString()

                        Log.e(
                            "TAG",
                            "like: " + title + " " + url + " " + Aboutthisplace + " " + Rating
                        )

                        firebaseDatabase.child("Culturalsights").child(title).child("details")
                            .child("user_data_storage").child(auth.currentUser?.uid!!)
                            .child(title)
                            .setValue(
                                LikeModelCass(
                                    url, title, Aboutthisplace, Rating
                                )
                            )

                        firebaseDatabase.child("user").child(auth.currentUser?.uid!!)
                            .child("user_records").child("status").child(title).setValue(
                                LikeModelCass(
                                    url, title, Aboutthisplace, Rating
                                )
                            )

                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })
        })
        firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("Culturalsights").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                CulturalSightsList.clear()
                for (i in snapshot.children) {
                    var CultureSightsData = i.getValue(CulturalModalClass::class.java)

                    Log.e(
                        "TAG",
                        "onDataChange: " + CultureSightsData?.url + " " + CultureSightsData?.title
                    )
                    CultureSightsData?.let { d -> CulturalSightsList.add(d) }
                    CultureSightsData?.title = i.child("title").value.toString()
                    CultureSightsData?.url = i.child("url").value.toString()
                }
                var manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.rcvCulturalSights.layoutManager = manager
                binding.rcvCulturalSights.adapter = adapter2
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    private fun CulturalExperiences() {
        adapter1 = CulturalExperiencesAdapter(this, CulturalExperiencesList, {
            val intent = Intent(activity, DisplayPlaceActivity::class.java)
            intent.putExtra("title", it.title)
            intent.putExtra("culturalexperiences", true)
            activity?.startActivity(intent)
        }, { status, title ->

            firebaseDatabase.child("culturalexperiences").child(title).child("details")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var title = snapshot.child("title").value.toString()
                        var url = snapshot.child("url").value.toString()
                        var Aboutthisplace = snapshot.child("About this place").value.toString()
                        var Rating = snapshot.child("Rating").value.toString()

                        Log.e(
                            "TAG",
                            "like: " + title + " " + url + " " + Aboutthisplace + " " + Rating
                        )

                        firebaseDatabase.child("culturalexperiences").child(title).child("details")
                            .child("user_data_storage").child(auth.currentUser?.uid!!)
                            .child(title)
                            .setValue(
                                LikeModelCass(
                                    url, title, Aboutthisplace, Rating
                                )
                            )

                        firebaseDatabase.child("user").child(auth.currentUser?.uid!!)
                            .child("user_records").child("status").child(title).setValue(
                                LikeModelCass(
                                    url, title, Aboutthisplace, Rating
                                )
                            )
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })
        })
        firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("culturalexperiences")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    CulturalExperiencesList.clear()
                    for (i in snapshot.children) {
                        var CultureExperiencesData = i.getValue(CulturalModalClass::class.java)

                        Log.e(
                            "TAG",
                            "onDataChange: " + CultureExperiencesData?.url + " " + CultureExperiencesData?.title
                        )
                        CultureExperiencesData?.let { d -> CulturalExperiencesList.add(d) }
                        CultureExperiencesData?.title = i.child("title").value.toString()
                        CultureExperiencesData?.url = i.child("url").value.toString()

                    }
                    var manager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    binding.rcvCulturalExperiences.layoutManager = manager
                    binding.rcvCulturalExperiences.adapter = adapter1
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("TAG", "onCancelled: $error")
                }
            })
    }

    private fun CultureArroundtheWorld() {
        adapter4 = CulturalWorldAdapter(this, CulturalWorldList, {
            val intent = Intent(activity, DisplayPlaceActivity::class.java)
            intent.putExtra("title", it.title)
            intent.putExtra("culturearoundtheworld", true)
            activity?.startActivity(intent)
        }, { status, title ->

            firebaseDatabase.child("culturearoundtheworld").child(title).child("details")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var title = snapshot.child("title").value.toString()
                        var url = snapshot.child("url").value.toString()
                        var Aboutthisplace = snapshot.child("About this place").value.toString()
                        var Rating = snapshot.child("Rating").value.toString()

                        Log.e(
                            "TAG",
                            "like: " + title + " " + url + " " + Aboutthisplace + " " + Rating
                        )

                        firebaseDatabase.child("culturearoundtheworld").child(title)
                            .child("details")
                            .child("user_data_storage").child(auth.currentUser?.uid!!)
                            .child(title)
                            .setValue(
                                LikeModelCass(
                                    url, title, Aboutthisplace, Rating
                                )
                            )

                        firebaseDatabase.child("user").child(auth.currentUser?.uid!!)
                            .child("user_records").child("status").child(title).setValue(
                                LikeModelCass(
                                    url, title, Aboutthisplace, Rating
                                )
                            )

                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })
        })
        firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("culturearoundtheworld")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    CulturalWorldList.clear()
                    for (i in snapshot.children) {
                        var CultureWorldData = i.getValue(CulturalModalClass::class.java)

                        Log.e(
                            "TAG",
                            "onDataChange: " + CultureWorldData?.url + " " + CultureWorldData?.title
                        )
                        CultureWorldData?.let { d -> CulturalWorldList.add(d) }
                        CultureWorldData?.title = i.child("title").value.toString()
                        CultureWorldData?.url = i.child("url").value.toString()
                    }
                    var manager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    binding.rcvCulturalWorld.layoutManager = manager
                    binding.rcvCulturalWorld.adapter = adapter4
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("TAG", "onCancelled: $error")
                }
            })
    }
}


class LikeModelCass(
    var url: String,
    var title: String,
    var Aboutthisplace: String,
    var Rating: String,
) {
}
