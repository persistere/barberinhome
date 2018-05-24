package br.com.barberinhome.barberinhomebeta.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by joseotavio on 23/05/2018.
 */
class MRetrofit {

    var retrofit: Retrofit

    constructor() {
        retrofit = Retrofit.Builder()
                .baseUrl("http://barberinhome.com.br/app/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getRetofit(): Retrofit {
        return retrofit
    }
}

