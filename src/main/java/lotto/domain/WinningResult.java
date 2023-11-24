package lotto.domain;

public class WinningResult {
    private final int winningCount;
    private final boolean matchBonusNumber;

    public WinningResult(int winningCount, boolean matchBonusNumber) {
        this.winningCount = winningCount;
        this.matchBonusNumber = matchBonusNumber;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean isMatchBonusNumber() {
        return matchBonusNumber;
    }
}
