package com.example.exchange_rate

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.exchange_rate.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import com.example.exchange_rate.retrofit.RetrofitPrivate

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        findViewById<Button>(R.id.btnDate).setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker() {
        calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(this, {_, year: Int, monthOfYear: Int, dayOfMonth: Int ->
            val selectedDate = Calendar.getInstance()
            selectedDate.set(year, monthOfYear, dayOfMonth)
            val formattedDate = dateFormat.format(selectedDate.time)
            binding.textView.text = "Selected date: " + formattedDate
            dataset.clear()
            retrofitPrivate?.getCurrencyExchange(formattedDate) {

                it?.currencyItem?.forEach{currency ->
                    dataset.add(currency)
                }
                binding.recyclerCurrency.adapter = CurrencyAdapter(dataset)
            }
        },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.datePicker.maxDate = calendar.timeInMillis
        val minDay = 1
        val minMonth = 12
        val minYear = 2014
        calendar.set(minYear, minMonth-1, minDay)
        datePickerDialog.datePicker.minDate = calendar.timeInMillis
        datePickerDialog.show()
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

}