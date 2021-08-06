package com.example.tecnoflix.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tecnoflix.R
import com.example.tecnoflix.dados.remote.modelo.ModeloFavoritos
import com.squareup.picasso.Picasso

class ListaFavoritosAdapter(
    private val listFavorite: List<ModeloFavoritos>,
    private val filmeSelecionado: ListaFilmesAdapter.FilmeSelecionado
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemCount(): Int {
        return listFavorite.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderGenerico(
            LayoutInflater.from(parent.context).inflate(R.layout.filme_pesquisado, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolderGenerico) {
            holder.titulo.text = listFavorite[position].title
            Picasso.with(holder.capaPesquisada.context)
                .load("https://image.tmdb.org/t/p/w500/" + listFavorite[position].capaImagem)
                .into(holder.capaPesquisada)
            holder.itemView.setOnClickListener {
                filmeSelecionado.enviaDadosDoFilmeClikado(
                    listFavorite[position].title,
                    "https://image.tmdb.org/t/p/w500/" + listFavorite[position].capaImagem,
                    listFavorite[position].dataLancamento,
                    listFavorite[position].avaliacao.toDouble(),
                    listFavorite[position].numVotos.toInt(),
                    listFavorite[position].sinopse
                )
            }
        }
    }

    class ViewHolderGenerico(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val capaPesquisada: ImageView = itemView.findViewById(R.id.filme_pesquisado_capa)
        val titulo: TextView = itemView.findViewById(R.id.titulo_filme_pesquisado)
    }
}
