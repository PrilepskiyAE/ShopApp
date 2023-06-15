package com.prilepskiy.core.data.apiService

import com.prilepskiy.core.data.apiService.response.productResponse.ProductInfoResponse
import com.prilepskiy.core.data.apiService.response.productResponse.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApiService {
    @GET(PRODUCT_INFO_BY_ID_URL)
    suspend fun  getProductInfoByID( @Query("i")id: String): Response<ProductInfoResponse>
    @GET(PRODUCT_INFO_BY_CATEGORY_URL)
    suspend fun  getProductInfoByCategory(@Query("c")categoryName: String): Response<ProductResponse>
}