package com.criattussolution.pokedexdevspaceapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.criattussolution.pokedexdevspaceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //CRIAR DATA CLASS - ok
        //CRIAR LISTA FROM DATA CLASS - ok
        //CRIAR ADAPTER - ok
        //SET ADAPTER
        // LINEAR LAYOUTMANAGER
        // SUBMETER A LISTA


        val recycle = binding.rvPokemon
        val adapterPokemon = pokemonAdapter()

        recycle.adapter = adapterPokemon
        recycle.layoutManager = GridLayoutManager(this, 2)
        adapterPokemon.submitList(listPokemons)


        adapterPokemon.setOnClickListener { listaPokemon ->


        }

    }

}


//CRIAR LISTA

val listPokemons = listOf(
    pokemonsList(
        name = "Bulbasaur ",
        R.drawable.bulbasaur,
        

    ),

    pokemonsList(
        name = "Ivysaur ",
        R.drawable.ivysauro

    ),
    pokemonsList(
        name = "Venusaur",
        R.drawable.venusauro

    ),


    pokemonsList(
        name = "Charmander",
        R.drawable.charmander

    ),
    pokemonsList(
        name = "Charmeleon",
        R.drawable.charmeleon

    ),
    pokemonsList(
        name = "Charizard",
        R.drawable.charizard

    ),


    pokemonsList(
        name = "Squirtle",
        R.drawable.squirtle

    ),
    pokemonsList(
        name = "Wartortle",
        R.drawable.wartortle

    ),
    pokemonsList(
        name = "Blastoise",
        R.drawable.blastoise

    ),


    pokemonsList(
        name = "Catepie",
        R.drawable.caterpie

    ),
    pokemonsList(
        name = "Metapod",
        R.drawable.metapod

    ),
    pokemonsList(
        name = "Butterfree",
        R.drawable.butterfree

    ),
)

