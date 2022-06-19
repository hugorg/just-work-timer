package com.demo.justworktimer.di

import com.demo.justworktimer.persistance.dao.WorkoutSetDao
import com.demo.justworktimer.feature.set.SetRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object RepoModule {

    @Provides
    fun provideSetRepo(workoutSetDao: WorkoutSetDao) : SetRepo {
        return SetRepo(workoutSetDao)
    }
}