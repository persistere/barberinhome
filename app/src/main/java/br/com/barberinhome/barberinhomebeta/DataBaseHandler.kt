package br.com.barberinhome.barberinhomebeta

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


/**
 * Created by joseotavio on 02/06/2018.
 */

val DATABASE_NAME = "TabelaUser"
val TABLE_NAME = "Users"
val COL_ID = "id"
val COL_NOME = "nome"
val COL_EMAIL = "email"
val COL_SENHA = "senha"
val COL_CELULAR = "celular"

class DataBaseHandler (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

        override fun onCreate(db: SQLiteDatabase?) {
            val createTable = " CREATE TABLE " + TABLE_NAME + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NOME + " VARCHAR(256), " +
                    COL_EMAIL + " VARCHAR(256), " +
                    COL_SENHA + " VARCHAR(256), " +
                    COL_CELULAR + " VARCHAR(256) )"

            db?.execSQL(createTable)

        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        }


        fun addUserData(addUserdbLocal : AddUserdbLocal) {
            val db = this.writableDatabase
            var cv = ContentValues()
            cv.put(COL_NOME, addUserdbLocal.nome )
            cv.put(COL_EMAIL, addUserdbLocal.email )
            cv.put(COL_SENHA, addUserdbLocal.senha )
            cv.put(COL_CELULAR, addUserdbLocal.celular )


            var result = db.insert(TABLE_NAME, null, cv)

            if (result == -1.toLong()) {
                println("erro")
            } else {
                println("sucesso")
            }
        }

        fun readUserData() : MutableList<AddUserdbLocal>{
            var list : MutableList<AddUserdbLocal> = ArrayList()

            val db = this.readableDatabase
            val query = "Select * from " + TABLE_NAME
            val result = db.rawQuery(query, null)

            if(result.moveToFirst()){
                do {
                    var user = AddUserdbLocal()
                    user.nome = result.getString(result.getColumnIndex(COL_NOME))
                    list.add(user)

                }while (result.moveToNext())
            }

            result.close()
            db.close()

            return list
        }

}



