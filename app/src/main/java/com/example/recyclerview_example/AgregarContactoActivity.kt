package com.example.recyclerview_example

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.recyclerview_example.MainActivity.Companion.lstContactos
import com.example.recyclerview_example.Models.Contacto

class AgregarContactoActivity : AppCompatActivity(), View.OnClickListener {

    // Declaración de componentes necesarios
    private lateinit var edtNombre: EditText
    private lateinit var edtNumeroTelefonico: EditText
    private lateinit var btnRegistrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_contacto)
        // Se agrega la flecha para salir de la actividad
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Se configura el nombre de la actividad
        title = "Agregar Contacto"

        edtNombre = findViewById(R.id.edtNombre)
        edtNumeroTelefonico = findViewById(R.id.edtNumero)
        btnRegistrar = findViewById(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.btnRegistrar -> {
                if(edtNombre.text.toString().isNotEmpty() &&
                    edtNumeroTelefonico.text.toString().isNotEmpty()){
                    // Se guarda el registro en la lista
                    guardarRegistro(edtNombre.text.toString(),edtNumeroTelefonico.text.toString().toInt())
                    // Se muestra un dialog indicando que el registro fué exitoso
                    AlertDialog.Builder(this).setTitle("¡Registro Exitoso!")
                        .setMessage("El registro se guardo con éxito")
                        .setPositiveButton("Ok", DialogInterface.OnClickListener
                        { dialogInterface, i ->
                            // Se saca la actividad de la pila
                            finish()
                        }).show()
                }else{
                    edtNombre.error = "El campo no puede quedar vacio"
                    edtNumeroTelefonico.error = "El campo no puede quedar vacio"
                }
            }
        }
    }

    // Metodo que permite guardar un registro
    private fun guardarRegistro(nombreContacto: String, telefonoContacto: Int){
        val contacto: Contacto = Contacto(nombreContacto, telefonoContacto)
        // Se hace el import de la lista declarada en el MainActivity.kt
        // y se añaden registros
        lstContactos.add(contacto)
    }

    // Se configura la flecha para salir de la actividad
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Finalizar la actividad
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}