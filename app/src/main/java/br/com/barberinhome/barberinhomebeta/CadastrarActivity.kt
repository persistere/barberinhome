package br.com.barberinhome.barberinhomebeta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.barberinhome.barberinhomebeta.Model.AddUser
import br.com.barberinhome.barberinhomebeta.util.CallRetrofitUser
import kotlinx.android.synthetic.main.activity_cadastrar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CadastrarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)

        val context = this

        btSalvarCadastroCad.setOnClickListener ({

            if(!etNomeCad.text.toString().isEmpty() ){

                if(!etEmailCad.text.toString().isEmpty()){

                    if(!etSenhaCad.text.toString().isEmpty() ){

                        if(!etCelularCad.text.isEmpty() ){

                            val retrofit = Retrofit.Builder()
                                    .baseUrl("http://barberinhome.com.br/")
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build()


                                    retrofit.create(CallRetrofitUser::class.java)
                                    .getAddUser(etNomeCad.text.toString(),
                                            etEmailCad.text.toString(),
                                            etSenhaCad.text.toString(),
                                            etCelularCad.text.toString(),
                                            sucesso = "")
                                    .enqueue(object : Callback<AddUser> {

                                        override fun onResponse(call: Call<AddUser>?, response: Response<AddUser>?) {
                                            val sucesso = response?.body()?.sucesso

                                            var user = AddUserdbLocal(etNomeCad.text.toString(),
                                                    etEmailCad.text.toString(),
                                                    etSenhaCad.text.toString(),
                                                    etCelularCad.text.toString())
                                            var db = DataBaseHandler(context)
                                            db.addUserData(user)

                                            println(sucesso)

                                            if(sucesso == 1 ){
                                                listarBabeiros()
                                            }else{
                                                Toast.makeText(this@CadastrarActivity, "Erro de Cadastro", Toast.LENGTH_LONG).show()
                                            }
                                        }

                                        override fun onFailure(call: Call<AddUser>?, t: Throwable?) {
                                            Toast.makeText(this@CadastrarActivity, "Usuário já Cadastrado", Toast.LENGTH_LONG).show()
                                            println(t)
                                        }

                                    })

                        }else{
                            Toast.makeText(this@CadastrarActivity, "Insira o celular", Toast.LENGTH_LONG).show()
                        }

                    }else{
                        Toast.makeText(this@CadastrarActivity, "Insira a Senha", Toast.LENGTH_LONG).show()
                    }

                }else{
                    Toast.makeText(this@CadastrarActivity, "Insira o E-mail", Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(this@CadastrarActivity, "Insira o nome", Toast.LENGTH_LONG).show()
            }


        })
    }



    fun listarBabeiros() {
        val intent = Intent(this, ListaBarbeirosActivity::class.java)
        startActivity(intent)

    }

}
