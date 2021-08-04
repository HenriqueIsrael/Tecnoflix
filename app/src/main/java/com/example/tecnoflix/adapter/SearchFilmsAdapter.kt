package com.example.tecnoflix.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnoflix.R
import com.example.tecnoflix.dados.remote.modelo.ModeloFilmes
import com.squareup.picasso.Picasso

class SearchFilmsAdapter(
    private val listaFilmesPesquisadas: ModeloFilmes,
    private val filmeSelecionado: ListaFilmesAdapter.FilmeSelecionado
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return listaFilmesPesquisadas.results.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderGenerico(
            LayoutInflater.from(parent.context).inflate(R.layout.filme_pesquisado, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolderGenerico) {
            holder.titulo.text = listaFilmesPesquisadas.results[position].title
            Picasso.with(holder.capaPesquisada.context)
                .load("https://image.tmdb.org/t/p/w500/" + listaFilmesPesquisadas.results[position].poster_path)
                .into(holder.capaPesquisada)
            holder.itemView.setOnClickListener {
                filmeSelecionado.enviaDadosDoFilmeClikado(
                    listaFilmesPesquisadas.results[position].title,
                    "https://image.tmdb.org/t/p/w500/" + listaFilmesPesquisadas.results[position].poster_path,
                    listaFilmesPesquisadas.results[position].release_date,
                    listaFilmesPesquisadas.results[position].vote_average,
                    listaFilmesPesquisadas.results[position].vote_count,
                    listaFilmesPesquisadas.results[position].overview
                )
            }
        }
    }

    class ViewHolderGenerico(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val capaPesquisada: ImageView = itemView.findViewById(R.id.filme_pesquisado_capa)
        val titulo: TextView = itemView.findViewById(R.id.titulo_filme_pesquisado)
    }
}
