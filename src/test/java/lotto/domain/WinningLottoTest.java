package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningLottoTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 6, 46})
    void create(int input) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = input;
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void calculateMatchingNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        int count = winningLotto.calculateMatchingNumber(numbers);
        assertThat(count).isEqualTo(5);
    }

    @Test
    void hasBonusNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        boolean hasBonusNumber = winningLotto.hasBonusNumber(numbers);
        assertThat(hasBonusNumber).isTrue();
    }
}