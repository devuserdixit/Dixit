package com.example.firebaserealtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.firebaserealtime.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding

    lateinit var firebaseDatabase: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        initView()
    }

    private fun initView() {
        var fName = mainBinding.edtFName.text.toString()
        var lName = mainBinding.edtLName.text.toString()
        var mobile = mainBinding.edtMobile.text.toString()
        var email = mainBinding.edtemail.text.toString()
        var pass = mainBinding.edtpassword.text.toString()

        firebaseDatabase = FirebaseDatabase.getInstance()

        mainBinding.btnLogin.setOnClickListener {

            var key = firebaseDatabase.reference.child("StudentTb").push().key ?: ""

            var obj = studentModel(key, fName, lName, mobile, email, pass)
            firebaseDatabase.reference.child("StudentTb").child(key).setValue(obj)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                    }
                }.addOnFailureListener {
                    Log.e("TAG", "initView: " + it.message)
                    Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show()
                }
//            mainBinding.edtFName.text.clear()
//            mainBinding.edtLName.text.clear()
//            mainBinding.edtMobile.text.clear()
//            mainBinding.edtemail.text.clear()
//            mainBinding.edtpassword.text.clear()
//
        }
    }
}

data class studentModel(
    var id: String,
    var fName: String,
    var lName: String,
    var mobile: String,
    var email: String,
    var pass: String
)