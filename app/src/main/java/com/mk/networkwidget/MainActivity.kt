package com.mk.networkwidget

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mk.networkwidget.databinding.ActivityMainBinding
import com.mk.networkwidget.networkUtil.NetworkChangeListener
import com.mk.networkwidget.networkUtil.getIp


class MainActivity : AppCompatActivity() {

    var binding : ActivityMainBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.networkWidget?.textviewIp?.text = getIp()

        val intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(NetworkChangeListener(), intentFilter)


    }
}