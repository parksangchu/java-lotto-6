package lotto.domain;

public class LottoShop {
    private static final int LOTTO_PRICE = 1_000;
    private final int purchaseAmount;
    private final int purchaseQuantity;

    public LottoShop(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        validate(purchaseAmount);
        purchaseQuantity = purchaseAmount / LOTTO_PRICE;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0 || purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public void issueLottos() {
        for (int i = 0; i < purchaseQuantity; i++) {
            Lotto lotto = LottoMaker.makeLotto();
            LottoRepository.addLotto(lotto);
        }
    }
}
