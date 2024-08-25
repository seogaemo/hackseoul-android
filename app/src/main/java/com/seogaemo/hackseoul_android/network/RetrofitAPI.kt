package com.seogaemo.hackseoul_android.network

import com.seogaemo.hackseoul_android.data.CompanyResponse
import com.seogaemo.hackseoul_android.data.ProductResponse
import com.seogaemo.hackseoul_android.data.SignInRequest
import com.seogaemo.hackseoul_android.data.SignInResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path


interface RetrofitAPI {
    @POST("auth/signin")
    suspend fun signIn(
        @Body body: SignInRequest
    ): Response<SignInResponse>

    @GET("company/{id}")
    suspend fun getCompany(
        @Header("Authorization") authorization: String,
        @Path(value = "id") id : Int
    ): Response<CompanyResponse>

    @GET("product/{id}")
    suspend fun getProduct(
        @Header("Authorization") authorization: String,
        @Path(value = "id") id : Int
    ): Response<ProductResponse>
}