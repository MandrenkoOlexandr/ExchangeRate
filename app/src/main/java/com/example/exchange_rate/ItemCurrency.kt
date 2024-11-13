package com.example.exchange_rate

data class ItemCurrency (
    val currency: String,
    val saleRateNB: Float,
    val purchaseRateNB: Float,
    val saleRate: Float,
    val purchaseRate: Float
)