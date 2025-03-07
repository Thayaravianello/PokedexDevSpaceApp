package com.criattussolution.pokedexdevspaceapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}