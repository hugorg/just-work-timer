package com.demo.justworktimer.data.dao

import androidx.room.*
import com.demo.justworktimer.data.entity.Workout

@Dao
sealed interface WorkoutDao{
    @Query("SELECT * FROM `Workout`")
    fun getAll(): List<Workout>

    @Insert
    fun insert(set: Workout)

    @Insert
    fun insertAll(vararg sets: Workout)

    @Delete
    fun delete(set: Workout)

    @Update
    fun updateTodo(vararg sets: Workout)
}