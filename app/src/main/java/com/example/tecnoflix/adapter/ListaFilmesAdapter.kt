package com.example.tecnoflix.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnoflix.R

class ListaFilmesAdapter : RecyclerView.Adapter <RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return 10
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_lista_filme,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is viewHolder) {
        //    holder.capa
        }
    }
    class viewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val capa: ImageView = itemView.findViewById(R.id.capa_filme)
    }
}
