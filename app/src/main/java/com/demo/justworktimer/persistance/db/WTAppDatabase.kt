package com.demo.justworktimer.persistance.dao.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.demo.justworktimer.persistance.Converters
import com.demo.justworktimer.persistance.dao.SetActionDao
import com.demo.justworktimer.persistance.dao.WorkoutDao
import com.demo.justworktimer.persistance.dao.WorkoutSetDao
import com.demo.justworktimer.persistance.entity.SetAction
import com.demo.justworktimer.persistance.entity.Workout
import com.demo.justworktimer.persistance.entity.WorkoutSet

@Database(entities = [WorkoutSet::class, Workout::class, SetAction::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class WTAppDatabase : RoomDatabase() {
    abstract fun workoutSetDao(): WorkoutSetDao
    abstract fun workoutDao(): WorkoutDao
    abstract fun setActionDao(): SetActionDao

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