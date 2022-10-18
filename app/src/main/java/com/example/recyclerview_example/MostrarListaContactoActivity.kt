package com.example.recyclerview_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_example.Adapters.ContactosAdapter
import com.example.recyclerview_example.MainActivity.Companion.lstContactos

class MostrarListaContactoActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var contactosAdapter: ContactosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_lista_contacto)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Titulo para la actividad
        title = "Mostrar Lista"

        // Llamada al configurador del recyclerView
        configRecyclerView()
    }

    // Configurar flechita de la barra
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                // Finalizar la actividad
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // Metodo que permite configurar el RecyclerView
    private fun configRecyclerView(){
        recyclerView = findViewById(R.id.rcvContactos)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Se hace el import de la lista de contactos y se le pasa al adaptador
        contactosAdapter = ContactosAdapter(lstContactos, this)
        recyclerView.adapter = contactosAdapter
    }
}