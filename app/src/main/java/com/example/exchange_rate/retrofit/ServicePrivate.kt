package com.example.exchange_rate.retrofit

import com.example.exchange_rate.items.ItemListOfCur
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServicePrivate {

    // https://api.privatbank.ua/p24api/exchange_rates?json&date=01.12.2014

    @GET("p24api/exchange_rates")
    fun getCurrencyExchange(
        @Query("json") json : String?,
        @Query("date") date : String
    ): Call<ItemListOfCur>?
}