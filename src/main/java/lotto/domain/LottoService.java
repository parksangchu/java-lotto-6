package lotto.domain;

import java.util.List;

public class LottoService {
    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;


    public LottoService(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public void createRanks() {
        for (Lotto lotto : lottos) {
            int matchingCount = winningLotto.calculateMatchingNumber(lotto.getNumbers());
            boolean hasBonusNumber = winningLotto.hasBonusNumber(lotto.getNumbers());
            Rank rank = Rank.of(matchingCount, hasBonusNumber);
            if (rank.isNotNone()) {
                RankRepository.addRank(rank);
            }
        }
    }
}
