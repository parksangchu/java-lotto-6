package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.global.Error;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {
    @ParameterizedTest
    @DisplayName("로또 번호는 1-45 숫자만 생성 가능하다.")
    @ValueSource(ints = {-1, 0, 46, 50, 100})
    void createNumber(int input) {
        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.INVALID_NUMBER_RANGE.getMessage());
        assertThatCode(() -> new Number(30))
                .doesNotThrowAnyException();
    }
}