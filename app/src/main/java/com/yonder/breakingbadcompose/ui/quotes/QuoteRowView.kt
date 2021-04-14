package com.yonder.breakingbadcompose.ui.quotes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.yonder.breakingbadcompose.domain.model.QuoteUiModel
import com.yonder.breakingbadcompose.ui.theme.padding_normal

@Composable
fun QuoteRowView(quoteUiModel: QuoteUiModel){

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(padding_normal)
        ) {
            Text(
                text = quoteUiModel.author,
                style = MaterialTheme.typography.body1
            )
            Text(
                text = quoteUiModel.quote,
                style = MaterialTheme.typography.body2,
                color = Color.Gray
            )
        }
        Divider(color = Color.LightGray)
    }

}

@Preview
@Composable
fun QuoteRowViewPreview() {
    QuoteRowView(QuoteUiModel("Say My Name","Heisenberg"))
}