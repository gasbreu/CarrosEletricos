package com.example.carroseletricos.data

import com.example.carroseletricos.domain.Carro
import retrofit2.Call
import retrofit2.http.GET

interface CarsApi {

    @GET("cars.json")
    fun getAllCars() : Call<List<Carro>>
}