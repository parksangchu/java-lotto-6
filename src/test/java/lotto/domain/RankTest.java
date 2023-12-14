package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void of() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
    }
}