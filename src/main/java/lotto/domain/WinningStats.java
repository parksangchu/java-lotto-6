package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class WinningStats {
    private final Map<Rank, Integer> winningStats;

    public WinningStats(Map<Rank, Integer> winningStats) {
        this.winningStats = winningStats;
    }

    private long calculateTotalProfit() {
        return winningStats.entrySet()
                .stream()
                .map(entry -> entry.getKey()
                        .calculateProfit(entry.getValue()))
                .mapToLong(profit -> profit)
                .sum();
    }

    public Map<Rank, Integer> getWinningStats() {
        return Collections.unmodifiableMap(winningStats);
    }

}
