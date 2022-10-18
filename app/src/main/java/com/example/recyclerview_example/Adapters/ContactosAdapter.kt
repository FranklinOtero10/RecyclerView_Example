package com.example.recyclerview_example.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_example.Models.Contacto
import com.example.recyclerview_example.R

class ContactosAdapter(var lstContactos: MutableList<Contacto> = ArrayList(), var context: Context)
    : RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.item_contacto_list,
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lstContactos[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return lstContactos.size
    }

    // Clase que permite enlazar el contenido del archivo item_contactos_list
    // Con la lógica
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val txvNombre: TextView = view.findViewById(R.id.txvNombre)
        private val txvNumeroTelefonico: TextView =
            view.findViewById(R.id.txvNumTel)

        fun bind(contacto: Contacto, context: Context) {
            // Se le asignan valores desde la lógica a la vista
            txvNombre.text = contacto.nombreContacto
            txvNumeroTelefonico.text = contacto.numeroTelefonico.toString()
        }
    }
}