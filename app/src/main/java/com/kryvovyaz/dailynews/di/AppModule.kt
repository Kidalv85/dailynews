package com.kryvovyaz.dailynews.di

import android.app.Application
import com.kryvovyaz.dailynews.data.manager.LocalUserManagerImpl
import com.kryvovyaz.dailynews.data.remote.NewsApi
import com.kryvovyaz.dailynews.domain.manager.LocalUserManager
import com.kryvovyaz.dailynews.domain.repository.NewsRepository
import com.kryvovyaz.dailynews.domain.usecases.app_entry.AppEntryUseCases
import com.kryvovyaz.dailynews.domain.usecases.app_entry.ReadAppEntry
import com.kryvovyaz.dailynews.domain.usecases.app_entry.SaveAppEntry
import com.kryvovyaz.dailynews.domain.usecases.news.GetNews
import com.kryvovyaz.dailynews.domain.usecases.news.NewsUseCases
import com.kryvovyaz.dailynews.data.repository.NewsRepositoryImpl
import com.kryvovyaz.dailynews.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }

}