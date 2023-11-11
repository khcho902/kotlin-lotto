package calculator

class StringAddCalculator {

    fun add(input: String?): Long {
        if (input.isNullOrBlank()) return 0

        val tokens = tokenizeInput(input)
        return tokens.sumOf { parseToPositiveNumber(it) }
    }

    private fun tokenizeInput(input: String): List<String> {
        val customDelimiterMatchResult = Regex("//(.)\n(.*)").find(input)

        return if (customDelimiterMatchResult != null) {
            val (customDelimiter, numbers) = customDelimiterMatchResult.destructured
            numbers.split(customDelimiter)
        } else {
            input.split(",|:".toRegex())
        }
    }

    private fun parseToPositiveNumber(number: String): Long {
        val parsedNumber = number.toLongOrNull()
            ?: throw IllegalArgumentException("Invalid number format: $number")

        if (parsedNumber < 0) {
            throw IllegalArgumentException("Negative numbers not allowed: $parsedNumber")
        }

        return parsedNumber
    }
}
