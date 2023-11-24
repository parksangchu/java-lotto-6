package lotto.view;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRepository;
import lotto.domain.Rank;

public class OutputView {
    private static final String PURCHASE_QUANTITY_FORMAT = "%n%d개를 구매했습니다.%n";
    private static final String WINNING_STATS = "당첨 통계\n---";
    private static final String WINNING_STATS_FORMAT = """
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개
            """;

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printPurchaseQuantity(int purchaseQuantity) {
        System.out.printf(PURCHASE_QUANTITY_FORMAT, purchaseQuantity);
    }

    public static void printLottos(LottoRepository lottoRepository) {
        for (Lotto lotto : lottoRepository.getLottos()) {
            System.out.println(lotto.getNumbers()
                    .stream()
                    .sorted()
                    .toList());
        }
    }

    public static void printWinningStats(Map<Rank, Integer> winningStats) {
        System.out.println(WINNING_STATS);
        System.out.printf(WINNING_STATS_FORMAT
                , winningStats.get(FIFTH)
                , winningStats.get(FOURTH)
                , winningStats.get(THIRD)
                , winningStats.get(SECOND)
                , winningStats.get(FIRST));
    }
}
