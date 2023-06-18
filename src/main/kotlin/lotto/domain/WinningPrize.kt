package lotto.domain

enum class WinningPrize(val count: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    companion object {
        fun of(count: Int): WinningPrize {
            return values().first { it.count == count }
        }
    }
}
