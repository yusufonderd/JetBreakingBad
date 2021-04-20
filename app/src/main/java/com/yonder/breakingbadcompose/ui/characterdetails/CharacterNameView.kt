package com.yonder.breakingbadcompose.ui.characterdetails

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.tooling.preview.Preview
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel
import com.yonder.breakingbadcompose.domain.model.firstName
import com.yonder.breakingbadcompose.domain.model.lastName
import com.yonder.breakingbadcompose.domain.model.mockWalterWhite
import com.yonder.breakingbadcompose.ui.theme.large_padding

@Composable
fun CharacterNameView(characterUiModel: CharacterUiModel?) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {

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

        Text(
            text = characterUiModel?.portrayed.orEmpty(),
            style = MaterialTheme.typography.h5,
            color = Color.Black
        )

    }

}

@Preview
@Composable
fun CharacterNameViewPreview() {
    CharacterProfileImageView(
        mockWalterWhite
    )
}