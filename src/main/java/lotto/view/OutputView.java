package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class OutputView {
    private static final String DELIMITER = ",";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String LOTTOS_LABEL = "\n%d개를 구매했습니다.";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printLottos(int purchaseQuantity, List<Lotto> lottos) {
        System.out.printf(LOTTOS_LABEL, purchaseQuantity);
        lottos.forEach(lotto -> System.out.println(convertToString(lotto.getNumbers())));
    }

    public static String convertToString(List<Integer> lotto) {
        return lotto.stream()
                .sorted()
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }
}
