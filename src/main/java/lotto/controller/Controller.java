package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class Controller {

    public void run() {
        PurchaseAmount purchaseAmount = createPurchaseAmount();
    }

    private PurchaseAmount createPurchaseAmount() {
        return new PurchaseAmount(InputView.askPurchaseAmount());
    }
}
