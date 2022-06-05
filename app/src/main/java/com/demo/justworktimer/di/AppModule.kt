package com.demo.justworktimer.di

import android.content.Context
import androidx.room.Room
import com.demo.justworktimer.data.dao.db.WTAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRoomInstance(@ApplicationContext context: Context) = WTAppDatabase.getAppDB(context)

    @Singleton
    @Provides
    fun provideWorkoutSetDao(db: WTAppDatabase) = db.workoutSetDao()

    @Singleton
    @Provides
    fun provideWorkoutDao(db: WTAppDatabase) = db.workoutDao()

    @Singleton
    @Provides
    fun provideSetActionDao(db: WTAppDatabase) = db.setActionDao()
}