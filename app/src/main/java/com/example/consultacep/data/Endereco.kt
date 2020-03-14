package com.example.consultacep.data

import java.io.Serializable

class Endereco : Serializable {
    constructor(
        cep: String?,
        logradouro: String?,
        complemento: String?,
        bairro: String?,
        localidade: String?,
        uf: String?
    ) {
        this.cep = cep
        this.logradouro = logradouro
        this.complemento = complemento
        this.bairro = bairro
        this.localidade = localidade
        this.uf = uf
    }

    var cep: String?
    var logradouro: String?
    var complemento: String?
    var bairro: String?
    var localidade: String?
    var uf: String?
}

