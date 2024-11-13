package com.example.exchange_rate.items


import com.google.gson.annotations.SerializedName

data class ItemListOfCur(
    @SerializedName("bank")
    val bank: String?,
    @SerializedName("baseCurrency")
    val baseCurrency: Int?,
    @SerializedName("baseCurrencyLit")
    val baseCurrencyLit: String?,
    @SerializedName("date")
    val date: String?,
    @SerializedName("exchangeRate")
    val currencyItem: List<CurrencyItem?>?
)