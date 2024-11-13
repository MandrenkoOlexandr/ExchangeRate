package com.example.exchange_rate

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.exchange_rate.databinding.ActivityMainBinding
import com.example.exchange_rate.retrofit.RetrofitPrivate

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        binding.button.setOnClickListener {
            retrofitPrivate?.getCurrencyExchange("01.12.2014") {
                Log.d(TAG, "on: $it")

                it?.currencyItem?.forEach{currency ->
                    Log.d(TAG, "$currency")
                }
            }

        }

    }

    private var retrofitPrivate: RetrofitPrivate? = null
    override fun onStart() {
        super.onStart()
        retrofitPrivate = RetrofitPrivate()
    }

    override fun onStop() {
        super.onStop()
        retrofitPrivate = null
    }

    private val TAG = "XXXX"


}