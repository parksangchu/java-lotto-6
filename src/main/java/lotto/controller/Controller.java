package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoRepository;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public void run() {
        PurchaseAmount purchaseAmount = createPurchaseAmount();
        int purchaseQuantity = purchaseAmount.calculatePurchaseQuantity();
        OutputView.printPurchaseQuantity(purchaseQuantity);
        LottoRepository lottoRepository = createLottoRepository(purchaseQuantity);
        OutputView.printLottos(lottoRepository);
        Lotto winningNumbers = createWinningNumbers();
    }

    private PurchaseAmount createPurchaseAmount() {
        while (true) {
            try {
                return new PurchaseAmount(InputView.askPurchaseAmount());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private LottoRepository createLottoRepository(int purchaseQuantity) {
        LottoRepository lottoRepository = new LottoRepository();
        lottoRepository.issueLottos(purchaseQuantity);
        return lottoRepository;
    }

    private Lotto createWinningNumbers() {
        while (true) {
            try {
                return new Lotto(InputView.askWinningNumbers());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
