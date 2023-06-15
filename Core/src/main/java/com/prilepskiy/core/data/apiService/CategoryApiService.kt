package com.prilepskiy.core.data.apiService

import com.prilepskiy.core.data.apiService.response.categoryResponse.CategoriesResponse
import retrofit2.Response
import retrofit2.http.GET

interface CategoryApiService {
    @GET(CATEGORY_URL)
    suspend fun  getCategory(): Response<CategoriesResponse>
}