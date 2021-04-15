package com.yonder.breakingbadcompose.ui.characterdetails

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel
import com.yonder.breakingbadcompose.ui.theme.character_image_details_size

@Composable
fun CharacterHeaderView(characterUiModel: CharacterUiModel?){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically

    ) {
        CharacterProfileImageView(characterUiModel = characterUiModel)
        Divider(
            modifier = Modifier
                .width(1.dp)
                .height(character_image_details_size / 2), color = Color.LightGray
        )
        Column() {
            Text(
                text = characterUiModel?.nickName.orEmpty(),
                style = MaterialTheme.typography.h5,
                color = Color.LightGray
            )
            Text(
                text = characterUiModel?.status.orEmpty(),
                style = MaterialTheme.typography.h6,
                color = Color.DarkGray
            )
        }
    }
}

