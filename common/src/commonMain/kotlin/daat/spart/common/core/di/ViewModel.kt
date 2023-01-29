package de.cicerohellmann.core.di

import de.cicerohellmann.viking.game.GameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { GameViewModel() }
}