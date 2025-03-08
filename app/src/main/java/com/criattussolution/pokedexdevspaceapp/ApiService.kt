package com.criattussolution.pokedexdevspaceapp

import android.location.GnssAntennaInfo.PhaseCenterOffset
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id")id: Int): Response<Pokemon>

    @GET("pokemon")
    suspend fun getPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<PokemonListResponse>
}