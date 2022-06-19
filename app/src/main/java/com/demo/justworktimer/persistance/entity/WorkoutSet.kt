package com.demo.justworktimer.persistance.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Set")
data class WorkoutSet(
    @PrimaryKey(autoGenerate = true) var setId : Int = 0,
    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "actions") var actions : List<SetAction>,
    @ColumnInfo(name = "rounds") var rounds : Int
)

