package com.mk.networkwidget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.RemoteViews
import com.mk.networkwidget.networkUtil.getIp

fun Context.updateWidget(){
    val intent = Intent(this, ExampleAppWidgetProvider::class.java)
    intent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
// Use an array and EXTRA_APPWIDGET_IDS instead of AppWidgetManager.EXTRA_APPWIDGET_ID,
// since it seems the onUpdate() is only fired on that:
    // Use an array and EXTRA_APPWIDGET_IDS instead of AppWidgetManager.EXTRA_APPWIDGET_ID,
// since it seems the onUpdate() is only fired on that:
    val ids: IntArray = AppWidgetManager.getInstance(this).
    getAppWidgetIds((ComponentName(this, ExampleAppWidgetProvider::class.java)))
    intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids)
    sendBroadcast(intent)
}

class ExampleAppWidgetProvider : AppWidgetProvider() {
    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        Log.d("AppWidgetProvider", "onReceive $intent");
    }

    override fun onUpdate(
            context: Context?,
            appWidgetManager: AppWidgetManager?,
            appWidgetIds: IntArray?
    ) {
//        super.onUpdate(context, appWidgetManager, appWidgetIds)
        Log.d("AppWidgetProvider", "onUpdate $appWidgetIds");

        // Get the layout for the App Widget and attach an on-click listener
        // to the button
        if(appWidgetIds!=null)
        for (id in appWidgetIds){
            val views = RemoteViews(context?.packageName, R.layout.layout_widget);
            views.setTextViewText(R.id.textview_ip, context?.getIp())
            appWidgetManager?.updateAppWidget(id, views)

        }
    }

    override fun onAppWidgetOptionsChanged(
            context: Context?,
            appWidgetManager: AppWidgetManager?,
            appWidgetId: Int,
            newOptions: Bundle?
    ) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions)
        Log.d("AppWidgetProvider", "onAppWidgetOptionsChanged $appWidgetId");

    }

    override fun onDeleted(context: Context?, appWidgetIds: IntArray?) {
        super.onDeleted(context, appWidgetIds)
        Log.d("AppWidgetProvider", "onDeleted $appWidgetIds");

    }

    override fun onEnabled(context: Context?) {
        super.onEnabled(context)
        Log.d("AppWidgetProvider", "onEnabled ");

    }

    override fun onDisabled(context: Context?) {
        super.onDisabled(context)
        Log.d("AppWidgetProvider", "onDisabled ");

    }

    override fun onRestored(context: Context?, oldWidgetIds: IntArray?, newWidgetIds: IntArray?) {
        super.onRestored(context, oldWidgetIds, newWidgetIds)
        Log.d("AppWidgetProvider", "onRestored $oldWidgetIds -> $newWidgetIds ");

    }


}