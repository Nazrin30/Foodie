package com.example.graduationproject.di

import android.content.Context
import androidx.room.Room
import com.example.graduationproject.data.datasource.FoodsDatasource
import com.example.graduationproject.data.datasource.UsersDatasource
import com.example.graduationproject.data.repository.FoodsRepository
import com.example.graduationproject.retrofit.ApiUtils
import com.example.graduationproject.retrofit.FoodsDao
import com.example.graduationproject.room.MyDatabase
import com.example.graduationproject.room.UsersDao
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
    fun provideFoodsRepository ( foodsDatasource: FoodsDatasource, usersDatasource: UsersDatasource) : FoodsRepository{
        return FoodsRepository(foodsDatasource, usersDatasource)
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

    @Provides
    @Singleton
    fun provideUsersDataSource(usersDao: UsersDao) : UsersDatasource{
        return UsersDatasource(usersDao)
    }

    @Provides
    @Singleton
    fun provideUsersDao(@ApplicationContext context: Context) : UsersDao{
       val db = Room.databaseBuilder(context, MyDatabase::class.java, "foodie.sqlite")
           .createFromAsset("foodie.sqlite").build()
        return db.getUsersDao()
    }
}