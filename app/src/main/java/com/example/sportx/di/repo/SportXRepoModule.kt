package com.example.sportx.di.repo

import com.example.sportx.data.remote.RemoteDataSourceFactory
import com.example.sportx.data.repository.SPORTXRepoImpl
import com.example.sportx.domain.use_case.SPORTXRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class SportXRepoModule {
    @Binds
    @Singleton
    abstract fun bindRepo(sportxRepoImpl: SPORTXRepoImpl) : SPORTXRepo
}

//@Module
//@InstallIn(SingletonComponent::class)
//object SportXRepoModule{
//
//    @Singleton
//    @Provides
//    fun provideSportXRepo(remoteDataSourceFactory: RemoteDataSourceFactory) : SPORTXRepo{
//            return SPORTXRepoImpl(remoteDataSourceFactory)
//    }
//}