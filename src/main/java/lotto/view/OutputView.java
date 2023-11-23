package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRepository;

public class OutputView {
    private static final String PURCHASE_QUANTITY_FORMAT = "%n%d개를 구매했습니다.%n";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printPurchaseQuantity(int purchaseQuantity) {
        System.out.printf(PURCHASE_QUANTITY_FORMAT, purchaseQuantity);
    }

    public static void printLottos(LottoRepository lottoRepository) {
        for (Lotto lotto : lottoRepository.getLottos()) {
            System.out.println(lotto.toString());
        }
    }
}
