package com.erykhf.android.harrypotterquiz.di

import com.erykhf.android.Repository
import com.erykhf.android.harrypotterquiz.HarryPotterApi
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

    @Singleton
    @Provides
    fun getAllHPCharacters() : HarryPotterApi {
        return Retrofit.Builder()
            .baseUrl("https://fedeperin-harry-potter-api-en.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HarryPotterApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(api: HarryPotterApi) = Repository(api)


}