package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoRepositoryTest {
    private LottoRepository lottoRepository;

    @BeforeEach
    void setUp() {
        lottoRepository = new LottoRepository();
        lottoRepository.issueLottos(10);
    }

    @Test
    @DisplayName("구매 수량을 입력 받아 로또를 발행한다.")
    void issueLottos() {
        assertThat(lottoRepository.getLottos()
                .size())
                .isEqualTo(10);
    }

    @Test
    @DisplayName("당첨 로또를 입력 받아 당첨 결과 목록을 만든다.")
    @RepeatedTest(100)
    void checkWinningResults() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        List<WinningResult> winningResults = lottoRepository.checkWinningResults(winningLotto);
        for (WinningResult winningResult : winningResults) {
            System.out.println(winningResult.getWinningCount());
            System.out.println(winningResult.isMatchingBonusNumber());
        }
        assertThat(winningResults.size()).isEqualTo(10);
    }
}