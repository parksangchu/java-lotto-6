package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INVALID_TYPE = "[ERROR] 숫자만 입력 가능합니다.";

    public int askPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        String input = Console.readLine();
        validateType(input);
        return Integer.parseInt(input);
    }

    private void validateType(String input) {
        if (!input.chars()
                .allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INVALID_TYPE);
        }
    }
}
