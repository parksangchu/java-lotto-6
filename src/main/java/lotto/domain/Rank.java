package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int winningCount;
    private final boolean hasBonusNumber;
    private final int prize;

    Rank(int winningCount, boolean hasBonusNumber, int prize) {
        this.winningCount = winningCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static WinningStats countRanks(List<WinningResult> winningResults) {
        Map<Rank, Integer> winningStats = new EnumMap<>(Rank.class);
        List<Rank> ranks = convertToRanks(winningResults);
        for (Rank rank : values()) {
            int count = Collections.frequency(ranks, rank);
            winningStats.put(rank, count);
        }
        return new WinningStats(winningStats);
    }

    private static List<Rank> convertToRanks(List<WinningResult> winningResults) {
        return winningResults.stream()
                .map(WinningResult::toRank)
                .collect(Collectors.toList());
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    public int getPrize() {
        return prize;
    }
}
