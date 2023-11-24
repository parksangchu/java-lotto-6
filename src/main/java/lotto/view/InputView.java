package lotto.view;

import static lotto.global.Error.INVALID_TYPE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";


    public static int askPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        String input = Console.readLine();
        validateType(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> askWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
        String input = Console.readLine();
        return Arrays.stream(input.trim()
                        .split(","))
                .peek(number -> validateType(number))
                .mapToInt(number -> Integer.parseInt(number))
                .boxed()
                .collect(Collectors.toList());
    }


    private static void validateType(String input) {
        if (!input.chars()
                .allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INVALID_TYPE.getMessage());
        }
    }
}
