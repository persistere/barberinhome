package br.com.barberinhome.barberinhomebeta

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_lista_barbeiros.*
import okhttp3.*
import java.io.IOException


class ListaBarbeirosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_barbeiros)

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
                println(body)

                val gson = GsonBuilder().create()

                val homefeed = gson.fromJson(body, Homefeed::class.java)

                runOnUiThread {
                    recyclerBarbeiros.adapter = BarbeirosAdapter(homefeed)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("erro")
            }
        })
    }
}


class Homefeed(val barbers: List<Barbers>)
class Barbers(val id_barber: Int, val nome_barber: String, val img: String)

