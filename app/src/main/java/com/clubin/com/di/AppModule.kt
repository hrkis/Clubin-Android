package com.clubin.com.di

import android.content.Context
import com.clubin.com.network.AllApi
import com.clubin.com.network.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAuthApi(
        remoteDataSource: RemoteDataSource,
        @ApplicationContext context: Context
    ): AllApi {
        return remoteDataSource.buildApi(AllApi::class.java, context)
    }


}