package lotto.domain;

public class WinningResult {
    private final int winningCount;
    private final boolean hasBonusNumber;

    public WinningResult(int winningCount, boolean hasBonusNumber) {
        this.winningCount = winningCount;
        this.hasBonusNumber = hasBonusNumber;
    }
}
