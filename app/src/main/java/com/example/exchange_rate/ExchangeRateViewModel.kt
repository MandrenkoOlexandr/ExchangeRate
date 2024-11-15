package com.example.exchange_rate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exchange_rate.items.CurrencyItem
import com.example.exchange_rate.retrofit.RetrofitPrivate

class ExchangeRateViewModel : ViewModel() {

    private val retrofitPrivate = RetrofitPrivate()

    private val _selectedDate = MutableLiveData<String>()
    val selectedDate: LiveData<String> get() = _selectedDate

    private val _currencyList = MutableLiveData<List<CurrencyItem>>()
    val currencyList: LiveData<List<CurrencyItem>> get() = _currencyList

    fun setSelectedDate(date: String) {
        _selectedDate.value = date
        fetchCurrencyRates(date)
    }

    private fun fetchCurrencyRates(date: String) {
        retrofitPrivate.getCurrencyExchange(date) { response ->
            if (response != null) {
                _currencyList.postValue(response.currencyItem?.filterNotNull() ?: emptyList())
            } else {
                _currencyList.postValue(emptyList())
            }
        }
    }
}
