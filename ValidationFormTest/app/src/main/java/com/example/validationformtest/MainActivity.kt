package com.example.validationformtest

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

class MainActivity : AppCompatActivity() {
    // two buttons
    var bCancel: Button? = null
    var bProceed: Button? = null

    // four text fields
    var etFirstName: EditText? = null
    var etLastName: EditText? = null
    var etEmail: EditText? = null
    var etPassword: EditText? = null

    // one boolean variable to check whether all the text fields
    // are filled by the user, properly or not.
    var isAllFieldsChecked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // register buttons with their proper IDs.
        bProceed = findViewById(R.id.proceedButton)
        bCancel = findViewById(R.id.cancelButton)

        // register all the EditText fields with their IDs.
        etFirstName = findViewById(R.id.firstName)
        etLastName = findViewById(R.id.lastName)
        etEmail = findViewById(R.id.email)
        etPassword = findViewById(R.id.password)

        // handle the PROCEED button
        bProceed.setOnClickListener(object : OnClickListener() {
            fun onClick(v: View?) {

                // store the returned value of the dedicated function which checks
                // whether the entered data is valid or if any fields are left blank.
                isAllFieldsChecked = CheckAllFields()

                // the boolean variable turns to be true then
                // only the user must be proceed to the activity2
                if (isAllFieldsChecked) {
                    val i = Intent(this@MainActivity, MainActivity2::class.java)
                    startActivity(i)
                }
            }
        })

        // if user presses the cancel button then close the
        // application or the particular activity.
        bCancel.setOnClickListener(object : OnClickListener() {
            fun onClick(v: View?) {
                finish()
                System.exit(0)
            }
        })
    }

    // function which checks all the text fields
    // are filled or not by the user.
    // when user clicks on the PROCEED button
    // this function is triggered.
    private fun CheckAllFields(): Boolean {
        if (etFirstName!!.length() == 0) {
            etFirstName!!.error = "This field is required"
            return false
        }
        if (etLastName!!.length() == 0) {
            etLastName!!.error = "This field is required"
            return false
        }
        if (etEmail!!.length() == 0) {
            etEmail!!.error = "Email is required"
            return false
        }
        if (etPassword!!.length() == 0) {
            etPassword!!.error = "Password is required"
            return false
        } else if (etPassword!!.length() < 8) {
            etPassword!!.error = "Password must be minimum 8 characters"
            return false
        }

        // after all validation return true.
        return true
    }
}
//This code is written by Ujjwal Kumar Bhardwaj
