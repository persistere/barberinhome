package br.com.barberinhome.barberinhomebeta

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalhes_barbeiro.view.*
import kotlinx.android.synthetic.main.activity_login.*
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhes_barbeiro.*
import kotlinx.android.synthetic.main.activity_sobre.*
import kotlinx.android.synthetic.main.item_list.view.*
import okhttp3.*
import java.io.IOException


class DetalhesBarbeiroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_barbeiro)

        val extras = intent.extras

        val id = extras.getString("ID_BARBER")//intent.getStringExtra(CustomViewHolder.ID_BARBER)
        val nome = extras.getString("NOME_BARBER")//intent.getStringExtra(CustomViewHolder.NOME_BARBER)
        val foto = extras.getString("FOTO_BARBER")//intent.getStringExtra(CustomViewHolder.FOTO_BARBER)


        val i = findViewById<TextView>(R.id.tfnomeBarberdt)
        i.text = nome


        val thumb = findViewById<ImageView>(R.id.ivFotoDetalhes)
        Picasso.get().load(foto).into(thumb)


        btnLigar.setOnClickListener {
            makeCall()
        }

        btnMapa.setOnClickListener {
            callMapa()
        }

        btnCompartilhar.setOnClickListener {
            shareLink()
        }

    }


    fun callMapa() {
        val intent = Intent(this, Mapa::class.java)
        startActivity(intent)
    }

    @SuppressLint("MissingPermission")
    fun makeCall() {
        val tel = "+5511948888362"
        //Fazer ligacao
        //val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel" + tel ))
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", tel, null));
        startActivity(intent)
    }

    fun shareLink() {
        //Compartilhar link
        var text = "barberinhome.com.br"
        var share = Intent(android.content.Intent.ACTION_SEND)

        share.type = "text/plan"
        share.putExtra(Intent.EXTRA_TEXT, text)

        val chosser = Intent.createChooser(share, "Compartilhar")

        startActivity(chosser)

    }
}


class BarberDetail(val id_barber: Int, val nome_barber: String, val img: String)