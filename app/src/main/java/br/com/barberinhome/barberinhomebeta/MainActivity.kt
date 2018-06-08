package br.com.barberinhome.barberinhomebeta

import android.content.Intent
import android.os.Bundle
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide


class MainActivity : IntroActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        var db = DataBaseHandler(this)
//        var data = db.readUserData()
//        val email = data.get(0).email
//        if(!email.isEmpty()) {
//            startActivity(Intent(this, ListaBarbeirosActivity::class.java))
//        }

            isButtonNextVisible = false
            isButtonBackVisible = false

            addSlide(SimpleSlide.Builder()
                    .title(getString(R.string.t1))
                    .description(R.string.d1 )
                    .image(R.drawable.um)
                    .background(R.color.background_white)
                    .build())

            addSlide(SimpleSlide.Builder()
                    .title(R.string.t2)
                    .description(R.string.d2)
                    .image(R.drawable.dois)
                    .background(R.color.background_white)
                    .build())

            addSlide(SimpleSlide.Builder()
                    .title(R.string.t3)
                    .description(R.string.d3)
                    .image(R.drawable.tres)
                    .background(R.color.background_white)
                    .build())

            addSlide(SimpleSlide.Builder()
                    .title(R.string.t4)
                    .description(R.string.t4)
                    .image(R.drawable.quatro)
                    .background(R.color.background_white)
                    .build())

            addSlide(FragmentSlide.Builder()
                    .background(R.color.background_white)
                    .fragment(CadastroFragment())
                    .canGoBackward(true)
                    .canGoForward(false)
                    .build())


    }

}
