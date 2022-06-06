package com.demo.justworktimer.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.demo.justworktimer.data.entity.SetAction

@Entity(tableName = "Set")
data class WorkoutSet(
    @PrimaryKey(autoGenerate = true) var setId : Int,
    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "actions") var actions : List<SetAction>,
    @ColumnInfo(name = "rounds") var rounds : Int
)

