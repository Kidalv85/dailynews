package com.kryvovyaz.dailynews.di

import android.app.Application
import androidx.room.Room
import com.kryvovyaz.dailynews.data.local.NewsDao
import com.kryvovyaz.dailynews.data.local.NewsDatabase
import com.kryvovyaz.dailynews.data.local.NewsTypeConvertor
import com.kryvovyaz.dailynews.data.manager.LocalUserManagerImpl
import com.kryvovyaz.dailynews.data.remote.NewsApi
import com.kryvovyaz.dailynews.domain.manager.LocalUserManager
import com.kryvovyaz.dailynews.domain.repository.NewsRepository
import com.kryvovyaz.dailynews.domain.usecases.app_entry.ReadAppEntry
import com.kryvovyaz.dailynews.domain.usecases.app_entry.SaveAppEntry
import com.kryvovyaz.dailynews.domain.usecases.news.GetNews
import com.kryvovyaz.dailynews.data.repository.NewsRepositoryImpl
import com.kryvovyaz.dailynews.domain.usecases.news.DeleteArticle
import com.kryvovyaz.dailynews.domain.usecases.news.SearchNews
import com.kryvovyaz.dailynews.domain.usecases.news.UpsertArticle
import com.kryvovyaz.dailynews.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = "news_db"
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao

}