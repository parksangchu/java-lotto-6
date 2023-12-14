package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    void createWinningResult() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Lotto> lottos = List.of(lotto1, lotto2);
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(lotto1, bonusNumber);
        LottoService lottoService = new LottoService(lottos, winningLotto);
        lottoService.createRanks();
        System.out.println(RankRepository.ranks());
    }
}