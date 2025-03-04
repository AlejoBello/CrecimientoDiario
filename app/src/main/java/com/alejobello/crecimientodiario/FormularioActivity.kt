package com.alejobello.crecimientodiario

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class FormularioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormularioScreen { nombre, habito, importancia, horario ->
                val intent = Intent(this, ConfirmacionActivity::class.java)
                intent.putExtra("nombre", nombre)
                intent.putExtra("habito", habito)
                intent.putExtra("importancia", importancia)
                intent.putExtra("horario", horario)
                startActivity(intent)
            }
        }
    }
}

@Composable
fun FormularioScreen(onEnviar: (String, String, String, String) -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var habito by remember { mutableStateOf("") }
    var importancia by remember { mutableStateOf("Media") }  // Predeterminado
    var horario by remember { mutableStateOf("Mañana") }  // Predeterminado

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Registro", fontSize = 24.sp, color = Color.Black)

        Spacer(modifier = Modifier.height(20.dp))

        // Nombre
        Text(text = "Ingresa tu nombre:", fontSize = 18.sp, color = Color.Black)
        BasicTextField(
            value = nombre,
            onValueChange = { nombre = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                .padding(12.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Hábito
        Text(text = "¿Qué hábito quieres mejorar?", fontSize = 18.sp, color = Color.Black)
        BasicTextField(
            value = habito,
            onValueChange = { habito = it },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                .padding(12.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Importancia del Hábito (RadioButtons)
        Text(text = "¿Qué tan importante es este hábito para ti?", fontSize = 18.sp, color = Color.Black)
        Column {
            listOf("Baja", "Media", "Alta").forEach { nivel ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = importancia == nivel,
                        onClick = { importancia = nivel }
                    )
                    Text(text = nivel, fontSize = 16.sp, color = Color.Black)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Horario (RadioButtons)
        Text(text = "¿En qué momento del día prefieres realizarlo?", fontSize = 18.sp, color = Color.Black)
        Column {
            listOf("Mañana", "Noche").forEach { opcion ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = horario == opcion,
                        onClick = { horario = opcion }
                    )
                    Text(text = opcion, fontSize = 16.sp, color = Color.Black)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botón Enviar
        Button(
            onClick = { onEnviar(nombre, habito, importancia, horario) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar")
        }
    }
}
