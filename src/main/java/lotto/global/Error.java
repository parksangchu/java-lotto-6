package lotto.global;

public enum Error {
    INVALID_SIZE("로또는 6개의 번호로 구성되어야 합니다."),
    DUPLICATED("로또 번호는 서로 중복될 수 없습니다."),
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
