package com.baitent.habit_compose.common.helpers

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

object DateFormatterHelper {

    private fun formatWeekday(date: LocalDate): String =
        date.dayOfWeek
            .name
            .lowercase()
            .replaceFirstChar { it.uppercase() }

    private fun formatMonth(date: LocalDate): String =
        date.month
            .name
            .lowercase()
            .replaceFirstChar { it.uppercase() }


    private fun formatDate(date: LocalDate): String {
        val weekday = formatWeekday(date)
        val month = formatMonth(date)
        return "$weekday, ${date.dayOfMonth} $month ${date.year}"
    }

    fun getTodayFormattedDate(
        zone: TimeZone = TimeZone.currentSystemDefault()
    ): String {
        val today = Clock.System.now()
            .toLocalDateTime(zone)
            .date
        return formatDate(today)
    }
}
