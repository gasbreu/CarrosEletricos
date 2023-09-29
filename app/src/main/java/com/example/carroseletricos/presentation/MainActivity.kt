package com.example.carroseletricos.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carroseletricos.R
import com.example.carroseletricos.presentation.adapter.CarAdapter

class MainActivity : AppCompatActivity() {

    lateinit var btnRedirect :Button
    lateinit var listaCarros: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setupListeners()
        setupList()
    }

    fun setupView(){
        btnRedirect = findViewById(R.id.btn_redirect)
        listaCarros = findViewById(R.id.lv_lista_carro)
    }

    fun setupList() {
        var dados = arrayOf(
            "mopa", "meuca"
        )
        val adapter = CarAdapter(dados)
        listaCarros.adapter = adapter
    }

    fun setupListeners() {
        btnRedirect.setOnClickListener {
            startActivity(Intent(this, CalcularAutonomiaActivity::class.java))
        }
    }

}