package com.example.companionobjects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import com.example.companionobjects.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var editTextPassword: EditText
    private lateinit var toggleButtonShowPassword: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        editTextPassword = findViewById(R.id.editTextPassword)
        toggleButtonShowPassword = findViewById(R.id.toggleButtonShowPassword)

        toggleButtonShowPassword.setOnClickListener {
            togglePasswordVisibility()
        }
    }

    private fun togglePasswordVisibility() {
        if (editTextPassword.transformationMethod is PasswordTransformationMethod) {
            // Password characters are hidden, show them
            editTextPassword.transformationMethod = null
        } else {
            // Password characters are shown, hide them
            editTextPassword.transformationMethod = PasswordTransformationMethod()
        }

        // Move the cursor to the end of the input to maintain the user's cursor position
        editTextPassword.setSelection(editTextPassword.text.length)
    }
}
