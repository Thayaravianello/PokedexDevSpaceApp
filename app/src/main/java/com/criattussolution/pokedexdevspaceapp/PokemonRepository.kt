package com.criattussolution.pokedexdevspaceapp

import retrofit2.Response

class PokemonRepository (private val apiService: ApiService){
    suspend fun getPokemons(limit: Int, offset: Int):
            Response<PokemonListResponse>{
        return apiService.getPokemons(limit, offset)
    }

    suspend fun getPokemon(id: Int): Response<Pokemon>{
        return apiService.getPokemon(id)
    }
}