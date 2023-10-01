package com.example.carroseletricos.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.carroseletricos.R
import com.example.carroseletricos.data.CarFactory
import com.example.carroseletricos.ui.adapter.CarAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CarFragment : Fragment(){

    lateinit var fabCalcular : FloatingActionButton
    lateinit var listaCarros : RecyclerView

    override fun onCreateView(                                                                      // view sendo criada
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.car_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {                           // view já criada
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupList()
        setupListeners()
    }

    fun setupView(view: View) {                                                                     // especificar o tipo view por estar fora de uma activity
        view.apply {
            listaCarros = findViewById(R.id.lv_lista_carro)
            fabCalcular = findViewById(R.id.fab_calcular)
        }

    }

    fun setupList() {
        val adapter = CarAdapter(CarFactory.list)
        listaCarros.adapter = adapter
    }

    fun setupListeners() {
        fabCalcular.setOnClickListener {
            startActivity(Intent(context, CalcularAutonomiaActivity::class.java))
        }
    }

}