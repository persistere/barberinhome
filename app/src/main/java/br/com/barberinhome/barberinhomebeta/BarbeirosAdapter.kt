package br.com.barberinhome.barberinhomebeta

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_login.view.*
import kotlinx.android.synthetic.main.item_list.view.*


/**
 * Created by joseotavio on 25/05/2018.
 */
class BarbeirosAdapter(val homeFeed: Homefeed): RecyclerView.Adapter<CustomViewHolder>(){

    //Numero de Itens
    override fun getItemCount(): Int {
        return homeFeed.barbers.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        //como criamos a view
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellfromRow = layoutInflater.inflate(R.layout.item_list, parent, false)
        return  CustomViewHolder(cellfromRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        val nomeBarbeiros = nomeBarbeiros.get(position)
        val barbeiro = homeFeed.barbers.get(position)
        holder?.itemView?.tfnomeBarber?.text = barbeiro.nome_barber


        val thumb = holder?.itemView?.ivFoto
        Picasso.get().load(barbeiro?.img).into(thumb)

        holder?.barbeiro = barbeiro
    }

}


class CustomViewHolder(val view: View, var barbeiro: Barbers? = null): RecyclerView.ViewHolder(view) {

    companion object {
        val NOME_BARBER = ""
        val FOTO_BARBER = ""
    }

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, DetalhesBarbeiroActivity::class.java)

            intent.putExtra(FOTO_BARBER, barbeiro?.img)
            intent.putExtra(NOME_BARBER, barbeiro?.nome_barber)

            view.context.startActivity(intent)
        }
    }
}