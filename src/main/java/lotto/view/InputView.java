package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.ErrorMessage;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String NUMBER_REGEX = "^[0-9]+$";

    public static int readPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
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
