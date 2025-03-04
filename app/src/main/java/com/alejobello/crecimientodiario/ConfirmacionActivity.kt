package com.alejobello.crecimientodiario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ConfirmacionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nombre = intent.getStringExtra("nombre") ?: "Desconocido"
        val habito = intent.getStringExtra("habito") ?: "No especificado"
        val nivel = intent.getStringExtra("nivel") ?: "No especificado"

        setContent {
            ConfirmacionScreen(nombre, habito, nivel)
        }
    }
}

@Composable
fun ConfirmacionScreen(nombre: String, habito: String, nivel: String) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = "¡Registro exitoso!", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Bienvenido, $nombre", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Hábito elegido: $habito", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Nivel de compromiso: $nivel", fontSize = 18.sp)
    }
}
