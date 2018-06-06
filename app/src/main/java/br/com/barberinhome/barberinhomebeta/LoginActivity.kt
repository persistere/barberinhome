package br.com.barberinhome.barberinhomebeta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.barberinhome.barberinhomebeta.Model.User
import br.com.barberinhome.barberinhomebeta.util.CallRetrofit
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LoginActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btSalvarCadastro.setOnClickListener({

            if(!etEmail.text.toString().isEmpty()){

                if(!etSenha.text.toString().isEmpty()){

                    btSalvarCadastro.isEnabled=false


                    val retrofit = Retrofit.Builder().baseUrl("http://barberinhome.com.br/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()

                    retrofit.create(CallRetrofit::class.java)
                            .getUser(etEmail.text.toString(), etSenha.text.toString())
                            .enqueue(object : Callback<List<User>> {

                            override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?) {
                                val login = response?.body()?.get(0)?.nome_barber

                                if(login != null){
                                    listarBabeiros()
                                }else{
                                    btSalvarCadastro.isEnabled=true
                                    Toast.makeText(this@LoginActivity, "Erro de login e senha", Toast.LENGTH_LONG).show()
                                }
                            }

                            override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
                                Toast.makeText(this@LoginActivity, "Você está off-line", Toast.LENGTH_LONG).show()
                            }
                    })

                }else{
                    Toast.makeText(this@LoginActivity, "Preencha a Senha", Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(this@LoginActivity, "Preencha o E-mail", Toast.LENGTH_LONG).show()
            }

        })
    }


    fun listarBabeiros() {
        val intent = Intent(this, ListaBarbeirosActivity::class.java)
        startActivity(intent)
    }
}
