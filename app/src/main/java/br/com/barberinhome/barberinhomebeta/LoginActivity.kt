package br.com.barberinhome.barberinhomebeta

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.barberinhome.barberinhomebeta.Model.User
import br.com.barberinhome.barberinhomebeta.util.CallRetrofit
import br.com.barberinhome.barberinhomebeta.util.MRetrofit
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btSalvarCadastro.setOnClickListener({
//            val retrofit = MRetrofit().getRetofit()
//            val user = CallRetrofit().getUser(etEmail.text.toString(), etSenha.text.toString())

            val retrofit = Retrofit.Builder()
                    .baseUrl("http://barberinhome.com.br/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            val api = retrofit.create(CallRetrofit::class.java)
            api.getUser(etEmail.text.toString(), etSenha.text.toString())
                    .enqueue(object : Callback<User> {

                        override fun onResponse(call: Call<User>?, response: Response<User>?) {
                            val nome = response?.body()?.nome_barber

                            print(nome)

                            Toast.makeText(applicationContext, nome, Toast.LENGTH_SHORT).show()


                        }

                        override fun onFailure(call: Call<User>?, t: Throwable?) {
                            Toast.makeText(this@LoginActivity, t?.message, Toast.LENGTH_SHORT).show()
                        }

                    })


        })
    }
}
