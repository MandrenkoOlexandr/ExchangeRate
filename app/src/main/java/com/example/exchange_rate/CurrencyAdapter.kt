package com.example.exchange_rate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exchange_rate.items.CurrencyItem

class CurrencyAdapter(private val dataSet: ArrayList<CurrencyItem?>) :

    RecyclerView.Adapter<CurrencyAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val currencyName: TextView
        val saleRateNBValue: TextView
        val purchaseRateNBValue: TextView
        val saleRateValue: TextView
        val purchaseRateValue: TextView

        init {
            currencyName = view.findViewById(R.id.currencyName)
            saleRateNBValue = view.findViewById(R.id.saleRateNBValue)
            purchaseRateNBValue = view.findViewById(R.id.purchaseRateNBValue)
            saleRateValue = view.findViewById(R.id.saleRateValue)
            purchaseRateValue = view.findViewById(R.id.purchaseRateValue)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.currency_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.currencyName.text = dataSet[position]?.currency ?: "N/A"
        viewHolder.saleRateNBValue.text = dataSet[position]?.saleRateNB?.toString() ?: "N/A"
        viewHolder.purchaseRateNBValue.text = dataSet[position]?.purchaseRateNB?.toString() ?: "N/A"
        viewHolder.saleRateValue.text = dataSet[position]?.saleRate?.toString() ?: "N/A"
        viewHolder.purchaseRateValue.text = dataSet[position]?.purchaseRate?.toString() ?: "N/A"
    }

    override fun getItemCount() = dataSet.size

}