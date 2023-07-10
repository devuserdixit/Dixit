package com.example.masterproject

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.masterproject.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth
    var btnGoogleLogin: SignInButton? = null
    lateinit var googleSignInClient: GoogleSignInClient

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
//        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken("291452850202-rfitoe9l2r50keqshu4l5cj30n8k0oq8.apps.googleusercontent.com")
//            .requestEmail()
//            .build()
//
//        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)
//        btnGoogleLogin?.setOnClickListener { // Initialize sign in intent
//            val intent: Intent = googleSignInClient.signInIntent
//            // Start activity for result
//            startActivityForResult(intent, 100)
//        }
//
//        // Initialize firebase auth
//        auth = FirebaseAuth.getInstance()
//        // Initialize firebase user
//        val firebaseUser: FirebaseUser? = auth.currentUser
//        // Check condition
//        if (firebaseUser != null) {
//            // When user already sign in redirect to profile activity
//            startActivity(
//                Intent(
//                    this,
//                    DashboardActivity::class.java
//                ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            )
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        // Check condition
//        if (requestCode == 100) {
//            // When request code is equal to 100 initialize task
//            val signInAccountTask: Task<GoogleSignInAccount> =
//                GoogleSignIn.getSignedInAccountFromIntent(data)
//
//            // check condition
//            if (signInAccountTask.isSuccessful) {
//                // When google sign in successful initialize string
//                val s = "Google sign in successful"
//                // Display Toast
//                displayToast(s)
//                // Initialize sign in account
//                try {
//                    // Initialize sign in account
//                    val googleSignInAccount = signInAccountTask.getResult(ApiException::class.java)
//                    // Check condition
//                    if (googleSignInAccount != null) {
//                        // When sign in account is not equal to null initialize auth credential
//                        val authCredential: AuthCredential = GoogleAuthProvider.getCredential(
//                            googleSignInAccount.idToken, null
//                        )
//                        // Check credential
//                        auth.signInWithCredential(authCredential)
//                            .addOnCompleteListener(this) { task ->
//                                // Check condition
//                                if (task.isSuccessful) {
//                                    // When task is successful redirect to profile activity
//                                    startActivity(
//                                        Intent(
//                                            this@MainActivity,
//                                            DashboardActivity::class.java
//                                        ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                                    )
//                                    // Display Toast
//                                    displayToast("Firebase authentication successful")
//                                } else {
//                                    // When task is unsuccessful display Toast
//                                    displayToast(
//                                        "Authentication Failed :" + task.exception?.message
//                                    )
//                                }
//                            }
//                    }
//                } catch (e: ApiException) {
//                    e.printStackTrace()
//                }
//            }
//        }
//    }
//
//    private fun displayToast(s: String) {
//        Toast.makeText(applicationContext, s, Toast.LENGTH_SHORT).show()
//    }
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