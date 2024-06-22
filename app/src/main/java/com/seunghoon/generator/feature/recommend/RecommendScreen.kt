package com.seunghoon.generator.feature.recommend

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.seunghoon.designsystem.ui.theme.Typography
import com.seunghoon.generator.component.Header
import com.seunghoon.generator.feature.home.MyDopamineCard

@Composable
internal fun RecommendScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Header(title = "title")
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = "내 도파민 분석하기",
                style = Typography.HeadLine,
            )
            Spacer(modifier = Modifier.height(26.dp))
            HorizontalDivider(thickness = 1.dp)
            Spacer(modifier = Modifier.height(28.dp))
            Text(
                text = "오늘의 점수",
                style = Typography.HeadLine,
            )
            Spacer(modifier = Modifier.height(28.dp))
            MyDopamineCard(title = "내 도파민 분석하기") {
                Text(
                    text = "75/100",
                    color = Color(0x40000000),
                    style = Typography.HeadLine.copy(fontSize = 16.sp),
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Column {
                Text(
                    text = "추천 활동!",
                    style = Typography.HeadLine,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "도파민 점수를 올릴 수 있어요.",
                    style = Typography.HeadLine.copy(
                        color = Color(0x40000000),
                        fontSize = 16.sp,
                    ),
                )
            }
        }
    }
}
