package com.example.consultacep.ui.base.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.consultacep.R
import androidx.appcompat.app.AppCompatActivity
import com.example.consultacep.ui.base.viewmodel.BuscarCepViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class BuscarCepActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        card_view.visibility = View.GONE
        btn_nova_consulta.visibility = View.GONE
        init()
    }

    private fun init() {
        btn_buscar.setOnClickListener { btnBuscarCep() }
        btn_nova_consulta.setOnClickListener { btnNovaCcnsulta() }
    }

    private fun btnBuscarCep() {

        val viewModel = ViewModelProviders.of(this).get(BuscarCepViewModel::class.java)

        if (validarCampos()) {
            viewModel.buscarEndereco(txt_cep.text.toString())
            viewModel.buscarCepLiveData.observe(this, Observer {
                it?.let { endereco ->
                    txt_logradouro.text = endereco.logradouro
                    txt_complemento.text = endereco.complemento
                    txt_bairro.text = endereco.bairro
                    txt_localidade.text = endereco.localidade
                    txt_uf.text = endereco.uf
                    card_view.visibility = View.VISIBLE
                    btn_nova_consulta.visibility = View.VISIBLE
                }
            })
        }
    }

    fun btnNovaCcnsulta() {
        card_view.visibility = View.GONE
        txt_cep.text!!.clear()
        btn_nova_consulta.visibility = View.VISIBLE
        limparCampos()
    }

    fun limparCampos() {
        txt_cep.text!!.clear()
    }

    fun validarCampos(): Boolean {
        if (txt_cep.text!!.isEmpty() || txt_cep.text.toString().length < 8) {
            Snackbar.make(contrait, getString(R.string.cep_invalid), Snackbar.LENGTH_LONG).show()
            return false
        } else {
            return true
        }
    }
}
