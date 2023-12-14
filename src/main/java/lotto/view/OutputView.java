package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String LOTTOS_LABEL = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_RESULT_LABEL = "\n당첨 통계\n---";
    private static final String WINNING_RESULT = "%d개 일치 (%,d원) - %d개";
    private static final String WINNING_RESULT_FOR_SECOND = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String TOTAL_PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printLottos(int purchaseQuantity, List<Lotto> lottos) {
        System.out.printf(LOTTOS_LABEL, purchaseQuantity);
        lottos.forEach(lotto -> System.out.println(convertToString(lotto.getNumbers())));
    }

    public static String convertToString(List<Integer> lotto) {
        return lotto.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }

    public static void printWinningResult(Map<Rank, Integer> winningResult) {
        System.out.println(WINNING_RESULT_LABEL);
        winningResult.forEach((rank, count) -> System.out.println(converToString(rank, count)));
    }

    private static String converToString(Rank rank, int count) {
        if (rank.isSecond()) {
            return String.format(WINNING_RESULT_FOR_SECOND, rank.getMatchingCount(), rank.getPrize(), count);
        }
        return String.format(WINNING_RESULT, rank.getMatchingCount(), rank.getPrize(), count);
    }

    public static void printTotalProfitRate(double totalProfitRate) {
        System.out.printf(TOTAL_PROFIT_RATE_FORMAT, totalProfitRate);
    }
}
