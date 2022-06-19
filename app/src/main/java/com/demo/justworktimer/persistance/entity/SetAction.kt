package com.demo.justworktimer.persistance.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Action")
data class SetAction(
    @PrimaryKey(autoGenerate = true) var actionId : Int = 0,
    @ColumnInfo(name = "action") var actionName : String,
    @ColumnInfo(name = "duration") var duration : Int)

