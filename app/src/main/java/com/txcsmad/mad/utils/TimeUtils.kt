package com.txcsmad.mad.utils

import java.text.SimpleDateFormat
import java.util.*

class TimeUtils {
    companion object {
        @JvmStatic
        fun getFormattedTime(date: String): String {
            val parsedDate = getParsedDate(date)
            val dateFormat = SimpleDateFormat("hh:mm a", Locale.US)
            dateFormat.timeZone = TimeZone.getTimeZone("GMT-05:00")
            return dateFormat.format(parsedDate)
        }

        fun getFormattedDate(date: String): String {
            val parsedDate = getParsedDate(date)
            val dateFormat = SimpleDateFormat("DD-MM-YYYY", Locale.US)
            dateFormat.timeZone = TimeZone.getTimeZone("GMT-05:00")
            return dateFormat.format(parsedDate)
        }

        fun getTimeSpan(startTime: String, endTime: String): String {
            val stringBuilder = StringBuilder(startTime)
                .append(" - ")
                .append(endTime)
            return stringBuilder.toString()
        }

        private fun getParsedDate(date: String): Date {
            val dateFormat = SimpleDateFormat("YYYY-MM-DDThh:mm:ssTZD", Locale.US)
            dateFormat.timeZone = TimeZone.getTimeZone("GMT")
            return dateFormat.parse(date)
        }
    }
}