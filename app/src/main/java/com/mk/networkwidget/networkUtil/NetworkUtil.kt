package com.mk.networkwidget.networkUtil

import android.content.Context
import android.content.Context.WIFI_SERVICE
import android.net.wifi.WifiManager
import android.util.Log


//region  context extension function getIp()
// required permissions


//endregion

fun Context.getIp(): String {
    val wm = this.getSystemService(WIFI_SERVICE) as WifiManager?
    wm?.let {
        val ip: String = integerToStringIP(it.connectionInfo.ipAddress)
        Log.d("network widget","IPV4 $ip")
        return ip
    }
    return "Not found";
}

fun integerToStringIP(ip: Int): String {
    return (ip and 0xFF).toString() + "." +
            (ip shr 8 and 0xFF) + "." +
            (ip shr 16 and 0xFF) + "." +
            (ip shr 24 and 0xFF)
}
