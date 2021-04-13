package com.yonder.breakingbadcompose.ui.characters

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.bumptech.glide.request.RequestOptions
import com.google.accompanist.glide.GlideImage
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel
import com.yonder.breakingbadcompose.ui.theme.Shapes
import com.yonder.breakingbadcompose.ui.theme.character_image_size
import com.yonder.breakingbadcompose.ui.theme.padding_normal
import com.yonder.breakingbadcompose.ui.theme.padding_small

@Composable
fun CharacterRowView(characterUIModel: CharacterUiModel) {
    val contentDescriptor = "ContentDescriptor"

    Row(modifier = Modifier.padding(padding_small)) {
        GlideImage(
            data = characterUIModel.imageUrl,
            contentDescription = contentDescriptor,
            requestBuilder = {
                val options = RequestOptions()
                options.centerCrop()
                apply(options)
            },
            modifier = Modifier
                .size(character_image_size)
                .clip(Shapes.small)
        )

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = padding_normal)
        ) {
            Text(
                text = characterUIModel.name,
                style = MaterialTheme.typography.body1
            )
            Text(
                text = characterUIModel.status,
                style = MaterialTheme.typography.body2,
                color = Color.DarkGray
            )
            Text(
                text = characterUIModel.nickName,
                style = MaterialTheme.typography.body2,
                color = Color.Gray
            )

        }

    }


}

