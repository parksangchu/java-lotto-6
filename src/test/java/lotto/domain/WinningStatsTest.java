package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatsTest {

    @Test
    @DisplayName("로또 구매 금액을 받아 총 수익률을 계산한다.")
    void calculateTotalProfitRate() {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        rankCounts.put(Rank.SECOND, 1);
        PurchaseAmount purchaseAmount = new PurchaseAmount(100_000);
        WinningStats winningStats = new WinningStats(rankCounts);
        double totalProfitRate = winningStats.calculateTotalProfitRate(purchaseAmount);
        assertThat(totalProfitRate).isEqualTo(30_000_000 * 100.0 / 100_000);
    }
}