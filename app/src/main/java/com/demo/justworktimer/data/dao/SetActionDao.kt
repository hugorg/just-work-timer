package com.demo.justworktimer.data.dao

import androidx.room.*
import com.demo.justworktimer.data.entity.SetAction
import com.demo.justworktimer.data.entity.Workout

interface SetActionDao {
    @Dao
    sealed interface WorkoutDao{
        @Query("SELECT * FROM `Action`")
        fun getAll(): List<SetAction>

        @Insert
        fun insert(set: SetAction)

        @Insert
        fun insertAll(vararg sets: SetAction)

        @Delete
        fun delete(set: SetAction)

        @Update
        fun updateTodo(vararg sets: SetAction)
    }
}