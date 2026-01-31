package com.example.adivinaelnumero.login.presentacion.viewmodels

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class AdivinaViewModel : ViewModel() {
    var numeroMagico by mutableStateOf(Random.nextInt(1, 101))
    var intentos by mutableStateOf(7)
    var mensaje by mutableStateOf("¡Adivina el número!")
    var finalizado by mutableStateOf(false)

    fun jugar(numeroEntrada: String) {
        val num = numeroEntrada.toIntOrNull()
        if (num != null) {
            intentos = intentos - 1

            if (num == numeroMagico) {
                mensaje = "¡Ganaste! Era el $numeroMagico"
                finalizado = true
            } else if (intentos <= 0) {
                mensaje = "Perdiste. El número era $numeroMagico"
                finalizado = true
            } else {
                val resta = if (num > numeroMagico) num - numeroMagico else numeroMagico - num
                if (resta <= 10) {
                    mensaje = "¡Estás cerca! (Caliente)"
                } else {
                    mensaje = "Estás lejos... (Frío)"
                }
            }
        }
    }
}