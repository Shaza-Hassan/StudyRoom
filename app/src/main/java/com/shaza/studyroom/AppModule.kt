package com.shaza.studyroom

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun databaseProvide(@ApplicationContext appContext:Context): UserDao{
        return  AppDatabase.getDatabase(appContext).userDao()
    }

    @Provides
    fun repoProvide(userDao: UserDao) = UserRepo(userDao)
}