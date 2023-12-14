package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    NONE(0, List.of(), 0),
    FIFTH(3, List.of(true, false), 5_000),
    FOURTH(4, List.of(true, false), 50_000),
    THIRD(5, List.of(false), 1_500_000),
    SECOND(5, List.of(true), 30_000_000),
    FIRST(6, List.of(true, false), 2_000_000_000);


    private final int matchingCount;
    private final List<Boolean> hasBonusNumber;
    private final int prize;

    Rank(int matchingCount, List<Boolean> hasBonusNumber, int prize) {
        this.matchingCount = matchingCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static Rank of(int matchingCount, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchingCount == matchingCount)
                .filter(rank -> rank.hasBonusNumber.contains(hasBonusNumber))
                .findAny()
                .orElse(NONE);
    }

    public boolean isNotNone() {
        return this != NONE;
    }

    public boolean is(Rank rank) {
        return this == rank;
    }

    public boolean isSecond() {
        return this == SECOND;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int calculateProfit(int count) {
        return count * prize;
    }
}
