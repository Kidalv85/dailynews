package com.kryvovyaz.dailynews.di

import android.app.Application
import com.kryvovyaz.dailynews.data.manager.LocalUserManagerImpl
import com.kryvovyaz.dailynews.domain.manager.LocalUserManager
import com.kryvovyaz.dailynews.domain.usecases.AppEntryUseCases
import com.kryvovyaz.dailynews.domain.usecases.ReadAppEntry
import com.kryvovyaz.dailynews.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}