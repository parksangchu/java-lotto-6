package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constants.ExceptionMessage.HAS_LETTER;
import static lotto.constants.ExceptionMessage.IS_NOT_THOUSAND_UNIT;
import static lotto.view.constants.Notice.ASK_BONUS_NUMBER;
import static lotto.view.constants.Notice.ASK_PURCHASE_PRICE;
import static lotto.view.constants.Notice.ASK_WINNER_NUMBERS;

public class InputView {
    public static int askPurchaseAmount() {
        System.out.println(ASK_PURCHASE_PRICE.getMessage());
        String input = readLine();
        validateType(input);
        int won = Integer.parseInt(input);
        validateThousandUnit(won);
        return won;
    }

    public static String askWinnerNumbers() {
        System.out.println();
        System.out.println(ASK_WINNER_NUMBERS.getMessage());
        return readLine();
    }

    public static String askBonusNumber() {
        System.out.println();
        System.out.println(ASK_BONUS_NUMBER.getMessage());
        return readLine();
    }

    private static void validateType(String input) {
        if (hasLetter(input)) {
            throw new IllegalArgumentException(HAS_LETTER.getMessage());
        }
    }

    private static boolean hasLetter(String input) {
        return input.chars()
                .anyMatch(Character::isLetter);
    }

    private static void validateThousandUnit(int won) {
        if (won % 1000 != 0) {
            throw new IllegalArgumentException(IS_NOT_THOUSAND_UNIT.getMessage());
        }
    }
}
