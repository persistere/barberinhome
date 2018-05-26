package br.com.barberinhome.barberinhomebeta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_buscar_endereco.*

class BuscarEnderecoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_endereco)

        btConfirmarEndereco.setOnClickListener {
            listarBabeiros()
        }

    }

    fun listarBabeiros() {
        val intent = Intent(this, ListaBarbeirosActivity::class.java)
        startActivity(intent)
    }

}
