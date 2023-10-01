package com.example.carroseletricos.data

import com.example.carroseletricos.domain.Carro

object CarFactory {                                                                                 // Definido como object para acessar as propriedades sem precisar instanciar.

    val list = listOf(
        Carro(
            id = 1,
            preco = "R$ 300.000.00",
            bateria = "300 kWh",
            potencia = "200cv",
            recarga = "30 min",
            urlPhoto = "wwww.google.com.br"
        ),
        Carro(
            id = 1,
            preco = "R$ 200.000.00",
            bateria = "200 kWh",
            potencia = "100cv",
            recarga = "20 min",
            urlPhoto = "wwww.google.com.br"
        ),
        Carro(
            id = 1,
            preco = "R$ 100.000.00",
            bateria = "100 kWh",
            potencia = "500cv",
            recarga =  "60 min",
            urlPhoto = "wwww.google.com.br"
        ),
        Carro(
            id = 1,
            preco = "R$ 600.000.00",
            bateria = "900 kWh",
            potencia = "600cv",
            recarga =  "90 min",
            urlPhoto = "wwww.google.com.br"
        )


    )
}