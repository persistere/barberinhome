package br.com.barberinhome.barberinhomebeta.util

import br.com.barberinhome.barberinhomebeta.Model.EditUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by joseotavio on 01/06/2018.
 */
interface CallRetrofitEditUser<T> {

    @GET("app/rest/wsUsers?a=5&tipo=1")

    fun getEditUser(@Query("id_barber") id_barber: Int,
                    @Query("nome_barber") nome_barber: String,
                   @Query("telefone") telefone: String,
                   @Query("sucesso") sucesso: Int)
            : Call<EditUser>

}