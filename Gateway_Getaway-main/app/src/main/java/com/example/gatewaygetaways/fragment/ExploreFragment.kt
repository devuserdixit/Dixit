package com.example.gatewaygetaways.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.gatewaygetaways.activity.DisplayplaceActivity
import com.example.gatewaygetaways.adapter.*
import com.example.gatewaygetaways.databinding.FragmentExploreBinding
import com.example.gatewaygetaways.modelclass.ModelClassForDestinaion
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase


class ExploreFragment : Fragment() {
    lateinit var firebaseDatabase: DatabaseReference
    lateinit var exploreBinding: FragmentExploreBinding

    var mountainlist = ArrayList<ModelClassForDestinaion>()
    var junglelist = ArrayList<ModelClassForDestinaion>()
    var culturalsitelist = ArrayList<ModelClassForDestinaion>()
    var warmdestinationlist = ArrayList<ModelClassForDestinaion>()
    var topdestinationlist = ArrayList<ModelClassForDestinaion>()

    lateinit var rcvexplore: RecyclerView
    lateinit var rcvculturalsite: RecyclerView
    lateinit var rcvjunglesafari: RecyclerView
    lateinit var rcvwarmdestination: RecyclerView
    lateinit var rcvtrendingdestination: RecyclerView

    lateinit var adaptermountain: MountainAdapter
    lateinit var adapterjunglesafari: JungleSafariAdapter
    lateinit var adapterwarmdestination: WarmDestinationAdapter
    lateinit var adapterculturalsite: CulturalSiteAdapter
    lateinit var adaptertrendingdestination: TrendindDestinationAdapter

    lateinit var auth: FirebaseAuth

    var userclickedon = "Auli Mountain"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        exploreBinding = FragmentExploreBinding.inflate(layoutInflater, container, false)

        auth = Firebase.auth

        initview()
        junglesafari()
        warmdestination()
        culturalsite()
        trendingdestination()
//        workingcode()

        return exploreBinding.root

    }

