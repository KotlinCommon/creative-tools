package de.cicerohellmann

import android.app.Application
import de.cicerohellmann.core.di.board
import de.cicerohellmann.core.di.viewModelModule
import de.cicerohellmann.core.tooling.compose.ImageCache
import org.koin.core.context.startKoin

class VikingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ImageCache.initialize(this)
        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            modules(
                board,
                viewModelModule
            )
        }
    }
}