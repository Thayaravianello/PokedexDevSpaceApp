package com.criattussolution.pokedexdevspaceapp

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://pokeapi.co/api/v2/"

object RetrofitClient {

    private val httpClient = OkHttpClient.Builder().build() // Cliente HTTP sem interceptador

    val retrofitInstance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient) // Usa o cliente HTTP configurado
            .build()
    }
}
