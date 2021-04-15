package com.yonder.breakingbadcompose.ui.characterdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel
import com.yonder.breakingbadcompose.domain.model.firstName
import com.yonder.breakingbadcompose.domain.model.lastName
import com.yonder.breakingbadcompose.ui.theme.large_padding

@Composable
fun CharacterNameView(characterUiModel: CharacterUiModel?){
    Column(modifier = Modifier.padding(large_padding)) {
        Text(
            text = characterUiModel?.firstName().orEmpty(),
            style = MaterialTheme.typography.h4
        )
        Text(
            text = characterUiModel?.lastName().orEmpty(),
            style = MaterialTheme.typography.h4,
            color = LightGray
        )
    }

}