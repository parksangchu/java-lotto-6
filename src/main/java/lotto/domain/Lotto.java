package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBERS_SIZE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < MIN_RANGE || number > MAX_RANGE)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_OUT_OF_INT_RANGE.getMessage());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
