package com.seunghoon.generator.feature.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.room.Room
import androidx.room.RoomDatabase
import com.seunghoon.generator.DopaDatabase
import com.seunghoon.generator.R
import com.seunghoon.generator.component.Header

lateinit var db: RoomDatabase

@Composable
internal fun FeedScreen() {
    val context = LocalContext.current
    db = Room.databaseBuilder(
        context,
        DopaDatabase::class.java,
        "dopa-database",
    ).build()


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
        }
    }
}
