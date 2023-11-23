package lotto.domain;

import static lotto.global.Error.INVALID_AMOUNT_RANGE;
import static lotto.global.Error.INVALID_UNIT;

public class PurchaseAmount {
    private static final int PURCHASE_UNIT = 1_000;
    private static final int MAX_AMOUNT = 100_000;
    private static final int MIN_AMOUNT = 1_000;
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validateUnit(purchaseAmount);
        validateRange(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateUnit(int purchaseAmount) {
        if (purchaseAmount % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_UNIT.getMessage());
        }
    }

    private void validateRange(int purchaseAmount) {
        if (purchaseAmount < MIN_AMOUNT || purchaseAmount > MAX_AMOUNT) {
            throw new IllegalArgumentException(INVALID_AMOUNT_RANGE.getMessage());
        }
    }

    public int calculatePurchaseQuantity() {
        return purchaseAmount / PURCHASE_UNIT;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
