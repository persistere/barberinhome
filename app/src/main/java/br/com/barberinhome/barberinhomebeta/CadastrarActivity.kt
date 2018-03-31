package br.com.barberinhome.barberinhomebeta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastrar.*

class CadastrarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)

        btSalvarCadastro.setOnClickListener {
            val intent = Intent(this, BuscarEnderecoActivity::class.java)
            startActivity(intent)
        }
    }


}
