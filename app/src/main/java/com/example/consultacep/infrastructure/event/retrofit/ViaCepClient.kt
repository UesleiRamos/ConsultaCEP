package com.example.consultacep.infrastructure.event.retrofit

import com.example.consultacep.infrastructure.event.service.ViaCepService
import com.example.consultacep.infrastructure.event.util.Global
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ViaCepClient {
    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Global.getUrlViaCep())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service = initRetrofit().create(ViaCepService::class.java)

}