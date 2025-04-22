package com.example.calculadorasimple

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var numero1: EditText
    lateinit var numero2: EditText
    lateinit var resultado: TextView
    lateinit var btnSumar: Button
    lateinit var btnRestar: Button
    lateinit var btnMultiplicar: Button
    lateinit var btnDividir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numero1 = findViewById(R.id.numero1)
        numero2 = findViewById(R.id.numero2)
        resultado = findViewById(R.id.txtResultado)
        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        btnMultiplicar = findViewById(R.id.btnMultiplicar)
        btnDividir = findViewById(R.id.btnDividir)

        btnSumar.setOnClickListener { operar("+") }
        btnRestar.setOnClickListener { operar("-") }
        btnMultiplicar.setOnClickListener { operar("*") }
        btnDividir.setOnClickListener { operar("/") }
    }

    private fun operar(operacion: String) {
        val n1 = numero1.text.toString().toDoubleOrNull()
        val n2 = numero2.text.toString().toDoubleOrNull()

        if (n1 != null && n2 != null) {
            val res = when (operacion) {
                "+" -> n1 + n2
                "-" -> n1 - n2
                "*" -> n1 * n2
                "/" -> if (n2 != 0.0) n1 / n2 else "Error: División por 0"
                else -> "Operación no válida"
            }
            resultado.text = "Resultado: $res"
        } else {
            resultado.text = "Por favor ingresa números válidos"
        }
    }
}
