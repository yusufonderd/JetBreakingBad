package com.yonder.breakingbadcompose.ui.characterdetails

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.request.RequestOptions
import com.google.accompanist.glide.GlideImage
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel
import com.yonder.breakingbadcompose.ui.characterdetails.CharacterProfileImageView
import com.yonder.breakingbadcompose.ui.theme.character_image_details_size
import com.yonder.breakingbadcompose.ui.theme.large_padding
import com.yonder.breakingbadcompose.ui.theme.normal_padding

@Composable
fun CharacterDetails(navController: NavController) {
    val characterUiModel = navController
        .previousBackStackEntry
        ?.arguments
        ?.getParcelable<CharacterUiModel>(CharacterDetails.CHARACTER_UI_MODEL)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(large_padding),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        CharacterHeaderView(characterUiModel = characterUiModel)


        CharacterNameView(characterUiModel = characterUiModel)


    }

}

object CharacterDetails {
    const val CHARACTER_UI_MODEL = "CHARACTER_UI_MODEL"
}




