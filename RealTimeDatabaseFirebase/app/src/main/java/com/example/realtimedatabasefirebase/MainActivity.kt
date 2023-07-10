package com.example.realtimedatabasefirebase

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.realtimedatabasefirebase.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.IOException
import java.util.UUID


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var filePath: Uri? = null
    lateinit var btSignIn: SignInButton
    lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth
    var storage: FirebaseStorage? = null
    var storageReference: StorageReference? = null
    private val PICK_IMAGE_REQUEST = 22
    lateinit var firebaseDatabase: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        SelectImage()
        uploadImage()
    }

    private fun initView() {

        firebaseDatabase = FirebaseDatabase.getInstance()


        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("893484733808-bivi4t87m62i2bkcl5ktmcansvpn8niq.apps.googleusercontent.com")
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)

        binding.btnGoogleLogin.setOnClickListener {
            val intent = googleSignInClient.signInIntent

            startActivityForResult(intent, 100)
        }

        binding.btnLogin.setOnClickListener {
            var key = firebaseDatabase.reference.child("StudentTb").push().key ?: ""
            var data = StudentModel(
                key,
                binding.edtFName.text.toString(),
                binding.edtLName.text.toString(),
                binding.edtMobile.text.toString(),
                binding.edtemail.text.toString(),
                binding.edtpassword.text.toString()
            )
            firebaseDatabase.reference.child("StudentTb").child(key).setValue(data)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                        binding.edtFName.text.clear()
                        binding.edtLName.text.clear()
                        binding.edtMobile.text.clear()
                        binding.edtemail.text.clear()
                        binding.edtpassword.text.clear()
                    }
                }.addOnFailureListener {
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                }
            binding.edtFName.setText("").toString()
            binding.edtLName.setText("").toString()
            binding.edtMobile.setText("").toString()
            binding.edtemail.setText("").toString()
            binding.edtpassword.setText("").toString()
            uploadImage()
        }
        binding.btnDisplayRecord.setOnClickListener {
            var i = Intent(this, DataDisplayActivity::class.java)
            startActivity(i)

        }
    }

    private fun SelectImage() {

        binding.imgview.setOnClickListener {

            // Defining Implicit Intent to mobile gallery
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(
                Intent.createChooser(
                    intent,
                    "Select Image from here..."
                ),
                PICK_IMAGE_REQUEST
            )
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(
            requestCode,
            resultCode,
            data
        )

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {

            // Get the Uri of data
            filePath = data.data
            try {

                // Setting image on image view using Bitmap
                val bitmap = MediaStore.Images.Media
                    .getBitmap(
                        contentResolver,
                        filePath
                    )
                binding.imgview.setImageBitmap(bitmap)
            } catch (e: IOException) {
                // Log the exception
                e.printStackTrace()
            }
        }
    }

    private fun uploadImage() {
        if (filePath != null) {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()
            val ref = storageReference!!.child("images/" + UUID.randomUUID().toString())
            ref.putFile(filePath!!)
                .addOnSuccessListener {
                    progressDialog.dismiss()
                    Toast.makeText(this@MainActivity, "Uploaded", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    progressDialog.dismiss()
                    Toast.makeText(this@MainActivity, "Failed " + e.message, Toast.LENGTH_SHORT)
                        .show()
                }
                .addOnProgressListener { taskSnapshot ->
                    val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot
                        .totalByteCount
                    progressDialog.setMessage("Uploaded " + progress.toInt() + "%")
                }
        }
    }
}



