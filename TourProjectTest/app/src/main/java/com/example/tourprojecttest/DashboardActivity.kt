package com.example.tourprojecttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.tourprojecttest.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        drawer()
    }

    private fun initView() {
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
        binding.locationBottom.setOnClickListener {
            loadFragment(LocationFragment())
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