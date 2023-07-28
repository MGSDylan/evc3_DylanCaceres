package com.dylancaceres.EVC

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.dylancaceres.EVC.databinding.ItemPersonajeBinding
import com.dylancaceres.EVC.model.Personaje

class VHPersonajes (private val binding: ItemPersonajeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(personaje : Personaje) {
        binding.txtPersonajeTalla.text = "${personaje.height} height"
        binding.txtPersonajePeso.text="${personaje.width} width"
        binding.imgPersonaje.load(personaje.url)

    }

}