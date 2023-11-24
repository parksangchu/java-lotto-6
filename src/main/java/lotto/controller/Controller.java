package lotto.controller;

import java.util.List;
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
        List<Integer> winningNumbers = createWinningNumbers();
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

    private List<Integer> createWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = InputView.askWinningNumbers();
                new Lotto(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
