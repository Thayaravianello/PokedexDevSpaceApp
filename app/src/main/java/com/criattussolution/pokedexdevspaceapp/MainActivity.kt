package com.criattussolution.pokedexdevspaceapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.criattussolution.pokedexdevspaceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val pokemonViewModel: PokemonViewModel by viewModels()
    private val pokemonAdapter = PokemonAdapter()

    private val errorMessage = "Erro ao carregar a lista de Pokémons"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPokemon.layoutManager = GridLayoutManager(this, 2)
        binding.rvPokemon.adapter = pokemonAdapter

        pokemonViewModel.pokemonList.observe(this, Observer { pokemonList ->
            if (pokemonList != null){
                pokemonAdapter.submitList(pokemonList)
            } else {
                Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })

        pokemonViewModel.isLoading.observe(this, Observer { isLoading ->

        })

        pokemonViewModel.searchPokemonList()

        binding.rvPokemon.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int){
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as GridLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                if (!pokemonViewModel.isLoading.value!! && (visibleItemCount +
                        firstVisibleItemPosition) >= totalItemCount -5 ){
                    pokemonViewModel.searchPokemonList()
                }
            }
        })
    }
}