//    private fun workingcode() {
//        exploreBinding.txttitleheading.setOnClickListener{
//            val nextfragment = BookingFragment()
//            val fragmentTransaction = requireFragmentManager().beginTransaction()
//            fragmentTransaction.replace(R.id.frameofbookingfragment,nextfragment)
//            fragmentTransaction.addToBackStack(null)
//            fragmentTransaction.commit()
//        }
//    }

    private fun trendingdestination() {
        adaptertrendingdestination = TrendindDestinationAdapter(this, topdestinationlist) {

            val intent = Intent(activity, DisplayplaceActivity::class.java)
            intent.putExtra("name", it.name)
            intent.putExtra("topddestination", true)
            activity?.startActivity(intent)

        }
        firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("trendingdestination")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (i in snapshot.children) {
                        var topdestinationdata = i.getValue(ModelClassForDestinaion::class.java)
                        Log.e(
                            "TAG",
                            "topdestination:" + topdestinationdata?.image + " " + topdestinationdata?.name
                        )
                        topdestinationdata?.let { d -> topdestinationlist.add(d) }
                        topdestinationdata?.image = i.child("image").value.toString()
                        topdestinationdata?.name = i.child("name").value.toString()
                    }
                    // setting recyclerView layoutManager
                    val layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    exploreBinding.rcvtrendingdestination.layoutManager = layoutManager
                    exploreBinding.rcvtrendingdestination.adapter = adaptertrendingdestination
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }

    private fun culturalsite() {
        adapterculturalsite = CulturalSiteAdapter(this, culturalsitelist, {

            val intent = Intent(activity, DisplayplaceActivity::class.java)
            intent.putExtra("name", it.name)
            intent.putExtra("culturalsite", true)
            activity?.startActivity(intent)
        }, { status, name ->

            // display mountain recycle view path
                firebaseDatabase.child("culturalsites").child(name).child("details")
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            var name = snapshot.child("name").value.toString()
                            var amount = snapshot.child("amount").value.toString()
                            var image = snapshot.child("image").value.toString()
                            var info = snapshot.child("info").value.toString()
                            var rateing = snapshot.child("rateing").value.toString()
                            var location = snapshot.child("location").value.toString()

                            Log.e("TAG", "like: " + name)

                            firebaseDatabase.child("culturalsites").child(name).child("details")
                                .child("user_data_storage").child(auth.currentUser?.uid!!)
                                .child(name)
                                .setValue(
                                    LikeModelCass(
                                        image, name, amount, rateing, info, location
                                    )
                                )

                            firebaseDatabase.child("user").child(auth.currentUser?.uid!!)
                                .child("user_records").child("status").child(name).setValue(
                                    LikeModelCass(
                                        image, name, amount, rateing, info, location
                                    )
                                )

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }

                    })

            })

        firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("culturalsites")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    culturalsitelist.clear()
                    for (i in snapshot.children) {
                        var culturalsitedata = i.getValue(ModelClassForDestinaion::class.java)
                        Log.e(
                            "TAG",
                            "culturalsite:" + culturalsitedata?.image + " " + culturalsitedata?.name
                        )
                        culturalsitedata?.let { d -> culturalsitelist.add(d) }
                        culturalsitedata?.image = i.child("image").value.toString()
                        culturalsitedata?.name = i.child("name").value.toString()
                    }

                    // setting recyclerView layoutManager

                    val layoutManager: RecyclerView.LayoutManager =
                        StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    exploreBinding.rcvculturalsite.layoutManager = layoutManager
                    exploreBinding.rcvculturalsite.adapter = adapterculturalsite
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }

    private fun warmdestination() {
        adapterwarmdestination = WarmDestinationAdapter(this, warmdestinationlist, {

            val warmintent = Intent(activity, DisplayplaceActivity::class.java)
            warmintent.putExtra("name", it.name)
            warmintent.putExtra("beachdestination", true)
            activity?.startActivity(warmintent)

        }, { status, name ->

            // display mountain recycle view path
            firebaseDatabase.child("warmdestination").child(name).child("details")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var name = snapshot.child("name").value.toString()
                        var amount = snapshot.child("amount").value.toString()
                        var image = snapshot.child("image").value.toString()
                        var info = snapshot.child("info").value.toString()
                        var rateing = snapshot.child("rateing").value.toString()
                        var location = snapshot.child("location").value.toString()

                        Log.e("TAG", "like: " + name)

                        firebaseDatabase.child("warmdestination").child(name).child("details")
                            .child("user_data_storage").child(auth.currentUser?.uid!!)
                            .child(name)
                            .setValue(
                                LikeModelCass(
                                    image, name, amount, rateing, info, location
                                )
                            )

                        firebaseDatabase.child("user").child(auth.currentUser?.uid!!)
                            .child("user_records").child("status").child(name).setValue(
                                LikeModelCass(
                                    image, name, amount, rateing, info, location
                                )
                            )

                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })

        })
        firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("warmdestination")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    warmdestinationlist.clear()
                    for (i in snapshot.children) {
                        var warmdestinationdata =
                            i.getValue(ModelClassForDestinaion::class.java)
                        Log.e(
                            "TAG",
                            "warmdestination:" + warmdestinationdata?.image + " " + warmdestinationdata?.location + " " + warmdestinationdata?.name + " " + warmdestinationdata?.amount
                        )
                        warmdestinationdata?.let { d -> warmdestinationlist.add(d) }
                        warmdestinationdata?.amount = i.child("amount").value.toString()
                        warmdestinationdata?.image = i.child("image").value.toString()
                        warmdestinationdata?.location = i.child("location").value.toString()
                        warmdestinationdata?.name = i.child("name").value.toString()
                    }
                    val LayoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    exploreBinding.rcvwarmdestination.layoutManager = LayoutManager
                    exploreBinding.rcvwarmdestination.adapter = adapterwarmdestination
                }

                override fun onCancelled(error: DatabaseError) {


                }

            })

    }

    private fun junglesafari() {

        adapterjunglesafari = JungleSafariAdapter(this, junglelist, {

            val args = Bundle()
            args.putString("name", it.name)
            Log.e("TAG", "Junglename: " + it.name)
//            val args = Bundle()
//            args.putString("name", it.name)
//            Log.e("TAG", "junlenamevaluename: "+it.name)
//            val nextfragment = BookingFragment()
//            nextfragment.setArguments(args)
//            Log.e("TAG", "jungleargsvalue: "+args )
//            val fragmentTransaction = requireFragmentManager().beginTransaction()
//            fragmentTransaction.replace(R.id.frameLayout, nextfragment)
//            fragmentTransaction.commit()

            val jungleintent = Intent(activity, DisplayplaceActivity::class.java)
            jungleintent.putExtra("name", it.name)
            jungleintent.putExtra("jungledestination", true)
            activity?.startActivity(jungleintent)


        }, { status, name ->

            // display mountain recycle view path
            firebaseDatabase.child("junglesafari").child(name).child("details")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var name = snapshot.child("name").value.toString()
                        var amount = snapshot.child("amount").value.toString()
                        var image = snapshot.child("image").value.toString()
                        var info = snapshot.child("info").value.toString()
                        var rateing = snapshot.child("rateing").value.toString()
                        var location = snapshot.child("location").value.toString()

                        Log.e("TAG", "like: " + name)

                        firebaseDatabase.child("junglesafari").child(name).child("details")
                            .child("user_data_storage").child(auth.currentUser?.uid!!)
                            .child(name)
                            .setValue(
                                LikeModelCass(
                                    image, name, amount, rateing, info, location
                                )
                            )

                        firebaseDatabase.child("user").child(auth.currentUser?.uid!!)
                            .child("user_records").child("status").child(name).setValue(
                                LikeModelCass(
                                    image, name, amount, rateing, info, location
                                )
                            )

                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })


        })


        firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("junglesafari")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    junglelist.clear()
                    for (i in snapshot.children) {
                        var junglesafaridata = i.getValue(ModelClassForDestinaion::class.java)
                        Log.e(
                            "TAG",
                            "onDataChangejunglesafari:" + junglesafaridata?.image + " " + junglesafaridata?.location + " " + junglesafaridata?.name + " " + junglesafaridata?.amount
                        )
                        junglesafaridata?.let { d -> junglelist.add(d) }
                        junglesafaridata?.amount = i.child("amount").value.toString()
                        junglesafaridata?.image = i.child("image").value.toString()
                        junglesafaridata?.location = i.child("location").value.toString()
                        junglesafaridata?.name = i.child("name").value.toString()
                    }

                    val LayoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    exploreBinding.rcvjunglesafari.layoutManager = LayoutManager
                    exploreBinding.rcvjunglesafari.adapter = adapterjunglesafari
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })


    }

    private fun initview() {


        adaptermountain = MountainAdapter(this, mountainlist, {

            val args = Bundle()
            args.putString("name", it.name)
            Log.e("TAG", "Mountainname: " + it.name)
//                val nextfragment = GoogleMapsFragment()
//                nextfragment.setArguments(args)
//                Log.e("TAG", "initviewars: "+args )
//                val fragmentTransaction = requireFragmentManager().beginTransaction()
//                fragmentTransaction.replace(R.id.frameLayout, nextfragment)
//                fragmentTransaction.commit()
            // like function here
            val intent = Intent(activity, DisplayplaceActivity::class.java)
            intent.putExtra("name", it.name)
            intent.putExtra("loadsPosition", true)
            activity?.startActivity(intent)
        }, { status, name ->
            // display mountain recycle view path
            firebaseDatabase.child("mountain").child(name).child("details")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var name = snapshot.child("name").value.toString()
                        var amount = snapshot.child("amount").value.toString()
                        var image = snapshot.child("image").value.toString()
                        var info = snapshot.child("info").value.toString()
                        var rateing = snapshot.child("rateing").value.toString()
                        var location = snapshot.child("location").value.toString()

                        Log.e("TAG", "like:" + location)

                        firebaseDatabase.child("mountain").child(name).child("details")
                            .child("user_data_storage").child(auth.currentUser?.uid!!)
                            .child(name)
                            .setValue(
                                LikeModelCass(
                                    image, name, amount, rateing, info, location
                                )
                            )

                        firebaseDatabase.child("user").child(auth.currentUser?.uid!!)
                            .child("user_records").child("status").child(name).setValue(
                                LikeModelCass(
                                    image, name, amount, rateing, info, location
                                )
                            )

                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })


        }, { cart, name ->

            firebaseDatabase.child("mountain").child(name).child("details")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var cartname = snapshot.child("name").value.toString()
                        var cartamount = snapshot.child("amount").value.toString()
                        var cartimage = snapshot.child("image").value.toString()
                        var cartinfo = snapshot.child("info").value.toString()
                        var cartrateing = snapshot.child("rateing").value.toString()
                        var cartlocation = snapshot.child("location").value.toString()

                        Log.e("TAG", "like:" + cartlocation)

                        firebaseDatabase.child("mountain").child(name).child("details")
                            .child("cart_data_storage").child(auth.currentUser?.uid!!)
                            .child(name)
                            .setValue(
                                LikeModelCass(
                                    cartimage,
                                    cartname,
                                    cartamount,
                                    cartrateing,
                                    cartinfo,
                                    cartlocation
                                )
                            )

                        firebaseDatabase.child("cart").child(name).child(auth.currentUser?.uid!!)
                            .child("cart_records")
                            .child("cartlist").child(name)
                            .setValue(
                                LikeModelCass(
                                    cartimage,
                                    cartname,
                                    cartamount,
                                    cartrateing,
                                    cartinfo,
                                    cartlocation
                                )
                            )
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })

        })
        firebaseDatabase = FirebaseDatabase.getInstance().reference
        firebaseDatabase.child("mountain").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                mountainlist.clear()
                for (i in snapshot.children) {

                    val data = i.getValue(ModelClassForDestinaion::class.java)
                    Log.e(
                        "TAG",
                        "dashboardmountain:" + data?.image + " " + data?.location + " " + data?.name + " " + data?.amount
                    )
                    data?.let { d -> mountainlist.add(d) }
                    data?.amount = i.child("amount").value.toString()
                    data?.image = i.child("image").value.toString()
                    data?.location = i.child("location").value.toString()
                    data?.name = i.child("name").value.toString()
//                    data?.rateing=i.child("rateing").value.toString()
//                    data?.details=i.child("details").value.toString()
                }


                val LayoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                exploreBinding.rcvexplore.layoutManager = LayoutManager
                exploreBinding.rcvexplore.adapter = adaptermountain
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })


    }

}

class LikeModelCass(
    var image: String,
    var name: String,
    var amount: String,
    var rateing: String,
    var info: String,
    var location: String
) {
}

