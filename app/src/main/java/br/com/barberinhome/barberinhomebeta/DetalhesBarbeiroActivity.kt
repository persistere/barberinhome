package br.com.barberinhome.barberinhomebeta

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalhes_barbeiro.view.*
import kotlinx.android.synthetic.main.activity_login.*
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhes_barbeiro.*


class DetalhesBarbeiroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_barbeiro)

        val foto = intent.getStringExtra(CustomViewHolder.FOTO_BARBER)
        val photo = findViewById<ImageView>(R.id.ivFotoDetalhes)
        Picasso.get().load(foto).into(photo)

        val nome = intent.getStringExtra(CustomViewHolder.NOME_BARBER)
        val i = findViewById<TextView>(R.id.tfnomeBarberdt)
        i.text = nome



        println(nome)
        println(foto)



        val datailURL = "http://barberinhome.com.br/app/rest/wsBarbers?id=1"
    }
}
