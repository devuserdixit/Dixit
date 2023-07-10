package com.example.validationform

import android.R
import android.content.Context
import android.os.Build
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Patterns
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.validationform.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var CountryList = ArrayList<String>()


    @RequiresApi(VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        RadioButtonValidation()
    }

    private fun RadioButtonValidation() {
//         if (Gender.getCheckedRadioButtonId() === -1) {
//            Toast.makeText(applicationContext, "Please select Gender", Toast.LENGTH_SHORT)
//                .show()
//        } else {
//            // get selected radio button from radioGroup
//            val selectedId: Int = gender.getCheckedRadioButtonId()
//            // find the radiobutton by returned id
//            selectedRadioButton = findViewById<View>(selectedId) as RadioButton
//            Toast.makeText(
//                applicationContext,
//                selectedRadioButton.getText().toString() + " is selected",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
    }


    @RequiresApi(VERSION_CODES.O)
    private fun initView() {

        CountryList.add("India")
        CountryList.add("Russia")
        CountryList.add("Korea")
        CountryList.add("Australia")
        CountryList.add("USA")
        CountryList.add("Canada")
        CountryList.add("Germany")
        CountryList.add("Bangladesh")
        CountryList.add("Pakistan")
        CountryList.add("China")

        val adapter: ArrayAdapter<*> =
            ArrayAdapter<Any?>(this, R.layout.simple_spinner_item, CountryList as List<Any?>)

        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        binding.CountrySpinner.adapter = adapter

        binding.btnSubmit.setOnClickListener {
            var Firstname = binding.edtFirstname.text.toString()
            var Lastname = binding.edtLastname.text.toString()
            var Mobile = binding.edtMobilenumber.text.toString()
            var Email = binding.edtEmailaddress.text.toString()
            var Age = binding.edtAge.text.toString()
            var Password = binding.edtPassword.text.toString()
            var ConfirmPassword = binding.edtConfirmPassword.text.toString()

            if (Firstname.isEmpty()) {
                Toast.makeText(this, "Enter Firstname", Toast.LENGTH_SHORT).show()
                Vibration()
            } else if (Firstname.length < 4) {
                Toast.makeText(this, "Enter Proper Firstname", Toast.LENGTH_SHORT).show()
                Vibration()
            } else if (Lastname.isEmpty()) {
                Toast.makeText(this, "Enter Lastname", Toast.LENGTH_SHORT).show()
                Vibration()
            } else if (Lastname.length < 4) {
                Toast.makeText(this, "Enter Proper Lastname", Toast.LENGTH_SHORT).show()
                Vibration()
            } else if (Mobile.isEmpty()) {
                Toast.makeText(this, "Enter Mobile number", Toast.LENGTH_SHORT).show()
                Vibration()
            } else if (Mobile.length < 10) {
                Toast.makeText(this, "Enter valid Mobile number", Toast.LENGTH_SHORT).show()
                Vibration()
            } else if (Email.isEmpty()) {
                Toast.makeText(this, "Enter E-mail", Toast.LENGTH_SHORT).show()
                Vibration()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                Toast.makeText(this, "Enter Proper E-mail", Toast.LENGTH_SHORT).show()
                Vibration()
            } else if (Age.isEmpty()) {
                Toast.makeText(this, "Enter Age", Toast.LENGTH_SHORT).show()
                Vibration()
            } else if (Age.length < 2) {
                Toast.makeText(this, "Enter Proper Age", Toast.LENGTH_SHORT).show()
                Vibration()
            } else if (Password.isEmpty() && Password.length < 8) {
                Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show()
                Vibration()
            } else if (ConfirmPassword.isEmpty() && Password.length < 8) {
                Toast.makeText(this, "Enter Confirm Password", Toast.LENGTH_SHORT).show()
                Vibration()
            }
            else if(ConfirmPassword.equals(Password)){
                Toast.makeText(this, "Password and Confirm Password not match", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun Vibration() {
        var vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator!!.vibrate(
                VibrationEffect.createOneShot(500, VibrationEffect.PARCELABLE_WRITE_RETURN_VALUE)
            )
        } else {
            vibrator!!.vibrate(500)
        }
    }
}
