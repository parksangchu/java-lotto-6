package lotto.domain;

import static lotto.global.Error.DUPLICATED;
import static lotto.global.Error.INVALID_SIZE;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_SIZE.getMessage());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream()
                .distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> new Number(number));
    }
    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
