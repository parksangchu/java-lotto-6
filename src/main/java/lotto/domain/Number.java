package lotto.domain;

import static lotto.global.Error.INVALID_NUMBER_RANGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Number {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int COUNT = 6;
    private final int number;

    public Number(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_VALUE, MAX_VALUE, COUNT);
    }
}
