package com.example.news_viewer_compose_navigation_clean.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.api.NewsApi
import com.example.data.database.NewsResponseDao
import com.example.data.database.NewsResponseDatabase
import com.example.data.mappers.ResultMapper
import com.example.domain.repository.NewsResponseRepository
import com.example.domain.useCase.GetNewsResponseUseCase
import com.example.news_viewer_compose_navigation_clean.BuildConfig.DEBUG
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val NAME = "news"

    @Provides
    @Singleton
    fun provideDatabase(application: Application): NewsResponseDatabase {
        return Room.databaseBuilder(
            application,
            NewsResponseDatabase::class.java, NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(database: NewsResponseDatabase): NewsResponseDao {
        return database.newsResponseDao
    }
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val connectTimeout: Long = 40// 20s
    private const val readTimeout: Long = 40 // 20s
    private const val BASE_URL = "https://content.guardianapis.com/sections/"


    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS)
        if (DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
        }
        okHttpClientBuilder.build()
        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }


}

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Provides
    @Singleton
    fun provideMapper(): ResultMapper {
        return ResultMapper()
    }

}

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepository(
        api: NewsApi,
        mapper: ResultMapper,
        dao: NewsResponseDao
    ): NewsResponseRepository {
        return com.example.data.NewsResponseRepositoryImpl(api, mapper, dao)
    }

}

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideUseCase(newsResponseRepository: NewsResponseRepository): GetNewsResponseUseCase {
        return GetNewsResponseUseCase(newsResponseRepository)
    }
}

