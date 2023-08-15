package com.example.tourprojecttest

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tourprojecttest.databinding.FragmentBookingsBinding
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONException
import org.json.JSONObject

class BookingsFragment : Fragment(),PaymentResultListener {

    private lateinit var amountEdt: EditText
    private lateinit var payBtn: Button
    lateinit var binding : FragmentBookingsBinding
    lateinit var context : Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBookingsBinding.inflate(layoutInflater, container, false)

        Razorpay()
        return binding.root
    }

    private fun Razorpay() {
        payBtn.setOnClickListener(View.OnClickListener {
            val samount = amountEdt.getText().toString()

            // rounding off the amount.
            val amount = Math.round(samount.toFloat() * 100)

            // initialize Razorpay account.
            val checkout = Checkout()

            // set your id as below
            checkout.setKeyID("rzp_test_2hORW5NhrpufzI")

            // set image
            checkout.setImage(R.drawable.place)

            // initialize json object
            val `object` = JSONObject()
            try {
                // to put name
                `object`.put("name", "Razor Payment")

                // put description
                `object`.put("description", "Test payment")

                // to set theme color
                `object`.put("theme.color", "")

                // put the currency
                `object`.put("currency", "INR")

                // put amount
                `object`.put("amount", amount)

                // put mobile number
                `object`.put("prefill.contact", "9284064503")

                // put email
                `object`.put("prefill.email", "chaitanyamunje@gmail.com")

                // open razorpay to checkout activity
                checkout.open(context as Activity?, `object`)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        })
    }

    override fun onPaymentSuccess(s: String) {
        // this method is called on payment success.
        Toast.makeText(context, "Payment is successful : $s", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentError(i: Int, s: String) {
        // on payment failed.
        Toast.makeText(context, "Payment Failed due to error : $s", Toast.LENGTH_SHORT).show()
    }
}