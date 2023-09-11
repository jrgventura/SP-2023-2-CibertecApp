package com.cibertec.cibertecapp

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.Arrays

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            // startActivity(Intent(this, MainActivity::class.java))
            alertWithMultipleChoiceList()
        }

    }

    // Alertas
    fun basicAlert() {
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle("Alerta Básica")
            setMessage("Mostramos un mensaje")
            setPositiveButton("ACEPTAR") { _: DialogInterface, _: Int ->
                enviarDatosAlServidor()
            }
            setNegativeButton("CANCELAR") { _: DialogInterface, _: Int ->
                Toast.makeText(applicationContext, "Cancelar",
                    Toast.LENGTH_LONG).show()
            }
            setNeutralButton("LO REVISARÉ") { _: DialogInterface, _: Int ->
                Toast.makeText(applicationContext, "Mas Adelante",
                    Toast.LENGTH_LONG).show()
            }
            show()
        }
    }

    fun enviarDatosAlServidor() {

    }

    // Alerta Button Icon
    fun basicAlertIcon() {
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle("Llamar a contacto")
            setMessage("Selecciona la opción para continuar")
            setPositiveButton("Llamar", null)
            setPositiveButtonIcon(resources.getDrawable(R.drawable.baseline_call_24,
                null))
            setNegativeButton("Cancelar", null)
            setNeutralButton("Talvez", null)
            show()
        }
    }

    // Alerta con Botones de Colores
    fun basicAlertButtonColor() {
        val builder = AlertDialog.Builder(this)
        with(builder){
            setTitle("LLamar a contacto")
            setMessage("Selecciona la opción para continuar")
            setPositiveButton("Llamar", null)
            setNegativeButton("Cancelar", null)
            setNeutralButton("Talvez", null)
        }
        val alertDialog = builder.create()
        alertDialog.show()

        val buttonPositive = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
        with(buttonPositive) {
            setBackgroundColor(resources.getColor(R.color.blue, null))
            setPadding(10, 0, 10, 0)
            setTextColor(Color.WHITE)
        }

        val buttonNegative = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE)
        with(buttonNegative) {
            setBackgroundColor(resources.getColor(R.color.blue, null))
            setPadding(10, 0, 10, 0)
            setTextColor(Color.WHITE)
        }
    }

    fun alertWithItems() {

        val items = arrayOf("Java", "Kotlin", "Swift", "C++", "C#")

        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle("Lenguajes de Programación")
            setItems(items) { dialog, index ->
                val item = items[index]
                Toast.makeText(context, "$item - selecionado",
                    Toast.LENGTH_LONG).show()
            }
            show()
        }
    }

    fun alertWithOneChoiceList() {
        val items = arrayOf("Java", "Kotlin", "Swift", "C++", "C#")
        var builder = AlertDialog.Builder(this)
        var itemSelected: Int = -1
        with(builder) {
            setTitle("Selecciona el lenguaje")
            setSingleChoiceItems(items, -1) { dialog, index ->
                itemSelected = index
            }
            setPositiveButton("Aceptar") { dialog, which ->
                var item = items[itemSelected]
                Toast.makeText(context, "$item - seleccionado",
                    Toast.LENGTH_LONG).show()
            }
            show()
        }
    }

    fun alertWithMultipleChoiceList() {
        val items = arrayOf("Java", "Kotlin", "Swift", "C++", "C#")
        val selectedList = ArrayList<Int>()
        var builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle("Lista de lenguajes")
            setMultiChoiceItems(items, null) { dialog, index, state ->
                if (state) {
                    selectedList.add(index)
                } else if (selectedList.contains(index)){
                    selectedList.remove(index)
                }
            }
            setPositiveButton("Aceptar") { dialog, which ->
                val selectedStrings = ArrayList<String>()

                for (item in selectedList.indices) {
                    selectedStrings.add(items[selectedList[item]])
                }

                Toast.makeText(context, "Los elementos seleccionados son:"
                        + Arrays.toString(selectedStrings.toTypedArray()),
                    Toast.LENGTH_LONG).show()

            }
            show()
        }
    }
}