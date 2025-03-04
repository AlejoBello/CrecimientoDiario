package com.alejobello.crecimientodiario


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaPresentacion {
                val intent = Intent(this, FormularioActivity::class.java)
                startActivity(intent)
            }
        }
    }
}

@Composable
fun PantallaPresentacion(onContinuar: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Bienvenido a Crecimiento Diario", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onContinuar) {
            Text("Comenzar")
        }
    }
}
