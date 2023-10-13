package com.example.carroseletricos.ui

import android.os.Bundle
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

class FavoriteFragment : Fragment() {                                                               // É criada a classe e definido seu tipo Fragment.

    private lateinit var listaCarrosFavorite: RecyclerView                                          // É criada uma variável lateinit do tipo RecycleView
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

    private fun setupList() {
        val cars = getCarsOnLocalDb()
        val carroAdapter = CarAdapter(cars, isFavoriteScreen = true)
        listaCarrosFavorite.isVisible = true
        listaCarrosFavorite.adapter = carroAdapter
        carroAdapter.carItemLister = { carro ->
           val isSaved = CarRepository(requireContext()).saveIfNotExist(carro)
        }
    }

    fun getCarsOnLocalDb(): List<Carro> {
        val repository = CarRepository(requireContext())
        return repository.getAll()
    }

    fun setupView(view: View) {
            listaCarrosFavorite = view.findViewById(R.id.lv_lista_carro_favorite)

    }

}