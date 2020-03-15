package com.example.consultacep.infrastructure.event.service

import com.example.consultacep.infrastructure.model.EnderecoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepService {

    @GET("{cep}/json")
    fun getEndereco(@Path("cep") cep: String): Call<EnderecoResponse>
}