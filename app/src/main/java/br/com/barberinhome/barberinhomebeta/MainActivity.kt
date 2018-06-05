package br.com.barberinhome.barberinhomebeta

import android.os.Bundle
import com.heinrichreimersoftware.materialintro.app.IntroActivity
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide


class MainActivity : IntroActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        isButtonNextVisible = false
        isButtonBackVisible = false

            addSlide(SimpleSlide.Builder()
                    .title("Éh! Chegou a hora de cortar a juba")
                    .description("Vamos fazer isso de um jeito fácil! 2 passos" )
                    .image(R.drawable.um)
                    .background(R.color.background_white)
                    .build())

            addSlide(SimpleSlide.Builder()
                    .title("Escolha o barbeiro, dia e a hora")
                    .description("Não se preucupe, ele foi selecionado a dedo por nossa equipe")
                    .image(R.drawable.dois)
                    .background(R.color.background_white)
                    .build())

            addSlide(SimpleSlide.Builder()
                    .title("Após efetuar o pagmento um barbeiro irá até você")
                    .description("Vai ficar bonitão sem filas, sem transito e sem sair de casa")
                    .image(R.drawable.tres)
                    .background(R.color.background_white)
                    .build())

            addSlide(SimpleSlide.Builder()
                    .title("Agora é só curtir o novo visual")
                    .description("Não esqueça de fazer sua avalização sobre o barbeiro")
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
