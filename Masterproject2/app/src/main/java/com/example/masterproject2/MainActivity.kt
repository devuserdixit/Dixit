package com.example.masterproject2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.masterproject2.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }
    private fun initView() {
        var sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        if (sharedPreferences.getBoolean("isLogin", false) == true) {
            var i = Intent(this, DashboardActivity::class.java)
            startActivity(i)
            finish()
        }
        auth = Firebase.auth
        binding.btnLogin.setOnClickListener {
            var email = binding.edtemail.text.toString()
            var password = binding.edtpassword.text.toString()
            var Mobile = binding.edtMobile.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "Please Enter E-mail First", Toast.LENGTH_SHORT).show()
            } else if (password.isEmpty()) {
                Toast.makeText(this, "Please Enter Password First", Toast.LENGTH_SHORT).show()
            } else if (email.isEmpty() && password.isEmpty() && Mobile.isEmpty()) {
                Toast.makeText(this, "Please Enter valid data", Toast.LENGTH_SHORT).show()
            } else if (Mobile.isEmpty()) {
                Toast.makeText(this, "Please Enter Mobile First", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT)
                            .show()
                        startActivity(
                            Intent(this@MainActivity, DashboardActivity::class.java)
                        )
                        finish()

                        val myEdit: SharedPreferences.Editor = sharedPreferences.edit()
                        myEdit.putBoolean("isLogin", true)
                        myEdit.putString("email", email)
                        myEdit.putString("password", password)
                        myEdit.putString("mobile", Mobile)
                    }
                }.addOnFailureListener {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.txtlogin.setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    LoginActivity::class.java
                )
            )
            finish()
        }
    }
}
