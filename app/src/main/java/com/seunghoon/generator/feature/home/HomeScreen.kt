package com.seunghoon.generator.feature.home

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.seunghoon.designsystem.ui.theme.Typography
import com.seunghoon.generator.R
import com.seunghoon.generator.component.DopamineProgress
import com.seunghoon.generator.component.Header
import com.seunghoon.generator.navigation.NavigationRoute

@Composable
internal fun HomeScreen(
    navHostController: NavHostController,
    navController: NavController,
) {
    var start by remember { mutableIntStateOf(0) }
    var max by remember { mutableIntStateOf(100) }

    var maxChecked by remember { mutableIntStateOf(4) }
    val checked = remember { mutableStateListOf<Int>() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF7F7)),
    ) {
        Header(title = "도파민 다이어리")
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.height(18.dp))
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .padding(horizontal = 18.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp),
                    )
                    .padding(
                        horizontal = 24.dp,
                        vertical = 8.dp,
                    ),
            ) {
                Spacer(modifier = Modifier.height(18.dp))
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row {
                        Column {
                            Text(
                                text = "현재 도파민",
                                style = Typography.HeadLine.copy(
                                    fontSize = 16.sp,
                                )
                            )
                            Text(
                                text = "오늘의 도파민 점수를 확인해보세요!",
                                style = Typography.HeadLine.copy(
                                    fontSize = 12.sp,
                                ),
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "$start/$max",
                            style = Typography.Medium,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Spacer(modifier = Modifier.height(28.dp))
                    DopamineProgress(
                        currentProgress = start.toFloat(),
                        maxProgress = max.toFloat(),
                    )
                }
            }
            Spacer(modifier = Modifier.height(18.dp))
            Image(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = {
                            navController.navigate(NavigationRoute.Root.RECOMMEND) {
                                popUpTo(0) {
                                    saveState = true
                                }
                            }
                        },
                        indication = null,
                    ),
                painter = painterResource(id = R.drawable.ic_5),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .padding(
                        horizontal = 12.dp,
                        vertical = 12.dp,
                    )
            ) {
                Row {
                    Column {
                        Text(
                            text = "오늘의 도파민",
                            style = Typography.HeadLine.copy(
                                fontSize = 16.sp,
                            )
                        )
                        Text(
                            text = "도파민 점수를 올려보세요!",
                            style = Typography.HeadLine.copy(
                                fontSize = 12.sp,
                            ),
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "${checked.size}/${maxChecked}",
                        style = Typography.Medium.copy(fontWeight = FontWeight.Bold),
                    )
                }
                Row {
                    DopamineCard(
                        title = "숙면",
                        imageUrl = R.drawable.ic_sleep,
                        checked = checked.contains(0),
                        onChecked = {
                            if (checked.contains(0)) {
                                checked.remove(0)
                                start -= 20
                            } else {
                                checked.add(0)
                                start += 20
                            }
                        },
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    DopamineCard(
                        title = "TV",
                        imageUrl = R.drawable.ic_tv,
                        checked = checked.contains(1),
                        onChecked = {
                            if (checked.contains(1)) {
                                checked.remove(1)
                                start -= 20
                            } else {
                                checked.add(1)
                                start += 20
                            }
                        },
                    )
                }
                Row {
                    DopamineCard(
                        title = "여행",
                        imageUrl = R.drawable.ic_trip,
                        checked = checked.contains(2),
                        onChecked = {
                            if (checked.contains(2)) {
                                checked.remove(2)
                                start -= 20
                            } else {
                                checked.add(2)
                                start += 20
                            }
                        },
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    DopamineCard(
                        title = "음식",
                        imageUrl = R.drawable.ic_food,
                        checked = checked.contains(3),
                        onChecked = {
                            if (checked.contains(3)) {
                                checked.remove(3)
                                start -= 20
                            } else {
                                checked.add(3)
                                start += 20
                            }
                        },
                    )
                }
            }
        }
    }
}

@Composable
internal fun RowScope.DopamineCard(
    title: String,
    imageUrl: Int,
    checked: Boolean,
    onChecked: () -> Unit,
) {
    val checkedAlpha by animateFloatAsState(
        targetValue = if (checked) 1f
        else 0f,
        label = "",
    )
    val checkBackground by animateColorAsState(
        targetValue = if (checked) Color(0xFFEE3B3B)
        else Color(0xFFD9D9D9),
        label = "",
    )

    Box(
        modifier = Modifier
            .weight(1f)
            .aspectRatio(1f)
            .padding(12.dp)
            .clickable(
                onClick = onChecked,
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
            )
            .clip(RoundedCornerShape(20.dp)),
    ) {
        Image(
            painter = painterResource(id = imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.SpaceBetween) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    style = Typography.HeadLine.copy(
                        fontSize = 16.sp,
                        color = Color.White,
                    )
                )
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(checkBackground),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        modifier = Modifier.alpha(checkedAlpha),
                        painter = painterResource(id = R.drawable.ic_check),
                        contentDescription = null,
                        tint = Color.White,
                    )
                }
            }
            Row(
                modifier = Modifier.clickable(
                    onClick = onChecked,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "인증하기",
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
