package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.ErrorMessage;

public class InputView {
    private static final String NUMBER_REGEX = "^[0-9]+$";

    public static int readPurchaseAmount() {
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateNumber(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }
}
