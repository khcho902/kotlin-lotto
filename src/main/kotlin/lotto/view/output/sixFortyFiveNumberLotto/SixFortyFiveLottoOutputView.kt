package lotto.view.output.sixFortyFiveNumberLotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoes
import lotto.view.output.OutputView

class SixFortyFiveLottoOutputView(lottoes: SixFortyFiveLottoes) :
    OutputView(
        lottoes.lottoList.map { lotto -> lotto.numbers.toString() + "\n" }
            .reduce { acc, s -> acc + s },
    )
