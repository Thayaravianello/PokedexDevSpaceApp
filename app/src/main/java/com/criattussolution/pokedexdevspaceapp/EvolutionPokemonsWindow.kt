package com.criattussolution.pokedexdevspaceapp

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EvolutionPokemonsWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_evolution_pokemons_window)




        val tituloNomePokemon = findViewById<TextView>(R.id.title_tv_evolution_namePokemon)
        val imagemPokemonPrincipal = findViewById<ImageView>(R.id.img_pokemon)
        val setaRetornar = findViewById<ImageView>(R.id.tv_evolution)
        val numberPokemon = findViewById<TextView>(R.id.title_tv_evolution_number)
        val powerOne = findViewById<TextView>(R.id.title_poder_um)
        val powerDois = findViewById<TextView>(R.id.title_poder_dois)
        val dadosPokemonOne = findViewById<TextView>(R.id.title_kg)
        val dadosPokemonTwo = findViewById<TextView>(R.id.title_power)
        val weightLargura = findViewById<TextView>(R.id.title_weight)
        val HeightAltura = findViewById<TextView>(R.id.title_height)
        val StateBasePokemon = findViewById<TextView>(R.id.title_status_pokemon)
        val BarraProgressoOne = findViewById<ProgressBar>(R.id.progressBarOne)
        val BarraProgressoTwo = findViewById<ProgressBar>(R.id.progressBarTwo)
        val BarraProgressoThree = findViewById<ProgressBar>(R.id.progressBarthree)
        val BarraProgressoFour = findViewById<ProgressBar>(R.id.progressBarFour)
        val BarraProgressoFive = findViewById<ProgressBar>(R.id.progressBarFive)







    }


}








