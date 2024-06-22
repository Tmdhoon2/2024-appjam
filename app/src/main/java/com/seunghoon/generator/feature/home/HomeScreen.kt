package com.seunghoon.generator.feature.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.seunghoon.designsystem.ui.theme.Typography
import com.seunghoon.generator.R
import com.seunghoon.generator.component.DopamineProgress
import com.seunghoon.generator.component.Header

@Composable
internal fun HomeScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Header()
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = "내 도파민 분석하기",
                style = Typography.HeadLine,
            )
            Spacer(modifier = Modifier.height(26.dp))
            HorizontalDivider(thickness = 1.dp)
            Spacer(modifier = Modifier.height(16.dp))
            MyDopamineCard {

            }
            Spacer(modifier = Modifier.height(42.dp))
            Text(
                text = "오늘의 도파민 선택하기",
                style = Typography.HeadLine,
            )
        }
    }
}

@Composable
internal fun MyDopamineCard(
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(20.dp),
            )
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(
                horizontal = 10.dp,
                vertical = 20.dp,
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "현재 내 도파민",
                style = Typography.HeadLine.copy(
                    fontSize = 16.sp,
                )
            )
            Row(
                modifier = Modifier.clickable(
                    onClick = onClick,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "더 알아보기",
                    style = Typography.HeadLine.copy(
                        fontSize = 12.sp,
                        color = Color(0x22000000),
                    )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_right),
                    contentDescription = null,
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        DopamineProgress(
            currentProgress = 1f,
            maxProgress = 7f,
        )
    }
}

@Composable
internal fun DopamineCard(
    title: String,
    imageUrl: String,
    checked: Boolean,
    onChecked: () -> Unit,
    onClick: () -> Unit,
) {
    val checkedAlpha by animateFloatAsState(
        targetValue = if (checked) 0f
        else 1f,
        label = "",
    )
    val checkBackground by animateColorAsState(
        targetValue = if (checked) Color(0xFFEE3B3B)
        else Color(0xFFD9D9D9),
        label = "",
    )

    Box {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
        )
        Column {
            Row {
                Text(
                    text = title,
                    style = Typography.HeadLine.copy(
                        fontSize = 16.sp,
                        color = Color.White,
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .alpha(checkedAlpha)
                        .background(checkBackground),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_check),
                        contentDescription = null,
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.clickable(
                    onClick = onClick,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "더 알아보기",
                    style = Typography.HeadLine.copy(
                        fontSize = 12.sp,
                        color = Color(0x22000000),
                    )
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_right),
                    contentDescription = null,
                )
            }
        }
    }
}
