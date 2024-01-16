package com.missclick.alies.di


import com.missclick.alies.ui.screens.menu.MenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
       MenuViewModel(
           get()
       )
    }

}

