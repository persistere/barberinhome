package br.com.barberinhome.barberinhomebeta

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splashctivity.*

class Splashctivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashctivity)

        carregar()
    }

    fun carregar(){
        val animacao = AnimationUtils.loadAnimation(this, R.anim.splash)

        ivLogo.clearAnimation()
        ivLogo.startAnimation(animacao)

        Handler().postDelayed({
            val intent = Intent(this@Splashctivity, MainActivity::class.java)

            this@Splashctivity.startActivity(intent)

            finish()
        }, 2000)
    }
}
