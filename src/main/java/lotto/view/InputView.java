package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.ErrorMessage;
import lotto.util.Util;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String NUMBER_REGEX = "^[0-9]+$";

    public static int readPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
        String input = Console.readLine();
        List<String> separatedInput = Util.splitByComma(input);
        return separatedInput.stream()
                .peek(InputView::validateNumber)
                .mapToInt(number -> Integer.parseInt(number))
                .boxed()
                .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
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
