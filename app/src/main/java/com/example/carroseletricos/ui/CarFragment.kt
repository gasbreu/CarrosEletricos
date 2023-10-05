package com.example.carroseletricos.ui

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.carroseletricos.R
import com.example.carroseletricos.domain.Carro
import com.example.carroseletricos.ui.adapter.CarAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONArray
import org.json.JSONTokener
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class CarFragment : Fragment() {

    lateinit var fabCalcular: FloatingActionButton
    lateinit var listaCarros: RecyclerView
    lateinit var progress : ProgressBar

    var carrosArray: ArrayList<Carro> = ArrayList()

    override fun onCreateView(                                                                      // view sendo criada
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.car_fragment, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {                           // view já criada
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupListeners()
        callService()
    }

    fun setupView(view: View) {                                                                     // especificar o tipo view por estar fora de uma activity
        view.apply {
            listaCarros = findViewById(R.id.lv_lista_carro)
            fabCalcular = findViewById(R.id.fab_calcular)
            progress = findViewById(R.id.pb_loader)
        }

    }

    fun setupList() {
        val adapter = CarAdapter(carrosArray)
        listaCarros.adapter = adapter
    }

    fun setupListeners() {
        fabCalcular.setOnClickListener {
            startActivity(Intent(context, CalcularAutonomiaActivity::class.java))
        }
    }

    fun callService() {
        MyTask().execute("https://igorbag.github.io/cars-api/cars.json")
    }

    inner class MyTask : AsyncTask<String, String, String>() {

        override fun onPreExecute() {
            super.onPreExecute()
            progress.visibility = View.VISIBLE
            Log.d("MyTask", "Iniciando...")
        }

        override fun doInBackground(vararg url: String?): String {

            var urlConnection: HttpURLConnection? = null

            try {
                val urlBase = URL(url[0])

                urlConnection = urlBase.openConnection() as HttpURLConnection
                urlConnection.connectTimeout = 60000
                urlConnection.readTimeout = 60000
                urlConnection.setRequestProperty(
                    "Accept",
                    "application/json"
                )

                val responseCode = urlConnection.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    var inString = urlConnection.inputStream.bufferedReader().use { it.readText() }
                    publishProgress(inString)
                }   else { Log.e("Erro", "Serviço indisponível no momento") }

            } catch (ex: Exception) {

            } finally {
                urlConnection?.disconnect()
            }

            return ""
        }

        override fun onProgressUpdate(vararg values: String?) {
            try {
                val jsonArray = JSONTokener(values[0]).nextValue() as JSONArray

                for (i in 0 until jsonArray.length()) {

                    val id = jsonArray.getJSONObject(i).getString("id")
                    Log.d("id", id)
                    val preco = jsonArray.getJSONObject(i).getString("preco")
                    Log.d("preco", preco)
                    val bateria = jsonArray.getJSONObject(i).getString("bateria")
                    Log.d("bateria", bateria)
                    val potencia = jsonArray.getJSONObject(i).getString("potencia")
                    Log.d("potencia", potencia)
                    val recarga = jsonArray.getJSONObject(i).getString("recarga")
                    Log.d("recarga", recarga)
                    val urlPhoto = jsonArray.getJSONObject(i).getString("urlPhoto")
                    Log.d("urlPhoto", urlPhoto)

                    val model = Carro(
                        id = id.toInt(),
                        preco = preco,
                        bateria = bateria,
                        potencia = potencia,
                        recarga = recarga,
                        urlPhoto = urlPhoto
                    )
                    carrosArray.add(model)
                }
                    progress.visibility = View.GONE
                    setupList()
            } catch (ex: Exception) {
                Log.e("Errp ->", ex.message.toString())
            }
        }

    }

}