package com.kryvovyaz.dailynews.presentation.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.kryvovyaz.dailynews.presentation.Dimentions.radius_6
import com.kryvovyaz.dailynews.ui.theme.WhiteGray

@Composable
fun NewsButton(
    text: String,
    onCLick: () -> Unit
) {
    Button(
        onClick = onCLick,
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(size = radius_6)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }

}

@Composable
fun NewsTextButton(
    text: String,
    onCLick: () -> Unit
) {
    TextButton(onClick = onCLick) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
            color = WhiteGray
        )
    }
}

@Preview
@Composable
private fun NewsButtonPreview() {
    MaterialTheme {
        NewsButton(
            text = "preview",
            onCLick = {}
        )
    }
}