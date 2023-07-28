package com.dylancaceres.EVC.UI.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.dylancaceres.EVC.R
import com.dylancaceres.EVC.VHPersonajes
import com.dylancaceres.EVC.databinding.ItemPersonajeBinding
import com.dylancaceres.EVC.model.Personaje

class RVpersonajeAdapter( private var personajes:List<Personaje>): RecyclerView.Adapter<VHPersonajes>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHPersonajes {
        val binding = ItemPersonajeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VHPersonajes(binding)
    }

    override fun getItemCount(): Int = personajes.size

    override fun onBindViewHolder(holder: VHPersonajes, position: Int) {
        holder.bind(personajes[position])
    }

}
