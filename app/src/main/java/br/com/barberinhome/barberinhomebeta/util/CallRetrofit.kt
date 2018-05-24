package br.com.barberinhome.barberinhomebeta.util

import br.com.barberinhome.barberinhomebeta.Model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by joseotavio on 23/05/2018.
 */
interface CallRetrofit {
    //@GET("wsClients?login_email={login_email}&senha={senha}")
    @GET("app/rest/wsClients")
    fun getUser(@Query("login_email") login_email: String,
                @Query("senha") senha: String): Call<User>


}