package com.criattussolution.pokedexdevspaceapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class PokemonViewModel(application: Application) : AndroidViewModel(application) {
    private val pokemonRepository = PokemonRepository(RetrofitClient.apiService)

    val pokemonList = MutableLiveData<List<PokemonResult>>()
    val errorMessage = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    private var offset = 0
    private val limit = 20

    fun searchPokemonList() {
        if (isLoading.value == true) return

        isLoading.value = true
        viewModelScope.launch {
            try {
                Log.d("PokemonViewModel", "Buscando Pokémons com offset $offset e limit $limit")

                val response: Response<PokemonListResponse> =
                    pokemonRepository.getPokemons(offset, limit)

                if (response.isSuccessful) {
                    val results = response.body()?.results

                    if (results != null && results.isNotEmpty()) {

                        val currentList = pokemonList.value?.toMutableList() ?: mutableListOf()

                        currentList.addAll(results)
                        pokemonList.value = currentList

                        offset += limit

                        Log.d("PokemonViewModel", "Pokémons carregados: ${results.size}")
                    } else {
                        errorMessage.value = "Nenhum Pokémon encontrado"
                    }
                } else {
                    errorMessage.value = "Erro ao buscar Pokémons: ${response.message()}"
                }
            } catch (e: Exception) {
                errorMessage.value = "Erro ao buscar Pokémons: ${e.message}"
            }
            isLoading.value = false
        }
    }
}