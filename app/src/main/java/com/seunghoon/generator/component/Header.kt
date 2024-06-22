package com.seunghoon.generator.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seunghoon.designsystem.ui.theme.Typography

@Composable
internal fun Header(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 4.dp)
            .background(color = Color.White)
            .padding(vertical = 18.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = title,
            style = Typography.Medium.copy(
                fontSize = 16.sp,
                color = Color(0xFFADADAD),
            )
        )
    }
}
