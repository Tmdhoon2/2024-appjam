package com.seunghoon.generator.feature.ranking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.seunghoon.designsystem.ui.theme.Typography
import com.seunghoon.generator.R
import com.seunghoon.generator.component.Header

val names = listOf("길근우", "이정호")
val scores = listOf(517, 332)

@Composable
internal fun RankingScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF7F7))

    ) {
        Header(title = "랭킹")
        Spacer(modifier = Modifier.height(18.dp))
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(horizontal = 20.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(10.dp),
                )
                .padding(
                    horizontal = 12.dp,
                    vertical = 12.dp,
                ),
        ) {
            Column {
                Text(
                    text = "6월 도파민 랭킹",
                    style = Typography.HeadLine.copy(
                        fontSize = 16.sp,

                        ),
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "도파민 랭킹을 높여보세요!",
                    style = Typography.HeadLine.copy(
                        fontSize = 12.sp,
                    ),
                )
            }
            Image(
                modifier = Modifier.padding(horizontal = 30.dp),
                painter = painterResource(id = R.drawable.ic_6),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(28.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                repeat(2) {
                    Rank(
                        id = it + 3,
                        name = names[it],
                        score = scores[it].toString(),
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.ic7),
                    contentDescription = null,
                )
                Rank(
                    id = 8,
                    name = "테스트",
                    score = "212",
                )
            }
        }
    }
}

@Composable
fun Rank(
    id: Int,
    name: String,
    score: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
            .background(Color.White)
            .border(width = 1.dp, color = Color(0xFFD9D9D9), shape = RoundedCornerShape(10.dp))
            .padding(
                horizontal = 12.dp,
                vertical = 10.dp,
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = "${id}등")
        Text(text = name)
        Text(text = "${score}점")
    }
}

@Composable
internal fun Header2(
    onClick: () -> Unit,
    title: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 4.dp)
            .background(color = Color.White)
            .padding(vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(modifier = Modifier.width(18.dp))
        Icon(
            modifier = Modifier.clickable(
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
            ),
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
            tint = Color(0xFFADADAD),
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = title,
            style = Typography.Medium.copy(
                fontSize = 16.sp,
                color = Color(0xFFADADAD),
            )
        )
    }
}
