package com.demo.justworktimer.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Action")
data class SetAction(
    @PrimaryKey(autoGenerate = true) var workoutSetId : Int,
    @ColumnInfo(name = "action") var action : String,
    @ColumnInfo(name = "duration") var duration : Int)

