package com.example.carroseletricos.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.carroseletricos.R

class CalcularAutonomiaActivity : AppCompatActivity() {

    private lateinit var btnCalcular: Button
    private lateinit var kmPercorrido: EditText
    private lateinit var resultado: TextView
    private lateinit var preco: EditText
    private lateinit var back: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_autonomia)

        setupView()
        setupListeners()
        setupCachedResult()
    }

    private fun setupCachedResult() {
        val valorCalculado = getSharedPref()
        resultado.text = valorCalculado.toString()
    }

    private fun setupView() {
        btnCalcular = findViewById(R.id.btn_calcular)
        preco = findViewById(R.id.et_preco_kwh)
        kmPercorrido = findViewById(R.id.et_km_percorrido)
        resultado = findViewById(R.id.tv_resultado)
        back = findViewById(R.id.im_back)

    }

    private fun setupListeners() {
        btnCalcular.setOnClickListener {
            calcular()
        }

        back.setOnClickListener {
            finish()
        }


    }

    private fun calcular() {
        val preco = preco.text.toString().toFloat()
        val km = kmPercorrido.text.toString().toFloat()
        val result = preco /km
        resultado.text = result.toString()
        saveSharedPref(result)
        Log.d("resultado ->", result.toString())
    }

    private fun saveSharedPref(resultado: Float) {
        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putFloat(getString(R.string.saved_calc), resultado)
            apply()
        }
    }

    private fun getSharedPref() : Float {
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getFloat(getString(R.string.saved_calc), 0.0f)

    }

}