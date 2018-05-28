package br.com.barberinhome.barberinhomebeta

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * Created by joseotavio on 28/05/2018.
 */

class MyFBClass : FirebaseMessagingService(){

    override fun onMessageReceived(p0: RemoteMessage?) {
        super.onMessageReceived(p0)

    }
}