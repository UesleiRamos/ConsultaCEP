package com.example.consultacep.infrastructure.model

import com.google.gson.annotations.SerializedName

class EnderecoResponse constructor(
    var cep : String,
    var logradouro : String,
    var complemento : String,
    var bairro : String,
    var localidade : String,
    var uf : String,
    var unidade : String,
    var ibge : String,
    var gia : String
)