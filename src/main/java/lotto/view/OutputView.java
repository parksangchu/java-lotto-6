package lotto.view;

import java.util.Arrays;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRepository;
import lotto.domain.Rank;
import lotto.domain.WinningStats;

public class OutputView {
    private static final String PURCHASE_QUANTITY_FORMAT = "%n%d개를 구매했습니다.%n";
    private static final String WINNING_STATS = "\n당첨 통계\n---";
    private static final String WINNING_STATS_FORMAT = "%d개 일치%s (%,d원) - %d개%n";
    private static final String HAS_BONUS_NUMBER = ", 보너스 볼 일치";
    private static final String HAS_NOT_BONUS_NUMBER = "";
    private static final String TOTAL_PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

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

    public static void printWinningStats(WinningStats winningStats) {
        Map<Rank, Integer> rankCounts = winningStats.getWinningStats();
        System.out.println(WINNING_STATS);
        Arrays.stream(Rank.values())
                .skip(1)
                .forEach(rank -> System.out.printf(WINNING_STATS_FORMAT
                        , rank.getWinningCount()
                        , checkBonusNumber(rank)
                        , rank.getPrize()
                        , rankCounts.get(rank)));
    }

    private static String checkBonusNumber(Rank rank) {
        if (rank.hasBonusNumber()) {
            return HAS_BONUS_NUMBER;
        }
        return HAS_NOT_BONUS_NUMBER;
    }

    public static void printTotalProfitRate(double totalProfitRate) {
        System.out.printf(TOTAL_PROFIT_RATE_FORMAT, totalProfitRate);
    }
}
