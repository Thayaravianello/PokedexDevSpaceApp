package com.criattussolution.pokedexdevspaceapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PokemonAdapter :
    ListAdapter<PokemonResult, PokemonAdapter.PokemonViewHolder>(PokemonDiffutil()) {

    private var onClickListener: ((PokemonResult) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val itemPokemon = getItem(position)
        holder.bind(itemPokemon, onClickListener)
    }

    fun setOnClickListener(onClick: (PokemonResult) -> Unit) {
        onClickListener = onClick
    }

    class PokemonViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val tvPokemon = view.findViewById<TextView>(R.id.title_recyv_poke)
        private val imgPokemon = view.findViewById<ImageView>(R.id.rv_img)

        fun bind(pokemonResult: PokemonResult, onClick: ((PokemonResult) -> Unit)?) {
            tvPokemon.text = pokemonResult.name

            val pokemonId = pokemonResult.url.split("pokemon/").getOrNull(1)?.split("/")?.getOrNull(0)?.toIntOrNull()

            if (pokemonId != null) {
                val imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokemonId.png"

                Log.d("PokemonImage", "Image URL: $imageUrl")

                Glide.with(view.context)
                    .load(imageUrl)
                    .into(imgPokemon)
            } else {

                imgPokemon.setImageResource(R.drawable.squirtle) // (MUDAAAAAR A IMAGEM DE SQUIRTLE PARA UMA DE ERRO)
            }

            view.setOnClickListener {
                onClick?.invoke(pokemonResult)
            }
        }
    }

    class PokemonDiffutil : DiffUtil.ItemCallback<PokemonResult>() {
        override fun areItemsTheSame(oldItem: PokemonResult, newItem: PokemonResult): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PokemonResult, newItem: PokemonResult): Boolean {
            return oldItem.name == newItem.name
        }
    }
}