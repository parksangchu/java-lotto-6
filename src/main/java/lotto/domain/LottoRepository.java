package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoRepository {
    private final List<Lotto> lottos = new ArrayList<>();

    public void issueLottos(int purchaseQuantity) {
        for (int i = 0; i < purchaseQuantity; i++) {
            Lotto lotto = new Lotto(Number.generateNumbers());
            lottos.add(lotto);
        }
    }

    public List<WinningResult> checkWinningResults(WinningLotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.checkWinningResult(winningLotto))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
