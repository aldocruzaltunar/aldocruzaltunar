package com.example.adivinaelnumero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.adivinaelnumero.login.presentacion.screens.AdivinaScreen
import com.example.adivinaelnumero.login.presentacion.viewmodels.AdivinaViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val miJuegoVM = AdivinaViewModel()

        setContent {
            Surface {
                AdivinaScreen(vm = miJuegoVM)
            }
        }
    }
}