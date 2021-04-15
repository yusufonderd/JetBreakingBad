package com.yonder.breakingbadcompose.ui.characterdetails

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import com.google.accompanist.glide.GlideImage
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel
import com.yonder.breakingbadcompose.ui.theme.character_image_details_size

@Composable
fun CharacterProfileImageView(characterUiModel: CharacterUiModel?) {
    if (characterUiModel != null) {
        GlideImage(
            data = characterUiModel.imageUrl,
            contentDescription = "character profile image",
            requestBuilder = {
                val options = RequestOptions()
                options.centerCrop()
                apply(options)
            },
            modifier = Modifier
                .size(character_image_details_size)
                .clip(RoundedCornerShape(12.dp))

        )
    }
}


@Preview
@Composable
fun CharacterProfileImageViewPreview() {
    val imageUrl =
        "https://images.amcnetworks.com/amc.com/wp-content/uploads/2015/04/cast_bb_700x1000_walter-white-lg.jpg"
    CharacterProfileImageView(
        CharacterUiModel(
            name = "Walter White",
            imageUrl = imageUrl,
            status = "Presumed dead",
            nickName = "Heisenberg"
        )
    )
}