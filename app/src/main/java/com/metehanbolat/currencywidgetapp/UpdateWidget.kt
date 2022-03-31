package com.metehanbolat.currencywidgetapp

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

val MY_BUTTTON_START = "myButtonStart"

fun updateWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetIds: IntArray?
) {
    val text = CurrencyChanger(context)

    val remoteViews = RemoteViews(context.packageName, R.layout.currency_widget).apply {
        setTextViewText(R.id.dolarAmount, text.dolarAmount.toString())
        setTextViewText(R.id.euroAmount, text.euroAmount.toString())
        setTextViewText(R.id.sterlinAmount, text.sterlinAmount.toString())

        val intent = Intent(context, CurrencyWidget::class.java)
        intent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds)
        PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        setOnClickPendingIntent(R.id.widgetButton, getPendingSelfIntent(context, MY_BUTTTON_START, CurrencyWidget::class.java))
    }
    text.changeString()

    appWidgetManager.updateAppWidget(appWidgetIds, remoteViews)
}

fun getPendingSelfIntent(context: Context?, action: String?, widgetClass: Class<CurrencyWidget>): PendingIntent? {
    val intent = Intent(context, widgetClass)
    intent.action = action
    return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
}