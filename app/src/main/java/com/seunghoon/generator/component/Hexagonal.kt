package com.seunghoon.generator.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun Hexagonal() {
    Canvas(modifier = Modifier.size(100.dp).background(Color.Gray)) {
        /*drawPoints(
            points = listOf(Offset(0.1f, 0.1f), Offset(0.2f, 0.2f)),
            pointMode = PointMode.Lines,
            strokeWidth = 0.3f,
        )*/
    }
}

@Preview(showBackground = true)
@Composable
private fun HexagonalPreview() {
    
}
