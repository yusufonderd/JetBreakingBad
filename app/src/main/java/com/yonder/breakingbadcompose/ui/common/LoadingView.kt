package com.yonder.breakingbadcompose.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.yonder.breakingbadcompose.R
import com.yonder.breakingbadcompose.ui.theme.normal_padding

@Composable
fun LoadingView(centerTextResId: Int = R.string.loading) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(normal_padding)
            )
            Text(text = stringResource(id = centerTextResId))
        }
    }
}

@Preview
@Composable
fun LoadingViewPreview() {
    LoadingView()
}