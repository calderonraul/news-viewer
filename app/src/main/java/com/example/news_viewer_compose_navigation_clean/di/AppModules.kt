package com.example.news_viewer_compose_navigation_clean.di

import android.app.Application
import androidx.room.Room
import com.example.data.api.NewsApi
import com.example.data.database.NewsResponseDao
import com.example.data.database.NewsResponseDatabase
import com.example.data.mappers.searchResponseMappers.ResultSearchMapper
import com.example.domain.repository.NewsResponseRepository
import com.example.domain.useCase.GetResponseByTitleUseCase
import com.example.domain.useCase.GetSearchResponseUseCase
import com.example.news_viewer_compose_navigation_clean.BuildConfig.DEBUG
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
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
    private const val BASE_URL = "https://content.guardianapis.com/"

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder().apply {
            addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("api-key", "177e6fac-ce7c-40ab-9944-f80b49099371")
                    return@Interceptor chain.proceed(builder.build())
                }
            )
        }
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
object SearchMapper {
    @Provides
    @Singleton
    fun provideSearchMapper(): ResultSearchMapper {
        return ResultSearchMapper()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepository(
        api: NewsApi,
        dao: NewsResponseDao,
        searchMapper: ResultSearchMapper
    ): NewsResponseRepository {
        return com.example.data.NewsResponseRepositoryImpl(
            api,
            dao,
            searchMapper
        )
    }

}

@Module
@InstallIn(SingletonComponent::class)
object UseCaseSearchModule {
    @Provides
    @Singleton
    fun provideSearchUseCase(newsResponseRepository: NewsResponseRepository): GetSearchResponseUseCase {
        return GetSearchResponseUseCase(newsResponseRepository)
    }
}

@Module
@InstallIn(SingletonComponent::class)
object UseCaseSearchByTitleModule{
    @Provides
    @Singleton
    fun provideSearchByTitleUseCase(newsResponseRepository: NewsResponseRepository):GetResponseByTitleUseCase{
        return GetResponseByTitleUseCase(newsResponseRepository)
    }
}

