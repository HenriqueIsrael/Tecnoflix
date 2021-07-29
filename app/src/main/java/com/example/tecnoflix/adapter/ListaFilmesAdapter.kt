package com.example.tecnoflix.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnoflix.R
import com.example.tecnoflix.dados.remote.modelo.ModeloFilmes
import com.squareup.picasso.Picasso

class ListaFilmesAdapter(
    private val listaFilmes: ModeloFilmes,
    private val numeroRecycler: Int,
    private val filmeSelecionado: FilmeSelecionado
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return 6
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return viewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_lista_filme, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is viewHolder) {
            if (numeroRecycler == 1) {
                Picasso.with(holder.capa.context)
                    .load("https://image.tmdb.org/t/p/w500/" + listaFilmes.results[position].poster_path)
                    .into(holder.capa)
            } else if (numeroRecycler == 2) {
                Picasso.with(holder.capa.context)
                    .load("https://image.tmdb.org/t/p/w500/" + listaFilmes.results[position + 6].poster_path)
                    .into(holder.capa)
            } else if (numeroRecycler == 3) {
                Picasso.with(holder.capa.context)
                    .load("https://image.tmdb.org/t/p/w500/" + listaFilmes.results[position + 12].poster_path)
                    .into(holder.capa)
            }
            holder.itemView.setOnClickListener {
                if (numeroRecycler == 1) {
                    filmeSelecionado.enviaDadosDoFilmeClikado(
                        listaFilmes.results[position].title,
                        "https://image.tmdb.org/t/p/w500/" + listaFilmes.results[position].poster_path,
                        listaFilmes.results[position].release_date,
                        listaFilmes.results[position].vote_average,
                        listaFilmes.results[position].vote_count,
                        listaFilmes.results[position].overview
                    )
                } else if (numeroRecycler == 2) {
                    filmeSelecionado.enviaDadosDoFilmeClikado(
                        listaFilmes.results[position + 6].title,
                        "https://image.tmdb.org/t/p/w500/" + listaFilmes.results[position + 6].poster_path,
                        listaFilmes.results[position + 6].release_date,
                        listaFilmes.results[position + 6].vote_average,
                        listaFilmes.results[position + 6].vote_count,
                        listaFilmes.results[position + 6].overview
                    )
                } else if (numeroRecycler == 3) {
                    filmeSelecionado.enviaDadosDoFilmeClikado(
                        listaFilmes.results[position + 12].title,
                        "https://image.tmdb.org/t/p/w500/" + listaFilmes.results[position + 12].poster_path,
                        listaFilmes.results[position + 12].release_date,
                        listaFilmes.results[position + 12].vote_average,
                        listaFilmes.results[position + 12].vote_count,
                        listaFilmes.results[position + 12].overview
                    )
                }
            }
        }
    }

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val capa: ImageView = itemView.findViewById(R.id.capa_filme)
    }

    interface FilmeSelecionado {
        fun enviaDadosDoFilmeClikado(
            titulo: String,
            capaFilme: String,
            dataLancamento: String,
            classificacaoFilme: Double,
            numeroVotos: Int,
            sinopse: String
        )
    }
}
