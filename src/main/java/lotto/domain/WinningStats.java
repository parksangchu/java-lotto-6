package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class WinningStats {
    private final Map<Rank, Integer> winningStats;

    public WinningStats(Map<Rank, Integer> winningStats) {
        this.winningStats = winningStats;
    }

    public Map<Rank, Integer> getWinningStats() {
        return Collections.unmodifiableMap(winningStats);
    }
}
