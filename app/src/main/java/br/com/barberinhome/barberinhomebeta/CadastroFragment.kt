package br.com.barberinhome.barberinhomebeta

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.intro_cadastro.*

/**
 * Created by joseotavio on 24/03/2018.
 */
class CadastroFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.intro_cadastro, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btCadastreSe.setOnClickListener {
            btCadastrar()
        }

    }


    fun btCadastrar() {
        val intent = Intent(context, CadastrarActivity::class.java)
        startActivity(intent)
    }
}