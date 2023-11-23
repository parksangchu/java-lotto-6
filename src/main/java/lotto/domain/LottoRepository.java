package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> lottos = new ArrayList<>();

    public void issueLottos(int purchaseQuantity) {
        for (int i = 0; i < purchaseQuantity; i++) {
            Lotto lotto = new Lotto(NumbersGenerator.generateNumbers());
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
