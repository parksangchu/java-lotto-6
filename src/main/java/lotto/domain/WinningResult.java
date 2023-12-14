package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class WinningResult {
    private static final double PERCENTAGE = 100.0;
    private final Map<Rank, Integer> winningResult;

    public WinningResult(Map<Rank, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public double calculateTotalProfitRate(int purchaseAmount) {
        return calculateTotalProfit() * PERCENTAGE / purchaseAmount;
    }

    private Long calculateTotalProfit() {
        return winningResult.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().calculateProfit(entry.getValue()))
                .sum();
    }

    public Map<Rank, Integer> getWinningResult() {
        return Collections.unmodifiableMap(winningResult);
    }
}
