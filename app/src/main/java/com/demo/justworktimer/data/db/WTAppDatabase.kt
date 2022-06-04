package com.demo.justworktimer.data.dao.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.demo.justworktimer.data.Converters
import com.demo.justworktimer.data.dao.WorkoutDao
import com.demo.justworktimer.data.dao.WorkoutSetDao
import com.demo.justworktimer.data.entity.Workout
import com.demo.justworktimer.data.entity.WorkoutSet

@Database(entities = [WorkoutSet::class, Workout::class], version = 1)
@TypeConverters(Converters::class)
abstract class WTAppDatabase : RoomDatabase() {
    abstract fun workoutSetDao(): WorkoutSetDao
    abstract fun workoutDao(): WorkoutDao

    companion object{
        private var appDB : WTAppDatabase? = null

        fun getAppDB(context: Context) : WTAppDatabase {
            if (appDB == null) {
                    appDB.apply{
                        appDB = Room.databaseBuilder(context, WTAppDatabase::class.java, "workoutTimerDBy")
                            .allowMainThreadQueries()
                            .build()
                        return appDB!!
                    }
            }
            else
                return appDB!!
        }
    }
}