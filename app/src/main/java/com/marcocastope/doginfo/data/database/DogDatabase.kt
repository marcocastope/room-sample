package com.marcocastope.doginfo.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marcocastope.doginfo.data.dao.DogDao
import com.marcocastope.doginfo.data.model.Dog

@Database(entities = [(Dog::class)], version = 1)
abstract class DogDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "DogDatabase"

        fun buildDatabase(context: Context): DogDatabase {
            return Room.databaseBuilder(
                context,
                DogDatabase::class.java,
                DATABASE_NAME
            ).allowMainThreadQueries()
                .build()
        }
    }

    abstract fun dogDao(): DogDao
}