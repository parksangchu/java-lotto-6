package lotto.controller;

import lotto.domain.LottoShop;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    public void start() {
        LottoShop lottoShop = createLottoShop();
    }

    private LottoShop createLottoShop() {
        while (true) {
            try {
                return new LottoShop(InputView.readPurchaseAmount());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
