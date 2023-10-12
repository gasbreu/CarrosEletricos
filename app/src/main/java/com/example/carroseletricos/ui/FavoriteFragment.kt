package com.example.carroseletricos.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.carroseletricos.R
import com.example.carroseletricos.data.local.CarRepository
import com.example.carroseletricos.domain.Carro
import com.example.carroseletricos.ui.adapter.CarAdapter

class FavoriteFragment : Fragment() {

    lateinit var listaCarrosFavorite: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorite_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView(view)
        setupList()
    }

    fun setupList() {
        val cars = getCarsOnLocalDb()
        val carroAdapter = CarAdapter(cars, isFavoriteScreen = true)
        listaCarrosFavorite.isVisible = true
        listaCarrosFavorite.adapter = carroAdapter
        carroAdapter.carItemLister = { carro ->
           // val isSaved = CarRepository(requireContext()).saveIfNotExist(carro)
        }
    }

    private fun getCarsOnLocalDb(): List<Carro> {
        val repository = CarRepository(requireContext())
        val carList = repository.getAll()
        return carList
    }

    fun setupView(view: View) {
        view.apply {
            listaCarrosFavorite = findViewById(R.id.lv_lista_carro_favorite)
        }

    }

}