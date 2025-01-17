package com.missclick.alies.ui.screens.chooseTeam

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.missclick.alies.R
import com.missclick.alies.ui.components.BigTeamCard
import com.missclick.alies.ui.components.NextButton
import com.missclick.alies.ui.components.SmallTeamCard
import com.missclick.alies.ui.navigation.NavigationTree
import com.missclick.alies.ui.screens.chooseTeam.models.ChooseTeamEvent
import com.missclick.alies.ui.theme.AppTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChooseTeamScreen(navController: NavController, vm: ChooseTeamViewModel = koinViewModel()) {

    val context = LocalContext.current
    val viewState by vm.state.collectAsState()
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = context.getString(R.string.choose_team),
            style = AppTheme.typography.headerTextBold,
            modifier = Modifier.padding(top = 8.dp),
            color = AppTheme.colors.primary
        )

        Divider(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .fillMaxWidth()
                .height(1.dp), color = AppTheme.colors.primary
        )

        LazyRow(state = listState, content = {
            itemsIndexed(viewState.choseTeamList) { _, item ->
                SmallTeamCard(teamImage = item.image, teamName = item.name) {
                    vm.obtainEvent(ChooseTeamEvent.TeamChoseClick(item))
                }
            }
        })



        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            content = {

                repeat((viewState.teamList.size - 1) / 2 + 1) {
                    item {
                        if (viewState.teamList.isNotEmpty()) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                modifier = Modifier.padding(vertical = 4.dp)
                            ) {
                                BigTeamCard(
                                    teamImage = viewState.teamList[it * 2].image,
                                    teamName = viewState.teamList[it * 2].name
                                ) {
                                    vm.obtainEvent(ChooseTeamEvent.TeamAllClick(viewState.teamList[it * 2]))
                                    coroutineScope.launch {
                                        listState.animateScrollToItem(index = viewState.choseTeamList.size - 1)
                                    }
                                }
                                if (it * 2 + 1 != viewState.teamList.size) {
                                    BigTeamCard(
                                        teamImage = viewState.teamList[it * 2 + 1].image,
                                        teamName = viewState.teamList[it * 2 + 1].name
                                    ) {
                                        vm.obtainEvent(ChooseTeamEvent.TeamAllClick(viewState.teamList[it * 2 + 1]))
                                        coroutineScope.launch {
                                            listState.animateScrollToItem(index = viewState.choseTeamList.size - 1)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            })

        if (viewState.choseTeamList.size > 1) {
            Column(
                Modifier.height(150.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NextButton() {
                    vm.obtainEvent(ChooseTeamEvent.Next(navController))
                }
            }
        }


    }




}