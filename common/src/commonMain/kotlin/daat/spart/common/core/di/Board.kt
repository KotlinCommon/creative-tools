package de.cicerohellmann.core.di

import de.cicerohellmann.viking.game.BoardProvider
import org.koin.dsl.module

val board = module {
    single { BoardProvider() }
}