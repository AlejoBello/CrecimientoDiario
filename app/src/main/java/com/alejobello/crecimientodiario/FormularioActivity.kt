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
            FormularioScreen { nombre, habito, nivel ->
                val intent = Intent(this, ConfirmacionActivity::class.java).apply {
                    putExtra("nombre", nombre)
                    putExtra("habito", habito)
                    putExtra("nivel", nivel)
                }
                startActivity(intent)
            }
        }
    }
}

@Composable
fun FormularioScreen(onEnviar: (String, String, String) -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var habito by remember { mutableStateOf("") }
    var nivel by remember { mutableStateOf("") }
    var isMorning by remember { mutableStateOf(false) }
    var isNight by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = "Ingresa tu nombre:", fontSize = 20.sp)
        BasicTextField(value = nombre, onValueChange = { nombre = it }, modifier = Modifier.fillMaxWidth().padding(8.dp))

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "¿Qué hábito quieres mejorar?", fontSize = 18.sp)
        BasicTextField(value = habito, onValueChange = { habito = it }, modifier = Modifier.fillMaxWidth().padding(8.dp))

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "¿Cuándo prefieres trabajar en este hábito?", fontSize = 18.sp)
        Row {
            Checkbox(checked = isMorning, onCheckedChange = { isMorning = it })
            Text(text = "Mañana", modifier = Modifier.padding(start = 4.dp))
        }
        Row {
            Checkbox(checked = isNight, onCheckedChange = { isNight = it })
            Text(text = "Noche", modifier = Modifier.padding(start = 4.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Nivel de compromiso:", fontSize = 18.sp)
        Row {
            RadioButton(selected = nivel == "Bajo", onClick = { nivel = "Bajo" })
            Text(text = "Bajo", modifier = Modifier.padding(start = 4.dp))

            RadioButton(selected = nivel == "Medio", onClick = { nivel = "Medio" })
            Text(text = "Medio", modifier = Modifier.padding(start = 4.dp))

            RadioButton(selected = nivel == "Alto", onClick = { nivel = "Alto" })
            Text(text = "Alto", modifier = Modifier.padding(start = 4.dp))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { onEnviar(nombre, habito, nivel) }) {
            Text("Enviar")
        }
    }
}
