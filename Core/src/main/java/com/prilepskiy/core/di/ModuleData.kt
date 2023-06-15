package com.prilepskiy.core.di

import com.prilepskiy.core.data.apiService.CategoryApiService
import com.prilepskiy.core.data.apiService.ProductApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
}
val databaseModule = module {}