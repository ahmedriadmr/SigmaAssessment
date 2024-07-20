package com.example.sigmaassessment.core.di

import com.example.sigmaassessment.profile_details.data.ProfileRepository
import com.example.sigmaassessment.profile_details.data.ProfileRepositoryRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideProfileRepository(repository: ProfileRepositoryRemote): ProfileRepository = repository
}
