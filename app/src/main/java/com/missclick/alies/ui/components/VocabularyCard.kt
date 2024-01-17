package com.missclick.alies.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.missclick.alies.ui.screens.chooseVocabulary.models.Vocabulary
import com.missclick.alies.ui.theme.AppTheme

@Composable
fun VocabularyCard(vocabulary: Vocabulary, checkboxClick : () -> Unit){

    var myState by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .size(280.dp, 80.dp)
            .border(width = 4.dp, shape = RoundedCornerShape(20.dp), color = AppTheme.colors.accent),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(0.dp),
        colors = CardDefaults.cardColors(containerColor = AppTheme.colors.secondaryBackground)
    ) {

        Box(
            Modifier.fillMaxSize().align(Alignment.Start),
        ) {
            Box(
                modifier = Modifier.padding(start = 24.dp).size(32.dp).align(Alignment.CenterStart).clip(shape = RoundedCornerShape(10.dp)).border(4.dp, AppTheme.colors.primary,shape = RoundedCornerShape(10.dp)),
            ) {
                Checkbox(
                    checked = vocabulary.isSelected,
                    onCheckedChange = { checkboxClick.invoke()},
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Color.Transparent,
                        checkedColor = Color.Transparent,
                        checkmarkColor = AppTheme.colors.primary
                    )
                )
            }
            Text(text = vocabulary.name, modifier = Modifier.align(Alignment.Center), style = AppTheme.typography.teamCardText, color = AppTheme.colors.primary)
        }
    }
}