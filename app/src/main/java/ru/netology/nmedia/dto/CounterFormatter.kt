package ru.netology.nmedia.dto

class CounterFormatter {
    fun format(count: Int): String {
        return when {
            count >= 1_000_000 -> {
                val value = count / 1_000_000.0
                if (value >= 10) {
                    "${value.toInt()}M"
                } else {
                    String.format("%.1fM", value).replace(Regex("\\.0"), "")
                }
            }
            count >= 10_000 -> {
                val hundreds = (count / 100) % 100
                if (hundreds == 0) {
                    "${count / 1000}K"
                } else {
                    val value = count / 1000.0
                    String.format("%.1fK", value).replace(Regex("\\.0"), "")
                }
            }
            count >= 1000 -> {
                val hundreds = (count / 100) % 10
                if (hundreds == 0) {
                    "${count / 1000}K"
                } else {
                    val value = count / 1000.0
                    String.format("%.1fK", value).replace(Regex("\\.0"), "")
                }
            }
            else -> count.toString()
        }
    }
}