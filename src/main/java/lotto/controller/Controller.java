package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRepository;
import lotto.domain.Number;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.domain.WinningStats;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public void run() {
        PurchaseAmount purchaseAmount = createPurchaseAmount();
        int purchaseQuantity = purchaseAmount.calculatePurchaseQuantity();
        OutputView.printPurchaseQuantity(purchaseQuantity);
        LottoRepository lottoRepository = createLottoRepository(purchaseQuantity);
        OutputView.printLottos(lottoRepository);
        WinningLotto winningLotto = createWinningLotto();
        List<WinningResult> winningResults = lottoRepository.checkWinningResults(winningLotto);
        WinningStats winningStats = Rank.countRanks(winningResults);
        OutputView.printWinningStats(winningStats);
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

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = createWinningNumbers();
        while (true) {
            try {
                int bonusNumber = InputView.askBonusNumber();
                new Number(bonusNumber);
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
