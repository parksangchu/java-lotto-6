package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INVALID_TYPE = "[ERROR] 숫자만 입력 가능합니다.";

    public int askPurchaseAmount() {
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
