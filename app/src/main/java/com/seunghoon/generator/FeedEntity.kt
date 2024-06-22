package com.seunghoon.generator

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Feed(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val uri: String,
)