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
        numbers.forEach(Number::new);
    }

    // TODO: 추가 기능 구현
    public WinningResult checkWinningResult(WinningLotto winningLotto) {
        int winningCount = checkWinningCount(winningLotto);
        boolean matchingBonusNumber = hasBonusNumber(winningLotto);
        return new WinningResult(winningCount, matchingBonusNumber);
    }

    private int checkWinningCount(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(number -> winningLotto
                        .getWinningNumbers()
                        .contains(number))
                .count();
    }

    private boolean hasBonusNumber(WinningLotto winningLotto) {
        return numbers.contains(winningLotto.getBonusNumber());
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
