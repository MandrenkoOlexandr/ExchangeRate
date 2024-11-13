package com.example.exchange_rate.retrofit

import com.example.exchange_rate.items.ItemListOfCur
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitPrivate {

    // https://api.privatbank.ua/p24api/exchange_rates?json&date=01.12.2014

    private val BASE_URL = "https://api.privatbank.ua/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(ServicePrivate::class.java)

    fun getCurrencyExchange(data : String, resultCallback: (ItemListOfCur?) -> Unit) {
        // TODO:
        val call = service.getCurrencyExchange(null, data)

        call?.enqueue(object : Callback<ItemListOfCur> {
            override fun onResponse(
                p0: Call<ItemListOfCur>,
                response: Response<ItemListOfCur>
            ) {
                resultCallback(response.body())
            }

            override fun onFailure(p0: Call<ItemListOfCur>, throwable: Throwable) {
                resultCallback(null)
            }

        }


        )
    }
}