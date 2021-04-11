package com.yonder.breakingbadcompose.data.remote.response

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("char_id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("birthday") val birthday: String?,
    @SerializedName("nickname") val nickName: String?,
    @SerializedName("img") val photo: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("occupation") val occupation: List<String?>?,
)