package com.prilepskiy.core.data.apiService

import retrofit2.Response
import retrofit2.http.GET

interface ProductApiService {
    @GET(PRODUCT_INFO_BY_ID_URL)
    suspend fun  getProductInfoByID(): Response<String>
    @GET(PRODUCT_INFO_BY_CATEGORY_URL)
    suspend fun  getProductInfoByCategory(): Response<String>
}