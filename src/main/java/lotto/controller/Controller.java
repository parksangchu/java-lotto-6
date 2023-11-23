package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    public void run() {
        PurchaseAmount purchaseAmount = createPurchaseAmount();
        int purchaseQuantity = purchaseAmount.calculatePurchaseQuantity();
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
}
