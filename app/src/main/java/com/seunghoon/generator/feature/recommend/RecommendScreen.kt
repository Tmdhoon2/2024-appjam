package com.seunghoon.generator.feature.recommend

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import androidx.room.Room
import com.seunghoon.designsystem.ui.theme.Typography
import com.seunghoon.generator.DopaDatabase
import com.seunghoon.generator.Feed
import com.seunghoon.generator.component.Header
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.util.UUID

lateinit var db: DopaDatabase

val titles = listOf(
    "책 읽기",
    "노래 감상하기",
    "산책하기",
    "운동하기",
    "자전거 타기",
)

val already = listOf(
    "청소하기",
    "일기쓰기",
    "독서하기",
    "스마트폰 사용 줄이기",
    "게임 줄이기"
)

@Composable
internal fun RecommendScreen(navController: NavController) {
    val context = LocalContext.current
    db = Room.databaseBuilder(
        context,
        DopaDatabase::class.java,
        "dopa-database",
    ).build()
    val dao = db.getFeedDao()
    var title = ""
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val cameraLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicture()) { result ->
            if (result) {
                CoroutineScope(Dispatchers.IO).launch {
                    imageUri?.run {
                        dao.saveFeed(
                            Feed(
                                title = title,
                                uri = this.toString(),
                            )
                        )
                    }
                }
            }
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF7F7)),
    ) {
        Header(title = "추천 활동")
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "추천 도파민 습관",
                        style = Typography.HeadLine.copy(
                            fontSize = 16.sp,

                            ),
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "오늘의 도파민 점수를 위해 달려보세요",
                        style = Typography.HeadLine.copy(
                            fontSize = 12.sp,
                        ),
                    )
                }
                Text(
                    text = "${titles.size}개",
                    style = Typography.HeadLine.copy(
                        fontSize = 12.sp,
                    ),
                )
            }
            Spacer(modifier = Modifier.height(28.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                repeat(5) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp)
                            .background(Color.White)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFD9D9D9),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(
                                horizontal = 12.dp,
                                vertical = 10.dp,
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = titles[it])
                        Text(
                            modifier = Modifier.clickable(
                                onClick = {
                                    title = titles[it]
                                    val imageFile =
                                        File(context.cacheDir, "image${UUID.randomUUID()}.png")
                                    imageUri = FileProvider.getUriForFile(
                                        context,
                                        "${context.packageName}.fileProvider",
                                        imageFile,
                                    )
                                    cameraLauncher.launch(imageUri)
                                },
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                            ),
                            text = "인증하기 >",
                            color = Color(0xFF1E27FF),
                            fontSize = 10.sp,
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "완료한 도파민 습관",
                        style = Typography.HeadLine.copy(
                            fontSize = 16.sp,

                            ),
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "완료한 도파민 습관을 확인해보세요!",
                        style = Typography.HeadLine.copy(
                            fontSize = 12.sp,
                        ),
                    )
                }
                Text(
                    text = "${titles.size}개",
                    style = Typography.HeadLine.copy(
                        fontSize = 12.sp,
                    ),
                )
            }
            Spacer(modifier = Modifier.height(28.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                repeat(5) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp)
                            .background(Color.White)
                            .border(
                                width = 1.dp,
                                color = Color(0xFFD9D9D9),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(
                                horizontal = 12.dp,
                                vertical = 10.dp,
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(text = already[it])
                        Text(
                            modifier = Modifier.clickable(
                                onClick = {
                                    title = already[it]
                                    val imageFile = File(context.cacheDir, "image.png")
                                    imageUri = FileProvider.getUriForFile(
                                        context,
                                        "${context.packageName}.fileProvider",
                                        imageFile,
                                    )
                                    cameraLauncher.launch(imageUri)
                                },
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                            ),
                            text = "인증하기 >",
                            color = Color(0xFF1E27FF),
                            fontSize = 10.sp,
                        )
                    }
                }
            }
        }
    }
}
