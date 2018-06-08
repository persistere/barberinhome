package br.com.barberinhome.barberinhomebeta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.widget.EditText
import android.widget.Toast
import br.com.barberinhome.barberinhomebeta.Model.EditUser
import br.com.barberinhome.barberinhomebeta.util.CallRetrofitEditUser
import kotlinx.android.synthetic.main.activity_cadastro_user.*
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CadastroUserActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val intent = Intent(this, ListaBarbeirosActivity::class.java)
                this.startActivity(intent)
            }
            R.id.navigation_dashboard -> {
                val intent = Intent(this, CadastroUserActivity::class.java)
                this.startActivity(intent)
            }
            R.id.navigation_notifications -> {
                val intent = Intent(this, SobreActivity::class.java)
                this.startActivity(intent)

            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_user)

        navigationlista.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val context = this

        var db = DataBaseHandler(context)
        var data = db.readUserData()


        val nome = findViewById<EditText>(R.id.etNomeCad)
        nome.setText(data.get(0).nome)

        val celular = findViewById<EditText>(R.id.etCelularCad)
        celular.setText(data.get(0).celular)


        btSalvarCad.setOnClickListener ({
            if(!etNomeCad.text.toString().isEmpty()){
                if(!etCelularCad.text.toString().isEmpty()){

                    val retrofit = Retrofit.Builder()
                            .baseUrl("http://barberinhome.com.br/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()

                    retrofit.create(CallRetrofitEditUser::class.java)
                            .getEditUser(1,
                                    etNomeCad.text.toString(),
                                    etCelularCad.text.toString(),
                                    0)
                            .enqueue(object : Callback<EditUser> {


                                override fun onResponse(call: Call<EditUser>?, response: Response<EditUser>?) {
                                    val sucesso = response?.body()?.sucesso

                                    if( sucesso == 1 ) {

                                        db.updateUserData(etNomeCad.text.toString(), etCelularCad.text.toString())

                                        Toast.makeText(this@CadastroUserActivity, "Alteração realizada com sucesso!", Toast.LENGTH_SHORT).show()
                                    } else {
                                        btSalvarCadastro.isEnabled=true
                                        Toast.makeText(this@CadastroUserActivity, "Erro de login e senha", Toast.LENGTH_LONG).show()
                                    }
                                }

                                override fun onFailure(call: Call<EditUser>?, t: Throwable?) {
                                    erro()
                                }
                            })

                }else{
                    Toast.makeText(this@CadastroUserActivity, "Preencha o Celular", Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(this@CadastroUserActivity, "Preencha o nome", Toast.LENGTH_LONG).show()
            }

        })


        btSair.setOnClickListener ({
            db.deleteUser()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        })
    }

    fun erro() {
        Toast.makeText(this@CadastroUserActivity, "Você está off line", Toast.LENGTH_LONG).show()
        val intent = Intent(this, CadastroFragment::class.java)
        startActivity(intent)
    }
}




