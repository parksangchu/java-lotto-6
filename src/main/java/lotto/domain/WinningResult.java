package lotto.domain;

public class WinningResult {
    private final int winningCount;
    private final boolean hasBonusNumber;

    public WinningResult(int winningCount, boolean matchingBonusNumber) {
        this.winningCount = winningCount;
        this.hasBonusNumber = matchingBonusNumber;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
