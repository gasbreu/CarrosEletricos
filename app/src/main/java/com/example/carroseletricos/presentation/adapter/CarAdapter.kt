package com.example.carroseletricos.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carroseletricos.R

class CarAdapter(private val carros: Array<String>) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView
        init {
            textView = view.findViewById(R.id.tv_preço_value)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.carro_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = carros.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = carros[position]
    }
}