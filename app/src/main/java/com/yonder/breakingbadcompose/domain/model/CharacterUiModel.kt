package com.yonder.breakingbadcompose.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterUiModel(
    val name: String,
    val imageUrl: String,
    val status: String,
    val nickName: String,
    val portrayed: String
) : Parcelable

fun CharacterUiModel.firstName() = name.split(" ").firstOrNull()
fun CharacterUiModel.lastName() = name.split(" ").lastOrNull()

val mockWalterWhite = CharacterUiModel(
    name = "Walter White",
    imageUrl = "https://images.amcnetworks.com/amc.com/wp-content/uploads/2015/04/cast_bb_700x1000_walter-white-lg.jpg",
    status = "Presumed dead",
    nickName = "Heisenberg",
    portrayed = "Bryan Cranston"
)