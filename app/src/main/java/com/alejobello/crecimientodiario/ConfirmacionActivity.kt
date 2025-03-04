package com.alejobello.crecimientodiario

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ConfirmacionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nombre = intent.getStringExtra("nombre") ?: "Desconocido"
        val habito = intent.getStringExtra("habito") ?: "No especificado"
        val importancia = intent.getStringExtra("importancia") ?: "No especificado"
        val horario = intent.getStringExtra("horario") ?: "No especificado"

        setContent {
            ConfirmacionScreen(nombre, habito, importancia, horario, this)
        }
    }
}

@Composable
fun ConfirmacionScreen(nombre: String, habito: String, importancia: String, horario: String, activity: Activity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF5F5F5), shape = RoundedCornerShape(12.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "¡Registro Exitoso!", fontSize = 24.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(20.dp))

        // Mostrar los datos ingresados
        Text(text = "Bienvenido, $nombre", fontSize = 20.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Hábito: $habito", fontSize = 18.sp, color = Color.Black)
        Text(text = "Importancia: $importancia", fontSize = 18.sp, color = Color.Black)
        Text(text = "Horario: $horario", fontSize = 18.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(30.dp))

        // Botón para salir de la app
        Button(
            onClick = { activity.finishAffinity() }, // Cierra la app completamente
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Salir")
        }
    }
}
