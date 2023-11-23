package lotto.global;

public enum Error {
    INVALID_TYPE("숫자만 입력 가능합니다."),
    INVALID_UNIT("1,000원 단위로만 입력 가능합니다."),
    INVALID_AMOUNT_RANGE("구매금액은 1,000원 이상 100,000원 이하여야 합니다.");
    private static final String ERROR = "[ERROR] ";
    private final String message;

    Error(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }
}
