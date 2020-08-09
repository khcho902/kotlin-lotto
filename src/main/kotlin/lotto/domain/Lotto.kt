package lotto.domain

class Lotto(numbers: Set<Int>) {
    val numbers = changeNumber(numbers)

    init {
        checkSixNumbers(numbers)
    }

    private fun checkSixNumbers(numbers: Set<Int>) {
        if (numbers.size != LOTTO_HAS_NUMBERS) {
            throw IllegalArgumentException("6개의 번호만 가질수 있습니다.")
        }
    }

    private fun changeNumber(numbers: Set<Int>): Set<Number> = numbers.map { Number.getNumber(it) }.toSet()

    fun getCountMatch(correctNumbers: Set<Number>): Int = correctNumbers.filter { isCorrect(it) }.size

    fun isCorrect(number: Number): Boolean = numbers.contains(number)

    companion object {
        const val LOTTO_HAS_NUMBERS = 6
    }
}
