package com.appsdeviser.carfax.utils

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import kotlin.math.log10
import kotlin.math.pow

class Utilities {
    companion object {

        private val SUFFIXES = arrayOf<String>("", "k mi", "M mi", "B mi")

        private val PRECISE_DECIMAL_FORMATTER = DecimalFormat(
            "#,###.###",
            DecimalFormatSymbols.getInstance(Locale.ENGLISH)
        )

        private val DECIMAL_FORMATTER = DecimalFormat(
            "#,###.#",
            DecimalFormatSymbols.getInstance(Locale.ENGLISH)
        )

        fun mileageToRSDecimalStack(quantity:Int, precise:Boolean):String {
            val quantityStr = (quantity).toString()
            if (quantityStr.length <= 4)
            {
                return quantityStr
            }
            val power = log10(quantity.toDouble()).toInt()

            val format = if (precise && power >= 6)
                PRECISE_DECIMAL_FORMATTER
            else
                DECIMAL_FORMATTER
            return format.format(quantity / (10.0.pow(((power / 3) * 3).toDouble()))) + SUFFIXES[power / 3]
        }

        fun currencyFormat(amount:Double):String {
            val formatter = DecimalFormat("###,###,##0")
            return formatter.format(amount)
        }
}
}