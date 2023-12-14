package lotto.domain;

import lotto.view.OutputView;
import org.junit.jupiter.api.Test;

class LottoMakerTest {

    @Test
    void makeLotto() {
        Lotto lotto = LottoMaker.makeLotto();
        System.out.println(OutputView.convertToString(lotto.getNumbers()));

    }
}