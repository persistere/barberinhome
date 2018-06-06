package br.com.barberinhome.barberinhomebeta

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.activity_lista_barbeiros.*
import okhttp3.*
import java.io.IOException


class ListaBarbeirosActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_lista_barbeiros)

        navigationlista.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        recyclerBarbeiros.layoutManager = LinearLayoutManager(this)

        fetchJson()

    }

    fun fetchJson() {
        val url = "http://barberinhome.com.br/app/rest/wsBarbers"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                //println(body)

                val gson = GsonBuilder().create()

                val homefeed = gson.fromJson(body, Homefeed::class.java)

                runOnUiThread {
                    recyclerBarbeiros.adapter = BarbeirosAdapter(homefeed)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                Toast.makeText(this@ListaBarbeirosActivity, "Você está off-line", Toast.LENGTH_LONG).show()
            }
        })
    }
}


class Homefeed(val barbers: List<Barbers>)
class Barbers(val id_barber: Int, val nome_barber: String, val img: String)

