package br.com.barberinhome.barberinhomebeta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import kotlinx.android.synthetic.main.activity_lista_barbeiros.*

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
    }
}
