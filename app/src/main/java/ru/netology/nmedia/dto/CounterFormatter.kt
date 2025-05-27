package ru.netology.nmedia.dto

class CounterFormatter {
    fun format(count: Int): String {
        return when {
            count >= 1_000_000 -> {
                val value = count / 1_000_000.0
                if (value >= 10) {
                    "${value.toInt()}M"
                } else {
                    val formatted = String.format("%.1f", value)
                    formatted.replace(Regex("\\.0$"), "")
                }
            }
            count >= 10_000 -> {
                val thousands = count / 1000
                val hundredsPart = (count / 100) % 10
                if (hundredsPart == 0) {
                    "$thousands K"
                } else {
                    val value = count / 1000.0
                    val formatted = String.format("%.1f", value)
                    formatted.replace(Regex("\\.0$"), "") + "K"
                }
            }
            count >= 1000 -> {
                val thousands = count / 1000
                val hundredsPart = (count / 100) % 10
                if (hundredsPart == 0) {
                    "$thousands K"
                } else {
                    val value = count / 1000.0
                    val formatted = String.format("%.1f", value)
                    formatted.replace(Regex("\\.0$"), "") + "K"
                }
            }
            else -> count.toString()
        }
    }
}