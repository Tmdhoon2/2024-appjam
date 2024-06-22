package com.seunghoon.generator.feature.feed

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import coil.compose.AsyncImage
import com.seunghoon.designsystem.ui.theme.Typography
import com.seunghoon.generator.DopaDatabase
import com.seunghoon.generator.Feed
import com.seunghoon.generator.R
import com.seunghoon.generator.component.Header
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

lateinit var db: DopaDatabase

@Composable
internal fun FeedScreen() {
    val context = LocalContext.current
    db = Room.databaseBuilder(
        context,
        DopaDatabase::class.java,
        "dopa-database",
    ).build()

    val list = remember { mutableStateListOf<Feed>() }

    LaunchedEffect(Unit) {
        launch(Dispatchers.IO) {
            runCatching {
                db.getFeedDao().getAll()
            }.onSuccess {
                list.addAll(it)
                Log.d("TEST", list.toString())
            }.onFailure {
                Log.d("TEST", it.toString())
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF7F7))
    ) {
        Header(title = "인증 커뮤니티")
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_8),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                items(list) {
                    Item(
                        uri = Uri.parse(it.uri),
                        title = it.title,
                    )
                }
            }
        }
    }
}

@Composable
private fun Item(
    uri: Uri,
    title: String,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(
                horizontal = 10.dp,
                vertical = 8.dp,
            )
    ) {
        Text(
            text = title,
            style = Typography.HeadLine.copy(
                fontSize = 12.sp,
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Log.d("TEST", uri.toString())
        AsyncImage(
            modifier = Modifier.clip(RoundedCornerShape(8.dp)),
            model = uri,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_up),
                contentDescription = null,
            )
            Text(text = "9")
            Icon(
                painter = painterResource(id = R.drawable.ic_down),
                contentDescription = null,
            )
            Text(text = "10")
        }
    }
}
