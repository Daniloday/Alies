package com.missclick.alies.ui.screens.roundResultScreen

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.missclick.alies.common.EventHandler
import com.missclick.alies.data.sharedStates.gameProcess.GameProcessShared
import com.missclick.alies.data.sharedStates.gameProcess.ShowedWords
import com.missclick.alies.data.sharedStates.gameProcess.TeamsScore
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.screens.roundResultScreen.models.RoundResultScreenEvent
import com.missclick.alies.ui.screens.roundResultScreen.models.RoundResultScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RoundResultScreenViewModel(
    private val gameProcess: GameProcessShared
) : ViewModel(), EventHandler<RoundResultScreenEvent> {

    private val _state: MutableStateFlow<RoundResultScreenState> = MutableStateFlow(
        RoundResultScreenState()
    )
    val state: StateFlow<RoundResultScreenState> = _state

    init {
        val score = gameProcess.state.value.showedWords.count { it.guessed } - gameProcess.state
            .value.showedWords.count { !it.guessed }
        _state.value = state.value.copy(
            roundScore = if (score > 0) score else 0,
            roundWords = gameProcess.state.value.showedWords
        )
    }

    override fun obtainEvent(event: RoundResultScreenEvent) {
        when (event) {
            is RoundResultScreenEvent.Next -> {
                next(event.navController)
            }

            is RoundResultScreenEvent.ChangeTick -> {
                changeTick(event.indexOfWord)
            }
        }
    }

    private fun next(navController: NavController) {


        val newTeams = gameProcess.state.value.teams.map {
            if (it.teamName == gameProcess.state.value.step!!.name) {
                TeamsScore(
                    teamName = it.teamName, score = it.score
                            + state.value.roundScore, image = it.image
                )
            } else {
                it
            }
        }

        gameProcess.state.value = gameProcess.state.value.copy(
            teams = newTeams
        )

        navController.navigate(NavigationTree.TEAM_RESULT_SCREEN.name)
    }

    private fun changeTick(indexOfWord: Int) {

        val listOfWordsNew = state.value.roundWords.mapIndexed { index, showedWords ->
            if (index == indexOfWord) ShowedWords(
                word = showedWords.word,
                guessed = !showedWords.guessed
            )
            else showedWords
        }

        val score = listOfWordsNew.count { it.guessed } - listOfWordsNew.count { !it.guessed }

        _state.value = state.value.copy(
            roundWords = listOfWordsNew,
            roundScore = if (score > 0) score else 0,
        )
    }


}