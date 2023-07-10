package com.example.realtimedatabasefirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.realtimedatabasefirebase.databinding.ActivityDataUpdateBinding
import com.google.firebase.database.FirebaseDatabase

class DataUpdateActivity : AppCompatActivity() {
    lateinit var binding : ActivityDataUpdateBinding
    lateinit var firebaseDatabase: FirebaseDatabase
    var id=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        id=intent.getStringExtra("id").toString()
        binding.edtFname.setText(intent.getStringExtra("firstname"))
        binding.edtLname.setText(intent.getStringExtra("lastname"))
        binding.edtMobile.setText(intent.getStringExtra("mobile"))
        binding.edtEmail.setText(intent.getStringExtra("email"))
        binding.edtpassword.setText(intent.getStringExtra("password"))

        firebaseDatabase = FirebaseDatabase.getInstance()

        binding.btnUpdate.setOnClickListener {
//            var key = firebaseDatabase.reference.child("StudentTb").push().key?:""
            var data = StudentModel(
                id,
                binding.edtFname.text.toString(),
                binding.edtLname.text.toString(),
                binding.edtMobile.text.toString(),
                binding.edtEmail.text.toString(),
                binding.edtpassword.text.toString()
            )
            firebaseDatabase.reference.child("StudentTb").child(id).setValue(data).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "Record SuccessFully Updated", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {
                Log.e("TAG", "initView: "+it.message)
                Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show()
            }
            var i = Intent(this,DataDisplayActivity::class.java)
            startActivity(i)
        }
    }
}