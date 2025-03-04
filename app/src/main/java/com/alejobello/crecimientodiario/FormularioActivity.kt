package com.alejobello.crecimientodiario

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class FormularioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormularioScreen { nombre ->
                val intent = Intent(this, ConfirmacionActivity::class.java)
                intent.putExtra("nombre", nombre)
                startActivity(intent)
            }
        }
    }
}

@Composable
fun FormularioScreen(onEnviar: (String) -> Unit) {
    var nombre by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Ingresa tu nombre:", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(10.dp))
        BasicTextField(value = nombre, onValueChange = { nombre = it })
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { onEnviar(nombre) }) {
            Text("Enviar")
        }
    }
}
