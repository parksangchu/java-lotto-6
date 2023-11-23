package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRepositoryTest {

    @Test
    @DisplayName("구매 수량을 매개변수로 입력 받아 로또를 발행한다.")
    void issueLottos() {
        LottoRepository lottoRepository = new LottoRepository();
        lottoRepository.issueLottos(10);
        assertThat(lottoRepository.getLottos()
                .size())
                .isEqualTo(10);
    }
}