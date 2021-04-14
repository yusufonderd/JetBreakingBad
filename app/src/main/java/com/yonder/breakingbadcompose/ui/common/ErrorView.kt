package com.yonder.breakingbadcompose.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.yonder.breakingbadcompose.R
import com.yonder.breakingbadcompose.ui.theme.padding_normal

@Composable
fun ErrorView(errorMessage: String) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_error_outline_24),
                contentDescription = "error icon",
                tint = Color.Red,
                modifier = Modifier.padding(padding_normal)
            )
            Text(text = errorMessage)
        }

    }

}

@Composable
fun ErrorView(errorMessageResId: Int) {
    ErrorView(errorMessage = stringResource(id = errorMessageResId))
}

@Preview
@Composable
fun ErrorViewPreview() {
    ErrorView("Error occurred")
}