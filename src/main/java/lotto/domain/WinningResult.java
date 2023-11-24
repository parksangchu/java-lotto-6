package lotto.domain;

public class WinningResult {
    private final int winningCount;
    private final boolean matchingBonusNumber;

    public WinningResult(int winningCount, boolean matchingBonusNumber) {
        this.winningCount = winningCount;
        this.matchingBonusNumber = matchingBonusNumber;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean isMatchingBonusNumber() {
        return matchingBonusNumber;
    }
}
