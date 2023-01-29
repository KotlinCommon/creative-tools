package de.cicerohellmann

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import de.cicerohellmann.engine.simulation
import de.cicerohellmann.sprite.DrawSprite

class EntryPoint : ComponentActivity() {
    override fun onDestroy() {
        super.onDestroy()
        simulation.cancel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawSprite(applicationContext)
        }
    }
}