package lotto.controller;

import lotto.domain.LottoRepository;
import lotto.domain.LottoShop;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    public void start() {
        LottoShop lottoShop = createLottoShop();
        lottoShop.issueLottos();
        OutputView.printLottos(lottoShop.getPurchaseQuantity(), LottoRepository.lottos());
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
