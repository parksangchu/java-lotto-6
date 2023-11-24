package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    // 아래에 추가 테스트 작성 가능

    @Test
    @DisplayName("발행한 로또를 당첨 로또와 비교할 수 있다.")
    void checkWinningResult() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto1 = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        WinningResult winningResult1 = lotto.checkWinningResult(winningLotto1);
        assertThat(winningResult1.getWinningCount()).isEqualTo(6);
        assertThat(winningResult1.hasBonusNumber()).isFalse();

        WinningLotto winningLotto2 = new WinningLotto(List.of(1, 2, 3, 4, 5, 20), 6);
        WinningResult winningResult2 = lotto.checkWinningResult(winningLotto2);
        assertThat(winningResult2.getWinningCount()).isEqualTo(5);
        assertThat(winningResult2.hasBonusNumber()).isTrue();
    }
}