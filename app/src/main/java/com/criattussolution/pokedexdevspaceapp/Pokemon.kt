package com.criattussolution.pokedexdevspaceapp

import androidx.core.view.WindowInsetsCompat.Type

data class Pokemon (
    val id: Int,
    val name: String,
    val types: List<PokemonType>,
    val sprites: Sprites
)

data class PokemonType(
    val type: TypeDetails
)

data class TypeDetails(
    val name: String
)

data class Sprites(
    val front_default: String
)