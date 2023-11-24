package lotto.domain;

import static lotto.domain.Rank.NONE;

import java.util.Arrays;

public class WinningResult {
    private static final int SECOND_OR_THIRD = 5;
    private final int winningCount;
    private final boolean hasBonusNumber;

    public WinningResult(int winningCount, boolean matchingBonusNumber) {
        this.winningCount = winningCount;
        this.hasBonusNumber = matchingBonusNumber;
    }

    public Rank toRank() {
        if (winningCount == SECOND_OR_THIRD) {
            return Arrays.stream(Rank.values())
                    .filter(rank -> rank.getWinningCount() == winningCount)
                    .filter(rank -> rank.hasBonusNumber() == hasBonusNumber)
                    .findAny()
                    .orElse(NONE);
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getWinningCount() == winningCount)
                .findAny()
                .orElse(NONE);
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
