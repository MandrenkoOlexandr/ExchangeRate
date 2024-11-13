package com.example.exchange_rate

val dataset: Array<ItemCurrency> = arrayOf(
    ItemCurrency("$", "USD", "₴", "UAH"),
    ItemCurrency("€", "EUR", "₴", "UAH"),
    ItemCurrency("¥", "JPY", "₴", "UAH"),
    ItemCurrency("£", "GBP", "₴", "UAH"),
    ItemCurrency("A$", "AUD", "₴", "UAH"),
    ItemCurrency("C$", "CAD", "₴", "UAH"),
    ItemCurrency("¥", "CNY", "₴", "UAH"),
    ItemCurrency("₹", "INR", "₴", "UAH")
//    ItemCurrency(i[saleRateNB], i[baseCurrency], 1, i[currency]),
//    ItemCurrency(1, i[currency], i[purchaseRateNB], i[baseCurrency])
)
