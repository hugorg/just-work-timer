package com.demo.justworktimer.feature.set

import com.demo.justworktimer.persistance.dao.WorkoutSetDao
import com.demo.justworktimer.persistance.entity.WorkoutSet
import javax.inject.Inject

class SetRepo @Inject constructor(private val setDao : WorkoutSetDao) {

    fun insertSet(set : WorkoutSet){
        setDao.insert(set)
    }

    fun getAll(set : WorkoutSet){
        setDao.getAll()
    }

    fun insertMultiple(sets : List<WorkoutSet>){
        setDao.insertAll()
    }

    fun delete(set: WorkoutSet){
        setDao.delete(set)
    }

    fun update(vararg sets: WorkoutSet){
        setDao.updateTodo(*sets)
    }
}