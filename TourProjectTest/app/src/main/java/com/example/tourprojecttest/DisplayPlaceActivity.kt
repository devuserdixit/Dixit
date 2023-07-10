package com.example.tourprojecttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.tourprojecttest.databinding.ActivityDisplayPlaceBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.NonCancellable

class DisplayPlaceActivity : AppCompatActivity() {

    lateinit var binding: ActivityDisplayPlaceBinding
    lateinit var firebaseDatabase: DatabaseReference
    lateinit var mountainlist: ArrayList<CulturalModalClass>
    lateinit var adapterhotel: HotelAdapter
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDisplayPlaceBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
        auth = Firebase.auth

        loadingmap()
        initView()
    }

    private fun initView() {
        binding.imgdisback.setOnClickListener {
            onBackPressed()
        }


        if (NonCancellable.key != null && intent.hasExtra("Travelmemories")) {
            // for trending destination

            firebaseDatabase = FirebaseDatabase.getInstance().reference
            var trendingvalue = intent.getStringExtra("title").toString()
            Log.e("TAG", "initview " + trendingvalue)

            firebaseDatabase.child("Travelmemories").child(trendingvalue).child("details")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var image4 = snapshot.child("url").value.toString()
                        var name4 = snapshot.child("title").value.toString()
                        var rateing4 = snapshot.child("Rating").value.toString()
                        var amount4 = snapshot.child("About this place").value.toString()
//                        var details4 = snapshot.child("info").value.toString()
//                        var location4 = snapshot.child("location").value.toString()

//                        val mFragmentManagertopdestination = supportFragmentManager
//                        val mFragmentTransactiontopdestination = mFragmentManagertopdestination.beginTransaction()
//                        val mFragmenttopdestination = GoogleMapsFragment()


                        Log.e(
                            "TAG",
                            "onDataChangemountain: " + image4 + " " + name4 + " " + rateing4 + " " + amount4
                        )

                        Glide.with(this@DisplayPlaceActivity).load(image4)
                            .placeholder(R.drawable.place).into(binding.imgplaceimage)
                        binding.txtplacename.text = name4
                        binding.txtrateing.text = rateing4
                        binding.txtfragamount.text = amount4
//                        binding.txtabouttheplace.text = details4
//                        binding.txtlocation.text = location4
                        binding.txttitlename.text = name4

//                        val bundle = Bundle()
//                        bundle.putString("name",name4)
//                        Log.e("TAG", "Tvalue: "+name4 )
//                        bundle.putBoolean("topddestination",true)
//                        mFragmenttopdestination.arguments = bundle
//                        mFragmentTransactiontopdestination.add(R.id.mapframe,mFragmenttopdestination).commit()
//                        Log.e("TAG", "onDataChangfgde: "+ bundle )
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })
        }
    }

    private fun loadingmap() {
        supportFragmentManager.beginTransaction().replace(R.id.mapframe, LocationFragment())
            .commit()
    }
}
