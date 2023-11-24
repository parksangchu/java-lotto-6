package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningResultTest {

    @ParameterizedTest
    @DisplayName("당첨 결과에 따라 순위를 도출한다.")
    @CsvSource(value = {"6,true,FIRST", "6,false,FIRST", "5,true,SECOND", "5,false,THIRD", "4,true,FOURTH",
            "4,false,FOURTH", "3,true,FIFTH", "3,false,FIFTH", "2,true,NONE", "1,false,NONE", "0,false,NONE"})
    void toRank(int input1, boolean input2, Rank expect) {
        WinningResult winningResult = new WinningResult(input1, input2);
        Rank rank = winningResult.toRank();
        assertThat(rank).isEqualTo(expect);
    }
}