package com.seunghoon.generator

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase

@Database(entities = [Feed::class], version = 1)
abstract class DopaDatabase : RoomDatabase() {
    abstract fun getFeedDao(): FeedDao
}

@Dao
interface FeedDao {
    @Query("SELECT * FROM feed")
    fun getAll(): List<Feed>

    @Insert
    fun saveFeed(feed: Feed)
}
