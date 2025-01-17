package com.missclick.alies.ui.screens.chooseVocabulary.models

import android.content.Context
import androidx.navigation.NavController

sealed class ChooseVocabularyEvent {
    class Next(val navController: NavController) : ChooseVocabularyEvent()
    class ClickVocabulary(val vocabulary: Vocabulary) : ChooseVocabularyEvent()

}

