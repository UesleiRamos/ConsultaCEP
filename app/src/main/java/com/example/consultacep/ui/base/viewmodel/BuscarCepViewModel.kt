package com.example.consultacep.ui.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.consultacep.infrastructure.event.retrofit.ViaCepClient
import com.example.consultacep.infrastructure.model.Endereco
import com.example.consultacep.infrastructure.model.EnderecoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BuscarCepViewModel : ViewModel() {
    val buscarCepLiveData: MutableLiveData<Endereco> = MutableLiveData()

    fun buscarEndereco(cep: String) {
        ViaCepClient.service.getEndereco(cep).enqueue(object : Callback<EnderecoResponse> {
            override fun onResponse(
                call: Call<EnderecoResponse>,
                response: Response<EnderecoResponse>
            ) {
                val responseEndereco = response.body()
                if (response.isSuccessful) {
                    val endereco =
                        Endereco(
                            cep = responseEndereco?.cep,
                            logradouro = responseEndereco?.logradouro,
                            complemento = responseEndereco?.complemento,
                            bairro = responseEndereco?.bairro,
                            localidade = responseEndereco?.localidade,
                            uf = responseEndereco?.uf
                        )
                    buscarCepLiveData.value = endereco
                }
            }

            override fun onFailure(call: Call<EnderecoResponse>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}