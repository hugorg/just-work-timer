package com.demo.justworktimer.persistance.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Workout")
data class Workout(
    @PrimaryKey(autoGenerate = true) val workoutId : Int = 0,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "sets") val sets : List<WorkoutSet>)
