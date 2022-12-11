package com.example.graduationproject.di

import android.content.Context
import androidx.room.Room
import com.example.graduationproject.data.datasource.FoodsDatasource

import com.example.graduationproject.data.repository.FoodsRepository
import com.example.graduationproject.retrofit.ApiUtils
import com.example.graduationproject.retrofit.FoodsDao


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.http.FormUrlEncoded
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFoodsRepository ( foodsDatasource: FoodsDatasource) : FoodsRepository{
        return FoodsRepository(foodsDatasource)
    }

    @Provides
    @Singleton
    fun provideFoodsDatasource ( foodsDao: FoodsDao): FoodsDatasource{
        return FoodsDatasource(foodsDao)
    }

    @Provides
    @Singleton
    fun provideFoodsDao () : FoodsDao{
        return ApiUtils.getFoodsDao()
    }


}