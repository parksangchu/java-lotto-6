package lotto.global;

public enum Error {
    INVALID_TYPE("숫자만 입력 가능합니다.");
    private static final String ERROR = "[ERROR] ";
    private final String message;

    Error(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }
}
