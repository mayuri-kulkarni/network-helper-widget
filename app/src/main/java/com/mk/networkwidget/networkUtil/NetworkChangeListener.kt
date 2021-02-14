package com.mk.networkwidget.networkUtil

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.mk.networkwidget.ExampleAppWidgetProvider
import com.mk.networkwidget.updateWidget

class NetworkChangeListener : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.updateWidget()
        Log.d("NetworkChangeListener", "onUpdate ");

    }
}