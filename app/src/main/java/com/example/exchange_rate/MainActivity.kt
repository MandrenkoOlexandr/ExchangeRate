package com.example.exchange_rate

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.exchange_rate.databinding.ActivityMainBinding
import com.example.exchange_rate.items.CurrencyAdapter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ExchangeRateViewModel by viewModels()
    private val calendar = Calendar.getInstance()
    private val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDate.setOnClickListener {
            showDatePicker()
        }

        viewModel.selectedDate.observe(this, Observer { date ->
            binding.textView.text = "Selected date: $date"
        })

        viewModel.currencyList.observe(this, Observer { currencyList ->
            binding.recyclerCurrency.adapter = CurrencyAdapter(currencyList)
        })
    }

    private fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, monthOfYear, dayOfMonth)
                val formattedDate = dateFormat.format(selectedDate.time)
                viewModel.setSelectedDate(formattedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePickerDialog.datePicker.maxDate = System.currentTimeMillis()

        val minDay = 1
        val minMonth = 12
        val minYear = 2014
        calendar.set(minYear, minMonth - 1, minDay)
        datePickerDialog.datePicker.minDate = calendar.timeInMillis
        datePickerDialog.show()
    }
}

