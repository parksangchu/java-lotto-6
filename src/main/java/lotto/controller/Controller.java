package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRepository;
import lotto.domain.LottoService;
import lotto.domain.LottoShop;
import lotto.domain.RankRepository;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    public void start() {
        LottoShop lottoShop = createLottoShop();
        lottoShop.issueLottos();
        OutputView.printLottos(lottoShop.getPurchaseQuantity(), LottoRepository.lottos());
        WinningLotto winningLotto = createWinningLotto();
        LottoService lottoService = new LottoService(LottoRepository.lottos(), winningLotto);
        lottoService.createRanks();
        WinningResult winningResult = new WinningResult(RankRepository.createWinningResult());
        OutputView.printWinningResult(winningResult.getWinningResult());
        double totalProfitRate = winningResult.calculateTotalProfitRate(lottoShop.getPurchaseAmount());
        OutputView.printTotalProfitRate(totalProfitRate);
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

    private WinningLotto createWinningLotto() {
        Lotto lotto = createLotto();
        while (true) {
            try {
                int bonusNumber = InputView.readBonusNumber();
                return new WinningLotto(lotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private Lotto createLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = InputView.readWinningNumbers();
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
