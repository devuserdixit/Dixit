package com.example.firebaseproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseproject.databinding.ActivityFacebookLoginBinding
import com.example.firebaseproject.databinding.ActivityLoginBinding
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.GraphResponse
import com.facebook.login.LoginResult
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import org.json.JSONException
import org.json.JSONObject
import java.util.Arrays


class FacebookLoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityFacebookLoginBinding
    lateinit var callbackManager: CallbackManager
    lateinit var Auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFacebookLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Auth = FirebaseAuth.getInstance()
        initView()
    }

    private fun initView() {

        binding.loginButton.setReadPermissions(Arrays.asList("email"))
        callbackManager = CallbackManager.Factory.create()

        binding.loginButton.registerCallback(
            callbackManager,
            object : FacebookCallback<LoginResult> {

                override fun onCancel() {

                }

                override fun onError(exception: FacebookException) {

                }

                @SuppressLint("SuspiciousIndentation")
                override fun onSuccess(result: LoginResult) {

                    var request = GraphRequest.newMeRequest(result.accessToken,
                        object : GraphRequest.GraphJSONObjectCallback {
                            override fun onCompleted(obj: JSONObject?, response: GraphResponse?) {
                                var email = obj?.getString("email")

                                Log.e("TAG", "onCompleted: " + email + " " + obj)
                            }
                        })

                    val parameters = Bundle()
                    parameters.putString("fields", "id,name,email,gender,birthday")
                    request.parameters = parameters
                    request.executeAsync()

                    val credential: AuthCredential =
                        FacebookAuthProvider.getCredential(result.accessToken.token)
                Auth = FirebaseAuth.getInstance()

                    Auth.signInWithCredential(credential).addOnCompleteListener {

                        if (it.isSuccessful) {
                            startActivity(
                                Intent(
                                    this@FacebookLoginActivity, MainActivity::class.java
                                ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            )
                            Toast.makeText(
                                this@FacebookLoginActivity,
                                "Firebase Authentication Successful",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }.addOnFailureListener {
                        Toast.makeText(
                            this@FacebookLoginActivity,
                            "Firebase Authentication Failed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            })
    }

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(resultCode, resultCode, data)
        super.onActivityReenter(resultCode, data)
    }
}