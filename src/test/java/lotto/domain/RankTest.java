package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @ParameterizedTest
    @DisplayName("당첨 결과 목록을 받아 순위 카운트를 생성한다.")
    @CsvSource(value = {"FIRST,1", "SECOND,1", "THIRD,1", "FOURTH,1", "FIFTH,0", "NONE,1"})
    void countRanks(Rank input, int expect) {
        List<WinningResult> winningResults = new ArrayList<>();
        winningResults.add(new WinningResult(6, true));
        winningResults.add(new WinningResult(5, true));
        winningResults.add(new WinningResult(5, false));
        winningResults.add(new WinningResult(4, true));
        winningResults.add(new WinningResult(0, true));
        Map<Rank, Integer> rankCounts = Rank.countRanks(winningResults);
        assertThat(rankCounts.get(input)).isEqualTo(expect);
    }
}