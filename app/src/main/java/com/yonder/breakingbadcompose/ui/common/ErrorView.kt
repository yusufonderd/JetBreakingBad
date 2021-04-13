package com.yonder.breakingbadcompose.ui.common

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.yonder.breakingbadcompose.R

@Composable
fun ErrorView(errorMessage: String) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_error_outline_24),
                contentDescription = null,
                tint = Color.Yellow
            )
            Text(text = errorMessage)
        }

    }

}

@Composable
fun ErrorView(errorMessageResId: Int) {
    ErrorView(errorMessage = stringResource(id = errorMessageResId))
}
