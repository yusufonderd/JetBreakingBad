package com.yonder.breakingbadcompose.ui.characterdetails

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.request.RequestOptions
import com.google.accompanist.glide.GlideImage
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel
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
            .fillMaxSize()
            .padding(large_padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        GlideImage(
            data = characterUiModel?.imageUrl.orEmpty(),
            contentDescription = "character profile image",
            requestBuilder = {
                val options = RequestOptions()
                options.centerCrop()
                apply(options)
            },
            modifier = Modifier
                .size(character_image_details_size)
                .clip(CircleShape)
                .border(2.dp, LightGray, CircleShape)
        )
        Text(
            text = characterUiModel?.name.orEmpty(),
            modifier = Modifier.padding(normal_padding)
        )

    }

}

object CharacterDetails {
    const val CHARACTER_UI_MODEL = "CHARACTER_UI_MODEL"
}




