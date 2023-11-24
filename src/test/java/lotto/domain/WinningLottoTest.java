package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.global.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {
    @ParameterizedTest
    @DisplayName("보너스 번호는 당첨 번호와 중복될 수 없다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void createWinningLotto(int input) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = input;
        assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.INVALID_BONUS_NUMBER.getMessage());
        assertThatCode(() -> new WinningLotto(winningNumbers, 7))
                .doesNotThrowAnyException();
    }
}