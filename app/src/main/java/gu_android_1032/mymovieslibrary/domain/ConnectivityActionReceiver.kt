package gu_android_1032.mymovieslibrary.domain

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import gu_android_1032.mymovieslibrary.R

class ConnectivityActionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        Toast.makeText(
            context,
            context?.getString(R.string.connection_receiver_message),
            Toast.LENGTH_LONG
        ).show()

    }
}