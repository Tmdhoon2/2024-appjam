package com.seunghoon.generator.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seunghoon.generator.R

@Composable
internal fun DopamineProgress(
    currentProgress: Float,
    maxProgress: Float,
) {
    val progress = if (currentProgress != 0f) currentProgress / maxProgress
    else 0f
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            when (progress) {
                in 0f..0.2f -> {
                    Image(
                        alpha = if (progress in 0f..0.33f) 1f
                        else 0f,
                        painter = painterResource(id = R.drawable.ic_1),
                        contentDescription = null,
                    )
                }

                in 0.2f..0.66f -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_2),
                        contentDescription = null,
                    )
                }

                else -> {
                    Image(
                        alpha = if (progress in 0.67f..2f) 1f
                        else 0f,
                        painter = painterResource(id = R.drawable.ic_3),
                        contentDescription = null,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Box(contentAlignment = Alignment.CenterStart) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(color = Color(0xFFD9D9D9)),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(progress)
                    .height(4.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(color = Color(0xFFEE3C3C)),
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Box(
                    modifier = Modifier
                        .size(
                            width = 4.dp,
                            height = 20.dp,
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            color = Color(
                                if (progress >= 0.2f) 0xFFEE3C3C
                                else 0xFFD9D9D9,
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .size(
                            width = 4.dp,
                            height = 20.dp,
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            color = Color(
                                if (progress >= 0.5f) 0xFFEE3C3C
                                else 0xFFD9D9D9,
                            )
                        )
                )
                Box(
                    modifier = Modifier
                        .size(
                            width = 4.dp,
                            height = 20.dp,
                        )
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            color = Color(
                                if (progress >= 0.85f) 0xFFEE3C3C
                                else 0xFFD9D9D9,
                            )
                        )
                )
            }
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Column {
            Text(
                text = "부족",
                color = Color(
                    if (progress in 0f..0.33f) 0xFF000000
                    else 0xFFD9D9D9,
                )
            )
        }
        Column {
            Text(
                text = "정상",
                color = Color(
                    if (progress in 0.34f..0.66f) 0xFF000000
                    else 0xFFD9D9D9,
                )
            )
        }
        Column {
            Text(
                text = "많음",
                color = Color(
                    if (progress in 0.67f..2f) 0xFF000000
                    else 0xFFD9D9D9,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DopamineProgressPreview() {
    DopamineProgress(
        currentProgress = 1f,
        maxProgress = 7f,
    )
}
