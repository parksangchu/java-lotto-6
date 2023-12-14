package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoShopTest {
    @Test
    void create() {
        assertThatThrownBy(() -> new LottoShop(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new LottoShop(1001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void issueLottos() {
        LottoShop lottoShop = new LottoShop(5000);
        lottoShop.issueLottos();
        assertThat(LottoRepository.lottos().size())
                .isEqualTo(5);
    }
}