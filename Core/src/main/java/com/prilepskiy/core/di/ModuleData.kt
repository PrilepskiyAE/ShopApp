package com.prilepskiy.core.di

import android.app.Application
import androidx.room.Room
import com.prilepskiy.core.data.apiService.CategoryApiService
import com.prilepskiy.core.data.apiService.ProductApiService
import com.prilepskiy.core.data.databaseService.database.MainDatabase
import com.prilepskiy.core.data.repository.CategoryRepositoryImpl
import com.prilepskiy.core.data.repository.ProductRepositoryImpl
import com.prilepskiy.core.domain.repository.CategoryRepository
import com.prilepskiy.core.domain.repository.ProductRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    fun retrofitService(api_url: String): Retrofit {

        return Retrofit.Builder()
            .baseUrl(api_url)
            .addConverterFactory(GsonConverterFactory.create())
            .apply {
                client(
                    OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        })
                        .readTimeout(1, TimeUnit.MINUTES)
                        .connectTimeout(1, TimeUnit.MINUTES)
                        .writeTimeout(1, TimeUnit.MINUTES)
                        .build()
                )
            }
            .build()
    }
    single<ProductApiService> { retrofitService("www.themealdb.com/api/json/v1/1/").create(ProductApiService::class.java) }
    single<CategoryApiService> { retrofitService("www.themealdb.com/api/json/v1/1/").create(CategoryApiService::class.java) }
}
val repositoryModule = module {
    single<CategoryRepository> { CategoryRepositoryImpl(get(), get()) }
    single<ProductRepository> { ProductRepositoryImpl(get(), get()) }
}
val databaseModule = module {
    fun provideMainDataBase(application: Application): MainDatabase {
        return Room.databaseBuilder(
            application,
            MainDatabase::class.java,
            "MainDB"
        ).allowMainThreadQueries()
            .build()
    }



    single { provideMainDataBase(androidApplication()) }
    //single { get<MainDatabase>().categoryDao }
}