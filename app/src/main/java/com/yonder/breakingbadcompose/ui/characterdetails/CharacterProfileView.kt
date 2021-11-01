package com.yonder.breakingbadcompose.ui.characterdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.yonder.breakingbadcompose.domain.model.CharacterUiModel
import com.yonder.breakingbadcompose.domain.model.mockWalterWhite
import com.yonder.breakingbadcompose.ui.theme.character_image_details_size

@Composable
fun CharacterProfileImageView(characterUiModel: CharacterUiModel?) {
    if (characterUiModel != null) {
        Image(
            painter = rememberImagePainter(characterUiModel.imageUrl),
            contentDescription = "character profile image",
            modifier = Modifier
                .size(character_image_details_size)
                .clip(RoundedCornerShape(12.dp))
        )

    }
}


@Preview
@Composable
fun CharacterProfileImageViewPreview() {
     CharacterProfileImageView(
        mockWalterWhite
    )
}