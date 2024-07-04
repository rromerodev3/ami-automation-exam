package com.example.exam.di

import android.content.Context
import com.example.exam.api.ProcessService
import com.example.exam.constants.Constants
import com.example.exam.repositories.ProcessRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(@ApplicationContext appContext: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesService(retrofit: Retrofit) = retrofit.create(ProcessService::class.java)

    @Provides
    fun provideProcessRepository(remoteDataSource: ProcessService) = ProcessRepository(remoteDataSource)
}