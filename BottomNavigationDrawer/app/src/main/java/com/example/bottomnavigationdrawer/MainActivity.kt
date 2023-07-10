package com.example.bottomnavigationdrawer

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.bottomnavigationdrawer.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var onBackpressedListener: OnBackPressedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView();
    }

    private fun initView() {
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setTitleTextColor(Color.WHITE)


        supportActionBar!!.title = "Home"
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment()).commit()
        binding.navView.setCheckedItem(R.id.drawer_home)
        toggle = ActionBarDrawerToggle(
            this,
            binding.drawer,
            binding.toolbar,
            R.string.open,
            R.string.close
        )
        binding.drawer.addDrawerListener(toggle)
        toggle!!.drawerArrowDrawable.color = resources.getColor(R.color.white)
        toggle!!.syncState()

        binding.navView.setNavigationItemSelectedListener(object :
            NavigationView.OnNavigationItemSelectedListener {
           lateinit var fragment: Fragment
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.getItemId()) {
                    R.id.drawer_home -> {
                        fragment = HomeFragment()
                        binding.drawer.closeDrawer(GravityCompat.START)
                        supportActionBar!!.setTitle("Home")
                        callFragment(fragment)
                    }
                    R.id.drawer_contact -> {
                        fragment = CallFragment()
                        binding.drawer.closeDrawer(GravityCompat.START)
                        supportActionBar!!.setTitle("Contact US")
                        callFragment(fragment)
                    }
                    R.id.drawer_about -> {
                        fragment = ChatFragment()
                        binding.drawer.closeDrawer(GravityCompat.START)
                        supportActionBar!!.setTitle("About US")
                        callFragment(fragment)
                    }
                }
                return true
            }
        })


        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_bottom -> callFragment(HomeFragment())
                R.id.call_bottom -> callFragment(CallFragment())
                R.id.chat_bottom -> callFragment(ChatFragment())
            }
            true
        }
    }

    //loading the another fragment in viewPager
    private fun callFragment(fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun onBackPressed() {
        if (onBackpressedListener != null) {
            supportActionBar!!.title = "Home"
            binding.navView.setCheckedItem(R.id.drawer_home)
            onBackpressedListener.doBack()
            binding.drawer.closeDrawer(GravityCompat.START)
        } else if (onBackpressedListener == null) {
            finish()
            super.onBackPressed()
        }
    }

    interface OnBackPressedListener {
        fun doBack()
    }

    fun setOnBackPressedListener(onBackPressedListener: OnBackPressedListener) {
        onBackpressedListener = onBackPressedListener!!
    }

    override fun onDestroy() {
        onBackpressedListener
        super.onDestroy()
    }
}
