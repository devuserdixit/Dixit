package com.example.masterproject2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.masterproject2.databinding.ActivityDashboardBinding
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView

class DashboardActivity : AppCompatActivity() {

    lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        binding.discoverBottom.setOnClickListener{
            loadFragment(DiscoverFragment())
        }
       binding.wishlistBottom.setOnClickListener {
           loadFragment(WishlistFragment())
        }
        binding.bookingBottom.setOnClickListener {
            loadFragment(BookingsFragment())
        }
        binding.cartBottom.setOnClickListener {
            loadFragment(CartFragment())
        }
    }

    private fun loadFragment(f: Fragment) {
        val fm: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.loutContainer, f)
        fragmentTransaction.commit()
    }

    private fun drawer() {
        binding.imgmenu.setOnClickListener {
            binding.layoutDrawer.openDrawer(GravityCompat.START)
        }
    }
}