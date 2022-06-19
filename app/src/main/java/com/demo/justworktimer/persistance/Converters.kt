package com.demo.justworktimer.persistance

import androidx.room.TypeConverter
import com.demo.justworktimer.persistance.entity.SetAction
import com.demo.justworktimer.persistance.entity.WorkoutSet
import com.google.gson.Gson
import java.util.*

object Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun listToJson(value: List<WorkoutSet>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<WorkoutSet>::class.java).toList()

    @TypeConverter
    fun actionListToJson(value: List<SetAction>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToActionList(value: String) = Gson().fromJson(value, Array<SetAction>::class.java).toList()
}