package com.example.retrofitapicalling

import android.app.Dialog
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitapicalling.databinding.ActivityLoginBinding
import com.example.retrofitapicalling.databinding.DialogShowBinding
import com.journaldev.retrofitintro.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {


    lateinit var binding: ActivityLoginBinding
    lateinit var apiInterface: APIInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {

        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        if (sharedPreferences.getBoolean("isLogin", false) == true) {
            var i = Intent(this, MainActivitcy::class.java)
            startActivity(i)
            finish()
        }

        binding.btnLogin.setOnClickListener {

            var dialog = Dialog(this)
            var dialogShowBinding = DialogShowBinding.inflate(layoutInflater)
            dialog.setContentView(dialogShowBinding.root)

            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.window?.setLayout(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            dialog.show()

            apiInterface = APIClient.getClient().create(APIInterface::class.java)
            var username = binding.edtusername.text.toString()
            var password = binding.edtpassword.text.toString()

            if (username.isEmpty()) {
                Toast.makeText(this, "Username is Empty", Toast.LENGTH_SHORT).show()
            } else if (password.isEmpty()) {
                Toast.makeText(this, "password is Empty", Toast.LENGTH_SHORT).show()
            } else {
                apiInterface.getLogin(username, password)
                    .enqueue(object : Callback<LoginModalClass> {
                        override fun onResponse(
                            call: Call<LoginModalClass>,
                            response: Response<LoginModalClass>
                        ) {
                            if (response.isSuccessful && response.code() == 200) {
                                Log.e("TAG", "onResponse: " + username)
                                var username = response.body()?.username
                                var id = response.body()?.id
                                var email = response.body()?.email
                                var firstname = response.body()?.firstName
                                var lastname = response.body()?.lastName
                                var gender = response.body()?.gender
                                var image = response.body()?.image
                                var token = response.body()?.token

                                val myEdit: SharedPreferences.Editor = sharedPreferences.edit()
                                myEdit.putBoolean("isLogin", true)
                                myEdit.putString("username", username)
                                myEdit.putString("firstname", firstname)
                                myEdit.putString("lastname", lastname)
                                myEdit.putString("gender", gender)
                                myEdit.putString("image", image)
                                myEdit.putString("email", email)
                                myEdit.commit()

                                var intent =
                                    Intent(this@LoginActivity, MainActivity::class.java)
                                startActivity(intent)
                                dialog.dismiss()
                                finish()

                                Log.e("TAG", "onResponse: " + gender)
                                var i =
                                    Intent(this@LoginActivity, LoginDataDisplayActivity::class.java)
                                i.putExtra("username", username)
                                i.putExtra("id", id)
                                i.putExtra("email", email)
                                i.putExtra("firstname", firstname)
                                i.putExtra("lastname", lastname)
                                i.putExtra("gender", gender)
                                i.putExtra("image", image)
                                i.putExtra("token", image)
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Login Successfully",
                                    Toast.LENGTH_SHORT
                                ).show()
                                startActivity(i)
                                dialog.dismiss()
                                finish()

                            } else {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Username or Password is invalid",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }

                        override fun onFailure(call: Call<LoginModalClass>, t: Throwable) {
                            TODO("Not yet implemented")
                        }

                    })
            }
        }
    }
}