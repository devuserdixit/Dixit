package com.example.masterproject

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.masterproject.databinding.ActivityDashboardBinding
import com.example.masterproject.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {

    lateinit var binding: ActivityDashboardBinding
    lateinit var auth: FirebaseAuth
    lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        GoogleLogout()
        drawer()
        initView()
    }

    private fun initView() {
        var sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        binding.loutSignout.setOnClickListener {

            val myEdit: SharedPreferences.Editor = sharedPreferences.edit()
            myEdit.remove("isLogin")
            myEdit.commit()

            var i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()
        }

        loadFragment(DiscoverFragment())
        binding.bottomNavigationView.setOnItemSelectedListener (object : NavigationView.OnNavigationItemSelectedListener,
        NavigationBarView.OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                lateinit var fragment: Fragment
                when (item.itemId) {
                    R.id.discover_bottom -> {
                        fragment = DiscoverFragment()
                        loadFragment(fragment)
                    }
                    R.id.wishlist_bottom -> {
                        fragment = WishlistFragment()
                        loadFragment(fragment)
                    }
                    R.id.booking_bottom -> {
                        fragment = BookingsFragment()
                        loadFragment(fragment)
                    }
                    R.id.cart_bottom -> {
                        fragment = CartFragment()
                        loadFragment(fragment)
                    }
//                    R.id.location_bottom -> {
//                        fragment = MapFragment()
//                        loadFragment(fragment)
//                    }
                }
                return true
            }

        })
    }

    private fun loadFragment(f : Fragment) {
        val fm : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.loutContainer,f)
        fragmentTransaction.commit()
    }

    private fun drawer() {
        binding.imgmenu.setOnClickListener{
            binding.layoutDrawer.openDrawer(GravityCompat.START)
        }

//    private fun GoogleLogout() {
//        googleSignInClient = GoogleSignIn.getClient(this, GoogleSignInOptions.DEFAULT_SIGN_IN)
//        binding.btnLogout.setOnClickListener {
//            // Sign out from google
//            googleSignInClient.signOut().addOnCompleteListener { task ->
//                // Check condition
//                if (task.isSuccessful) {
//                    // When task is successful sign out from firebase
//                    auth.signOut()
//                    // Display Toast
//                    Toast.makeText(applicationContext, "Logout successful", Toast.LENGTH_SHORT)
//                        .show()
//                    // Finish activity
//                    finish()
//                }
//            }
//        }
    }
}