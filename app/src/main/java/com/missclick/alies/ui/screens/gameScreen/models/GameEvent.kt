package com.missclick.alies.ui.screens.gameScreen.models

import androidx.navigation.NavController

sealed class GameEvent {

    class Guessed(val navController: NavController) : GameEvent()
    class Skip(val navController: NavController) : GameEvent()

    class FinishGame(val navController: NavController) : GameEvent()

    object ContinueGame : GameEvent()
    object Pause : GameEvent()

}