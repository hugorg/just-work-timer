package com.demo.justworktimer.persistance.dao

import androidx.room.*
import com.demo.justworktimer.persistance.entity.WorkoutSet

@Dao
sealed interface WorkoutSetDao{
    @Query("SELECT * FROM `Set`")
    fun getAll(): List<WorkoutSet>

    @Insert
    fun insert(set: WorkoutSet)

    @Insert
    fun insertAll(vararg sets: WorkoutSet)

    @Delete
    fun delete(set: WorkoutSet)

    @Update
    fun updateTodo(vararg sets: WorkoutSet)
}