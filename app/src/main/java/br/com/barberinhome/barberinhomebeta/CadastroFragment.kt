package br.com.barberinhome.barberinhomebeta

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
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

    fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo


        btCadastreSe.setOnClickListener {
            if( networkInfo != null && networkInfo.isConnectedOrConnecting) {
                irCadastrar()
            } else {
                context.toast("Você Está Offline")
            }

        }

        btJatenhoConta.setOnClickListener {
            if( networkInfo != null && networkInfo.isConnectedOrConnecting) {
                irLogar()
            } else {
                context.toast("Você Está Offline")
            }

        }

    }



    fun irCadastrar() {
        val intent = Intent(context, CadastrarActivity::class.java)
        startActivity(intent)
    }

    fun irLogar() {
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
    }
}