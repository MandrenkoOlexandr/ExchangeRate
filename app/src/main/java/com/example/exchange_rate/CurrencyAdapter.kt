package com.example.exchange_rate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CurrencyAdapter(private val dataSet: Array<ItemCurrency>) :
    RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val valueCurrency1: TextView
        val nameCurrency1: TextView
        val valueCurrency2: TextView
        val nameCurrency2: TextView

        init {
            valueCurrency1 = view.findViewById(R.id.valueCurrency1)
            nameCurrency1 = view.findViewById(R.id.nameCurrency1)
            valueCurrency2 = view.findViewById(R.id.valueCurrency2)
            nameCurrency2 = view.findViewById(R.id.nameCurrency2)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.currency_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.valueCurrency1.text = dataSet[position].value1
        viewHolder.nameCurrency1.text = dataSet[position].name1
        viewHolder.valueCurrency2.text = dataSet[position].value2
        viewHolder.nameCurrency2.text = dataSet[position].name2
    }

    override fun getItemCount() = dataSet.size

}