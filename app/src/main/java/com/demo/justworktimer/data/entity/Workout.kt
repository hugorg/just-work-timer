package com.demo.justworktimer.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Workout")
data class Workout(
    @PrimaryKey(autoGenerate = true) val workoutId : Int,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "sets") val sets : List<WorkoutSet>)
