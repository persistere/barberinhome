package br.com.barberinhome.barberinhomebeta

/**
 * Created by joseotavio on 02/06/2018.
 */


class AddUserdbLocal {
    var nome : String = ""
    var email : String = ""
    var senha : String = ""
    var celular : String = ""

    constructor(nome:String, email:String, senha:String,  celular:String){
        this.nome = nome
        this.email = email
        this.senha = senha
        this.celular = celular
    }

    constructor(){}
}