package com.example.retrofitapicalling

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.retrofitapicalling.databinding.ActivityLoginBinding
import com.example.retrofitapicalling.databinding.ActivityLoginDataDisplayBinding

class LoginDataDisplayActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginDataDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginDataDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        logout()
    }

    private fun logout() {
        var sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        binding.btnlogout.setOnClickListener {

            val myEdit: SharedPreferences.Editor = sharedPreferences.edit()
            myEdit.remove("isLogin")
            myEdit.commit()

            var i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    private fun initView() {
        var sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
//        var username = intent.getStringExtra("username")
//        var email = intent.getStringExtra("email")
//        var firstName = intent.getStringExtra("firstname")
//        var lastname = intent.getStringExtra("lastname")
//        var gender = intent.getStringExtra("gender")
//        var image = intent.getStringExtra("image")
//        var token = intent.getStringExtra("token")

        var image = sharedPreferences.getString("image", " ")
        Glide.with(this).load("$image").placeholder(R.drawable.place).into(binding.imageview)
        binding.txtusername.text = sharedPreferences.getString("username", " ")
        binding.txtemail.text = sharedPreferences.getString("email", " ")
        binding.txtfirstname.text = sharedPreferences.getString("firstname", " ")
        binding.txtlastname.text = sharedPreferences.getString("lastname", " ")
        binding.txtgender.text = sharedPreferences.getString("gender", " ")

    }
}