package com.example.recyclerview_example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.recyclerview_example.Models.Contacto

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Se crean las variables de acuerdo al tipo de componente que se requiera
    // enlazar con el XML
    private lateinit var btnAgregarContacto: Button
    private lateinit var btnMostrarLista: Button
    private lateinit var btnMostrarDatos: Button

    companion object{
        var lstContactos: MutableList<Contacto> = mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Se inicializan los botones creados anteriormente con los elementos creados
        // en el MainActivity.xml
        btnAgregarContacto = findViewById(R.id.btnAgregarContacto)
        btnMostrarLista = findViewById(R.id.btnMostrarLista)
        btnMostrarDatos = findViewById(R.id.btnMostrarDatos)

        configuracionBotones()
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btnAgregarContacto -> {
                // Permite ir a la vista para agregar un contacto
                startActivity(Intent(this, AgregarContactoActivity::class.java))
            }
            R.id.btnMostrarLista -> {
                // Si la lista esta vacia mostramos un mensaje
                if(lstContactos.isEmpty()){
                    Toast.makeText(this,"¡Lista vacia!", Toast.LENGTH_SHORT).show()
                }else{
                    // Permite ir a la vista para mostrar la lista de contactos
                    startActivity(Intent(this, MostrarListaContactoActivity::class.java))
                }
            }
            R.id.btnMostrarDatos -> {
                // Permite ir a la vista para mostrar los datos del desarrollador de la APP
                startActivity(Intent(this, MostrarDatosActivity::class.java))
            }
        }
    }

    fun configuracionBotones(){
        btnAgregarContacto.setOnClickListener(this)
        btnMostrarLista.setOnClickListener(this)
        btnMostrarDatos.setOnClickListener(this)
    }
}