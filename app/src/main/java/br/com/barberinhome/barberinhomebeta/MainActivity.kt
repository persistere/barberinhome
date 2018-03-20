package br.com.barberinhome.barberinhomebeta

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import android.Manifest.permission
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide
import android.R.attr.description



class MainActivity : IntroActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        addSlide(SimpleSlide.Builder()
                .title("Slide 1")
                .description("Slide 1")
                .image(R.drawable.um)
                .background(R.color.white)
                //.backgroundDark(R.color.background_dark_1)
                //.scrollable(false)
                //.permission(Manifest.permission.CAMERA)
                .build())
        addSlide(SimpleSlide.Builder()
                .title("Slide 2")
                .description("Slide 3")
                .image(R.drawable.dois)
                .background(R.color.white)
                //.backgroundDark(R.color.background_dark_1)
                //.scrollable(false)
                //.permission(Manifest.permission.CAMERA)
                .build())
        addSlide(SimpleSlide.Builder()
                .title("Slide 3")
                .description("Slide 3")
                .image(R.drawable.tres)
                .background(R.color.white)
                //.backgroundDark(R.color.background_dark_1)
                //.scrollable(false)
                //.permission(Manifest.permission.CAMERA)
                .build())
        addSlide(SimpleSlide.Builder()
                .title("Slide 4")
                .description("Slide 4")
                .image(R.drawable.quatro)
                .background(R.color.white)
                //.backgroundDark(R.color.background_dark_1)
                //.scrollable(false)
                //.permission(Manifest.permission.CAMERA)
                .build())
    }
}
