package com.demo.justworktimer.di

import android.content.Context
import com.demo.justworktimer.data.dao.db.WTAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDb(context: Context) : WTAppDatabase{
        return WTAppDatabase.getAppDB(context = context)
    }
}