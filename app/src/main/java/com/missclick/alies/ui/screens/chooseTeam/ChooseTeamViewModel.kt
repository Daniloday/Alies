package com.missclick.alies.ui.screens.chooseTeam

import androidx.lifecycle.ViewModel
import com.missclick.alies.common.EventHandler
import com.missclick.alies.data.models.Team
import com.missclick.alies.data.repository.Repository
import com.missclick.alies.data.sharedStates.GameSettings
import com.missclick.alies.ui.screens.chooseTeam.models.ChooseTeamEvent
import com.missclick.alies.ui.screens.chooseTeam.models.ChooseTeamState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChooseTeamViewModel(
    repository: Repository,
    private val gameSettings: GameSettings
) : ViewModel(), EventHandler<ChooseTeamEvent>
{


    private val _state : MutableStateFlow<ChooseTeamState> = MutableStateFlow(ChooseTeamState())
    val state : StateFlow<ChooseTeamState> = _state


    init {
        _state.value = state.value.copy(
            teamList = repository.getAllTeams()
        )
    }

    override fun obtainEvent(event: ChooseTeamEvent) {
        when(event){
            is ChooseTeamEvent.Next -> {next()}
            is ChooseTeamEvent.TeamAllClick -> {teamAllClick(event.item)}
            is ChooseTeamEvent.TeamChoseClick -> {teamChoseClick(event.item)}
        }
    }

    private fun next(){
        gameSettings.state.value = gameSettings.state.value.copy(
            chooseTeams = state.value.choseTeamList
        )
    }

    private fun teamAllClick(item : Team){
        val new = state.value.teamList.toMutableList()
        new.remove(item)
        _state.value = state.value.copy(
            teamList = new,
            choseTeamList = state.value.choseTeamList.plus(item)
        )
    }

    private fun teamChoseClick(item : Team){
        val new = state.value.choseTeamList.toMutableList()
        new.remove(item)
        _state.value = state.value.copy(
            teamList = state.value.teamList.plus(item),
            choseTeamList = new
        )

    }


}