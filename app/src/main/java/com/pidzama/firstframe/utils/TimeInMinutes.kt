package com.pidzama.firstframe.utils

fun timeToString(minutes: Int): String? {
    val hour = minutes / 60
    val min = minutes / hour % 60
    return String.format("%02dh %02dm", hour, min)
}