package com.criattussolution.pokedexdevspaceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


//adaptar o dae class e o pokemonlist layout

class pokemonAdapter :
    ListAdapter<pokemonsList, pokemonAdapter.pokemonViewHolder>(pokemonDiffutil()) {

    private lateinit var onClickListener: (pokemonsList) -> Unit


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pokemonViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return pokemonViewHolder(view)

    }


    //bind - atrelar o dado com a UI

    override fun onBindViewHolder(holder: pokemonViewHolder, position: Int) {

        val itemPokemon = getItem(position)
        holder.bind(itemPokemon, onClickListener)


    }


    fun setOnClickListener(onClick: (pokemonsList) -> Unit) {
        onClickListener = onClick

    }


    //criar class viewholder = view que segura os dados

    class pokemonViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val tvPokemon = view.findViewById<TextView>(R.id.title_recyv_poke)
        private val imgPokemon = view.findViewById<ImageView>(R.id.rv_img)

        fun bind(pokemonsList: pokemonsList, onCilick: (pokemonsList) -> Unit) {
            tvPokemon.text = pokemonsList.name
            imgPokemon.setImageResource(pokemonsList.imgPokemon)

            view.setOnClickListener {
                onCilick.invoke(pokemonsList)
            }
        }

    }


    // compara a diferenã quando a nossa lista é atualizada

    class pokemonDiffutil : DiffUtil.ItemCallback<pokemonsList>() {
        override fun areItemsTheSame(oldItem: pokemonsList, newItem: pokemonsList): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: pokemonsList, newItem: pokemonsList): Boolean {
            return oldItem.name == newItem.name
        }

    }


}