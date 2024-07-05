package com.example.exam.di

import android.content.Context
import androidx.room.Room
import com.example.exam.api.ProcessService
import com.example.exam.constants.Constants
import com.example.exam.db.AppDatabase
import com.example.exam.db.MetalDao
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

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "database_prepare_sqlite"
        )
        .createFromAsset("database.sqlite")
        .build()
    }

    @Provides
    fun provideMetalDao(appDatabase: AppDatabase): MetalDao {
        return appDatabase.metalDao()
    }

    @Singleton
    @Provides
    fun provideRetrofit(@ApplicationContext appContext: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesService(retrofit: Retrofit): ProcessService = retrofit.create(ProcessService::class.java)

    @Provides
    fun provideProcessRepository(remoteDataSource: ProcessService, localDataSource: MetalDao) = ProcessRepository(remoteDataSource, localDataSource)
}