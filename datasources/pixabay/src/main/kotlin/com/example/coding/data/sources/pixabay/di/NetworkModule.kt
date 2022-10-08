package com.example.coding.data.sources.pixabay.di

import com.example.coding.data.sources.pixabay.BuildConfig
import com.example.coding.data.sources.pixabay.Constants
import com.example.coding.data.sources.pixabay.sources.remote.service.PixabayApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
object NetworkModule {
    private const val TIMEOUT = 20

    @JvmStatic
    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        gson: Gson,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideOkHttpClient(
        builder: OkHttpClient.Builder
    ): OkHttpClient {
        builder.apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }

            writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
        }

        return builder.build()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideOkhttpBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }

    @JvmStatic
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): PixabayApiService = retrofit.create(
        PixabayApiService::class.java
    )


    @JvmStatic
    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()
}