package com.example.consultacep.infrastructure.event.util

object Global {
    enum class URLs constructor(val url: String){
        URL_BASE("https://viacep.com.br/ws/")
    }

    @JvmStatic
    fun getUrlViaCep(): String = URLs.URL_BASE.url
}