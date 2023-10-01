package com.example.carroseletricos.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.carroseletricos.R

class CalcularAutonomiaActivity : AppCompatActivity() {

    lateinit var btnCalcular: Button
    lateinit var kmPercorrido: EditText
    lateinit var resultado: TextView
    lateinit var preço: EditText
    lateinit var back: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_autonomia)
        setupView()
        setupListeners()
    }

    fun setupView() {
        btnCalcular = findViewById(R.id.btn_calcular)
        preço = findViewById(R.id.et_preco_kwh)
        kmPercorrido = findViewById(R.id.et_km_percorrido)
        resultado = findViewById(R.id.tv_resultado)
        back = findViewById(R.id.im_back)

    }

    fun setupListeners() {
        btnCalcular.setOnClickListener {
            calcular()
        }

        back.setOnClickListener {
            finish()
        }


    }

    fun calcular() {
        val preco = preço.text.toString().toFloat()
        val km = kmPercorrido.text.toString().toFloat()
        val result = preco /km
        resultado.text = result.toString()
        Log.d("resultado ->", result.toString())
    }
}