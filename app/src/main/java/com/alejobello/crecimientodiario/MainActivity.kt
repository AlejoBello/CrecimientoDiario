package com.alejobello.crecimientodiario

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaPresentacion(
                onContinuar = {
                    val intent = Intent(this, FormularioActivity::class.java)
                    startActivity(intent)
                },
                onSalir = { finishAffinity() } // Cierra la app completamente
            )
        }
    }
}

@Composable
fun PantallaPresentacion(onContinuar: () -> Unit, onSalir: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Logo de la app",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Bienvenido a Crecimiento Diario", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onContinuar) { Text("Comenzar") }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = onSalir, colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error)) {
            Text("Salir")
        }
    }
}
