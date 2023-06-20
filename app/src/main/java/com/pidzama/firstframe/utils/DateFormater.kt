package com.pidzama.firstframe.utils

import android.annotation.SuppressLint
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@SuppressLint("SimpleDateFormat")
fun DateFormater(dates : String): String{
    var formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("M/dd/yyyy")
    formatter =
        formatter.withLocale(Locale.US) // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH

    val date: LocalDate = LocalDate.parse("3/24/2022", formatter)
    return date.toString()
}

