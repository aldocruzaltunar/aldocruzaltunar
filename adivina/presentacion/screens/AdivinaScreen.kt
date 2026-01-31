package com.example.adivinaelnumero.login.presentacion.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.adivinaelnumero.login.presentacion.viewmodels.AdivinaViewModel

@Composable
fun AdivinaScreen(vm: AdivinaViewModel) {
    var entrada by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(vm.mensaje, style = MaterialTheme.typography.headlineMedium)
        Text("Intentos restantes: ${vm.intentos}")

        TextField(
            value = entrada,
            onValueChange = { entrada = it },
            label = { Text("Escribe un número") },
            enabled = !vm.finalizado
        )

        Button(
            onClick = {
                vm.jugar(entrada)
                entrada = ""
            },
            enabled = !vm.finalizado && entrada.isNotEmpty()
        ) {
            Text("Probar")
        }
    }
}