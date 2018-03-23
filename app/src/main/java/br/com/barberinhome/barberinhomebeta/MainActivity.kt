package br.com.barberinhome.barberinhomebeta

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import android.Manifest.permission
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide
import android.R.attr.description
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide
import kotlinx.android.synthetic.main.intro_cadastro.*




class MainActivity : IntroActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //btCadastreSe.setOnClickListener{
        //    btCadastrar()
        //}



        isButtonNextVisible = false
        isButtonBackVisible = false

            addSlide(SimpleSlide.Builder()
                    .title("Éh! Chegou a hora de cortar a juba")
                    .description("Vamos fazer isso de um jeito fácil! 2 passos " +
                            "fazer um cadastro rapidinho e escolher o barbeiro que vai até você")
                    .image(R.drawable.um)
                    .background(R.color.background_white)
                    //.backgroundDark(R.color.background_dark_1)
                    //.scrollable(false)
                    //.permission(Manifest.permission.CAMERA)
                    .build())

            addSlide(SimpleSlide.Builder()
                    .title("Escolha o barbeiro, dia e a hora")
                    .description("Não se preucupe, ele foi selecionado a dedo por nossa equipe")
                    .image(R.drawable.dois)
                    .background(R.color.background_white)
                    //.backgroundDark(R.color.background_dark_1)
                    //.scrollable(false)
                    //.permission(Manifest.permission.CAMERA)
                    .build())

            addSlide(SimpleSlide.Builder()
                    .title("Ai sim!!!")
                    .description("Ficou bonitão sem filas e sem sair de casa")
                    .image(R.drawable.tres)
                    .background(R.color.background_white)
                    //.backgroundDark(R.color.background_dark_1)
                    //.scrollable(false)
                    //.permission(Manifest.permission.CAMERA)
                    .build())

            addSlide(SimpleSlide.Builder()
                    .title("Agora é só curtir o novo visual e fazer o pagamento")
                    .description("Não esqueça de fazer sua avalização sobre o barbeiro")
                    .image(R.drawable.quatro)
                    .background(R.color.background_white)
                    //.backgroundDark(R.color.background_dark_1)
                    //.scrollable(false)
                    //.permission(Manifest.permission.CAMERA)
                    //.canGoBackward(true)
                    //.canGoForward(false)
                    .build())

            addSlide(FragmentSlide.Builder()
                    .background(R.color.background_white)
                    .fragment(R.layout.intro_cadastro)
                    .canGoBackward(true)
                    .canGoForward(false)
                    .build())
        }

    fun btCadastrar(){
        val intent = Intent(this, CadastrarActivity::class.java)
        startActivity(intent)
    }
}
