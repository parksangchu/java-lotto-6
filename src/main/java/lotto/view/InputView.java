package lotto.view;

import static lotto.global.Error.INVALID_TYPE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public int askPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        String input = Console.readLine();
        validateType(input);
        return Integer.parseInt(input);
    }

    private void validateType(String input) {
        if (!input.chars()
                .allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INVALID_TYPE.getMessage());
        }
    }
}
