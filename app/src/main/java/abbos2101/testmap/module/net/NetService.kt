package com.example.module.data.net

import abbos2101.zadacha01.module.net.model.CompanyListNet
import retrofit2.Response
import retrofit2.http.GET

interface NetService {
    @GET("api/v1/company/list")
    suspend fun getCompanyListModel(): Response<CompanyListNet>
}