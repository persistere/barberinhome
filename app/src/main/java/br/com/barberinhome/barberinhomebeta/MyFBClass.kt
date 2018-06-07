package br.com.barberinhome.barberinhomebeta

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.iid.FirebaseInstanceId



/**
 * Created by joseotavio on 28/05/2018.
 */

class MyFBClass : FirebaseMessagingService() {

    override fun onMessageReceived(p0: RemoteMessage?) {
        super.onMessageReceived(p0)

        val refreshedToken = FirebaseInstanceId.getInstance().token
        Log.d(TAG, "Refreshed token>>>>>>>>>>>>>>>>>>>>>>>>>>: " + refreshedToken!!)

    }




}


