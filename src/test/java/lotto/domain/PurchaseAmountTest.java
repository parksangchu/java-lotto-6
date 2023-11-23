package lotto.domain;

import static lotto.global.Error.INVALID_AMOUNT_RANGE;
import static lotto.global.Error.INVALID_UNIT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {
    @Test
    @DisplayName("구매금액이 1,000원 단위가 아니면 예외가 발생한다.")
    void createInvalidUnitPurchaseAmount() {
        assertThatThrownBy(() -> new PurchaseAmount(1_100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_UNIT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("구매금액이 1,000원 이상 100,000원 이하가 아니면 예외가 발생한다.")
    @ValueSource(ints = {0, 101_000})
    void createInvalidRangePurchaseAmount(int input) {
        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_AMOUNT_RANGE.getMessage());
    }
}