package com.example.androidasignment2.models.remote

import com.example.androidasignment2.*
import com.example.androidasignment2.models.SingsList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SingsService {
    @GET(END_POINT)
    fun getSings(
        @Query(PARAM_TERM) term:String,
        @Query(PARAM_MEDIA) media:String,
        @Query(PARAM_ENTITY) entity:String,
        @Query(PARAM_LIMIT) limit:String
    ): Call<SingsList>

    companion object{
        fun initRetrofit():SingsService{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SingsService::class.java)
        }

    }

}