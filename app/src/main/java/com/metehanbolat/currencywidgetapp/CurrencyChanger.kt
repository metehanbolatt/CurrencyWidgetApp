package com.metehanbolat.currencywidgetapp

import android.content.Context
import kotlin.random.Random

class CurrencyChanger(context: Context) {

    private val prefs = context.getSharedPreferences("Currency", Context.MODE_PRIVATE)

    var dolarAmount: Float
        get() {
            return prefs.getFloat(PREF_DOLAR, 10f)
        }
        set(value) {
            prefs.edit().putFloat(PREF_DOLAR, value).apply()
        }

    var euroAmount: Float
        get() {
            return prefs.getFloat(PREF_EURO, 11f)
        }
        set(value) {
            prefs.edit().putFloat(PREF_EURO, value).apply()
        }

    var sterlinAmount: Float
        get() {
            return prefs.getFloat(PREF_STERLIN, 12f)
        }
        set(value) {
            prefs.edit().putFloat(PREF_STERLIN, value).apply()
        }

    fun changeString() {
        val dolar = Random.nextDouble(10.0, 16.0)
        val euro = Random.nextDouble(15.0,21.0)
        val sterlin = Random.nextDouble(18.0,32.0)
        val strList = listOf(
            CurrencyModel("dolar", dolar.toFloat()),
            CurrencyModel("euro", euro.toFloat()),
            CurrencyModel("sterlin", sterlin.toFloat()),
        )
        dolarAmount = strList[0].amount
        euroAmount = strList[1].amount
        sterlinAmount = strList[2].amount
    }

    companion object {
        private const val PREF_DOLAR = "dolar"
        private const val PREF_EURO = "euro"
        private const val PREF_STERLIN = "sterlin"
    }
}