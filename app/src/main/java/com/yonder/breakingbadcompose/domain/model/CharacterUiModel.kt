package com.yonder.breakingbadcompose.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterUiModel(
    val name: String,
    val imageUrl: String,
    val status : String,
    val nickName: String
): Parcelable


fun CharacterUiModel.firstName() = name.split(" ").firstOrNull()
fun CharacterUiModel.lastName() = name.split(" ").lastOrNull()