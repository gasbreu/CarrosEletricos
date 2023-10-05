package com.example.carroseletricos.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carroseletricos.R
import com.example.carroseletricos.domain.Carro

class CarAdapter(private val carros: List<Carro>) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val preco : TextView
        val bateria : TextView
        val potencia : TextView
        val recarga : TextView
        val urlPhoto : ImageView
        init {
            view.apply {                                                                   // Para não ter que repetir o view.find...
                preco = findViewById(R.id.tv_preço_value)
                bateria = findViewById(R.id.tv_bateria_value)
                potencia = findViewById(R.id.tv_potencia_value)
                recarga = findViewById(R.id.tv_recarga_value)
                urlPhoto = findViewById(R.id.im_carro1)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.carro_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = carros.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.preco.text = carros[position].preco
        holder.bateria.text = carros[position].bateria
        holder.potencia.text = carros[position].potencia
        holder.recarga.text = carros[position].recarga
    }
}