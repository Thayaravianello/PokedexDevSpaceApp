package com.criattussolution.pokedexdevspaceapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceRetrofit {

    @GET("pokemon/")
    fun getNowPokemons(): Call<PokemonResponse>
}