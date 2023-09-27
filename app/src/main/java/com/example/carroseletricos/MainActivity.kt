package com.example.carroseletricos

import android.os.Bundle
import android.util.Log                                                                             // para poder usar o log.d
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var preço: EditText
    lateinit var btnCalcular: Button                                                                // definidas as variáveis que serão executadas posteriormente, e seus type, não havendo necessidade de definí-los na chamada.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        setupListeners()
    }

    fun setupView(){
        btnCalcular = findViewById(R.id.btn_calcular)                                               // definido que btnCalcular vai armazenar a informação da interação do usuário com a view.
        preço = findViewById(R.id.et_preco_kwh)                                                     // método para buscar o elemento pela sua id
    }
    fun setupListeners() {                                                                          // método que define quem vai estar esperando a interação do usuário na view.
        btnCalcular.setOnClickListener {
            val textoDitado = preço.text.toString()                                                 // definido que, com a interação no elemento definido, é reagatada a informação text de dentro da variável que está recebendo as informação da edit text definida anteriormente.
            Log.d("texto ditado ->", textoDitado)                                               // para registrar no log o valor da string textoDigitado
        }
    }
}