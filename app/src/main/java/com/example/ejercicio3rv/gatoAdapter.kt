package com.example.ejercicio3rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio3rv.databinding.ItemGatoBinding

class gatoAdapter(var listagato: MutableList<Gato>, private val listener: OnClickListener) : RecyclerView.Adapter<gatoAdapter.gatoViewHolder>() {

    inner class gatoViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemGatoBinding.bind(view)

        fun setListener(gato:Gato){
            binding.root.setOnLongClickListener {
                listener.onLongClick(gato)
                true
            }

        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): gatoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_gato, parent, false)
        return gatoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: gatoViewHolder, position: Int) {
        val gato = listagato.get(position)

        holder.setListener(gato)

        holder.binding.itemNombre.text = gato.nombre
    }

    override fun getItemCount(): Int {
        return listagato.size
    }

    fun addGato(gato: Gato){
        listagato.add(gato)
        notifyDataSetChanged()
    }

    fun removeGato(gato: Gato){
        listagato.remove(gato)
        notifyDataSetChanged()
    }




}